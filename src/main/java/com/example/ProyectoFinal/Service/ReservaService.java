package com.example.ProyectoFinal.Service;

import Dto.ReservaConCodigoRequest;
import com.example.ProyectoFinal.Model.Habitacion;
import com.example.ProyectoFinal.Model.Huesped;
import com.example.ProyectoFinal.Model.Reserva;
import com.example.ProyectoFinal.Repository.HabitacionRepository;
import com.example.ProyectoFinal.Repository.HuespedRepository;
import com.example.ProyectoFinal.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private HuespedRepository huespedRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva actualizarReserva(Long id, Reserva reservaActualizada) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setFechaIngreso(reservaActualizada.getFechaIngreso());
            reserva.setFechaSalida(reservaActualizada.getFechaSalida());
            reserva.setHuesped(reservaActualizada.getHuesped());
            reserva.setHabitacion(reservaActualizada.getHabitacion());
            reserva.setEstado(reservaActualizada.getEstado());
            return reservaRepository.save(reserva);
        }).orElse(null);
    }

    public boolean eliminarReserva(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Reserva crearReservaConCodigo(ReservaConCodigoRequest request) {
        Habitacion habitacion = habitacionRepository.findByCodigo(request.getCodigoHabitacion())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada con código: " + request.getCodigoHabitacion()));

        Huesped huesped = huespedRepository.findById(request.getIdHuesped())
                .orElseThrow(() -> new RuntimeException("Huésped no encontrado con ID: " + request.getIdHuesped()));

        // Validar que la habitación no esté ocupada
        if ("ocupado".equalsIgnoreCase(habitacion.getEstado())) {
            throw new RuntimeException("La habitación ya está ocupada.");
        }
        // Marcar como ocupada
        habitacion.setEstado("Reservada");
        habitacionRepository.save(habitacion);

        Reserva reserva = new Reserva();
        reserva.setFechaIngreso(request.getFechaIngreso());
        reserva.setFechaSalida(request.getFechaSalida());
        reserva.setHabitacion(habitacion);
        reserva.setHuesped(huesped);
        reserva.setEstado(request.getEstado());

        return reservaRepository.save(reserva);
    }

    public void eliminarReservaPorId(Long idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + idReserva));

        Habitacion habitacion = reserva.getHabitacion();

        // Liberar la habitación
        habitacion.setEstado("disponible");
        habitacionRepository.save(habitacion);

        // Eliminar la reserva
        reservaRepository.deleteById(idReserva);
    }

}