/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.C_Empleado_Reserva;
import Entidad.C_TipoComensal;
import Entidad.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL-UAB
 */
public class C_ComensalExterno {
    
    public List<C_TipoComensal> getAllComensalExterno(String auxReq){
        List<C_TipoComensal> listaReservaEmpleado = new ArrayList<C_TipoComensal>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            
            String sql = "SELECT ce.idReservaExterno, ce.IdTipoComensal, ce.IdTipoComida, cd.nombreCompleto, cd.celular, ce.Fecha, ce.Estado, ce.Cantidad, ce.descuento, ce.fechaRegistro, ce.fechaActualizacion, 0 as funcionario,\n" +
                        "tco.Nombre as NombreComida, tco.Costo as CostoComida,\n" +
                        "tc.Nombre as NombreComensal, tc.descuentoDesayuno, tc.descuentoAlmuerzo, tc.descuentoCena\n" +
                        "FROM CReservaExterno ce, CComensalExterno cd, CTipoComensal tc, CTipoComida tco\n" +
                        "WHERE ce.IdTipoComensal = tc.Id\n" +
                        "AND ce.IdTipoComida = tco.IdTipoComida\n" +
                        "AND ce.IdComensalExterno = cd.idComensalExterno\n" +
                        " " + auxReq + " " +
                        "AND ce.Estado <> 6 ORDER BY ce.Fecha ASC";
            
            System.out.println(sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                C_TipoComensal r = new C_TipoComensal();
                r.setIdEmpleadoReserva(res.getInt("idReservaExterno"));
                r.setIdTipoComida(res.getInt("IdTipoComida"));
                r.setNombreComida(res.getString("NombreComida"));
                r.setCosto(res.getDouble("CostoComida"));
                r.setIdTipoComensal(res.getInt("IdTipoComensal"));
                r.setFecha(res.getString("Fecha"));
                r.setCantidad(res.getInt("Cantidad"));
                r.setEstado(res.getInt("Estado"));
                r.setFechaRegistro(res.getDate("fechaRegistro"));
                r.setFechaActualizacion(res.getDate("fechaActualizacion"));
                r.setNombreComensal(res.getString("NombreComensal"));
                r.setNombreEmpleado(res.getString("NombreCompleto"));
                r.setDescuentoAdicional(res.getDouble("descuento"));
                r.setDescuentoDesayuno(res.getDouble("descuentoDesayuno"));
                r.setDescuentoAlmuerzo(res.getDouble("descuentoAlmuerzo"));
                r.setDescuentoCena(res.getDouble("descuentoCena"));
                r.setFuncionario(res.getInt("funcionario"));
                listaReservaEmpleado.add(r);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.C_ComensalExterno.getAllComensalExterno()" + e.getMessage());
        }
        return  listaReservaEmpleado;
    }
    
    public List<Usuario> getListComensalExterno(){
        List<Usuario> listaReservaEmpleado = new ArrayList<Usuario>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            
            String sql = " SELECT idComensalExterno, nombreCompleto, celular, 0 as funcionario FROM CComensalExterno ORDER BY NombreCompleto ASC";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Usuario r = new Usuario();
                r.setEmpleado_id(res.getInt("idComensalExterno"));
                r.setNombre(res.getString("nombreCompleto"));
                r.setFuncionario(res.getInt("funcionario"));
                r.setEstado(1);
                listaReservaEmpleado.add(r);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.C_ComensalExterno.getAllComensalExterno()" + e.getMessage());
        }
        return  listaReservaEmpleado;
    }
    
    public List<C_Empleado_Reserva> getReservaExternaByIdDate(int idComensalExterno, String fecha, int idTipoComida){
        List<C_Empleado_Reserva> listaReservaEmpleado = new ArrayList<C_Empleado_Reserva>();

        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT re.idReservaExterno, re.IdTipoComida, re.IdTipoComensal,  re.Fecha, re.Cantidad, re.Estado, re.Observacion, re.Cancelar, re.fechaCancelacion, re.fechaRegistro, re.fechaActualizacion, re.descuento, \n" +
                        "ce.IdComensalExterno, ce.idComensalExterno, ce.NombreCompleto, ce.Celular, \n" +
                        "tc.Nombre as NombreComida, tc.Costo as CostoComida, tc.Hora as HoraComida, tc.color as ColorComida, tc.Detalles as DetalleComida, tc.horasAnticipacion as HorasAnticipacionComida,\n" +
                        "tco.Nombre as NombreComensal, tco.descuento as DescuentoComensal\n" +
                        "FROM CReservaExterno re, CComensalExterno ce, CTipoComensal tco, CTipoComida tc\n" +
                        "WHERE re.IdComensalExterno = ce.IdComensalExterno\n" +
                        "AND re.IdTipoComensal = tco.Id\n" +
                        "AND re.IdTipoComida = tc.IdTipoComida\n" +
                        "AND re.Estado <> 6 " 
                    + "AND re.IdComensalExterno = "+idComensalExterno
                    + " AND re.Fecha = '" + fecha + "'"
                    + " AND re.IdTipoComida = " + idTipoComida;
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                C_Empleado_Reserva r = new C_Empleado_Reserva();
                r.setNombreEmpleado(res.getString("NombreCompleto"));
                r.setIdEmpleadoReserva(res.getInt("idReservaExterno"));
                r.setIdEmpleado(res.getInt("IdComensalExterno"));
                r.setIdTipoComida(res.getInt("IdTipoComida"));
                r.setNombreComida(res.getString("NombreComida"));
                r.setHora(res.getString("HoraComida"));
                r.setColor(res.getString("ColorComida"));
                r.setIdTipoComensal(res.getInt("IdTipoComensal"));
                r.setFecha(res.getString("Fecha"));
                r.setCantidad(res.getInt("Cantidad"));
                r.setEstado(res.getInt("Estado"));
                r.setObservacion(res.getString("Observacion"));
                r.setCancelar(res.getInt("Cancelar"));
                r.setFechaCancelacion(res.getString("FechaCancelacion"));
                r.setFechaRegistro(res.getDate("fechaRegistro"));
                r.setFechaActualizacion(res.getDate("fechaActualizacion"));
                listaReservaEmpleado.add(r);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.C_ComensalExterno.getReservaExternaByIdDate()" + e.getMessage());
        }
        return  listaReservaEmpleado;
    }
    
    public List<C_TipoComensal> getReservasExternasForParams(String parameter){
        
        List<C_TipoComensal> listaReservaEmpleado = new ArrayList<C_TipoComensal>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT ce.idReservaExterno, ce.IdTipoComensal, ce.IdTipoComida, cd.idComensalExterno, cd.nombreCompleto, cd.celular, ce.Fecha, ce.Estado, ce.Cantidad, ce.observacion, ce.descuento, ce.fechaRegistro, ce.fechaActualizacion, 0 as funcionario,\n" +
                        "tco.Nombre as NombreComida, tco.Costo as CostoComida, tco.Hora as HoraComida,\n" +
                        "tc.Nombre as NombreComensal, tc.descuentoDesayuno, tc.descuentoAlmuerzo, tc.descuentoCena\n" +
                        "FROM CReservaExterno ce, CComensalExterno cd, CTipoComensal tc, CTipoComida tco\n" +
                        "WHERE ce.IdTipoComensal = tc.Id\n" +
                        "AND ce.IdTipoComida = tco.IdTipoComida\n" +
                        "AND ce.IdComensalExterno = cd.idComensalExterno\n" +
                        " AND ce.Estado <> 6" + parameter;
            
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                C_TipoComensal r = new C_TipoComensal();
                r.setIdEmpleadoReserva(res.getInt("idReservaExterno"));
                r.setIdEmpleado(res.getInt("idComensalExterno"));
                r.setIdTipoComida(res.getInt("IdTipoComida"));
                r.setNombreComida(res.getString("NombreComida"));
                r.setHora(res.getString("HoraComida"));
                r.setCosto(res.getDouble("CostoComida"));
                r.setIdTipoComensal(res.getInt("IdTipoComensal"));
                r.setFecha(res.getString("Fecha"));
                r.setCantidad(res.getInt("Cantidad"));
                r.setEstado(res.getInt("Estado"));
                r.setObservacion(res.getString("observacion"));
                r.setFechaRegistro(res.getDate("fechaRegistro"));
                r.setFechaActualizacion(res.getDate("fechaActualizacion"));
                r.setNombreComensal(res.getString("NombreComensal"));
                r.setNombreEmpleado(res.getString("nombreCompleto"));
                r.setTelefono(res.getInt("celular"));
                r.setDescuentoAdicional(res.getDouble("descuento"));
                r.setDescuentoDesayuno(res.getDouble("descuentoDesayuno"));
                r.setDescuentoAlmuerzo(res.getDouble("descuentoAlmuerzo"));
                r.setDescuentoCena(res.getDouble("descuentoCena"));
                listaReservaEmpleado.add(r);            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.C_EmpleadoReservaModel.getReservasForParams()" + e.getMessage());
        }
        return  listaReservaEmpleado;
    }
    
    public int getMaxComensalExterno(){
        int id = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();            
            String sql = "SELECT MAX(idComensalExterno) as idComensalExterno FROM CComensalExterno";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getInt("idComensalExterno");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.C_ComensalExterno.getMaxComensalExterno()" + e.getMessage());
        }
        return  id;
    }
    
    public C_Empleado_Reserva getReservaExternoById(int idReservaExterno){
        C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT re.idReservaExterno, re.IdTipoComida, re.IdTipoComensal, re.Fecha, re.Cantidad, re.Estado, re.Observacion, re.Cancelar, re.fechaCancelacion, re.fechaRegistro, re.fechaActualizacion, re.descuento, \n" +
                        "ce.idComensalExterno, ce.NombreCompleto, ce.Celular, \n" +
                        "tc.Nombre as NombreComida, tc.Costo as CostoComida, tc.Hora as HoraComida, tc.color as ColorComida, tc.Detalles as DetalleComida, tc.horasAnticipacion as HorasAnticipacionComida,\n" +
                        "tco.Nombre as NombreComensal, tco.descuento as DescuentoComensal\n" +
                        "FROM CReservaExterno re, CComensalExterno ce, CTipoComensal tco, CTipoComida tc\n" +
                        "WHERE re.IdComensalExterno = ce.IdComensalExterno\n" +
                        "AND re.IdTipoComensal = tco.Id\n" +
                        "AND re.IdTipoComida = tc.IdTipoComida\n" +
                        "AND re.idReservaExterno = " + idReservaExterno;
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                empleadoReserva.setIdEmpleadoReserva(res.getInt("idReservaExterno"));
                empleadoReserva.setIdTipoComida(res.getInt("IdTipoComida"));
                empleadoReserva.setIdTipoComensal(res.getInt("IdTipoComensal"));
                empleadoReserva.setFecha(res.getString("Fecha"));
                empleadoReserva.setCantidad(res.getInt("Cantidad"));
                empleadoReserva.setEstado(res.getInt("Estado"));
                empleadoReserva.setObservacion(res.getString("Observacion"));
                empleadoReserva.setCancelar(res.getInt("Cancelar"));
                empleadoReserva.setFechaCancelacion(res.getString("FechaCancelacion"));
                empleadoReserva.setFechaRegistro(res.getDate("fechaRegistro"));
                empleadoReserva.setFechaActualizacion(res.getDate("fechaActualizacion"));
                empleadoReserva.setNombreComida(res.getString("NombreComida"));
                empleadoReserva.setCosto(res.getDouble("CostoComida"));
                empleadoReserva.setHora(res.getString("HoraComida"));
                empleadoReserva.setColor(res.getString("ColorComida"));
                empleadoReserva.setDetalle(res.getString("DetalleComida"));
                empleadoReserva.setHorasAnticipacion(res.getString("HorasAnticipacionComida"));
                empleadoReserva.setNombreEmpleado(res.getString("NombreCompleto"));
                empleadoReserva.setTelefono(res.getInt("Celular"));
                empleadoReserva.setDescuentoAdicional(res.getInt("descuento"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.C_ComensalExterno.getReservaExternoById() " + e.getMessage());
        }
        return empleadoReserva;
    }
    
    public String SaveComensalExterno(C_Empleado_Reserva empleadoReserva) {
        String respuesta = "Ok";
        try {            
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO CComensalExterno\n"
                    + "           (nombreCompleto, celular, fechaRegistro, fechaActualizar)\n"
                    + "     VALUES\n"
                    + "           ('" + empleadoReserva.getNombreCompleto()+ "', "+empleadoReserva.getCelular()+", CONVERT(date, SYSDATETIME()), CONVERT(date, SYSDATETIME()))";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_ComensalExterno.SaveComensalExterno() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String EditReservaExteno(int idReservaEmpleado, C_Empleado_Reserva reservaEmpleado){
        String respuesta = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE CReservaExterno \n"
                    + "   SET Cantidad = "+reservaEmpleado.getCantidad()+","
                    + "       IdTipoComensal = "+reservaEmpleado.getIdTipoComensal()+ ","
                    + "       Observacion = '"+reservaEmpleado.getObservacion() + "',"
                    + "       descuento = "+reservaEmpleado.getDescuentoAdicional()+ ","
                    + "       fechaActualizacion = CONVERT(date, SYSDATETIME())"
                    + " WHERE idReservaExterno  = " + idReservaEmpleado ;
            respuesta = "Ok";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_ComensalExterno.EditReservaExteno() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    
    public String SaveReservaExterno(int idComensalExterno, C_Empleado_Reserva empleadoReserva) {
        String respuesta = "Ok";
        try {            
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO CReservaExterno\n"
                    + "           (IdTipoComensal, IdComensalExterno, Fecha, Cantidad, Estado, Observacion, Cancelar, FechaCancelacion, IdTipoComida, fechaRegistro, descuento, notificacion, listarNotificacion)\n"
                    + "     VALUES\n"
                    + "           (" + empleadoReserva.getIdTipoComensal()+ ", "+idComensalExterno+",'"+ empleadoReserva.getFecha()+ "',"+ empleadoReserva.getCantidad()+", 1,'"+empleadoReserva.getObservacion()+"', 0, null,"+empleadoReserva.getIdTipoComida()+",  CONVERT(date, SYSDATETIME()), 0, "+empleadoReserva.getNotificacion()+","+empleadoReserva.getListarNotifiacion()+")";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_ComensalExterno.SaveComensalExterno() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteReservaExterno(int idReservaExterno){
        String respuesta = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE CReservaExterno \n"
                    + "   SET Estado = 6 \n"
                    + " WHERE idReservaExterno  = " + idReservaExterno ;
            respuesta = "Ok";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_ComensalExterno.DeleteReservaExterno() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
