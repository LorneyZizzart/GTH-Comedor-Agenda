/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.C_TipoComida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class C_TipoComidaModel {
    
    public List<C_TipoComida> getAllTipoComida() {
        List<C_TipoComida> tipoComidas = new ArrayList<C_TipoComida>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT IdTipoComida, Nombre, Costo, Estado, Hora, Detalles, FechaRegistro, FechaActualizacion, color, horasAnticipacion"
                        + " FROM CTipoComida "
                        + " WHERE Estado <> 6";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                C_TipoComida tipoComida = new C_TipoComida();
                tipoComida.setIdTipoComida(res.getInt("IdTipoComida"));
                tipoComida.setNombreComida(res.getString("Nombre"));
                tipoComida.setCosto(res.getDouble("Costo"));
                tipoComida.setEstado(res.getInt("Estado"));
                tipoComida.setHora(res.getString("Hora"));
                tipoComida.setDetalle(res.getString("Detalles"));
                tipoComida.setFechaRegistro(res.getDate("FechaRegistro"));
                tipoComida.setFechaActualizacion(res.getDate("FechaActualizacion"));
                tipoComida.setColor(res.getString("color"));
                tipoComida.setHorasAnticipacion(res.getString("horasAnticipacion"));
                tipoComidas.add(tipoComida);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.C_TipoComidaController.getAllTipoComensal() " + e.getMessage());
        }
        return tipoComidas;
    }
    
    
    public C_TipoComida getTipoComidaById(int idTipoComida) {
        C_TipoComida tipoComida = new C_TipoComida();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT IdTipoComida, Nombre, Costo, Estado, Hora, Detalles, FechaRegistro, FechaActualizacion, color, horasAnticipacion"
                        + " FROM CTipoComida "
                        + " WHERE IdTipoComida = " + idTipoComida + "";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                tipoComida.setIdTipoComida(res.getInt("IdTipoComida"));
                tipoComida.setNombreComida(res.getString("Nombre"));
                tipoComida.setCosto(res.getDouble("Costo"));
                tipoComida.setEstado(res.getInt("Estado"));
                tipoComida.setHora(res.getString("Hora"));
                tipoComida.setDetalle(res.getString("Detalles"));
                tipoComida.setFechaRegistro(res.getDate("FechaRegistro"));
                tipoComida.setFechaActualizacion(res.getDate("FechaActualizacion"));
                tipoComida.setColor(res.getString("color"));
                tipoComida.setHorasAnticipacion(res.getString("horasAnticipacion"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.CargoController.getCargoByCargoId() " + e.getMessage());
        }
        return tipoComida;
    }
    
    public String SaveOrUpdate(C_TipoComida tipoComida) {
        String respuesta = "Ok";
        try {
            if (tipoComida.getIdTipoComida()== 0) {
                //insertar
                respuesta = SaveTipoComida(tipoComida);
            } else {
                // Actualizar
                respuesta = ActualizarTipoComida(tipoComida);
            }

        } catch (Exception e) {
        }
        return respuesta;
    }
    
    private String SaveTipoComida(C_TipoComida tipoComida) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO CTipoComida\n"
                    + "           (Nombre, Costo, Estado, Hora, Detalles, FechaRegistro, FechaActualizacion, color, horasAnticipacion)\n"
                    + "     VALUES\n"
                    + "           ('" + tipoComida.getNombreComida()+ "','"+ tipoComida.getCosto()+"',"  + tipoComida.getEstado() + ", '"+ tipoComida.getHora()+ "', '"+tipoComida.getDetalle()+"', CONVERT(date, SYSDATETIME()), CONVERT(date, SYSDATETIME()),'"+tipoComida.getColor()+"', '"+tipoComida.getHorasAnticipacion()+"')";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_TipoComidaModel.SaveTipoComida() " + e.getMessage();
        }
        return respuesta;
    }
    
    private String ActualizarTipoComida(C_TipoComida tipoComida) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "UPDATE CTipoComida \n"
                    + "   SET Nombre = '" + tipoComida.getNombreComida()+ "' \n"
                    + "      ,Costo = '" + tipoComida.getCosto()+ "' \n"
                    + "      ,Estado = " + tipoComida.getEstado() + " \n"
                    + "      ,Hora = '" + tipoComida.getHora()+ "' \n"
                    + "      ,color = '" + tipoComida.getColor()+ "' \n"
                    + "      ,Detalles = '" + tipoComida.getDetalle()+ "' \n"
                    + "      ,horasAnticipacion = '" + tipoComida.getHorasAnticipacion()+ "' \n"
                    + "      ,fechaActualizacion = CONVERT(date, SYSDATETIME()) \n"
                    + " WHERE IdTipoComida = " + tipoComida.getIdTipoComida();
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_TipoComidaModel.ActualizarTipoComida() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteTipoComida(int idTipoComida) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE CTipoComida \n"
                    + "   SET Estado = 6 \n"
                    + " WHERE IdTipoComida  = " + idTipoComida ;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_TipoComidaModelo.DeleteTipoComida() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
