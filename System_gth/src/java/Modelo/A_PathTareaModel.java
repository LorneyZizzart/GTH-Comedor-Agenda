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
    
    public List<A_PathTarea> getAllPath(String titulo, int idUser) {
        List<A_PathTarea> ps = new ArrayList<A_PathTarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pa.idPath, pa.idTarea, pa.nombre, pa.pathImage\n" +
                        "FROM APath pa, ATarea ta\n" +
                        "WHERE pa.idTarea = ta.idTarea\n" +
                        "AND ta.titulo = '"+ titulo + "'\n" +
                        "AND ta.idUsuarioCrea = " + idUser;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_PathTarea p = new A_PathTarea();
                p.setIdPath(res.getInt("idPath"));
                p.setIdTarea(res.getInt("idTarea"));
                p.setNombrePath(res.getString("nombre"));
                p.setPathImage(res.getString("PathImage"));
                String[] partPath = p.getPathImage().split("\\.", 0);
                p.setTypeFilePath(partPath[1]);
                ps.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_PathTareaModel.getAllPath() " + e.getMessage());
        }
        return ps;
    }
    
    public String savePathTarea(A_PathTarea path ){
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO APath\n"
                    + "  (idTarea, nombre, pathImage)"
                    + "  VALUES\n"
                    + "  ("+path.getIdTarea()+", '"+path.getNombrePath()+"','"+path.getPathImage()+"')";

            db.insertar(sql);
            db.cierraConexion();
                       
        } catch (SQLException e) {
            respuesta = "Modelo.AFileUploadHandler.savePathTarea() " + e.getMessage();
        }
        return respuesta;
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
