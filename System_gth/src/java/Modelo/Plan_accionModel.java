/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Plan_accion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Plan_accionModel {

    public String SaveOrUpdatePlan_accion(Plan_accion plan) {
        String mensaje = "Ok";
        try {
            if (plan.getPlan_accion_id() == 0) {
                // insertamos
                mensaje = SavePlan_accion(plan);
            } else {
                // actualizamos
                mensaje = UpdatePlan_accion(plan);
            }
        } catch (Exception e) {
            mensaje = "Modelo.Plan_accionModel.SaveOrUpdatePlan_accion() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String SavePlan_accion(Plan_accion plan) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Plan_accion\n"
                    + "           (Nombre, Contexto, Fecha_creacion\n"
                    + "           ,Empleado_id, Estado, Plan_subobjetivo_id)\n"
                    + "     VALUES\n"
                    + "           ('" + plan.getNombre() + "','" + plan.getContexto() + "',SYSDATETIME()\n"
                    + "           ,'" + plan.getEmpleado_id() + "','" + plan.getEstado() + "','" + plan.getPlan_subobjetivo_id() + "')";
            System.out.println("SavePlan_accion : " + sql);
            db.insertar(sql);
            db.cierraConexion();
            int id = idplanaccion();
            mensaje = mensaje + "##" + id;
        } catch (SQLException e) {
            mensaje = "Modelo.Plan_accionModel.SavePlan_accion() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String UpdatePlan_accion(Plan_accion plan) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_accion\n"
                    + "   SET Nombre = '" + plan.getNombre() + "'\n"
                    + "      ,Contexto = '" + plan.getContexto() + "'\n"
                    + "      ,Fecha_actualizacion = SYSDATETIME()\n"
                    + "      ,Empleado_actualiza = '" + plan.getEmpleado_id() + "'\n"
                    + "      ,Estado = '" + plan.getEstado() + "'\n"
                    + " WHERE Plan_accion_id = '" + plan.getPlan_accion_id() + "'";
            System.out.println("UpdatePlan_accion : " + sql);
            db.insertar(sql);
            db.cierraConexion();
            mensaje = mensaje + "##" + plan.getPlan_accion_id();
        } catch (SQLException e) {
            mensaje = "Modelo.Plan_accionModel.SavePlan_accion() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<Plan_accion> GetAllPlan_accionBySubobjetivo_id(int subobjetivo_id) {
        List<Plan_accion> planes = new ArrayList<Plan_accion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pa.Plan_accion_id, pa.Nombre, pa.Contexto\n"
                    + "      ,convert(varchar, pa.Fecha_creacion, 103)Fecha_creacion, pa.Empleado_id\n"
                    + "	  ,convert(varchar, pa.Fecha_actualizacion,103)Fecha_actualizacion ,pa.Empleado_actualiza\n"
                    + "      ,pa.Estado, pa.Plan_subobjetivo_id, CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "	  ,(Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = pa.Empleado_actualiza) Nombre_Actualiza, pa.Criterio\n"
                    + "  FROM Plan_accion pa\n"
                    + "		inner join Empleado e \n"
                    + "		on pa.Empleado_id = e.Empleado_id\n"
                    + "WHERE PA.Plan_subobjetivo_id = '" + subobjetivo_id + "'  and pa.Estado = '1'";
            System.out.println("GetAllPlan_accionBySubobjetivo_id() " + sql);

            ResultSet res = db.consulta(sql);
            while (res.next()) {

                Plan_accion p = new Plan_accion();
                p.setPlan_accion_id(res.getInt("Plan_accion_id"));
                p.setNombre(res.getString("NOMBRE"));
                p.setContexto(res.getString("CONTEXTO"));
                p.setFecha_creacion(res.getString("Fecha_creacion"));
                p.setEmpleado_id(res.getInt("Empleado_id"));
                p.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                p.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                p.setEstado(res.getInt("Estado"));
                p.setPlan_subobjetivo_id(res.getInt("Plan_subobjetivo_id"));
                p.setCriterio(res.getString("Criterio"));

                //Datos adicionales para ver al empleado su nombre
                p.setNombre_creador(res.getString("Nombre_creador"));
                p.setNombre_actualizador(res.getString("Nombre_Actualiza"));

                planes.add(p);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_accionModel.GetAllPlan_accionBySubobjetivo_id() " + e.getMessage());
        }
        return planes;
    }

    public Plan_accion GetPlan_AccionByPlanAccion_id(int plan_accoin_id) {
        Plan_accion p = new Plan_accion();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pa.Plan_accion_id, pa.Nombre, pa.Contexto\n"
                    + "      ,convert(varchar, pa.Fecha_creacion, 103)Fecha_creacion, pa.Empleado_id\n"
                    + "	  ,convert(varchar, pa.Fecha_actualizacion,103)Fecha_actualizacion ,pa.Empleado_actualiza\n"
                    + "      ,pa.Estado, pa.Plan_subobjetivo_id, CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "	  ,(Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = pa.Empleado_actualiza) Nombre_Actualiza, pa.Criterio\n"
                    + "  FROM Plan_accion pa\n"
                    + "		inner join Empleado e \n"
                    + "		on pa.Empleado_id = e.Empleado_id\n"
                    + "WHERE PA.Plan_accion_id = '" + plan_accoin_id + "'  and pa.Estado = '1' ";
            System.out.println("GetAllPlan_accionBySubobjetivo_id() " + sql);

            ResultSet res = db.consulta(sql);
            if (res.next()) {

                p.setPlan_accion_id(res.getInt("Plan_accion_id"));
                p.setNombre(res.getString("NOMBRE"));
                p.setContexto(res.getString("CONTEXTO"));
                p.setFecha_creacion(res.getString("Fecha_creacion"));
                p.setEmpleado_id(res.getInt("Empleado_id"));
                p.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                p.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                p.setEstado(res.getInt("Estado"));
                p.setPlan_subobjetivo_id(res.getInt("Plan_subobjetivo_id"));
                p.setCriterio(res.getString("Criterio"));

                //Datos adicionales para ver al empleado su nombre
                p.setNombre_creador(res.getString("Nombre_creador"));
                p.setNombre_actualizador(res.getString("Nombre_Actualiza"));
               // p.setPresupuesto(res.getFloat("Presupuesto"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_accionModel.GetAllPlan_AccionByPlanAccion_id() " + e.getMessage());
        }
        return p;
    }

    public String UpdatePlanAccionCriterio(Plan_accion plan) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_accion\n"
                    + "   SET Criterio = '" + plan.getCriterio() + "'\n"
                    + " WHERE Plan_accion_id = '" + plan.getPlan_accion_id() + "'";
            System.out.println("UpdatePlanAccionCriterio : " + sql);
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Plan_accionModel.UpdatePlanAccionCriterio() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public int idplanaccion() {
        int id = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select max(Plan_accion_id)id from Plan_accion";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getInt("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_accionModel.idplnaaccion() " + e.getMessage());
        }
        return id;
    }

    public String eliminaplanAccion(String planacion, String usuario) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_accion\n"
                    + "   SET Fecha_actualizacion = SYSDATETIME()\n"
                    + "      ,Empleado_actualiza = '" + usuario + "'\n"
                    + "      ,Estado = '6'      \n"
                    + " WHERE Plan_accion_id = '" + planacion + "'";
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Plan_accionModel.eliminaplanAccion() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
}
