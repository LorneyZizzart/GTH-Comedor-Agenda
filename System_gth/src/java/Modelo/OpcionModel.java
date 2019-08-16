package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Opcion;
import Entidad.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpcionModel {

    public String EliminaOpcionByidMenu(int id) {
        String eliman = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM Opcion \n"
                    + "      WHERE Menu_id = " + id;
            ResultSet res = db.borrar(sql);
            db.cierraConexion();
            eliman = "Ok";

        } catch (SQLException e) {
            eliman = "Modelo.OpcionModel.EliminaOpcion() " + e.getMessage();
            System.out.println(eliman);
        }
        return eliman;
    }

    public String EliminaOpcionByidOpcion(int id) {
        String eliman = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM Opcion \n"
                    + "      WHERE Opcion_id = " + id;
            ResultSet res = db.borrar(sql);
            db.cierraConexion();
            eliman = "Ok";

        } catch (SQLException e) {
            eliman = "Modelo.OpcionModel.EliminaOpcion() " + e.getMessage();
            System.out.println(eliman);
        }
        return eliman;
    }

    public List<Opcion> GetAllOpciones() {
        List<Opcion> opciones = new ArrayList<Opcion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT o.Opcion_id, o.Nombre, o.Url, o.Descriocion, o.Estado, o.Orden, o.Menu_id, m.Nombre as Nombre_menu\n"
                    + "  FROM Opcion o \n"
                    + "	   Inner join Menu m\n"
                    + "	   on o.Menu_id = m.Menu_id\n"
                    + "	   order by m.Posicion, o.Orden";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Opcion o = new Opcion();
                o.setOpcion_id(res.getInt("Opcion_id"));
                o.setNombre(res.getString("Nombre"));
                o.setUrl(res.getString("Url"));
                o.setDescriocion(res.getString("Descriocion"));
                o.setEstado(res.getInt("Estado"));
                o.setOrden(res.getInt("Orden"));
                o.setMenu_id(res.getInt("Menu_id"));
                o.setNombre_menu(res.getString("Nombre_menu"));
                opciones.add(o);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.OpcionModel.GetAllOpciones()" + e.getMessage());
        }
        return opciones;
    }

    public Opcion GetOpcionById(int id) {
        Opcion o = new Opcion();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT o.Opcion_id, o.Nombre, o.Url, o.Descriocion, o.Estado, o.Orden, o.Menu_id, m.Nombre as Nombre_menu\n"
                    + "  FROM Opcion o \n"
                    + "	   Inner join Menu m\n"
                    + "	   on o.Menu_id = m.Menu_id\n"
                    + "	   where o.Opcion_id ='" + id + "' order by m.Posicion, o.Orden";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                o.setOpcion_id(res.getInt("Opcion_id"));
                o.setNombre(res.getString("Nombre"));
                o.setUrl(res.getString("Url"));
                o.setDescriocion(res.getString("Descriocion"));
                o.setEstado(res.getInt("Estado"));
                o.setOrden(res.getInt("Orden"));
                o.setMenu_id(res.getInt("Menu_id"));
                o.setNombre_menu(res.getString("Nombre"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.OpcionModel.GetAllOpcionById()" + e.getMessage());
        }
        return o;
    }

    public String InsertUpdateOpcion(Opcion opcion) {
        String respuesta = "";
        try {
            if (opcion.getOpcion_id() == 0) {
                //realiza la insercion 
                respuesta = InsertaOpcion(opcion);
            } else {
                //realiza la actualizacion
                respuesta = UpdateOpcion(opcion);
            }
        } catch (Exception e) {
            System.out.println("Modelo.OpcionModel.InsertUpdateOpcion() " + e.getMessage());
        }
        return respuesta;
    }

    private String InsertaOpcion(Opcion opcion) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "INSERT INTO Opcion(Nombre, Url, Descriocion, Estado, Orden, Menu_id)\n"
                    + "     VALUES ('" + opcion.getNombre() + "', '" + opcion.getUrl() + "', '" + opcion.getDescriocion() + "', '" + opcion.getEstado() + "', '" + opcion.getOrden() + "', '" + opcion.getMenu_id() + "') ";
            db.insertar(Sql);
            db.cierraConexion();
            mensaje = "Ok";
        } catch (SQLException e) {
            mensaje = "Modelo.OpcionModel.InsertaOpcion() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    private String UpdateOpcion(Opcion op) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "UPDATE Opcion \n"
                    + "   SET Nombre = '" + op.getNombre() + "'\n"
                    + "      ,Url = '" + op.getUrl() + "'\n"
                    + "      ,Descriocion = '" + op.getDescriocion() + "'\n"
                    + "      ,Estado = '" + op.getEstado() + "'\n"
                    + "      ,Orden = '" + op.getOrden() + "'\n"
                    + "      ,Menu_id = '" + op.getMenu_id() + "'\n"
                    + " WHERE Opcion_id = '" + op.getOpcion_id() + "'";
            db.actualizar(Sql);
            db.cierraConexion();
            mensaje = "Ok";
        } catch (SQLException e) {
            mensaje = "Modelo.OpcionModel.UpdateOpcion() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<Usuario> EliminarOpcion(int id) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "Select u.User_id, u.Usuario, u.email, u.Estado, u.Perfil	\n"
                    + "from Usuario_opcion uo \n"
                    + "	inner join Usuario u\n"
                    + "	on uo.User_id = u.User_id\n"
                    + "where uo.Opcion_id = '" + id + "'";
            ResultSet res = db.consulta(Sql);
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
                String eliminaOpcion = opcion.EliminaOpcionByidOpcion(id);

            }
            db.cierraConexion();

        } catch (SQLException e) {
            System.out.println("Modelo.OpcionModel.EliminarOpcion() " + e.getMessage());
        }
        return usuarios;
    }

    public List<Opcion> GetAllOpcionesByMenu_id(int menuId) {
        List<Opcion> opciones = new ArrayList<Opcion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT o.Opcion_id, o.Nombre, o.Url, o.Descriocion, o.Estado, o.Orden, o.Menu_id\n"
                    + "FROM Opcion o where o.Menu_id = '"+menuId+"' order by o.Orden ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Opcion o = new Opcion();
                o.setOpcion_id(res.getInt("Opcion_id"));
                o.setNombre(res.getString("Nombre"));
                o.setUrl(res.getString("Url"));
                o.setDescriocion(res.getString("Descriocion"));
                o.setEstado(res.getInt("Estado"));
                o.setOrden(res.getInt("Orden"));
                o.setMenu_id(res.getInt("Menu_id"));
                opciones.add(o);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.OpcionModel.GetAllOpcionesByMenu_id()" + e.getMessage());
        }
        return opciones;
    }
}
