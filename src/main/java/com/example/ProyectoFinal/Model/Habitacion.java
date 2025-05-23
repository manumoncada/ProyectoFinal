package com.example.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    private int cantidadCamas;

    private String estado;

    public Habitacion() {
    }

    public Habitacion(Long id, String codigo, int cantidadCamas, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.cantidadCamas = cantidadCamas;
        this.estado = estado;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
