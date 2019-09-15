package org.apache.jsp.Registro.departamento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.Area;
import Entidad.Departamento;

public final class eliminarDepartamento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.AreaController _area = null;
      synchronized (_jspx_page_context) {
        _area = (Controlador.AreaController) _jspx_page_context.getAttribute("_area", PageContext.PAGE_SCOPE);
        if (_area == null){
          _area = new Controlador.AreaController();
          _jspx_page_context.setAttribute("_area", _area, PageContext.PAGE_SCOPE);
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
    int idDepartamento = 0;
    Departamento departamento = new Departamento();
    
    List<Area> listaArea = new ArrayList<Area>();
    listaArea = _area.getAllArea();
    
    List<Departamento> ListaDepartamento = new ArrayList<Departamento>();
    ListaDepartamento = _departamento.GetAllDepartamento();
    
    try {
        idDepartamento = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        departamento = _departamento.GetDepartamentoById(idDepartamento);
    }catch (Exception e) {
        idDepartamento = 0;
    }

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("             <input type=\"hidden\" value=\"");
      out.print(idDepartamento);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Area</label>\n");
      out.write("                            <select disabled name=\"idArea\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"\">Selecione una opción</option>\n");
      out.write("                            ");

                                for (Area item : listaArea) {
                                    String Select = "";
                                    if (item.getArea_id() == departamento.getArea_id()) {
                                            Select = "Selected";
                                        }
                                if(item.getEstado() == 1){
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(item.getArea_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                              ");
 } } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                            <label>Departamento</label>\n");
      out.write("                            <select disabled name=\"idDepartamento\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"0\"></option>\n");
      out.write("                            ");

                                for (Departamento item : ListaDepartamento) {
                                    String Select = "";
                                    if (item.getNombre().equalsIgnoreCase(departamento.getDepartamento_Nombre_dep())) {
                                            Select = "Selected";
                                        }
                                if(item.getEstado() == 1){
                            
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
 } } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"nombre\"  name=\"nombre\" placeholder=\"Ingresar nombre\" value=\"");
      out.print(_character.CharacterUCFirst(departamento.getNombre()));
      out.write("\">                            \n");
      out.write("                        </div>                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label\n");
      out.write("                            ");

                                String select = "";
                                if(departamento.getEstado() > 0){
                                    select = "checked";
                                }
                            
      out.write("\n");
      out.write("                            <label> <input disabled type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("      $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('deleteDepartamento.jsp',\n");
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
