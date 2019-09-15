package org.apache.jsp.Administrar.opcion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Entidad.Usuario;
import java.util.List;

public final class eliminaopcion_005felimina_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.OpcionController eliminaMenu = null;
      synchronized (_jspx_page_context) {
        eliminaMenu = (Controlador.OpcionController) _jspx_page_context.getAttribute("eliminaMenu", PageContext.PAGE_SCOPE);
        if (eliminaMenu == null){
          eliminaMenu = new Controlador.OpcionController();
          _jspx_page_context.setAttribute("eliminaMenu", eliminaMenu, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    List<Usuario> Usuarios = new ArrayList<Usuario>();
    int id = Integer.parseInt(request.getParameter("id"));
    Usuarios = eliminaMenu.EliminarOpcion(id);
    if (Usuarios.size() == 0) {

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
      out.write("            <h4><i class=\"icon fa fa-ban\"></i> No se puede eliminar la opción</h4>\n");
      out.write("\n");
      out.write("            <p>La opción tiene ");
      out.print(Usuarios.size());
      out.write(" usuarios activos que usan la opción.</p>\n");
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
      out.write("                        <th>Usuario</th>\n");
      out.write("                        <th>Correo</th>\n");
      out.write("                        <th>Perfil</th>\n");
      out.write("                        <th>Estado</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        for (Usuario item : Usuarios) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(item.getUsuario());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(item.getEmail());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(item.getPerfil());
      out.write("</td>\n");
      out.write("                        <td>");

                            if (item.getEstado() == 1) {
                            
      out.write("<span class=\"label label-success\">Activo</span>");

                            } else {
                            
      out.write("<span class=\"label label-warning\">Inactivo</span>");

                                }
                            
      out.write("</td>\n");
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
