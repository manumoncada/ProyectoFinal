package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Pago;
import com.example.ProyectoFinal.Service.PagoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("/{id}")
    public Pago getById(@PathVariable Long id) {
        return pagoService.getById(id);
    }

    @PostMapping
    public Pago save(@RequestBody Pago pago) {
        return pagoService.save(pago);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pagoService.delete(id);
    }
}
