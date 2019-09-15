package org.apache.jsp.Administrar.modulo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Entidad.Usuario;
import java.util.List;

public final class eliminaMenu_005felimina_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.MenuController eliminaMenu = null;
      synchronized (_jspx_page_context) {
        eliminaMenu = (Controlador.MenuController) _jspx_page_context.getAttribute("eliminaMenu", PageContext.PAGE_SCOPE);
        if (eliminaMenu == null){
          eliminaMenu = new Controlador.MenuController();
          _jspx_page_context.setAttribute("eliminaMenu", eliminaMenu, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    List<Usuario> Usuarios = new ArrayList<Usuario>();
    int id = Integer.parseInt(request.getParameter("id"));
    Usuarios = eliminaMenu.Elimina(id);
    if (Usuarios.size() == 0) {

      out.write("\r\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\r\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Eliminado</h4>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\r\n");
      out.write("            location.reload();\r\n");
      out.write("        });\r\n");
      out.write("        $(\"form\")[0].reset();\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");

} else {

      out.write("\r\n");
      out.write("<!-- TABLE: LATEST ORDERS -->\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("    <div class=\"box-header\">\r\n");
      out.write("        <div class=\"alert alert-danger alert-dismissible\">\r\n");
      out.write("            <h4><i class=\"icon fa fa-ban\"></i> No se puede eliminar el menú</h4>\r\n");
      out.write("\r\n");
      out.write("            <p>El menú tiene ");
      out.print(Usuarios.size());
      out.write(" usuarios activos que usan la opción.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"box-tools pull-right\">\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\r\n");
      out.write("            </button>\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.box-header -->\r\n");
      out.write("    <div class=\"box-body\">\r\n");
      out.write("        <div class=\"table-responsive\">\r\n");
      out.write("            <table class=\"table no-margin\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Usuario</th>\r\n");
      out.write("                        <th>Correo</th>\r\n");
      out.write("                        <th>Perfil</th>\r\n");
      out.write("                        <th>Estado</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    ");

                        for (Usuario item : Usuarios) {
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>");
      out.print(item.getUsuario());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(item.getEmail());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(item.getPerfil());
      out.write("</td>\r\n");
      out.write("                        <td>");

                            if (item.getEstado() == 1) {
                            
      out.write("<span class=\"label label-success\">Activo</span>");

                            } else {
                            
      out.write("<span class=\"label label-warning\">Inactivo</span>");

                                }
                            
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");

                        }
                    
      out.write("               \r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.table-responsive -->\r\n");
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
