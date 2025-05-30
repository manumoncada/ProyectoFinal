package com.example.ProyectoFinal.Controller;

import Dto.ReservaConCodigoRequest;
import com.example.ProyectoFinal.Model.Habitacion;
import com.example.ProyectoFinal.Model.Reserva;
import com.example.ProyectoFinal.Service.HabitacionService;
import com.example.ProyectoFinal.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habitaciones")
@CrossOrigin(origins = "*")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;
    @Autowired
    private ReservaService reservaService;


    @PostMapping
    public Habitacion crear(@RequestBody Habitacion habitacion) {
        return habitacionService.crearHabitacion(habitacion);
    }

    @GetMapping
    public List<Habitacion> listarTodas() {
        return habitacionService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Habitacion> obtenerPorId(@PathVariable Long id) {
        return habitacionService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Habitacion actualizar(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        return habitacionService.actualizarHabitacion(id, habitacion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = habitacionService.eliminarHabitacion(id);
        return eliminado ? "Habitación eliminada correctamente." : "Habitación no encontrada.";
    }
    @PostMapping("/con-codigo")
    public Reserva crearReservaConCodigo(@RequestBody ReservaConCodigoRequest request) {
        return reservaService.crearReservaConCodigo(request);
    }
}
