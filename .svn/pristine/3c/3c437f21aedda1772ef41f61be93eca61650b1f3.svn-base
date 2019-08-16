package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Feedback;
import Entidad.Feedback_tipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackModelo {
    
    public List<Feedback_tipo> get_All_TiposAdventendia() {
        List<Feedback_tipo> tipos = new ArrayList<Feedback_tipo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Feedback_tipo_id\n"
                    + "      ,Nombre\n"
                    + "      ,Estado\n"
                    + "  FROM Feedback_tipo\n"
                    + " WHERE Estado = '1'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Feedback_tipo tipo = new Feedback_tipo();
                tipo.setFeedback_tipo_id(res.getInt("Feedback_tipo_id"));
                tipo.setNombre(res.getString("Nombre"));
                tipo.setEstado(res.getInt("Estado"));
                tipos.add(tipo);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.FeedbackModelo.get_All_TiposAdventendia() " + e.getMessage());
        }
        return tipos;
    }
    
    public String Create_or_update(Feedback advertencia) {
        String mensaje = "Ok";
        if (advertencia.getFeedback_id() == 0) {
            mensaje = Create_advertencia(advertencia);
        } else {
            mensaje = Update_advertencia(advertencia);
        }
        return mensaje;
    }
    
    private String Create_advertencia(Feedback advertencia) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String formatoFecha = cambia_formato_fecha_us(advertencia.getFecha_advertencia());
            String sql = "INSERT INTO Feedback\n"
                    + "           (Motivo, Descripcion, Feedback_tipo_id\n"
                    + "           ,Fecha_creacion, Estado, Empleado_id\n"
                    + "           ,Admin_id,Fecha_advertencia)\n"
                    + "     VALUES\n"
                    + "           ('" + advertencia.getMotivo() + "','" + advertencia.getDescripcion() + "','" + advertencia.getFeedback_tipo_id() + "'"
                    + "            , CONVERT(date, SYSDATETIME()),1,'" + advertencia.getEmpleado_id() + "'"
                    + "            , '" + advertencia.getAdmin_id() + "', CONVERT(date,'" + formatoFecha + "'))";
            
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.FeedbackModelo.Create_advertencia() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
    
    private String Update_advertencia(Feedback advertencia) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String formatoFecha = cambia_formato_fecha_us(advertencia.getFecha_advertencia());
            String sql = "UPDATE Feedback\n"
                    + "   SET Motivo = '" + advertencia.getMotivo() + "'\n"
                    + "      ,Descripcion = '" + advertencia.getDescripcion() + "'\n"
                    + "      ,Feedback_tipo_id = '" + advertencia.getFeedback_tipo_id() + "'\n"
                    + "      ,Estado = '1'\n"
                    + "      ,Fecha_actualiza = CONVERT(date, SYSDATETIME())\n"
                    + "      ,Admin_actualiza = '" + advertencia.getAdmin_id() + "'\n"
                    + "      ,Fecha_advertencia = CONVERT(date,'" + formatoFecha + "')\n"
                    + " WHERE Feedback_id = '" + advertencia.getFeedback_id() + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = " Modelo.FeedbackModelo.Update_advertencia() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    /*
    cambia de dd/mm/yyyy a yyyy/mm/dd
     */
    public String cambia_formato_fecha_us(String fecha) {
        String separa[] = fecha.split("/");
        String dia = separa[0];
        String mes = separa[1];
        String anio = separa[2];
        return anio + "/" + mes + "/" + dia;
    }
    
    public List<Feedback> Get_all_feedback_empleado(int empleado_id) {
        List<Feedback> notas = new ArrayList<Feedback>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select f.Feedback_id, ft.Feedback_tipo_id, ft.Nombre, f.Motivo, CONVERT(varchar(10) ,f.Fecha_creacion, 103) Fecha_creacion\n"
                    + "from Feedback f \n"
                    + "inner join Feedback_tipo ft\n"
                    + "on f.Feedback_tipo_id = ft.Feedback_tipo_id where f.Estado = '1' and f.Empleado_id = '" + empleado_id + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Feedback nota = new Feedback();
                nota.setFeedback_id(res.getInt("Feedback_id"));
                nota.setFeedback_tipo_id(res.getInt("Feedback_tipo_id"));
                nota.setFeedback_tipo_nombre(res.getString("Nombre"));
                nota.setMotivo(res.getString("Motivo"));
                nota.setFecha_advertencia(res.getString("Fecha_creacion"));
                notas.add(nota);
                
            }
            db.cierraConexion();
        } catch (SQLException e) {
        }
        return notas;
    }
    
    public Feedback Get_feedback_by_id(int Feedback_tipo_id) {
        Feedback nota = new Feedback();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select f.Feedback_id, ft.Feedback_tipo_id, ft.Nombre, f.Motivo, CONVERT(varchar(10) ,f.Fecha_creacion, 103) Fecha_creacion, f.Descripcion, "
                    + "CONCAT(em.Nombre,' ',em.Apellido_paterno,' ',em.Apellido_materno) Nombre_empleado\n"
                    + "from Feedback f \n"
                    + "inner join Feedback_tipo ft\n"
                    + "on f.Feedback_tipo_id = ft.Feedback_tipo_id \n"
                    + "inner join Empleado em \n"
                    + "on em.Empleado_id = f.Empleado_id\n"
                    + "where f.Feedback_id = '" + Feedback_tipo_id + "'  ";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                nota.setFeedback_id(res.getInt("Feedback_id"));
                nota.setFeedback_tipo_id(res.getInt("Feedback_tipo_id"));
                nota.setFeedback_tipo_nombre(res.getString("Nombre"));
                nota.setMotivo(res.getString("Motivo"));
                nota.setFecha_advertencia(res.getString("Fecha_creacion"));
                nota.setDescripcion(res.getString("Descripcion"));
                nota.setNombre_empleado(res.getString("Nombre_empleado"));
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.FeedbackModelo.Get_feedback_by_id() " + e.getMessage());
        }
        return nota;
    }
    
    public String delete_feedback_by_id(int Feedback_tipo_id, int admin_id) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Feedback\n"
                    + "   SET Estado = '6'\n"
                    + "      ,Fecha_actualiza = CONVERT(date, SYSDATETIME())\n"
                    + "      ,Admin_actualiza = '" + admin_id + "'\n"
                    + " WHERE Feedback_id = '" + Feedback_tipo_id + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.FeedbackModelo.delete_feedback_by_id() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
    
}
