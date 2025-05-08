package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.MetodoPago;
import com.example.ProyectoFinal.Repository.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public List<MetodoPago> getAll() {
        return metodoPagoRepository.findAll();
    }

    public Optional<MetodoPago> getById(Long id) {
        return metodoPagoRepository.findById(id);
    }

    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public void delete(Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
