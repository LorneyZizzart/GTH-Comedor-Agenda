package org.apache.jsp.Comensal.tipoComida;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.C_TipoComida;

public final class editarTipoComida_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.C_TipoComidaController _tipoComida = null;
      synchronized (_jspx_page_context) {
        _tipoComida = (Controlador.C_TipoComidaController) _jspx_page_context.getAttribute("_tipoComida", PageContext.PAGE_SCOPE);
        if (_tipoComida == null){
          _tipoComida = new Controlador.C_TipoComidaController();
          _jspx_page_context.setAttribute("_tipoComida", _tipoComida, PageContext.PAGE_SCOPE);
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

    String idEncript = request.getParameter("id");
    
    int idTipoComida = 0;
    C_TipoComida tipoComida = new C_TipoComida();
    
    try {
        idTipoComida = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        tipoComida = _tipoComida.getTipoComidaById(idTipoComida);        
    }catch (Exception e) {
        idTipoComida = 0;
    }

      out.write("\n");
      out.write("         <form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("             <input type=\"hidden\" value=\"");
      out.print(idTipoComida);
      out.write("\" name=\"id\" id=\"id\">             \n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"nombre\"  name=\"nombre\" value=\"");
      out.print(tipoComida.getNombreComida());
      out.write("\">                            \n");
      out.write("                        </div>   \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Costo <span data-toggle=\"tooltip\" title=\"El sistema automaticamente expresara en bolivianos.\" class=\"badge\">!</span></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"costo\"  name=\"costo\" value=\"");
      out.print(tipoComida.getCosto());
      out.write("\">                            \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Hora de ingreso <span data-toggle=\"tooltip\" title=\"Horario de ingreso al comedor, debe ser un formato de HH:MM.\" class=\"badge\">!</span></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"hora\"  name=\"hora\" value=\"");
      out.print(tipoComida.getHora());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Color del item</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"color\"  name=\"color\" value=\"");
      out.print(tipoComida.getColor());
      out.write("\">                           \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Horas de anticipación <span data-toggle=\"tooltip\" title=\"Se restara a la hora de ingreso al comedor, debe ser un formato de HH:MM.\" class=\"badge\">!</span></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"horaAnticipacion\"  name=\"horaAnticipacion\" value=\"");
      out.print(tipoComida.getHorasAnticipacion());
      out.write("\">                            \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Detalles</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"detalle\"  name=\"detalle\">");
      out.print(tipoComida.getDetalle());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            ");

                                String select = "";
                                if(tipoComida.getEstado() > 0){
                                    select = "checked";
                                }
                            
      out.write("\n");
      out.write("                            <label> <input type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                        </div>   \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-refresh\"></i> Actualizar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("        \n");
      out.write("    <script type=\"text/javascript\">\n");
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
      out.write("                            min: 3,\n");
      out.write("                            max: 30,\n");
      out.write("                            message: 'El Nombre tiene que ser mas de 6 y menos de 30 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                costo:{\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El costo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 10,\n");
      out.write("                            message: 'El costo debe ser un valor valido.'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([0-9.\\s])+$/i,\n");
      out.write("                            message: 'La posición solo puede tener caracteres númericos del 0 en adelante.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                hora:{\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La hora no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 10,\n");
      out.write("                            message: 'La hora tiene que ser un valor valido.'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([0-9:\\s])+$/i,\n");
      out.write("                            message: 'Debe ser en formato de hora 00:00'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                horaAnticipacion:{\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La hora de anticipación no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 10,\n");
      out.write("                            message: 'La hora tiene que ser un valor valido.'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([0-9:\\s])+$/i,\n");
      out.write("                            message: 'Debe ser en formato de hora 00:00'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                color:{\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El color no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 20,\n");
      out.write("                            message: 'El color tiene que ser un valor valido.'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([0-9a-zA-z#\\s])+$/i,\n");
      out.write("                            message: 'El color tiene que contener valores validos.'\n");
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
      out.write("                url: \"guardarTipoComida.jsp\",\n");
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
      out.write("\n");
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
