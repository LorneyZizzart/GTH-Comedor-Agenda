package Controlador;

import Entidad.Plan_objetivo;
import Modelo.Plan_objetivoModelo;
import java.util.List;

public class Plan_objetivoController {

    /*
        Para crear el id = 0
        Para actualizar id > 0
        Para esto nesecitamos los parametros
        @Plan_objetivo
        -Plan_objetivo_id
        -Titulo
        -Creaditacion
        -Gestion
        -Empleado_id // que para la actualizacion pasaria a ser Empleado_actualiza
        -Fecha_creacion // Para la actualizacion pasaria a ser Fecha_actuaza
        -Estado  ; 1=activo; 0=desactivado ; 6=eliminado        
     */
    public String SaveorUpdateObjetivo(Plan_objetivo plan_objetivo) {
        Plan_objetivoModelo plan = new Plan_objetivoModelo();
        return plan.SaveorUpdateObjetivo(plan_objetivo);
    }

    /*
        Obtenemos todos los planes_objetivos del empelado
        para esto nesecitamos el parametro
        -Empleado_id
     */
    public List<Plan_objetivo> GetAllPlanObjetivobyUser(int empleado_id) {
        Plan_objetivoModelo plan = new Plan_objetivoModelo();
        return plan.GetAllPlanObjetivobyUser(empleado_id);
    }

    /*
        Optenemos solo un  Plan_objetivo
        para esto requerimos el siquiente parametro
        @Plan_objetivo_id
     */
    public Plan_objetivo GetplanObjetivobyId(int plan_objetivo_id) {
        Plan_objetivoModelo plan = new Plan_objetivoModelo();
        return plan.GetplanObjetivobyId(plan_objetivo_id);
    }
}
