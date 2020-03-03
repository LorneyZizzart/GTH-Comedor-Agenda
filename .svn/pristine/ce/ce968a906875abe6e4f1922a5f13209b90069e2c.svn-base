package Controlador;

import Entidad.Empleado_docente;
import Modelo.Empleado_docenteModelo;
import java.util.List;

public class Empleado_docenteController {

    /*
        Traemos toda la lista de los docentes de acuerdo a la gestion y el area
        El area puede ser 0 y no tomara en cuenta el area si no toda la gestion
        
     */
    public List<Empleado_docente> getAllDocenteByGestionArea(String gestion, String area) {
        Empleado_docenteModelo mod = new Empleado_docenteModelo();
        return mod.getAllDocenteByGestionArea(gestion, area);
    }

    /*
        convinamos la tabla empleado y cargamos en la lista Empleado_docente
        No mostrara el docente si este esta guardado en el mismo area y en estado = 1
        para esto requeriamos la gestion y el area
     */
    public List<Empleado_docente> getAllEmpleadoByGestionArea(String gestion, String area) {
        Empleado_docenteModelo mod = new Empleado_docenteModelo();
        return mod.getAllEmpleadoByGestionArea(gestion, area);
    }

    /*
        Agregamos al docente
     */
    public String AgregarProfesor(Empleado_docente prof) {
        Empleado_docenteModelo mod = new Empleado_docenteModelo();
        return mod.AgregarProfesor(prof);
    }

    /*
        Eliminamos un profesor
        en realidad solo cambiamos de esta do a 6
     */
    public String ElimiarProfesor(String codigo_prof, String codigo_usuario) {
        Empleado_docenteModelo mod = new Empleado_docenteModelo();
        return mod.ElimiarProfesor(codigo_prof, codigo_usuario);
    }

    /*
        Traemos el codigo_sis_acad de la tabla empleado
        En caso que no tenga retornamos vacio
        para esto requerimos:
        -emplado_id
     */
    public String GetEmpleadoCodAcad(String id) {
        Empleado_docenteModelo mod = new Empleado_docenteModelo();
        return mod.GetEmpleadoCodAcad(id);
    }
}
