package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Evento_participantes;
import java.util.ArrayList;
import java.util.List;
import Entidad.Login_Entidad;
import Entidad.Evento;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class personas_005fno_005fseleccionadas_005fguardar_005funo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Evento_participantesController guardaEventoParti = null;
      synchronized (_jspx_page_context) {
        guardaEventoParti = (Controlador.Evento_participantesController) _jspx_page_context.getAttribute("guardaEventoParti", PageContext.PAGE_SCOPE);
        if (guardaEventoParti == null){
          guardaEventoParti = new Controlador.Evento_participantesController();
          _jspx_page_context.setAttribute("guardaEventoParti", guardaEventoParti, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    HttpSession sesion = request.getSession();
    //out.print(sesion.getAttribute("USUARIO"));
    if (session.getAttribute("USUARIO") == null) {

      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    Termino su sesión, ingrese nuevamente haga clic <a href=\"../../\"> aquí.</a>\n");
      out.write("</div>\n");

} else {
    Login_Entidad DatoUsuario = new Login_Entidad();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    String evento = request.getParameter("id_evento");
    String personas = request.getParameter("personales");

    Evento_participantes par = new Evento_participantes();
    par.setEmpleado_id(Integer.parseInt(personas));
    par.setEvento_id(Integer.parseInt(evento));
    par.setRegistra_personal_id(DatoUsuario.getEmpleado_id());

    String respuesta = guardaEventoParti.AnadirUnParticipantes(par);

    if (respuesta.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    toastr.success(\"Agregado Correctamente.\");\n");
      out.write("    $(\"#tr_");
      out.print(personas);
      out.write("\").remove();\n");
      out.write("</script>\n");

} else {
    //out.print("Se produjo un error :" + respuesta);

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    toastr.error(\"Se produjo un error.\" +");
      out.print(respuesta);
      out.write(");\n");
      out.write("</script>\n");

        }
    }



      out.write('\n');
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
