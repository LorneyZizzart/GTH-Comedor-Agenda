/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cuestionario_respuestas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Cuestionario_respuestasModelo {

    public String Save_respuestas(List<Cuestionario_respuestas> respuestas) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            int Cuestionario_evalua_id = respuestas.get(0).getCuestionario_evalua_id();
            int existe = 0;
            String sqlverifica = "select LLeno_cuestionario from Cuestioario_evalua where Cuestionario_evalua_id = '" + Cuestionario_evalua_id + "' ";
            ResultSet resp = db.consulta(sqlverifica);
            if (resp.next()) {
                existe = resp.getInt("LLeno_cuestionario");
            }
            if (existe == 0) {
                for (Cuestionario_respuestas res : respuestas) {
                    String sql = "INSERT INTO Cuestionario_respuestas\n"
                            + "            (Cuestionario_evalua_id, Pregunta_id, Nota)\n"
                            + "     VALUES ('" + res.getCuestionario_evalua_id() + "','" + res.getPregunta_id() + "','" + res.getNota() + "')";
                    db.insertar(sql);
                }

                Cuestionario_evaluaModel cues_eva = new Cuestionario_evaluaModel();
                String res = cues_eva.update_lleno_cuestionario(Cuestionario_evalua_id);
                respuesta = res;
            }else{
                respuesta = "Ya se registro encuesta";
            }

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Cuestionario_respuestasModelo.Save_respuestas() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

}
