package org.apache.jsp.Comensal.empleadoReserva;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import Entidad.C_Empleado_Reserva;
import Entidad.C_TipoComensal;
import Entidad.C_TipoComida;
import java.util.ArrayList;
import java.util.List;

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
      Controlador.C_EmpleadoReservaController _reservaEmpleado = null;
      synchronized (_jspx_page_context) {
        _reservaEmpleado = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("_reservaEmpleado", PageContext.PAGE_SCOPE);
        if (_reservaEmpleado == null){
          _reservaEmpleado = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("_reservaEmpleado", _reservaEmpleado, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
  
    int idReserva = Integer.parseInt(request.getParameter("id"));
    String nombreReserva = request.getParameter("nombre");  
    String data = request.getParameter("fechaInicial");
    String dataNow = request.getParameter("fechaNow");
    String[] CantidadPlatos = new String[]{"1", "2", "3"};
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//    variable para obtener la fecha recibida
    Date dateStart = formatter.parse(data);
//    variable para obtener la fecha de hoy
    Date date = formatter.parse(dataNow);
//    variable para obtener la hora de hoy
    Date dateHora = new Date();
    String horaNow[] = dateFormat.format(dateHora).split(":");
    String tipoComensal = null;
    String estado = "";

    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    listaComensal = _tipoComensal.getAllTipoComensal();
    empleadoReserva = _reservaEmpleado.getReservaEmpleadoById(idReserva);
    for (C_TipoComensal item : listaComensal) {
        if(item.getTipoComensal_id() == empleadoReserva.getIdTipoComensal()){
            tipoComensal = item.getNombreComensal();
        }
    }
    String horaAnticipacion[] = empleadoReserva.getHorasAnticipacion().split(":");
    String horaComida[] = empleadoReserva.getHora().split(":");
//    System.out.print("HoraNow: "+Integer.parseInt(horaNow[0]));
//    System.out.print("Hora: "+(Integer.parseInt(horaComida[0])-Integer.parseInt(horaAnticipacion[0])));
    
    if(dateStart.before(date)){
        estado = "disabled";
    }else if(date.before(dateStart)){
//        falta aun validar la hora de reserva de desayuno
         estado = "";
    }else{
//        hay que comparar las fechas que sean iguales para que solo esa x la hora
         if(Integer.parseInt(horaNow[0]) > (Integer.parseInt(horaComida[0])-Integer.parseInt(horaAnticipacion[0]))){
            estado = "disabled";
         }else{
            estado = ""; 
         }
         
    }

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idReserva);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                         <div class=\"form-group\">\n");
      out.write("                            <p>Comensal: <span class=\"badge bg-purple\">");
      out.print(tipoComensal);
      out.write("</span>  </p> \n");
      out.write("                        </div> \n");
      out.write("                            <h4 style=\"color: #501482\" class=\"page-header\">Tipos de alimento</h4>\n");
      out.write("                        <div class=\"form-group groupTipoAlimento\">\n");
      out.write("\n");
      out.write("                                <label class=\"col-md-5\">\n");
      out.write("                                    <i class=\"fa fa-spoon\"></i> ");
      out.print(nombreReserva);
      out.write("\n");
      out.write("                                </label>\n");
      out.write("                                 <div class=\"form-group\">\n");
      out.write("                                    <select ");
      out.print(estado);
      out.write(" class=\"form-control form-cantidad\" id=\"cantidad\" name=\"cantidad\">\n");
      out.write("                                      <option disabled selected=\"selected\">Cantidad</option>\n");
      out.write("                                      ");

                                        for(String s : CantidadPlatos){
                                            String select = "";
                                            if(empleadoReserva.getCantidad() == Integer.parseInt(s))
                                              select = "Selected";
                                            
      out.write("\n");
      out.write("                                            <option ");
      out.print(select);
      out.write('>');
      out.print(s);
      out.write("</option>\n");
      out.write("                                        ");

                                        }
                                      
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                        </div>  <br>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Observación</label>\n");
      out.write("                            <textarea ");
      out.print(estado);
      out.write(" class=\"form-control\" rows=\"3\" id=\"observacion\"  name=\"observacion\">");
      out.print(empleadoReserva.getObservacion());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-left btn_eliminar\" ");
      out.print(estado);
      out.write("><i class=\"fa fa-trash\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\" ");
      out.print(estado);
      out.write(" ><i class=\"fa fa-refresh\"></i> Actualizar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(document).ready(function () {\n");
      out.write("    \n");
      out.write("        $('.form_guardar').bootstrapValidator({\n");
      out.write("//            SOLO VALIDA TRES TIPOS DE COMIDAS [DESAYUNO, ALMUERZO, CENA]\n");
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
      out.write("                },\n");
      out.write("                cantidad: {\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: \n");
      out.write("                    {\n");
      out.write("                        notEmpty: \n");
      out.write("                        {\n");
      out.write("                            message: 'La cantidad no puede ser vacio. '\n");
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
      out.write("                url: \"actualizarReserva.jsp\",\n");
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
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('eliminarReserva.jsp',\n");
      out.write("                    {id: $(\"#id\").val()},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
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
