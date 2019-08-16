package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Tipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoModelo {

    public List<Tipo> getAllTipo() {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Tipo_id, Nombre, Html, Estado FROM Tipo";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Tipo t = new Tipo();
                t.setTipo_id(res.getInt("Tipo_id"));
                t.setNombre(res.getString("Nombre"));
                t.setHtml(res.getString("Html"));
                t.setEstado(res.getInt("Estado"));
                tipos.add(t);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.TipoModelo.getAllTipo() " + e.getMessage());
        }
        return tipos;
    }

    public List<Tipo> GetAllTipoActivos() {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Tipo_id, Nombre, Html, Estado FROM Tipo WHERE Estado = '1'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Tipo t = new Tipo();
                t.setTipo_id(res.getInt("Tipo_id"));
                t.setNombre(res.getString("Nombre"));
                t.setHtml(res.getString("Html"));
                t.setEstado(res.getInt("Estado"));
                tipos.add(t);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.TipoModelo.getAllTipo() " + e.getMessage());
        }
        return tipos;
    }

}
