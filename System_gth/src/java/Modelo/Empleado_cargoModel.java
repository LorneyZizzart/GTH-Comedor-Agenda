package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Empleado_cargo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Empleado_cargoModel {

    public List<Empleado_cargo> GetAllEmpleadoCargo() {
        List<Empleado_cargo> cargos = new ArrayList<Empleado_cargo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select ec.Empleado_id, ec.Departamento_id, ec.Nivel_id, ec.Cargo, ec.Fecha_inicio, ec.Fecha_fin, ec.Activo, ec.Fecha_creacion, ec.Id,\n"
                    + "		d.Nombre Departamento_Nombre, n.Nombre Nivel_Nombre, CONCAT(e.Nombre,' ',e.Apellido_paterno,' ',e.Apellido_materno) Empleado_Nombre\n"
                    + " from Empleado_cargo ec\n"
                    + "	inner join Departamento d\n"
                    + "	on ec.Departamento_id = d.Departamento_id\n"
                    + "	inner join Nivel n\n"
                    + "	on ec.Nivel_id = n.Nivel_id\n"
                    + "	inner join Empleado e\n"
                    + "	on ec.Empleado_id = e.Empleado_id";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado_cargo e = new Empleado_cargo();
                e.setId(res.getInt("Id"));
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setDepartamento_id(res.getInt("Departamento_id"));
                e.setNivel_id(res.getInt("Nivel_id"));
                e.setCargo(res.getString("Cargo"));
                e.setFecha_inicio(res.getString("Fecha_inicio"));
                e.setFecha_fin(res.getString("Fecha_fin"));
                e.setActivo(res.getInt("Activo"));
                e.setFecha_creacion(res.getDate("Fecha_creacion"));
                e.setDepartamento_nombre(res.getString("Departamento_Nombre"));
                e.setNivel_nombre(res.getString("Nivel_Nombre"));
                e.setEmpleado_nombre(res.getString("Empleado_Nombre"));
                cargos.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_cargoModel.GetAllEmpleadoCargo() " + e.getMessage());
        }
        return cargos;
    }

    public Empleado_cargo GetEmpleadoCargoByIdEmpleado(int empladoId) {
        Empleado_cargo e = new Empleado_cargo();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select ec.Empleado_id, ec.Departamento_id, ec.Nivel_id, ec.Cargo, ec.Fecha_inicio, ec.Fecha_fin, ec.Activo, ec.Fecha_creacion, ec.Id,\n"
                    + "		d.Nombre Departamento_Nombre, n.Nombre Nivel_Nombre, CONCAT(e.Nombre,' ',e.Apellido_paterno,' ',e.Apellido_materno) Empleado_Nombre, c.Cargo_id, c.Nombre\n"
                    + " from Empleado_cargo ec\n"
                    + "	inner join Departamento d\n"
                    + "	on ec.Departamento_id = d.Departamento_id\n"
                    + "	inner join Nivel n\n"
                    + "	on ec.Nivel_id = n.Nivel_id\n"
                    + "	inner join Empleado e\n"
                    + "	on ec.Empleado_id = e.Empleado_id "
                    + " inner join Cargo c\n"
                    + "	on ec.Cargo_id = c.Cargo_id"
                    + " where ec.Activo = '1' and ec.Empleado_id = '" + empladoId + "' ";
            System.out.println(" --- ---  " + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                e.setId(res.getInt("Id"));
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setDepartamento_id(res.getInt("Departamento_id"));
                e.setNivel_id(res.getInt("Nivel_id"));
                e.setCargo(res.getString("Cargo"));
                e.setFecha_inicio(res.getString("Fecha_inicio"));
                e.setFecha_fin(res.getString("Fecha_fin"));
                e.setActivo(res.getInt("Activo"));
                e.setFecha_creacion(res.getDate("Fecha_creacion"));
                e.setDepartamento_nombre(res.getString("Departamento_Nombre"));
                e.setNivel_nombre(res.getString("Nivel_Nombre"));
                e.setEmpleado_nombre(res.getString("Empleado_Nombre"));
                e.setCargo_id(res.getInt("Cargo_id"));
                e.setCargo_nombre(res.getString("Nombre"));
            } else {
                e = null;
            }
            db.cierraConexion();
        } catch (SQLException ex) {
            System.out.println("Modelo.Empleado_cargoModel.GetEmpleadoCargoByIdEmpleado() " + ex.getMessage());
        }
        return e;
    }

    public String DateConvertInsertSQL(String date) {
        if (!date.equals(null)) {
            String[] datePart = date.split("/");
            System.out.print("'" + datePart[2] + "/" + datePart[1] + "/" + datePart[0] + "'");
            return "'" + datePart[2] + "/" + datePart[1] + "/" + datePart[0] + "'";
        }
        return null;
    }

    public String CreateEmpleadoCargo(Empleado_cargo empleado) {
        String respuesta = "";

        try {
            String concatena_campos = "";
            String concatema_valor = "";
            if (!ValidaEmpty(empleado.getFecha_inicio())) {
                concatena_campos = " , Fecha_inicio ";
                concatema_valor = "," + DateConvertInsertSQL(empleado.getFecha_inicio());
            }
            if (!ValidaEmpty(empleado.getFecha_fin())) {
                concatena_campos = concatena_campos + " , Fecha_fin ";
                concatema_valor = concatema_valor + ", " + DateConvertInsertSQL(empleado.getFecha_fin());
            } else {
            }

            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            InactivaEmpleadocargo(empleado.getEmpleado_id());
            String sql = "INSERT INTO Empleado_cargo(Empleado_id, Departamento_id, Nivel_id, \n"
                    + "						   Cargo,Activo, Fecha_creacion, Cargo_id " + concatena_campos + ")\n"
                    + "     VALUES('" + empleado.getEmpleado_id() + "','" + empleado.getDepartamento_id() + "','" + empleado.getNivel_id() + "',\n"
                    + "			'" + empleado.getCargo() + "','1', CONVERT(date, SYSDATETIME()), '" + empleado.getCargo_id() + "'  " + concatema_valor + ")";
            System.out.print("sql: "+sql);
            db.insertar(sql);

            respuesta = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Empleado_cargoModel.CreateEmpleadoCargo() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public void InactivaEmpleadocargo(int EmpleadoId) {
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Empleado_cargo\n"
                    + "   SET Activo = '0'\n"
                    + "WHERE Empleado_id = '" + EmpleadoId + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_cargoModel.InactivaEmpleadocargo() " + e.getMessage());
        }
    }

    public List<Empleado_cargo> GetAllEnpleado_cargoByEmpleadoId(int empleadoId) {
        List<Empleado_cargo> empleados = new ArrayList<Empleado_cargo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select ec.Empleado_id, ec.Departamento_id, ec.Nivel_id, ec.Cargo, CONVERT(VARCHAR(10),ec.Fecha_inicio, 103) Fecha_inicio , CONVERT(VARCHAR(10),ec.Fecha_fin, 103) Fecha_fin, ec.Activo, ec.Fecha_creacion, ec.Id,\n"
                    + "		d.Nombre Departamento_Nombre, n.Nombre Nivel_Nombre, CONCAT(e.Nombre,' ',e.Apellido_paterno,' ',e.Apellido_materno) Empleado_Nombre, c.Cargo_id , c.Nombre \n"
                    + "from Empleado_cargo ec\n"
                    + "inner join Departamento d\n"
                    + "on ec.Departamento_id = d.Departamento_id\n"
                    + "inner join Nivel n\n"
                    + "on ec.Nivel_id = n.Nivel_id\n"
                    + "inner join Empleado e\n"
                    + "on ec.Empleado_id = e.Empleado_id "
                    + "inner join Cargo c \n"
                    + "on ec.Cargo_id = c.Cargo_id \n"
                    + "where ec.Empleado_id = '" + empleadoId + "' order by ec.Fecha_inicio, ec.Activo  desc ";
            System.err.println(sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado_cargo em = new Empleado_cargo();
                em.setId(res.getInt("Id"));
                em.setEmpleado_id(res.getInt("Empleado_id"));
                em.setDepartamento_id(res.getInt("Departamento_id"));
                em.setNivel_id(res.getInt("Nivel_id"));
                em.setCargo(res.getString("Cargo"));
                em.setFecha_inicio(res.getString("Fecha_inicio"));
                em.setFecha_fin(res.getString("Fecha_fin"));
                em.setActivo(res.getInt("Activo"));
                em.setFecha_creacion(res.getDate("Fecha_creacion"));

                em.setDepartamento_nombre(res.getString("Departamento_Nombre"));
                em.setNivel_nombre(res.getString("Nivel_Nombre"));
                em.setEmpleado_nombre(res.getString("Empleado_Nombre"));

                em.setCargo_id(res.getInt("Cargo_id"));
                em.setCargo_nombre(res.getString("Nombre"));

                empleados.add(em);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_cargoModel.GetAllEnpleado_cargoByEmpleadoId() " + e.getMessage());
        }
        return empleados;
    }

    public String UpdateEmpleado_cargo(Empleado_cargo empleado) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            String concatena_campos = "";

            if (!ValidaEmpty(empleado.getFecha_inicio())) {
                concatena_campos = " , Fecha_inicio = '" + ConertirFechaAmaricano(empleado.getFecha_inicio()) + "'";
            }
            if (!ValidaEmpty(empleado.getFecha_fin())) {
                concatena_campos = concatena_campos + " , Fecha_fin =  '" + ConertirFechaAmaricano(empleado.getFecha_fin()) + "'";
            }
            db.conectar();
            String sql = "UPDATE Empleado_cargo\n"
                    + "   SET\n"
                    + "      Departamento_id = '" + empleado.getDepartamento_id() + "'\n"
                    + "      ,Nivel_id = '" + empleado.getNivel_id() + "'\n"
                    + "      ,Cargo = '" + empleado.getCargo() + "'\n"
                    + "      ,Cargo_id = '" + empleado.getCargo_id() + "'\n"
                    + "	  ,Activo = '" + empleado.getActivo() + "' " + concatena_campos + "\n"
                    + " WHERE Id = '" + empleado.getId() + "' and Empleado_id = '" + empleado.getEmpleado_id() + "'";
            System.out.println(" Actualiza " + sql);
            db.actualizar(sql);
            resultado = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            resultado = "Modelo.Empleado_cargoModel.UpdateEmpleado_cargo() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    public String DeleteEmpleado_cargo(int id) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM Empleado_cargo\n"
                    + "      WHERE Id = " + id + "";
            db.insertar(sql);
            resultado = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            resultado = "Modelo.Empleado_cargoModel.DeleteEmpleado_cargo() " + e.getMessage();
            System.out.println("Modelo.Empleado_cargoModel.DeleteEmpleado_cargo() " + e.getMessage());
        }
        return resultado;
    }

    public List<Empleado_cargo> getAllEmpleado_cargoByNivel_id(int Nivel_id) {
        List<Empleado_cargo> Cargos = new ArrayList<Empleado_cargo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select ec.Id, e.Empleado_id, CONCAT(e.Nombre,' ',e.Apellido_paterno,' ',e.Apellido_materno) Empleado_nombre, ec.Cargo, ec.Activo, ec.Nivel_id\n"
                    + "from Empleado_cargo ec \n"
                    + "inner join Empleado e\n"
                    + "on ec.Empleado_id = e.Empleado_id\n"
                    + "where ec.Nivel_id = '" + Nivel_id + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado_cargo c = new Empleado_cargo();
                c.setId(res.getInt("Id"));
                c.setEmpleado_id(res.getInt("Empleado_id"));
                c.setEmpleado_nombre(res.getString("Empleado_nombre"));
                c.setCargo(res.getString("Cargo"));
                c.setActivo(res.getInt("Activo"));
                c.setNivel_id(res.getInt("Nivel_id"));
                Cargos.add(c);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_cargoModel.getAllEmpleado_cargoByNivel_id() " + e.getMessage());
        }
        return Cargos;
    }

    public List<Empleado_cargo> getAllEmpleado_cargoByDepartamento_id(int Departamento_id) {
        List<Empleado_cargo> Cargos = new ArrayList<Empleado_cargo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select ec.Id, e.Empleado_id, CONCAT(e.Nombre,' ',e.Apellido_paterno,' ',e.Apellido_materno) Empleado_nombre, ec.Cargo, ec.Activo, ec.Nivel_id, ec.Departamento_id\n"
                    + "from Empleado_cargo ec \n"
                    + "inner join Empleado e\n"
                    + "on ec.Empleado_id = e.Empleado_id\n"
                    + "where ec.Departamento_id = '" + Departamento_id + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado_cargo c = new Empleado_cargo();
                c.setId(res.getInt("Id"));
                c.setEmpleado_id(res.getInt("Empleado_id"));
                c.setEmpleado_nombre(res.getString("Empleado_nombre"));
                c.setCargo(res.getString("Cargo"));
                c.setActivo(res.getInt("Activo"));
                c.setNivel_id(res.getInt("Nivel_id"));
                c.setDepartamento_id(res.getInt("Departamento_id"));
                Cargos.add(c);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_cargoModel.getAllEmpleado_cargoByNivel_id() " + e.getMessage());
        }
        return Cargos;
    }

    public static boolean ValidaEmpty(final String s) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }

    public Empleado_cargo GetEmpleadoCargoByEnpleadoCargo_id(int Id) {
        Empleado_cargo e = new Empleado_cargo();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select ec.Empleado_id, ec.Departamento_id, ec.Nivel_id, ec.Cargo, CONVERT(VARCHAR(10),ec.Fecha_inicio, 103) Fecha_inicio,  CONVERT(VARCHAR(10),ec.Fecha_fin, 103) Fecha_fin, ec.Activo, ec.Fecha_creacion, ec.Id,\n"
                    + "		d.Nombre Departamento_Nombre, n.Nombre Nivel_Nombre, CONCAT(e.Nombre,' ',e.Apellido_paterno,' ',e.Apellido_materno) Empleado_Nombre, c.Cargo_id, c.Nombre\n"
                    + " from Empleado_cargo ec\n"
                    + "	inner join Departamento d\n"
                    + "	on ec.Departamento_id = d.Departamento_id\n"
                    + "	inner join Nivel n\n"
                    + "	on ec.Nivel_id = n.Nivel_id\n"
                    + "	inner join Empleado e\n"
                    + "	on ec.Empleado_id = e.Empleado_id "
                    + " inner join Cargo c\n"
                    + "	on ec.Cargo_id = c.Cargo_id"
                    + " where ec.id = '" + Id + "' ";
            System.out.println(" --- ---  " + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                e.setId(res.getInt("Id"));
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setDepartamento_id(res.getInt("Departamento_id"));
                e.setNivel_id(res.getInt("Nivel_id"));
                e.setCargo(res.getString("Cargo"));
                e.setFecha_inicio(res.getString("Fecha_inicio"));
                e.setFecha_fin(res.getString("Fecha_fin"));
                e.setActivo(res.getInt("Activo"));
                e.setFecha_creacion(res.getDate("Fecha_creacion"));
                e.setDepartamento_nombre(res.getString("Departamento_Nombre"));
                e.setNivel_nombre(res.getString("Nivel_Nombre"));
                e.setEmpleado_nombre(res.getString("Empleado_Nombre"));
                e.setCargo_id(res.getInt("Cargo_id"));
                e.setCargo_nombre(res.getString("Nombre"));
            } else {
                e = null;
            }
            db.cierraConexion();
        } catch (SQLException ex) {
            System.out.println("Modelo.Empleado_cargoModel.GetEmpleadoCargoByIdEmpleado() " + ex.getMessage());
        }
        return e;
    }

    public String ConertirFechaAmaricano(String fecha) {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT convert(date, '" + fecha + "', 103) Fecha";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                resultado = res.getString("Fecha");
            }
            db.cierraConexion();

        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_cargoModel.ConertirFechaAmaricano() " + e.getMessage());
        }
        return resultado;
    }

}
