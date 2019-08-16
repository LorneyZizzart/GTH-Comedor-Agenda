/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_Tarea extends A_EstadoTarea{
    
    private int IdTarea;
    private String Titulo;
    private String Descripcion;
    private String Color;
    private String FechaInicio;
    private String FechaFinal;
    private String AuxFechaFinal;
    private int EstadoTarea;
    private Date FechaRegistroTarea;
    private Date FechaActualizacionTarea;
    private int IdUserCrea;
    private int IdEmpleado;
    private String NombreEmpleado;
    private int Telefeno;
    private String Foto;
    private String HoraInicio;
    private String HoraFinal;
    private List<Empleado> Empleados;
    private int IdEmpleadoTarea;
    
    public void setIdEmpleadoTarea(int idEmpleadoTarea){
        this.IdEmpleadoTarea = idEmpleadoTarea;
    }
    
    public int getIdEmpleadoTarea(){
        return IdEmpleadoTarea;
    }
    
    public List<Empleado> getEmpleados() {
        return Empleados;
    }

    public void setEmpleados(List<Empleado> Empleados) {
        this.Empleados = Empleados;
    }
    
    public void setAuxFechaFinal(String auxFechaFinal){
        this.AuxFechaFinal = auxFechaFinal;
    }
    
    public String getAuxFechaFinal(){
        return AuxFechaFinal;
    }
    
    public void setHoraFinal(String horaFinal){
     this.HoraFinal = horaFinal;   
    }            
    
    public String getHoraFinal(){
        return HoraFinal;
    }
    
    public void setHoraInicio(String horaInicio){
        this.HoraInicio = horaInicio;
    }
    
    public String getHoraInicio(){
        return HoraInicio;
    }
    
    public void setFoto(String foto){
        this.Foto = foto;
    }
    
    public String getFoto(){
        return Foto;
    }
    
    public void setTelefono(int telefono){
        this.Telefeno = telefono;
    }
    
    public int getTelefono(){
        return Telefeno;
    } 
    
    public void setNombreEmpleado(String nombreEmpleado){
        this.NombreEmpleado = nombreEmpleado;
    }
    
    public String getNombreEmpleado(){
        return NombreEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado){
        this.IdEmpleado = idEmpleado;
    }
    
    public int getIdEmpleado(){
        return IdEmpleado;
    }
    
    public void setIdUserCrea(int idUserCrea){
        this.IdUserCrea = idUserCrea;
    }
    
    public int getIdUserCrea(){
        return IdUserCrea;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion){
        this.FechaActualizacionTarea = fechaActualizacion;
    }
    
    public Date getFechaActualizacion(){
        return FechaActualizacionTarea;
    }
    
    public void setFechaRegistroTarea(Date fechaRegistro){
        this.FechaRegistroTarea = fechaRegistro;
    }
    
    public Date getFechaRegistroTarea(){
        return FechaRegistroTarea;
    }
    
    public void setEstadoTarea(int estadoTarea){
        this.EstadoTarea = estadoTarea;
    }
    
    public int getEstadoTarea(){
        return EstadoTarea;
    }
    
    public void setFechaFinal(String fechaFinal){
        this.FechaFinal = fechaFinal; 
    }
    
    public String getFechaFinal(){
        return FechaFinal;
    }
    
    public void setFechaInicio(String fechaInicio){
        this.FechaInicio = fechaInicio;
    }
    
    public String getFechaInicio(){
        return FechaInicio;
    }
    
    public void setColor(String color){
        this.Color = color;
    }
    
    public String getColor(){
        return Color;
    }
    
    public void setDescripcion(String descripcion){
        this.Descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return Descripcion;
    }
    
    public void setTitulo(String titulo){
        this.Titulo = titulo;
    }
    
    public String getTitulo(){
        return Titulo;
    }
    
    public void setIdTarea(int idTarea){
        this.IdTarea = idTarea;
    }
    
    public int getIdTarea(){
        return IdTarea;
    }
    
}
