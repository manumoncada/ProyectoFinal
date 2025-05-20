package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.Parqueadero;
import com.example.ProyectoFinal.Repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParqueaderoService {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    public Parqueadero crearParqueadero(Parqueadero parqueadero) {
        return parqueaderoRepository.save(parqueadero);
    }

    public List<Parqueadero> obtenerTodos() {
        return parqueaderoRepository.findAll();
    }

    public Optional<Parqueadero> obtenerPorPlaca(String placa) {
        return parqueaderoRepository.findById(placa);
    }

    public Parqueadero actualizarParqueadero(String placa, Parqueadero parqueaderoActualizado) {
        return parqueaderoRepository.findById(placa).map(parqueadero -> {
            parqueadero.setHuesped(parqueaderoActualizado.getHuesped());
            return parqueaderoRepository.save(parqueadero);
        }).orElse(null);
    }

    public boolean eliminarParqueadero(String placa) {
        if (parqueaderoRepository.existsById(placa)) {
            parqueaderoRepository.deleteById(placa);
            return true;
        }
        return false;
    }
}
