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
    
    public List<A_Tarea> getAllProcedimientoTarea(int idTarea) {
        List<A_Tarea> procedimientos = new ArrayList<A_Tarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idProcedimiento, idTarea, nombre, descripcion, estado, fechaRegistro, fechaActualizacion\n" +
                        "FROM AProcedimientoTarea\n" +
                        "WHERE estado <> 6\n" +
                        "AND idTarea = " + idTarea;
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
            System.out.println("Modelo.A_ProcedimientoTareaModel.getAllProcedimientoTarea() " + e.getMessage());
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
            respuesta = "Modelo.A_TareaModel.ActualizarTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteProcedimiento(int idProcedimiento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM AProcedimientoTarea WHERE idProcedimiento = " + idProcedimiento;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.DeleteProcedimiento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
//    aux procedimiento
    
    public List<A_ProcedimientoTarea> getAllAuxProcedimientoTarea(int idUsuario) {
        List<A_ProcedimientoTarea> procedimientos = new ArrayList<A_ProcedimientoTarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT idProcedimiento, paso, responsable, actividad, documentoTrabajo, fechaInicio, fechaFinal, horaInicio, horaFinal, estado\n" +
                        "FROM AuxProcedimientoTarea WHERE idUsuario = " + idUsuario;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
                procedimiento.setEstadoProcedimiento(res.getInt("estado"));
                procedimientos.add(procedimiento);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_ProcedimientoTareaModel.getAllProcedimientoTarea() " + e.getMessage());
        }
        return procedimientos;
    }
    
    public String SaveAuxProcedimientoTarea(A_ProcedimientoTarea p) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "";
            db.insertar(sql);
            db.cierraConexion();
                       
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.SaveAuxProcedimientoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String UpdateAuxProcedimientoTarea(A_ProcedimientoTarea p) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "";
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.UpdateAuxProcedimientoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String getAuxMaxProcedimientoTarea(){
        String id = null;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT MAX(idProcedimiento) as id FROM AuxProcedimientoTarea";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getString("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            id = "Modelo.A_TareaModel.getAuxMaxProcedimientoTarea() " + e.getMessage();
        }
        return  id;
    }
    
    public String DeleteAuxProcedimientoTarea(int idProcedimiento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELTE FROM AuxProcedimientoTarea \n"
                    + " WHERE idProcedimiento = " + idProcedimiento ;

            db.borrar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.DeleteAuxProcedimientoTarea() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    public String DeleteAllAuxProcedimiento(int idUsuario) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELTE FROM AuxProcedimientoTarea WHERE idUsuario = " + idUsuario;
            db.borrar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.DeleteAllAuxProcedimiento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
//    AUX EMPLEADO PROCEDIMIENTO
    
    public String SaveAuxEmpleadoProcedimiento(int idEmpleado, int idProcedimiento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO AuxEmpleadoProcedimiento\n"
                    + "  (idEmpleado, idProcedimiento)"
                    + "  VALUES\n"
                    + "  ("+idEmpleado+","+idProcedimiento+")";
            db.insertar(sql);
            db.cierraConexion();
                       
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.SaveAuxEmpleadoProcedimiento() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteAuxEmpleadoProcedimiento(int idEmpleadoProcedimiento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELTE FROM AuxEmpleadoProcedimiento \n"
                      + " WHERE idEmpleadoProcedimiento = " + idEmpleadoProcedimiento;

            db.borrar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.DeleteAuxEmpleadoProcedimiento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    public String DeleteAllAuxEmpleadoProcedimiento(int idProcedimiento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELTE FROM AuxEmpleadoProcedimiento WHERE idProcedimiento = " + idProcedimiento;
            db.borrar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_ProcedimientoTareaModel.DeleteAllAuxEmpleadoProcedimiento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    
}
