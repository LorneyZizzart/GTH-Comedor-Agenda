package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Estado_civil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estado_civilModelo {

    public List<Estado_civil> GetAllEstadoCivil() {
        List<Estado_civil> civiles = new ArrayList<Estado_civil>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "SELECT Estado_civil_id, Nombre, Estado\n"
                    + "FROM Estado_civil \n"
                    + "where Estado = '1'";
            ResultSet res = db.consulta(Sql);
            while (res.next()) {
                Estado_civil e = new Estado_civil();
                e.setEstado_civil_id(res.getInt("Estado_civil_id"));
                e.setNombre(res.getString("Nombre"));
                e.setEstado(res.getInt("Estado"));
                
                civiles.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Estado_civilModelo.GetAllEstadoCivil() " + e.getMessage());
        }
        return civiles;
    }

}
