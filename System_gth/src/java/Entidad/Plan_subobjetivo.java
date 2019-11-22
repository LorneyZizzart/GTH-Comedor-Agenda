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
public class Plan_subobjetivo {

    private int Plan_subobjetivo_id;
    private int Plan_objetivo_id;
    private String Titulo;
    private String Descripcion;
    private int Empleado_id;
    private String Fecha_creacion;
    private String Fecha_actualizacion;
    private int Empleado_actualiza;
    private int Estado;

    private String Nombre_creador;
    private String Nombre_actualizador;

    public String getNombre_creador() {
        return Nombre_creador;
    }

    public void setNombre_creador(String Nombre_creador) {
        this.Nombre_creador = Nombre_creador;
    }

    public String getNombre_actualizador() {
        return Nombre_actualizador;
    }

    public void setNombre_actualizador(String Nombre_actualizador) {
        this.Nombre_actualizador = Nombre_actualizador;
    }
    
    

    public int getPlan_subobjetivo_id() {
        return Plan_subobjetivo_id;
    }

    public void setPlan_subobjetivo_id(int Plan_subobjetivo_id) {
        this.Plan_subobjetivo_id = Plan_subobjetivo_id;
    }

    public int getPlan_objetivo_id() {
        return Plan_objetivo_id;
    }

    public void setPlan_objetivo_id(int Plan_objetivo_id) {
        this.Plan_objetivo_id = Plan_objetivo_id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getEmpleado_id() {
        return Empleado_id;
    }

    public void setEmpleado_id(int Empleado_id) {
        this.Empleado_id = Empleado_id;
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

    public int getEmpleado_actualiza() {
        return Empleado_actualiza;
    }

    public void setEmpleado_actualiza(int Empleado_actualiza) {
        this.Empleado_actualiza = Empleado_actualiza;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

   

}
