package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Habitacion;
import com.example.ProyectoFinal.Repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<Habitacion> getDisponiblesPorFecha(LocalDate fecha) {
        return habitacionRepository.findHabitacionesDisponiblesPorFecha(fecha);
    }

    public List<Habitacion> getAll() {
        return habitacionRepository.findAll();
    }

    public Habitacion getById(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    public Habitacion save(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public void delete(Long id) {
        habitacionRepository.deleteById(id);
    }
}
