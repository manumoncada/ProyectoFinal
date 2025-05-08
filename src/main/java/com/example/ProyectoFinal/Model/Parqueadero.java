package com.example.ProyectoFinal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Parqueadero {

    @Id
    private String placa;

    @ManyToOne
    @JoinColumn(name = "id_huesped")
    private Huesped huesped;

    public Parqueadero() {
    }

    public Parqueadero(String placa, Huesped huesped) {
        this.placa = placa;
        this.huesped = huesped;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
}