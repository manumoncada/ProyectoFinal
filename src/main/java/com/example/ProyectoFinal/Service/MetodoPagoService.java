package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.MetodoPago;
import com.example.ProyectoFinal.Repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public MetodoPago crearMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public List<MetodoPago> obtenerTodos() {
        return metodoPagoRepository.findAll();
    }

    public Optional<MetodoPago> obtenerPorId(Long id) {
        return metodoPagoRepository.findById(id);
    }

    public MetodoPago actualizarMetodoPago(Long id, MetodoPago metodoPagoActualizado) {
        return metodoPagoRepository.findById(id).map(metodoPago -> {
            metodoPago.setNombre(metodoPagoActualizado.getNombre());
            return metodoPagoRepository.save(metodoPago);
        }).orElse(null);
    }

    public boolean eliminarMetodoPago(Long id) {
        if (metodoPagoRepository.existsById(id)) {
            metodoPagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
