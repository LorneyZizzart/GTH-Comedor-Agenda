package org.apache.jsp.planificaEstrate.plan_005faccion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Plan_matriz;
import Entidad.Login_Entidad;

public final class matriz_005fnuevo_005fguardar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Plan_matrizController crearPlanMatriz = null;
      synchronized (_jspx_page_context) {
        crearPlanMatriz = (Controlador.Plan_matrizController) _jspx_page_context.getAttribute("crearPlanMatriz", PageContext.PAGE_SCOPE);
        if (crearPlanMatriz == null){
          crearPlanMatriz = new Controlador.Plan_matrizController();
          _jspx_page_context.setAttribute("crearPlanMatriz", crearPlanMatriz, PageContext.PAGE_SCOPE);
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

    String plan_accion_id = request.getParameter("plan_accion_id");
    String plan_accion_estado = request.getParameter("plan_accion_estado");
    String mat_quehacer = request.getParameter("mat_quehacer");
    String mat_responsable = request.getParameter("mat_responsable");
    String mat_como = request.getParameter("mat_como");
    String mat_documento = request.getParameter("mat_documento");
    String mat_indicador_nombre = request.getParameter("mat_indicador_nombre");
    String mat_fecha = request.getParameter("mat_fecha");
    String mat_indicador = request.getParameter("mat_indicador");
    String Plan_matriz_id = request.getParameter("Plan_matriz_id");

    Plan_matriz matriz = new Plan_matriz();
    matriz.setPlan_matriz_id(Integer.parseInt(Plan_matriz_id));
    matriz.setQue_hacer(mat_quehacer);
    matriz.setResponsable(mat_responsable);
    matriz.setComo(mat_como);
    matriz.setDocumento_generadi(mat_documento);
    matriz.setIndicadores_resultado(mat_indicador_nombre);
    matriz.setFecha(mat_fecha);
    matriz.setIndicador(mat_indicador);
    matriz.setPlan_accion_id(Integer.parseInt(plan_accion_id));
    matriz.setEmpleado_id(DatoUsuario.getEmpleado_id());
    matriz.setEstado(Integer.parseInt(plan_accion_estado));

    String mensaje = crearPlanMatriz.SaveorUpdateMatriz(matriz);
    if (mensaje.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".mensaje\").hide(1500, function () {\n");
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
