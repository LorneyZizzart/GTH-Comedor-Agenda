package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Area;
import Entidad.Departamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaModel {

    public List<Area> getAllArea() {
        List<Area> areas = new ArrayList<Area>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Area_id, Nombre, Posicion, Estado, Fecha_creacion \n"
                    + "  FROM Area ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Area a = new Area();
                a.setArea_id(res.getInt("Area_id"));
                a.setNombre(res.getString("Nombre"));
                a.setPosicion(res.getInt("Posicion"));
                a.setEstado(res.getInt("Estado"));
                a.setFecha_creacion(res.getDate("Fecha_creacion"));
                areas.add(a);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.AreaModel.getAllArea() " + e.getMessage());
        }
        return areas;
    }

    public String InsertOrUpdateArea(Area area) {
        String respuesta = "";
        try {
            if (area.getArea_id() == 0) {
                //insert
                respuesta = InsertArea(area);
            } else {
                //actualiza
                respuesta = UpdatetArea(area);
            }
        } catch (Exception e) {
            respuesta = "Modelo.AreaModel.InsertOrUpdateArea() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String InsertArea(Area area) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Area(Nombre, Posicion, Estado, Fecha_creacion)\n"
                    + "     VALUES('" + area.getNombre() + "','" + area.getPosicion() + "','" + area.getEstado() + "',CONVERT(date, SYSDATETIME()))";
            db.insertar(sql);
            mensaje = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.AreaModel.InsertArea() " + e.getMessage());
        }
        return mensaje;
    }

    public String UpdatetArea(Area area) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Area \n"
                    + "   SET Nombre = '" + area.getNombre() + "'\n"
                    + "      ,Posicion =  '" + area.getPosicion() + "'\n"
                    + "      ,Estado =  '" + area.getEstado() + "'\n"
                    + "      ,Fecha_creacion = CONVERT(date, SYSDATETIME()) \n"
                    + " WHERE Area_id ='" + area.getArea_id() + "'  ";
            db.actualizar(sql);
            mensaje = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.AreaModel.UpdatetArea() " + e.getMessage());
        }
        return mensaje;
    }

    public Area getAreaById(int id) {
        Area a = new Area();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Area_id, Nombre, Posicion, Estado, Fecha_creacion \n"
                    + "  FROM Area WHERE Area_id = '" + id + "' ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                a.setArea_id(res.getInt("Area_id"));
                a.setNombre(res.getString("Nombre"));
                a.setPosicion(res.getInt("Posicion"));
                a.setEstado(res.getInt("Estado"));
                a.setFecha_creacion(res.getDate("Fecha_creacion"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.AreaModel.getAreaById() " + e.getMessage());
        }
        return a;
    }

    public List<Departamento> DeleteArea(int area_id) {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            DepartamentoModel dep_model = new DepartamentoModel();
            departamentos = dep_model.GetAllDepartamentoByIdArea(area_id);
            if (departamentos.isEmpty()) {
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "DELETE Area\n"
                        + "      WHERE Area_id = '" + area_id + "'";
                db.borrar(sql);
                db.cierraConexion();
            }

        } catch (SQLException e) {
            System.out.println("Modelo.AreaModel.DeleteArea() " + e.getMessage());
        }
        return departamentos;
    }

}
