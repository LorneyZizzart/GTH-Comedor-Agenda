package Controlador;

import Entidad.Plan_indica_resultado;
import Modelo.Plan_indica_resultadoModel;
import java.util.List;

public class Plan_indica_resultadoController {

    public String CreateOrUpdateIndicador(Plan_indica_resultado indicador) {
        Plan_indica_resultadoModel mod = new Plan_indica_resultadoModel();
        return mod.CreateOrUpdateIndicador(indicador);
    }

    public List<Plan_indica_resultado> GetAllIndicadorByEmepleado(String empleado, String matriz_id) {
        Plan_indica_resultadoModel mod = new Plan_indica_resultadoModel();
        return mod.GetAllIndicadorByEmepleado(empleado, matriz_id);
    }

    public Plan_indica_resultado GetIndicadorById(String id) {
        Plan_indica_resultadoModel mod = new Plan_indica_resultadoModel();
        return mod.GetIndicadorById(id);
    }

    public String deleteIndicador(String id_indicador, String empleado) {
        Plan_indica_resultadoModel mod = new Plan_indica_resultadoModel();
        return mod.deleteIndicador(id_indicador, empleado);
    }
    
    public List<Plan_indica_resultado> GetAllIndicador(String matriz_id) {
        Plan_indica_resultadoModel mod = new Plan_indica_resultadoModel();
        return mod.GetAllIndicador(matriz_id);
    }

    public List<Plan_indica_resultado> GetAllIndicadorCalendarioByUserId(String empleado) {
        Plan_indica_resultadoModel mod = new Plan_indica_resultadoModel();
        return mod.GetAllIndicadorCalendarioByUserId(empleado);
    }
    /*
        Treamos todos los indicadores que esten en estado 1
        Esto sera para la vista de adminstracion 
    */
    public List<Plan_indica_resultado> GetAllIndicadorCalendarioAdmin() {
        Plan_indica_resultadoModel mod = new Plan_indica_resultadoModel();
        return mod.GetAllIndicadorCalendarioAdmin();
    }
    
}
