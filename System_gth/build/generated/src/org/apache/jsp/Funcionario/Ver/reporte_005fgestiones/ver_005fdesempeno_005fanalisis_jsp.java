package org.apache.jsp.Funcionario.Ver.reporte_005fgestiones;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import Entidad.Pregunta;
import java.util.ArrayList;
import java.util.List;
import Entidad.Cuestionario;

public final class ver_005fdesempeno_005fanalisis_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Reporte_evaluacionesController _reporte_ciclo_cuestionario = null;
      synchronized (_jspx_page_context) {
        _reporte_ciclo_cuestionario = (Controlador.Reporte_evaluacionesController) _jspx_page_context.getAttribute("_reporte_ciclo_cuestionario", PageContext.PAGE_SCOPE);
        if (_reporte_ciclo_cuestionario == null){
          _reporte_ciclo_cuestionario = new Controlador.Reporte_evaluacionesController();
          _jspx_page_context.setAttribute("_reporte_ciclo_cuestionario", _reporte_ciclo_cuestionario, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    String id_cuestionario = request.getParameter("id_cuestionario");
    String des_gestion = request.getParameter("des_gestion");
    String des_emple_id = request.getParameter("des_emple_id");

    Cuestionario cuestionario = new Cuestionario();

    cuestionario = _reporte_ciclo_cuestionario.GetCuestionario_Empleado_by_cuestionario_id(Integer.parseInt(id_cuestionario), Integer.parseInt(des_gestion), Integer.parseInt(des_emple_id));

    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
    separadoresPersonalizados.setDecimalSeparator('.');

    DecimalFormat formato_personalizado = new DecimalFormat("#.00", separadoresPersonalizados);

      out.write("\n");
      out.write("\n");
      out.write("<section class=\"invoice lista_preguntas\">\n");
      out.write("    <!-- title row -->\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12\">\n");
      out.write("            <h2 class=\"page-header\">\n");
      out.write("                <i class=\"fa fa-file-text-o\"></i> ");
      out.print(cuestionario.getNombre());
      out.write("                \n");
      out.write("            </h2>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Table row -->\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12 table-responsive\">\n");
      out.write("            <table class=\"table table-striped\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>#</th>\n");
      out.write("                        <th>Pregunta </th>\n");
      out.write("                        <th style=\"width: 250px\" >Análisis</th>\n");
      out.write("                        <th>Promedio</th>    \n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        int contapregunta = 0;
                        List<Pregunta> Preguntas = new ArrayList<Pregunta>();
                        Preguntas = cuestionario.getPreguntas();
                        for (Pregunta item : Preguntas) {
                            contapregunta++;
                            float promedio = item.getPromedio() * 10;
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(contapregunta);
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(item.getNombre());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"progress progress-xs\">\n");
      out.write("                                <div class=\"progress-bar progress-bar-danger\" style=\"width: ");
      out.print(promedio);
      out.write("%;background-color: #");
      out.print(item.getColor_pintar());
      out.write("!important\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
//=item.getPromedio()
      out.write("\n");
      out.write("                            <span class=\"badge bg-red\" style=\"width: 90px; background-color: #");
      out.print(item.getColor_pintar());
      out.write("!important\">");
      out.print((formato_personalizado.format(item.getPromedio())));
      out.write(' ');
      out.print(item.getDesempeno());
      out.write("</span>\n");
      out.write("                        </td>                        \n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.row -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- this row will not appear when printing -->\n");
      out.write("    <div class=\"row no-print\">\n");
      out.write("        <div class=\"col-xs-12\">\n");
      out.write("            <button class=\"btn btn-default close_preguntas\"><i class=\"fa fa-close\"></i> Cerrar</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(\".close_preguntas\").on(\"click\", function () {\n");
      out.write("        $(\".lista_preguntas\").hide(2000, function () {\n");
      out.write("\n");
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
