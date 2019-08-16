package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Banco_respuestas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Banco_respuestasModelo {

    public List<Banco_respuestas> GetAllBancoRespuestasByTipo_id(int tipo_id) {
        List<Banco_respuestas> respuestas = new ArrayList<Banco_respuestas>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Banco_Respuestas_id, Opcion, Css, Seccion, Tipo_id\n"
                    + "  FROM Banco_respuestas \n"
                    + " WHERE Tipo_id = '" + tipo_id + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Banco_respuestas i = new Banco_respuestas();
                i.setBanco_Respuestas_id(res.getInt("Banco_Respuestas_id"));
                i.setOpcion(res.getString("Opcion"));
                i.setCss(res.getString("Css"));
                i.setSeccion(res.getString("Seccion"));
                i.setTipo_id(res.getInt("Tipo_id"));
                respuestas.add(i);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Banco_respuestasModelo.GetAllBancoRespuestasByTipo_id() " + e.getMessage());
        }
        return respuestas;
    }

}
