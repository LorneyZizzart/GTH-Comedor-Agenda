/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.sql.Date;

/**
 *
 * @author pc
 */
public class C_TipoComida {
    
    private int IdTipoComida;
    private String NombreComida;
    private Double Costo;
    private int Estado;
    private String Hora;
    private String Detalle;
    private Date FechaRegistro;
    private Date FechaActualizacion;
    private String Color;
    private String HorasAnticipacion;
    
    public String getHorasAnticipacion(){
        return HorasAnticipacion;
    }
    
    public void setHorasAnticipacion(String horasAnticipacion){
        this.HorasAnticipacion = horasAnticipacion;
    }
    
    public String getColor(){
        return Color;
    }
    
    public void setColor(String color){
        this.Color = color;
    }
    
    public int getIdTipoComida(){
        return IdTipoComida;
    }
    
    public void setIdTipoComida(int idTipoComida){
        this.IdTipoComida = idTipoComida;
    }
    
    public String getNombreComida(){
        return NombreComida;
    }
    
    public void setNombreComida(String nombreComida){
        this.NombreComida = nombreComida;
    }
    
    public Double getCosto(){
        return Costo;
    }
    
    public void setCosto(double costo){
        this.Costo = costo;
    }
    
    public int getEstado (){
        return Estado;
    }
    
    public void setEstado(int estado){
        this.Estado = estado;
    }
    
    public String getHora(){
        return Hora;
    }
    
    public void setHora(String hora){
        this.Hora = hora;
    }
    
    public String getDetalle(){
        return Detalle;
    }
    
    public void setDetalle(String detalle){
        this.Detalle = detalle;
    }
    
    public Date getFechaRegistro(){
        return FechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro){
        this.FechaRegistro = fechaRegistro;
    }
    
    public Date getFechaActualizacion(){
        return FechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActulizacion){
        this.FechaActualizacion = fechaActulizacion;
    }
    
}
