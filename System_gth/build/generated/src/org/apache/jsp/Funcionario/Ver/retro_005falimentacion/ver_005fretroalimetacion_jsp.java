package org.apache.jsp.Funcionario.Ver.retro_005falimentacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Feedback;

public final class ver_005fretroalimetacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.FeedbackController _feedback_ver = null;
      synchronized (_jspx_page_context) {
        _feedback_ver = (Controlador.FeedbackController) _jspx_page_context.getAttribute("_feedback_ver", PageContext.PAGE_SCOPE);
        if (_feedback_ver == null){
          _feedback_ver = new Controlador.FeedbackController();
          _jspx_page_context.setAttribute("_feedback_ver", _feedback_ver, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    String id_nota = request.getParameter("id");
    Feedback datos = new Feedback();
    datos = _feedback_ver.Get_feedback_by_id(Integer.parseInt(id_nota));

      out.write("\n");
      out.write("<div class=\"box-body\">\n");
      out.write("    <dl class=\"dl-horizontal\">\n");
      out.write("        <dt>Tipo Advertencia: </dt>\n");
      out.write("        <dd>");
      out.print(datos.getFeedback_tipo_nombre());
      out.write(".</dd>\n");
      out.write("        <dt>Motivo: </dt>        \n");
      out.write("        <dd>");
      out.print(datos.getMotivo());
      out.write(".</dd>\n");
      out.write("        <dt>Fecha:</dt>\n");
      out.write("        <dd>");
      out.print(datos.getFecha_advertencia());
      out.write(".</dd>\n");
      out.write("        <dt>Descripción</dt>\n");
      out.write("        <dd>");
      out.print(datos.getDescripcion());
      out.write("\n");
      out.write("        </dd>\n");
      out.write("    </dl>\n");
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
