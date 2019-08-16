package Controlador;

import Entidad.Login_Entidad;
import Entidad.Menu;
import Modelo.LoginModel;
import java.util.List;

public class LoginController {

    public Login_Entidad Iniciar_sesion(String usuario, String contrasena) {
        LoginModel login = new LoginModel();
        return login.Iniciar_sesion(usuario, contrasena);
    }

    public List<Menu> MenuUsuario(int codigo_usuario) {
        LoginModel login = new LoginModel();
        return login.MenuUsuario(codigo_usuario);
    }

    /*
    / Solo se utilizara esto para la validacion de un usuario 
    / que realizara la evaluacion. Para esto se requieres enviar un id
    / @Cuestionario_evalua_id
    / donde optenemos el valor de Evalua_empleado_id de la tabla Cuestionario_evalua
    / que nos servira de referencia para poder obtener los datos del evaluador
     */
    public Login_Entidad evaluacion_login(int id) {
        LoginModel login = new LoginModel();
        return login.evaluacion_login(id);
    }
}
