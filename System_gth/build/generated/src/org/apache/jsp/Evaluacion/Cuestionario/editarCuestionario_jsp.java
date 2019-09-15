package org.apache.jsp.Evaluacion.Cuestionario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.*;
import java.util.*;

public final class editarCuestionario_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    \n");
      out.write("\n");
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
    String idUserEncript = request.getParameter("idUser");
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    List<Sector_Cuestionario> departamentos = new ArrayList<Sector_Cuestionario>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Cargo> listaCargo = new ArrayList<Cargo>();
    List<Sector_Cuestionario> cargos = new ArrayList<Sector_Cuestionario>();
    listaCargo = _cargo.getAllCargoByCargoId();
        
    int idCuestionario = 0;
    int idUsuario = 0;
    Cuestionario cuestionario = new Cuestionario();
    
    try {
        idUsuario = Integer.parseInt(_encript.ValorADesencriptar(idUserEncript));
        idCuestionario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cuestionario = _cuestionario.GetCuestionariobyCuestionario_id(idCuestionario);
        cargos = cuestionario.getSectores().getCargo();
        departamentos = cuestionario.getSectores().getDepartamentos();
    }catch (Exception e) {
        idCuestionario = 0;
        idUsuario = 0;
    }

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idCuestionario);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("             <input type=\"hidden\" value=\"");
      out.print(idUsuario);
      out.write("\" name=\"idUsuario\" id=\"idUsuario\">\n");
      out.write("\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                         <div class=\"form-group\">\n");
      out.write("                            <label>Nombre del cuestionario</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"nombre\"  name=\"nombre\" value=\"");
      out.print(cuestionario.getNombre());
      out.write("\">                            \n");
      out.write("                        </div>   \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cargo</label>\n");
      out.write("                            <select name=\"idCargo\" class=\"form-control select2 selectNivel\" multiple=\"multiple\" style=\"width: 100%;\">\n");
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
      out.write("                              ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Descripción</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"descripcion\"  name=\"descripcion\">");
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
      out.write("                            <label> <input type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Departamemto</label>\n");
      out.write("                            <select name=\"idDepartamento\" class=\"form-control select2 selectDepartamento\" multiple=\"multiple\" style=\"width: 100%;\">\n");
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
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-refresh\"></i> Actualizar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
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
      out.write("                nombre:{\n");
      out.write("                    message: 'El nombre no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El nombre no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 6,\n");
      out.write("                            max: 100,\n");
      out.write("                            message: 'El Nombre tiene que ser mas de 6 y menos de 100 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z()0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'\n");
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
      out.write("                url: \"guardarCuestionario.jsp\",\n");
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
