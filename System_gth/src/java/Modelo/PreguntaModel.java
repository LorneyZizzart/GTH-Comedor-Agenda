package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Banco_respuestas;
import Entidad.Pregunta;
import Entidad.Pregunta_opcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreguntaModel {
    
    public String CreateOrUpdatePregunta(Pregunta pregunta) {
        String respuesta = "";
        try {
            if (pregunta.getPregunta_id() == 0) {
                //insertamos                
                respuesta = InsertaPregunta(pregunta);
            } else {
                //actualizamos
                respuesta = ActualizaPregunta(pregunta);
            }
            
        } catch (Exception e) {
            respuesta = "Modelo.PreguntaModel.CreateOrUpdatePregunta( ) " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    public String InsertaPregunta(Pregunta pregunta) {
        String respuesta = "";
        try {
            Banco_respuestasModelo banco = new Banco_respuestasModelo();
            List<Banco_respuestas> bancoRespuestas = new ArrayList<Banco_respuestas>();
            
            bancoRespuestas = banco.GetAllBancoRespuestasByTipo_id(pregunta.getTipo_id());
            if (bancoRespuestas.size() > 0) {
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "INSERT INTO Pregunta\n"
                        + "           (Cuestionario_id, Nombre, Estado, Orden, Fecha_creacion,Usuario_crea,Tipo_id)\n"
                        + "     VALUES\n"
                        + "           ('" + pregunta.getCuestionario_id() + "','" + pregunta.getNombre() + "','" + pregunta.getEstado() + "','" + pregunta.getOrden() + "',CONVERT(date, SYSDATETIME()),'" + pregunta.getUsuario_crea() + "','" + pregunta.getTipo_id() + "')";
                db.insertar(sql);
                int Pregunta_id = getLastIdPregunta();
                for (Banco_respuestas item : bancoRespuestas) {
                    
                    Pregunta_opcionModelo opcion = new Pregunta_opcionModelo();
                    Pregunta_opcion op = new Pregunta_opcion();
                    op.setCss(item.getCss());
                    op.setOpcion(item.getOpcion());
                    op.setPregunta_id(Pregunta_id);
                    op.setPregunta_opcion_id(0);
                    op.setSeccion(item.getSeccion());
                    
                    respuesta = opcion.insertPregunta_opcion(op);
                }
                db.cierraConexion();
                
                bancoRespuestas = banco.GetAllBancoRespuestasByTipo_id(pregunta.getTipo_id());
                respuesta = "Ok";
            } else {
                respuesta = "Se Requiere Banco de respuestas";
            }
        } catch (SQLException e) {
            respuesta = "Modelo.PreguntaModel.InsertaPregunta() " + e.getMessage();
            System.out.println(respuesta);
        }
        
        return respuesta;
    }
    
    public int getLastIdPregunta() {
        int id = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select max(Pregunta_id)id from Pregunta ";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getInt("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.PreguntaModel.getLastIdPregunta() " + e.getMessage());
        }
        return id;
    }
    
    public String ActualizaPregunta(Pregunta pregunta) {
        String mensaje = "";
        try {
            Pregunta_opcionModelo opcion = new Pregunta_opcionModelo();
            String eliOpci = opcion.eliminaPregunta_opcionByPregunta_id(pregunta.getPregunta_id());
            if (eliOpci.equalsIgnoreCase("Ok")) {
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "UPDATE Pregunta\n"
                        + "   SET Cuestionario_id = '" + pregunta.getCuestionario_id() + "'\n"
                        + "      ,Nombre = '" + pregunta.getNombre() + "'\n"
                        + "      ,Estado = '" + pregunta.getEstado() + "'\n"
                        + "      ,Orden = '" + pregunta.getOrden() + "'\n"
                        + "      ,Fecha_actualiza = CONVERT(date, SYSDATETIME()) \n"
                        + "      ,Usuario_actualiza = '" + pregunta.getUsuario_actualiza() + "'\n"
                        + "      ,Tipo_id = '" + pregunta.getTipo_id() + "'\n"
                        + " WHERE Pregunta_id = '" + pregunta.getPregunta_id() + "'";
                db.actualizar(sql);
                db.cierraConexion();
                mensaje = "Ok";
                
                Banco_respuestasModelo banco = new Banco_respuestasModelo();
                List<Banco_respuestas> bancoRespuestas = new ArrayList<Banco_respuestas>();
                bancoRespuestas = banco.GetAllBancoRespuestasByTipo_id(pregunta.getTipo_id());
                
                if (bancoRespuestas.size() > 0) {
                    for (Banco_respuestas item : bancoRespuestas) {
                        
                        Pregunta_opcionModelo opcions = new Pregunta_opcionModelo();
                        Pregunta_opcion op = new Pregunta_opcion();
                        op.setCss(item.getCss());
                        op.setOpcion(item.getOpcion());
                        op.setPregunta_id(pregunta.getPregunta_id());
                        op.setPregunta_opcion_id(0);
                        op.setSeccion(item.getSeccion());
                        
                        mensaje = opcions.insertPregunta_opcion(op);
                    }
                } else {
                    mensaje = "Se Requiere Banco de respuestas";
                }
                
            } else {
                mensaje = "No se pudo actualizar Pregunta, no se puede actualizar Opcion_respuesta";
            }
            
        } catch (SQLException e) {
            mensaje = "Modelo.PreguntaModel.ActualizaPregunta() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
    
    public List<Pregunta> GetAllPreguntaByCuestionarioId(int Cuestionario_id) {
        List<Pregunta> preguntas = new ArrayList<Pregunta>();
        try {
            Pregunta_opcionModelo opciones_respuesta = new Pregunta_opcionModelo();
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT p.Pregunta_id, p.Cuestionario_id, p.Nombre, p.Estado, p.Orden, p.Fecha_creacion, p.Usuario_crea, p.Fecha_actualiza, p.Usuario_actualiza, p.Tipo_id, t.Html \n"
                    + "  FROM Pregunta p inner join Tipo t on p.Tipo_id = p.Tipo_id \n"
                    + " WHERE Cuestionario_id = '" + Cuestionario_id + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Pregunta p = new Pregunta();
                p.setPregunta_id(res.getInt("Pregunta_id"));
                p.setCuestionario_id(res.getInt("Cuestionario_id"));
                p.setNombre(res.getString("Nombre"));
                p.setEstado(res.getInt("Estado"));
                p.setOrden(res.getInt("Orden"));
                p.setFecha_creacion(res.getDate("Fecha_creacion"));
                p.setUsuario_crea(res.getInt("Usuario_crea"));
                p.setFecha_actualiza(res.getDate("Fecha_actualiza"));
                p.setUsuario_actualiza(res.getInt("Usuario_actualiza"));
                p.setTipo_id(res.getInt("Tipo_id"));
                p.setNombre_tipo_id(res.getString("Html"));
                p.setPreguntaOpcion(opciones_respuesta.GetPreguntaOpcionByPregunta_id(p.getPregunta_id()));
                preguntas.add(p);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.PreguntaModel.GetAllPreguntaByCuestionarioId() " + e.getMessage());
        }
        return preguntas;
    }
    
    public String EliminaPregunta(int pregunta_id) {
        String mensaje = "";
        try {
            Pregunta_opcionModelo opcion = new Pregunta_opcionModelo();
            String eliOpci = opcion.eliminaPregunta_opcionByPregunta_id(pregunta_id);
            if (eliOpci.equalsIgnoreCase("Ok")) {
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String Sql = "DELETE FROM Pregunta\n"
                        + "         WHERE Pregunta_id = " + pregunta_id + "";
                db.insertar(Sql);
                db.cierraConexion();
                mensaje = eliOpci;
            } else {
                mensaje = eliOpci;
            }
        } catch (SQLException e) {
            mensaje = "Modelo.PreguntaModel.EliminaPregunta() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
    
    public Pregunta GetPreguntaByPregunta_Id(int pregunta_id) {
        Pregunta p = new Pregunta();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Pregunta_id, Cuestionario_id, Nombre, Estado, Orden, Fecha_creacion, Usuario_crea, Fecha_actualiza, Usuario_actualiza, Tipo_id \n"
                    + "  FROM Pregunta \n"
                    + " WHERE Pregunta_id = '" + pregunta_id + "'";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                p.setPregunta_id(res.getInt("Pregunta_id"));
                p.setCuestionario_id(res.getInt("Cuestionario_id"));
                p.setNombre(res.getString("Nombre"));
                p.setEstado(res.getInt("Estado"));
                p.setOrden(res.getInt("Orden"));
                p.setFecha_creacion(res.getDate("Fecha_creacion"));
                p.setUsuario_crea(res.getInt("Usuario_crea"));
                p.setFecha_actualiza(res.getDate("Fecha_actualiza"));
                p.setUsuario_actualiza(res.getInt("Usuario_actualiza"));
                p.setTipo_id(res.getInt("Tipo_id"));
                
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.PreguntaModel.GetPreguntaByPregunta_Id() " + e.getMessage());
        }
        return p;
    }
    
}
