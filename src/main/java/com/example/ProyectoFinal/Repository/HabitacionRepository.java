package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    @Query(value = """
        SELECT * FROM habitacion h
        WHERE h.estado = 'Disponible' AND h.id NOT IN (
            SELECT r.id_habitacion FROM reserva r
            WHERE r.fecha_ingreso <= :fecha AND r.fecha_salida >= :fecha
        )
        """, nativeQuery = true)
    List<Habitacion> findHabitacionesDisponiblesPorFecha(LocalDate fecha);
}
