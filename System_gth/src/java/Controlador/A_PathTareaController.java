/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_PathTarea;
import Modelo.A_PathTareaModel;
import java.util.List;

/**
 *
 * @author DELL-UAB
 */
public class A_PathTareaController {
    A_PathTareaModel mod = new A_PathTareaModel();
    
    
    public List<A_PathTarea> getAllPath(int idTarea) {
        return this.mod.getAllPath(idTarea);
    }
    
    public String DeletePath(int idPath){ 
        return this.mod.DeletePath(idPath);
    }
}
