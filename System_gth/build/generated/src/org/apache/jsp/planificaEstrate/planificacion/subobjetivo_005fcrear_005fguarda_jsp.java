package org.apache.jsp.planificaEstrate.planificacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Plan_subobjetivo;
import Entidad.Login_Entidad;

public final class subobjetivo_005fcrear_005fguarda_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Plan_subobjetivoController guardaPlansubobjetivo = null;
      synchronized (_jspx_page_context) {
        guardaPlansubobjetivo = (Controlador.Plan_subobjetivoController) _jspx_page_context.getAttribute("guardaPlansubobjetivo", PageContext.PAGE_SCOPE);
        if (guardaPlansubobjetivo == null){
          guardaPlansubobjetivo = new Controlador.Plan_subobjetivoController();
          _jspx_page_context.setAttribute("guardaPlansubobjetivo", guardaPlansubobjetivo, PageContext.PAGE_SCOPE);
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

    String objetivo_id = request.getParameter("objetivo_id");
    String subobjetivo_id = request.getParameter("subobjetivo_id");
    String subobjetivo_titulo = request.getParameter("sub_titulo");
    String subobjetivo_descripcion = request.getParameter("sub_descri");
    String subobjetivo_estado = request.getParameter("subobjetivo_estado");

    int empleado_id = DatoUsuario.getEmpleado_id();

    Plan_subobjetivo subobjetivo = new Plan_subobjetivo();
    subobjetivo.setPlan_subobjetivo_id(Integer.parseInt(subobjetivo_id));
    subobjetivo.setPlan_objetivo_id(Integer.parseInt(objetivo_id));
    subobjetivo.setTitulo(subobjetivo_titulo);
    subobjetivo.setDescripcion(subobjetivo_descripcion);
    subobjetivo.setEmpleado_id(empleado_id);
    subobjetivo.setEstado(Integer.parseInt(subobjetivo_estado));

    String mensaje = guardaPlansubobjetivo.SaveorUpdateSubobjetivo(subobjetivo);

    if (mensaje.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
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
