package Controlador;

import Entidad.Evento_participantes;
import Modelo.Evento_participantesModel;
import java.util.List;

public class Evento_participantesController {

    //
    // Requerimos una lista de Participantes
    // para esto requerimos que la lista tenga los 
    // siguientes parametros 
    // @Evento_participantes
    // - Empleado_id
    // - Evento_id
    // - Registra_personal_id // el usuario que registra
    public String AnadirParticipantes(List<Evento_participantes> Participates) {
        Evento_participantesModel participante = new Evento_participantesModel();
        return participante.AnadirParticipantes(Participates);
    }
    
    //
    // Requerimos una lista de Participantes
    // para esto requerimos que la lista tenga los 
    // siguientes parametros 
    // @Evento_participantes
    // - Empleado_id
    // - Evento_id
    // - Registra_personal_id // el usuario que registra
    public String AnadirUnParticipantes(Evento_participantes Participates) {
        Evento_participantesModel participante = new Evento_participantesModel();
        return participante.AnadirUnParticipantes(Participates);
    }

    // Eliminamos al personal del evento   
    // cambianos a estado 6 al personal 
    // para esto requerimo las siguientes variables
    // @Evento_participante
    // - Empleado_id
    // - Registra_personal_id
    // - Evento_id
    public String EliminaParticipanteEvento(Evento_participantes participante) {
        Evento_participantesModel parti = new Evento_participantesModel();
        return parti.EliminaParticipanteEvento(participante);
    }
}
