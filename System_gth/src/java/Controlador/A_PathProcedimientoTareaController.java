/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_Tarea;
import Modelo.A_PathProcedimientoTareaModel;
import java.util.List;

/**
 *
 * @author DELL-UAB
 */
public class A_PathProcedimientoTareaController {
     A_PathProcedimientoTareaModel mod = new A_PathProcedimientoTareaModel();
    
    
    public List<A_Tarea> getAllPathProcedimiento(int idProcedimiento) {
        return this.mod.getAllPathProcedimiento(idProcedimiento);
    } 
    
    public String savePathProcedimiento(A_Tarea path){
        return this.mod.savePathProcedimiento(path);
    }
    
    public String DeletePathProcedimiento(int idPath){ 
        return this.mod.DeletePathProcedimiento(idPath);
    }
    
}
