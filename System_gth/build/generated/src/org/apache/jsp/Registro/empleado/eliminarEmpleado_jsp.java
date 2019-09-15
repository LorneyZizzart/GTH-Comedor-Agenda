package org.apache.jsp.Registro.empleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Empleado;

public final class eliminarEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EmpleadoController _empleado = null;
      synchronized (_jspx_page_context) {
        _empleado = (Controlador.EmpleadoController) _jspx_page_context.getAttribute("_empleado", PageContext.PAGE_SCOPE);
        if (_empleado == null){
          _empleado = new Controlador.EmpleadoController();
          _jspx_page_context.setAttribute("_empleado", _empleado, PageContext.PAGE_SCOPE);
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
 int idEmpleado = 0; 
    String idEncript = request.getParameter("id");  

    Empleado empleado = new Empleado();
    
    try {
        idEmpleado = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        empleado = _empleado.GetEmpleadoByID(idEmpleado);
    }catch (Exception e) {
        idEmpleado = 0;
    }    

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("             <input type=\"hidden\" value=\"");
      out.print(empleado.getEmpleado_id());
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"nombre\"  name=\"nombre\" placeholder=\"Nombres\" value=\"");
      out.print(_character.CharacterUCFirst(empleado.getNombre()));
      out.write("\">                            \n");
      out.write("                        </div>  \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Apellido paterno</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"apellidoPaterno\"  name=\"apellidoPaterno\" placeholder=\"Apellido paterno\" value=\"");
      out.print(_character.CharacterUCFirst(empleado.getApellido_paterno()));
      out.write("\">                            \n");
      out.write("                        </div>  \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Apellido materno</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"apellidoMaterno\"  name=\"apellidoMaterno\" placeholder=\"Apellido materno\" value=\"");
      out.print(_character.CharacterUCFirst(empleado.getApellido_materno()));
      out.write("\">                            \n");
      out.write("                        </div>  \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Correo electrónico</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"email\"  name=\"email\" placeholder=\"Email\" value=\"");
      out.print(empleado.getEmail());
      out.write("\">                            \n");
      out.write("                        </div>  \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Teléfono</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"telefono\"  name=\"telefono\" placeholder=\"Teléfono\" value=\"");
      out.print(empleado.getTelefono());
      out.write("\">                            \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            ");

                                String select = "";
                                if(empleado.getEstado() > 0){
                                    select = "checked";
                                }
                            
      out.write("\n");
      out.write("                            <label> <input disabled type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado civil</label>\n");
      out.write("                            <select disabled name=\"idEstadoCivil\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"\" selected=\"selected\">");
      out.print(empleado.getEstado_civil_Nombre());
      out.write("</option>     \n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>País</label>\n");
      out.write("                            <select disabled name=\"idPais\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"\" selected=\"selected\">");
      out.print(empleado.getPaisNombre());
      out.write("</option>  \n");
      out.write("                                \n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("      $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('deleteEmpleado.jsp',\n");
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
