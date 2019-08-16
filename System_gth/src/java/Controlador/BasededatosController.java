package Controlador;

import Conexion.ConectaSqlServer;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasededatosController {

    public String Copia_deSeguridad() {
        String resultado = "";
        Date objDate = new Date();
        String newstring = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(objDate);
        //String dbName = "GTH_" + objDate.getDay() + "--" + objDate.getMonth() + "--" + objDate.getYear() + "__" + objDate.getMinutes() + ":" + objDate.getSeconds() + ".bak";
        String dbName = "GTH_" + newstring+".bak";

        try {

            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = " Backup Database GTH TO DISK='C:\\backup\\" + dbName + "' ";
            db.insertar(sql);
            resultado = "Ok";
            db.cierraConexion();

        } catch (SQLException e) {
            resultado = "Controlador.BasededatosController.Copia_deSeguridad() " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }
}
