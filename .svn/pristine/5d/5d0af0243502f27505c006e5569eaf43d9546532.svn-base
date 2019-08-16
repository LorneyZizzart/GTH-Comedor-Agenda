package Controlador;

import Entidad.Pregunta_opcion;
import java.util.List;

public class Pregunta_opcionController {

    /*
    / Para insertar requerimos los siguientes parametros
    / @Pregunta_opcion
    / Opcion
    / Css
    / Seccion
    / Pregunta_id
     */
    public String insertPregunta_opcion(Entidad.Pregunta_opcion opcion) {
        Modelo.Pregunta_opcionModelo mod = new Modelo.Pregunta_opcionModelo();
        return mod.insertPregunta_opcion(opcion);
    }

    /*
    / Elimina Pregunta_opcion
    / nesecitamos el siguiente parametro.
    / @Pregunta_id
     */
    public String eliminaPregunta_opcionByPregunta_id(int pregunta_id) {
        Modelo.Pregunta_opcionModelo mod = new Modelo.Pregunta_opcionModelo();
        return mod.eliminaPregunta_opcionByPregunta_id(pregunta_id);
    }

    public List<Pregunta_opcion> GetPreguntaOpcionByPregunta_id(int pregunta_id) {
        Modelo.Pregunta_opcionModelo mod = new Modelo.Pregunta_opcionModelo();
        return mod.GetPreguntaOpcionByPregunta_id(pregunta_id);
    }
}
