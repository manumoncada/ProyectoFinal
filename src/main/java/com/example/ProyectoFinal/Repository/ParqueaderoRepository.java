package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Model.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueaderoRepository extends JpaRepository<Parqueadero, String> {
}
