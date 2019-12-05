package org.apache.jsp.planificaEstrate.planificacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Login_Entidad;
import Entidad.Plan_objetivo;

public final class plan_005festrate_005fguardar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Plan_objetivoController guardaPlan = null;
      synchronized (_jspx_page_context) {
        guardaPlan = (Controlador.Plan_objetivoController) _jspx_page_context.getAttribute("guardaPlan", PageContext.PAGE_SCOPE);
        if (guardaPlan == null){
          guardaPlan = new Controlador.Plan_objetivoController();
          _jspx_page_context.setAttribute("guardaPlan", guardaPlan, PageContext.PAGE_SCOPE);
        }
      }
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

    String plan_id = request.getParameter("plan_id");
    String plan_titulo = request.getParameter("plan_titulo");
    String plan_creditacion = request.getParameter("plan_creditacion");
    String plan_gestion = request.getParameter("plan_gestion");
    String plan_estado = request.getParameter("plan_estado");
    int emplado_id = DatoUsuario.getEmpleado_id();

    Plan_objetivo plan = new Plan_objetivo();
    plan.setPlan_objetivo_id(Integer.parseInt(plan_id));
    plan.setTitulo(plan_titulo);
    plan.setCreditacion(plan_creditacion);
    plan.setGestion(Integer.parseInt(plan_gestion));
    plan.setEstado(Integer.parseInt(plan_estado));
    plan.setEmpleado_id(emplado_id);

    String mensajereturn = guardaPlan.SaveorUpdateObjetivo(plan);
    String[] parts = mensajereturn.split("##");
    String mensaje = parts[0];
    if (mensaje.equalsIgnoreCase("Ok")) {

        if (parts[1].equalsIgnoreCase("Actualiza")) {


      out.write("\n");
      out.write("<div class=\"text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#mensaje\").hide(1500, function () {\n");
      out.write("            location.reload();\n");
      out.write("        });\n");
      out.write("        $(\"form\")[0].reset();\n");
      out.write("    });\n");
      out.write("</script>\n");
    } else {
    out.print(parts[1]);

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#titleModal\").html(\"Crear Subobjetivo\");\n");
      out.write("        $.post('subobjetivo_crear.jsp',\n");
      out.write("                {objetivo_id: ");
      out.print(parts[1]);
      out.write("},\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                }\n");
      out.write("        );\n");
      out.write("    });\n");
      out.write("</script>\n");

    }
} else {
      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    ");
      out.print(mensaje);
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
