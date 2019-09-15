package org.apache.jsp.Comensal.empleadoReserva;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import Entidad.C_Empleado_Reserva;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import Entidad.C_TipoComensal;
import Entidad.C_TipoComida;
import java.util.ArrayList;
import java.util.List;

public final class crearReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.C_EmpleadoReservaController _empleadoReserva = null;
      synchronized (_jspx_page_context) {
        _empleadoReserva = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("_empleadoReserva", PageContext.PAGE_SCOPE);
        if (_empleadoReserva == null){
          _empleadoReserva = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("_empleadoReserva", _empleadoReserva, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
  
    String idUsuario = request.getParameter("idUser");
    String dataStart = request.getParameter("fechaInicio");
    String dataEnd = request.getParameter("fechaFin");    
    String dataNow = request.getParameter("fechaNow");
    String diaInicio = request.getParameter("diaInicio");
    String tipoComensal = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    //para enviar la fecha y revise si existe registros
    String fecha[] = dataStart.split("/");
    //variable para obtener la fecha de hoy
    Calendar dateNow = Calendar.getInstance();
    //variable para almacenar la fecha de inicio
    Calendar Month = Calendar.getInstance();
    //variable para obtener la hora de hoy
    Date dateHora = new Date();
    String horaNow[] = dateFormat.format(dateHora).split(":");
    Date dateStart = formatter.parse(dataStart);
    Month.setTime(dateStart);
    List<C_Empleado_Reserva> reservasNow = new ArrayList<C_Empleado_Reserva>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    listaComensal = _tipoComensal.getAllTipoComensal();
    listaTipoComida = _tipoComida.getAllTipoComida();
    reservasNow = _empleadoReserva.getReservaByIdDate(Integer.parseInt(idUsuario), fecha[2]+"/"+fecha[1]+"/"+fecha[0]);
    
    for(C_TipoComensal item : listaComensal){
        if(Integer.parseInt(diaInicio) >= item.getDiaInicio() && Integer.parseInt(diaInicio) <= item.getDiaFin() && item.getEstado() == 1){
            tipoComensal = item.getNombreComensal();
        }
//        else if(dateNow.get(Calendar.MONTH) != Month.get(Calendar.MONTH)&& item.getEstado() == 1){
//            tipoComensal = item.getNombreComensal();
//        }
    }


      out.write("\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(listaTipoComida.size());
      out.write("\" name=\"lengthComida\" id=\"lengthComida\">\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idUsuario);
      out.write("\" name=\"idUsuario\" id=\"idUsuario\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(dataStart);
      out.write("\" name=\"fechaInicio\" id=\"fechaInicio\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(dataEnd);
      out.write("\" name=\"fechaFin\" id=\"fechaFin\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <p class=\" col-sm-6\">Comensal: <span class=\"badge bg-purple\">");
      out.print(tipoComensal);
      out.write("</span>  </p>    \n");
      out.write("                            <label class=\"col-sm-6\"> <input  id=\"repetir\" name=\"repetir\" type=\"checkbox\" class=\"minimal\"> Repetir en el mes </label>\n");
      out.write("                        </div> \n");
      out.write("                        <br>\n");
      out.write("                        <h4 style=\"color: #501482\" class=\"page-header\">Tipos de alimentos</h4>\n");
      out.write("                        <div class=\"form-group groupTipoAlimento\">\n");
      out.write("                            ");

                                int contador = 0;    
                                for(C_TipoComida item : listaTipoComida){
                                    contador++;
                                    String estado = "";
                                                                                                        
                                    if(item.getEstado() == 1){
                                        String horaAnticipacion[] = item.getHorasAnticipacion().split(":");
                                        String horaComida[] = item.getHora().split(":"); 
                                        
                                        for(C_Empleado_Reserva reserva : reservasNow){
                                            if(reserva.getIdTipoComida() == item.getIdTipoComida()){
                                                estado = "disabled";
                                            }
                                        }
                                        if(dataStart.equals(dataNow)){
                                            if(Integer.parseInt(horaNow[0]) > (Integer.parseInt(horaComida[0])-Integer.parseInt(horaAnticipacion[0]))){
                                                estado = "disabled";
                                            }else{
                                               estado = ""; 
                                            }
                                        }
                                        
                                
      out.write("\n");
      out.write("                                <label class=\"col-md-5\">\n");
      out.write("                                    <input ");
      out.print(estado);
      out.write(" id=\"posicion\" type=\"checkbox\" class=\"minimal posicion");
      out.print(contador);
      out.write("\"> ");
      out.print(item.getNombreComida());
      out.write("\n");
      out.write("                                </label>\n");
      out.write("                               \n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <select class=\"form-control cantidad");
      out.print(contador);
      out.write(" form-cantidad\" id=\"cantidad\" name=\"cantidad");
      out.print(item.getNombreComida());
      out.write("\" disabled>\n");
      out.write("                                      <option disabled selected=\"selected\">Cantidad</option>\n");
      out.write("                                      <option>1</option>\n");
      out.write("                                      <option>2</option>\n");
      out.write("                                      <option>3</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                              ");
 } } 
      out.write("\n");
      out.write("                        </div>  \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Observación</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"observacion\"  name=\"observacion\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cerrar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-calendar-check-o\"></i> Reservar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(document).ready(function () {\n");
      out.write("    var array = [];\n");
      out.write("    for(var i = 1; i <= $(\"#lengthComida\").val(); i++){\n");
      out.write("        array.push(i);\n");
      out.write("    }\n");
      out.write("    array.forEach(function (element){\n");
      out.write("      $('.posicion'+ element).change(function() {\n");
      out.write("            if(this.checked) {\n");
      out.write("              $('.cantidad'+element).prop(\"disabled\", false);\n");
      out.write("              $('.cantidad'+element).val(\"1\");\n");
      out.write("            } else {\n");
      out.write("              $('.cantidad'+element).prop(\"disabled\", true);\n");
      out.write("              $('.cantidad'+element).val(\"Cantidad\");\n");
      out.write("            }\n");
      out.write("       });  \n");
      out.write("    })\n");
      out.write("    \n");
      out.write("        $('.form_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                idTipoComensal: {\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El tipo de comensal es requerido'\n");
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
      out.write("                url: \"guardarReservaEmpleado.jsp\",\n");
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
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
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
