package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Habitacion;
import com.example.ProyectoFinal.Service.HabitacionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping("/disponibles")
    public List<Habitacion> getDisponibles(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return habitacionService.getDisponiblesPorFecha(fecha);
    }

    @GetMapping
    public List<Habitacion> getAll() {
        return habitacionService.getAll();
    }

    @GetMapping("/{id}")
    public Habitacion getById(@PathVariable Long id) {
        return habitacionService.getById(id);
    }

    @PostMapping
    public Habitacion save(@RequestBody Habitacion habitacion) {
        return habitacionService.save(habitacion);
    }

    @PutMapping("/{id}")
    public Habitacion update(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        habitacion.setId(id);
        return habitacionService.save(habitacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        habitacionService.delete(id);
    }
}
