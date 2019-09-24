/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.A_PathTarea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL-UAB
 */
public class A_PathTareaModel {
    
    public List<A_PathTarea> getAllPath(int idTarea) {
        List<A_PathTarea> ps = new ArrayList<A_PathTarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idPath, idTarea, nombre, path \n" +
                        "FROM APath \n" +
                        "WHERE idTarea = " + idTarea;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_PathTarea p = new A_PathTarea();
                p.setIdPath(res.getInt("idPath"));
                p.setIdTarea(res.getInt("idTarea"));
                p.setNombrePath(res.getString("nombre"));
                p.setPath(res.getString("path"));
                String[] partPath = p.getPath().split("\\.", 0);
                p.setTypeFilePath(partPath[1]);
                ps.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_PathTareaModel.getAllPath() " + e.getMessage());
        }
        return ps;
    }
    
    public String DeletePath(int idPath) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM APath WHERE idPath = " + idPath;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.DeleteProcedimiento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
