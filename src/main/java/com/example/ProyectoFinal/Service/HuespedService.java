package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Huesped;
import com.example.ProyectoFinal.Repository.HuespedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuespedService {

    private final HuespedRepository huespedRepository;

    public HuespedService(HuespedRepository huespedRepository) {
        this.huespedRepository = huespedRepository;
    }

    public List<Huesped> getAll() {
        return huespedRepository.findAll();
    }

    public Optional<Huesped> getById(Long id) {
        return huespedRepository.findById(id);
    }

    public Huesped save(Huesped huesped) {
        return huespedRepository.save(huesped);
    }

    public void delete(Long id) {
        huespedRepository.deleteById(id);
    }
}
