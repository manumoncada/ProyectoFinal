package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Reserva;
import com.example.ProyectoFinal.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

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
}
