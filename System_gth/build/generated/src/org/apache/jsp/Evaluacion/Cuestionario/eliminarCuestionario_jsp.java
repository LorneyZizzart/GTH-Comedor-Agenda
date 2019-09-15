package org.apache.jsp.Evaluacion.Cuestionario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.*;
import java.util.*;

public final class eliminarCuestionario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.CuestionarioController _cuestionario = null;
      synchronized (_jspx_page_context) {
        _cuestionario = (Controlador.CuestionarioController) _jspx_page_context.getAttribute("_cuestionario", PageContext.PAGE_SCOPE);
        if (_cuestionario == null){
          _cuestionario = new Controlador.CuestionarioController();
          _jspx_page_context.setAttribute("_cuestionario", _cuestionario, PageContext.PAGE_SCOPE);
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
      out.write("   \n");
      Controlador.DepartamentoController _departamento = null;
      synchronized (_jspx_page_context) {
        _departamento = (Controlador.DepartamentoController) _jspx_page_context.getAttribute("_departamento", PageContext.PAGE_SCOPE);
        if (_departamento == null){
          _departamento = new Controlador.DepartamentoController();
          _jspx_page_context.setAttribute("_departamento", _departamento, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.CargoController _cargo = null;
      synchronized (_jspx_page_context) {
        _cargo = (Controlador.CargoController) _jspx_page_context.getAttribute("_cargo", PageContext.PAGE_SCOPE);
        if (_cargo == null){
          _cargo = new Controlador.CargoController();
          _jspx_page_context.setAttribute("_cargo", _cargo, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idEncript = request.getParameter("id");    
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    List<Sector_Cuestionario> departamentos = new ArrayList<Sector_Cuestionario>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Cargo> listaCargo = new ArrayList<Cargo>();
    List<Sector_Cuestionario> cargos = new ArrayList<Sector_Cuestionario>();
    listaCargo = _cargo.getAllCargoByCargoId();
    
    int idCuestionario = 0;
    Cuestionario cuestionario = new Cuestionario();
    
    try {
        idCuestionario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cuestionario = _cuestionario.GetCuestionariobyCuestionario_id(idCuestionario);
        departamentos = cuestionario.getSectores().getDepartamentos();
        cargos = cuestionario.getSectores().getCargo();
    }catch (Exception e) {
        idCuestionario = 0;
    }

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idCuestionario);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                         <div class=\"form-group\">\n");
      out.write("                            <label>Nombre del cuestionario</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"nombre\"  name=\"nombre\" placeholder=\"Ingresar nombre\" value=\"");
      out.print(cuestionario.getNombre());
      out.write("\">                           \n");
      out.write("                        </div>   \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cargo</label>\n");
      out.write("                            <select disabled name=\"idCargo\" class=\"form-control select2 selectNivel\" multiple=\"multiple\" style=\"width: 100%;\">\n");
      out.write("                                <option disabled>Selecione una opción</option>\n");
      out.write("                              ");

                                for (Cargo item : listaCargo) {
                                     String Select = "";
                                for (Sector_Cuestionario sector : cargos){
                                    if(item.getCargo_id()== sector.getArea_id())
                                        Select = "Selected";
                                }
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(item.getCargo_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>  \n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Descripción</label>\n");
      out.write("                            <textarea disabled class=\"form-control\" rows=\"3\" id=\"descripcion\"  name=\"descripcion\">");
      out.print(cuestionario.getDetalle());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Activar</label>\n");
      out.write("                            ");

                                String select = "";
                                if(cuestionario.getEstado() > 0){
                                    select = "checked";
                                }
                            
      out.write("\n");
      out.write("                            <label> <input disabled type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Departamemto</label>\n");
      out.write("                            <select disabled name=\"idDepartamento\" class=\"form-control select2 selectDepartamento\" multiple=\"multiple\" style=\"width: 100%;\">\n");
      out.write("                              <option disabled>Selecione una opción</option>\n");
      out.write("                              ");

                                for (Departamento item : listaDepartamento) {
                                    String Select = "";
                                for (Sector_Cuestionario sector : departamentos){
                                    if(item.getDepartamento_id() == sector.getArea_id())
                                        Select = "Selected";
                                }
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(item.getDepartamento_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                              ");
 } 
      out.write("\n");
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
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('deleteCuestionario.jsp',\n");
      out.write("                    {id: id_menu},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write(" \n");
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
