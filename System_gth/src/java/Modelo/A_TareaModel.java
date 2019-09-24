/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.A_ProcedimientoTarea;
import Entidad.A_Tarea;
import Modelo.A_ProcedimientoTareaModel;
import Entidad.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_TareaModel {
    
    public List<A_Tarea> getAllTarea(int idUser, String sentencia) throws ParseException {
        List<A_Tarea> tareas = new ArrayList<A_Tarea>();        
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ta.idTarea, ta.idEstadoTarea, ta.idRepeticionTarea, ta.idUsuarioCrea, ta.titulo, ta.descripcion, ta.fechaInicio, ta.fechaRegistro, ta.fechaActualizacion, ta.horaInicio, ta.estado, \n" +
                        "et.nombre as nombreEstado,\n" +
                        "rt.nombre as nombreRepeticion, rt.sumarDias, rt.sumarMes, rt.sumarYear,\n" +
                        "em.Empleado_id, em.Apellido_paterno, em.Apellido_materno, em.Nombre as nombreEmpleado, em.Telefono, em.Foto\n" +
                        "FROM ATarea ta, AEstadoTarea et, Usuario us, Empleado em, ARepeticionTarea rt \n" +
                        "WHERE ta.idEstadoTarea = et.idEstadoTarea\n" +
                        "AND ta.idRepeticionTarea = rt.idRepeticionTarea\n" +
                        "AND ta.idUsuarioCrea = us.User_id\n" +
                        "AND us.Empleado_id = em.Empleado_id\n" +
                        "AND ta.estado <> 6  " +
                        "AND ta.idUsuarioCrea = " + idUser + " " +sentencia;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_Tarea tarea = new A_Tarea();
                
                tarea.setIdTarea(res.getInt("idTarea"));
                tarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                tarea.setIdUserCrea(res.getInt("idUsuarioCrea"));
                tarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                tarea.setTitulo(res.getString("titulo"));
                tarea.setDescripcion(res.getString("descripcion"));
                tarea.setFechaInicio(this.ConvertDate(res.getString("fechaInicio")));
                tarea.setEstadoTarea(res.getInt("estado"));
                tarea.setFechaRegistroTarea(res.getDate("fechaRegistro"));
                tarea.setFechaActualizacion(res.getDate("fechaActualizacion"));
                tarea.setNombreEstadoTarea(res.getString("nombreEstado"));
                tarea.setIdEmpleado(res.getInt("Empleado_id"));
                tarea.setNombreEmpleado(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("nombreEmpleado"));
                tarea.setTelefono(res.getInt("Telefono"));
                tarea.setFoto(res.getString("Foto"));
                tarea.setHoraInicio(res.getString("horaInicio"));
                tarea.setNombreRepeticion(res.getString("nombreRepeticion"));
                tarea.setSumarDias(res.getInt("sumarDias"));
                tarea.setSumarMes(res.getInt("sumarMes"));
                tarea.setSumarYear(res.getInt("sumarYear"));                
                
                tareas.add(tarea);
            }
            db.cierraConexion();
                      
        } catch (SQLException e) {
            System.out.println("Modelo.A_TareaModel.getAllTarea() " + e.getMessage());
        }
        return tareas;
    }
//    ver tareas agrupadas
    public List<A_Tarea> getGroupTareaByUser (int idUser) {
        List<A_Tarea> tareas = new ArrayList<A_Tarea>();        
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ta.titulo, ta.idRepeticionTarea, ta.fechaRegistro , rt.nombre\n" +
                         "FROM ATarea ta, ARepeticionTarea rt\n" +
                         "WHERE ta.idRepeticionTarea = rt.idRepeticionTarea\n" +
                         "AND idUsuarioCrea = " + idUser + "\n" +
                         "GROup by ta.titulo, ta.idRepeticionTarea, ta.fechaRegistro, rt.nombre";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_Tarea tarea = new A_Tarea();
                tarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                tarea.setTitulo(res.getString("titulo"));
                tarea.setFechaRegistroTarea(res.getDate("fechaRegistro"));
                tarea.setNombreRepeticion(res.getString("nombre"));   
                tareas.add(tarea);
            }
            db.cierraConexion();
                      
        } catch (SQLException e) {
            System.out.println("Modelo.A_TareaModel.getGroupTareaByUser() " + e.getMessage());
        }
        return tareas;
    }
    
    public A_Tarea getTareaById(int idTarea) throws ParseException {
        A_Tarea tarea = new A_Tarea();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ta.idTarea, ta.idEstadoTarea, ta.idRepeticionTarea, ta.idUsuarioCrea, ta.titulo, ta.descripcion, ta.fechaInicio, ta.fechaRegistro, ta.fechaActualizacion, ta.horaInicio, ta.estado, ta.domingo, ta.lunes, ta.martes, ta.miercoles, ta.jueves, ta.viernes, ta.sabado, \n" +
                        "et.nombre as nombreEstado,\n" +
                        "rt.nombre as nombreRepeticion, rt.sumarDias, rt.sumarMes, rt.sumarYear,\n" +
                        "em.Empleado_id, em.Apellido_paterno, em.Apellido_materno, em.Nombre as nombreEmpleado, em.Telefono, em.Foto\n" +
                        "FROM ATarea ta, AEstadoTarea et, Usuario us, Empleado em, ARepeticionTarea rt \n" +
                        "WHERE ta.idEstadoTarea = et.idEstadoTarea\n" +
                        "AND ta.idRepeticionTarea = rt.idRepeticionTarea\n" +
                        "AND ta.idUsuarioCrea = us.User_id\n" +
                        "AND us.Empleado_id = em.Empleado_id\n" +
                        "AND ta.estado <> 6  " +
                        "AND ta.idTarea = " + idTarea;

            ResultSet res = db.consulta(sql);
            if (res.next()) {                
                tarea.setIdTarea(res.getInt("idTarea"));
                tarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                tarea.setIdUserCrea(res.getInt("idUsuarioCrea"));
                tarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                tarea.setTitulo(res.getString("titulo"));
                tarea.setDescripcion(res.getString("descripcion"));
                tarea.setFechaInicio(this.ConvertDate(res.getString("fechaInicio")));
                tarea.setEstadoTarea(res.getInt("estado"));
                tarea.setFechaRegistroTarea(res.getDate("fechaRegistro"));
                tarea.setFechaActualizacion(res.getDate("fechaActualizacion"));
                tarea.setNombreEstadoTarea(res.getString("nombreEstado"));
                tarea.setIdEmpleado(res.getInt("Empleado_id"));
                tarea.setNombreEmpleado(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("nombreEmpleado"));
                tarea.setTelefono(res.getInt("Telefono"));
                tarea.setFoto(res.getString("Foto"));
                tarea.setHoraInicio(res.getString("horaInicio"));
                tarea.setNombreRepeticion(res.getString("nombreRepeticion"));
                tarea.setSumarDias(res.getInt("sumarDias"));
                tarea.setSumarMes(res.getInt("sumarMes"));
                tarea.setSumarYear(res.getInt("sumarYear"));  
                tarea.setDomingo(res.getInt("domingo"));
                tarea.setLunes(res.getInt("lunes"));
                tarea.setMartes(res.getInt("martes"));
                tarea.setMiercoles(res.getInt("miercoles"));
                tarea.setJueves(res.getInt("jueves"));
                tarea.setViernes(res.getInt("viernes"));
                tarea.setSabado(res.getInt("sabado"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.A_TareaModel.getTareaById() " + e.getMessage());
        }
        return tarea;
    }
    
    public String getMaxIdTarea(){
        String id = null;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT MAX(idTarea) AS idTarea FROM ATarea";

            ResultSet res = db.consulta(sql);
            if (res.next()) {                
                id = res.getString("idTarea");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.A_TareaModel.getMaxIdTarea() " + e.getMessage());
        }
        return id;
    }
    
    public List<A_Tarea> getAllTareaForProcess(String nombreProceso) {
        List<A_Tarea> tareas = new ArrayList<A_Tarea>();        
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ta.idTarea, ta.idEstadoTarea, ta.idRepeticionTarea, ta.idUsuarioCrea, ta.titulo, ta.descripcion, ta.fechaInicio, ta.fechaRegistro, ta.fechaActualizacion, ta.horaInicio, ta.estado, \n" +
                        "et.nombre as nombreEstado,\n" +
                        "rt.nombre as nombreRepeticion, rt.sumarDias, rt.sumarMes, rt.sumarYear,\n" +
                        "em.Empleado_id, em.Apellido_paterno, em.Apellido_materno, em.Nombre as nombreEmpleado, em.Telefono, em.Foto\n" +
                        "FROM ATarea ta, AEstadoTarea et, Usuario us, Empleado em, ARepeticionTarea rt \n" +
                        "WHERE ta.idEstadoTarea = et.idEstadoTarea\n" +
                        "AND ta.idRepeticionTarea = rt.idRepeticionTarea\n" +
                        "AND ta.idUsuarioCrea = us.User_id\n" +
                        "AND us.Empleado_id = em.Empleado_id\n" +
                        "AND ta.estado <> 6  " +
                        "AND ta.titulo = '" + nombreProceso + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                A_Tarea tarea = new A_Tarea();                
                tarea.setIdTarea(res.getInt("idTarea"));
                tarea.setIdEstadoTarea(res.getInt("idEstadoTarea"));
                tarea.setIdUserCrea(res.getInt("idUsuarioCrea"));
                tarea.setIdRepeticionTarea(res.getInt("idRepeticionTarea"));
                tarea.setTitulo(res.getString("titulo"));
                tarea.setDescripcion(res.getString("descripcion"));
                tarea.setFechaInicio(res.getString("fechaInicio"));
                tarea.setEstadoTarea(res.getInt("estado"));
                tarea.setFechaRegistroTarea(res.getDate("fechaRegistro"));
                tarea.setFechaActualizacion(res.getDate("fechaActualizacion"));
                tarea.setNombreEstadoTarea(res.getString("nombreEstado"));
                tarea.setIdEmpleado(res.getInt("Empleado_id"));
                tarea.setNombreEmpleado(res.getString("Apellido_paterno")+" "+res.getString("Apellido_materno")+" "+res.getString("nombreEmpleado"));
                tarea.setTelefono(res.getInt("Telefono"));
                tarea.setFoto(res.getString("Foto"));
                tarea.setHoraInicio(res.getString("horaInicio"));
                tarea.setNombreRepeticion(res.getString("nombreRepeticion"));
                tarea.setSumarDias(res.getInt("sumarDias"));
                tarea.setSumarMes(res.getInt("sumarMes"));
                tarea.setSumarYear(res.getInt("sumarYear")); 
                tareas.add(tarea);
            }
            db.cierraConexion();
                      
        } catch (SQLException e) {
            System.out.println("Modelo.A_TareaModel.getAllTareaForProcess() " + e.getMessage());
        }
        return tareas;
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
                    + "  (titulo, descripcion, idRepeticionTarea, idEstadoTarea, fechaInicio, horaInicio, domingo, lunes, martes, miercoles, jueves, viernes, sabado, fechaRegistro, fechaActualizacion, idUsuarioCrea, estado)"
                    + "  VALUES\n"
                    + "  ('"+tarea.getTitulo()+"','"+tarea.getDescripcion()+"',"+tarea.getIdRepeticionTarea()+","+tarea.getIdEstadoTarea()+",'"+tarea.getFechaInicio()+"','"+tarea.getHoraInicio()+"',"+tarea.getDomingo()+"," + tarea.getLunes()+"," + tarea.getMartes()+ ","+tarea.getMiercoles()+","+tarea.getJueves()+","+tarea.getViernes()+","+tarea.getSabado()+",CONVERT(date, SYSDATETIME()),CONVERT(date, SYSDATETIME()),"+tarea.getIdUserCrea()+",1)";
            
            db.insertar(sql);
            db.cierraConexion();
                       
        } catch (SQLException e) {
            respuesta = "Modelo.A_TareaModel.SaveTarea() " + e.getMessage();
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
                    + "      ,idRepeticionTarea = " + tarea.getIdRepeticionTarea()+ " \n"
                    + "      ,idEstadoTarea = " + tarea.getIdEstadoTarea()+ " \n"
                    + "      ,fechaInicio = '" + tarea.getFechaInicio()+ "' \n"
                    + "      ,horaInicio = '" + tarea.getHoraInicio()+ "' \n"
                    + "      ,domingo = " + tarea.getDomingo()+ " \n"
                    + "      ,lunes = " + tarea.getLunes()+ " \n"
                    + "      ,martes = " + tarea.getMartes()+ " \n"
                    + "      ,miercoles = " + tarea.getMiercoles()+ " \n"
                    + "      ,jueves = " + tarea.getJueves()+ " \n"
                    + "      ,viernes = " + tarea.getViernes()+ " \n"
                    + "      ,sabado = " + tarea.getSabado()+ " \n"
                    + "      ,fechaActualizacion = CONVERT(date, SYSDATETIME()) "
                    + " WHERE idTarea = " + tarea.getIdTarea();
            System.out.print("sql:"+sql);
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
    
    
    public String ConvertDate(String dateEntry) throws ParseException{
        String fecha = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd");
        Date date = parseador.parse(dateEntry);
        calendar.setTime(date);
        String day = null, month = null, year = null;
        
        if (calendar.get(Calendar.DATE) < 10){
            day = "0"+calendar.get(Calendar.DATE);
        }else day = String.valueOf(calendar.get(Calendar.DATE));
        
        if(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)+1)) < 10){
            month = "0"+Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)+1));
        } else month = String.valueOf(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)+1)));
        
        if(calendar.get(Calendar.YEAR) < 10){
            year = "0"+calendar.get(Calendar.YEAR);
        }else year = String.valueOf(calendar.get(Calendar.YEAR));
        
        fecha = day+"/"+month+"/"+year;
        return fecha;
    }
}
