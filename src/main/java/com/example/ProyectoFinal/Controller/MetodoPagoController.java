package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.MetodoPago;
import com.example.ProyectoFinal.Service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodos-pago")
@CrossOrigin(origins = "*")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @PostMapping
    public MetodoPago crear(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.crearMetodoPago(metodoPago);
    }

    @GetMapping
    public List<MetodoPago> listarTodos() {
        return metodoPagoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<MetodoPago> obtenerPorId(@PathVariable Long id) {
        return metodoPagoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public MetodoPago actualizar(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        return metodoPagoService.actualizarMetodoPago(id, metodoPago);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = metodoPagoService.eliminarMetodoPago(id);
        return eliminado ? "Método de pago eliminado correctamente." : "Método de pago no encontrado.";
    }
}
