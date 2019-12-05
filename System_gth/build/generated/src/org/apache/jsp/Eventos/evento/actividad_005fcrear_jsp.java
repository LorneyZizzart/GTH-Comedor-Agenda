package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Evento_Actividad;

public final class actividad_005fcrear_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Evento_ActividadController traer_Actividad = null;
      synchronized (_jspx_page_context) {
        traer_Actividad = (Controlador.Evento_ActividadController) _jspx_page_context.getAttribute("traer_Actividad", PageContext.PAGE_SCOPE);
        if (traer_Actividad == null){
          traer_Actividad = new Controlador.Evento_ActividadController();
          _jspx_page_context.setAttribute("traer_Actividad", traer_Actividad, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String e_evento_id = request.getParameter("id_evento");
    int e_actividad_id = Integer.parseInt(request.getParameter("id_actividad"));
    Evento_Actividad evento = new Evento_Actividad();
    if (e_actividad_id == 0) {
        evento = null;
    } else {
        evento = traer_Actividad.GetActividadesByActividad_id(e_actividad_id);
    }


      out.write("\n");
      out.write("<form id=\"form_actividad_guardar\" method=\"post\" class=\"form_actividad_guardar\">   \n");
      out.write("    <input type=\"hidden\" name=\"evento_id\" id=\"evento_id\" value=\"");
      out.print(e_evento_id);
      out.write("\">\n");
      out.write("    <input type=\"hidden\" name=\"actividad_id\" id=\"actividad_id\" value=\"");
      out.print(e_actividad_id);
      out.write("\">\n");
      out.write("    <div class=\"box-body\">\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <label>Nombre actividad</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"actividad_nombre\"  name=\"actividad_nombre\" value=\"");
 if (evento != null) {
                    out.print(evento.getNombre_actividad());
                }
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <label>Fecha inicio</label>\n");
      out.write("                    <div class=\"input-group date\">\n");
      out.write("                        <div class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-calendar\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"actividad_inicio_fecha\"  name=\"actividad_inicio_fecha\" value=\"");
 if (evento != null) {
                                out.print(evento.getFecha_inicio_actividad());
                            }
      out.write("\">                            \n");
      out.write("                    </div>        \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 bootstrap-timepicker\">\n");
      out.write("                    <label>Hora inicio</label>\n");
      out.write("                    <div class=\"input-group date\">\n");
      out.write("                        <div class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"text\" class=\"form-control timepicker\" id=\"actividad_inicio_hora\"  name=\"actividad_inicio_hora\" value=\"");
 if (evento != null) {
                                out.print(evento.getHora_inicio_actividad());
                            }
      out.write("\">                            \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <label>Fecha fin</label>\n");
      out.write("                    <div class=\"input-group date\">\n");
      out.write("                        <div class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-calendar\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"actividad_fin_fecha\"  name=\"actividad_fin_fecha\" value=\"");
 if (evento != null) {
                                out.print(evento.getFecha_fin_actividad());
                            }
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 bootstrap-timepicker\">\n");
      out.write("                    <label>Hora fin</label>\n");
      out.write("                    <div class=\"input-group date\">\n");
      out.write("                        <div class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"text\" class=\"form-control actividad_fin_hora\" id=\"actividad_fin_hora\"  name=\"actividad_fin_hora\" value=\"");
 if (evento != null) {
                                out.print(evento.getHora_fin_actividad());
                            }
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <label>Detalle</label>\n");
      out.write("            <textarea class=\"form-control\" rows=\"3\" id=\"actividad_detalle\"  name=\"actividad_detalle\">");
 if (evento != null) {
                    out.print(evento.getDescripcion());
                }
      out.write("</textarea>            \n");
      out.write("        </div>        \n");
      out.write("    </div>\n");
      out.write("    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("    <div class=\"box-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("<div id=\"mensaje\"></div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    //Timepicker\n");
      out.write("    $(\".timepicker\").timepicker({\n");
      out.write("        showInputs: false\n");
      out.write("    });\n");
      out.write("    $(\".actividad_fin_hora\").timepicker({\n");
      out.write("        showInputs: false\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('#actividad_inicio_fecha').datepicker({\n");
      out.write("        autoclose: true,\n");
      out.write("        language: 'es'\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('#actividad_fin_fecha').datepicker({\n");
      out.write("        autoclose: true,\n");
      out.write("        language: 'es'\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('.form_actividad_guardar').bootstrapValidator({\n");
      out.write("        message: 'Este valor no es valido',\n");
      out.write("        feedbackIcons: {\n");
      out.write("            valid: 'glyphicon glyphicon-ok',\n");
      out.write("            invalid: 'glyphicon glyphicon-remove',\n");
      out.write("            validating: 'glyphicon glyphicon-refresh'\n");
      out.write("        },\n");
      out.write("        fields: {\n");
      out.write("            actividad_nombre: {\n");
      out.write("                message: 'El nombre no es valido.',\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'El nombre no puede ser vacio. '\n");
      out.write("                    },\n");
      out.write("                    stringLength: {\n");
      out.write("                        min: 6,\n");
      out.write("                        max: 200,\n");
      out.write("                        message: 'El Nombre tiene que ser mas de 6 y menos de 200 caracteres'\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            actividad_inicio_fecha: {\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'Fecha es requerido. '\n");
      out.write("                    },\n");
      out.write("                    date: {\n");
      out.write("                        format: 'DD/MM/YYYY',\n");
      out.write("                        message: 'La fecha no es valida.'\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            actividad_inicio_hora: {\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'Fecha es requerido. '\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            actividad_fin_fecha: {\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'Fecha es requerido. '\n");
      out.write("                    },\n");
      out.write("                    date: {\n");
      out.write("                        format: 'DD/MM/YYYY',\n");
      out.write("                        message: 'La fecha no es valida.'\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            actividad_fin_hora: {\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'Fecha es requerido. '\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            actividad_detalle: {\n");
      out.write("                message: 'El detalle no es valido.',\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'El detalle no puede ser vacio. '\n");
      out.write("                    },\n");
      out.write("                    stringLength: {\n");
      out.write("                        min: 6,\n");
      out.write("                        max: 500,\n");
      out.write("                        message: 'El Nombre tiene que ser mas de 6 y menos de 500 caracteres'\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    }).on('success.form.bv', function (e) {\n");
      out.write("        // Prevent submit form\n");
      out.write("        e.preventDefault();\n");
      out.write("        $(\"#mensaje\").show();\n");
      out.write("        $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("        var $form = $(e.target),\n");
      out.write("                validator = $form.data('bootstrapValidator');\n");
      out.write("        $.ajax({\n");
      out.write("            type: \"POST\",\n");
      out.write("            url: \"actividad_crear_guardar.jsp\",\n");
      out.write("            data: $(\".form_actividad_guardar\").serialize(),\n");
      out.write("            success: function (data)\n");
      out.write("            {\n");
      out.write("                $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                $(\"#mensaje\").html(data);\n");
      out.write("            }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                $(\"#mensaje\").html(menn);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
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
