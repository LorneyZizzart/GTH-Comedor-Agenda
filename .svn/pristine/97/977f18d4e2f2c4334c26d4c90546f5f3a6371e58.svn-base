package Controlador;

import Entidad.Plan_accion;
import Modelo.Plan_accionModel;
import java.util.List;

public class Plan_accionController {

    /*
        Para insertar campo Plan_accion_id = 0
        Para actualizar campo Plan_accion_id > 0
        Para realizar la insercion y actualizacion requerimos lo siguiente parametros
        @Plan_accion
        -Plan_Accion_id
        -Nombre
        -Contexto
        -Empleado_id // Para la actualizacion pasa a ser como Empleado_actualiza
        -Plan_subobjetivo_id
        -Estado // Cuando se elimina para a ser Estado = 6
     */
    public String SaveOrUpdatePlan_accion(Plan_accion plan) {
        Modelo.Plan_accionModel mod = new Modelo.Plan_accionModel();
        return mod.SaveOrUpdatePlan_accion(plan);
    }

    /*
        Obtenemos una lista de todos los planes_accion 
        para esto requerimos el 
        -Plan_subobjetivo_id
     */
    public List<Plan_accion> GetAllPlan_accionBySubobjetivo_id(int subobjetivo_id) {
        Plan_accionModel mod = new Plan_accionModel();
        return mod.GetAllPlan_accionBySubobjetivo_id(subobjetivo_id);
    }

    /*
        Obtenemos una lista de todos los planes_accion 
        para esto requerimos el 
        -Plan_subobjetivo_id
     */
    public Plan_accion GetPlan_AccionByPlanAccion_id(int plan_accion_id) {
        Plan_accionModel mod = new Plan_accionModel();
        return mod.GetPlan_AccionByPlanAccion_id(plan_accion_id);
    }

    /*
        
        Actualizamos solo el Critero para esto requerimos
        @Plan_accion    
        -Plan_Accion_id
        -Criterio
     */
    public String UpdatePlanAccionCriterio(Plan_accion plan) {
        Plan_accionModel mod = new Plan_accionModel();
        return mod.UpdatePlanAccionCriterio(plan);
    }

}
