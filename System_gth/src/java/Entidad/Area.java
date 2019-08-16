package Entidad;

import java.util.Date;

public class Area {

    private int Area_id;
    private String Nombre;
    private int Posicion;
    private int Estado;
    private Date Fecha_creacion;

    public int getArea_id() {
        return Area_id;
    }

    public void setArea_id(int Area_id) {
        this.Area_id = Area_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPosicion() {
        return Posicion;
    }

    public void setPosicion(int Posicion) {
        this.Posicion = Posicion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public Date getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(Date Fecha_creacion) {
        this.Fecha_creacion = Fecha_creacion;
    }
    
    
}
