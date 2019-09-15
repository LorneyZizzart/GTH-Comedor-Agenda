/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_ProcedimientoTarea;
import Entidad.A_Tarea;
import Entidad.Empleado;
import Modelo.A_ProcedimientoTareaModel;
import Modelo.A_TareaModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL-UAB
 */
public class A_ProcedimientoTareaController {
    A_ProcedimientoTareaModel mod = new A_ProcedimientoTareaModel();
    
    public List<A_Tarea> getAllProcedimiento(int idTarea) {
        return this.mod.getAllProcedimientoTarea(idTarea);
    }
    
    public A_ProcedimientoTarea getProcedimientoById(int idProcedimiento){
        return this.mod.getProcedimientoById(idProcedimiento);
    }  
    
    public String SaveProcedimiento(A_Tarea procesoTarea) throws ParseException {        
        A_TareaModel modT = new A_TareaModel();
        List<A_Tarea> listaTarea = new ArrayList<A_Tarea>();
        A_Tarea tarea = new A_Tarea();
        tarea = modT.getTareaById(procesoTarea.getIdTarea());
        listaTarea = modT.getAllTareaForProcess(tarea.getTitulo());
        String resultado = null;
        for(A_Tarea t : listaTarea){
            procesoTarea.setIdTarea(t.getIdTarea());
            resultado = this.mod.SaveProcedimientoTarea(procesoTarea);
        }
        return  resultado;
    }
    
    public String UpdateProcedimientoTarea(A_ProcedimientoTarea procesoTarea) {
        return this.mod.UpdateProcedimientoTarea(procesoTarea);
    }
    
    public String DeleteProcedimientoTarea(int idProcedimiento){ 
        return this.mod.DeleteProcedimiento(idProcedimiento);
    }
    
//    AUX EMPLEADO PROCEDIMIENTO
    
    private String AuxSaveEmpleadoProcedimiento(List<Empleado> empleados, int idProcedimiento) {
        String resultado = null;
        int idAuxProcedimiento = 0;
        if(idProcedimiento == 0)
        idAuxProcedimiento = Integer.parseInt(mod.getAuxMaxProcedimientoTarea());
        else idAuxProcedimiento = idProcedimiento;
        for(Empleado e : empleados){
            resultado = this.mod.SaveAuxEmpleadoProcedimiento(e.getEmpleado_id(), idAuxProcedimiento);
        }
        return resultado;
    }
    
    private  String DeleteAuxEmpleadoProcedimiento(int idEmpleadoProcedimiento) {
        return this.mod.DeleteAuxEmpleadoProcedimiento(idEmpleadoProcedimiento);
    }
    
    private  String DeleteAllAuxEmpleadoProcedimiento(int idProcedimiento) {
        return this.mod.DeleteAllAuxEmpleadoProcedimiento(idProcedimiento);
    }
    
    
//    AUX PROCEDIMIENTO TAREA
    
    public List<A_ProcedimientoTarea> getAuxAllProcedimiento(int idUsuario) {
        return this.mod.getAllAuxProcedimientoTarea(idUsuario);
    }
    
    public String AuxSaveOrUpdate(A_ProcedimientoTarea procesoTarea) {
        String respuesta = null;
        try {
            if (procesoTarea.getIdProcedimiento() == 0) {
                //insertar
                respuesta = AuxSaveProcedimiento(procesoTarea);
            } else {
                // Actualizar
                respuesta = AuxUpdateProcedimiento(procesoTarea);
            }

        } catch (Exception e) {
        }
        return respuesta;
    }
    
    private String AuxSaveProcedimiento(A_ProcedimientoTarea procesoTarea) {
        String resultado = null;
        resultado =  this.mod.SaveAuxProcedimientoTarea(procesoTarea);
        return resultado;
    }
    
    private String AuxUpdateProcedimiento(A_ProcedimientoTarea procesoTarea) {
        String resultado = null;
        resultado = this.mod.UpdateAuxProcedimientoTarea(procesoTarea);
        if(resultado.equals("Ok")){
            resultado = this.DeleteAllAuxEmpleadoProcedimiento(procesoTarea.getIdProcedimiento());

        }
        return resultado;
    }
    
    public  String AuxDeleteProcedimiento(int idProcedimiento) {
        return this.mod.DeleteAuxProcedimientoTarea(idProcedimiento);
    }
    
    public  String AuxDeleteAllProcedimiento(int idUsuario) {
        return this.mod.DeleteAllAuxProcedimiento(idUsuario);
    }
    
}
