package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    boolean existsByCodigo(String codigo); // ✅ Para evitar códigos duplicados
}
