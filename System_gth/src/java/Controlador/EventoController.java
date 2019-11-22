package Controlador;

import Entidad.Empleado;
import Entidad.Evento;
import Modelo.EventoModel;
import java.util.List;

public class EventoController {

    // @Estados
    // 1 = activo
    // 0 = Desactivado
    // 2 = Vencidos
    // 6 = Eliminado
    //
    // Creamos el evento
    // para esto requerimos el objeto Evento
    // con los siguientes parametros
    // @Evento
    // - Evento_id      /Actualizar
    // - Nombre_evento
    // - Empleado_id
    // - Fecha_inicio
    // - Fecha_fin
    // - Estado         /Actualizar
    public String InsertOrUpdate(Evento evento) {
        EventoModel e = new EventoModel();
        return e.InsertOrUpdate(evento);
    }

    // Traemos una lita de todos los eventos que estan activos 
    // los que estan en escado 1
    public List<Evento> GetAllEventoActivo() {
        EventoModel e = new EventoModel();
        return e.GetAllEventoActivo();
    }

    // Traemos una lita de todos los eventos que estan pasados
    // los que estan en escado 0
    public List<Evento> GetAllEventoPasados() {
        EventoModel e = new EventoModel();
        return e.GetAllEventoPasados();
    }

    // Trae un objeto de tipo Evento
    // se requiere para esto el evento_id
    // @Eventi_id
    public Evento GetEventobyId(int id) {
        EventoModel e = new EventoModel();
        return e.GetEventobyId(id);
    }

    // Para desactivar el evento nesecitamos 
    // los datos del empleado y el evento_id
    // cambiaremos a estado 0
    // - Empleado_id
    // - Evento_id
    public String DesactivarEvento(int empleado_id, int evento_id) {
        EventoModel e = new EventoModel();
        return e.DesactivarEvento(empleado_id, evento_id);
    }

    // Para eliminar el evento nesecitamos 
    // los datos del empleado y el evento_id
    // cambiaremos a estado 6
    // - Empleado_id
    // - Evento_id
    public String EliminarEvento(int empleado_id, int evento_id) {
        EventoModel e = new EventoModel();
        return e.EliminarEvento(empleado_id, evento_id);
    }

    /*
    / Optenemso todos los empleados que 
    / estan registrados en el evento y en estado 1
    / esta lista tambien tiene un objeto
    / que tiene el relacion con tabla 
    / Empleado_cargo
    / @Empleado_cargo tambien puede retornar
    / como nulo encaso que no tenga un cargo
     */
    public List<Empleado> GetAllEmpleadoEvento(int evento_di) {
        EventoModel e = new EventoModel();
        return e.GetAllEmpleadoEvento(evento_di);
    }
    
    /*
    / Optenemso todos los empleados que 
    / NO estan registrados en el evento y en estado 1
    / esta lista tambien tiene un objeto
    / que tiene el relacion con tabla 
    / Empleado_cargo
    / @Empleado_cargo tambien puede retornar
    / como nulo encaso que no tenga un cargo
     */
    public List<Empleado> GetAllEmpleadoNoEstanaEnEvento(int evento_di) {
        EventoModel e = new EventoModel();
        return e.GetAllEmpleadoNoEstanaEnEvento(evento_di);
    }
    
    // Lista de todos los participates que no fueron registrados
    // en la actividad para esto requerimos el id de la actividad
    // -Evento_actividad_id
    public List<Empleado> Juego_cantidad_asistencia(int catnidad, int id_evento) {
        EventoModel e = new EventoModel();
        return e.Juego_cantidad_asistencia(catnidad, id_evento);
    }
    
    //Agregamos ganador a la tabla Evento_participante_ganador
    // para esto requerimos el 
    // -Empleado_id
    // -Evneto_id
    
    public String guarda_ganador_eventos(int empleado_id, int evento_id){
        EventoModel e = new EventoModel();
        return e.guarda_ganador_eventos(empleado_id, evento_id);
    }
}
