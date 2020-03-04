/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Plan_indica_resultado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Roberto
 */
public class Plan_indica_resultadoModel {

    public String CreateOrUpdateIndicador(Plan_indica_resultado indicador) {
        String resultado = "Ok";
        try {
            if (indicador.getPlan_indica_resultado_id() == 0) {
                resultado = CreateIndicador(indicador);
            } else {
                resultado = UpdateIndicador(indicador);
            }
        } catch (Exception e) {
            resultado = "Modelo.Plan_indica_resultadoModel.CreateOrUpdateIndicador() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    private String CreateIndicador(Plan_indica_resultado indicador) {
        String resuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Plan_indica_resultado\n"
                    + "           (Nombre, Fecha, Empleado_id\n"
                    + "           ,Fecha_creacion, Estado, Plan_matriz_id\n"
                    + "           ,Plan_estado_id)\n"
                    + "     VALUES\n"
                    + "           ('" + indicador.getNombre() + "', CONVERT(DATETIME, '" + indicador.getFecha() + "', 103) ,'" + indicador.getEmpleado_id() + "',\n"
                    + "		   SYSDATETIME(),1, '" + indicador.getPlan_matriz_id() + "',\n"
                    + "		   '" + indicador.getPlan_estado_id() + "')";
            System.out.println(sql);
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            resuesta = "Modelo.Plan_indica_resultadoModel.CreateIndicador() " + e.getMessage();
            System.out.println(resuesta);
        }
        return resuesta;
    }

    private String UpdateIndicador(Plan_indica_resultado indicador) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_indica_resultado\n"
                    + "   SET Nombre = '" + indicador.getNombre() + "'\n"
                    + "      ,Fecha = CONVERT(DATETIME, '" + indicador.getFecha() + "', 103)\n"
                    + "      ,Fecha_actualiza = SYSDATETIME()      \n"
                    + "      ,Empleado_actualiza = '" + indicador.getEmpleado_id() + "'\n"
                    + "	  ,Plan_estado_id = '" + indicador.getPlan_estado_id() + "'\n"
                    + " WHERE Plan_indica_resultado_id = '" + indicador.getPlan_indica_resultado_id() + "'";
            System.out.println(" Actualiza : " + sql);
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Plan_indica_resultadoModel.UpdateIndicador() " + e.getMessage();
            System.out.println("Modelo.Plan_indica_resultadoModel.UpdateIndicador() " + e.getMessage());
        }
        return respuesta;
    }

    public List<Plan_indica_resultado> GetAllIndicadorByEmepleado(String empleado, String matriz_id) {
        List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT   pi.Plan_indica_resultado_id, pi.Nombre, CONVERT(nvarchar,  pi.Fecha, 103) Fecha, pi.Empleado_id, pi.Fecha_creacion,\n"
                    + "	     pi.Fecha_actualiza, pi.Estado, pi.Empleado_actualiza, pi.Plan_matriz_id, pi.Plan_estado_id ,pe.Nombre as Nombre_Estado\n"
                    + "FROM     Plan_indica_resultado pi\n"
                    + "inner join Plan_estado pe\n"
                    + "on pi.plan_estado_id = pe.plan_estado_id \n"
                    + "where pi.empleado_id = '" + empleado + "' and pi.Plan_matriz_id = '" + matriz_id + "' and pi.Estado = 1 order by pi.fecha";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_indica_resultado i = new Plan_indica_resultado();
                i.setPlan_indica_resultado_id(res.getInt("Plan_indica_resultado_id"));
                i.setNombre(res.getString("Nombre"));
                i.setFecha(res.getString("Fecha"));
                i.setEstado_nombre(res.getString("Nombre_estado"));
                indicadores.add(i);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_indica_resultadoModel.GetAllIndicadorByEmepleado() " + e.getMessage());
        }
        return indicadores;
    }

    public Plan_indica_resultado GetIndicadorById(String id) {
        Plan_indica_resultado indica = new Plan_indica_resultado();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT   pi.Plan_indica_resultado_id, pi.Nombre, CONVERT(nvarchar,  pi.Fecha, 103) Fecha, pi.Empleado_id, pi.Fecha_creacion,\n"
                    + "	     pi.Fecha_actualiza, pi.Estado, pi.Empleado_actualiza, pi.Plan_matriz_id, pi.Plan_estado_id ,pe.Nombre as Nombre_Estado\n"
                    + "FROM     Plan_indica_resultado pi\n"
                    + "inner join Plan_estado pe\n"
                    + "on pi.plan_estado_id = pe.plan_estado_id \n"
                    + "where Plan_indica_resultado_id = '" + id + "' ";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                indica.setPlan_indica_resultado_id(res.getInt("Plan_indica_resultado_id"));
                indica.setNombre(res.getString("Nombre"));
                indica.setFecha(res.getString("Fecha"));
                indica.setEstado_nombre(res.getString("Nombre_estado"));
                indica.setPlan_estado_id(res.getInt("Plan_estado_id"));
                indica.setPlan_matriz_id(res.getInt("Plan_matriz_id"));
            }
            db.cierraConexion();
        } catch (SQLException e) {

            System.out.println("Modelo.Plan_indica_resultadoModel.GetIndicadorById() " + e.getMessage());
        }
        return indica;
    }

    public String deleteIndicador(String id_indicador, String emplado) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_indica_resultado\n"
                    + "   SET Fecha_actualiza = SYSDATETIME()      \n"
                    + "      ,Empleado_actualiza = '" + emplado + "'\n"
                    + "	  ,Estado = 6 \n"
                    + " WHERE Plan_indica_resultado_id = '" + id_indicador + "'";
            System.out.println(" Elimina : " + sql);
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Plan_indica_resultadoModel.UpdateIndicador() " + e.getMessage();
            System.out.println("Modelo.Plan_indica_resultadoModel.UpdateIndicador() " + e.getMessage());
        }
        return respuesta;
    }

    public List<Plan_indica_resultado> GetAllIndicador(String matriz_id) {
        List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT   pi.Plan_indica_resultado_id, pi.Nombre, CONVERT(nvarchar,  pi.Fecha, 103) Fecha, pi.Empleado_id, pi.Fecha_creacion,\n"
                    + "	     pi.Fecha_actualiza, pi.Estado, pi.Empleado_actualiza, pi.Plan_matriz_id, pi.Plan_estado_id ,pe.Nombre as Nombre_Estado\n"
                    + "FROM     Plan_indica_resultado pi\n"
                    + "inner join Plan_estado pe\n"
                    + "on pi.plan_estado_id = pe.plan_estado_id \n"
                    + "where pi.Plan_matriz_id = '" + matriz_id + "' and pi.Estado = 1 order by pi.fecha";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_indica_resultado i = new Plan_indica_resultado();
                i.setPlan_indica_resultado_id(res.getInt("Plan_indica_resultado_id"));
                i.setNombre(res.getString("Nombre"));
                i.setFecha(res.getString("Fecha"));
                i.setEstado_nombre(res.getString("Nombre_estado"));
                indicadores.add(i);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_indica_resultadoModel.GetAllIndicadorByEmepleado() " + e.getMessage());
        }
        return indicadores;
    }

    public List<Plan_indica_resultado> GetAllIndicadorCalendarioByUserId(String empleado) {
        List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select Plan_indica_resultado_id, Plan_matriz_id, Nombre, Fecha from Plan_indica_resultado where Empleado_id = '" + empleado + "' \n"
                    + "and Estado = '1' order by Fecha";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_indica_resultado re = new Plan_indica_resultado();
                re.setPlan_indica_resultado_id(res.getInt("Plan_indica_resultado_id"));
                re.setNombre(res.getString("Nombre"));
                re.setPlan_matriz_id(res.getInt("Plan_matriz_id"));
                re.setFecha(res.getString("FECHA"));
                indicadores.add(re);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_indica_resultadoModel.GetAllIndicadorCalendarioByUserId() " + e.getMessage());
        }
        return indicadores;
    }

    public List<Plan_indica_resultado> GetAllIndicadorCalendarioAdmin() {
        List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select Plan_indica_resultado_id, Plan_matriz_id, Nombre, Fecha from Plan_indica_resultado \n"
                    + "  where Estado = '1' order by Fecha";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_indica_resultado re = new Plan_indica_resultado();
                re.setPlan_indica_resultado_id(res.getInt("Plan_indica_resultado_id"));
                re.setNombre(res.getString("Nombre"));
                re.setPlan_matriz_id(res.getInt("Plan_matriz_id"));
                re.setFecha(res.getString("FECHA"));
                indicadores.add(re);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_indica_resultadoModel.GetAllIndicadorCalendarioAdmin() " + e.getMessage());
        }
        return indicadores;
    }
}
