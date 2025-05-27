package Dto;

import java.time.LocalDate;

public class ReservaConCodigoRequest {
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String codigoHabitacion;
    private Long idHuesped;
    private String estado;

    // Getters y setters
    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getCodigoHabitacion() { return codigoHabitacion; }
    public void setCodigoHabitacion(String codigoHabitacion) { this.codigoHabitacion = codigoHabitacion; }

    public Long getIdHuesped() { return idHuesped; }
    public void setIdHuesped(Long idHuesped) { this.idHuesped = idHuesped; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
