/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_TipoTarea;
import Modelo.A_TipoTareaModel;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_TipoTareaController {
    
    public List<A_TipoTarea> getAllTipoTarea() {
        A_TipoTareaModel x = new A_TipoTareaModel();
        return x.getAllTipoTarea();
    }
    
    public A_TipoTarea getTipoTareaById(int idTipoTarea) {
        A_TipoTareaModel mod = new A_TipoTareaModel();
        return mod.getTipoTareaById(idTipoTarea);
    }
    
    /*
    / Realizamos la insercion o la actualizacion de TipoTarea  
    / para realizar este registro se requiere los siguietes parametros
    / @TipoTarea
    / -Id / en caso de actualizacion tiene que ser > 0
    / -Nombre
    / -Estado
     */
    public String SaveOrUpdate(A_TipoTarea tipoTarea) {
        A_TipoTareaModel mod = new A_TipoTareaModel();
        return mod.SaveOrUpdate(tipoTarea);
    }
    
    /*
    / Para eliminar el tipo de tarea
    / para esto se queriere
    / - idTipoTarea 
     */
    public String DeleteTipoTareaById(int idTipoTarea) {
        A_TipoTareaModel mod = new A_TipoTareaModel();
        return mod.DeleteTipoTarea(idTipoTarea);
    }
    
}
