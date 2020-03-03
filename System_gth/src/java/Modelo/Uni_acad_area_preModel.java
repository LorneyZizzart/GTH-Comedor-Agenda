/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Uni_acad_area_pre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Uni_acad_area_preModel {

    public Uni_acad_area_pre GetAreaPregunta(String gestion, String unidad_id) {
        Uni_acad_area_pre area = new Uni_acad_area_pre();
        try {
            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Uni_acad_area_pre_id, Nombre, Estado, Gestion, Unidad_academica_id,Puntuacion\n"
                    + "     FROM Uni_acad_area_pre\n"
                    + "    WHERE Gestion = '" + gestion + "' AND Unidad_academica_id = '" + unidad_id + "' AND Estado = '1'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                area.setUni_acad_area_pre_id(res.getInt("Uni_acad_area_pre_id"));
                area.setNombre(res.getString("Nombre"));
                area.setEstado(res.getInt("Estado"));
                area.setGestion(res.getString("Gestion"));
                area.setUnidad_academica_id(res.getInt("Unidad_academica_id"));
                area.setPuntuacion(res.getInt("puntuacion"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Uni_acad_area_preModel.GetAreaPregunta() " + e.getMessage());
        }
        return area;
    }

    public List<Uni_acad_area_pre> GetProfAreasNota(String Empleado_id, String Gestion) {
        List<Uni_acad_area_pre> areas = new ArrayList<Uni_acad_area_pre>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String gestion_db = "";
            String ges = "SELECT  LTRIM(RTRIM(Gestion))Gestion FROM Cuestionario_gestion where Cuestionario_gestion_id = '" + Gestion + "'";
            ResultSet resg = db.consulta(ges);
            if (resg.next()) {
                gestion_db = resg.getString("Gestion");
            }

            String sql = "Select * from( SELECT uaap.Uni_acad_area_pre_id, LTRIM(RTRIM(uaap.Nombre))Nombre, uaap.Estado, uaap.Gestion, uaap.Unidad_academica_id, uaap.Puntuacion, ed.Codigo_uab,\n"
                    + "(Select (SUM(B.PUNTUACION)/(SELECT COUNT(*) FROM Uni_acad_pre WHERE Uni_acad_area_pre_id = uaap.Uni_acad_area_pre_id) )noTA\n"
                    + "from Uni_acad_pre a \n"
                    + "INNER JOIN Uni_acad_emple_res b \n"
                    + "ON a.Uni_acad_pre = b.Uni_acad_pre \n"
                    + "WHERE a.Uni_acad_area_pre_id = uaap.Uni_acad_area_pre_id AND B.Empleado_docente_id =ed.Empleado_docente_id ) NOTA\n"
                    + "FROM  Uni_acad_area_pre uaap, Empleado_docente ed\n"
                    + "where uaap.Gestion = '" + gestion_db + "' and ed.Empleado_id = '" + Empleado_id + "' and ed.Estado = '1') as Cuentio where NOTA > 0";
            System.out.println(sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Uni_acad_area_pre a = new Uni_acad_area_pre();
                a.setUni_acad_area_pre_id(res.getInt("Uni_acad_area_pre_id"));
                a.setNombre(res.getString("Nombre"));
                a.setEstado(res.getInt("Estado"));
                a.setGestion(res.getString("Gestion"));
                a.setUnidad_academica_id(res.getInt("Unidad_academica_id"));
                a.setPuntuacion(res.getInt("Puntuacion"));
                a.setNota(res.getFloat("Nota"));

                int nota_entero = (int) a.getNota();
                //String pintar = Get_CollorPintar(nota_entero, Integer.toString(a.getPuntuacion()));
                //a.setCss(pintar);
                a = Get_CollorPintar(a);
                areas.add(a);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Uni_acad_area_preModel.GetProfAreasNota() " + e.getMessage());
        }
        return areas;
    }

    public Uni_acad_area_pre Get_CollorPintar(Uni_acad_area_pre a) {
        String color = "ed1c24";
        String seccion = "";
        try {
            String puntuacion = Integer.toString(a.getPuntuacion());
            int nota = (int) a.getNota();
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select b.css , b.seccion \n"
                    + "from Banco_respuestas b \n"
                    + "	 inner join Tipo t \n"
                    + "	 on b.Tipo_id = t.Tipo_id \n"
                    + "where t.nombre like('%" + puntuacion + "%') and b.Opcion = '" + nota + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                color = res.getString("Css");
                seccion = res.getString("Seccion");                
                a.setNota_estado(seccion);
                a.setCss(color);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Reporte_evaluacionesModelo.Get_CollorPintar() " + e.getMessage());
        }
        return a;
    }

}
