package Modelo;

import Conexion.ConectaSqlServer;
import Controlador.EncriptionController;
import Entidad.View_Envia_Correo_Datos;
import Send_MailGmail.send_mailView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Send_mailModelo {

    public String Enviar_emailEvaluacion(int gestioin_id, int persona_id) {

        Controlador.EncriptionController encripta = new EncriptionController();

        String mensaje = "Ok";
        try {
            //String boton_click = "http://192.168.12.233:8080/System_gth/Respuesta/respuesta/index.jsp?id=";

            List<View_Envia_Correo_Datos> ListaMandarCorreo = new ArrayList<View_Envia_Correo_Datos>();
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select ce.Cuestionario_evalua_id, ce.Evalua_empleado_id, ce.A_empleado_id, (e.Apellido_paterno+' '+e.Apellido_materno+' '+ e.Nombre) Evaluador,\n"
                    + "		(select (Apellido_paterno+' '+Apellido_materno+' '+ Nombre) Nombre from Empleado where Empleado_id = ce.A_empleado_id) Evaluado, cg.Mensaje_correo, e.email, cg.Titulo_correo \n"
                    + "from Cuestioario_evalua ce\n"
                    + "	inner join Cuestionario_gestion cg\n"
                    + "	on cg.Cuestionario_gestion_id = ce.Cuestionario_gestion_id\n"
                    + "	inner join Empleado e\n"
                    + "	on e.Empleado_id = ce.Evalua_empleado_id\n"
                    + "where  cg.Cuestionario_gestion_id = '" + gestioin_id + "' and ce.A_empleado_id = '" + persona_id + "' and  (ce.Envio_correo is null or ce.Envio_correo <>1)";
            System.out.println(" Lista de personas a que se enviara el correo : " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                String id_ecriptado = encripta.ValorAEncriptar(res.getString("Cuestionario_evalua_id"));
                String html_boton = "<center>\n"
                        + "<div style=\"width:200px\">\n"
                        + "<a href=\"http://200.58.75.218:8080/gth_web/Respuesta/respuesta/index.jsp?iasdfsdfasdf121as2dd1f21sf12d=" + id_ecriptado + "\" style=\"text-decoration:none;color:#ffffff\" target=\"_blank\">\n"
                        + "              <p style=\"background-color:#541686;color:#ffffff;font-family:'Open Sans',Arial,sans-serif;font-size:16px;font-weight:50;line-height:24px;text-decoration:none;text-transform:none;border-radius:4px;margin:0;padding:16px 0\">\n"
                        + "             Haga clic para comenzar.\n"
                        + "              </p></a>\n"
                        + "              </div>\n"
                        + "              </center>";

                View_Envia_Correo_Datos enviar = new View_Envia_Correo_Datos();
                String mensaje_ = res.getString("Mensaje_correo");
                String evaluador_ = res.getString("Evaluador");
                String evaluado_ = res.getString("Evaluado");

                String new_mensaje = mensaje_.replace("--Evaluador--", evaluador_);
                new_mensaje = new_mensaje.replace("--Evaluado--", evaluado_);

                enviar.setCuestionario_evalua_id(res.getInt("Cuestionario_evalua_id"));
                enviar.setEvalua_empleado_id(res.getInt("Evalua_empleado_id"));
                enviar.setA_empleado_id(res.getInt("A_empleado_id"));
                enviar.setEvaluador(res.getString("Evaluador"));
                enviar.setEvaluado(res.getString("Evaluado"));
                enviar.setMensaje_correo(new_mensaje + html_boton);
                enviar.setEmail(res.getString("email"));
                enviar.setCorreo_titulo(res.getString("Titulo_correo"));

                ListaMandarCorreo.add(enviar);

            }

            for (View_Envia_Correo_Datos item : ListaMandarCorreo) {
                Send_MailGmail.send_mailView view = new send_mailView();
                String respuesta = view.Envia_correo_evaluacion(item.getEmail(), item.getMensaje_correo(), item.getCorreo_titulo());
                if (respuesta.equalsIgnoreCase("Ok")) {
                    String sqlActualizaEstado = "UPDATE Cuestioario_evalua \n"
                            + "   SET  Envio_correo = '1',\n"
                            + "		Fecha_envio_correo = CONVERT(date, SYSDATETIME())\n"
                            + " WHERE Cuestionario_evalua_id = '" + item.getCuestionario_evalua_id() + "' ";
                    System.out.println("-- Actualiza correo -- " + item.getEvaluador());
                    db.actualizar(sqlActualizaEstado);
                }
            }
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = ("Modelo.Send_mailModelo.Enviar_emailEvaluacion() " + e.getMessage());
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String Enviar_Un_emailEvaluacion(int cuestionario_evalua_id) {

        Controlador.EncriptionController encripta = new EncriptionController();

        String mensaje = "Ok";
        try {
            //String boton_click = "http://192.168.12.233:8080/System_gth/Respuesta/respuesta/index.jsp?id=";

            List<View_Envia_Correo_Datos> ListaMandarCorreo = new ArrayList<View_Envia_Correo_Datos>();
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select ce.Cuestionario_evalua_id, ce.Evalua_empleado_id, ce.A_empleado_id, (e.Apellido_paterno+' '+e.Apellido_materno+' '+ e.Nombre) Evaluador,\n"
                    + "		(select (Apellido_paterno+' '+Apellido_materno+' '+ Nombre) Nombre from Empleado where Empleado_id = ce.A_empleado_id) Evaluado, cg.Mensaje_correo, e.email, cg.Titulo_correo \n"
                    + "from Cuestioario_evalua ce\n"
                    + "	inner join Cuestionario_gestion cg\n"
                    + "	on cg.Cuestionario_gestion_id = ce.Cuestionario_gestion_id\n"
                    + "	inner join Empleado e\n"
                    + "	on e.Empleado_id = ce.Evalua_empleado_id\n"
                    + "where ce.Cuestionario_evalua_id = '" + cuestionario_evalua_id + "'";
            System.out.println(" Lista de personas a que se enviara el correo : " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                String id_ecriptado = encripta.ValorAEncriptar(res.getString("Cuestionario_evalua_id"));
                String html_boton = "<center>\n"
                        + "<div style=\"width:200px\">\n"
                        + "<a href=\"http://200.58.75.218:8080/gth_web/Respuesta/respuesta/index.jsp?iasdfsdfasdf121as2dd1f21sf12d=" + id_ecriptado + "\" style=\"text-decoration:none;color:#ffffff\" target=\"_blank\">\n"
                        + "              <p style=\"background-color:#541686;color:#ffffff;font-family:'Open Sans',Arial,sans-serif;font-size:16px;font-weight:50;line-height:24px;text-decoration:none;text-transform:none;border-radius:4px;margin:0;padding:16px 0\">\n"
                        + "             Haga clic para comenzar.\n"
                        + "              </p></a>\n"
                        + "              </div>\n"
                        + "              </center>";

                View_Envia_Correo_Datos enviar = new View_Envia_Correo_Datos();
                String mensaje_ = res.getString("Mensaje_correo");
                String evaluador_ = res.getString("Evaluador");
                String evaluado_ = res.getString("Evaluado");

                String new_mensaje = mensaje_.replace("--Evaluador--", evaluador_);
                new_mensaje = new_mensaje.replace("--Evaluado--", evaluado_);

                enviar.setCuestionario_evalua_id(res.getInt("Cuestionario_evalua_id"));
                enviar.setEvalua_empleado_id(res.getInt("Evalua_empleado_id"));
                enviar.setA_empleado_id(res.getInt("A_empleado_id"));
                enviar.setEvaluador(res.getString("Evaluador"));
                enviar.setEvaluado(res.getString("Evaluado"));
                enviar.setMensaje_correo(new_mensaje + html_boton);
                enviar.setEmail(res.getString("email"));
                enviar.setCorreo_titulo(res.getString("Titulo_correo"));

                ListaMandarCorreo.add(enviar);

            }

            for (View_Envia_Correo_Datos item : ListaMandarCorreo) {
                Send_MailGmail.send_mailView view = new send_mailView();
                String respuesta = view.Envia_correo_evaluacion(item.getEmail(), item.getMensaje_correo(), item.getCorreo_titulo());
                if (respuesta.equalsIgnoreCase("Ok")) {
                    String sqlActualizaEstado = "UPDATE Cuestioario_evalua \n"
                            + "   SET  Envio_correo = '1',\n"
                            + "		Fecha_envio_correo = CONVERT(date, SYSDATETIME())\n"
                            + " WHERE Cuestionario_evalua_id = '" + item.getCuestionario_evalua_id() + "' ";
                    System.out.println("-- Actualiza correo -- " + item.getEvaluador());
                    db.actualizar(sqlActualizaEstado);
                }
            }
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = ("Modelo.Send_mailModelo.Enviar_emailEvaluacion() " + e.getMessage());
            System.out.println(mensaje);
        }
        return mensaje;
    }

}
