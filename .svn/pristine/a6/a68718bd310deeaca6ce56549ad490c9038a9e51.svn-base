/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_EstadoTarea;
import Modelo.A_EstadoTareaModel;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_EstadoTareaController {
    
    public List<A_EstadoTarea> getAllEstadoTarea() {
        A_EstadoTareaModel x = new A_EstadoTareaModel();
        return x.getAllEstadoTarea();
    }   
    
    public A_EstadoTarea getEstadoTareaById(int idEstadoTarea) {
        A_EstadoTareaModel mod = new A_EstadoTareaModel();
        return mod.getEstadoTareaById(idEstadoTarea);
    }
    
    public String SaveOrUpdate(A_EstadoTarea estadoTarea) {
        A_EstadoTareaModel mod = new A_EstadoTareaModel();
        return mod.SaveOrUpdate(estadoTarea);
    }
    
    public String DeleteEstadoTareaById(int idEstadoTarea) {
        A_EstadoTareaModel mod = new A_EstadoTareaModel();
        return mod.DeleteEstadoTarea(idEstadoTarea);
    }
    
}
