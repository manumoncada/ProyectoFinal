package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.MetodoPago;
import com.example.ProyectoFinal.Service.MetodoPagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodospago")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public List<MetodoPago> getAll() {
        return metodoPagoService.getAll();
    }

    @GetMapping("/{id}")
    public MetodoPago getById(@PathVariable Long id) {
        return metodoPagoService.getById(id).orElse(null);
    }

    @PostMapping
    public MetodoPago save(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.save(metodoPago);
    }

    @PutMapping("/{id}")
    public MetodoPago update(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        metodoPago.setId(id);
        return metodoPagoService.save(metodoPago);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        metodoPagoService.delete(id);
    }
}
