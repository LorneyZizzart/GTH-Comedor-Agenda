/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSisAcad;
import Conexion.ConectaSqlServer;
import Entidad.Uni_acad_pre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Uni_acad_preModel {

    public List<Uni_acad_pre> getPreguntasByArea(String area) {
        List<Uni_acad_pre> preguntas = new ArrayList<Uni_acad_pre>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Uni_acad_pre, Pregunta, Estado, Orden, Uni_acad_area_pre_id, Nom_bd\n"
                    + "  FROM Uni_acad_pre\n"
                    + " WHERE Uni_acad_area_pre_id ='" + area + "' and Estado ='1' order by Orden";
            ResultSet res = db.consulta(sql);

            while (res.next()) {
                Uni_acad_pre p = new Uni_acad_pre();
                p.setUni_acad_pre(res.getInt("Uni_acad_pre"));
                p.setPregunta(res.getString("Pregunta"));
                p.setEstado(res.getInt("Estado"));
                p.setOrden(res.getInt("Orden"));
                p.setUni_acad_area_pre_id(res.getInt("Uni_acad_area_pre_id"));
                p.setNom_bd(res.getString("Nom_bd"));
                preguntas.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
        }
        return preguntas;
    }

    public String ImportaNotaSisAcad(String doc_uab, String docente_id, String area_id, String gestion) {
        String mensaje = "Ok";
        try {
            List<Uni_acad_pre> preguntas = new ArrayList<Uni_acad_pre>();
            preguntas = getPreguntasByArea(area_id);
            preguntas = AniadimosnotaAlProfesor(preguntas, gestion, doc_uab);
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            for (Uni_acad_pre pregunta : preguntas) {
                String sql = "INSERT INTO Uni_acad_emple_res(Empleado_docente_id, Uni_acad_pre, Puntuacion)\n"
                        + "   VALUES('" + docente_id + "','" + pregunta.getUni_acad_pre() + "','" + pregunta.getNota() + "')";
                System.out.println(" - " + sql);
                db.insertar(sql);
            }
            db.cierraConexion();

        } catch (SQLException e) {
            mensaje = "Modelo.Uni_acad_preModel.ImportaNotaSisAcad() " + e.getMessage();
            System.out.println("Modelo.Uni_acad_preModel.ImportaNotaSisAcad() " + e.getMessage());
        }
        return mensaje;
    }

    public List<Uni_acad_pre> AniadimosnotaAlProfesor(List<Uni_acad_pre> preguntas, String gestion, String codigoUAB) {
        try {
            Conexion.ConectaSisAcad acad = new ConectaSisAcad();
            acad.conectar();
            String sql = "SELECT codigo_personal, profesor, round(grupo1,2) grupo1, round(grupo2,2) grupo2, round(grupo3,2) grupo3,round(grupo4,2) grupo4,\n"
                    + "       round(grupo5,2) grupo5, round(grupo6,2) grupo6,round(grupo7,2) grupo7,round(grupo8,2) grupo8 , \n"
                    + "       round( ((round(grupo1,2) + round(grupo2,2) + round(grupo3,2) +round(grupo4,2) +round(grupo5,2) + round(grupo6,2) +round(grupo7,2) +round(grupo8,2) ) / 8),2 ) promedio \n"
                    + "       FROM ( \n"
                    + "       SELECT codigo_personal, profesor, sum(grupo1)/count(*) grupo1,sum(grupo2)/count(*) grupo2,sum(grupo3)/count(*) grupo3,\n"
                    + "                 sum(grupo4)/count(*) grupo4, sum(grupo5)/count(*) grupo5, sum(grupo6)/count(*) grupo6, sum(grupo7)/count(*) grupo7, sum(grupo8)/count(*) grupo8 \n"
                    + "                 FROM eval_doc_promedio_ver2 where grupo1 != 0 and grupo2 != 0 and grupo3 != 0 and grupo4 != 0 and grupo5 != 0 and grupo6 != 0 and \n"
                    + "                 grupo7 != 0 and grupo8 != 0  and curso_carga_id like '" + gestion + "%' and codigo_personal ='" + codigoUAB + "' group by codigo_personal, profesor ) ORDER BY profesor";
            ResultSet res = acad.consulta(sql);
            if (res.next()) {
                float grupo1 = res.getFloat("grupo1") / 2;
                float grupo2 = res.getFloat("grupo2") / 2;
                float grupo3 = res.getFloat("grupo3") / 2;
                float grupo4 = res.getFloat("grupo4") / 2;
                float grupo5 = res.getFloat("grupo5") / 2;
                float grupo6 = res.getFloat("grupo6") / 2;
                float grupo7 = res.getFloat("grupo7") / 2;
                float grupo8 = res.getFloat("grupo8") / 2;
                preguntas.get(0).setNota(grupo1);
                preguntas.get(1).setNota(grupo2);
                preguntas.get(2).setNota(grupo3);
                preguntas.get(3).setNota(grupo4);
                preguntas.get(4).setNota(grupo5);
                preguntas.get(5).setNota(grupo6);
                preguntas.get(6).setNota(grupo7);
                preguntas.get(7).setNota(grupo8);

            }
            acad.cierraConexion();
        } catch (SQLException e) {
        }
        return preguntas;
    }

    public List<Uni_acad_pre> getPreguntasAndNota(String Empleado_id, String Uni_acad_area_pre_id, String gestion) {
        List<Uni_acad_pre> preguntas = new ArrayList<Uni_acad_pre>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select a.*, b.Puntuacion Nota, d.Puntuacion as Sobre\n"
                    + "from Uni_acad_pre a \n"
                    + "inner join Uni_acad_emple_res b\n"
                    + "on a.Uni_acad_pre = b.Uni_acad_pre\n"
                    + "inner join Empleado_docente c\n"
                    + "on c.Empleado_docente_id = b.Empleado_docente_id\n"
                    + "inner join Uni_acad_area_pre d \n"
                    + "on a.Uni_acad_area_pre_id = d.Uni_acad_area_pre_id\n"
                    + "where a.Uni_acad_area_pre_id = '" + Uni_acad_area_pre_id + "' \n"
                    + "--and b.Empleado_docente_id = '1' \n"
                    + "and c.Empleado_id ='" + Empleado_id + "'\n"
                    + "and c.Estado = '1' and c.Gestion = '" + gestion + "' and a.Estado = '1'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Uni_acad_pre p = new Uni_acad_pre();
                p.setUni_acad_pre(res.getInt("Uni_acad_pre"));
                p.setPregunta(res.getString("Pregunta"));
                p.setEstado(res.getInt("Estado"));
                p.setOrden(res.getInt("Orden"));
                p.setUni_acad_area_pre_id(res.getInt("Uni_acad_area_pre_id"));
                p.setNom_bd(res.getString("Nom_bd"));

                p.setNota(res.getFloat("Nota"));
                p.setSobre(res.getInt("Sobre"));

                p = Get_CollorPintar(p);
                preguntas.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Uni_acad_preModel.getPreguntasAndNota() " + e.getMessage());
        }
        return preguntas;
    }

    public Uni_acad_pre Get_CollorPintar(Uni_acad_pre a) {
        String color = "ed1c24";
        String seccion = "";
        try {
            String puntuacion = Integer.toString(a.getSobre());
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
