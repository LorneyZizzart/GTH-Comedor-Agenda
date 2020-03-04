package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Log;
import java.sql.SQLException;

public class LogModel {

    public void sabeLog(Log log) {
        try {
            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Log\n"
                    + "           (Empleado_id, Ip, Mac\n"
                    + "           ,Dato_navegador, Nombre_navegador, SistemaOperativo\n"
                    + "           ,URL, Hora, Accion, Usuario)\n"
                    + "     VALUES\n"
                    + "           ('" + log.getEmpleado_id() + "','" + log.getIp() + "','" + log.getMac() + "' \n"
                    + "		    ,'" + log.getDato_navegador() + "','" + log.getNombre_navegador() + "','" + log.getSistemaOperativo() + "' \n"
                    + "			,'" + log.getURL() + "',SYSDATETIME(),'" + log.getAccion() + "','" + log.getUsuario() + "')";
            db.insertar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.LogModel.sabeLog() " + e.getMessage());
        }
    }

}
