package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Pago;
import com.example.ProyectoFinal.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> obtenerPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago actualizarPago(Long id, Pago pagoActualizado) {
        return pagoRepository.findById(id).map(pago -> {
            pago.setFechaPago(pagoActualizado.getFechaPago());
            pago.setMonto(pagoActualizado.getMonto());
            pago.setMetodoPago(pagoActualizado.getMetodoPago());
            pago.setReserva(pagoActualizado.getReserva());
            return pagoRepository.save(pago);
        }).orElse(null);
    }

    public boolean eliminarPago(Long id) {
        if (pagoRepository.existsById(id)) {
            pagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
