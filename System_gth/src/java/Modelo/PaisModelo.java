package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Pais;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaisModelo {

    public List<Pais> GetAllPais() {
        List<Pais> paises = new ArrayList<Pais>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Pais_id, PaisNombre\n"
                    + "FROM Pais order by PaisNombre";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Pais p = new Pais();
                p.setPais_id(res.getString("Pais_id"));
                p.setPaisNombre(res.getString("PaisNombre"));
                paises.add(p);
            }
            db.cierraConexion();
        } catch (Exception e) {
            System.out.println("Modelo.PaisModelo.GetAllPais() " + e.getMessage());
        }
        return paises;
    }

}
