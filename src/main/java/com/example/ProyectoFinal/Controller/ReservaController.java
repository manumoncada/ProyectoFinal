package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Reserva;
import com.example.ProyectoFinal.Service.ReservaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/{id}")
    public Reserva getById(@PathVariable Long id) {
        return reservaService.getById(id);
    }

    @PostMapping
    public Reserva save(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservaService.delete(id);
    }
}
