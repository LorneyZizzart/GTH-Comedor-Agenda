package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Evento_participantes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Evento_participantesModel {

    public String AnadirParticipantes(List<Evento_participantes> Participates) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            for (Evento_participantes pa : Participates) {
                if (verifica_participante_evento(pa)) {
                    activamos_participante_evento(pa);
                } else {
                    String sql = "INSERT Evento_participantes\n"
                            + "           (Empleado_id, Evento_id, Estado\n"
                            + "           ,Registra_personal_id, Fecha_registro)\n"
                            + "     VALUES\n"
                            + "           ('" + pa.getEmpleado_id() + "','" + pa.getEvento_id() + "','1'\n"
                            + "		   ,'" + pa.getRegistra_personal_id() + "', CONVERT(date, SYSDATETIME()))";
                    System.out.println("Insert participante : " + sql);
                    db.insertar(sql);
                }
            }
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Evento_participantesModel.AnadirParticipantes() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String EliminaParticipanteEvento(Evento_participantes participante) {
        String retorna = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Evento_participantes\n"
                    + "   SET Estado = '6'\n"
                    + "      ,Registra_personal_id = '" + participante.getRegistra_personal_id() + "'      \n"
                    + " WHERE Empleado_id = '" + participante.getEmpleado_id() + "' and Evento_id = '" + participante.getEvento_id() + "'";
            System.err.println("EliminaParticipanteEvento: " + sql);
            db.actualizar(sql);

            db.cierraConexion();
        } catch (SQLException e) {
            retorna = "Modelo.Evento_participantesModel.EliminaParticipanteEvento() " + e.getMessage();
            System.out.println(retorna);
        }
        return retorna;
    }

    private boolean verifica_participante_evento(Evento_participantes pa) {
        boolean retorna = true;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            int valor = 0;
            String sql = "SELECT count(*) total\n"
                    + "  FROM Evento_participantes \n"
                    + " WHERE Empleado_id = '" + pa.getEmpleado_id() + "' and Evento_id = '" + pa.getEvento_id() + "' and Estado = '6'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                valor = res.getInt("total");
            }

            if (valor == 0) {
                retorna = false;
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_participantesModel.verifica_participante_evento() " + e.getMessage());
        }
        return retorna;
    }

    private void activamos_participante_evento(Evento_participantes pa) {
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Evento_participantes\n"
                    + "   SET Estado = '1'\n"
                    + "      ,Registra_personal_id = '" + pa.getRegistra_personal_id() + "'      \n"
                    + " WHERE Empleado_id = '" + pa.getEmpleado_id() + "' and Evento_id = '" + pa.getEvento_id() + "'";
            System.out.println("EliminaParticipanteEvento: " + sql);
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_participantesModel.activamos_participante_evento() " + e.getMessage());
        }
    }

    public String AnadirUnParticipantes(Evento_participantes Participates) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            if (verifica_participante_evento(Participates)) {
                activamos_participante_evento(Participates);
            } else {
                String sql = "INSERT Evento_participantes\n"
                        + "           (Empleado_id, Evento_id, Estado\n"
                        + "           ,Registra_personal_id, Fecha_registro)\n"
                        + "     VALUES\n"
                        + "           ('" + Participates.getEmpleado_id() + "','" + Participates.getEvento_id() + "','1'\n"
                        + "		   ,'" + Participates.getRegistra_personal_id() + "', CONVERT(date, SYSDATETIME()))";
                System.out.println("Insert un participante : " + sql);
                db.insertar(sql);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Evento_participantesModel.AnadirParticipantes() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

}
