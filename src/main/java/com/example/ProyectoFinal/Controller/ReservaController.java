package com.example.ProyectoFinal.Controller;

import Dto.ReservaConCodigoRequest;
import com.example.ProyectoFinal.Model.Reserva;
import com.example.ProyectoFinal.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> eliminarReserva(@PathVariable Long id) {
        try {
            reservaService.eliminarReservaPorId(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/con-codigo")
    public Reserva crearReservaConCodigo(@RequestBody ReservaConCodigoRequest request) {
        return reservaService.crearReservaConCodigo(request);
    }
}
