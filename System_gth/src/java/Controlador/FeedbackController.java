package Controlador;

import Entidad.Feedback;
import Entidad.Feedback_tipo;
import Modelo.FeedbackModelo;
import java.util.List;

public class FeedbackController {

    /*
        Treamos todos los tipos de advertencias exista
     */
    public List<Feedback_tipo> get_All_TiposAdventendia() {
        FeedbackModelo mod = new FeedbackModelo();
        return mod.get_All_TiposAdventendia();
    }

    /*
    / Insertamos o actualzamos una retroalimentacion 
     */
    public String Create_or_update(Feedback advertencia) {
        FeedbackModelo mod = new FeedbackModelo();
        return mod.Create_or_update(advertencia);
    }

    /*
    / Treamos todos la retroalimentacion del empleado
    / buscamos por su id
     */
    public List<Feedback> Get_all_feedback_empleado(int empleado_id) {
        FeedbackModelo mod = new FeedbackModelo();
        return mod.Get_all_feedback_empleado(empleado_id);
    }

    /*
    / traemos un objeto de tipo Feedback
    / para esto nesecitamos el id
    / @Feedback_tipo_id
     */
    public Feedback Get_feedback_by_id(int Feedback_tipo_id) {
        FeedbackModelo mod = new FeedbackModelo();
        return mod.Get_feedback_by_id(Feedback_tipo_id);
    }

    /*
    / Eliminamos Feedback 
    / en realidad cambiamos a estado 6 para mantener un historico 
    / para esto requerimos el paramirto
    / @Feedback_tipo_id
     */
    public String delete_feedback_by_id(int Feedback_tipo_id, int admin_id) {
        FeedbackModelo mod = new FeedbackModelo();
        return mod.delete_feedback_by_id(Feedback_tipo_id, admin_id);
    }
}
