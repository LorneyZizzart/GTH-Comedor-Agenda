package org.apache.jsp.Administrar.modulo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Menu;

public final class eliminaMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.MenuController getunMenu = null;
      synchronized (_jspx_page_context) {
        getunMenu = (Controlador.MenuController) _jspx_page_context.getAttribute("getunMenu", PageContext.PAGE_SCOPE);
        if (getunMenu == null){
          getunMenu = new Controlador.MenuController();
          _jspx_page_context.setAttribute("getunMenu", getunMenu, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.CharacterController _character = null;
      synchronized (_jspx_page_context) {
        _character = (Controlador.CharacterController) _jspx_page_context.getAttribute("_character", PageContext.PAGE_SCOPE);
        if (_character == null){
          _character = new Controlador.CharacterController();
          _jspx_page_context.setAttribute("_character", _character, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    int idMenu = 0;
    Menu menu = new Menu();
    try {
        idMenu = Integer.parseInt(request.getParameter("id"));
        menu = getunMenu.getMenuById(idMenu);
    } catch (Exception e) {
        idMenu = 0;
    }

      out.write("\n");
      out.write("                <form id=\"form_menu_guardar\"  class=\"form_menu_guardar\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(idMenu);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"modulo_nombre\"  name=\"modulo_nombre\" placeholder=\"Ingresar Nombre\" value=\"");
      out.print(_character.CharacterUCFirst(menu.getNombre()));
      out.write("\" disabled>                            \n");
      out.write("                        </div>                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            ");

                                String select = "";
                                if (menu.getEstado() > 0) {
                                    select = "checked";
                                }
      out.write("\n");
      out.write("                            <label> <input type=\"checkbox\" name=\"modulo_estado\" id=\"modulo_estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write(" disabled></label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Posición</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"modulo_posicion\" name=\"modulo_posicion\" placeholder=\"Ingresar Posición\" value=\"");
      out.print(menu.getPosicion());
      out.write("\" disabled>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Icono</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\"  id=\"modulo_icono\" name=\"modulo_icono\" placeholder=\"Icono\" value=\"");
      out.print(menu.getIcono());
      out.write("\" disabled>\n");
      out.write("                        </div>                        \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn_eliminar btn btn-danger pull-right\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <div id=\"mensaje\"></div>\n");
      out.write("                \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('eliminaMenu_elimina.jsp',\n");
      out.write("                    {id: id_menu},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>");
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
