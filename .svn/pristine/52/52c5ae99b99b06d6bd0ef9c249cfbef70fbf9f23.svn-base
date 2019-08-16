package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cargo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoModelo {

    public String SaveOrUpdate(Cargo cargo) {
        String respuesta = "Ok";
        try {
            if (cargo.getCargo_id() == 0) {
                //insertar
                respuesta = SaveCargo(cargo);
            } else {
                // Actualizar
                respuesta = ActualizarCargo(cargo);
            }

        } catch (Exception e) {
        }
        return respuesta;
    }

    private String SaveCargo(Cargo cargo) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Cargo\n"
                    + "           (Nombre, Descripcion, Estado)\n"
                    + "     VALUES\n"
                    + "           ('" + cargo.getNombre() + "','" + cargo.getDescripcion() + "','" + cargo.getEstado() + "')";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.CargoModelo.SaveCargo() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    private String ActualizarCargo(Cargo cargo) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "UPDATE Cargo \n"
                    + "   SET Nombre = '" + cargo.getNombre() + "' \n"
                    + "      ,Descripcion = '" + cargo.getDescripcion() + "' \n"
                    + "      ,Estado = '" + cargo.getEstado() + "' \n"
                    + " WHERE Cargo_id  = '" + cargo.getCargo_id() + "'";
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.CargoModelo.ActualizarCargo() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public Cargo getCargoByCargoId(int cargo_id) {
        Cargo cargo = new Cargo();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Cargo_id, Nombre, Descripcion, Estado\n"
                    + "  FROM Cargo \n"
                    + "  WHERE Cargo_id = '" + cargo_id + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                cargo.setCargo_id(res.getInt("Cargo_id"));
                cargo.setNombre(res.getString("Nombre"));
                cargo.setEstado(res.getInt("Estado"));
                cargo.setDescripcion(res.getString("Descripcion"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.CargoController.getCargoByCargoId() " + e.getMessage());
        }
        return cargo;
    }

    public List<Cargo> getAllCargoByCargoId() {
        List<Cargo> cargos = new ArrayList<Cargo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Cargo_id, Nombre, Descripcion, Estado\n"
                    + "  FROM Cargo \n"
                    + "  WHERE Estado <> 6";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Cargo cargo = new Cargo();
                cargo.setCargo_id(res.getInt("Cargo_id"));
                cargo.setNombre(res.getString("Nombre"));
                cargo.setEstado(res.getInt("Estado"));
                cargo.setDescripcion(res.getString("Descripcion"));
                cargos.add(cargo);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.CargoController.getCargoByCargoId() " + e.getMessage());
        }
        return cargos;
    }

    public String DeleteCargoByCargoId(int cargoId) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Cargo \n"
                    + "   SET Estado = '6' \n"
                    + " WHERE Cargo_id  = '" + cargoId + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.CargoModelo.DeleteCargoByCargoId() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

}
