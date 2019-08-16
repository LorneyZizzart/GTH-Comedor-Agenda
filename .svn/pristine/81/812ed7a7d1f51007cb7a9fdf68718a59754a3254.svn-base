package Controlador;

import Entidad.Cuestionario;
import Modelo.CuestionarioModel;
import java.util.List;

public class CuestionarioController {

    /*
    / Para poder realizar la insercion el cuestionario_id = 0
    / Para la actualizacion cuestionario_id > 0
    / Los parametos que se requiere son los siguientes
    / @Cuestionario
    / Nombre -nombre del cuestionario
    / Estado - Estado tiene que se 1 = activo o 0=desactivado
    / Usuario_crea  - aqui que mande el usuario_id para la creacion
    / Usuario_actualiza - aqui que mande el usuario_id para la actualizacion
    / Detalle - Aqui se coloca un pequeño detalle del cuestionario maximo de  550 caracteres
    / -------- Tambien nesecitamos una lista de tipo cadena 
    / Esto sera para poder registrar las areas como ser Cargo, Departamento
    / requeerimos que estas lista se envien de la situente manera
    / List<String> area = new ArrayList<String>();
     */
    public String CreateOrUpdateCuestionario(Cuestionario cuestionario, List<String> cargo, List<String> departamento) {
        CuestionarioModel cue = new CuestionarioModel();
        return cue.CreateOrUpdateCuestionario(cuestionario, cargo, departamento);
    }

    /*
    / Traemos todos los cuentionarios
     */
    public List<Cuestionario> GetAllCuestionario() {
        CuestionarioModel cue = new CuestionarioModel();
        return cue.GetAllCuestionario();
    }

    /*
    / Traemos un cuestionario 
    / La busqueda se realiza por el Cuestionario_id    
    / Retorna solo un objeto de tipo Cuestionario
     */
    public Cuestionario GetCuestionariobyCuestionario_id(int cuestionario_id) {
        CuestionarioModel cue = new CuestionarioModel();
        return cue.GetCuestionariobyCuestionario_id(cuestionario_id);
    }

    /*
    / Eliminamos un cuestionrio
    / Verifica que no tenga preguntas 
    / En caso que tuviera retorna mensaje que no se puede eliminar
    / En caso que no tuviera relacion con preguntas returna Ok y elimina
     */
    public String DeleteCuestionariobyCuestionario_id(int cuestionario_id) {
        CuestionarioModel cue = new CuestionarioModel();
        return cue.DeleteCuestionariobyCuestionario_id(cuestionario_id);
    }

    /*
    / Camcioamos de destado 
    / El nuevo estado sera 6
    / El estado 6 Significa Eliminado en todos los casos
     */
    public String DeleteCuestionarioByCuestionarioIdCambiaEstato6(int cuestionario_id) {
        CuestionarioModel cue = new CuestionarioModel();
        return cue.DeleteCuestionarioByCuestionarioIdCambiaEstato6(cuestionario_id);
    }

    /*
    / Comenzamos con la evaluacion 
    / para esto comenzaremos con el id de la tabla Cuestionario_evalua
    / con el id Cuestionario_evalua_id
    / esto nos retorna datos de cuestioario tambien 
    / List<Pregunta>
    /     -> Lista<Pregunta_opcion>
    /
     */
    public Cuestionario ComenzarEvaluacion(int cuestionario_evalua_id) {
        CuestionarioModel cue = new CuestionarioModel();
        return cue.ComenzarEvaluacion(cuestionario_evalua_id);
    }

}
