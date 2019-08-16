package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Pregunta_opcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;

public class Pregunta_opcionModelo {

    public String insertPregunta_opcion(Pregunta_opcion opcion) {
        String respuesta = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Pregunta_opcion\n"
                    + "           (Opcion, Css, Seccion, Pregunta_id)\n"
                    + "     VALUES\n"
                    + "           ('" + opcion.getOpcion() + "','" + opcion.getCss() + "','" + opcion.getSeccion() + "','" + opcion.getPregunta_id() + "')";
            db.insertar(sql);
            db.cierraConexion();
            respuesta = "Ok";
        } catch (SQLException e) {
            respuesta = "Modelo.Pregunta_opcionModelo.insertPregunta_opcion() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String eliminaPregunta_opcionByPregunta_id(int pregunta_id) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE Pregunta_opcion\n"
                    + "      WHERE Pregunta_id = " + pregunta_id + "";
            db.insertar(sql);
            mensaje = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Pregunta_opcionModelo.eliminaPregunta_opcionByPregunta_id() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<Pregunta_opcion> GetPreguntaOpcionByPregunta_id(int pregunta_id) {
        List<Pregunta_opcion> opciones = new ArrayList<Pregunta_opcion>();
        try {

            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "select po.Pregunta_opcion_id, po.Opcion, po.Css, po.Seccion, po.Pregunta_id \n"
                    + "from Pregunta_opcion po where po.Pregunta_id = '" + pregunta_id + "' order by Pregunta_opcion_id";
            ResultSet res = db.consulta(Sql);
            while (res.next()) {
                Pregunta_opcion opcion = new Pregunta_opcion();
                opcion.setPregunta_id(res.getInt("Pregunta_opcion_id"));
                opcion.setOpcion(res.getString("Opcion"));
                opcion.setCss(res.getString("Css"));
                opcion.setSeccion(res.getString("Seccion"));
                opcion.setPregunta_id(res.getInt("Pregunta_id"));
                               
                opciones.add(opcion);
                
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Pregunta_opcionModelo.GetPreguntaOpcionByPregunta_id() " + e.getMessage());
        }
        return opciones;
    }

}
