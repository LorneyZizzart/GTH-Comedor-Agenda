/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Roberto
 */
public class Evento_Actividad {

    private int Evento_Actividad_id;
    private String Nombre_actividad;
    private String Fecha_creacion;
    private String Fecha_actualizacion;
    private int Empleado_id;
    private String Descripcion;
    private String Fecha_inicio_actividad;
    private String Fecha_fin_actividad;
    private int Estado;
    private int Evento_id;

    private String Hora_inicio_actividad;
    private String Hora_fin_actividad;

    public String getHora_fin_actividad() {
        return Hora_fin_actividad;
    }

    public void setHora_fin_actividad(String Hora_fin_actividad) {
        this.Hora_fin_actividad = Hora_fin_actividad;
    }

    public String getHora_inicio_actividad() {
        return Hora_inicio_actividad;
    }

    public void setHora_inicio_actividad(String Hora_inicio_actividad) {
        this.Hora_inicio_actividad = Hora_inicio_actividad;
    }

    public int getEvento_Actividad_id() {
        return Evento_Actividad_id;
    }

    public void setEvento_Actividad_id(int Evento_Actividad_id) {
        this.Evento_Actividad_id = Evento_Actividad_id;
    }

    public String getNombre_actividad() {
        return Nombre_actividad;
    }

    public void setNombre_actividad(String Nombre_actividad) {
        this.Nombre_actividad = Nombre_actividad;
    }

    public String getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(String Fecha_creacion) {
        this.Fecha_creacion = Fecha_creacion;
    }

    public String getFecha_actualizacion() {
        return Fecha_actualizacion;
    }

    public void setFecha_actualizacion(String Fecha_actualizacion) {
        this.Fecha_actualizacion = Fecha_actualizacion;
    }

    public int getEmpleado_id() {
        return Empleado_id;
    }

    public void setEmpleado_id(int Empleado_id) {
        this.Empleado_id = Empleado_id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_inicio_actividad() {
        return Fecha_inicio_actividad;
    }

    public void setFecha_inicio_actividad(String Fecha_inicio_actividad) {
        this.Fecha_inicio_actividad = Fecha_inicio_actividad;
    }

    public String getFecha_fin_actividad() {
        return Fecha_fin_actividad;
    }

    public void setFecha_fin_actividad(String Fecha_fin_actividad) {
        this.Fecha_fin_actividad = Fecha_fin_actividad;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getEvento_id() {
        return Evento_id;
    }

    public void setEvento_id(int Evento_id) {
        this.Evento_id = Evento_id;
    }

}
