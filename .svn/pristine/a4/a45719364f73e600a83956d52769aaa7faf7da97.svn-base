package Controlador;

import Entidad.Usuario_opcion;
import Modelo.Usuario_opcionModelo;
import java.util.List;

public class Usuario_opcionController {

    public List<Usuario_opcion> GetAllUsuarioOpcionByUser_id(int user_id) {
        Usuario_opcionModelo uop = new Usuario_opcionModelo();
        return uop.GetAllUsuarioOpcionByUser_id(user_id);
    }

    /*
    /    Eliminamos una opcion del usuario
    /    requerimos para esto 
    /    el Opcion_id y User_id para poder eliminar
     */
    public String DeleteUsuario_opcion(String user_id, String opcion_id) {
        Usuario_opcionModelo uop = new Usuario_opcionModelo();
        return uop.DeleteUsuario_opcion(user_id, opcion_id);
    }

    /*
    /    Agregamos una opcion al usuario
    /    requerimos para esto 
    /    el Opcion_id y User_id para poder añadir una opcion 
     */
    public String CreateUsuario_opcion(String user_id, String opcion_id) {
        Usuario_opcionModelo uop = new Usuario_opcionModelo();
        return uop.CreateUsuario_opcion(user_id, opcion_id);
    }

    
}
