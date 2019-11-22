package org.apache.jsp.GTH.evaluacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ver_005fseguimiento_005fenvia_005fcorreo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.Send_mailController _send_mail_uno = null;
      synchronized (_jspx_page_context) {
        _send_mail_uno = (Controlador.Send_mailController) _jspx_page_context.getAttribute("_send_mail_uno", PageContext.PAGE_SCOPE);
        if (_send_mail_uno == null){
          _send_mail_uno = new Controlador.Send_mailController();
          _jspx_page_context.setAttribute("_send_mail_uno", _send_mail_uno, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String ciclo_id = request.getParameter("ciclo_id");
    String emple_evaluar = request.getParameter("emple_evaluar");
    String evaluador = request.getParameter("evaluador");
    String grupo = request.getParameter("grupo");

    out.print("Ciclo = " + ciclo_id + " evaluar a:" + emple_evaluar + "  evaluador:" + evaluador + " grupo:" + grupo);
    String mensaje = _send_mail_uno.Enviar_Un_email_a_evaluador(Integer.parseInt(ciclo_id), Integer.parseInt(emple_evaluar), Integer.parseInt(evaluador), grupo);

    if (mensaje.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<script>\n");
      out.write("    toastr.success(\"Correo enviado correctamente.\");\n");
      out.write("</script>\n");

} else {

      out.write("\n");
      out.write("<script>\n");
      out.write("    toastr.error(\"Se produjo un error.\" + ");
      out.print(mensaje);
      out.write(");\n");
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
