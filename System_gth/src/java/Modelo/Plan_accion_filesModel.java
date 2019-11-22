package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Plan_accion_files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Plan_accion_filesModel {

    public String SaveFile(Plan_accion_files file) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Plan_accion_files\n"
                    + "           (Nombre, Nombre_archivo, Fecha_subido\n"
                    + "           ,Estado, Empleado_id, Plan_accion_id)\n"
                    + "     VALUES\n"
                    + "           ('" + file.getNombre() + "','" + file.getNombre_archivo() + "',SYSDATETIME() \n"
                    + "		   ,'" + file.getEstado() + "','" + file.getEmpleado_id() + "','" + file.getPlan_accion_id() + "')";
            System.out.println(" SaveFile() " + sql);
            db.insertar(sql);
            db.cierraConexion();

        } catch (SQLException e) {
            System.out.println("Modelo.Plan_accion_filesModel.SaveFile() " + e.getMessage());
        }
        return mensaje;
    }

    public List<Plan_accion_files> GetAllFileByPlanacionid(int id) {
        List<Plan_accion_files> files = new ArrayList<Plan_accion_files>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Plan_accion_files_id, Nombre, Nombre_archivo, Fecha_subido\n"
                    + "      ,Estado, Empleado_id, Fecha_actualiza, Empleado_actualiza, Plan_accion_id\n"
                    + "  FROM Plan_accion_files\n"
                    + "  WHERE Plan_accion_id = '" + id + "' and Estado ='1' ";
            System.out.println("GetAllFileByPlanacionid() " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_accion_files f = new Plan_accion_files();
                f.setPlan_accion_files_id(res.getInt("Plan_accion_files_id"));
                f.setNombre(res.getString("Nombre"));
                f.setNombre_archivo(res.getString("Nombre_archivo"));
                f.setFecha_subido(res.getString("Fecha_subido"));
                f.setEstado(res.getInt("Estado"));
                f.setEmpleado_id(res.getInt("Empleado_id"));
                f.setFecha_actualiza(res.getString("Fecha_actualiza"));
                f.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                f.setPlan_accion_id(res.getInt("Plan_accion_id"));
                files.add(f);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_accion_filesModel.GetAllFileByPlanacionid() " + e.getMessage());
        }
        return files;
    }

    public String DeleteFile(Plan_accion_files file) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_accion_files\n"
                    + "   SET Estado = '" + file.getEstado() + "'      \n"
                    + "      ,Fecha_actualiza = SYSDATETIME()\n"
                    + "      ,Empleado_actualiza = '" + file.getEmpleado_id() + "'      \n"
                    + " WHERE Plan_accion_files_id = '" + file.getPlan_accion_files_id() + "'";
            System.out.println("DeleteFile() " + sql);
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Plan_accion_filesModel.DeleteFile()" + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

}
