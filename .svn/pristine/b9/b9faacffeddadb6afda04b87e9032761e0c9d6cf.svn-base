package Modelo;

import Conexion.ConectaSqlServer;
import java.sql.SQLException;
import java.util.List;

public class Cuestionario_gestion_empleadoModelo {

    public String Insert_Cuestionario_gestion_empleado(int cuestionario_gestion_id, List<String> empleado_id) {
        String resultado = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            for (String id : empleado_id) {
                String sql = "INSERT INTO Cuestionario_gestion_empleado\n"
                        + "           (Cuestionario_gestion_id, Empleado_id)\n"
                        + "     VALUES\n"
                        + "           ('" + cuestionario_gestion_id + "', '" + id + "')";
                db.insertar(sql);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Cuestionario_gestion_empleadoModelo.Insert_Cuestionario_gestion_empleado() " + e.getMessage());
        }
        return resultado;
    }

    public String DeleteEmpledadodeGestion(int Cuestionario_gestion_empleado_id) {
        String resultado = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "delete from Cuestionario_gestion_empleado where Cuestionario_gestion_empleado_id = " + Cuestionario_gestion_empleado_id + "";
            System.out.print(sql);
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            resultado = "Modelo.Cuestionario_gestion_empleadoModelo.DeleteEmpledadodeGestion() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }
}
