/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Plan_subobjetivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Plan_subobjetivoModelo {

    public String SaveorUpdateSubobjetivo(Plan_subobjetivo subobjetivo) {
        String mensaje = "Ok";
        try {
            if (subobjetivo.getPlan_subobjetivo_id() == 0) {
                // insertamos
                mensaje = SaveSubobjetivo(subobjetivo);
            } else {
                // actualizamos
                mensaje = UpdateSubobjetivo(subobjetivo);
            }
        } catch (Exception e) {
            mensaje = "Modelo.Plan_subobjetivoModelo.SaveorUpdateSubobjetivo() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String SaveSubobjetivo(Plan_subobjetivo subobjetivo) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Plan_subobjetivo\n"
                    + "           (Plan_objetivo_id, Titulo, Descripcion, \n"
                    + "			Empleado_id, Fecha_creacion, Estado)\n"
                    + "     VALUES\n"
                    + "           ('" + subobjetivo.getPlan_objetivo_id() + "', '" + subobjetivo.getTitulo() + "','" + subobjetivo.getDescripcion() + "'\n"
                    + "           ,'" + subobjetivo.getEmpleado_id() + "' ,SYSDATETIME(), '"+subobjetivo.getEstado()+"')";
            System.out.println(" Inserta Subobjetivo =  " + sql);
            db.insertar(sql);
            db.cierraConexion();

        } catch (SQLException e) {
            mensaje = "Modelo.Plan_subobjetivoModelo.SaveSubobjetivo() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String UpdateSubobjetivo(Plan_subobjetivo subobjetivo) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_subobjetivo\n"
                    + "   SET Plan_objetivo_id = '" + subobjetivo.getPlan_objetivo_id() + "'\n"
                    + "      ,Titulo = '" + subobjetivo.getTitulo() + "'\n"
                    + "      ,Descripcion = '" + subobjetivo.getDescripcion() + "'\n"
                    + "      ,Fecha_actualizacion = Sysdatetime()\n"
                    + "      ,Empleado_actualiza = '" + subobjetivo.getEmpleado_id() + "'\n"
                    + "      ,Estado = '" + subobjetivo.getEstado() + "'\n"
                    + " WHERE Plan_subobjetivo_id = '" + subobjetivo.getPlan_subobjetivo_id() + "'";
            System.out.println(" Actualiza Subobjetivo =  " + sql);
            db.insertar(sql);
            db.cierraConexion();

        } catch (SQLException e) {
            mensaje = "Modelo.Plan_subobjetivoModelo.UpdateSubobjetivo() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<Plan_subobjetivo> GetAllSubobjeticosbyIdObjetivo(int objetivo_id) {
        List<Plan_subobjetivo> subobjetivos = new ArrayList<Plan_subobjetivo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ps.Plan_subobjetivo_id, ps.Plan_objetivo_id, ps.Titulo, ps.Descripcion, ps.Empleado_id\n"
                    + "      ,CONVERT(varchar, ps.Fecha_creacion, 103)Fecha_creacion, CONVERT(varchar, ps.Fecha_actualizacion,103)Fecha_actualizacion, ps.Empleado_actualiza, ps.Estado\n"
                    + "	  , CONCAT(e.Apellido_paterno,' ', e.Apellido_materno,' ',e.Nombre)Nombre_creador\n"
                    + "	  ,(select CONCAT(e.Apellido_paterno,' ', e.Apellido_materno,' ',e.Nombre) from Empleado em where em.Empleado_id = ps.Empleado_actualiza)Nombre_actualizador\n"
                    + "		\n"
                    + "  FROM Plan_subobjetivo ps\n"
                    + "	   inner join Empleado e\n"
                    + "	   on ps.Empleado_id =	e.Empleado_id\n"
                    + "WHERE  ps.Plan_objetivo_id = '" + objetivo_id + "' and ps.Estado = '1'";
            System.out.println(" GetAllSubobjeticosbyIdObjetivo  =" + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_subobjetivo sub = new Plan_subobjetivo();
                sub.setPlan_subobjetivo_id(res.getInt("Plan_subobjetivo_id"));
                sub.setPlan_objetivo_id(res.getInt("Plan_objetivo_id"));
                sub.setTitulo(res.getString("Titulo"));
                sub.setDescripcion(res.getString("Descripcion"));
                sub.setEmpleado_id(res.getInt("Empleado_id"));
                sub.setFecha_creacion(res.getString("Fecha_creacion"));
                sub.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                sub.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                sub.setEstado(res.getInt("Estado"));

                sub.setNombre_creador(res.getString("Nombre_creador"));
                sub.setNombre_actualizador(res.getString("Nombre_actualizador"));

                subobjetivos.add(sub);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_subobjetivoModelo.GetAllSubobjeticosbyIdObjetivo() " + e.getMessage());
        }
        return subobjetivos;
    }

    public Plan_subobjetivo GetSubobjetivobyId(int subobjetivo_id) {
        Plan_subobjetivo sub = new Plan_subobjetivo();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ps.Plan_subobjetivo_id, ps.Plan_objetivo_id, ps.Titulo, ps.Descripcion, ps.Empleado_id\n"
                    + "      ,CONVERT(varchar, ps.Fecha_creacion, 103)Fecha_creacion, CONVERT(varchar, ps.Fecha_actualizacion,103)Fecha_actualizacion, ps.Empleado_actualiza, ps.Estado\n"
                    + "	  , CONCAT(e.Apellido_paterno,' ', e.Apellido_materno,' ',e.Nombre)Nombre_creador\n"
                    + "	  ,(select CONCAT(e.Apellido_paterno,' ', e.Apellido_materno,' ',e.Nombre) from Empleado em where em.Empleado_id = ps.Empleado_actualiza)Nombre_actualizador\n"
                    + "		\n"
                    + "  FROM Plan_subobjetivo ps\n"
                    + "	   inner join Empleado e\n"
                    + "	   on ps.Empleado_id =	e.Empleado_id\n"
                    + "WHERE  ps.Plan_subobjetivo_id = '" + subobjetivo_id + "'";
            System.out.println(" GetSubobjetivobyId  =" + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                
                sub.setPlan_subobjetivo_id(res.getInt("Plan_subobjetivo_id"));
                sub.setPlan_objetivo_id(res.getInt("Plan_objetivo_id"));
                sub.setTitulo(res.getString("Titulo"));
                sub.setDescripcion(res.getString("Descripcion"));
                sub.setEmpleado_id(res.getInt("Empleado_id"));
                sub.setFecha_creacion(res.getString("Fecha_creacion"));
                sub.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                sub.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                sub.setEstado(res.getInt("Estado"));

                sub.setNombre_creador(res.getString("Nombre_creador"));
                sub.setNombre_actualizador(res.getString("Nombre_actualizador"));
                
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_subobjetivoModelo.GetSubobjetivobyId() " + e.getMessage());
        }
        return sub;
    }

}
