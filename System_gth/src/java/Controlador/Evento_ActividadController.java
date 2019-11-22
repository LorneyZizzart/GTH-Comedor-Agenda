package Controlador;

import Entidad.Empleado;
import Entidad.Evento_Actividad;
import Modelo.Evento_ActividadModel;
import java.util.List;

public class Evento_ActividadController {

    // Para crear o actualizar la actividad, requerimos los siguientes
    // datos que el tenga el objeto Evento_actividad
    // @Evento_Actividad
    // -Nombre_actividad
    // -Empleado_id
    // -Descripcion
    // -Fecha_inicio_actividad
    // -Fecha_fin_actividad
    // -Evento_id
    public String CreateorUpdateEventoActividad(Evento_Actividad actividad) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.CreateorUpdateEventoActividad(actividad);
    }

    // Traemos todas las actividades 
    // que pertenescan a un evento 
    // para esto requerimos el
    // @Evento_id
    public List<Evento_Actividad> GetAllActividadesByEvento_id(int Evento_id) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.GetAllActividadesByEvento_id(Evento_id);
    }

    // Traemos una actividades 
    // para esto requerimos el
    // @Actividad_id
    public Evento_Actividad GetActividadesByActividad_id(int actividad_id) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.GetActividadesByActividad_id(actividad_id);
    }

    // Eliminarmos la actividad
    // en realidad cambiamos de estado a estdo 6 
    // para esto requerimos
    // -Evento_actividad_id
    // -Evento_id
    public String EliminaActividad(Evento_Actividad actividad) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.EliminaActividad(actividad);
    }

    // Lista de todos los participates que no fueron registrados
    // en la actividad para esto requerimos el id de la actividad
    // -Evento_actividad_id
    public List<Empleado> EmpleadosNoregistradoActividad(int id_actividad, int id_evento) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.EmpleadosNoregistradoActividad(id_actividad, id_evento);
    }

    public String RegistroAsistenciaActividad(int empleado_id, int actividad_id) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.RegistroAsistenciaActividad(empleado_id, actividad_id);
    }

    // Lista de todos los participates que no fueron registrados
    // en la actividad para esto requerimos el id de la actividad
    // -Evento_actividad_id
    public List<Empleado> EmpleadosPresenteActividad(int id_actividad, int id_evento) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.EmpleadosPresenteActividad(id_actividad, id_evento);
    }

    // optenemos la catnidad de eventos que tiene una actividad
    // para esto requerimos el id del evento
    // @Evento_id   
    public int Cantidad_ActividadesEvento(int evento_id) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.Cantidad_ActividadesEvento(evento_id);
    }
    
    // Lista de todos los participates que estan en la actividad
    // menos lo que fueron seleccionados ante en la ruleta
    // -Evento_actividad_id
    public List<Empleado> EmpleadosActividadJuego(int id_actividad, int id_evento) {
        Evento_ActividadModel model = new Evento_ActividadModel();
        return model.EmpleadosActividadJuego(id_actividad, id_evento);
    }
}
