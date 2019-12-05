package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import Entidad.Login_Entidad;
import Entidad.Evento_Actividad;

public final class actividad_005fcrear_005fguardar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Evento_ActividadController guardaActividad = null;
      synchronized (_jspx_page_context) {
        guardaActividad = (Controlador.Evento_ActividadController) _jspx_page_context.getAttribute("guardaActividad", PageContext.PAGE_SCOPE);
        if (guardaActividad == null){
          guardaActividad = new Controlador.Evento_ActividadController();
          _jspx_page_context.setAttribute("guardaActividad", guardaActividad, PageContext.PAGE_SCOPE);
        }
      }
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
      out.write('\n');

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

    String evento_id = _encript.ValorADesencriptar(request.getParameter("evento_id"));
    String actividad_nombre = request.getParameter("actividad_nombre");
    String actividad_inicio_fecha = request.getParameter("actividad_inicio_fecha");
    String actividad_inicio_hora = request.getParameter("actividad_inicio_hora");
    String actividad_fin_fecha = request.getParameter("actividad_fin_fecha");
    String actividad_fin_hora = request.getParameter("actividad_fin_hora");
    String actividad_detalle = request.getParameter("actividad_detalle");
    String actividad_id = request.getParameter("actividad_id");
    Evento_Actividad evento = new Evento_Actividad();

    try {
        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(actividad_inicio_fecha);
        Date fin = new SimpleDateFormat("dd/MM/yyyy").parse(actividad_fin_fecha);
        if (fin.before(inicio)) {



      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>    \n");
      out.write("    Fecha  Inicio de la actividad tiene que ser mayor o igual a la fecha de finalización.\n");
      out.write("</div>\n");
} else {

    Evento_Actividad ac = new Evento_Actividad();
    ac.setNombre_actividad(actividad_nombre);
    ac.setEmpleado_id(DatoUsuario.getEmpleado_id());
    ac.setDescripcion(actividad_detalle);
    ac.setFecha_inicio_actividad(actividad_inicio_fecha + " " + actividad_inicio_hora);
    ac.setFecha_fin_actividad(actividad_fin_fecha + " " + actividad_fin_hora);
    ac.setEvento_id(Integer.parseInt(evento_id));
    ac.setEvento_Actividad_id(Integer.parseInt(actividad_id));

    String respuesta = guardaActividad.CreateorUpdateEventoActividad(ac);
    if (respuesta.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#mensaje\").hide(2000, function () {\n");
      out.write("            location.reload();\n");
      out.write("        });\n");
      out.write("        $(\"form\")[0].reset();\n");
      out.write("    });\n");
      out.write("</script>\n");

} else {
    //out.print("Se produjo un error :" + respuesta);

      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    ");
      out.print(respuesta);
      out.write("\n");
      out.write("</div>\n");

        }
    }
} catch (Exception e) {

    // out.print("Se produjo un error " + e.getMessage());

      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    ");
      out.print(e.getMessage());
      out.write("\n");
      out.write("</div>\n");

        }
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
