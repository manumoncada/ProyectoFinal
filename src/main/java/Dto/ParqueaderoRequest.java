package Dto;

public class ParqueaderoRequest {

    private String placa;
    private String codigoHabitacion;

    public ParqueaderoRequest() {}

    public ParqueaderoRequest(String placa, String codigoHabitacion) {
        this.placa = placa;
        this.codigoHabitacion = codigoHabitacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }
}