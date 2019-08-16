/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.A_TipoTarea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_TipoTareaModel {
    
     public List<A_TipoTarea> getAllTipoTarea() {
        List<A_TipoTarea> tiposTarea = new ArrayList<A_TipoTarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idTipoTarea, nombre, estado "
                       + "FROM ATipoTarea "
                       + " WHERE Estado <> 6";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_TipoTarea tipoTarea = new A_TipoTarea();
                tipoTarea.setIdTipoTarea(res.getInt("idTipoTarea"));
                tipoTarea.setNombreTarea(res.getString("nombre"));
                tipoTarea.setEstadoTipoTarea(res.getInt("estado"));
                tiposTarea.add(tipoTarea);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_TipoTareaModel.getAllTipoTarea() " + e.getMessage());
        }
        return tiposTarea;
    }
     
    public A_TipoTarea getTipoTareaById(int idTipoTarea) {
        A_TipoTarea tipoTarea = new A_TipoTarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idTipoTarea, nombre, estado "
                        + " FROM ATipoTarea "
                        + "  WHERE idTipoTarea = " + idTipoTarea;

            ResultSet res = db.consulta(sql);
            if (res.next()) {
                tipoTarea.setIdTipoTarea(res.getInt("idTipoTarea"));
                tipoTarea.setNombreTarea(res.getString("nombre"));
                tipoTarea.setEstadoTipoTarea(res.getInt("estado"));


            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.A_TipoTareaModel.getTipoTareaById() " + e.getMessage());
        }
        return tipoTarea;
    } 
     
     public String SaveOrUpdate(A_TipoTarea tipoTarea) {
        String respuesta = null;
        try {
            if (tipoTarea.getIdTipoTarea()== 0) {
                //insertar
                respuesta = SaveTipoTarea(tipoTarea);
            } else {
                // Actualizar
                respuesta = ActualizarTipoTarea(tipoTarea);
            }

        } catch (Exception e) {
        }
        return respuesta;
    }
     
     private String SaveTipoTarea(A_TipoTarea tipoTarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO ATipoTarea\n"
                    + "           (nombre, estado)"
                    + "     VALUES\n"
                    + "           ('" + tipoTarea.getNombreTarea()+ "',"  + tipoTarea.getEstadoTipoTarea()+ ")";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_TipoTareaModel.SaveTipoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    private String ActualizarTipoTarea(A_TipoTarea tipoTarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "UPDATE ATipoTarea \n"
                    + "   SET nombre = '" + tipoTarea.getNombreTarea()+ "' \n"
                    + "      ,estado = " + tipoTarea.getEstadoTipoTarea()+ " \n"
                    + " WHERE idTipoTarea = " + tipoTarea.getIdTipoTarea();
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_TipoTareaModel.ActualizarTipoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteTipoTarea(int idTipoTarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE ATipoTarea \n"
                    + "   SET estado = 6 \n"
                    + " WHERE idTipoTarea = " + idTipoTarea ;

            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_TipoTareaModel.DeleteTipoTarea() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
