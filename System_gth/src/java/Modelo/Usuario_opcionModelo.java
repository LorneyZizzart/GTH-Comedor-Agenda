package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Usuario_opcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuario_opcionModelo {

    public List<Usuario_opcion> GetAllUsuarioOpcionByUser_id(int user_id) {
        List<Usuario_opcion> opciones = new ArrayList<Usuario_opcion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select User_id, Opcion_id, Fecha_creacion\n"
                    + "from usuario_opcion where User_id = '"+user_id+"' ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Usuario_opcion op = new Usuario_opcion();
                op.setFecha_creacion(res.getString("Fecha_creacion"));
                op.setOpcion_id(res.getInt("Opcion_id"));
                op.setUser_id(res.getInt("User_id"));
                opciones.add(op);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Usuario_opcionModelo.GetAllUsuarioOpcionByUser_id() " + e.getMessage());
        }
        return opciones;
    }

    public String DeleteUsuario_opcion(String user_id, String opcion_id) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = " DELETE FROM Usuario_opcion \n"
                    + " WHERE User_id = '" + user_id + "' and Opcion_id = '" + opcion_id + "'";
            db.insertar(sql);
            resultado = "Ok";
            db.cierraConexion();
        } catch (SQLException ex) {
            resultado = "Modelo.Usuario_opcionModelo.DeleteUsuario_opcion() " + ex.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    public String CreateUsuario_opcion(String user_id, String opcion_id) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Usuario_opcion\n"
                    + "           (Fecha_creacion\n"
                    + "           ,User_id\n"
                    + "           ,Opcion_id)\n"
                    + "     VALUES\n"
                    + "           (CONVERT(date, SYSDATETIME())\n"
                    + "		   ,'" + user_id + "'\n"
                    + "		   ,'" + opcion_id + "')";
            db.insertar(sql);
            resultado = "Ok";
            db.cierraConexion();
        } catch (SQLException ex) {
            resultado = "Modelo.Usuario_opcionModelo.CreateUsuario_opcion() " + ex.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    
}
