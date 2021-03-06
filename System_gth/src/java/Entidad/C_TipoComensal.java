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
public class C_TipoComensal extends C_Empleado_Reserva{
    
    private int TipoComensal_id;
    private String NombreComensal;
    private int Estado;
    private Date FechaRegistro;
    private int UsuarioCrea;
    private Date FechaActualiza;
    private int MinimoDias;
    private String Descuento;
    private int DiasAnticipacion;
    private Double DescuentoDesayuno;
    private Double DescuentoAlmuerzo;
    private Double DescuentoCena;
    
    
    
    public Double getDescuentoCena(){
        return DescuentoCena;
    }
    
    public void setDescuentoCena(double descuentoCena){
        this.DescuentoCena = descuentoCena;
    }
    
    public Double getDescuentoAlmuerzo(){
        return DescuentoAlmuerzo;
    }
    
    public void setDescuentoAlmuerzo(double descuentoAlmuerzo){
        this.DescuentoAlmuerzo = descuentoAlmuerzo;
    }
    
    public Double getDescuentoDesayuno(){
        return DescuentoDesayuno;
    }
    
    public void setDescuentoDesayuno(double descuentoDesayuno){
        this.DescuentoDesayuno = descuentoDesayuno;
    }
    
    public int getDiasAnticipacion(){
        return DiasAnticipacion;
    }
    
    public void setDiasAnticipacion(int DiasAnticipacion){
        this.DiasAnticipacion = DiasAnticipacion;
    }
    
    public String getDescuento(){
        return Descuento;
    }
    
    public void setDescuento(String descuento){
        this.Descuento = descuento;
    }
        
    public int getMinimoDias(){
        return MinimoDias;
    }
    
    public  void setMinimoDias(int minimoDias){
        this.MinimoDias = minimoDias;
    }
    
    public int getTipoComensal_id(){
        return TipoComensal_id;
    }
    
    public void setTipoComensal_id(int tipoComensal_id){
        this.TipoComensal_id = tipoComensal_id;
    }
    
    public String getNombreComensal(){
        return NombreComensal;
    }
    
    public void setNombreComensal(String nombreComensal){
        this.NombreComensal = nombreComensal;
    }
    
    public int getEstado(){
        return Estado;
    }
    
    public void setEstado(int estado){
        this.Estado = estado;
    }
    
    public Date getFechaRegistro(){
        return FechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro){
        this.FechaRegistro = fechaRegistro;
    }
    
    public int getUsuarioCrea(){
        return UsuarioCrea;
    }
    
    public void setUsuarioCrea(int usuarioCrea){
        this.UsuarioCrea = usuarioCrea;
    }
    
    public Date getFechaActualizacion(){
        return FechaActualiza;
    }
    
    public void setFechaActualiza(Date fechaActualiza){
        this.FechaActualiza = fechaActualiza;
    }
    
}
