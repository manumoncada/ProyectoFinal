package com.example.ProyectoFinal.Controller;

import Dto.ParqueaderoRequest;
import com.example.ProyectoFinal.Model.Parqueadero;
import com.example.ProyectoFinal.Service.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parqueaderos")
@CrossOrigin(origins = "*")
public class ParqueaderoController {

    @Autowired
    private ParqueaderoService parqueaderoService;

    @PostMapping
    public Parqueadero crear(@RequestBody ParqueaderoRequest request) {
        return parqueaderoService.crearParqueadero(request);
    }

    @GetMapping
    public List<Parqueadero> listarTodos() {
        return parqueaderoService.obtenerTodos();
    }

    @GetMapping("/{placa}")
    public Optional<Parqueadero> obtenerPorPlaca(@PathVariable String placa) {
        return parqueaderoService.obtenerPorPlaca(placa);
    }

    @PutMapping("/{placa}")
    public Parqueadero actualizar(@PathVariable String placa, @RequestBody ParqueaderoRequest request) {
        return parqueaderoService.actualizarParqueadero(placa, request);
    }

    @DeleteMapping("/{placa}")
    public String eliminar(@PathVariable String placa) {
        boolean eliminado = parqueaderoService.eliminarParqueadero(placa);
        return eliminado ? "Parqueadero eliminado correctamente." : "Parqueadero no encontrado.";
    }
}
