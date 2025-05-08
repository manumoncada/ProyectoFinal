package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Huesped;
import com.example.ProyectoFinal.Service.HuespedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/huespedes")
public class HuespedesController {

    private final HuespedService huespedesService;

    public HuespedesController(HuespedService huespedService) {
        this.huespedesService = huespedService;
    }

    @GetMapping
    public List<Huesped> getAll() {
        return huespedesService.getAll();
    }

    @GetMapping("/{id}")
    public Huesped getById(@PathVariable Long id) {
        return huespedesService.getById(id).orElse(null);
    }

    @PostMapping
    public Huesped save(@RequestBody Huesped huesped) {
        return huespedesService.save(huesped);
    }

    @PutMapping("/{id}")
    public Huesped update(@PathVariable Long id, @RequestBody Huesped huesped) {
        huesped.setId(id);
        return huespedesService.save(huesped);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        huespedesService.delete(id);
    }
}
