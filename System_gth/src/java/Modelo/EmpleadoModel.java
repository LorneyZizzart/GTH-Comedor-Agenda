package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoModel {

    public List<Empleado> GetAllEmpleadoNotUser() {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select e.Empleado_id ,e.Nombre,e.Apellido_paterno,e.Apellido_materno\n"
                    + "from Empleado e \n"
                    + "where e.Empleado_id not in(select u.Empleado_id from Usuario u)";

            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("Nombre"));
                empleados.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.EmpleadoModel.GetAllEmpleadoNotUser()" + e.getMessage());
        }
        return empleados;
    }

    public List<Empleado> GetAllEmpleado() {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id, e.Pais_id,\n"
                    + "ec.Nombre Estado_civil_Nombre, p.PaisNombre\n"
                    + "  FROM Empleado e\n"
                    + "  inner join Estado_civil ec \n"
                    + "  on e.Estado_civil_id = ec.Estado_civil_id\n"
                    + "  inner join Pais p\n"
                    + "  on e.Pais_id = p.Pais_id";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre(res.getString("Nombre"));
                e.setApellido_paterno(res.getString("Apellido_paterno"));
                e.setApellido_materno(res.getString("Apellido_materno"));
                e.setEmail(res.getString("email"));
                e.setFecha_nacimiento(res.getString("Fecha_nacimiento"));
                e.setTelefono(res.getString("Telefono"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setEstado(res.getInt("Estado"));
                e.setEstado_civil_id(res.getInt("Estado_civil_id"));
                e.setPais_id(res.getString("Pais_id"));
                e.setEstado_civil_Nombre(res.getString("Estado_civil_Nombre"));
                e.setPaisNombre(res.getString("PaisNombre"));

                Empleado_cargoModel cargo = new Empleado_cargoModel();
                e.setCargo(cargo.GetEmpleadoCargoByIdEmpleado(e.getEmpleado_id()));

                empleados.add(e);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.EmpleadoModel.GetAllEmpleado()" + e.getMessage());
        }
        return empleados;
    }

    public String CreateEmpleado(Empleado em) {
        String respuesta = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Empleado(Nombre, Apellido_paterno, Apellido_materno, email, \n"
                    + "			       Telefono, Fecha_creacion, Estado,\n"
                    + "                        Estado_civil_id,Pais_id)\n"
                    + "     VALUES('" + em.getNombre() + "','" + em.getApellido_paterno() + "','" + em.getApellido_materno() + "','" + em.getEmail().trim() + "',\n"
                    + "			'" + em.getTelefono() + "', CONVERT(date, SYSDATETIME()),'" + em.getEstado() + "',\n"
                    + "			'" + em.getEstado_civil_id() + "','" + em.getPais_id() + "')";
            db.insertar(sql);
            int Empleado_id = GetLastEmpleadoID();
            em.getCargo().setEmpleado_id(Empleado_id);
            Empleado_cargoModel emple_cargo = new Empleado_cargoModel();
            respuesta = emple_cargo.CreateEmpleadoCargo(em.getCargo());
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.EmpleadoModel.CreateEmpleado()" + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public int GetLastEmpleadoID() {
        int id = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select max(Empleado_id) id from Empleado ";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getInt("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.EmpleadoModel.GetLastEmpleadoID() " + e.getMessage());
        }
        return id;
    }

    public Empleado GetEmpleadoByID(int codigo) {
        Empleado e = new Empleado();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id, e.Pais_id,\n"
                    + "ec.Nombre Estado_civil_Nombre, p.PaisNombre, e.Foto \n"
                    + "  FROM Empleado e\n"
                    + "  inner join Estado_civil ec \n"
                    + "  on e.Estado_civil_id = ec.Estado_civil_id\n"
                    + "  inner join Pais p\n"
                    + "  on e.Pais_id = p.Pais_id where e.Empleado_id = '" + codigo + "' ";
            System.out.println("--- " + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre(res.getString("Nombre"));
                e.setApellido_paterno(res.getString("Apellido_paterno"));
                e.setApellido_materno(res.getString("Apellido_materno"));
                e.setEmail(res.getString("email"));
                e.setFecha_nacimiento(res.getString("Fecha_nacimiento"));
                e.setTelefono(res.getString("Telefono"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setEstado(res.getInt("Estado"));
                e.setEstado_civil_id(res.getInt("Estado_civil_id"));
                e.setPais_id(res.getString("Pais_id"));
                e.setEstado_civil_Nombre(res.getString("Estado_civil_Nombre"));
                e.setPaisNombre(res.getString("PaisNombre"));
                e.setFoto(res.getString("Foto"));
            } else {
                e = null;
            }
            db.cierraConexion();
        } catch (SQLException er) {
            System.out.println("Modelo.EmpleadoModel.GetAllEmpleado()" + er.getMessage());
        }
        return e;
    }

    public String UpdateEmpleado(Empleado empleado) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Empleado\n"
                    + "   SET Nombre = '" + empleado.getNombre() + "'\n"
                    + "      ,Apellido_paterno = '" + empleado.getApellido_paterno() + "'\n"
                    + "      ,Apellido_materno = '" + empleado.getApellido_materno() + "'\n"
                    + "      ,email ='" + empleado.getEmail().trim() + "'      \n"
                    + "      ,Telefono = '" + empleado.getTelefono() + "'     \n"
                    + "      ,Estado = '" + empleado.getEstado() + "'\n"
                    + "      ,Estado_civil_id = '" + empleado.getEstado_civil_id() + "'\n"
                    + "      ,Pais_id = '" + empleado.getPais_id() + "'\n"
                    + " WHERE Empleado_id = '" + empleado.getEmpleado_id() + "'";
            db.actualizar(sql);
            resultado = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            resultado = "Modelo.EmpleadoModel.UpdateEmpleado() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    public String deleteEmpldeado(int id) {
        String result = "";
        try {
            // Verificamos cantidad de cargo
            Empleado_cargoModel cargo = new Empleado_cargoModel();
            int cantidad_cargo = cargo.GetAllEnpleado_cargoByEmpleadoId(id).size();
            if (cantidad_cargo > 0) {
                result = result + " Este usuario tiene " + cantidad_cargo + " cargo.<br>";
            }

            // validamos cantidad usuario
            UsuarioModel usuario = new UsuarioModel();
            int cantidad_usuario = usuario.ExistsUserbyEmpleado_id(id);
            if (cantidad_usuario > 0) {
                result = result + " Este usuario tiene " + cantidad_usuario + " cuenta de Usuario.<br>";
            }
            // Validamos si realiza reserva
            CEmpleado_reservaModel reserva = new CEmpleado_reservaModel();
            int cantidad_reserva = reserva.CantidaReservas(id);
            if (cantidad_reserva > 0) {
                result = result + " Este usuario tiene " + cantidad_reserva + " Reservas.<br>";
            }

            int total = cantidad_cargo + cantidad_usuario + cantidad_reserva;
            if (total == 0) {
                System.out.println("Eliminamos");
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "DELETE FROM Empleado\n"
                        + "      WHERE Empleado_id = '" + id + "'";
                db.insertar(sql);
                result = "Ok";
                db.cierraConexion();
            } else {
                System.out.println("No Eliminamos " + result);
            }

        } catch (SQLException ex) {
            result = "Modelo.EmpleadoModel.deleteEmpldeado() " + ex.getMessage();
            System.out.println(result);
        }
        return result;
    }

    public int validaCorreoEmpleado(String correo) {
        int cantidad = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select count(*) cantidad from Empleado where email = '" + correo.trim() + "'";
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

    public String Actualizamos_foto_empleado(String foto, int empleado) {
        String resultado = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Empleado\n"
                    + "   SET Foto = '" + foto + "'\n"
                    + " WHERE Empleado_id  ='" + empleado + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            resultado = "Modelo.EmpleadoModel.Actualizamos_foto_empleado() " + e.getMessage();
            System.err.println(resultado);
        }
        return resultado;
    }

    public String GetMailUsuario_id(int Usuario_id) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select email from empleado User_id where Empleado_id = '" + Usuario_id + "'";
            System.out.println(" correo: " + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                resultado = res.getString("email");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            resultado = "Modelo.UsuarioModel.GetMailUsuario() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

}
