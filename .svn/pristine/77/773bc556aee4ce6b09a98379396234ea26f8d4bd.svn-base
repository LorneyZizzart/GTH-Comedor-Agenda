package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Empleado_cargo;
import Entidad.Nivel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NivelModel {

    public List<Nivel> getAllNivel() {
        List<Nivel> niveles = new ArrayList<Nivel>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "SELECT Nivel_id, Nombre, Estado, Fecha_creacion, Posicion"
                    + "  FROM Nivel order by Posicion ";
            ResultSet res = db.consulta(Sql);
            while (res.next()) {
                Nivel nivel = new Nivel();
                nivel.setNivel_id(res.getInt("Nivel_id"));
                nivel.setNombre(res.getString("Nombre"));
                nivel.setEstado(res.getInt("Estado"));
                nivel.setFecha_creacion(res.getDate("Fecha_creacion"));
                nivel.setPosicion(res.getInt("Posicion"));
                niveles.add(nivel);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.NivelModel.getAllNivel() " + e.getMessage());
        }
        return niveles;
    }

    public String InsertOrUpdateNivel(Nivel nivel) {
        String mensaje = "";
        try {
            if (nivel.getNivel_id() == 0) {
                //insertamos
                mensaje = insertNivel(nivel);
            } else {
                //Actualizamos
                mensaje = updatetNivel(nivel);
            }
        } catch (Exception e) {
            mensaje = "Modelo.NivelModel.insertUpdateNivel()" + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String insertNivel(Nivel nivel) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Nivel (Nombre, Estado, Fecha_creacion, Posicion)\n"
                    + "     VALUES('" + nivel.getNombre() + "','" + nivel.getEstado() + "', CONVERT(date, SYSDATETIME()),'" + nivel.getPosicion() + "')";
            db.insertar(sql);
            mensaje = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.NivelModel.insertNivel() " + e.getMessage();
            System.out.println("Modelo.NivelModel.insertNivel() " + e.getMessage());
        }
        return mensaje;
    }

    public String updatetNivel(Nivel nivel) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Nivel\n"
                    + "   SET Nombre = '" + nivel.getNombre() + "'\n"
                    + "      ,Estado = '" + nivel.getEstado() + "'\n"
                    + "      ,Fecha_creacion = CONVERT(date, SYSDATETIME()) \n"
                    + "      ,Posicion = '" + nivel.getPosicion() + "' \n"
                    + " WHERE Nivel_id = '" + nivel.getNivel_id() + "'";
            db.insertar(sql);
            mensaje = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.NivelModel.insertNivel() " + e.getMessage();
            System.out.println("Modelo.NivelModel.updatetNivel() " + e.getMessage());
        }
        return mensaje;
    }

    public Nivel getNivelById(int id) {
        Nivel nivel = new Nivel();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "SELECT Nivel_id, Nombre, Estado, Fecha_creacion, Posicion"
                    + "  FROM Nivel WHERE Nivel_id = '" + id + "'";
            ResultSet res = db.consulta(Sql);
            if (res.next()) {
                nivel.setNivel_id(res.getInt("Nivel_id"));
                nivel.setNombre(res.getString("Nombre"));
                nivel.setEstado(res.getInt("Estado"));
                nivel.setFecha_creacion(res.getDate("Fecha_creacion"));
                nivel.setPosicion(res.getInt("Posicion"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.NivelModel.getNivelById() " + e.getMessage());
        }
        return nivel;
    }

    public List<Empleado_cargo> DeleteNivel(int nivelId) {
        List<Empleado_cargo> cargos = new ArrayList<Empleado_cargo>();
        try {
            Empleado_cargoModel emple = new Empleado_cargoModel();
            cargos = emple.getAllEmpleado_cargoByNivel_id(nivelId);
            if (cargos.isEmpty()) {
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "DELETE FROM Nivel\n"
                        + "      WHERE Nivel_id = '" + nivelId + "'";
                db.borrar(sql);
                db.cierraConexion();
            }

        } catch (SQLException e) {
            System.out.println("Modelo.NivelModel.DeleteNivel() " + e.getMessage());
        }
        return cargos;
    }

}
