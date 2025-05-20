package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Habitacion;
import com.example.ProyectoFinal.Repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public Habitacion crearHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public List<Habitacion> obtenerTodas() {
        return habitacionRepository.findAll();
    }

    public Optional<Habitacion> obtenerPorId(Long id) {
        return habitacionRepository.findById(id);
    }

    public Habitacion actualizarHabitacion(Long id, Habitacion habitacionActualizada) {
        return habitacionRepository.findById(id).map(habitacion -> {
            habitacion.setCantidadCamas(habitacionActualizada.getCantidadCamas());
            habitacion.setEstado(habitacionActualizada.getEstado());
            return habitacionRepository.save(habitacion);
        }).orElse(null);
    }

    public boolean eliminarHabitacion(Long id) {
        if (habitacionRepository.existsById(id)) {
            habitacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
