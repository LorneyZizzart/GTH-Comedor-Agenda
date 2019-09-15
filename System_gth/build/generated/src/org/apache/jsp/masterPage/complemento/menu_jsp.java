package org.apache.jsp.masterPage.complemento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Opcion;
import Entidad.Login_Entidad;
import java.util.ArrayList;
import java.util.List;
import Entidad.Menu;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession sesionmenu = request.getSession();
    if (sesionmenu.getAttribute("USUARIO") == null) {
        out.print("<script>window.location.href = 'login.jsp';</script>");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!-- Left side column. contains the logo and sidebar -->\n");
      out.write("<aside class=\"main-sidebar\">\n");
      out.write("    <!-- sidebar: style can be found in sidebar.less -->\n");
      out.write("    <section class=\"sidebar\">\n");
      out.write("        <!-- Sidebar user panel -->\n");
      out.write("        <div class=\"user-panel\">\n");
      out.write("            <div class=\"pull-left image\">\n");
      out.write("                <img src=\"../../folder_picture/../images/user.png\" class=\"img-circle\" alt=\"User Image\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"pull-left info\">\n");
      out.write("                <p>Admin</p>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- sidebar menu: : style can be found in sidebar.less -->\n");
      out.write("        <ul class=\"sidebar-menu\">\n");
      out.write("            <li class=\"header\">MENÚ PRINCIPAL</li>\n");
      out.write("\n");
      out.write("            ");


                List<Menu> menu = new ArrayList<Menu>();

                menu = (ArrayList<Menu>) sesionmenu.getAttribute("MENU");

                for (Menu item : menu) {
            
      out.write("\n");
      out.write("            <li class=\"treeview\">\n");
      out.write("                <a href=\"#\">\n");
      out.write("                    <i class=\"");
      out.print(item.getIcono());
      out.write("\"></i> <span>");
      out.print(item.getNombre());
      out.write("</span>\n");
      out.write("                    <span class=\"pull-right-container\">\n");
      out.write("                        <i class=\"fa fa-angle-left pull-right\"></i>\n");
      out.write("                    </span>\n");
      out.write("                </a>\n");
      out.write("\n");
      out.write("                ");

                    for (Opcion elem : item.getOpciones()) {
                
      out.write("\n");
      out.write("                <ul class=\"treeview-menu\">\n");
      out.write("                    <li><a href=\"");
      out.print(elem.getUrl());
      out.write("\"><i class=\"fa fa-circle-o\"></i> ");
      out.print(elem.getNombre());
      out.write("</a></li>                    \n");
      out.write("                </ul>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </li>\n");
      out.write("            ");

                }
            
      out.write("            \n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </section>\n");
      out.write("    <!-- /.sidebar -->\n");
      out.write("</aside>\n");
      out.write("\n");
      out.write("<!-- Content Wrapper. Contains page content -->\n");
      out.write("<div class=\"content-wrapper\">");
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
