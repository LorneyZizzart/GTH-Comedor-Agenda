package Controlador;

import Entidad.View_Empleado_Encuesta;
import java.util.List;

public class Cuestionario_evaluaController {

    /*
    / Para porder guardar a los evaluadores re requiere los siguientes datos
    / List<View_Empleado_Encuesta> Encuesntados, donde tendran los siguientes datos
    / @View_Empleado_Encuesta
    / Empleado_id
    / Cuestionario_id
    / List<View_Empleado_Encuesta> Jefes
    / @Empleado_id
    / De la mima manera para Pares, Bajos y Clientes
     */
    public String SaveCuestionario_evalua(List<View_Empleado_Encuesta> encuestados) {
        Modelo.Cuestionario_evaluaModel mod = new Modelo.Cuestionario_evaluaModel();
        return mod.SaveCuestionario_evalua(encuestados);
    }

    /*
    / Guardar una evaluacion 
    / Para porder guardar a los evaluadores re requiere los siguientes datos
    / List<View_Empleado_Encuesta> Encuesntados, donde tendran los siguientes datos
    / @View_Empleado_Encuesta
    / Empleado_id
    / Cuestionario_id
    / List<View_Empleado_Encuesta> Jefes
    / @Empleado_id
    / De la mima manera para Pares, Bajos y Clientes
     */
    public String SaveUnCuestionario_evalua(View_Empleado_Encuesta encuestado) {
        Modelo.Cuestionario_evaluaModel mod = new Modelo.Cuestionario_evaluaModel();
        return mod.SaveUnCuestionario_evalua(encuestado);
    }
}
