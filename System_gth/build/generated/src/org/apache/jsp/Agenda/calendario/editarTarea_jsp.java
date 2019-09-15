package org.apache.jsp.Agenda.calendario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_Tarea;
import Entidad.A_EstadoTarea;
import Entidad.A_TipoTarea;
import Entidad.A_RepeticionTarea;
import java.util.ArrayList;
import java.util.List;

public final class editarTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_TipoTareaController _tipoTarea = null;
      synchronized (_jspx_page_context) {
        _tipoTarea = (Controlador.A_TipoTareaController) _jspx_page_context.getAttribute("_tipoTarea", PageContext.PAGE_SCOPE);
        if (_tipoTarea == null){
          _tipoTarea = new Controlador.A_TipoTareaController();
          _jspx_page_context.setAttribute("_tipoTarea", _tipoTarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
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

    String id = request.getParameter("id"); 
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_TipoTarea> listaTipoTarea = new ArrayList<A_TipoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaById(Integer.parseInt(id));
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();
    listaTipoTarea = _tipoTarea.getAllTipoTarea();

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(id);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("    <input type=\"hidden\" value=\"0\" name=\"idUsuario\" id=\"idUsuario\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(tarea.getFechaFinal());
      out.write("\" name=\"ff\" id=\"ff\">\n");
      out.write("    \n");
      out.write("    <div class=\"nav-tabs-custom\" style=\"margin-bottom: 0px;\">\n");
      out.write("            <ul class=\"nav nav-tabs\">\n");
      out.write("              <li class=\"active\"><a href=\"#tab_1\" data-toggle=\"tab\">Tab 1</a></li>\n");
      out.write("              <li><a href=\"#tab_2\" data-toggle=\"tab\">Tab 2</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"tab-content\">\n");
      out.write("              <div class=\"tab-pane active\" id=\"tab_1\">\n");
      out.write("                <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Título</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"titulo\"  name=\"titulo\" value=\"");
      out.print(tarea.getTitulo());
      out.write("\" >                            \n");
      out.write("                        </div>                                                                                                          \n");
      out.write("                        <div class=\"form-group col-md-6\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <label>Fecha incio:</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                              <input type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"datepicker1\" value=\"");
      out.print(tarea.getFechaInicio());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"bootstrap-timepicker col-md-6\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                              <label>Hora</label>\n");
      out.write("\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control timepicker\" name=\"horaInicio\" value=\"");
      out.print(tarea.getHoraInicio());
      out.write("\">\n");
      out.write("\n");
      out.write("                                <div class=\"input-group-addon\">\n");
      out.write("                                  <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <!-- /.input group -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form group -->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <label>Fecha final:</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                              <input type=\"text\" class=\"form-control pull-right\" name=\"fechaFinal\" id=\"datepicker2\" value=\"");
      out.print(tarea.getFechaFinal());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"bootstrap-timepicker col-md-6\" style=\"padding-right: 0;padding-left: 0;\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                              <label>Hora</label>\n");
      out.write("\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control timepicker\" name=\"horaFinal\" value=\"");
      out.print(tarea.getHoraFinal());
      out.write("\">\n");
      out.write("\n");
      out.write("                                <div class=\"input-group-addon\">\n");
      out.write("                                  <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <!-- /.input group -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form group -->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Repetir cada</label>\n");
      out.write("                            <select name=\"idRepeticion\"  class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                              <option disabled selected=\"selected\">Selecione una opción</option>\n");
      out.write("                              ");

                                    
                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        if(item.getEstadoRepeticion()== 1){
                                        String Seleccionar = "";    
                                    if (item.getIdRepeticionTarea() == tarea.getIdRepeticionTarea()) {
                                            Seleccionar = "Selected";
                                        }
                                    
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getIdRepeticionTarea());
      out.write('"');
      out.write(' ');
      out.print(Seleccionar);
      out.write('>');
      out.print(item.getNombreRepeticion());
      out.write("</option>\n");
      out.write("                               ");
 } } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Categoria</label>\n");
      out.write("                            <select name=\"idCategoria\"  class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                              <option disabled selected=\"selected\">Selecione una opción</option>\n");
      out.write("                              ");

                                    String Select = "";
                                    for(A_TipoTarea item : listaTipoTarea){
                                        if(item.getEstadoTipoTarea()== 1){
                                            
                                    if (item.getIdTipoTarea()== tarea.getIdTipoTarea()) {
                                            Select = "Selected";
                                        }
                                    
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getIdTipoTarea());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(item.getNombreTarea());
      out.write("</option>\n");
      out.write("                               ");
 } } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                         <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            <select name=\"idEstado\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                              <option disabled selected=\"selected\">Selecione una opción</option>\n");
      out.write("                              ");

                                    String Selec = "";
                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        if(item.getEstadoEstadoTarea()== 1){
                                            if (item.getIdEstadoTarea()== tarea.getIdEstadoTarea()) {
                                            Selec = "Selected";
                                        }
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getIdEstadoTarea());
      out.write('"');
      out.write(' ');
      out.print(Selec);
      out.write('>');
      out.print(item.getNombreEstadoTarea());
      out.write("</option>\n");
      out.write("                               ");
 } } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("              </div>\n");
      out.write("              <!-- /.tab-pane -->\n");
      out.write("              <div class=\"tab-pane\" id=\"tab_2\">\n");
      out.write("                <div class=\"box-body\">                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Color</label>\n");
      out.write("\n");
      out.write("                            <div class=\"input-group my-colorpicker2\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"color\" value=\"");
      out.print(tarea.getColor());
      out.write("\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i></i>\n");
      out.write("                              </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.input group -->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Descripción</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"15\" id=\"descripcion\"  name=\"descripcion\">");
      out.print(tarea.getDescripcion());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <ul class=\"mailbox-attachments clearfix\">\n");
      out.write("                <li>\n");
      out.write("                  <span class=\"mailbox-attachment-icon\"><i class=\"fa fa-file-word-o\"></i></span>\n");
      out.write("\n");
      out.write("                  <div class=\"mailbox-attachment-info\">\n");
      out.write("                    <a href=\"#\" class=\"mailbox-attachment-name\"><i class=\"fa fa-paperclip\"></i> CARTA JOVEN.docx</a>\n");
      out.write("                        <span class=\"mailbox-attachment-size\">\n");
      out.write("                          1,245 KB\n");
      out.write("                          <a href=\"#\" class=\"btn btn-default btn-xs pull-right\"><i class=\"fa fa-cloud-download\"></i></a>\n");
      out.write("                        </span>\n");
      out.write("                  </div>\n");
      out.write("                </li>\n");
      out.write("              </ul>\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Seleccionar archivo</label>\n");
      out.write("                            <input type=\"file\" id=\"file\"  name=\"file\"> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("              </div>\n");
      out.write("              <!-- /.tab-pane -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.tab-content -->\n");
      out.write("          </div>\n");
      out.write("    \n");
      out.write("                    \n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-left btn_eliminar\"><i class=\"fa fa-trash\"></i> Eliminar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-purple pull-right\"><i class=\"fa fa-refresh\"></i> Actualizar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                        <div id=\"mensaje\" style=\"margin: 2%;padding-bottom: 0.1%;\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        //Timepicker\n");
      out.write("    $(\".timepicker\").timepicker({\n");
      out.write("      showInputs: false\n");
      out.write("    });\n");
      out.write("        //color picker with addon\n");
      out.write("    $(\".my-colorpicker2\").colorpicker();\n");
      out.write("        //Initialize Select2 Elements\n");
      out.write("        $(\".select2\").select2();\n");
      out.write("        //Date picker\n");
      out.write("        $('#datepicker1').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("          autoclose: true\n");
      out.write("        });\n");
      out.write("        $('#datepicker2').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("          autoclose: true\n");
      out.write("        });\n");
      out.write("        $('.form_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                titulo:{\n");
      out.write("                    message: 'El nombre no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El nombre no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 3,\n");
      out.write("                            max: 30,\n");
      out.write("                            message: 'El nombre tiene que ser mas de 6 y menos de 30 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                color:{\n");
      out.write("                    message: 'El color no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El color no puede ser vacio.'\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 7,\n");
      out.write("                            max: 20,\n");
      out.write("                            message: 'El color debe contener 7 a 20 caracteres.'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([a-z0-9.,()#_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El color solo puede constar de números, #, (), comas, puntos y letras.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                descripcion:{\n");
      out.write("                    message: 'La descripción no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La descripción no puede ser vacio.'\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 5,\n");
      out.write("                            max: 500,\n");
      out.write("                            message: 'La descripción debe contener de 5 a 500 caracteres.'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'\n");
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
      out.write("                fechaFinal:{\n");
      out.write("                    message: 'La fecha final no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La fecha final no puede ser vacio.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                idCategoria:{\n");
      out.write("                    message: 'La categoria no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La categoria no puede ser vacio.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                idEstado:{\n");
      out.write("                    message: 'El estado no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El estado no puede ser vacio.'\n");
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
      out.write("                url: \"guardarTarea.jsp\",\n");
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
      out.write("            $.post('eliminarTarea.jsp',\n");
      out.write("                    {id: $(\"#id\").val()},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
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
