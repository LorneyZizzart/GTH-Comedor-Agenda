/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.A_RepeticionTarea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_RepeticionTareaModel {
    
    public List<A_RepeticionTarea> getAllRepeticionTarea() {
        List<A_RepeticionTarea> repeticionesTarea = new ArrayList<A_RepeticionTarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idRepeticionTarea, nombre, sumarDias, sumarMes, sumarYear, estado "
                       + "FROM ARepeticionTarea "
                       + " WHERE Estado <> 6 ORDER BY nombre ASC";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_RepeticionTarea repeticionTarea = new A_RepeticionTarea();
                repeticionTarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                repeticionTarea.setNombreRepeticion(res.getString("nombre"));
                repeticionTarea.setSumarDias(res.getInt("sumarDias"));
                repeticionTarea.setSumarMes(res.getInt("sumarMes"));
                repeticionTarea.setSumarYear(res.getInt("sumarYear"));
                repeticionTarea.setEstadoRepeticion(res.getInt("estado"));
                repeticionesTarea.add(repeticionTarea);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_RepeticionTareaModel.getAllRepeticionTarea() " + e.getMessage());
        }
        return repeticionesTarea;
    }
    
}
