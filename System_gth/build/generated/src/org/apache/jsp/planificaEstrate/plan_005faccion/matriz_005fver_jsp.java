package org.apache.jsp.planificaEstrate.plan_005faccion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Plan_matriz;

public final class matriz_005fver_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Plan_matrizController matriz_ver = null;
      synchronized (_jspx_page_context) {
        matriz_ver = (Controlador.Plan_matrizController) _jspx_page_context.getAttribute("matriz_ver", PageContext.PAGE_SCOPE);
        if (matriz_ver == null){
          matriz_ver = new Controlador.Plan_matrizController();
          _jspx_page_context.setAttribute("matriz_ver", matriz_ver, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String plan_accion_id = request.getParameter("id_pla_ac").replace(" ", "+");
    plan_accion_id = _encript.ValorADesencriptar(plan_accion_id);
    String Plan_matriz_id = "0";

    Plan_matriz matriz = new Plan_matriz();
    matriz = matriz_ver.getMatrizByPlanAccionId(Integer.parseInt(plan_accion_id));
    if (matriz != null) {
        Plan_matriz_id = Integer.toString(matriz.getPlan_matriz_id());
    }

      out.write("\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("    <!-- Main content -->\n");
      out.write("    <section class=\"invoice\">\n");
      out.write("        <!-- title row -->\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-12\">\n");
      out.write("                <h2 class=\"page-header\">\n");
      out.write("                    <i class=\"fa fa-line-chart\"></i> Matriz Documento Historia\n");
      out.write("                    <!--<small class=\"pull-right\">Date: 2/10/2014</small>-->\n");
      out.write("                </h2>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.col -->\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row invoice-info\">\n");
      out.write("            <div class=\"col-sm-12 invoice-col\">\n");
      out.write("\n");
      out.write("                <strong>Que hacer: </strong><br>\n");
      out.write("                <p>");
if (matriz != null) {
                        out.print(matriz.getQue_hacer());
                    }
      out.write("                 \n");
      out.write("                </p>\n");
      out.write("                <strong>Responsable: </strong><br>\n");
      out.write("                <p>");
if (matriz != null) {
                        out.print(matriz.getResponsable());
                    }
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <strong>Como: </strong><br>\n");
      out.write("                <p>");
if (matriz != null) {
                        out.print(matriz.getComo());
                    }
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <strong>Documento generado: </strong><br>\n");
      out.write("                <p>");
if (matriz != null) {
                        out.print(matriz.getDocumento_generadi());
                    }
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <strong>Indicador de Resultado: </strong><br>\n");
      out.write("                <strong>Nombre: </strong><br>\n");
      out.write("                <p>");
if (matriz != null) {
                        out.print(matriz.getIndicadores_resultado());
                    }
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <strong>Fecha: </strong><br>\n");
      out.write("                <p>");
if (matriz != null) {
                        out.print(matriz.getFecha());
                    }
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <strong>Indicador: </strong><br>\n");
      out.write("                <p>");
if (matriz != null) {
                        out.print(matriz.getIndicador());
                    }
      out.write("\n");
      out.write("                </p>\n");
      out.write("            </div>      \n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
