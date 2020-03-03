package org.apache.jsp.Evaluacion.importauab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Uni_acad_pre;
import java.util.ArrayList;
import java.util.List;

public final class preguntas_005fver_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Uni_acad_preController preguntasController = null;
      synchronized (_jspx_page_context) {
        preguntasController = (Controlador.Uni_acad_preController) _jspx_page_context.getAttribute("preguntasController", PageContext.PAGE_SCOPE);
        if (preguntasController == null){
          preguntasController = new Controlador.Uni_acad_preController();
          _jspx_page_context.setAttribute("preguntasController", preguntasController, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String area_preguntas = request.getParameter("area");
    //out.print(area_preguntas);
    List<Uni_acad_pre> preguntas = new ArrayList<Uni_acad_pre>();
    preguntas = preguntasController.getPreguntasByArea(area_preguntas);

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"table-responsive\">\n");
      out.write("    <table class=\"table\">\n");
      out.write("        <tbody>\n");
      out.write("            ");

                for (Uni_acad_pre p : preguntas) {
            
      out.write("\n");
      out.write("            <tr>                \n");
      out.write("                <td>");
      out.print(p.getPregunta());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>");
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
