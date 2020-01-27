package org.apache.jsp.GTH.evaluacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cliente;
import Entidad.View_Empleado_Encuesta;
import Entidad.Cuestionario;
import java.util.ArrayList;
import java.util.List;

public final class muestra_005flista_005fevaluacion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      Controlador.Cuestionario_gestionController _cuestionario_gestion = null;
      synchronized (_jspx_page_context) {
        _cuestionario_gestion = (Controlador.Cuestionario_gestionController) _jspx_page_context.getAttribute("_cuestionario_gestion", PageContext.PAGE_SCOPE);
        if (_cuestionario_gestion == null){
          _cuestionario_gestion = new Controlador.Cuestionario_gestionController();
          _jspx_page_context.setAttribute("_cuestionario_gestion", _cuestionario_gestion, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');


    String gestion_id = request.getParameter("id_ciclo");
    String persona_id = request.getParameter("id_emple");

    List<View_Empleado_Encuesta> cuestionarios = new ArrayList<View_Empleado_Encuesta>();
    cuestionarios = _cuestionario_gestion.GetCuestionarioByGestionEmpleado(Integer.parseInt(gestion_id), Integer.parseInt(persona_id));

    if (cuestionarios.size() == 0) {
        out.print("No tiene evaluacion asignada");
    } else {

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"table-responsive mailbox-messages table-responsive\">\n");
      out.write("    <table class=\"table table-hover table-striped\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th class=\"text-center\">#</th>\n");
      out.write("                <th>Nombre</th>\n");
      out.write("                <th style=\"width: 5%\">Autoevaluación</th>\n");
      out.write("                <th style=\"width: 18%\">Jefes</th>\n");
      out.write("                <th style=\"width: 18%\">Pares</th>\n");
      out.write("                <th style=\"width: 18%\">Bajos</th>\n");
      out.write("                <th style=\"width: 18%\">Clientes</th>\n");
      out.write("                <th></th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                int contador = 0;
                for (View_Empleado_Encuesta item : cuestionarios) {
                    contador++;
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(contador);
      out.write(" \n");
      out.write("                    <input type=\"hidden\" id=\"save_empleado_id_");
      out.print(contador);
      out.write("\" name=\"save_empleado_id_");
      out.print(contador);
      out.write("\" value=\"");
      out.print(item.getEmpleado_id());
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" id=\"save_cuestionario_id_");
      out.print(contador);
      out.write("\" name=\"save_cuestionario_id_");
      out.print(contador);
      out.write("\" value=\"");
      out.print(item.getCuestionario_id());
      out.write("\">\n");
      out.write("                </td>\n");
      out.write("                <td>");
      out.print(item.getCuestionario_Nombre());
      out.write("</td>\n");
      out.write("                <td class=\"text-center\">\n");
      out.write("                    ");

                        String checked = "";
                        if (item.getAuto_evaluacion().equalsIgnoreCase("Ok")) {
                            checked = " checked";
                        }
      out.write("\n");
      out.write("                    <input class=\"autoEvaluacion-");
      out.print(contador);
      out.write("\" name=\"autoEvaluacion-");
      out.print(contador);
      out.write("\" id=\"autoEvaluacion-");
      out.print(contador);
      out.write("\" type=\"checkbox\" ");
      out.print(checked);
      out.write(" >\n");
      out.write("                </td>\n");
      out.write("                <td class=\"mailbox-subject\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <select name=\"idJefe-");
      out.print(contador);
      out.write("\" id=\"idJefe-");
      out.print(contador);
      out.write("\"  class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">     \n");
      out.write("                            ");

                                for (View_Empleado_Encuesta j : item.getJefes()) {
                                    String selected_ = "";
                                    for (View_Empleado_Encuesta sj : item.getSelect_Jefes()) {
                                        if (j.getEmpleado_id() == sj.getEmpleado_id()) {
                                            selected_ = "selected";
                                        }
                                    }
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(j.getEmpleado_id());
      out.write('"');
      out.write(' ');
      out.print(selected_);
      out.write('>');
      out.print(j.getNombre_empleado());
      out.write("</option>                            \n");
      out.write("                            ");

                                }
                            
      out.write("                                                      \n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("                <td class=\"mailbox-subject\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <select name=\"idPares-");
      out.print(contador);
      out.write("\" id=\"idPares-");
      out.print(contador);
      out.write("\"  class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">       \n");
      out.write("                            ");

                                for (View_Empleado_Encuesta j : item.getPares()) {
                                    String selected_ = "";
                                    for (View_Empleado_Encuesta p : item.getSelect_Pares()) {
                                        if (j.getEmpleado_id() == p.getEmpleado_id()) {
                                            selected_ = "selected";
                                        }
                                    }
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(j.getEmpleado_id());
      out.write('"');
      out.write(' ');
      out.print(selected_);
      out.write('>');
      out.print(j.getNombre_empleado());
      out.write("</option>                            \n");
      out.write("                            ");

                                }
                            
      out.write("     \n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("                <td class=\"mailbox-subject\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <select name=\"idBajos-");
      out.print(contador);
      out.write("\" id=\"idBajos-");
      out.print(contador);
      out.write("\"  class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">                           \n");
      out.write("                            ");

                                for (View_Empleado_Encuesta j : item.getBajos()) {
                                    String selected_ = "";
                                    for (View_Empleado_Encuesta p : item.getSelect_Bajos()) {
                                        if (j.getEmpleado_id() == p.getEmpleado_id()) {
                                            selected_ = "selected";
                                        }
                                    }
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(j.getEmpleado_id());
      out.write('"');
      out.write(' ');
      out.print(selected_);
      out.write('>');
      out.print(j.getNombre_empleado());
      out.write("</option>                            \n");
      out.write("                            ");

                                }
                            
      out.write("                            \n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("                <td class=\"mailbox-subject\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <select name=\"idClientes-");
      out.print(contador);
      out.write("\" id=\"idClientes-");
      out.print(contador);
      out.write("\"  class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">                           \n");
      out.write("                            ");

                                for (Cliente j : item.getClientes()) {
                                    String selected_ = "";
                                    for (Cliente p : item.getSelect_Clientes()) {
                                        String select_cliente=p.getCliente_id()+"-"+p.getTelefono();
                                        String list_cliente = j.getCliente_id()+"-"+j.getTelefono();
                                        //if (j.getCliente_id() == p.getCliente_id()) {
                                        if (select_cliente.equalsIgnoreCase(list_cliente)) {
                                            selected_ = "selected";
                                        }
                                    }
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(j.getCliente_id());
      out.write('-');
      out.print(j.getTelefono());
      out.write('"');
      out.write(' ');
      out.print(selected_);
      out.write('>');
      out.print(j.getNombre());
      out.write("</option>                            \n");
      out.write("                            ");

                                }
                            
      out.write("                 \n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("                <td> \n");
      out.write("\n");
      out.write("                    ");
 if (item.getVerifica_correo() == 0) {
      out.write("\n");
      out.write("                    <button type=\"button\" class=\"btn btn-purple pull-right btn-save-evaluator\" data-posicion=\"");
      out.print(contador);
      out.write("\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    <div class=\"mensaje_save_evaluadores\"></div>\n");
      out.write("</div>\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $(\".btn-save-evaluator\").on(\"click\", function () {\n");
      out.write("        var posicion = $(this).attr(\"data-posicion\");\n");
      out.write("        //alert(posicion);\n");
      out.write("\n");
      out.write("        var autoevaluacion = '';\n");
      out.write("        if ($('#autoEvaluacion-' + posicion).is(':checked')) {\n");
      out.write("            // Hacer algo si el checkbox ha sido seleccionado\n");
      out.write("            autoevaluacion = 'Ok';\n");
      out.write("        } else {\n");
      out.write("            // Hacer algo si el checkbox ha sido deseleccionado\n");
      out.write("            autoevaluacion = 'No';\n");
      out.write("        }\n");
      out.write("        //alert(\" Auto eva : \" + autoevaluacion);\n");
      out.write("\n");
      out.write("        var id_ciclo_gestion = $('#id_ciclo_gestion').val();\n");
      out.write("        //alert(\"gestion Id : \" + id_ciclo_gestion);\n");
      out.write("\n");
      out.write("        var id_empleado = $('#save_empleado_id_' + posicion).val();\n");
      out.write("        //alert(\"Empleado Id : \" + id_empleado);\n");
      out.write("\n");
      out.write("        var id_cuestionario = $('#save_cuestionario_id_' + posicion).val();\n");
      out.write("        //alert(\"Cuestionario Id : \" + id_cuestionario);\n");
      out.write("\n");
      out.write("        var jefes_posicion = 'idJefe-' + posicion;\n");
      out.write("        var jefes = ($('select[id=' + jefes_posicion + ']').val());\n");
      out.write("        //alert(\"Jefes : \" + jefes);\n");
      out.write("\n");
      out.write("        var pares_posicion = 'idPares-' + posicion;\n");
      out.write("        var pares = ($('select[id=' + pares_posicion + ']').val());\n");
      out.write("        //alert(\"Pares : \" + pares);\n");
      out.write("\n");
      out.write("        var bajos_posicion = 'idBajos-' + posicion;\n");
      out.write("        var bajos = ($('select[id=' + bajos_posicion + ']').val());\n");
      out.write("        //alert(\"Bajos : \" + bajos);\n");
      out.write("\n");
      out.write("        var clientes_posicion = 'idClientes-' + posicion;\n");
      out.write("        var clientes = ($('select[id=' + clientes_posicion + ']').val());\n");
      out.write("        //alert(\"clientes : \" + clientes);\n");
      out.write("\n");
      out.write("        //$(\".mensaje_save_evaluadores\").html('');\n");
      out.write("        //$(\".mensaje_save_evaluadores\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('guardar_evaluadores.jsp',\n");
      out.write("                {id_ciclo_gestion: id_ciclo_gestion,\n");
      out.write("                    id_empleado: id_empleado,\n");
      out.write("                    id_cuestionario: id_cuestionario,\n");
      out.write("                    autoevaluacion: autoevaluacion,\n");
      out.write("                    jefes: jefes,\n");
      out.write("                    pares: pares,\n");
      out.write("                    bajos: bajos,\n");
      out.write("                    clientes: clientes\n");
      out.write("                },\n");
      out.write("                function (html) {\n");
      out.write("                    // $(\".mensaje_save_evaluadores\").removeClass('loader');\n");
      out.write("                    // $(\".mensaje_save_evaluadores\").html(html);\n");
      out.write("                    if (html.trim() == \"Ok\") {\n");
      out.write("                        toastr.success(\"Guardado Correctamente.\");\n");
      out.write("                    } else {\n");
      out.write("                        toastr.error(\"Se produjo un error.\" + html);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".mensaje_save_evaluadores\").removeClass('loader');\n");
      out.write("            $(\".mensaje_save_evaluadores\").html(alerta);\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("</script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
