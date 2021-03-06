/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_EstadoTarea;
import Entidad.A_ProcedimientoTarea;
import Entidad.A_Tarea;
import Entidad.Empleado;
import Modelo.A_ProcedimientoTareaModel;
import Modelo.A_TareaModel;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL-UAB
 */
public class A_ProcedimientoTareaController {
    A_ProcedimientoTareaModel mod = new A_ProcedimientoTareaModel();
    A_TareaModel modTarea = new A_TareaModel();
    
    public List<A_Tarea> getAllProcedimientoTarea(String titulo, int idUsuario) {
        return this.mod.getAllProcedimientoTarea(titulo, idUsuario);
    }
    
    public List<A_Tarea> getAllIdProcedimiento(String titulo, int idUsuario, String nombreProceso) {
        return this.mod.getAllIdProcedimiento(titulo, idUsuario, nombreProceso);
    }
    
    public A_ProcedimientoTarea getProcedimientoById(int idProcedimiento){
        return this.mod.getProcedimientoById(idProcedimiento);
    }  
    
    public A_Tarea getMaxIdProcedimiento(){
        return mod.getMaxIdProcedimiento();
    }
    
    public List<A_Tarea> SaveProcedimiento(A_Tarea procesoTarea) throws ParseException {        
        A_TareaModel modT = new A_TareaModel();
        List<A_Tarea> listaTarea = new ArrayList<A_Tarea>();
        List<A_Tarea> listaId = new ArrayList<A_Tarea>();
//        A_Tarea tarea = new A_Tarea();
//        tarea = modT.getTareaById(procesoTarea.getIdTarea());
        listaTarea = modT.getAllTareaForProcess(procesoTarea);
        String resultado = null;
        for(A_Tarea t : listaTarea){
            procesoTarea.setIdTarea(t.getIdTarea());
            resultado = this.mod.SaveProcedimientoTarea(procesoTarea);
            listaId.add(this.mod.getMaxIdProceso());
        }
        return  listaId;
    }
    
    public String UpdateProcedimientoTarea(A_ProcedimientoTarea procesoTarea) {
        return this.mod.UpdateProcedimientoTarea(procesoTarea);
    }
    
    public String DeleteProcedimientoTarea(String idProcedimiento){ 
        String[] id = idProcedimiento.split("%");
        List<A_Tarea> tareas = new ArrayList<>();
        A_ProcedimientoTarea p = new A_EstadoTarea();
        p = this.mod.getProcedimientoById(Integer.parseInt(id[0]));
        String nombreProceso = p.getNombreProcedimiento();
        String respuesta = null;
        tareas = this.modTarea.getAllTareaByTitulo_User(id[1], Integer.parseInt(id[2]));
        for(A_Tarea ta : tareas){
            System.err.println("tarea");
            System.out.println(ta);            
            p = this.mod.getProcedimientoTareaByIdTarea_Nombre(ta.getIdTarea(), nombreProceso);
            System.err.println("proceso");
            System.out.println(p);
            respuesta = this.mod.DeleteProcedimiento(p.getIdProcedimiento());
        }
        return respuesta;
    }
}
