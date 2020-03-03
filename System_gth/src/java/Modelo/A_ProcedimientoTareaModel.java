/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.A_EstadoTarea;
import Entidad.A_ProcedimientoTarea;
import Entidad.A_Tarea;
import Entidad.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_ProcedimientoTareaModel {
    
    public List<A_Tarea> getAllProcedimientoTarea(String titulo, int idUsuario) {
        List<A_Tarea> procedimientos = new ArrayList<A_Tarea>();
        A_Tarea p = new A_Tarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pt.idProcedimiento, pt.idTarea, pt.nombre, pt.descripcion, pt.estado, pt.fechaRegistro, pt.fechaActualizacion\n" +
"                        FROM AProcedimientoTarea pt, ATarea ta\n" +
"                        WHERE pt.idTarea = ta.idTarea\n" +
"			 AND pt.estado <> 6\n" +
"                        AND ta.titulo = '" + titulo + "'\n" +  
"		         AND ta.idUsuarioCrea = " + idUsuario;
            ResultSet res = db.consulta(sql);
            if (res.next()) {                
                p.setIdProcedimiento(res.getInt("idProcedimiento"));
                p.setIdTarea(res.getInt("idTarea"));
                p.setNombreProcedimiento(res.getString("nombre"));
                p.setDescripcionProcedimiento(res.getString("descripcion"));
                p.setEstadoProcedimiento(res.getInt("estado"));
                p.setFechaRegistroProcedimiento(res.getDate("fechaRegistro"));
                p.setFechaActualizacionProcedimiento(res.getDate("fechaActualizacion"));
            }
            
            procedimientos = this.getAllProcedimientoByIdTarea(p.getIdTarea());       
            
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_ProcedimientoTareaModel.getAllProcedimientoTarea() " + e.getMessage());
        }
        return procedimientos;
    }
    
    public List<A_Tarea> getAllIdProcedimiento(String titulo, int idUsuario, String nombreProceso) {
        List<A_Tarea> procedimientos = new ArrayList<A_Tarea>();
        
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pt.idProcedimiento\n" +
                        "FROM AProcedimientoTarea pt, ATarea ta\n" +
                        "WHERE pt.idTarea = ta.idTarea\n" +
                        "AND ta.titulo = '"+titulo+"'\n" +
                        "AND ta.idUsuarioCrea = "+idUsuario+"\n" +
                        "AND pt.nombre = '" + nombreProceso +"'";
            
            System.out.print("sql: "+sql);
            
            ResultSet res = db.consulta(sql);
            while (res.next()) { 
                A_Tarea p = new A_Tarea();
                p.setIdProcedimiento(res.getInt("idProcedimiento"));
                procedimientos.add(p);
            }  
            
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_ProcedimientoTareaModel.getAllIdProcedimiento() " + e.getMessage());
        }
        return procedimientos;
    }
    
    private List<A_Tarea> getAllProcedimientoByIdTarea(int idTarea) {
        List<A_Tarea> procedimientos = new ArrayList<A_Tarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idProcedimiento, idTarea, nombre, descripcion, estado, fechaRegistro, fechaActualizacion\n" +
                        "FROM AProcedimientoTarea \n" +
                        "WHERE estado <> 6\n" +
                        "AND  idTarea = " + idTarea;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_Tarea p = new A_Tarea();
                p.setIdProcedimiento(res.getInt("idProcedimiento"));
                p.setIdTarea(res.getInt("idTarea"));
                p.setNombreProcedimiento(res.getString("nombre"));
                p.setDescripcionProcedimiento(res.getString("descripcion"));
                p.setEstadoProcedimiento(res.getInt("estado"));
                p.setFechaRegistroProcedimiento(res.getDate("fechaRegistro"));
                p.setFechaActualizacionProcedimiento(res.getDate("fechaActualizacion"));
                procedimientos.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_ProcedimientoTareaModel.getAllProcedimientoByIdTarea() " + e.getMessage());
        }
        return procedimientos;
    }
    
    public A_ProcedimientoTarea getProcedimientoById(int idProceso){
        A_ProcedimientoTarea p = new A_ProcedimientoTarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idProcedimiento, nombre, descripcion, estado, fechaRegistro, fechaActualizacion\n" +
                        "FROM AProcedimientoTarea\n" +
                        "WHERE estado <> 6\n" +
                        "AND idProcedimiento = " + idProceso;
            ResultSet res = db.consulta(sql);
            if (res.next()) { 
                p.setIdProcedimiento(res.getInt("idProcedimiento"));
                p.setNombreProcedimiento(res.getString("nombre"));
                p.setDescripcionProcedimiento(res.getString("descripcion"));
                p.setEstadoProcedimiento(res.getInt("estado"));
                p.setFechaRegistroProcedimiento(res.getDate("fechaRegistro"));
                p.setFechaActualizacionProcedimiento(res.getDate("fechaActualizacion"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_ProcedimientoTareaModel.getProcesoTareaById() " + e.getMessage());
        }
           
        return p;
    }
    
    public A_ProcedimientoTarea getProcedimientoTareaByIdTarea_Nombre(int idTarea, String nombre){
        A_ProcedimientoTarea p = new A_ProcedimientoTarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT pro.idProcedimiento, pro.nombre\n" +
                        "FROM ATarea ta, AProcedimientoTarea pro\n" +
                        "WHERE ta.idTarea = pro.idTarea\n" +
                        "AND ta.idTarea = " + idTarea + "\n" + 
                        "AND pro.nombre = '" + nombre+ "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) { 
                p.setIdProcedimiento(res.getInt("idProcedimiento"));
                p.setNombreProcedimiento(res.getString("nombre"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_ProcedimientoTareaModel.getProcesoTareaById() " + e.getMessage());
        }           
        return p;
    }
    
    public A_Tarea getMaxIdProcedimiento(){
        A_Tarea t = new A_Tarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idProcedimiento, idTarea, nombre\n" +
                        "FROM AProcedimientoTarea\n" +
                        "WHERE idProcedimiento = (SELECT MAX(idProcedimiento)  FROM AProcedimientoTarea)\n" +
                        "GROUP BY idProcedimiento, idTarea, nombre";

            ResultSet res = db.consulta(sql);
            if (res.next()) {       
                t.setIdProcedimiento(res.getInt("idProcedimiento"));
                t.setIdTarea(res.getInt("idTarea"));
                t.setNombreProcedimiento(res.getString("nombre"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.A_ProcedimientoTareaModel.getMaxIdTarea() " + e.getMessage());
        }
        return t;
    }
    
    public A_Tarea getMaxIdProceso(){
        A_Tarea t = new A_Tarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT MAX(idProcedimiento) as id  FROM AProcedimientoTarea WHERE estado <> 6";

            ResultSet res = db.consulta(sql);
            if (res.next()) {   
                t.setIdProcedimiento(res.getInt("id"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.A_ProcedimientoTareaModel.getMaxIdProceso() " + e.getMessage());
        }
        return t;
    }
    
    public String SaveProcedimientoTarea(A_Tarea a) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO AProcedimientoTarea\n"
                    + "  (idTarea, nombre, descripcion, estado, fechaRegistro, fechaActualizacion)"
                    + "  VALUES\n"
                    + "  ("+a.getIdTarea()+",'"+a.getNombreProcedimiento()+"','"+a.getDescripcionProcedimiento()+"',1,CONVERT(date, SYSDATETIME()),CONVERT(date, SYSDATETIME()))";
            db.insertar(sql);
            db.cierraConexion();
                       
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.SaveProcedimientoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String UpdateProcedimientoTarea(A_ProcedimientoTarea p) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "UPDATE AProcedimientoTarea \n"
                    + "   SET nombre = '" + p.getNombreProcedimiento()+ "' \n"
                    + "      ,descripcion = '" + p.getDescripcionProcedimiento()+ "' \n"
                    + "      ,fechaActualizacion = CONVERT(date, SYSDATETIME()) "
                    + " WHERE idProcedimiento = " + p.getIdProcedimiento();
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.ActualizarTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteProcedimiento(int idProcedimiento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE AProcedimientoTarea \n"
                    + "   SET estado = 6 WHERE idProcedimiento = " + idProcedimiento;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.DeleteProcedimiento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
}
