package org.apache.jsp.Evaluacion.importauab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class importa_005fevaluacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.Uni_acad_preController preguntasImport = null;
      synchronized (_jspx_page_context) {
        preguntasImport = (Controlador.Uni_acad_preController) _jspx_page_context.getAttribute("preguntasImport", PageContext.PAGE_SCOPE);
        if (preguntasImport == null){
          preguntasImport = new Controlador.Uni_acad_preController();
          _jspx_page_context.setAttribute("preguntasImport", preguntasImport, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String docente_id = request.getParameter("docente_id");
    String cod_uab = request.getParameter("cod_uab");
    String area_id = request.getParameter("area_id");

    String gestion = request.getParameter("gestion");

    //out.print("codigo UAB:" + cod_uab + " docente: " + docente_id + " area: " + area_id + " gestion:" + gestion);
    String resultado = preguntasImport.ImportaNotaSisAcad(cod_uab, docente_id, area_id, gestion);
    if (resultado.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<script>\n");
      out.write("    location.reload();\n");
      out.write("</script>\n");

    }

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
