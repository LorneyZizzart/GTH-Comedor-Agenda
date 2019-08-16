package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Departamento;
import Entidad.Empleado_cargo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoModel {

    public String SaveOrUpdateDepartamento(Departamento dep) {
        String Mensaje = "";
        try {
            if (dep.getDepartamento_id() == 0) {
                //insertamos
                Mensaje = CreateDepartamento(dep);
            } else {
                //Actualizamo
                Mensaje = UpdateDepartamento(dep);
            }
        } catch (Exception e) {
            Mensaje = "Modelo.DepartamentoModel.SaveOrUpdateDepartamento() " + e.getMessage();
            System.out.println(Mensaje);
        }
        return Mensaje;
    }

    public String CreateDepartamento(Departamento dep) {
        String Mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String campo = ", Departamento_id_aux";
            String valor = ", NULL ";
            if (dep.getDepartamento_id_aux() > 0) {
                campo = ", Departamento_id_aux";
                valor = ",'" + dep.getDepartamento_id_aux() + "' ";
            }
            String sql = "INSERT INTO Departamento(Nombre, Estado, Fecha_creacion, Area_id" + campo + ")\n"
                    + "     VALUES('" + dep.getNombre() + "','" + dep.getEstado() + "', CONVERT(date, SYSDATETIME()),'" + dep.getArea_id() + "'" + valor + ")";
            db.insertar(sql);
            db.cierraConexion();
            Mensaje = "Ok";
        } catch (SQLException e) {
            Mensaje = "Modelo.DepartamentoModel.CreateDepartament() " + e.getMessage();
            System.out.println(Mensaje);
        }
        return Mensaje;
    }

    public String UpdateDepartamento(Departamento dep) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String aux = ", Departamento_id_aux = NULL ";

            if (dep.getDepartamento_id_aux() > 0) {
                aux = ", Departamento_id_aux = '" + dep.getDepartamento_id_aux() + "' ";
            }
            String sql = "UPDATE Departamento\n"
                    + "   SET Nombre = '" + dep.getNombre() + "'\n"
                    + "      ,Estado = '" + dep.getEstado() + "'            \n"
                    + "      ,Area_id = '" + dep.getArea_id() + "' " + aux + "\n"
                    + " WHERE Departamento_id = '" + dep.getDepartamento_id() + "'";
            db.actualizar(sql);
            mensaje = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.DepartamentoModel.UpdateDepartamento() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<Departamento> GetAllDepartamento() {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT a.Departamento_id, a.Nombre, a.Estado, a.Fecha_creacion, a.Area_id, a.Departamento_id_aux, ar.Nombre as Area_Nombre,\n"
                    + " ISNULL((select Nombre from Departamento where Departamento_id = a.Departamento_id_aux),'0')Dependiente\n"
                    + "FROM Departamento a \n"
                    + "	inner join Area ar\n"
                    + "	on ar.Area_id = a.Area_id";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Departamento dep = new Departamento();
                dep.setDepartamento_id(res.getInt("Departamento_id"));
                dep.setNombre(res.getString("Nombre"));
                dep.setEstado(res.getInt("Estado"));
                dep.setFecha_creacion(res.getDate("Fecha_creacion"));
                dep.setDepartamento_id_aux(res.getInt("Departamento_id_aux"));
                dep.setArea_id(res.getInt("Area_id"));
                dep.setArea_Nombre(res.getString("Area_Nombre"));
                dep.setDepartamento_Nombre_dep(res.getString("Dependiente"));
                departamentos.add(dep);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.DepartamentoModel.GetAllDepartamento() " + e.getMessage());
        }
        return departamentos;
    }

    public Departamento GetDepartamentoById(int id) {
        Departamento dep = new Departamento();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT a.Departamento_id, a.Nombre, a.Estado, a.Fecha_creacion, a.Area_id, a.Departamento_id_aux, ar.Nombre as Area_Nombre,\n"
                    + " ISNULL((select Nombre from Departamento where Departamento_id = a.Departamento_id_aux),'0')Dependiente\n"
                    + "FROM Departamento a \n"
                    + "	inner join Area ar\n"
                    + "	on ar.Area_id = a.Area_id WHERE a.Departamento_id='" + id + "' ";
            ResultSet res = db.consulta(sql);
            if (res.next()) {

                dep.setDepartamento_id(res.getInt("Departamento_id"));
                dep.setNombre(res.getString("Nombre"));
                dep.setEstado(res.getInt("Estado"));
                dep.setFecha_creacion(res.getDate("Fecha_creacion"));
                dep.setDepartamento_id_aux(res.getInt("Departamento_id_aux"));
                dep.setArea_id(res.getInt("Area_id"));
                dep.setArea_Nombre(res.getString("Area_Nombre"));
                dep.setDepartamento_Nombre_dep(res.getString("Dependiente"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.DepartamentoModel.GetDepartamentoById() " + e.getMessage());
        }
        return dep;
    }

    public List<Departamento> GetAllDepartamentoByIdArea(int areaId) {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select Departamento_id, Nombre, Estado, Area_id \n"
                    + "from Departamento  \n"
                    + "where Area_id = '" + areaId + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Departamento dep = new Departamento();
                dep.setDepartamento_id(res.getInt("Departamento_id"));
                dep.setNombre(res.getString("Nombre"));
                dep.setEstado(res.getInt("Estado"));
                dep.setArea_id(res.getInt("Area_id"));
                departamentos.add(dep);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.DepartamentoModel.GetAllDepartamentoByIdArea() " + e.getMessage());
        }
        return departamentos;
    }

    public List<Empleado_cargo> DeleteDepartamento(int departamento_id) {
        List<Empleado_cargo> cargos = new ArrayList<Empleado_cargo>();
        try {
            Empleado_cargoModel encar = new Empleado_cargoModel();
            cargos = encar.getAllEmpleado_cargoByDepartamento_id(departamento_id);
            if (cargos.isEmpty()) {
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "DELETE FROM Departamento\n"
                        + "      WHERE Departamento_id = '" + departamento_id + "'";
                db.borrar(sql);
                db.cierraConexion();
            }

        } catch (Exception e) {
            System.out.println("Modelo.DepartamentoModel.DeleteDepartamento() " + e.getMessage());
        }
        return cargos;
    }

}
