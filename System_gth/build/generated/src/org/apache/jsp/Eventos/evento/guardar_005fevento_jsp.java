package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Login_Entidad;
import Entidad.Evento;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class guardar_005fevento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EventoController guardaEvento = null;
      synchronized (_jspx_page_context) {
        guardaEvento = (Controlador.EventoController) _jspx_page_context.getAttribute("guardaEvento", PageContext.PAGE_SCOPE);
        if (guardaEvento == null){
          guardaEvento = new Controlador.EventoController();
          _jspx_page_context.setAttribute("guardaEvento", guardaEvento, PageContext.PAGE_SCOPE);
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

    String e_nombre = request.getParameter("evento_nombre");
    String e_fecha_inicio = request.getParameter("evento_inicio");
    String e_fecha_fin = request.getParameter("evento_fin");
    String e_detalle = request.getParameter("evento_detalle");
    int e_evento_di = Integer.parseInt(request.getParameter("evento_id"));

    try {
        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(e_fecha_inicio);
        Date fin = new SimpleDateFormat("dd/MM/yyyy").parse(e_fecha_fin);
        if (fin.before(inicio)) {



      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>    \n");
      out.write("    Fecha  Inicio del evento tiene que ser mayor o igual a la fecha de finalización.\n");
      out.write("</div>\n");
} else {

    Evento e = new Evento();
    e.setEvento_id(e_evento_di);
    e.setNombre_evento(e_nombre);
    e.setEmpleado_id(DatoUsuario.getEmpleado_id());
    e.setFecha_inicio(e_fecha_inicio);
    e.setFecha_fin(e_fecha_fin);
    e.setDetalle(e_detalle);
    String respuesta = guardaEvento.InsertOrUpdate(e);
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
