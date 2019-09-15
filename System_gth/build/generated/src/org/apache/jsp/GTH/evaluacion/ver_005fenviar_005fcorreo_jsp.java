package org.apache.jsp.GTH.evaluacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.View_Empleado_Encuesta;
import Entidad.View_Enviar_correo;
import java.util.ArrayList;
import java.util.List;

public final class ver_005fenviar_005fcorreo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Cuestionario_gestionController _ciclo = null;
      synchronized (_jspx_page_context) {
        _ciclo = (Controlador.Cuestionario_gestionController) _jspx_page_context.getAttribute("_ciclo", PageContext.PAGE_SCOPE);
        if (_ciclo == null){
          _ciclo = new Controlador.Cuestionario_gestionController();
          _jspx_page_context.setAttribute("_ciclo", _ciclo, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String id_empleado = request.getParameter("id_emple");
    String id_ciclo = request.getParameter("id_ciclo");

    List<View_Enviar_correo> correos = new ArrayList<View_Enviar_correo>();
    correos = _ciclo.GetAquienEnviaCorreo(Integer.parseInt(id_ciclo), Integer.parseInt(id_empleado));
    //correos = _ciclo.VerAquienEnviaCorreo(Integer.parseInt(id_ciclo), Integer.parseInt(id_empleado));

      out.write("\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(id_empleado);
      out.write("\" id=\"envia_empleado_id\">\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(id_ciclo);
      out.write("\" id=\"envia_ciclo_id\">\n");
      out.write("<table class=\"table table-hover table-striped\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th class=\"text-center\">#</th>\n");
      out.write("            <th>Nombre Cuestionario</th>\n");
      out.write("            <th style=\"width: 5%\">Autoevaluación</th>\n");
      out.write("            <th style=\"width: 19%\">Jefes</th>\n");
      out.write("            <th style=\"width: 19%\">Pares</th>\n");
      out.write("            <th style=\"width: 19%\">Bajos</th>\n");
      out.write("            <th style=\"width: 19%\">Clientes</th>\n");
      out.write("            <th></th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");

            int contador = 0;
            for (View_Enviar_correo item : correos) {
                contador++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(item.getCuestionario_nombre());
      out.write("</td>\n");
      out.write("            <td>");
 if (item.getAuto_evaluacion() != null) {
                
      out.write(' ');
      out.print(item.getAuto_evaluacion().getNombre_empleado());
      out.write(" <br> \n");
      out.write("                ");
      out.print(item.getAuto_evaluacion().getCorreo_electonico());

                    }
                
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                ");

                    for (View_Empleado_Encuesta jef : item.getLista_jefes()) {
                
      out.write("\n");
      out.write("                ");
      out.print(jef.getNombre_empleado());
      out.write(" <br> \n");
      out.write("                ");
      out.print(jef.getCorreo_electonico());
      out.write("\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");

                    for (View_Empleado_Encuesta par : item.getLista_pares()) {
                
      out.write("\n");
      out.write("                ");
      out.print(par.getNombre_empleado());
      out.write(" <br> \n");
      out.write("                ");
      out.print(par.getCorreo_electonico());
      out.write("\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");

                    for (View_Empleado_Encuesta bajo : item.getLista_bajos()) {
                
      out.write("\n");
      out.write("                ");
      out.print(bajo.getNombre_empleado());
      out.write(" <br> \n");
      out.write("                ");
      out.print(bajo.getCorreo_electonico());
      out.write("<br> \n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                ");

                    for (View_Empleado_Encuesta cli : item.getLista_clientes()) {
                
      out.write("\n");
      out.write("                ");
      out.print(cli.getNombre_empleado());
      out.write(" <br> \n");
      out.write("                ");
      out.print(cli.getCorreo_electonico());
      out.write("<br> \n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<div class=\"pull-right\">\n");
      out.write("    <button type=\"button\" class=\"btn btn-purple btn-sm btn-flat btn_enviar_correo\" title=\"Guardar\">Enviar Correo</button>\n");
      out.write("</div>.\n");
      out.write("<div class = \"mensaje_guarda_correo\"></div>\n");
      out.write("<script>\n");
      out.write("    $(\".btn_enviar_correo\").click(function (e) {\n");
      out.write("\n");
      out.write("        var id_empleado = $('#envia_empleado_id').val();\n");
      out.write("        var id_gestion = $('#envia_ciclo_id').val();\n");
      out.write("\n");
      out.write("        $(\".mensaje_guarda_correo\").html(\"\");\n");
      out.write("        $(\".mensaje_guarda_correo\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("        $.post('envia_correo.jsp',\n");
      out.write("                {\n");
      out.write("                    id_gestion: id_gestion,\n");
      out.write("                    id_empleado: id_empleado\n");
      out.write("                },\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".mensaje_guarda_correo\").removeClass('loader');\n");
      out.write("                    $(\".mensaje_guarda_correo\").html(html);\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".mensaje_guarda_correo\").removeClass('loader');\n");
      out.write("            $(\".mensaje_guarda_correo\").html(alerta);\n");
      out.write("        });\n");
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
