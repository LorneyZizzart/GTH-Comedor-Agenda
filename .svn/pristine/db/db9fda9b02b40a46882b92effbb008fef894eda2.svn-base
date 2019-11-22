package Controlador;

import Entidad.Plan_matriz;
import Modelo.Plan_matrizModel;
import java.util.List;

public class Plan_matrizController {

    /*
    Para la insercion Plan_matriz_id = 0
    Para la actualizaion Plan_matriz_id > 0
    Para poder realizr esta operacion nesecitaremos los siguientes parametros
    @Plan_matriz
    - Plan_matriz_id
    - Que_hacer
    - Responsable
    - Como
    - Documento_generadi
    - Indicadores_resultado 
    - Fecha
    - Indicador
    - Plan_accion_id
    - Empleado_id
    - Estado
     */
    public String SaveorUpdateMatriz(Plan_matriz matriz) {
        Modelo.Plan_matrizModel ma = new Modelo.Plan_matrizModel();
        return ma.SaveorUpdateMatriz(matriz);
    }
    /*
        Traemos un objeto de tipo Plan_matriz
        para esto nesecitamos Plan_matriz_id de tipo entero 
    */
    public Plan_matriz getMatrizByIdMatriz(int id_matriz){
        Modelo.Plan_matrizModel ma = new Modelo.Plan_matrizModel();
        return ma.getMatrizByIdMatriz(id_matriz);
    }
    
    /*
        Traemos un objeto de tipo Plan_matriz
        para esto nesecitamos Plan_accion_id de tipo entero 
    */
    public Plan_matriz getMatrizByPlanAccionId(int plan_accion){
        Modelo.Plan_matrizModel ma = new Modelo.Plan_matrizModel();
        return ma.getMatrizByPlanAccionId(plan_accion);
    }
    
    /*
        Traemos toda la matriz con fecha para mostrar en el 
        calendario que esten en estado = 1
    */
    public List<Plan_matriz> GetAllMatriz(){
        Plan_matrizModel ma = new Plan_matrizModel();
        return ma.GetAllMatriz();
    }
}
