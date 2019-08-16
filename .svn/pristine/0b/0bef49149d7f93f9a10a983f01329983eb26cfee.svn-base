package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Menu;
import Entidad.Opcion;
import Entidad.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuModel {
    
    public List<Menu> getAllMenu() {
        List<Menu> Menus = new ArrayList<Menu>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Menu_id, Nombre, Url, Estado, Posicion, Icono\n"
                    + "FROM    Menu order by Posicion";
            
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Menu menu = new Menu();
                menu.setMenu_id(res.getInt("Menu_id"));
                menu.setNombre(res.getString("Nombre"));
                menu.setUrl(res.getString("Url"));
                menu.setEstado(res.getInt("Estado"));
                menu.setPosicion(res.getInt("Posicion"));
                menu.setIcono(res.getString("Icono"));
                Menus.add(menu);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.MenuModel.getAllenu() " + e.getMessage());
        }
        return Menus;
    }
    
    public Menu getMenuById(int id) {
        Menu menu = new Menu();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT	Menu_id, Nombre, Url, Estado, Posicion, Icono\n"
                    + "FROM    Menu WHERE Menu_id = '" + id + "' ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                menu.setMenu_id(res.getInt("Menu_id"));
                menu.setNombre(res.getString("Nombre"));
                menu.setUrl(res.getString("Url"));
                menu.setEstado(res.getInt("Estado"));
                menu.setPosicion(res.getInt("Posicion"));
                menu.setIcono(res.getString("Icono"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.MenuModel.getMenuById()" + e.getMessage());
        }
        return menu;
    }
    
    public String Menu_guarda_actualiza(Menu menu) {
        String retorna = "";
        try {
            if (menu.getMenu_id() == 0) {
                retorna = Crear_menu(menu);
            } else {
                retorna = Actualiza_menu(menu);
            }
        } catch (Exception e) {
            retorna = e.getMessage();
            System.out.println(e.getMessage());
        }
        return retorna;
    }
    
    public String Crear_menu(Menu menu) {
        String respuesta = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Menu (Nombre, Url, Estado,Posicion,Icono)\n"
                    + "VALUES('" + menu.getNombre() + "','#','" + menu.getEstado() + "','" + menu.getPosicion() + "','" + menu.getIcono() + "')";
            db.insertar(sql);
            db.cierraConexion();
            respuesta = "Ok";
        } catch (SQLException e) {
            respuesta = "Modelo.MenuModel.Crear_menu() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    public String Actualiza_menu(Menu menu) {
        String respuesta = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "update Menu set Nombre = '" + menu.getNombre() + "' ,\n"
                    + "	   Url ='" + menu.getUrl() + "',\n"
                    + "	   Estado = '" + menu.getEstado() + "',\n"
                    + "	   Posicion ='" + menu.getPosicion() + "',\n"
                    + "	   Icono ='" + menu.getIcono() + "'\n"
                    + "	   where Menu_id='" + menu.getMenu_id() + "'";
            db.actualizar(sql);
            db.cierraConexion();
            respuesta = "Ok";
        } catch (SQLException e) {
            respuesta = "Modelo.MenuModel.Crear_menu() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    public List<Usuario> Elimina(int id) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select u.User_id, u.Usuario, u.Contrasena, u.email, u.Estado, u.Perfil\n"
                    + "from Menu me\n"
                    + "inner join Opcion op\n"
                    + "on me.Menu_id = op.Menu_id\n"
                    + "inner join Usuario_opcion uo\n"
                    + "on op.Opcion_id = uo.Opcion_id\n"
                    + "inner join Usuario u\n"
                    + "on u.User_id = uo.User_id\n"
                    + "where me.Menu_id = " + id + " \n"
                    + "group by u.User_id, u.Usuario, u.Contrasena, u.email, u.Estado, u.Perfil";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Usuario u = new Usuario();
                u.setUser_id(res.getInt("User_id"));
                u.setUsuario(res.getString("Usuario"));
                u.setEmail(res.getString("email"));
                u.setEstado(Integer.parseInt(res.getString("Estado")));
                u.setPerfil(res.getString("Perfil"));
                usuarios.add(u);
            }
            if (usuarios.isEmpty()) {
                //Eliminaros opciones
                OpcionModel opcion = new OpcionModel();
                String eliminaOpcion = opcion.EliminaOpcionByidMenu(id);
                //eliminamos menu
                String EliminaMenu = eliminaMenubyId(id);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.MenuModel.Elimina()" + e.getMessage());
        }
        return usuarios;
    }
    
    public String eliminaMenubyId(int id) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM Menu \n"
                    + "      WHERE Menu_id =" + id;
            ResultSet res = db.borrar(sql);
            resultado = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            resultado = "Modelo.MenuModel.eliminaMenubyId() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }
    
    public List<Menu> getAllMenuAndOpcion() {
        List<Menu> menus = new ArrayList<Menu>();
        try {
            menus = getAllMenu();
            for (Menu item : menus) {
                OpcionModel opcion = new OpcionModel();
                List<Opcion> opciones = new ArrayList<Opcion>();
                opciones = opcion.GetAllOpcionesByMenu_id(item.getMenu_id());
                item.setOpciones(opciones);
            }
            
        } catch (Exception ex) {
            System.out.println("Modelo.MenuModel.getAllMenuAndOpcion() " + ex.getMessage());
        }
        return menus;
    }
    
}
