/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.A_EstadoTarea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_EstadoTareaModel {
    
    public List<A_EstadoTarea> getAllEstadoTarea() {
        List<A_EstadoTarea> estadosTarea = new ArrayList<A_EstadoTarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idEstadoTarea, nombre, estado "
                       + "FROM AEstadoTarea "
                       + " WHERE Estado <> 6";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_EstadoTarea estadoTarea = new A_EstadoTarea();
                estadoTarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                estadoTarea.setNombreEstadoTarea(res.getString("nombre"));
                estadoTarea.setEstadoEstadoTarea(res.getInt("estado"));
                estadosTarea.add(estadoTarea);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_EstadoTareaModel.getAllEstadoTarea() " + e.getMessage());
        }
        return estadosTarea;
    }
    
    public A_EstadoTarea getEstadoTareaById(int idEstadoTarea) {
        A_EstadoTarea estadoTarea = new A_EstadoTarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idEstadoTarea, nombre, estado "
                        + " FROM AEstadoTarea "
                        + "  WHERE idEstadoTarea = " + idEstadoTarea;

            ResultSet res = db.consulta(sql);
            if (res.next()) {
                estadoTarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                estadoTarea.setNombreEstadoTarea(res.getString("nombre"));
                estadoTarea.setEstadoEstadoTarea(res.getInt("estado"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.A_EstadoTareaModel.getEstadoTareaById() " + e.getMessage());
        }
        return estadoTarea;
    }
    
    public String SaveOrUpdate(A_EstadoTarea estadoTarea) {
        String respuesta = null;
        try {
            if (estadoTarea.getIdEstadoTarea()== 0) {
                //insertar
                respuesta = SaveEstadoTarea(estadoTarea);
            } else {
                // Actualizar
                respuesta = ActualizarEstadoTarea(estadoTarea);
            }

        } catch (Exception e) {
        }
        return respuesta;
    }
    
    private String SaveEstadoTarea(A_EstadoTarea estadoTarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO AEstadoTarea\n"
                    + "           (nombre, estado)"
                    + "     VALUES\n"
                    + "           ('" + estadoTarea.getNombreEstadoTarea()+ "',"  + estadoTarea.getEstadoEstadoTarea()+ ")";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_EstadoTareaModel.SaveEstadoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    private String ActualizarEstadoTarea(A_EstadoTarea estadoTarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "UPDATE AEstadoTarea \n"
                    + "   SET nombre = '" + estadoTarea.getNombreEstadoTarea()+ "' \n"
                    + "      ,estado = " + estadoTarea.getEstadoEstadoTarea()+ " \n"
                    + " WHERE idEstadoTarea = " + estadoTarea.getIdEstadoTarea();
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_EstadoTareaModel.ActualizarEstadoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteEstadoTarea(int idEstadoTarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE AEstadoTarea \n"
                    + "   SET estado = 6 \n"
                    + " WHERE idEstadoTarea = " + idEstadoTarea ;

            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_EstadoTareaModel.DeleteEstadoTarea() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
