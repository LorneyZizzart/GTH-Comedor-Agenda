package Controlador;

import Modelo.Cuestionario_gestionModelo;
import Entidad.Cuestionario_gestion;
import Entidad.View_Empleado_Encuesta;
import Entidad.View_Empleado_Gestion;
import Entidad.View_Enviar_correo;
import java.util.List;

public class Cuestionario_gestionController {

    /*
    / Este metodo es para realizar la actualizacion y la insecion
    / Para la insercion mandamos los parametros 
    / @Cuestionario_gestion
    / - Cuestionario_gestion_id - Tiene que ser = 0
    / - Nombre - Sera el nombre de la gestion 
    / - Usuario_crea - El ususario que lo crea
    / - Descripcion
    /
    / Para la actualizacion requerimos los siguientes parametros
    / @Cuestionario_gestion
    / - Cuestionario_gestion_id - Tiene que ser > 0
    / - Nombre - Sera el nombre de la gestion 
    / - Usuario_actualiza - El ususario que lo Actualiza
    / - Descripcion
     */
    public String SaveorUpdateCuestionario_gestion(Cuestionario_gestion gestion, List<String> Empleado_id) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.SaveorUpdateCuestionario_gestion(gestion, Empleado_id);
    }

    /*
    / Solo se cambia de estado a 6 en caso de querer eliminar
    / Para esto solo se requiere el parametro 
    / - Cuestionario_gestion_id
     */
    public String DeleteCuestionario_gestion(int id) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.DeleteCuestionario_gestion(id);
    }

    /*
    / Traemos un objeto de tipo Cuestionario_gestion
    / Para esto se requiere 
    / - Cuestionario_gestion_id
     */
    public Cuestionario_gestion GetCuestionario_gestionById(int id) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.GetCuestionario_gestionById(id);
    }

    /*   
    / Retorna una lista, mnos los eliminados que estan en estado = 6
     */
    public List<Cuestionario_gestion> GetAllCuestionario_gestion() {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.GetAllCuestionario_gestion();
    }

    /*
    / Traemos la lista de todos los empleados
    / la condicion es que es el empleado cargo este activo = 1
    / tambien el Empleado este el estado = 1
    / Retorna el siguiente dato
    / @View_Empleado_Gestion
    / - Empleado_id;
    / - Nombre_empleado;
    / - Nombre_cargo;
    / Nombre_departamento
     */
    public List<View_Empleado_Gestion> GetAllEmpleadoGestion() {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.GetAllEmpleadoGestion();
    }

    /*
    / Eliminamos a un empleado de la gestion 
    / para esto requerimos le id 
    / - Cuestionario_gestion_empleado_id
     */
    public String DeleteEmpledadodeGestion(int Cuestionario_gestion_empleado_id) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.DeleteEmpledadodeGestion(Cuestionario_gestion_empleado_id);
    }

    /*
    / Traemos la lista de todos los empleados que no se encuentran registrados
    / en la gestion.
    / La condicion es que es el empleado cargo este activo = 1
    / tambien el Empleado este el estado = 1
    / Retorna el siguiente dato
    / @View_Empleado_Gestion
    / - Empleado_id;
    / - Nombre_empleado;
    / - Nombre_cargo;
    / Nombre_departamento
     */
    public List<View_Empleado_Gestion> GetAllEmpleadoNoRegistradoEnGestion(int gestion) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.GetAllEmpleadoNoRegistradoEnGestion(gestion);
    }

    /*
    / Aniadimos a empleados a una gestion
    / requerimos que solo se nos pase los siguientes datos
    / - Cuestionario_gestion_id
    / List<String> id de todos los empleados seleccionados
     */
    public String AgregaEmpleadoAGestion(int cuestionario_gestion_id, List<String> IdEmpleado) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.AgregaEmpleadoAGestion(cuestionario_gestion_id, IdEmpleado);
    }

    /*
    / Busca las coincidencias entre los cuestionarios que se encuentran activos 
    / y retorna una lista con  con datos del cuestionario, personal 
    / y las persona que realizaran la evaluacion
    / @jefes, Pares, clientes
     */
    public List<View_Empleado_Encuesta> GetCuestionarioByGestionEmpleado(int gestion_id, int empleado_id) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.GetCuestionarioByGestionEmpleado(gestion_id, empleado_id);
    }

    /*
    / Mostramos los cuestionarios y las personas que evaluaran 
    / al personal seleccionado
    / Para esto requerimos los siguientes parametros
    / @Cuestionario_gestion_id
    / @Empleado_id
     */
    public List<View_Enviar_correo> GetAquienEnviaCorreo(int Cuestionario_gestion_id, int Empleado_id) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.GetAquienEnviaCorreo(Cuestionario_gestion_id, Empleado_id);
    }

    /*
    / Insertamos y Actualizamos el contenido del Correo_electronico que se mandara
    / a las persona involucrara a la evaluacion a la gestion.
    / Para esto requerimos los siguientes datos
    / @Cuestionario_gestion_id
    / @Mensaje_correo
     */
    public String SaveCorreoMensaje(String Cuestionario_gestion_id, String Mensaje_correo, String titulo_correo) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.SaveCorreoMensaje(Cuestionario_gestion_id, Mensaje_correo, titulo_correo);
    }
    
    /*
    / Casamos un reporte de a quien mandamos los correos
    / del personal seleccionado
    / Para esto requerimos los siguientes parametros
    / @Cuestionario_gestion_id
    / @Empleado_id
     */
    public List<View_Enviar_correo> VerAquienEnviaCorreo(int Cuestionario_gestion_id, int Empleado_id) {
        Cuestionario_gestionModelo Modelo = new Cuestionario_gestionModelo();
        return Modelo.VerAquienEnviaCorreo(Cuestionario_gestion_id, Empleado_id);
    }
}
