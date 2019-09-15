package org.apache.jsp.Registro.empleado.cargo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cargo;
import java.util.ArrayList;
import java.util.List;
import Entidad.Nivel;
import Entidad.Departamento;
import Entidad.Empleado_cargo;

public final class eliminarCargo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      Controlador.NivelController _nivel = null;
      synchronized (_jspx_page_context) {
        _nivel = (Controlador.NivelController) _jspx_page_context.getAttribute("_nivel", PageContext.PAGE_SCOPE);
        if (_nivel == null){
          _nivel = new Controlador.NivelController();
          _jspx_page_context.setAttribute("_nivel", _nivel, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.DepartamentoController _departamento = null;
      synchronized (_jspx_page_context) {
        _departamento = (Controlador.DepartamentoController) _jspx_page_context.getAttribute("_departamento", PageContext.PAGE_SCOPE);
        if (_departamento == null){
          _departamento = new Controlador.DepartamentoController();
          _jspx_page_context.setAttribute("_departamento", _departamento, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Empleado_cargoController _cargo = null;
      synchronized (_jspx_page_context) {
        _cargo = (Controlador.Empleado_cargoController) _jspx_page_context.getAttribute("_cargo", PageContext.PAGE_SCOPE);
        if (_cargo == null){
          _cargo = new Controlador.Empleado_cargoController();
          _jspx_page_context.setAttribute("_cargo", _cargo, PageContext.PAGE_SCOPE);
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
      Controlador.Empleado_cargoController _empleadoCargo = null;
      synchronized (_jspx_page_context) {
        _empleadoCargo = (Controlador.Empleado_cargoController) _jspx_page_context.getAttribute("_empleadoCargo", PageContext.PAGE_SCOPE);
        if (_empleadoCargo == null){
          _empleadoCargo = new Controlador.Empleado_cargoController();
          _jspx_page_context.setAttribute("_empleadoCargo", _empleadoCargo, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
  String idEncript = request.getParameter("id");
    int idEmpleadoCargo = Integer.parseInt(_encript.ValorADesencriptar(idEncript));

    List<Nivel> listaNivel = new ArrayList<Nivel>();
    listaNivel = _nivel.getAllNivel();
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Empleado_cargo> cargos = new ArrayList<Empleado_cargo>();
    cargos = _cargo.GetAllEmpleadoCargo();
    
    Empleado_cargo empleadoCargo = new Empleado_cargo();
    empleadoCargo = _empleadoCargo.GetEmpleadoCargoByEnpleadoCargo_id(idEmpleadoCargo);

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(empleadoCargo.getId());
      out.write("\" name=\"idCargo\" id=\"idCargo\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre completo</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\"  value=\"");
      out.print(_character.CharacterUCFirst(empleadoCargo.getEmpleado_nombre()));
      out.write("\">                            \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Grupo</label>\n");
      out.write("                            <select disabled name=\"idNivel\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                            <option>");
      out.print(_character.CharacterUCFirst(empleadoCargo.getNivel_nombre()));
      out.write("</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Departamento</label>\n");
      out.write("                            <select disabled name=\"idDepartamento\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                              <option>");
      out.print(_character.CharacterUCFirst(empleadoCargo.getDepartamento_nombre()));
      out.write("</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cargo:</label>\n");
      out.write("                            <select disabled name=\"idCargo\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                               <option>");
      out.print(_character.CharacterUCFirst(empleadoCargo.getCargo_nombre()));
      out.write("</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            ");

                                String select = "";
                                if(empleadoCargo.getActivo()> 0){
                                    select = "checked";
                                }
                            
      out.write("\n");
      out.write("                            <input disabled type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write(">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Fecha inicio</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"fechaInicio\" name=\"fechaInicio\" value=\"");
      out.print(empleadoCargo.getFecha_inicio());
      out.write("\">   \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group date\">\n");
      out.write("                            <label>Fecha final</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"fechaFinal\" name=\"fechaFinal\" value=\"");
      out.print(empleadoCargo.getFecha_fin());
      out.write("\"> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("<div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#idCargo\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('cargo/eliminar_eliminarCargo.jsp',\n");
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
