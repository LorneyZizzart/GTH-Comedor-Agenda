/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
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
public class A_TareaModel {
    
    private List<A_Tarea> getOtherTarea(int idUser, int idEmpleado) {
        List<A_Tarea> tareas = new ArrayList<A_Tarea>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ta.idTarea, ta.idTipoTarea, ta.idEstadoTarea, ta.idRepeticionTarea, ta.idUsuarioCrea, ta.titulo, ta.descripcion, ta.color, ta.fechaInicio, ta.fechaFinal, ta.estado, ta.fechaRegistro, ta.fechaActualizacion, ta.horaInicio, ta.horaFinal,\n" +
                        "ti.nombre as nombreTipo,\n" +
                        "et.nombre as nombreEstado,\n" +
                        "rt.nombre as nombreRepeticion, rt.sumarDias, rt.sumarMes, rt.sumarYear,						\n" +
                        "em.Empleado_id, em.Apellido_paterno, em.Apellido_materno, em.Nombre as nombreEmpleado, em.Telefono, em.Foto,\n" +
                        "aet.idEmpleadoTarea\n" +
                        "FROM ATarea ta, ATipoTarea ti, AEstadoTarea et, Usuario us, Empleado em, ARepeticionTarea rt, AEmpleadoTarea  aet\n" +
                        "WHERE ta.idTipoTarea = ti.idTipoTarea\n" +
                        "AND ta.idEstadoTarea = et.idEstadoTarea\n" +
                        "AND ta.idRepeticionTarea = rt.idRepeticionTarea\n" +
                        "AND ta.idTarea = aet.idTarea\n" +
                        "AND ta.idUsuarioCrea = us.User_id\n" +
                        "AND us.Empleado_id = em.Empleado_id\n" +
                        "AND ta.estado <> 6 \n" +
                        "AND aet.idUsuarioCrea <> " + idUser + "\n"+
                        "AND aet.idEmpleado = " + idEmpleado;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_Tarea tarea = new A_Tarea();
                tarea.setIdTarea(res.getInt("idTarea"));
                tarea.setIdTipoTarea(res.getInt("idTipoTarea"));
                tarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                tarea.setIdUserCrea(res.getInt("idUsuarioCrea"));
                tarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                tarea.setTitulo(res.getString("titulo"));
                tarea.setDescripcion(res.getString("descripcion"));
                tarea.setColor(res.getString("color"));
                tarea.setFechaInicio(res.getString("fechaInicio"));
                tarea.setFechaFinal(res.getString("fechaFinal"));
                tarea.setEstadoTarea(res.getInt("estado"));
                tarea.setFechaRegistroTarea(res.getDate("fechaRegistro"));
                tarea.setFechaActualizacion(res.getDate("fechaActualizacion"));
                tarea.setNombreTarea(res.getString("nombreTipo"));
                tarea.setNombreEstadoTarea(res.getString("nombreEstado"));
                tarea.setIdEmpleado(res.getInt("Empleado_id"));
                tarea.setNombreEmpleado(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("nombreEmpleado"));
                tarea.setTelefono(res.getInt("Telefono"));
                tarea.setFoto(res.getString("Foto"));
                tarea.setHoraInicio(res.getString("horaInicio"));
                tarea.setHoraFinal(res.getString("horaFinal"));
                tarea.setNombreRepeticion(res.getString("nombreRepeticion"));
                tarea.setSumarDias(res.getInt("sumarDias"));
                tarea.setSumarMes(res.getInt("sumarMes"));
                tarea.setSumarYear(res.getInt("sumarYear"));
                tarea.setIdEmpleadoTarea(res.getInt("idEmpleadoTarea"));
                tareas.add(tarea);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.A_TareaModel.getOtherTarea() " + e.getMessage());
        }
        return tareas;
    }
    
    public List<A_Tarea> getAllTarea(int idUser) {
        List<A_Tarea> tareas = new ArrayList<A_Tarea>();
        List<A_Tarea> otherTareas = new ArrayList<A_Tarea>();
        int idEmpleado = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ta.idTarea, ta.idTipoTarea, ta.idEstadoTarea, ta.idRepeticionTarea, ta.idUsuarioCrea, ta.titulo, ta.descripcion, ta.color, ta.fechaInicio, ta.fechaFinal, ta.estado, ta.fechaRegistro, ta.fechaActualizacion, ta.horaInicio, ta.horaFinal, \n" +
                        "ti.nombre as nombreTipo,\n" +
                        "et.nombre as nombreEstado,\n" +
                        "rt.nombre as nombreRepeticion, rt.sumarDias, rt.sumarMes, rt.sumarYear,\n" +
                        "em.Empleado_id, em.Apellido_paterno, em.Apellido_materno, em.Nombre as nombreEmpleado, em.Telefono, em.Foto\n" +
                        "FROM ATarea ta, ATipoTarea ti, AEstadoTarea et, Usuario us, Empleado em, ARepeticionTarea rt \n" +
                        "WHERE ta.idTipoTarea = ti.idTipoTarea\n" +
                        "AND ta.idEstadoTarea = et.idEstadoTarea\n" +
                        "AND ta.idRepeticionTarea = rt.idRepeticionTarea\n" +
                        "AND ta.idUsuarioCrea = us.User_id\n" +
                        "AND us.Empleado_id = em.Empleado_id\n" +
                        "AND ta.estado <> 6 " +
                        "AND ta.idUsuarioCrea = " + idUser;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_Tarea tarea = new A_Tarea();
                tarea.setIdTarea(res.getInt("idTarea"));
                tarea.setIdTipoTarea(res.getInt("idTipoTarea"));
                tarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                tarea.setIdUserCrea(res.getInt("idUsuarioCrea"));
                tarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                tarea.setTitulo(res.getString("titulo"));
                tarea.setDescripcion(res.getString("descripcion"));
                tarea.setColor(res.getString("color"));
                tarea.setFechaInicio(res.getString("fechaInicio"));
                tarea.setFechaFinal(res.getString("fechaFinal"));
                tarea.setEstadoTarea(res.getInt("estado"));
                tarea.setFechaRegistroTarea(res.getDate("fechaRegistro"));
                tarea.setFechaActualizacion(res.getDate("fechaActualizacion"));
                tarea.setNombreTarea(res.getString("nombreTipo"));
                tarea.setNombreEstadoTarea(res.getString("nombreEstado"));
                idEmpleado = res.getInt("Empleado_id");
                tarea.setIdEmpleado(res.getInt("Empleado_id"));
                tarea.setNombreEmpleado(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("nombreEmpleado"));
                tarea.setTelefono(res.getInt("Telefono"));
                tarea.setFoto(res.getString("Foto"));
                tarea.setHoraInicio(res.getString("horaInicio"));
                tarea.setHoraFinal(res.getString("horaFinal"));
                tarea.setNombreRepeticion(res.getString("nombreRepeticion"));
                tarea.setSumarDias(res.getInt("sumarDias"));
                tarea.setSumarMes(res.getInt("sumarMes"));
                tarea.setSumarYear(res.getInt("sumarYear"));
                tareas.add(tarea);
            }
            db.cierraConexion();
            otherTareas = getOtherTarea(idUser, idEmpleado);
            if(otherTareas.size() > 0){
                for(A_Tarea t : otherTareas){
                tareas.add(t);
                }
            }            
        } catch (SQLException e) {
            System.out.println("Modelo.A_TareaModel.getAllTarea() " + e.getMessage());
        }
        return tareas;
    }
    
    public A_Tarea getTareaById(int idTarea) {
        A_Tarea tarea = new A_Tarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ta.idTarea, ta.idTipoTarea, ta.idEstadoTarea, ta.idRepeticionTarea, ta.idUsuarioCrea, ta.titulo, ta.descripcion, ta.color, ta.fechaInicio, ta.fechaFinal, ta.estado, ta.fechaRegistro, ta.fechaActualizacion, ta.horaInicio, ta.horaFinal, \n" +
                        "ti.nombre as nombreTipo,\n" +
                        "et.nombre as nombreEstado,\n" +
                        "rt.nombre as nombreRepeticion, rt.sumarDias, rt.sumarMes, rt.sumarYear,\n" +
                        "em.Empleado_id, em.Apellido_paterno, em.Apellido_materno, em.Nombre as nombreEmpleado, em.Telefono, em.Foto\n" +
                        "FROM ATarea ta, ATipoTarea ti, AEstadoTarea et, Usuario us, Empleado em, ARepeticionTarea rt \n" +
                        "WHERE ta.idTipoTarea = ti.idTipoTarea\n" +
                        "AND ta.idEstadoTarea = et.idEstadoTarea\n" +
                        "AND ta.idRepeticionTarea = rt.idRepeticionTarea\n" +
                        "AND ta.idUsuarioCrea = us.User_id\n" +
                        "AND us.Empleado_id = em.Empleado_id\n" +
                        "AND ta.estado <> 6 " +
                        "AND ta.idTarea = " + idTarea;

            ResultSet res = db.consulta(sql);
            if (res.next()) {
                tarea.setIdTarea(res.getInt("idTarea"));
                tarea.setIdTipoTarea(res.getInt("idTipoTarea"));
                tarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                tarea.setIdUserCrea(res.getInt("idUsuarioCrea"));
                tarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                tarea.setTitulo(res.getString("titulo"));
                tarea.setDescripcion(res.getString("descripcion"));
                tarea.setColor(res.getString("color"));
                tarea.setFechaInicio(res.getString("fechaInicio"));
                tarea.setFechaFinal(res.getString("fechaFinal"));
                tarea.setEstadoTarea(res.getInt("estado"));
                tarea.setFechaRegistroTarea(res.getDate("fechaRegistro"));
                tarea.setFechaActualizacion(res.getDate("fechaActualizacion"));
                tarea.setNombreTarea(res.getString("nombreTipo"));
                tarea.setNombreEstadoTarea(res.getString("nombreEstado"));
                tarea.setIdEmpleado(res.getInt("Empleado_id"));
                tarea.setNombreEmpleado(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("nombreEmpleado"));
                tarea.setTelefono(res.getInt("Telefono"));
                tarea.setFoto(res.getString("Foto"));
                tarea.setHoraInicio(res.getString("horaInicio"));
                tarea.setHoraFinal(res.getString("horaFinal"));
                tarea.setNombreRepeticion(res.getString("nombreRepeticion"));
                tarea.setSumarDias(res.getInt("sumarDias"));
                tarea.setSumarMes(res.getInt("sumarMes"));
                tarea.setSumarYear(res.getInt("sumarYear"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.A_TareaModel.getTareaById() " + e.getMessage());
        }
        return tarea;
    }
    
    public String SaveOrUpdate(A_Tarea tarea) {
        String respuesta = null;
        try {
            if (tarea.getIdTarea() == 0) {
                //insertar
                respuesta = SaveTarea(tarea);
            } else {
                // Actualizar
                respuesta = ActualizarTarea(tarea);
            }

        } catch (Exception e) {
        }
        return respuesta;
    }
    
    private String SaveTarea(A_Tarea tarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO ATarea\n"
                    + "  (titulo, descripcion, color, fechaInicio, fechaFinal, idTipoTarea, estado, fechaRegistro, fechaActualizacion, idEstadoTarea, idUsuarioCrea, horaInicio, horaFinal, idRepeticionTarea)"
                    + "  VALUES\n"
                    + "  ('" + tarea.getTitulo()+"','" + tarea.getDescripcion()+ "','"+tarea.getColor()+"','"+tarea.getFechaInicio()+"','"+tarea.getFechaFinal()+"',"+tarea.getIdTipoTarea()+",1,CONVERT(date, SYSDATETIME()),CONVERT(date, SYSDATETIME()),"+tarea.getIdEstadoTarea()+","+tarea.getIdUserCrea()+",'"+tarea.getHoraInicio()+"','"+tarea.getHoraFinal()+"',"+tarea.getIdRepeticionTarea()+")";
            db.insertar(sql);
            db.cierraConexion();
            if(tarea.getEmpleados().size() > 0){
                tarea.setIdTarea(Integer.parseInt(MaxIdTarea()));
                for(Empleado e : tarea.getEmpleados()){
                respuesta = SaveEmpleadoTarea(e.getEmpleado_id(), tarea.getIdTarea(), tarea.getIdUserCrea());
                }
            }            
        } catch (SQLException e) {
            respuesta = "Modelo.A_TareaModel.SaveTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    private String  MaxIdTarea(){
        String id = "0";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT MAX(idTarea) as id FROM ATarea";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getString("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            id = "Modelo.A_TareaModel.SaveEmpleadoTarea() " + e.getMessage();
        }
        return id;
    }
    
    private String SaveEmpleadoTarea(int idEmpleado, int idTarea, int idUser) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO AEmpleadoTarea\n"
                    + "  (idEmpleado, idTarea, estado, idUsuarioCrea)"
                    + "  VALUES\n"
                    + "  (" + idEmpleado+"," + idTarea +",1,"+idUser+")";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_TareaModel.SaveEmpleadoTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    
    
    private String ActualizarTarea(A_Tarea tarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "UPDATE ATarea \n"
                    + "   SET titulo = '" + tarea.getTitulo()+ "' \n"
                    + "      ,descripcion = '" + tarea.getDescripcion()+ "' \n"
                    + "      ,color = '" + tarea.getColor()+ "' \n"
                    + "      ,fechaInicio = '" + tarea.getFechaInicio()+ "' \n"
                    + "      ,fechaFinal = '" + tarea.getFechaFinal()+ "' \n"
                    + "      ,idTipoTarea = " + tarea.getIdTipoTarea()+ " \n"
                    + "      ,idEstadoTarea = " + tarea.getIdEstadoTarea()+ " \n"
                    + "      ,horaInicio = '" + tarea.getHoraInicio()+ "' \n"
                    + "      ,horaFinal = '" + tarea.getHoraFinal()+ "' \n"
                    + "      ,idRepeticionTarea = " + tarea.getIdRepeticionTarea()+ " \n"
                    + "      ,fechaActualizacion = CONVERT(date, SYSDATETIME()) "
                    + " WHERE idTarea = " + tarea.getIdTarea();
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_TareaModel.ActualizarTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteTarea(int idTarea) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE ATarea \n"
                    + "   SET estado = 6 \n"
                    + " WHERE idTarea = " + idTarea ;

            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.A_TareaModel.DeleteTarea() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
