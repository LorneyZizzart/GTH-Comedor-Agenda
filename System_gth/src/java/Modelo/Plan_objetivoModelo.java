/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Plan_objetivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Plan_objetivoModelo {

    public String SaveorUpdateObjetivo(Plan_objetivo plan_objetivo) {
        String mensaje = "Ok";
        try {
            if (plan_objetivo.getPlan_objetivo_id() == 0) {
                mensaje = SavePlanObjetivo(plan_objetivo);
            } else {
                mensaje = UpdatePlanObjetivo(plan_objetivo);
            }
        } catch (Exception e) {
            mensaje = "Modelo.Plan_objetivoModelo.SaveorUpdateObjetivo()" + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String SavePlanObjetivo(Plan_objetivo plan_objetivo) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String inserta = "INSERT INTO Plan_objetivo\n"
                    + "           (Titulo, Creditacion, Gestion\n"
                    + "           ,Empleado_id, Fecha_creacion,Estado )\n"
                    + "     VALUES\n"
                    + "           ('" + plan_objetivo.getTitulo() + "','" + plan_objetivo.getCreditacion() + "','" + plan_objetivo.getGestion() + "'\n"
                    + "		   ,'" + plan_objetivo.getEmpleado_id() + "', SYSDATETIME(),'" + plan_objetivo.getEstado() + "')";
            System.out.println(" Inserta : " + inserta);            
            db.insertar(inserta);
            String ultimoID = GetUltimoPlanObjetivoId();
            mensaje=mensaje+"##"+ultimoID;
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = mensaje+"##Modelo.Plan_objetivoModelo.SavePlanObjetivo() "+e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String UpdatePlanObjetivo(Plan_objetivo plan_objetivo) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String actualiza = "UPDATE Plan_objetivo\n"
                    + "   SET Titulo = '" + plan_objetivo.getTitulo() + "'\n"
                    + "      ,Creditacion = '" + plan_objetivo.getCreditacion() + "'\n"
                    + "      ,Gestion = '" + plan_objetivo.getGestion() + "'\n"
                    + "      ,Fecha_actualizacion = SYSDATETIME()\n"
                    + "      ,Empleado_actualiza = '" + plan_objetivo.getEmpleado_id() + "'\n"
                    + "      ,Estado = '" + plan_objetivo.getEstado() + "'\n"
                    + "WHERE Plan_objetivo_id = '" + plan_objetivo.getPlan_objetivo_id() + "'";
            System.out.println(" Actualiza : " + actualiza);
            db.actualizar(actualiza);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Plan_objetivoModelo.SavePlanObjetivo() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<Plan_objetivo> GetAllPlanObjetivobyUser(int empleado_id) {
        List<Plan_objetivo> plan_objetivos = new ArrayList<Plan_objetivo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String consulta = "SELECT po.Plan_objetivo_id, po.Titulo, po.Creditacion, po.Gestion, po.Empleado_id\n"
                    + "      ,convert(varchar , po.Fecha_creacion, 103)Fecha_creacion, convert(varchar , po.Fecha_actualizacion,103)Fecha_actualizacion, po.Empleado_actualiza,po.Estado\n"
                    + "	  , CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "	  , (Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = po.Empleado_actualiza) Nombre_Actualiza\n"
                    + "  FROM Plan_objetivo po\n"
                    + "		inner join Empleado e\n"
                    + "		on po.Empleado_id = e.Empleado_id\n"
                    + "where po.Empleado_id = '" + empleado_id + "' and po.Estado = '1' ";
            System.out.println("GetAllPlanObjetivobyUser " + consulta);
            ResultSet res = db.consulta(consulta);
            while (res.next()) {
                Plan_objetivo p = new Plan_objetivo();
                p.setPlan_objetivo_id(res.getInt("Plan_objetivo_id"));
                p.setTitulo(res.getString("Titulo"));
                p.setCreditacion(res.getString("Creditacion"));
                p.setGestion(res.getInt("Gestion"));
                p.setEmpleado_id(res.getInt("Empleado_id"));
                p.setFecha_creacion(res.getString("Fecha_creacion"));
                p.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                p.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                p.setEstado(res.getInt("Estado"));

                p.setNombre_creador(res.getString("Nombre_creador"));
                p.setNombre_actualizador(res.getString("Nombre_Actualiza"));

                plan_objetivos.add(p);
            }
            db.cierraConexion();
        } catch (Exception e) {
            System.out.println("Modelo.Plan_objetivoModelo.GetAllPlanObjetivobyUser() " + e.getMessage());
        }
        return plan_objetivos;
    }

    public Plan_objetivo GetplanObjetivobyId(int plan_objetivo_id) {
        Plan_objetivo p = new Plan_objetivo();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String consulta = "SELECT po.Plan_objetivo_id, po.Titulo, po.Creditacion, po.Gestion, po.Empleado_id\n"
                    + "      ,convert(varchar , po.Fecha_creacion, 103)Fecha_creacion, convert(varchar , po.Fecha_actualizacion,103)Fecha_actualizacion, po.Empleado_actualiza,po.Estado\n"
                    + "	  , CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "	  , (Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = po.Empleado_actualiza) Nombre_Actualiza\n"
                    + "  FROM Plan_objetivo po\n"
                    + "		inner join Empleado e\n"
                    + "		on po.Empleado_id = e.Empleado_id\n"
                    + "where po.Plan_objetivo_id = '" + plan_objetivo_id + "'";
            ResultSet res = db.consulta(consulta);
            while (res.next()) {

                p.setPlan_objetivo_id(res.getInt("Plan_objetivo_id"));
                p.setTitulo(res.getString("Titulo"));
                p.setCreditacion(res.getString("Creditacion"));
                p.setGestion(res.getInt("Gestion"));
                p.setEmpleado_id(res.getInt("Empleado_id"));
                p.setFecha_creacion(res.getString("Fecha_creacion"));
                p.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                p.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                p.setEstado(res.getInt("Estado"));

                p.setNombre_creador(res.getString("Nombre_creador"));
                p.setNombre_actualizador(res.getString("Nombre_Actualiza"));

            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_objetivoModelo.GetAllPlanObjetivobyUser() " + e.getMessage());
        }
        return p;
    }

    public String GetUltimoPlanObjetivoId() {
        String resultado = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select MAX(Plan_objetivo_id)id from Plan_objetivo";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                resultado=res.getString("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            resultado="Modelo.Plan_objetivoModelo.GetUltimoPlanObjetivoId() "+e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }
}
