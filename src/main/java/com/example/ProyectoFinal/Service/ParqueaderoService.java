package com.example.ProyectoFinal.Service;

import Dto.ParqueaderoRequest;
import com.example.ProyectoFinal.Model.Habitacion;
import com.example.ProyectoFinal.Model.Parqueadero;
import com.example.ProyectoFinal.Repository.HabitacionRepository;
import com.example.ProyectoFinal.Repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParqueaderoService {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    public Parqueadero crearParqueadero(ParqueaderoRequest request) {
        Habitacion habitacion = habitacionRepository.findByCodigo(request.getCodigoHabitacion())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada con código: " + request.getCodigoHabitacion()));
        Parqueadero parqueadero = new Parqueadero(request.getPlaca(), habitacion);
        return parqueaderoRepository.save(parqueadero);
    }

    public List<Parqueadero> obtenerTodos() {
        return parqueaderoRepository.findAll();
    }

    public Optional<Parqueadero> obtenerPorPlaca(String placa) {
        return parqueaderoRepository.findById(placa);
    }

    public Parqueadero actualizarParqueadero(String placa, ParqueaderoRequest request) {
        return parqueaderoRepository.findById(placa).map(parqueadero -> {
            Habitacion habitacion = habitacionRepository.findByCodigo(request.getCodigoHabitacion())
                    .orElseThrow(() -> new RuntimeException("Habitación no encontrada con código: " + request.getCodigoHabitacion()));
            parqueadero.setHabitacion(habitacion);
            return parqueaderoRepository.save(parqueadero);
        }).orElse(null);
    }

    public boolean eliminarParqueadero(String placa) {
        if (parqueaderoRepository.existsById(placa)) {
            parqueaderoRepository.deleteById(placa);
            return true;
        }
        return false;
    }
}

