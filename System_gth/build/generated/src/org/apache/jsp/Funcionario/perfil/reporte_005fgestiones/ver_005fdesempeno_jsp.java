package org.apache.jsp.Funcionario.perfil.reporte_005fgestiones;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cuestionario_gestion;
import java.util.ArrayList;
import java.util.List;

public final class ver_005fdesempeno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Cuestionario_gestionController _cuestionario_gestion = null;
      synchronized (_jspx_page_context) {
        _cuestionario_gestion = (Controlador.Cuestionario_gestionController) _jspx_page_context.getAttribute("_cuestionario_gestion", PageContext.PAGE_SCOPE);
        if (_cuestionario_gestion == null){
          _cuestionario_gestion = new Controlador.Cuestionario_gestionController();
          _jspx_page_context.setAttribute("_cuestionario_gestion", _cuestionario_gestion, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<Cuestionario_gestion> gestiones = new ArrayList<Cuestionario_gestion>();
    gestiones = _cuestionario_gestion.GetAllCuestionario_gestion();

      out.write("\n");
      out.write("\n");
      out.write("<center>\n");
      out.write("    <select class=\"form-control select_ciclo\" style=\"width: 160px\">\n");
      out.write("        <option value=\"0\">Selecione Ciclo</option>\n");
      out.write("        ");

            for (Cuestionario_gestion g : gestiones) {
        
      out.write("\n");
      out.write("        <option value=\"");
      out.print(g.getCuestionario_gestion_id());
      out.write('"');
      out.write('>');
      out.print(g.getNombre());
      out.write("</option>\n");
      out.write("        ");

            }
        
      out.write("                    \n");
      out.write("    </select>\n");
      out.write("</center>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<div id=\"funcnionario_rep_desempeno\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(\".select_ciclo\").change(function () {\n");
      out.write("        var select_getion = $(this).val();\n");
      out.write("        var emple_id = $('#idEmpleado_id').val();\n");
      out.write("        if (select_getion > 0) {\n");
      out.write("            $(\"#funcnionario_rep_desempeno\").html(\"\");\n");
      out.write("            $(\"#funcnionario_rep_desempeno\").addClass(\"loader\");\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"reporte_gestiones/reporte_gestion.jsp\",\n");
      out.write("                data: {gestion_id: select_getion,\n");
      out.write("                    empleado_id: emple_id},\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#funcnionario_rep_desempeno\").removeClass(\"loader\");\n");
      out.write("                    $(\"#funcnionario_rep_desempeno\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#funcnionario_rep_desempeno\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#funcnionario_rep_desempeno\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
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
