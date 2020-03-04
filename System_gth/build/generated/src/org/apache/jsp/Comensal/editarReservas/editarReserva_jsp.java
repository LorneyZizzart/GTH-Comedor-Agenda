package org.apache.jsp.Comensal.editarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.C_TipoComensal;
import Entidad.C_Empleado_Reserva;

public final class editarReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.C_EmpleadoReservaController _empleadoReserva = null;
      synchronized (_jspx_page_context) {
        _empleadoReserva = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("_empleadoReserva", PageContext.PAGE_SCOPE);
        if (_empleadoReserva == null){
          _empleadoReserva = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("_empleadoReserva", _empleadoReserva, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_TipoComensalesController _tipoComensal = null;
      synchronized (_jspx_page_context) {
        _tipoComensal = (Controlador.C_TipoComensalesController) _jspx_page_context.getAttribute("_tipoComensal", PageContext.PAGE_SCOPE);
        if (_tipoComensal == null){
          _tipoComensal = new Controlador.C_TipoComensalesController();
          _jspx_page_context.setAttribute("_tipoComensal", _tipoComensal, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String[] idReserva = request.getParameter("id").split("%");
    if(Integer.parseInt(idReserva[1]) == 1){
        empleadoReserva = _empleadoReserva.getReservaEmpleadoById(Integer.parseInt(idReserva[0]));
    }else{
        empleadoReserva = _empleadoReserva.getReservaExternoById(Integer.parseInt(idReserva[0]));
    }

    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaComensal = _tipoComensal.getAllTipoComensal();

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(idReserva[0]);
      out.write('%');
      out.print(idReserva[1]);
      out.write("\" name=\"idReserva\" id=\"idReserva\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre completo: </label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" value=\"");
      out.print(empleadoReserva.getNombreEmpleado());
      out.write("\">                            \n");
      out.write("                        </div>                          \n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Teléfono</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" value=\"");
      out.print(empleadoReserva.getTelefono());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                                <label >Tipo de comensal:</label>\n");
      out.write("                                   <select id=\"idTipoCo\" name=\"idTipoCo\" class=\"form-control selectComensal\" data-placeholder=\"Selelcione una opción\"\n");
      out.write("                                        style=\"width: 100%;\">\n");
      out.write("                                  ");
                                        
                                    for(C_TipoComensal item : listaComensal){
                                        String select = "";
                                        String disabled = "";
                                        if(item.getTipoComensal_id() == empleadoReserva.getIdTipoComensal()){ 
                                            select = "Selected";
                                        }
                                        if(item.getEstado() == 0){
                                            disabled = "disabled";
                                        }
                                        
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getTipoComensal_id());
      out.write('"');
      out.write(' ');
      out.print(select);
      out.write(' ');
      out.print(disabled);
      out.write('>');
      out.print(item.getNombreComensal());
      out.write("</option>\n");
      out.write("                                    ");

                                        
                                    }
                                  
      out.write("\n");
      out.write("                                </select> \n");
      out.write("                                \n");
      out.write("                              </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Observación</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"observacion\"  name=\"observacion\">");
      out.print(empleadoReserva.getObservacion());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Cantidad</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"cantidad\"  name=\"cantidad\" value=\"");
      out.print(empleadoReserva.getCantidad());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Descuento adicional <span data-toggle=\"tooltip\" title=\"El sistema automaticamente expresara en bolivianos.\" class=\"badge\">!</span></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"descuentoAdicional\"  name=\"descuentoAdicional\" value=\"");
      out.print(empleadoReserva.getDescuentoAdicional());
      out.write("\">  \n");
      out.write("                        </div>   \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
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
      out.write("                cantidad:{\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El cantidad no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        integer: {\n");
      out.write("                            message: 'Debe introducir un valor entero.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                descuentoAdicional:{\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El descuento no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 10,\n");
      out.write("                            message: 'El descuento debe ser un valor valido.'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([0-9.\\s])+$/i,\n");
      out.write("                            message: 'El descuento solo puede tener caracteres númericos del 0 en adelante.'\n");
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
      out.write("                url: \"guardarActulizacionReserva.jsp\",\n");
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
