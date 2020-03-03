package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Unidad_academica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Unidad_academicaModel {

    public List<Unidad_academica> GetAllUnidadAcademica() {
        List<Unidad_academica> unidades = new ArrayList<Unidad_academica>();
        try {
            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Unidad_academica_id, Nombre, Descripcion, Abreviatura, Estado\n"
                    + "FROM Unidad_academica where  Estado = 1 order by Unidad_academica_id";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Unidad_academica u = new Unidad_academica();
                u.setUnidad_academica_id(res.getInt("Unidad_academica_id"));
                u.setNombre(res.getString("Nombre"));
                u.setDescripcion(res.getString("Descripcion"));
                u.setAbreviatura(res.getString("Abreviatura"));
                u.setEstado(res.getInt("Estado"));
                unidades.add(u);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Unidad_academicaModel.GetAllUnidadAcademica() " + e.getMessage());
        }
        return unidades;
    }

}
