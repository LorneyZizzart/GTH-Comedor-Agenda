package org.apache.jsp.Funcionario.perfil.retro_005falimentacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Login_Entidad;

public final class eliminar_005fretroalimentacion_005fguardar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.FeedbackController _feedback_guarda = null;
      synchronized (_jspx_page_context) {
        _feedback_guarda = (Controlador.FeedbackController) _jspx_page_context.getAttribute("_feedback_guarda", PageContext.PAGE_SCOPE);
        if (_feedback_guarda == null){
          _feedback_guarda = new Controlador.FeedbackController();
          _jspx_page_context.setAttribute("_feedback_guarda", _feedback_guarda, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String id = request.getParameter("id");

    
    Login_Entidad DatoUsuario = new Login_Entidad();
    HttpSession sesion = request.getSession();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    String mensaje = _feedback_guarda.delete_feedback_by_id(Integer.parseInt(id), DatoUsuario.getEmpleado_id());// _feedback_guarda.Create_or_update(retroalimenta);

    if (mensaje.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        setTimeout(\"location.reload()\", 1000);\n");
      out.write("    });\n");
      out.write("</script>\n");

} else {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-danger alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> se produjo un errro: ");
      out.print(mensaje);
      out.write("</h4>\n");
      out.write("</div>\n");

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
