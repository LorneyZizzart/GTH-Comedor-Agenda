/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_ProcedimientoTarea {
    public List<A_ProcedimientoTarea> getAllEstadoTarea(int idTarea) {
        List<A_ProcedimientoTarea> procedimientos = new ArrayList<A_ProcedimientoTarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idProcedimiento, idTarea, nombre, descripcion, fechaInicio, fechaFinal, horaInicio, horaFinal, estado, fechaRegistro, fechaActualizacion\n" +
                        "FROM AProcedimientoTarea\n" +
                        "WHERE estado <> 6\n" +
                        "AND idTarea = " + idTarea;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
                procedimientos.add(procedimiento);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_EstadoTareaModel.getAllEstadoTarea() " + e.getMessage());
        }
        return procedimientos;
    }
}
