package org.apache.jsp.Registro.empleado.cargo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cargo;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import Entidad.Nivel;
import Entidad.Departamento;

public final class crearCargo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
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
      Controlador.CharacterController _character = null;
      synchronized (_jspx_page_context) {
        _character = (Controlador.CharacterController) _jspx_page_context.getAttribute("_character", PageContext.PAGE_SCOPE);
        if (_character == null){
          _character = new Controlador.CharacterController();
          _jspx_page_context.setAttribute("_character", _character, PageContext.PAGE_SCOPE);
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

    int idEmpleado = Integer.parseInt(request.getParameter("id"));
    String opcion = "registrar";
    List<Nivel> listaNivel = new ArrayList<Nivel>();
    listaNivel = _nivel.getAllNivel();
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Cargo> cargos = new ArrayList<Cargo>();
    cargos = _cargo.getAllCargoByCargoId();
    
    Calendar fecha = new GregorianCalendar();
    String fechaNow="", day="", month="";
    
    if(fecha.get(fecha.DATE)<10) day = "0"+Integer.toString(fecha.get(fecha.DATE));
    else day = Integer.toString(fecha.get(fecha.DATE));
    fecha.add(fecha.MONTH, 1);
    if(fecha.get(fecha.MONTH)<10) month = "0"+Integer.toString(fecha.get(fecha.MONTH));
    else month = Integer.toString(fecha.get(fecha.MONTH));
        
    fechaNow = day +"/"+month+"/"+Integer.toString(fecha.get(fecha.YEAR));
    

      out.write("\n");
      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(idEmpleado);
      out.write("\" name=\"idEmpleado\" id=\"idEmpleado\">\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(opcion);
      out.write("\" name=\"opcion\" id=\"opcion\">\n");
      out.write("    \n");
      out.write("                    <div class=\"box-body\"> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Grupo</label>\n");
      out.write("                            <select name=\"idNivel\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"\" selected=\"selected\">Selecione una opción</option>\n");
      out.write("                                ");

                                for (Nivel item : listaNivel) {                                    
                                    
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(item.getNivel_id());
      out.write("\" >");
      out.print(_character.CharacterUCFirst(item.getNombre()));
      out.write("</option>\n");
      out.write("                            ");
 } 
      out.write(" \n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Departamento</label>\n");
      out.write("                            <select name=\"idDepartamento\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"\" selected=\"selected\">Selecione una opción</option>\n");
      out.write("                                ");

                                for (Departamento item : listaDepartamento) {
                                    
                                    
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(item.getDepartamento_id());
      out.write("\" >");
      out.print(_character.CharacterUCFirst(item.getNombre()));
      out.write("</option>\n");
      out.write("                            ");
 } 
      out.write("  \n");
      out.write("                            </select>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cargo:</label>\n");
      out.write("                            <select name=\"idCargo\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"\" selected=\"selected\">Selecione una opción</option>\n");
      out.write("                                ");

                                for (Cargo item : cargos) {
                                    if(item.getEstado() == 1){
                                    
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(item.getCargo_id());
      out.write('"');
      out.write('>');
      out.print(_character.CharacterUCFirst(item.getNombre()));
      out.write("</option>\n");
      out.write("                            ");
 } } 
      out.write("  \n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Fecha inicio</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"fechaInicio\" name=\"fechaInicio\" value=\"");
      out.print(fechaNow);
      out.write("\">                            \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group date\">\n");
      out.write("                            <label>Fecha final</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"fechaFinal\" name=\"fechaFinal\">                            \n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("<div id=\"mensaje\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2();\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    //Date picker\n");
      out.write("//    $('#datepicker').datepicker({\n");
      out.write("//      autoclose: true\n");
      out.write("//    })\n");
      out.write("    \n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $('.form_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                idNivel: {\n");
      out.write("                    message: 'El area no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Debe seleccionar un nivel. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                idDepartamento: {\n");
      out.write("                    message: 'El area no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Debe seleccionar un departamento de trabajo. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                idCargo: {\n");
      out.write("                    message: 'El cargo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Debe seleccionar un cargo de trabajo. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"cargo/guardarCargo.jsp\",\n");
      out.write("                data: $(\".form_guardar\").serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    $(\"#mensaje\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#mensaje\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
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
