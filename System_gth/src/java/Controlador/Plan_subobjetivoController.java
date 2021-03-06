package Controlador;

import Entidad.Plan_subobjetivo;
import Modelo.Plan_subobjetivoModelo;
import java.util.List;

public class Plan_subobjetivoController {

    /*
        Para insertar el Plan_subobjetivo_id = 0
        Para actualizar el Plan_subobjetivo_id > 0
        Los parametros que nesecitamos para realizar la 
        insercion y actualizacion son los siguietes
        @Plan_subobjetivo
        -Plan_subobjetivo_id
        -Plan_objetivo_id
        -Titulo
        -Descripcion
        -Empleado_id //para hacer la actualizacion esto parasia a ser Empleado_actualiza
     */
    public String SaveorUpdateSubobjetivo(Plan_subobjetivo subobjetivo) {
        Plan_subobjetivoModelo mod = new Plan_subobjetivoModelo();
        return mod.SaveorUpdateSubobjetivo(subobjetivo);
    }

    /*
        Listaremos todos los subobjetivos
        para esto nesecitaremos los siguientes parametros 
        -Plan_objetivo_id
     */
    public List<Plan_subobjetivo> GetAllSubobjeticosbyIdObjetivo(int objetivo_id) {
        Plan_subobjetivoModelo mod = new Modelo.Plan_subobjetivoModelo();
        return mod.GetAllSubobjeticosbyIdObjetivo(objetivo_id);
    }

    /*
        Traemos un subobjetivo para esto nesecitamos 
        el siguiente parametro 
        -Plan_objetivo_id
     */
    public Plan_subobjetivo GetSubobjetivobyId(int subobjetivo_id) {
        Plan_subobjetivoModelo mod = new Modelo.Plan_subobjetivoModelo();
        return mod.GetSubobjetivobyId(subobjetivo_id);
    }

    /*
        Eliminaremos el subobjetivo para esto reqquerimo 
        @id_subobjetivo
        @empleado_id
        Lo que aremos sera pasar a estado = 6
     */
    public String deleteSubobjetivo(String subobjetivo_id, String empleado_id) {
        Plan_subobjetivoModelo mod = new Modelo.Plan_subobjetivoModelo();
        return mod.deleteSubobjetivo(subobjetivo_id, empleado_id);
    }
}
