package Controlador;

import Entidad.Empleado;
import Modelo.EmpleadoModel;
import java.util.List;

public class EmpleadoController {

    /*
    / Optenemos la lista de empleados
    / que no tienen accesos al sistema
    / solo son empleados y no tienen 
    / relacion con la tabla Usuario
    / Solo retorna los siguientes parametros
    / @Parametros:
    / Emplado_id
    / Nombre
     */
    public List<Empleado> GetAllEmpleadoNotUser() {
        EmpleadoModel em = new EmpleadoModel();
        return em.GetAllEmpleadoNotUser();
    }

    /*
    / Optenemso todos los empleados
    / esta lista tambien tiene un objeto
    / que tiene el relacion con tabla 
    / Empleado_cargo
    / @Empleado_cargo tambien puede retornar
    / como nulo encaso que no tenga un cargo
     */
    public List<Empleado> GetAllEmpleado() {
        EmpleadoModel em = new EmpleadoModel();
        return em.GetAllEmpleado();
    }

    /*
    / Parameros para crear
    / @Empleado
    / Nombre
    / Apellido_paterno
    / Apellido_materno
    / Email
    / Telefono
    / Estado
    / Estado_civil_id
    / Pais_id
     */
    public String CreateEmpleado(Empleado empleado) {
        EmpleadoModel em = new EmpleadoModel();
        return em.CreateEmpleado(empleado);
    }

    /*
    / Retorna solo los parametros 
    / @Empleado
    / Empleado_id
    / Nombre
    / Apellido_paterno
    / Apellido_materno
    / Email
    / Telefono
    / Estado
    / Estado_civil_id
    / Pais_id
     */
    public Empleado GetEmpleadoByID(int codigo) {
        EmpleadoModel em = new EmpleadoModel();
        return em.GetEmpleadoByID(codigo);
    }

    /*
    / Requerimos solo los parametros 
    / @Empleado
    / Empleado_id
    / Nombre
    / Apellido_paterno
    / Apellido_materno
    / Email
    / Telefono
    / Estado
    / Estado_civil_id
    / Pais_id
     */
    public String UpdateEmpleado(Empleado empleado) {
        EmpleadoModel em = new EmpleadoModel();
        return em.UpdateEmpleado(empleado);
    }

    /*
    / Elimina un empleado
    / Realiza la validacion que no tenga Cargo, Usuario, y Cempleado_reserva
    / Encaso que elimine retorna un Ok
    / En caso que no, retorna el por que no elimina
     */
    public String deleteEmpldeado(int id) {
        EmpleadoModel em = new EmpleadoModel();
        return em.deleteEmpldeado(id);
    }

    /*
    / Validamos si existe el correo
    / enviamos el correo 
    / en caso que existe retorna la 
    / cantidad de coincidencias
     */
    public int validaCorreoEmpleado(String correo) {
        EmpleadoModel em = new EmpleadoModel();
        return em.validaCorreoEmpleado(correo);
    }

    /*
    / Validamos si existe el correo
    / enviamos el correo 
    / en caso que existe retorna la 
    / cantidad de coincidencias
     */
    public String Actualizamos_foto_empleado(String foto, int empleado) {
        EmpleadoModel em = new EmpleadoModel();
        return em.Actualizamos_foto_empleado(foto, empleado);
    }
    /*
    / Traeremos el Correo electronico con el que se registro al personal
    / Esto nos servira para poder traer su correo y poder crear un usuario
    / nesecitamos
    / @Usuario_id
    */
    public String GetMailUsuario(int Usuario_id){
        EmpleadoModel uop = new EmpleadoModel();
        return uop.GetMailUsuario_id(Usuario_id);
    }
}
