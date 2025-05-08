package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Parqueadero;
import com.example.ProyectoFinal.Repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParqueaderoService {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    public List<Parqueadero> listar() {
        return parqueaderoRepository.findAll();
    }

    public Parqueadero guardar(Parqueadero parqueadero) {
        return parqueaderoRepository.save(parqueadero);
    }

    public void eliminar(String placa) {
        parqueaderoRepository.deleteById(placa);
    }
}
