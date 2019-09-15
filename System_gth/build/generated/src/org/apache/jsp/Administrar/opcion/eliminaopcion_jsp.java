package org.apache.jsp.Administrar.opcion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Opcion;
import Entidad.Menu;
import java.util.ArrayList;
import java.util.List;

public final class eliminaopcion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.OpcionController getunOpcion = null;
      synchronized (_jspx_page_context) {
        getunOpcion = (Controlador.OpcionController) _jspx_page_context.getAttribute("getunOpcion", PageContext.PAGE_SCOPE);
        if (getunOpcion == null){
          getunOpcion = new Controlador.OpcionController();
          _jspx_page_context.setAttribute("getunOpcion", getunOpcion, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    int idOpcion = 0;
    Opcion opcion = new Opcion();
    try {
        idOpcion = Integer.parseInt(request.getParameter("id"));
        opcion = getunOpcion.GetOpcionById(idOpcion);
    } catch (Exception e) {
        idOpcion = 0;
    }

      out.write('\n');
      Controlador.MenuController consultaMenu = null;
      synchronized (_jspx_page_context) {
        consultaMenu = (Controlador.MenuController) _jspx_page_context.getAttribute("consultaMenu", PageContext.PAGE_SCOPE);
        if (consultaMenu == null){
          consultaMenu = new Controlador.MenuController();
          _jspx_page_context.setAttribute("consultaMenu", consultaMenu, PageContext.PAGE_SCOPE);
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

    List<Menu> ListaMenu = new ArrayList<Menu>();
    ListaMenu = consultaMenu.getAllMenu();

      out.write("\n");
      out.write("                <form id=\"form_opcion_guardar\" method=\"post\" class=\"form_opcion_guardar\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(idOpcion);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Menú</label>\n");
      out.write("                            <select class=\"form-control select2\" name='idMenu' id='idMenu' style=\"width: 100%;\" disabled>\n");
      out.write("                                <option value=\"\">- Seleccionar -</option>\n");
      out.write("                                ");
 for (Menu i : ListaMenu) {
                                        String select = "";
                                        if (opcion.getMenu_id() == i.getMenu_id()) {
                                            select = "selected='selected'";
                                        }
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(i.getMenu_id());
      out.write('"');
      out.write(' ');
      out.print(select);
      out.write('>');
      out.print(i.getNombre());
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre Opción</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"opcion_nombre\"  name=\"opcion_nombre\" placeholder=\"Ingresar Nombre\" value=\"");
      out.print(_character.CharacterUCFirst(opcion.getNombre()));
      out.write("\" disabled>                            \n");
      out.write("                        </div>                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            ");

                                String select = "";
                                if (opcion.getEstado() > 0) {
                                    select = "checked";
                                }
      out.write("\n");
      out.write("                            <label> <input type=\"checkbox\" name=\"opcion_estado\" id=\"opcion_estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write(" disabled></label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Posición</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"opcion_posicion\" name=\"opcion_posicion\" placeholder=\"Ingresar Posición\" value=\"");
      out.print(opcion.getOrden());
      out.write("\" disabled>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Url</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\"  id=\"opcion_url\" name=\"opcion_url\" placeholder=\"Icono\" value=\"");
      out.print(opcion.getUrl());
      out.write("\" disabled>\n");
      out.write("                        </div>      \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Descripción</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\"  id=\"opcion_descripcion\" name=\"opcion_descripcion\" placeholder=\"Icono\" value=\"");
      out.print(opcion.getDescriocion());
      out.write("\" disabled>\n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default btn_canselar\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <div id=\"mensaje\"></div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('eliminaopcion_elimina.jsp',\n");
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
