/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Reporte_gth;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Roberto
 */
public class Reporte_gthModel {

    public List<Reporte_gth> getReporte(String id_cuestionario) {
        List<Reporte_gth> reportes = new ArrayList<Reporte_gth>();
        List<Reporte_gth> Evaluador_noevaluo = new ArrayList<Reporte_gth>();
        List<Reporte_gth> reportes_v = new ArrayList<Reporte_gth>();
        reportes = Lista(id_cuestionario);
        Evaluador_noevaluo = ListaNoevaluo(id_cuestionario);
        List<Integer> id_;
        id_ = new ArrayList<Integer>();
        for (Reporte_gth r : reportes) {
            id_.add(r.getA_emplado_id());
        }

        Set<Integer> hashSet = new HashSet<Integer>(id_);
        id_.clear();
        id_.addAll(hashSet);

        for (Integer i : id_) {

            Reporte_gth re = new Reporte_gth();
            int cuenta_o = 0;
            for (Reporte_gth r : reportes) {

                if (i == r.getA_emplado_id()) {
                    if (r.getLlenado() == 0) {
                        cuenta_o++;
                    }
                    re.setA_emplado_id(i);
                    re.setEvaluado(r.getEvaluado());
                    re.setLlenado(cuenta_o);
                }
            }
            reportes_v.add(re);
        }

        for (Reporte_gth r : reportes_v) {

            int cuenta_o = 0;
            if (r.getA_emplado_id() == 178) {
                System.out.println("Analizamos - " + r.getA_emplado_id() + " - " + r.getEvaluado());
            }
            for (Reporte_gth a : Evaluador_noevaluo) {
                if (r.getA_emplado_id() == a.getEvalua_empleado_id()) {
                    System.out.println(" -- " + a.getEvalua_empleado_id() + " - " + a.getEvaluador() + " - " + a.getEvaluado() + " - " + a.getLlenado());
                    if (a.getLlenado() == 0) {
                        cuenta_o++;
                    }
                }
            }

            r.setNo_evaluo(cuenta_o);
        }
System.out.println("----------------------------- ");
        for (Reporte_gth r : reportes_v) {
            System.out.println(r.getA_emplado_id() + " - " + r.getEvaluado() + " - " + r.getLlenado() + " - " + r.getNo_evaluo());
        }

        return reportes_v;
    }

    public List<Reporte_gth> Lista(String id_cuestionario) {
        List<Reporte_gth> reportes = new ArrayList<Reporte_gth>();
        try {
            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select ce.A_empleado_id, dbo.Nombre_de_empleado(ce.A_empleado_id) Evaluado,  ce.Evalua_empleado_id, dbo.Nombre_de_empleado(ce.Evalua_empleado_id) Evaluador,\n"
                    + "(select COUNT(*) from Cuestioario_evalua z where z.Cuestionario_gestion_id=24 and z.Evalua_empleado_id = ce.Evalua_empleado_id and z.A_empleado_id = ce.A_empleado_id and (z.Tipo_cliente = 'E' or z.Tipo_cliente is null)) Evaluaciones,\n"
                    + "(select ISNULL( sum(LLeno_cuestionario),0) from Cuestioario_evalua z where z.Cuestionario_gestion_id=24 and z.Evalua_empleado_id = ce.Evalua_empleado_id and z.A_empleado_id = ce.A_empleado_id and (z.Tipo_cliente = 'E' or z.Tipo_cliente is null)) Llenado\n"
                    + "\n"
                    + "from Cuestioario_evalua ce\n"
                    + "where ce.Cuestionario_gestion_id=24 \n"
                    + " and Evalua_empleado_id not in(select Empleado_id from Empleado_cargo where Nivel_id in (20,1020,1021,1022))\n"
                    + "  and Evalua_empleado_id not in(select Empleado_id from Empleado_cargo where Nivel_id in (20,1020,1021,1022))\n"
                    + "     and (ce.Tipo_cliente = 'E' or ce.Tipo_cliente is null) \n"
                    + "group by ce.A_empleado_id, ce.Evalua_empleado_id\n"
                    + "Order by dbo.Nombre_de_empleado(ce.A_empleado_id),ce.Evalua_empleado_id";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Reporte_gth ress = new Reporte_gth();

                ress.setA_emplado_id(res.getInt("A_empleado_id"));
                ress.setEvaluado(res.getString("Evaluado"));
                ress.setEvalua_empleado_id(res.getInt("Evalua_empleado_id"));
                ress.setEvaluador(res.getString("Evaluador"));
                ress.setEvaluaciones(res.getInt("Evaluaciones"));
                ress.setLlenado(res.getInt("Llenado"));
                reportes.add(ress);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Reporte_gthModel.Lista() " + e.getMessage());
        }
        return reportes;
    }

    public List<Reporte_gth> ListaNoevaluo(String id_cuestionario) {
        List<Reporte_gth> reportes = new ArrayList<Reporte_gth>();
        try {
            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select ce.Evalua_empleado_id, dbo.Nombre_de_empleado(ce.Evalua_empleado_id) Evaluador, ce.A_empleado_id, dbo.Nombre_de_empleado(ce.A_empleado_id) Evaluado,\n"
                    + "(select COUNT(*) from Cuestioario_evalua z where z.Cuestionario_gestion_id=24 and \n"
                    + "z.Evalua_empleado_id = ce.Evalua_empleado_id and z.A_empleado_id = ce.A_empleado_id and (z.Tipo_cliente = 'E' or z.Tipo_cliente is null)) Evaluaciones,\n"
                    + "(select ISNULL( sum(LLeno_cuestionario),0) from Cuestioario_evalua z where z.Cuestionario_gestion_id=24 and z.Evalua_empleado_id = ce.Evalua_empleado_id and z.A_empleado_id = ce.A_empleado_id and (z.Tipo_cliente = 'E' or z.Tipo_cliente is null)) Llenado\n"
                    + "from Cuestioario_evalua ce\n"
                    + "where ce.Cuestionario_gestion_id=24 \n"
                    + " and Evalua_empleado_id not in(select Empleado_id from Empleado_cargo where Nivel_id in (20,1020,1021,1022))\n"
                    + "  and Evalua_empleado_id not in(select Empleado_id from Empleado_cargo where Nivel_id in (20,1020,1021,1022))\n"
                    + "     and (ce.Tipo_cliente = 'E' or ce.Tipo_cliente is null) \n"
                    + "group by ce.A_empleado_id, ce.Evalua_empleado_id\n"
                    + "Order by dbo.Nombre_de_empleado(ce.Evalua_empleado_id), dbo.Nombre_de_empleado(ce.A_empleado_id)";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Reporte_gth ress = new Reporte_gth();

                ress.setA_emplado_id(res.getInt("A_empleado_id"));
                ress.setEvaluado(res.getString("Evaluado"));
                ress.setEvalua_empleado_id(res.getInt("Evalua_empleado_id"));
                ress.setEvaluador(res.getString("Evaluador"));
                ress.setEvaluaciones(res.getInt("Evaluaciones"));
                ress.setLlenado(res.getInt("Llenado"));
                reportes.add(ress);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Reporte_gthModel.Lista() " + e.getMessage());
        }
        return reportes;
    }

}
