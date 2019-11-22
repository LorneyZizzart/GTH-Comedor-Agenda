package org.apache.jsp.GTH.evaluacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.View_Empleado_Encuesta;
import Entidad.View_Enviar_correo;
import java.util.ArrayList;
import java.util.List;

public final class ver_005fseguimiento_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    for (View_Enviar_correo correo : correos) {

      out.write("\n");
      out.write("<h3>");
      out.print(correo.getCuestionario_nombre());
      out.write("</h3>\n");
      out.write("\n");
      out.write("<table class=\"table table-responsive\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>#</th>\n");
      out.write("            <th>Nombre</th>\n");
      out.write("            <th>Evaluo</th>\n");
      out.write("            <th>Enviar correo</th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");

            int contador = 0;
            if (correo.getAuto_evaluacion() != null) {
                contador++;
                View_Empleado_Encuesta auto = correo.getAuto_evaluacion();
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(auto.getNombre_empleado());
      out.write("</td>\n");
      out.write("            <td>");
 if (auto.getLleno_cuestionario() == 0) {
      out.write("<p class=\"text-danger\">NO</p>");
} else {
      out.write("<p class=\"text-success\">SI</p>");
}
      out.write("</td>\n");
      out.write("            <td><button type=\"button\" class=\"btn btn-purple btn_un_correo\" data-id=\"");
      out.print(auto.getEmpleado_id());
      out.write("\" data-grupo=\"Autoevaluacion\">Enviar correo</button></td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
            for (View_Empleado_Encuesta jef : correo.getLista_jefes()) {
                contador++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(contador);
      out.write(" - ");
      out.print(jef.getLleno_cuestionario());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(jef.getNombre_empleado());
      out.write("</td>\n");
      out.write("            <td>");
 if (jef.getLleno_cuestionario() == 0) {
      out.write("<p class=\"text-danger\">NO</p>");
} else {
      out.write("<p class=\"text-success\">SI</p>");
}
      out.write("</td>\n");
      out.write("            <td><button type=\"button\" class=\"btn btn-purple btn_un_correo\" data-id=\"");
      out.print(jef.getEmpleado_id());
      out.write("\" data-grupo=\"Jefe\">Enviar correo</button></td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
            for (View_Empleado_Encuesta par : correo.getLista_pares()) {
                contador++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(contador);
      out.write(" - ");
      out.print(par.getLleno_cuestionario());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(par.getNombre_empleado());
      out.write("</td>\n");
      out.write("            <td>");
 if (par.getLleno_cuestionario() == 0) {
      out.write("<p class=\"text-danger\">NO</p>");
} else {
      out.write("<p class=\"text-success\">SI</p>");
}
      out.write("</td>\n");
      out.write("            <td><button type=\"button\" class=\"btn btn-purple btn_un_correo\" data-id=\"");
      out.print(par.getEmpleado_id());
      out.write("\" data-grupo=\"Par\">Enviar correo</button></td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
            for (View_Empleado_Encuesta bajo : correo.getLista_bajos()) {
                contador++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(bajo.getNombre_empleado());
      out.write("</td>\n");
      out.write("            <td>");
 if (bajo.getLleno_cuestionario() == 0) {
      out.write("<p class=\"text-danger\">NO</p>");
} else {
      out.write("<p class=\"text-success\">SI</p>");
}
      out.write("</td>\n");
      out.write("            <td><button type=\"button\" class=\"btn btn-purple btn_un_correo\" data-id=\"");
      out.print(bajo.getEmpleado_id());
      out.write("\" data-grupo=\"Bajo\">Enviar correo</button></td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
            for (View_Empleado_Encuesta cli : correo.getLista_clientes()) {
                contador++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(cli.getNombre_empleado());
      out.write("</td>\n");
      out.write("            <td>");
 if (cli.getLleno_cuestionario() == 0) {
      out.write("<p class=\"text-danger\">NO</p>");
} else {
      out.write("<p class=\"text-success\">SI</p>");
}
      out.write("</td>\n");
      out.write("            <td><button type=\"button\" class=\"btn btn-purple btn_un_correo\" data-id=\"");
      out.print(cli.getEmpleado_id());
      out.write("\" data-grupo=\"Cliente\">Enviar correo</button></td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("<div class=\"envia_correo_uno\"></div>\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(\".btn_un_correo\").click(function (e) {\n");
      out.write("        var ciclo_id = ");
      out.print(id_ciclo);
      out.write(";\n");
      out.write("        var emple_evaluar = ");
      out.print(id_empleado);
      out.write(";\n");
      out.write("        var evaluador = $(this).attr(\"data-id\");\n");
      out.write("        var grupo = $(this).attr(\"data-grupo\");\n");
      out.write("        //alert(\" Ciclo id = \" + ciclo_id + \"  evaluar = \" + emple_evaluar + \"  evaluador = \" + evaluador + \"  Grupo :\" + grupo);\n");
      out.write("\n");
      out.write("        $(\".envia_correo_uno\").html(\"\");\n");
      out.write("        $(\".envia_correo_uno\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("        $.post('ver_seguimiento_envia_correo.jsp',\n");
      out.write("                {\n");
      out.write("                    ciclo_id: ciclo_id,\n");
      out.write("                    emple_evaluar: emple_evaluar,\n");
      out.write("                    evaluador: evaluador,\n");
      out.write("                    grupo: grupo\n");
      out.write("                },\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".envia_correo_uno\").removeClass('loader');\n");
      out.write("                    $(\".envia_correo_uno\").html(html);\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".envia_correo_uno\").removeClass('loader');\n");
      out.write("            $(\".envia_correo_uno\").html(alerta);\n");
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
