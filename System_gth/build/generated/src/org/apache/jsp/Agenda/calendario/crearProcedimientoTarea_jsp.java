package org.apache.jsp.Agenda.calendario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Empleado;
import java.util.ArrayList;
import java.util.List;

public final class crearProcedimientoTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EmpleadoController _empleado = null;
      synchronized (_jspx_page_context) {
        _empleado = (Controlador.EmpleadoController) _jspx_page_context.getAttribute("_empleado", PageContext.PAGE_SCOPE);
        if (_empleado == null){
          _empleado = new Controlador.EmpleadoController();
          _jspx_page_context.setAttribute("_empleado", _empleado, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idUsuario =  request.getParameter("id");
    List<Empleado> listaEmpleado = new ArrayList<Empleado>();
    listaEmpleado = _empleado.GetAllEmpleado();

      out.write("\n");
      out.write("<form id=\"frm_guardar\" method=\"post\" class=\"frm_guardar\" >\n");
      out.write("    <input type=\"hidden\" value=\"0\" name=\"id\" id=\"id\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idUsuario);
      out.write("\" name=\"idUsuario\" id=\"idUsuario\">\n");
      out.write("    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Paso</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"paso\"  name=\"paso\">                            \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group col-md-6\" style=\"padding-right: 10px; padding-left: 0px;\">\n");
      out.write("                        <label>Responsable</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"responsable\"  name=\"responsable\">   \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6 frm-funcionario\" style=\"margin-top: 2px; padding-right: 0px; padding-left: 0px; margin-bottom: 39px;\">\n");
      out.write("                        <label>Funcionario(s)</label>\n");
      out.write("                        <select name=\"funcionario\" class=\"form-control select3\" multiple=\"multiple\" data-placeholder=\"Selecionar funcionario\" style=\"width: 100%;\">\n");
      out.write("                                ");

                                    for(Empleado item : listaEmpleado){
                                    if(item.getEstado()== 1){
                                
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(item.getEmpleado_id());
      out.write('"');
      out.write('>');
      out.print(item.getApellido_paterno());
      out.write(' ');
      out.print(item.getApellido_materno());
      out.write(' ');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                             ");
 } } 
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-12\" style=\"padding: 0;\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                            <label>Actividad</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"actividad\"  name=\"actividad\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Documento de trabajo</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"documento\"  name=\"documento\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group col-md-6\" style=\"padding-right: 10px; padding-left: 0px;\">\n");
      out.write("                            <label>Fecha incio:</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                                <input type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"datepicker3\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"bootstrap-timepicker col-md-6\" style=\"padding-right: 0px; padding-left: 0px;\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                              <label>Hora</label>\n");
      out.write("\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control timepicker\" name=\"hi\">\n");
      out.write("\n");
      out.write("                                <div class=\"input-group-addon\">\n");
      out.write("                                  <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <!-- /.input group -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form group -->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-12\" style=\"padding: 0;\">\n");
      out.write("                            <div class=\"form-group col-md-6\" style=\"padding-right: 10px; padding-left: 0px;\">\n");
      out.write("                            <label>Fecha final</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                                <input type=\"text\" class=\"form-control pull-right\" name=\"ff\" id=\"datepicker4\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"bootstrap-timepicker col-md-6\" style=\"padding-right: 0px; padding-left: 0px;\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                              <label>Hora</label>\n");
      out.write("\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control timepicker\" name=\"hf\">\n");
      out.write("\n");
      out.write("                                <div class=\"input-group-addon\">\n");
      out.write("                                  <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <!-- /.input group -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form group -->\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            <input type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\">\n");
      out.write("                        </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("    </div>\n");
      out.write("    <div class=\"box-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("    </div>                \n");
      out.write("    </form>\n");
      out.write("    <div  id=\"message\" style=\"margin: 2%;\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        //Timepicker\n");
      out.write("    $(\".timepicker\").timepicker({\n");
      out.write("      showInputs: false\n");
      out.write("    });\n");
      out.write("        //Initialize Select2 Elements\n");
      out.write("        $(\".select3\").select2();\n");
      out.write("        //Date picker\n");
      out.write("        $('#datepicker3').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("          autoclose: true\n");
      out.write("        });\n");
      out.write("        $('#datepicker4').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("          autoclose: true\n");
      out.write("        });\n");
      out.write("        $('.frm_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                paso:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: \n");
      out.write("                        {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: \n");
      out.write("                        {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 2,\n");
      out.write("                            message: 'Solo puede tener 2 caracteres.'\n");
      out.write("                        },\n");
      out.write("                        integer: {\n");
      out.write("                            message: 'El valor debe ser un número entero.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                responsable:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 3,\n");
      out.write("                            max: 30,\n");
      out.write("                            message: 'Tiene que ser mas de 6 y menos de 30 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                actividad:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 3,\n");
      out.write("                            max: 400,\n");
      out.write("                            message: 'Tiene que ser mas de 6 y menos de 30 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'Solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                documento:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 400,\n");
      out.write("                            message: 'Tiene que ser mas de 1 y menos de 400 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'Solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                fi:{\n");
      out.write("                    message: 'La fecha de inicio no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La fecha de inicio no puede ser vacio.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                hi:{\n");
      out.write("                    message: 'La hora no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La hora no puede ser vacio.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                ff:{\n");
      out.write("                    message: 'La fecha final no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La fecha final no puede ser vacio.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                hf:{\n");
      out.write("                    message: 'La hora no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La hora no puede ser vacio.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#message\").show();\n");
      out.write("            $(\"#message\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"guardarProcedimientoTarea.jsp\",\n");
      out.write("                data: $(\".frm_guardar\").serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#message\").removeClass(\"loader\");\n");
      out.write("                    $(\"#message\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#message\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#message\").html(menn);\n");
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
