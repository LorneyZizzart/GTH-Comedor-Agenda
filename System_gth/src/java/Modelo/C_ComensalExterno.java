/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.C_Empleado_Reserva;
import Entidad.C_TipoComensal;
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
            
            String sql = "SELECT ce.idComensalExterno, ce.IdTipoComensal, ce.IdTipoComida, ce.NombreCompleto, ce.Celular, ce.Fecha, ce.Estado, ce.Cantidad, ce.descuento, ce.fechaRegistro, ce.fechaActualizacion, 0 as funcionario,\n" +
                        "tco.Nombre as NombreComida, tco.Costo as CostoComida,\n" +
                        "tc.Nombre as NombreComensal, tc.descuentoDesayuno, tc.descuentoAlmuerzo, tc.descuentoCena\n" +
                        "FROM CComensalExterno ce, CTipoComensal tc, CTipoComida tco\n" +
                        "WHERE ce.IdTipoComensal = tc.Id\n" +
                        "AND ce.IdTipoComida = tco.IdTipoComida\n" +
                        " " + auxReq + " " +
                        "AND ce.Estado <> 6 ORDER BY ce.Fecha ASC";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                C_TipoComensal r = new C_TipoComensal();
                r.setIdEmpleadoReserva(res.getInt("idComensalExterno"));
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
    
    public String SaveComensalExterno(C_Empleado_Reserva empleadoReserva) {
        String respuesta = "Ok";
        try {            
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO CComensalExterno\n"
                    + "           (IdTipoComensal, NombreCompleto, Celular, Fecha, Cantidad, Estado, Observacion, Cancelar, FechaCancelacion, IdTipoComida, fechaRegistro, descuento, notificacion, listarNotificacion)\n"
                    + "     VALUES\n"
                    + "           (" + empleadoReserva.getIdTipoComensal()+ ", '"+empleadoReserva.getNombreCompleto()+"',"+empleadoReserva.getCelular()+",'"+ empleadoReserva.getFecha()+ "',"+ empleadoReserva.getCantidad()+", 1,'"+empleadoReserva.getObservacion()+"', 0, null,"+empleadoReserva.getIdTipoComida()+",  CONVERT(date, SYSDATETIME()), 0, "+empleadoReserva.getNotificacion()+","+empleadoReserva.getListarNotifiacion()+")";

            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_ComensalExterno.SaveComensalExterno() " + e.getMessage();
        }
        return respuesta;
    }
    
}
