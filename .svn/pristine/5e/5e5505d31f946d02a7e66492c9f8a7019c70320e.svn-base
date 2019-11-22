/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.C_TipoComensal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class C_TipoComensalModel {
    
    public List<C_TipoComensal> getAllTipoComensal() {
        List<C_TipoComensal> tipoComensales = new ArrayList<C_TipoComensal>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Id, Nombre, MinimiDias, Estado, fechaRegistro, UsuarioCrea, fechaActualizacion, diasAnticipacion, descuentoDesayuno, descuentoAlmuerzo, descuentoCena"
                        + " FROM CTipoComensal "
                        + " WHERE Estado <> 6";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                C_TipoComensal tipoComensal = new C_TipoComensal();
                tipoComensal.setTipoComensal_id(res.getInt("Id"));
                tipoComensal.setNombreComensal(res.getString("Nombre"));
                tipoComensal.setMinimoDias(res.getInt("MinimiDias"));
                tipoComensal.setEstado(res.getInt("Estado"));
                tipoComensal.setFechaRegistro(res.getDate("fechaRegistro"));
                tipoComensal.setUsuarioCrea(res.getInt("UsuarioCrea"));
                tipoComensal.setFechaActualiza(res.getDate("fechaActualizacion"));
                tipoComensal.setDiasAnticipacion((res.getInt("diasAnticipacion")));
                tipoComensal.setDescuentoDesayuno((res.getDouble("descuentoDesayuno")));
                tipoComensal.setDescuentoAlmuerzo((res.getDouble("descuentoAlmuerzo")));
                tipoComensal.setDescuentoCena((res.getDouble("descuentoCena")));
                tipoComensales.add(tipoComensal);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.CargoController.getCargoByCargoId() " + e.getMessage());
        }
        return tipoComensales;
    }
    
    public C_TipoComensal getTipoComensalById(int idTipoComensal) {
        C_TipoComensal tipoComensal = new C_TipoComensal();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Id, Nombre, MinimiDias, Estado, UsuarioCrea, fechaRegistro, fechaActualizacion, diasAnticipacion, descuentoDesayuno, descuentoAlmuerzo, descuentoCena "
                        + " FROM CTipoComensal "
                        + "  WHERE Id = " + idTipoComensal;
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                tipoComensal.setTipoComensal_id(res.getInt("Id"));
                tipoComensal.setNombreComensal(res.getString("Nombre"));
                tipoComensal.setMinimoDias(res.getInt("MinimiDias"));
                tipoComensal.setEstado(res.getInt("Estado"));
                tipoComensal.setFechaRegistro(res.getDate("fechaRegistro"));
                tipoComensal.setFechaActualiza(res.getDate("fechaActualizacion"));
                tipoComensal.setUsuarioCrea(res.getInt("UsuarioCrea"));
                tipoComensal.setDiasAnticipacion(res.getInt("diasAnticipacion"));
                tipoComensal.setDescuentoDesayuno((res.getDouble("descuentoDesayuno")));
                tipoComensal.setDescuentoAlmuerzo((res.getDouble("descuentoAlmuerzo")));
                tipoComensal.setDescuentoCena((res.getDouble("descuentoCena")));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.CargoController.getCargoByCargoId() " + e.getMessage());
        }
        return tipoComensal;
    }
    
    public String SaveOrUpdate(C_TipoComensal tipoComensal) {
        String respuesta = "Ok";
        try {
            if (tipoComensal.getTipoComensal_id()== 0) {
                //insertar
                respuesta = SaveTipoComensal(tipoComensal);
            } else {
                // Actualizar
                respuesta = ActualizarTipoComensal(tipoComensal);
            }

        } catch (Exception e) {
        }
        return respuesta;
    }
    
    private String SaveTipoComensal(C_TipoComensal tipoComensal) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO CTipoComensal\n"
                    + "           (Nombre, MinimiDias, Estado, fechaRegistro, UsuarioCrea, fechaActualizacion, diasAnticipacion, descuentoDesayuno, descuentoAlmuerzo, descuentoCena)\n"
                    + "     VALUES\n"
                    + "           ('" + tipoComensal.getNombreComensal()+ "',"+ tipoComensal.getMinimoDias()+","  + tipoComensal.getEstado() + ", CONVERT(date, SYSDATETIME()), " + tipoComensal.getUsuarioCrea() + ", CONVERT(date, SYSDATETIME()),"+tipoComensal.getDiasAnticipacion()+",'"+tipoComensal.getDescuentoDesayuno()+"','"+tipoComensal.getDescuentoAlmuerzo()+"','"+tipoComensal.getDescuentoCena()+"')";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_TipoComensalModel.SaveTipoComensal() " + e.getMessage();
        }
        return respuesta;
    }
    
    private String ActualizarTipoComensal(C_TipoComensal tipoComensal) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "UPDATE CTipoComensal \n"
                    + "   SET Nombre = '" + tipoComensal.getNombreComensal()+ "' \n"
                    + "      ,descuentoDesayuno = '" + tipoComensal.getDescuentoDesayuno()+ "' \n"
                    + "      ,descuentoAlmuerzo = '" + tipoComensal.getDescuentoAlmuerzo()+ "' \n"
                    + "      ,descuentoCena = '" + tipoComensal.getDescuentoCena()+ "' \n"
                    + "      ,diasAnticipacion = " + tipoComensal.getDiasAnticipacion()+ " \n"
                    + "      ,Estado = '" + tipoComensal.getEstado() + "' \n"
                    + "      ,fechaActualizacion = CONVERT(date, SYSDATETIME()) \n"
                    + " WHERE Id  = " + tipoComensal.getTipoComensal_id();
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.C_TipoComensalModel.ActualizarTipoComensal() " + e.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteTipoComensal(int tipoComensal_Id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE CTipoComensal \n"
                    + "   SET Estado = 6 \n"
                    + " WHERE Id  = " + tipoComensal_Id ;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.CargoModelo.DeleteTipoComensal() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
}
