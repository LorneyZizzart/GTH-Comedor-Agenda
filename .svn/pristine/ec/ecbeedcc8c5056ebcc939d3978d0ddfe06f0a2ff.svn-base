/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Plan_estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Plan_estadoModel {

    public List<Plan_estado> GetAllEstado() {
        List<Plan_estado> estados = new ArrayList<Plan_estado>();
        try {
            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Plan_estado_id, Nombre, Estado, Posicion\n"
                    + "FROM   Plan_estado\n"
                    + "where Estado = 1 order by Posicion";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Plan_estado p = new Plan_estado();
                p.setPlan_estado_id(res.getInt("Plan_estado_id"));
                p.setNombre(res.getString("Nombre"));
                p.setEstado(res.getInt("Estado"));
                p.setPosicion(res.getInt("Posicion"));
                estados.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Plan_estadoModel.GetAllEstado() " + e.getMessage());
        }
        return estados;
    }

}
