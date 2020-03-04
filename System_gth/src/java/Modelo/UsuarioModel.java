package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Usuario;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {

    public List<Usuario> GetAllUser() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select u.User_id, e.Empleado_id, u.Usuario, u.email, u.Perfil, u.Estado, e.Nombre, e.Apellido_paterno, e.Apellido_materno, 1 as funcionario\n" +
                         "From Usuario u \n" +
                         "inner join Empleado  e \n" +
                         "on e.Empleado_id = u.Empleado_id order by u.Usuario";
            
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Usuario u = new Usuario();
                u.setUser_id(res.getInt("User_id"));
                u.setEmpleado_id(res.getInt("Empleado_id"));
                u.setUsuario(res.getString("Usuario"));
                u.setEmail(res.getString("email"));
                u.setPerfil(res.getString("Perfil"));
                u.setEstado(res.getInt("Estado"));
                u.setFuncionario(res.getInt("funcionario"));
                u.setNombre(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("Nombre"));
                usuarios.add(u);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.UsuarioModel.GetAllUser() " + e.getMessage());
        }
        return usuarios;
    }
    
    public List<Usuario> getAllByDepartamento(int idDepartamento) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT us.User_id, em.Empleado_id, em.Apellido_paterno, em.Apellido_materno, em.Nombre\n" +
                        "FROM Departamento de, Empleado_cargo ec, Empleado em, Usuario us\n" +
                        "WHERE us.Empleado_id = em.Empleado_id\n" +
                        "AND em.Empleado_id = ec.Empleado_id\n" +
                        "AND ec.Departamento_id = de.Departamento_id\n" +
                        "AND em.Estado <> 6\n" +
                        "AND de.Departamento_id = " + idDepartamento + "\n"+
                        "ORDER BY em.Apellido_paterno ASC";
            
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Usuario u = new Usuario();
                u.setUser_id(res.getInt("User_id"));
                u.setEmpleado_id(res.getInt("Empleado_id"));
                u.setNombre(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("Nombre"));
                usuarios.add(u);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.UsuarioModel.GetAllUser() " + e.getMessage());
        }
        return usuarios;
    }

    public int validaCorreo(String correo) {
        int cantidad = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select count(*) cantidad from Usuario where email = '" + correo + "'";
            System.out.println(sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                cantidad = res.getInt("cantidad");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.UsuarioModel.validaCorreo() " + e.getMessage());
        }
        return cantidad;
    }

    public Usuario GetDatosParaActualizarByUser_id(int IdUsuario) {
        Usuario usuario = new Usuario();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select u.User_id,u.Usuario, u.Perfil, u.email, u.Estado, CONCAT(e.Nombre,' ', e.Apellido_paterno,' ', e.Apellido_materno) Nombre\n"
                    + "from Usuario u\n"
                    + "	inner join Empleado e\n"
                    + "	on u.Empleado_id = e.Empleado_id\n"
                    + "where u.User_id = '" + IdUsuario + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                usuario.setUser_id(res.getInt("User_id"));
                usuario.setUsuario(res.getString("Usuario"));
                usuario.setPerfil(res.getString("Perfil"));
                usuario.setEmail(res.getString("email"));
                usuario.setEstado(res.getInt("Estado"));
                usuario.setNombre(res.getString("Nombre"));
            }
            db.cierraConexion();
        } catch (SQLException ex) {
            System.out.println("Modelo.UsuarioModel.GetDatosParaActualizarByUser_id() " + ex.getMessage());
        }
        return usuario;
    }

    public String UpdateUserDatosPersonales(Usuario usuario) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Usuario\n"
                    + "   SET Usuario = '" + usuario.getUsuario() + "'\n"
                    + "      ,email = '" + usuario.getEmail() + "'\n"
                    + "      ,Estado = '" + usuario.getEstado() + "'\n"
                    + "      ,Perfil = '" + usuario.getPerfil() + "'\n"
                    + "WHERE User_id = '" + usuario.getUser_id() + "'";
            db.actualizar(sql);
            mensaje = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.UsuarioModel.UpdateUserDatosPersonales() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String UpdatePassword(Usuario usuario) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Usuario\n"
                    + "   SET Contrasena = '" + usuario.getContrasena() + "'     \n"
                    + " WHERE User_id = '" + usuario.getUser_id() + "'";
            db.actualizar(sql);
            db.cierraConexion();
            mensaje = "Ok";
        } catch (Exception e) {
            mensaje = "Modelo.UsuarioModel.UpdatePassword() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public int ExistsUserbyEmpleado_id(int id) {
        int existe = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select COUNT(*) existe from Usuario where Empleado_id = '" + id + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                existe = res.getInt("existe");
            }
            db.cierraConexion();
        } catch (SQLException ex) {
            System.out.println("Modelo.Usuario_opcionModelo.ExistsUserbyEmpleado_id() " + ex.getMessage());
        }
        return existe;
    }

    public String CreateUsuario(Usuario usuario) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Usuario(Usuario, Contrasena, email, Fecha_creacion, Estado, Empleado_id, Perfil)\n"
                    + "     VALUES('" + usuario.getUsuario() + "','" + usuario.getContrasena() + "','" + usuario.getEmail() + "',CONVERT(date, SYSDATETIME()),'" + usuario.getEstado() + "','" + usuario.getEmpleado_id() + "','" + usuario.getPerfil() + "')";
            db.insertar(sql);
            resultado = "Ok";
            db.cierraConexion();
        } catch (SQLException ex) {
            resultado = "Modelo.UsuarioModel.CreateUsuario() " + ex.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    public String DeleteUsuario(int Usuario_id) {
        String resultado = "";
        try {
            //validamos si tiene opciones
            Usuario_opcionModelo opciones = new Usuario_opcionModelo();
            int total_opciones = opciones.GetAllUsuarioOpcionByUser_id(Usuario_id).size();
            if (total_opciones > 0) {
                resultado = resultado + " Este usuario tiene " + total_opciones + " opciones.";
            }

            int total = total_opciones;
            if (total == 0) {
                System.err.println("Eliminamos ");
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "DELETE FROM Usuario\n"
                        + "      WHERE User_id = '" + Usuario_id + "'";
                db.insertar(sql);
                resultado = "Ok";
                db.cierraConexion();
            } else {
                System.err.println("No Eliminamos " + resultado);
            }

        } catch (SQLException e) {
            resultado = "Modelo.UsuarioModel.DeleteUsuario() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    

}
