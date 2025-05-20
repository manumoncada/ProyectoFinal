package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.Pago;
import com.example.ProyectoFinal.Service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public Pago crear(@RequestBody Pago pago) {
        return pagoService.crearPago(pago);
    }

    @GetMapping
    public List<Pago> listarTodos() {
        return pagoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pago> obtenerPorId(@PathVariable Long id) {
        return pagoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Pago actualizar(@PathVariable Long id, @RequestBody Pago pago) {
        return pagoService.actualizarPago(id, pago);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = pagoService.eliminarPago(id);
        return eliminado ? "Pago eliminado correctamente." : "Pago no encontrado.";
    }
}
