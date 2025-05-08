package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {
}
