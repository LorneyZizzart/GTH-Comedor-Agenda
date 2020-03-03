/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.A_Tarea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL-UAB
 */
public class A_PathProcedimientoTareaModel {
    
    public List<A_Tarea> getAllPathProcedimiento(int idProcedimiento) {
        List<A_Tarea> ps = new ArrayList<A_Tarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pp.idPathProcedimiento, pp.idProcedimiento, pp.nombre, pp.pathImage\n" +
                        "FROM APathProcedimiento pp, AProcedimientoTarea pt\n" +
                        "WHERE pp.idProcedimiento = pt.idProcedimiento\n" +
                        "AND pt.idProcedimiento = " + idProcedimiento;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_Tarea p = new A_Tarea();
                p.setIdPathProcedimiento(res.getInt("idPathProcedimiento"));
                p.setIdProcedimiento(res.getInt("idProcedimiento"));
                p.setNombrePath(res.getString("nombre"));
                p.setPathImage(res.getString("pathImage"));
                ps.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_PathTareaModel.getAllPath() " + e.getMessage());
        }
        return ps;
    }
    
    public String savePathProcedimiento(A_Tarea path ){
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO APathProcedimiento\n"
                    + "  (idProcedimiento, nombre, pathImage)"
                    + "  VALUES\n"
                    + "  ("+path.getIdProcedimiento()+", '"+path.getNombrePath()+"','"+path.getPathImage()+"')";

            db.insertar(sql);
            db.cierraConexion();
                       
        } catch (SQLException e) {
            respuesta = "Modelo.A_PathProcedimientoTareaModel.savePathProcedimiento() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeletePathProcedimiento(int idPathProcedimiento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM APathProcedimiento WHERE idPathProcedimiento = " + idPathProcedimiento;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_PathProcedimientoTareaModel.DeletePathProcedimiento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
