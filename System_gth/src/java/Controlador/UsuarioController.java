package Controlador;

import Entidad.Usuario;
import Modelo.UsuarioModel;
import java.util.List;

public class UsuarioController {

    /*
    / Realiza un listado de todos 
    / los usuarios que se encuentran 
    / registrados
     */
    public List<Usuario> GetAllUser() {
        UsuarioModel u = new UsuarioModel();
        return u.GetAllUser();
    }
    
    public List<Usuario> getAllByDepartamento(int idDepartamento) {
        UsuarioModel u = new UsuarioModel();
        return u.getAllByDepartamento(idDepartamento);
    }

    /*
    / Validamos si existe el correo
    / enviamos el correo 
    / en caso que existe retorna la 
    / cantidad de coincidencias
     */
    public int validaCorreo(String correo) {
        UsuarioModel u = new UsuarioModel();
        return u.validaCorreo(correo);
    }

    /*
    / Retorna objeto Usuario
    / con los siguientes paramerotro
    / para poder realizar la actualizacion
    / de datos del Usuario
    / @Usuario
    / Nombre
    / User_id
    / Usuario
    / Perfil
    / email
    / Estado
     */
    public Usuario GetDatosParaActualizarByUser_id(int IdUsuario) {
        UsuarioModel u = new UsuarioModel();
        return u.GetDatosParaActualizarByUser_id(IdUsuario);
    }

    /*
    / Actualizamos datos del Usuario
    / para poder realizar la actualizacion
    / de datos nesecitamos lis siguietnes parámetros
    / @Usuario    
    / User_id
    / Usuario
    / Perfil
    / email
    / Estado
     */
    public String UpdateUserDatosPersonales(Usuario usuario) {
        UsuarioModel u = new UsuarioModel();
        return u.UpdateUserDatosPersonales(usuario);
    }

    /*
    / Actualizamos la contraseña
    / para esto nesecitamso los siguites parametos
    / @Usuario
    / User_id
    / Contrana
     */
    public String UpdatePassword(Usuario usuario) {
        UsuarioModel u = new UsuarioModel();
        return u.UpdatePassword(usuario);
    }

    /*
    / Retorna un numero entero en caso que exista el usuario
    / se realiza la busqueda por Empleado_id    
    / Retorna = 0 si no exsiste el usuario
    / Retorna > 0 en caso que exista
     */
    public int ExistsUserbyEmpleado_id(int id) {
        UsuarioModel uop = new UsuarioModel();
        return uop.ExistsUserbyEmpleado_id(id);
    }

    /*
    / para crear un usuario nesecitamos los siguientes parametros
    / @Usuario
    / Usuario
    / Contrasena
    / email     
    / Estado
    / Empleado_id
    / Perfil    
     */
    public String CreateUsuario(Usuario usuario){
        UsuarioModel uop = new UsuarioModel();
        return uop.CreateUsuario(usuario);
    }
    
    /*
    / Eliminamos Ususario
    / Validamos que notenga registros en otras tablas
    / En caso que no relacion con otra tabla Retorna Ok
    / En caso que si tenga relacion con otras tablas retorna un mensaje 
    / con las tablas relacionadas
    / Parametro requerido 
    / @Usuario_id
    */
    public String DeleteUsuario(int Usuario_id){
        UsuarioModel uop = new UsuarioModel();
        return uop.DeleteUsuario(Usuario_id);
    }
    
    
}
