package org.apache.jsp.Comensal.editarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.C_TipoComida;
import Entidad.C_TipoComensal;

public final class crearReporte_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.C_TipoComidaController _tipoComida = null;
      synchronized (_jspx_page_context) {
        _tipoComida = (Controlador.C_TipoComidaController) _jspx_page_context.getAttribute("_tipoComida", PageContext.PAGE_SCOPE);
        if (_tipoComida == null){
          _tipoComida = new Controlador.C_TipoComidaController();
          _jspx_page_context.setAttribute("_tipoComida", _tipoComida, PageContext.PAGE_SCOPE);
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
 
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    listaComensal = _tipoComensal.getAllTipoComensal();

      out.write("\n");
      out.write("         <form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group col-md-6\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <label>Fecha incio:</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                              <input type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"datepicker1\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>  \n");
      out.write("                        <div class=\"form-group col-md-6\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <label>Fecha final:</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                              <input type=\"text\" class=\"form-control pull-right\" name=\"ff\" id=\"datepicker2\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label class=\"col-md-3\">Ordenar :</label>\n");
      out.write("                            <label class=\"col-md-4\"><input type=\"checkbox\" name=\"oA\" id=\"oA\"  class=\"flat-red\"> Alfabéticamente</label>\n");
      out.write("                            <label class=\"col-md-5\"><input type=\"checkbox\" name=\"oF\" id=\"oF\"  class=\"flat-red\" checked> Fecha</label>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                                <h4 style=\"color: #501482;\" class=\"page-header\"><i class=\"fa fa-user\"></i> Tipos de comensal</h4>\n");
      out.write("                                <select name=\"c\" class=\"form-control selectComensal\" multiple=\"multiple\" data-placeholder=\"Selelcione una opción\"\n");
      out.write("                                        style=\"width: 100%;\">\n");
      out.write("                                  ");

                                    for(C_TipoComensal item : listaComensal){
                                        if(item.getEstado() == 1){
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getTipoComensal_id());
      out.write('"');
      out.write('>');
      out.print(item.getNombreComensal());
      out.write("</option>\n");
      out.write("                                    ");

                                        }
                                    }
                                  
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                              </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <h4 style=\"color: #501482; margin-top: 4%;\" class=\"page-header\"><i class=\"fa fa-cutlery\"></i> Tipos de alimento</h4>\n");
      out.write("                                <select name=\"a\" class=\"form-control selectComida\" multiple=\"multiple\" data-placeholder=\"Selecione una opción\"\n");
      out.write("                                        style=\"width: 100%;\">\n");
      out.write("                                  ");

                                    for(C_TipoComida item : listaTipoComida){
                                        if(item.getEstado() == 1){
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getIdTipoComida());
      out.write('"');
      out.write('>');
      out.print(item.getNombreComida());
      out.write("</option>\n");
      out.write("                                    ");

                                        }
                                    }
                                  
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                              </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btnReport btn-purple pull-right\"><i class=\"fa fa-print\"></i> Generar Reporte</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        //Initialize Select2 Elements\n");
      out.write("        $('.selectComensal').select2();\n");
      out.write("        $('.selectComida').select2();\n");
      out.write("         //Datemask dd/mm/yyyy\n");
      out.write("        //Date picker\n");
      out.write("        $('#datepicker1').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("          autoclose: true\n");
      out.write("        });\n");
      out.write("        $('#datepicker2').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("          autoclose: true\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("         $('.form_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                fi:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                ff:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                c:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                a:{\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            e.colspan;\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            var a = document.createElement(\"a\");\n");
      out.write("                    a.target = \"_blank\";\n");
      out.write("                    a.href = \"generarReporte.jsp?\"+$(\".form_guardar\").serialize();\n");
      out.write("                    a.click();\n");
      out.write("            \n");
      out.write("        });\n");
      out.write("        \n");
      out.write("//        $(\".btnReport\").click(function () {\n");
      out.write("//            var a = document.createElement(\"a\");\n");
      out.write("//            a.target = \"_blank\";\n");
      out.write("//            a.href = \"generarReporte.jsp\";\n");
      out.write("//            a.click();\n");
      out.write("//            $.post('generarReporte.jsp',\n");
      out.write("//                  {fechaInicio : $('#datepicker1').val(),\n");
      out.write("//                   fechaFinal : $('#datepicker2').val(),\n");
      out.write("//                   tipoComensal: $('idComensal').val(),\n");
      out.write("//                   tipoComida: $('idComida').val()}\n");
      out.write("//            );\n");
      out.write("//        });\n");
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
