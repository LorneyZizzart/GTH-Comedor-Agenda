/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Invitado1
 */
public class A_EstadoTarea extends A_TipoTarea{
    private int IdEstadoTarea;
    private String NombreEstadoTarea;
    private int EstadoEstadoTarea;
    
    public void setEstadoEstadoTarea(int estadoEstadoTarea ){
        this.EstadoEstadoTarea = estadoEstadoTarea;
    }
    
    public int getEstadoEstadoTarea(){
        return EstadoEstadoTarea;
    }
    
    public void setNombreEstadoTarea(String nombreEstadoTarea){
        this.NombreEstadoTarea = nombreEstadoTarea;
    }
    
    public String getNombreEstadoTarea(){
        return NombreEstadoTarea;
    }
    
    public void setIdEstadoTarea(int idEstadoTarea){
        this.IdEstadoTarea = idEstadoTarea;
    }
    
    public int getIdEstadoTarea(){
        return IdEstadoTarea;
    }
}
