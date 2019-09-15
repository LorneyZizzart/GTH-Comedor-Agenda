package org.apache.jsp.Registro.area;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import Entidad.Departamento;

public final class deleteArea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.AreaController _area = null;
      synchronized (_jspx_page_context) {
        _area = (Controlador.AreaController) _jspx_page_context.getAttribute("_area", PageContext.PAGE_SCOPE);
        if (_area == null){
          _area = new Controlador.AreaController();
          _jspx_page_context.setAttribute("_area", _area, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    int idArea = 0;
    List<Departamento> departamentos = new ArrayList<Departamento>();
    
    try {
        idArea = Integer.parseInt(request.getParameter("id"));
        departamentos = _area.DeleteArea(idArea);
    }catch (Exception e) {
        idArea = 0;
    }
    
    if(departamentos.size() == 0){

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Eliminado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\n");
      out.write("            location.reload();\n");
      out.write("        });\n");
      out.write("        $(\"form\")[0].reset();\n");
      out.write("    });\n");
      out.write("</script>\n");

} else {

      out.write("\n");
      out.write("<!-- TABLE: LATEST ORDERS -->\n");
      out.write("<div class=\"box\">\n");
      out.write("    <div class=\"box-header\">\n");
      out.write("        <div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("            <h4><i class=\"icon fa fa-ban\"></i>No se puede eliminar el área.</h4>\n");
      out.write("\n");
      out.write("            <p>El área tiene ");
      out.print(departamentos.size());
      out.write(" departamentos activos que estan asignados.</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"box-tools pull-right\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\n");
      out.write("            </button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- /.box-header -->\n");
      out.write("    <div class=\"box-body\">\n");
      out.write("        <div class=\"table-responsive\">\n");
      out.write("            <table class=\"table no-margin\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Departamento</th>\n");
      out.write("                        <th>Estado</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        for (Departamento item : departamentos) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(item.getDepartamento_id());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(item.getNombre());
      out.write("</td>\n");
      out.write("                        <td>");
 if (item.getEstado() == 1) {
      out.write("<span class=\"badge bg-green\">Activo</span> </td>");
} else {
      out.write("<span class=\"badge bg-red\">Inactivo</span> </td>");
}
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                    
      out.write("               \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.table-responsive -->\n");
      out.write("        ");

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
