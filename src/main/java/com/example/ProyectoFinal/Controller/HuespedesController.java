package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Huesped;
import com.example.ProyectoFinal.Service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/huespedes")
@CrossOrigin(origins = "*")
public class HuespedesController {

    @Autowired
    private HuespedService huespedService;

    @PostMapping
    public Huesped crear(@RequestBody Huesped huesped) {
        return huespedService.crearHuesped(huesped);
    }

    @GetMapping
    public List<Huesped> listarTodos() {
        return huespedService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Huesped> obtenerPorId(@PathVariable Long id) {
        return huespedService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Huesped actualizar(@PathVariable Long id, @RequestBody Huesped huesped) {
        return huespedService.actualizarHuesped(id, huesped);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = huespedService.eliminarHuesped(id);
        return eliminado ? "Huésped eliminado correctamente." : "Huésped no encontrado.";
    }
}
