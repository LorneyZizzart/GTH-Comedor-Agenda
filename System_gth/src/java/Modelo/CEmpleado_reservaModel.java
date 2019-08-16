package Modelo;

import Conexion.ConectaSqlServer;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CEmpleado_reservaModel {
    
    public int CantidaReservas(int idEmpleado) {
        int cantidad = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select count(*) cantidad from CEmpleado_Reserva\n"
                    + "where IdEmpleado = '" + idEmpleado + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                cantidad = res.getInt("cantidad");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.CEmpleado_reservaModel.CantidaReservas() " + e.getMessage());
        }
        return cantidad;
    }
    
}
