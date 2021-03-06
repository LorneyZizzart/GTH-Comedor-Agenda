package Controlador;

import Entidad.Plan_accion;
import Entidad.Plan_indica_resultado;
import Entidad.Plan_matriz;
import Entidad.Plan_objetivo;
import Entidad.Plan_subobjetivo;
import Modelo.Plan_objetivoModelo;
import java.util.ArrayList;
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

    /*
        Obtenemos el listado del menu 
        Esto depende el usuarui que aya creado los objetivos y lo que continua
        @Usuario_id
     */
    public List<Plan_objetivo> getMenuGetAllPlanObjetivobyUser(String userid) {
        Plan_objetivoModelo plan = new Plan_objetivoModelo();
        return plan.getMenuGetAllPlanObjetivobyUser(userid);
    }

    /*
        Elimnar un objetivo 
        Para esto requerimos los datos 
        @objetivo_id
        @usuario_id
        Solo cambiaremos de estado a estado 6
     */
    public String EliminaObjetivo(String objetivo_id, String usuario_id) {
        Plan_objetivoModelo plan = new Plan_objetivoModelo();
        return plan.EliminaObjetivo(objetivo_id, usuario_id);
    }

    /*
        Optenemos solo un  Plan_objetivo
        para esto requerimos el siquiente parametro
        @Plan_objetivo_id
     */
    public Plan_objetivo GetplanObjetivobyIdprint(int plan_objetivo_id) {
        Plan_objetivoModelo plan = new Plan_objetivoModelo();
        Plan_objetivo objetivo = new Plan_objetivo();
        objetivo = plan.GetplanObjetivobyId(plan_objetivo_id);

        List<Plan_subobjetivo> subobjetivos = new ArrayList<Plan_subobjetivo>();
        Plan_subobjetivoController ps = new Plan_subobjetivoController();
        subobjetivos = ps.GetAllSubobjeticosbyIdObjetivo(plan_objetivo_id);

        for (Plan_subobjetivo s : subobjetivos) {
            List<Plan_accion> planaccion = new ArrayList<Plan_accion>();
            Plan_accionController pa = new Plan_accionController();
            planaccion = pa.GetAllPlan_accionBySubobjetivo_id(s.getPlan_subobjetivo_id());
            for (Plan_accion p : planaccion) {
                Plan_matriz matriz = new Plan_matriz();
                Plan_matrizController mc = new Plan_matrizController();
                matriz = mc.getMatrizByPlanAccionId(p.getPlan_accion_id());

                if (matriz != null) {
                    List<Plan_indica_resultado> indicador = new ArrayList<Plan_indica_resultado>();
                    Plan_indica_resultadoController pc = new Plan_indica_resultadoController();
                    indicador = pc.GetAllIndicador(Integer.toString(matriz.getPlan_matriz_id()));

                    matriz.setPlan_indica_resultado(indicador);
                }

                p.setPlan_Matriz(matriz);

            }

            s.setPlan_accion(planaccion);
        }
        objetivo.setPlan_subobjetivos(subobjetivos);

        return objetivo;
    }
}
