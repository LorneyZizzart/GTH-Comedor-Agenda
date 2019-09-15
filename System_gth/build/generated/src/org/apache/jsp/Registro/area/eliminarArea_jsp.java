package org.apache.jsp.Registro.area;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Area;

public final class eliminarArea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.AreaController _area = null;
      synchronized (_jspx_page_context) {
        _area = (Controlador.AreaController) _jspx_page_context.getAttribute("_area", PageContext.PAGE_SCOPE);
        if (_area == null){
          _area = new Controlador.AreaController();
          _jspx_page_context.setAttribute("_area", _area, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
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

    String idEncript = request.getParameter("id");
    int idArea = 0;
    Area area = new Area();
    
    try {
        idArea = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        area = _area.getAreaById(idArea);
    }catch (Exception e) {
        idArea = 0;
    }

      out.write("\n");
      out.write("         <form id=\"form_guardar\" method=\"post\" class=\"form_area_guardar\">\n");
      out.write("             <input type=\"hidden\" value=\"");
      out.print(idArea);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"area_nombre\"  name=\"area_nombre\" placeholder=\"Ingresar nombre\" value=\"");
      out.print(_character.CharacterUCFirst(area.getNombre()));
      out.write("\">                            \n");
      out.write("                        </div>  \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Posición</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"posicion\"  name=\"posicion\" value=\"");
      out.print(area.getPosicion());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label\n");
      out.write("                            ");

                                String select = "";
                                if(area.getEstado() > 0){
                                    select = "checked";
                                }
                            
      out.write("\n");
      out.write("                            <label> <input disabled type=\"checkbox\" name=\"area_estado\" id=\"area_estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                        </div>   \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('deleteArea.jsp',\n");
      out.write("                    {id: id_menu},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("</script>\n");
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
