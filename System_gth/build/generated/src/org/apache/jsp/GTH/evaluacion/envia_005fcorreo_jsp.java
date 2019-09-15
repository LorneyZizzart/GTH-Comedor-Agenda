package org.apache.jsp.GTH.evaluacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class envia_005fcorreo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.Send_mailController _send_mail = null;
      synchronized (_jspx_page_context) {
        _send_mail = (Controlador.Send_mailController) _jspx_page_context.getAttribute("_send_mail", PageContext.PAGE_SCOPE);
        if (_send_mail == null){
          _send_mail = new Controlador.Send_mailController();
          _jspx_page_context.setAttribute("_send_mail", _send_mail, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String gestion_id = request.getParameter("id_gestion");
    String empleado_id = request.getParameter("id_empleado");

    out.print("Gestion " + gestion_id + " Empleado " + empleado_id);
    String mensaje = _send_mail.Enviar_emailEvaluacion(Integer.parseInt(gestion_id), Integer.parseInt(empleado_id));
    if (mensaje.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\"alert alert-success\" role=\"alert\"> <strong>Ok!</strong> Enviado correctamente. </div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".mensaje_guarda_correo\").hide(2000, function () {\n");
      out.write("            location.reload();\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");

} else {

      out.write("\n");
      out.write("<div class=\"alert alert-danger\" role=\"alert\"> <strong>Se produjo un error!</strong> ");
      out.print(mensaje);
      out.write(". </div>\n");

    }

      out.write('\n');
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
