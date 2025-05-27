package com.example.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
public class Parqueadero {

    @Id
    private String placa;

    @ManyToOne
    @JoinColumn(name = "codigo_habitacion", referencedColumnName = "codigo")
    private Habitacion habitacion;

    public Parqueadero() {
    }

    public Parqueadero(String placa, Habitacion habitacion) {
        this.placa = placa;
        this.habitacion = habitacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}