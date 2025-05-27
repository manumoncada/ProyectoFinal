package com.example.ProyectoFinal.Controller;

import Dto.ReservaConCodigoRequest;
import com.example.ProyectoFinal.Model.Reserva;
import com.example.ProyectoFinal.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public Reserva crear(@RequestBody Reserva reserva) {
        return reservaService.crearReserva(reserva);
    }

    @GetMapping
    public List<Reserva> listarTodas() {
        return reservaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> obtenerPorId(@PathVariable Long id) {
        return reservaService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Reserva actualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.actualizarReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = reservaService.eliminarReserva(id);
        return eliminado ? "Reserva eliminada correctamente." : "Reserva no encontrada.";
    }
    @PostMapping("/con-codigo")
    public Reserva crearReservaConCodigo(@RequestBody ReservaConCodigoRequest request) {
        return reservaService.crearReservaConCodigo(request);
    }
}
