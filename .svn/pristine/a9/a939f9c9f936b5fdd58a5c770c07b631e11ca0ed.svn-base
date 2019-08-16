package Controlador;

import Entidad.Pregunta;
import java.util.List;

public class PreguntaController {
    /*
    / Para la creacion o actualizacion de pregunta se requiere 
    / los siguientes parámetros
    / @Pregunta
    / Cuestionario_id() -En caso que se inserte estara este en 0, en caso de actualizacion tiene que ser > 0
    / Nombre - Titulo de la pregunta o pregunta 
    / Estado - Colocamos 0 = inactivo, 1 = activo
    / Orden - Sera valor entero para la el orden
    / Usuario_crea - El id del usuario que crea
    / Tipo_id - tipo de pregunta que sera
    / Usuario_actualiza - Seral el usuario que actualiza la pregunta 
    / -- Retornara un 'Ok' Si se realiza correctamente
    / o un valor distinto en caso que pase algun error
    */
    public String CreateOrUpdatePregunta(Pregunta pregunta) {
        Modelo.PreguntaModel mod = new Modelo.PreguntaModel();
        return mod.CreateOrUpdatePregunta(pregunta);
    }

    /*
    / Traemos la lista de preguntas que térnense a un Cuestionario
    / Pâra esto requerimos el parametro    
    / @Cuestionario_id
    */
    public List<Pregunta> GetAllPreguntaByCuestionarioId(int Cuestionario_id) {
        Modelo.PreguntaModel mod = new Modelo.PreguntaModel();
        return mod.GetAllPreguntaByCuestionarioId(Cuestionario_id);
    }
    
    /*
    / Elimina una pregunta para esto requerimos que     
    / se envie el siguiente parametro 
    / @Pregunta_id
    / retornara una valor String de respuesta 'Ok' cuando se realiza correctamente
    / y otro valos que caso que no se pueda realizar al eliminacion
    */
    public String EliminaPregunta(int pregunta_id) {
        Modelo.PreguntaModel mod = new Modelo.PreguntaModel();
        return mod.EliminaPregunta(pregunta_id);
    }
    
    /*
    / Traemos un objeto de tipo pregunta
    / Pâra esto requerimos el parametro    
    / @pregunta_id
    */
    public Pregunta GetPreguntaByPregunta_Id(int pregunta_id) {
        Modelo.PreguntaModel mod = new Modelo.PreguntaModel();
        return mod.GetPreguntaByPregunta_Id(pregunta_id);
    }
}
