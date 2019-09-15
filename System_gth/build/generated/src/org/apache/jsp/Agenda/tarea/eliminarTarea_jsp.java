package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_Tarea;
import Entidad.A_EstadoTarea;
import Entidad.A_RepeticionTarea;
import java.util.ArrayList;
import java.util.List;

public final class eliminarTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_EstadoTareaController _estadoTarea = null;
      synchronized (_jspx_page_context) {
        _estadoTarea = (Controlador.A_EstadoTareaController) _jspx_page_context.getAttribute("_estadoTarea", PageContext.PAGE_SCOPE);
        if (_estadoTarea == null){
          _estadoTarea = new Controlador.A_EstadoTareaController();
          _jspx_page_context.setAttribute("_estadoTarea", _estadoTarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_RepeticionTareaController _repeticionTarea = null;
      synchronized (_jspx_page_context) {
        _repeticionTarea = (Controlador.A_RepeticionTareaController) _jspx_page_context.getAttribute("_repeticionTarea", PageContext.PAGE_SCOPE);
        if (_repeticionTarea == null){
          _repeticionTarea = new Controlador.A_RepeticionTareaController();
          _jspx_page_context.setAttribute("_repeticionTarea", _repeticionTarea, PageContext.PAGE_SCOPE);
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

    String id = _encript.ValorADesencriptar(request.getParameter("id")); 
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaById(Integer.parseInt(id));
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(id);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Título</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"titulo\"  name=\"titulo\" value=\"");
      out.print(tarea.getTitulo());
      out.write("\">                            \n");
      out.write("                        </div>                         \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Descripción</label>\n");
      out.write("                            <textarea disabled class=\"form-control\" rows=\"3\" id=\"descripcion\"  name=\"descripcion\">");
      out.print(tarea.getDescripcion());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Repetir cada</label>\n");
      out.write("                            <select disabled id=\"idRepeticion\" name=\"idRepeticion\"  class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"0\" disabled selected=\"selected\">Selecione una opción</option>\n");
      out.write("                              ");

                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        String select = "";
                                        if(tarea.getIdRepeticionTarea() == item.getIdRepeticionTarea())
                                            select = "Selected";
                                        if(item.getEstadoRepeticion()== 1){
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getIdRepeticionTarea());
      out.write('"');
      out.write(' ');
      out.print(select);
      out.write('>');
      out.print(item.getNombreRepeticion());
      out.write("</option>\n");
      out.write("                               ");
 } } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                            <div id=\"fechaInicio\" class=\"form-group\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <label>Fecha incio:</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                                <input disabled type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"datepicker1\" autocomplete=\"off\" value=\"");
      out.print(tarea.getFechaInicio());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                            <div class=\"row row-days\">\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>D</label>\n");
      out.write("                                    ");

                                        String d = "";
                                        if(tarea.getDomingo() > 0){
                                            d = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input disabled type=\"checkbox\" name=\"D\" id=\"D\"  class=\"flat-red\" ");
      out.print(d);
      out.write(">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>L</label>\n");
      out.write("                                    ");

                                        String l = "";
                                        if(tarea.getLunes()> 0){
                                            l = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input disabled type=\"checkbox\" name=\"L\" id=\"L\"  class=\"flat-red\" ");
      out.print(l);
      out.write(">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>M</label>\n");
      out.write("                                    ");

                                        String ma = "";
                                        if(tarea.getMartes()> 0){
                                            ma = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input disabled type=\"checkbox\" name=\"Ma\" id=\"Ma\"  class=\"flat-red\" ");
      out.print(ma);
      out.write(">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>M</label>\n");
      out.write("                                    ");

                                        String mi = "";
                                        if(tarea.getMiercoles()> 0){
                                            mi = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input disabled type=\"checkbox\" name=\"Mi\" id=\"Mi\"  class=\"flat-red\" ");
      out.print(mi);
      out.write(">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>J</label>\n");
      out.write("                                    ");

                                        String j = "";
                                        if(tarea.getJueves()> 0){
                                            j = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input disabled type=\"checkbox\" name=\"J\" id=\"J\"  class=\"flat-red\" ");
      out.print(j);
      out.write(">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>V</label>\n");
      out.write("                                    ");

                                        String v = "";
                                        if(tarea.getViernes()> 0){
                                            v = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input disabled type=\"checkbox\" name=\"V\" id=\"V\"  class=\"flat-red\" ");
      out.print(v);
      out.write(">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>S</label>\n");
      out.write("                                    ");

                                        String s = "";
                                        if(tarea.getSabado()> 0){
                                            s = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input disabled type=\"checkbox\" name=\"S\" id=\"S\"  class=\"flat-red\" ");
      out.print(s);
      out.write(">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div id=\"horaInicio\" class=\"bootstrap-timepicker\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                              <label>Hora</label>\n");
      out.write("\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                  <input disabled type=\"text\" class=\"form-control timepicker\" name=\"horaInicio\" autocomplete=\"off\" ");
      out.print(tarea.getHoraInicio());
      out.write(">\n");
      out.write("\n");
      out.write("                                <div class=\"input-group-addon\">\n");
      out.write("                                  <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <!-- /.input group -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form group -->\n");
      out.write("                        </div>\n");
      out.write("                         <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            <select  disabled name=\"idEstado\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                              <option disabled selected=\"selected\">Selecione una opción</option>\n");
      out.write("                              ");

                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        String select = "";
                                        if(tarea.getIdEstadoTarea() == item.getIdEstadoTarea())
                                            select = "Selected";
                                        if(item.getEstadoEstadoTarea()== 1){
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getIdEstadoTarea());
      out.write('"');
      out.write(' ');
      out.print(select);
      out.write('>');
      out.print(item.getNombreEstadoTarea());
      out.write("</option>\n");
      out.write("                               ");
 } } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        switch($('#idRepeticion').val()){\n");
      out.write("            case '1':\n");
      out.write("                    $(\".row-days\").hide();\n");
      out.write("                    $(\"#fechaInicio\").show();\n");
      out.write("                    $(\"#horaInicio\").hide();\n");
      out.write("                    break;\n");
      out.write("                case '2':\n");
      out.write("                    $(\"#fechaInicio\").show();\n");
      out.write("                    $(\".row-days\").hide();\n");
      out.write("                    $(\"#horaInicio\").show();\n");
      out.write("                    break;\n");
      out.write("                case '3':\n");
      out.write("                    $(\"#horaInicio\").hide();\n");
      out.write("                    $(\"#fechaInicio\").show();\n");
      out.write("                    $(\".row-days\").show();\n");
      out.write("                    break;\n");
      out.write("                case '4':\n");
      out.write("                    $(\"#horaInicio\").hide();\n");
      out.write("                    $(\".row-days\").hide();\n");
      out.write("                    $(\"#fechaInicio\").show();\n");
      out.write("                    break;\n");
      out.write("                case '5':\n");
      out.write("                    $(\"#horaInicio\").hide();\n");
      out.write("                    $(\".row-days\").hide();\n");
      out.write("                    $(\"#fechaInicio\").show();\n");
      out.write("                    break;\n");
      out.write("                case '6':\n");
      out.write("                    $(\"#horaInicio\").hide();\n");
      out.write("                    $(\".row-days\").hide();\n");
      out.write("                    $(\"#fechaInicio\").show();\n");
      out.write("                    break;\n");
      out.write("                case '7':\n");
      out.write("                    $(\"#horaInicio\").hide();\n");
      out.write("                    $(\".row-days\").hide();\n");
      out.write("                    $(\"#fechaInicio\").show();\n");
      out.write("                    break;\n");
      out.write("                default:\n");
      out.write("                    $(\".row-days\").hide();\n");
      out.write("                    $(\"#fechaInicio\").hide();\n");
      out.write("                    $(\"#horaInicio\").hide();\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("//        ocultar select multiple\n");
      out.write("        \n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('deleteTarea.jsp',\n");
      out.write("                    {id: id_menu},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
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
