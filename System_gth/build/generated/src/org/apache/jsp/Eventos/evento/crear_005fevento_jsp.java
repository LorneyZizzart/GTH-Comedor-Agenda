package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Evento;

public final class crear_005fevento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EventoController editarEvento = null;
      synchronized (_jspx_page_context) {
        editarEvento = (Controlador.EventoController) _jspx_page_context.getAttribute("editarEvento", PageContext.PAGE_SCOPE);
        if (editarEvento == null){
          editarEvento = new Controlador.EventoController();
          _jspx_page_context.setAttribute("editarEvento", editarEvento, PageContext.PAGE_SCOPE);
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

    Evento e_evento = new Evento();
    int evento_id = 0;

    try {
        String desencriptar = _encript.ValorADesencriptar(request.getParameter("evento_id"));
        evento_id = Integer.parseInt(desencriptar);
        e_evento = editarEvento.GetEventobyId(evento_id);
    } catch (Exception e) {
        System.err.println(" -- - " + e.getMessage());
        evento_id = 0;
        e_evento = null;
    }

    //out.print(evento_id);

      out.write("\n");
      out.write("<form id=\"form_evento_guardar\" method=\"post\" class=\"form_evento_guardar\">   \n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(evento_id);
      out.write("\" name=\"evento_id\" id=\"evento_id\">\n");
      out.write("    <div class=\"box-body\">\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <label>Nombre evento</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"evento_nombre\"  name=\"evento_nombre\" value=\"");
 if (e_evento != null) {
                    out.print(e_evento.getNombre_evento());
                }
                   
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <label>Fecha inicio</label>\n");
      out.write("            <div class=\"input-group date\">\n");
      out.write("                <div class=\"input-group-addon\">\n");
      out.write("                    <i class=\"fa fa-calendar\"></i>\n");
      out.write("                </div>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"evento_inicio\"  name=\"evento_inicio\" value=\"");
if (e_evento != null) {
                        out.print(e_evento.getFecha_inicio());
                    }
      out.write("\">                            \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <label>Fecha fin</label>\n");
      out.write("            <div class=\"input-group date\">\n");
      out.write("                <div class=\"input-group-addon\">\n");
      out.write("                    <i class=\"fa fa-calendar\"></i>\n");
      out.write("                </div>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"evento_fin\"  name=\"evento_fin\" value=\"");
if (e_evento != null) {
                        out.print(e_evento.getFecha_fin());
                    }
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"form-group\" >\n");
      out.write("            <label>Detalle</label>\n");
      out.write("            <textarea class=\"form-control\" rows=\"3\" id=\"evento_detalle\"  name=\"evento_detalle\">");
if (e_evento != null) {
                    out.print(e_evento.getDetalle());
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $('#evento_inicio').datepicker({\n");
      out.write("            autoclose: true,\n");
      out.write("            language: 'es'\n");
      out.write("        });\n");
      out.write("        $('#evento_fin').datepicker({\n");
      out.write("            autoclose: true,\n");
      out.write("            language: 'es'\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $('.form_evento_guardar').bootstrapValidator({\n");
      out.write("            message: 'Este valor no es valido',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                evento_nombre: {\n");
      out.write("                    message: 'El nombre no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El nombre no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 6,\n");
      out.write("                            max: 200,\n");
      out.write("                            message: 'El Nombre tiene que ser mas de 6 y menos de 200 caracteres'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                evento_inicio: {\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Fecha es requerido. '\n");
      out.write("                        },\n");
      out.write("                        date: {\n");
      out.write("                            format: 'DD/MM/YYYY',\n");
      out.write("                            message: 'La fecha no es valida.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                evento_fin: {\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Fecha es requerido. '\n");
      out.write("                        },\n");
      out.write("                        date: {\n");
      out.write("                            format: 'DD/MM/YYYY',\n");
      out.write("                            message: 'La fecha no es valida.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                evento_detalle: {\n");
      out.write("                    message: 'El detalle no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El detalle no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 6,\n");
      out.write("                            max: 500,\n");
      out.write("                            message: 'El Nombre tiene que ser mas de 6 y menos de 500 caracteres'\n");
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
      out.write("                url: \"guardar_evento.jsp\",\n");
      out.write("                data: $(\".form_evento_guardar\").serialize(),\n");
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
