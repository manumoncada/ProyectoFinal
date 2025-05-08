package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Parqueadero;
import com.example.ProyectoFinal.Service.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parqueaderos")
public class ParqueaderoController {

    @Autowired
    private ParqueaderoService parqueaderoService;

    @GetMapping
    public List<Parqueadero> listar() {
        return parqueaderoService.listar();
    }

    @PostMapping
    public Parqueadero guardar(@RequestBody Parqueadero parqueadero) {
        return parqueaderoService.guardar(parqueadero);
    }

    @DeleteMapping("/{placa}")
    public void eliminar(@PathVariable String placa) {
        parqueaderoService.eliminar(placa);
    }
}
