/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Plan_indica_resultado;
import Entidad.Plan_matriz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Plan_matrizModel {

    public String SaveorUpdateMatriz(Entidad.Plan_matriz matriz) {
        String mensaje = "Ok";
        try {
            if (matriz.getPlan_matriz_id() == 0) {
                //save
                mensaje = SaveMatriz(matriz);
            } else {
                //update
                mensaje = UpdateMatriz(matriz);
            }
        } catch (Exception e) {
            mensaje = "Modelo.Plan_matriz.SaveorUpdateMatriz()" + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String idPlanMatriz() {
        String id = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select max(Plan_matriz_id) id from Plan_matriz";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getString("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_matrizModel.idPlanMatriz() -- " + e.getMessage());
        }
        return id;
    }

    public String SaveMatriz(Entidad.Plan_matriz matriz) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Plan_matriz\n"
                    + "           (Que_hacer, Responsable, Como\n"
                    + "           ,Documento_generadi, Indicadores_resultado\n"
                    + "           ,Indicador, Plan_accion_id, Fecha_cracion\n"
                    + "           ,Empleado_id,Estado, Presupuesto)\n"
                    + "     VALUES\n"
                    + "           ('" + matriz.getQue_hacer() + "','" + matriz.getResponsable() + "','" + matriz.getComo() + "'\n"
                    + "		   ,'" + matriz.getDocumento_generadi() + "','" + matriz.getIndicadores_resultado() + "' \n"
                    + "		   ,'" + matriz.getIndicador() + "','" + matriz.getPlan_accion_id() + "',SYSDATETIME() \n"
                    + "		   ,'" + matriz.getEmpleado_id() + "','" + matriz.getEstado() + "', '" + matriz.getPresupuesto() + "')";
            System.out.println(" SaveMatriz() " + sql);
            db.insertar(sql);
            String id = idPlanMatriz();
            mensaje = "Ok##" + id;
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Plan_matriz.SaveMatriz() " + e.getMessage() + "Error";

            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String UpdateMatriz(Entidad.Plan_matriz matriz) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Plan_matriz\n"
                    + "   SET Que_hacer = '" + matriz.getQue_hacer() + "'\n"
                    + "      ,Responsable = '" + matriz.getResponsable() + "'\n"
                    + "      ,Como = '" + matriz.getComo() + "'\n"
                    + "      ,Documento_generadi = '" + matriz.getDocumento_generadi() + "'\n"
                    + "      ,Indicadores_resultado = '" + matriz.getIndicadores_resultado() + "'\n"
                    + "      ,Presupuesto = '" + matriz.getPresupuesto() + "' \n"
                    + "      ,Indicador = '" + matriz.getIndicador() + "'      \n"
                    + "      ,Fecha_actualizacion = SYSDATETIME()\n"
                    + "      ,Empleado_actualiza = '" + matriz.getEmpleado_id() + "'\n"
                    + "      ,Estado = '" + matriz.getEstado() + "'\n"
                    + " WHERE Plan_matriz_id = '" + matriz.getPlan_matriz_id() + "'";
            System.out.println(" UpdateMatriz() " + sql);
            db.actualizar(sql);
            mensaje = "Ok##" + matriz.getPlan_matriz_id();
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Plan_matriz.UpdateMatriz() " + e.getMessage() + "Error";
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public Plan_matriz getMatrizByIdMatriz(int id_matriz) {
        Plan_matriz m = new Plan_matriz();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pm.Plan_matriz_id, pm.Que_hacer, pm.Responsable\n"
                    + "      ,pm.Como, pm.Documento_generadi, pm.Indicadores_resultado\n"
                    + "      ,CONVERT(char,pm.Fecha,103)fecha ,pm.Indicador, pm.Plan_accion_id\n"
                    + "      ,pm.Fecha_cracion, pm.Empleado_id, pm.Fecha_actualizacion\n"
                    + "      ,pm.Empleado_actualiza, pm.Estado\n"
                    + "	  ,CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "      ,(Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = pm.Empleado_actualiza) Nombre_Actualiza, pm.Presupuesto\n"
                    + "  FROM Plan_matriz pm\n"
                    + "  inner join Empleado e\n"
                    + "  on pm.Empleado_id = e.Empleado_id\n"
                    + "  WHERE PM.Plan_matriz_id = '" + id_matriz + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                m.setPlan_matriz_id(res.getInt("Plan_matriz_id"));
                m.setQue_hacer(res.getString("Que_hacer"));
                m.setResponsable(res.getString("Responsable"));
                m.setComo(res.getString("Como"));
                m.setDocumento_generadi(res.getString("Documento_generadi"));
                m.setIndicadores_resultado(res.getString("Indicadores_resultado"));
                m.setFecha(res.getString("Fecha"));
                m.setIndicador(res.getString("Indicador"));
                m.setPlan_accion_id(res.getInt("Plan_accion_id"));
                m.setFecha_cracion(res.getString("Fecha_cracion"));
                m.setEmpleado_id(res.getInt("Empleado_id"));
                m.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                m.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                m.setEstado(res.getInt("Estado"));
                m.setPresupuesto(res.getFloat("Presupuesto"));

                m.setNombre_creador(res.getString("Nombre_creador"));
                m.setNombre_actualizador(res.getString("Nombre_actualizador"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_matrizModel.getMatrizByIdMatriz() " + e.getMessage());
        }
        return m;
    }

    public Plan_matriz getMatrizByPlanAccionId(int plan_accion) {
        Plan_matriz m = new Plan_matriz();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pm.Plan_matriz_id, pm.Que_hacer, pm.Responsable\n"
                    + "      ,pm.Como, pm.Documento_generadi, pm.Indicadores_resultado\n"
                    + "      ,CONVERT(char,pm.Fecha,103)fecha,pm.Indicador, pm.Plan_accion_id\n"
                    + "      ,pm.Fecha_cracion, pm.Empleado_id, pm.Fecha_actualizacion\n"
                    + "      ,pm.Empleado_actualiza, pm.Estado\n"
                    + "	  ,CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "      ,(Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = pm.Empleado_actualiza) Nombre_Actualiza, pm.Presupuesto\n"
                    + "  FROM Plan_matriz pm\n"
                    + "  inner join Empleado e\n"
                    + "  on pm.Empleado_id = e.Empleado_id\n"
                    + "  WHERE PM.Plan_accion_id = '" + plan_accion + "' and pm.estado='1' ";
            System.out.println(" getMatrizByPlanAccionId() = " + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                m.setPlan_matriz_id(res.getInt("Plan_matriz_id"));
                m.setQue_hacer(res.getString("Que_hacer"));
                m.setResponsable(res.getString("Responsable"));
                m.setComo(res.getString("Como"));
                m.setDocumento_generadi(res.getString("Documento_generadi"));
                m.setIndicadores_resultado(res.getString("Indicadores_resultado"));
                m.setPresupuesto(res.getFloat("Presupuesto"));
                m.setIndicador(res.getString("Indicador"));
                m.setPlan_accion_id(res.getInt("Plan_accion_id"));
                m.setFecha_cracion(res.getString("Fecha_cracion"));
                m.setEmpleado_id(res.getInt("Empleado_id"));
                m.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                m.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                m.setEstado(res.getInt("Estado"));

                m.setNombre_creador(res.getString("Nombre_creador"));
                m.setNombre_actualizador(res.getString("Nombre_Actualiza"));
            } else {
                m = null;
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_matrizModel.getMatrizByIdMatriz() " + e.getMessage());
        }
        return m;
    }

    public List<Plan_matriz> GetAllMatriz() {
        List<Plan_matriz> mm = new ArrayList<Plan_matriz>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pm.Plan_matriz_id, pm.Que_hacer, pm.Responsable\n"
                    + "      ,pm.Como, pm.Documento_generadi, pm.Indicadores_resultado\n"
                    + "      ,pm.Fecha,pm.Indicador, pm.Plan_accion_id\n"
                    + "      ,pm.Fecha_cracion, pm.Empleado_id, pm.Fecha_actualizacion\n"
                    + "      ,pm.Empleado_actualiza, pm.Estado\n"
                    + "	  ,CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "      ,(Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = pm.Empleado_actualiza) Nombre_Actualiza\n"
                    + "  FROM Plan_matriz pm\n"
                    + "  inner join Empleado e\n"
                    + "  on pm.Empleado_id = e.Empleado_id\n"
                    + "  WHERE PM.Estado = '1'";
            System.out.println(" GetAllMatriz() = " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_matriz m = new Plan_matriz();
                m.setPlan_matriz_id(res.getInt("Plan_matriz_id"));
                m.setQue_hacer(res.getString("Que_hacer"));
                m.setResponsable(res.getString("Responsable"));
                m.setComo(res.getString("Como"));
                m.setDocumento_generadi(res.getString("Documento_generadi"));
                m.setIndicadores_resultado(res.getString("Indicadores_resultado"));
                m.setFecha(res.getString("Fecha").replace(" ", ""));
                m.setIndicador(res.getString("Indicador"));
                m.setPlan_accion_id(res.getInt("Plan_accion_id"));
                m.setFecha_cracion(res.getString("Fecha_cracion"));
                m.setEmpleado_id(res.getInt("Empleado_id"));
                m.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                m.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                m.setEstado(res.getInt("Estado"));

                m.setNombre_creador(res.getString("Nombre_creador"));
                m.setNombre_actualizador(res.getString("Nombre_Actualiza"));

                mm.add(m);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_matrizModel.getMatrizByIdMatriz() " + e.getMessage());
        }
        return mm;
    }

    public Plan_matriz getMatrizByPlanAccionIdCalendario(int plan_accion) {
        Plan_matriz m = new Plan_matriz();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pm.Plan_matriz_id, pm.Que_hacer, pm.Responsable\n"
                    + "      ,pm.Como, pm.Documento_generadi, pm.Indicadores_resultado\n"
                    + "      ,CONVERT(char,pm.Fecha,103)fecha,pm.Indicador, pm.Plan_accion_id\n"
                    + "      ,pm.Fecha_cracion, pm.Empleado_id, pm.Fecha_actualizacion\n"
                    + "      ,pm.Empleado_actualiza, pm.Estado\n"
                    + "	  ,CONCAT(e.Apellido_paterno,' ', e.Apellido_materno, ' ', e.Nombre) Nombre_creador\n"
                    + "      ,(Select CONCAT(em.Apellido_paterno,' ', em.Apellido_materno, ' ', em.Nombre) from Empleado em where em.Empleado_id = pm.Empleado_actualiza) Nombre_Actualiza, pm.Presupuesto\n"
                    + "  FROM Plan_matriz pm\n"
                    + "  inner join Empleado e\n"
                    + "  on pm.Empleado_id = e.Empleado_id\n"
                    + "  WHERE PM.Plan_matriz_id = '" + plan_accion + "' and pm.estado='1' ";
            System.out.println(" getMatrizByPlanAccionId() = " + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                m.setPlan_matriz_id(res.getInt("Plan_matriz_id"));
                m.setQue_hacer(res.getString("Que_hacer"));
                m.setResponsable(res.getString("Responsable"));
                m.setComo(res.getString("Como"));
                m.setDocumento_generadi(res.getString("Documento_generadi"));
                m.setIndicadores_resultado(res.getString("Indicadores_resultado"));
                m.setPresupuesto(res.getFloat("Presupuesto"));
                m.setIndicador(res.getString("Indicador"));
                m.setPlan_accion_id(res.getInt("Plan_accion_id"));
                m.setFecha_cracion(res.getString("Fecha_cracion"));
                m.setEmpleado_id(res.getInt("Empleado_id"));
                m.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                m.setEmpleado_actualiza(res.getInt("Empleado_actualiza"));
                m.setEstado(res.getInt("Estado"));

                m.setNombre_creador(res.getString("Nombre_creador"));
                m.setNombre_actualizador(res.getString("Nombre_Actualiza"));
            } else {
                m = null;
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_matrizModel.getMatrizByIdMatriz() " + e.getMessage());
        }
        return m;
    }

    public Plan_matriz getMatrizByIndicadorId(int indicador_id) {
        Plan_matriz indica = new Plan_matriz();
        try {

            List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
            Plan_indica_resultado indicador = new Plan_indica_resultado();
            Plan_indica_resultadoModel indica_model = new Plan_indica_resultadoModel();
            indicador = indica_model.GetIndicadorById(Integer.toString(indicador_id));
            indicadores.add(indicador);

            indica = getMatrizByPlanAccionIdCalendario(indicador.getPlan_matriz_id());
            indica.setPlan_indica_resultado(indicadores);

        } catch (Exception e) {
            System.out.println("Modelo.Plan_matrizModel.getMatrizByIndicadorId() " + e.getMessage());
        }
        return indica;
    }
}
