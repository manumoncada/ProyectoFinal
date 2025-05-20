package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Huesped;
import com.example.ProyectoFinal.Repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuespedService {

    @Autowired
    private HuespedRepository huespedRepository;

    public Huesped crearHuesped(Huesped huesped) {
        return huespedRepository.save(huesped);
    }

    public List<Huesped> obtenerTodos() {
        return huespedRepository.findAll();
    }

    public Optional<Huesped> obtenerPorId(Long id) {
        return huespedRepository.findById(id);
    }

    public Huesped actualizarHuesped(Long id, Huesped huespedActualizado) {
        return huespedRepository.findById(id).map(huesped -> {
            huesped.setPrimerNombre(huespedActualizado.getPrimerNombre());
            huesped.setSegundoNombre(huespedActualizado.getSegundoNombre());
            huesped.setPrimerApellido(huespedActualizado.getPrimerApellido());
            huesped.setSegundoApellido(huespedActualizado.getSegundoApellido());
            huesped.setTelefono(huespedActualizado.getTelefono());
            return huespedRepository.save(huesped);
        }).orElse(null);
    }

    public boolean eliminarHuesped(Long id) {
        if (huespedRepository.existsById(id)) {
            huespedRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
