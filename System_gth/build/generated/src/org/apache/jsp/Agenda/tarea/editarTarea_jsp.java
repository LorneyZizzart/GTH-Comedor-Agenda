package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_PathTarea;
import Entidad.A_Tarea;
import Entidad.A_EstadoTarea;
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
      Controlador.A_PathTareaController _path = null;
      synchronized (_jspx_page_context) {
        _path = (Controlador.A_PathTareaController) _jspx_page_context.getAttribute("_path", PageContext.PAGE_SCOPE);
        if (_path == null){
          _path = new Controlador.A_PathTareaController();
          _jspx_page_context.setAttribute("_path", _path, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String[] id = request.getParameter("id").split("%"); 
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    List<A_PathTarea> listaPath = new ArrayList<A_PathTarea>();

    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaByTitulo(id[0], Integer.parseInt(id[1]));
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();
    listaPath = _path.getAllPath(id[0], Integer.parseInt(id[1]));

      out.write("\n");
      out.write("<style>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    input[type=file] {\n");
      out.write("    opacity: 0;\n");
      out.write("    width: 100%;\n");
      out.write("    height: 100%;\n");
      out.write("    overflow: hidden;\n");
      out.write("}\n");
      out.write(" \n");
      out.write("#upload { \n");
      out.write("    width: 162px;\n");
      out.write("    height: 35px;\n");
      out.write("    color: #fff;\n");
      out.write("    background-color: #511583;\n");
      out.write("    border-color: #3b0e5f;\n");
      out.write("    padding: 6px 12px;\n");
      out.write("    font-size: 14px;\n");
      out.write("    line-height: 1.42857143;\n");
      out.write("    border-radius: 3px;\n");
      out.write("    box-shadow: none;\n");
      out.write("    border: 1px solid transparent;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"update\" name=\"proceso\" id=\"proceso\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(tarea.getIdTarea());
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(id[0]);
      out.write("\" name=\"oldTitulo\" id=\"oldTitulo\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(id[1]);
      out.write("\" name=\"idFunc\" id=\"idFunc\">\n");
      out.write("                    <div class=\"box-body\">                      \n");
      out.write("                        <div class=\" form-group\" >\n");
      out.write("                            <label>Título</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"titulo\"  name=\"titulo\" value=\"");
      out.print(tarea.getTitulo());
      out.write("\">                            \n");
      out.write("                        </div>                         \n");
      out.write("                        <div id=\"campoDescripcion\" class=\"form-group\">\n");
      out.write("                            <label>Descripción </label>\n");
      out.write("                            <textarea class=\"textarea\"  id=\"descripcion\"  name=\"descripcion\" style=\"width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;\">");
      out.print(tarea.getDescripcion());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-12\" style=\"padding: 0\">Cargar imagen </label>\n");
      out.write("                            <div class=\"col-md-8\" style=\"padding-left: 0;\">\n");
      out.write("                              <input type=\"text\" class=\"form-control col-md-10\" id=\"tituloImage\"  name=\"tituloImage\" placeholder=\"Título de la imagen\"> \n");
      out.write("                            </div>\n");
      out.write("                            <div  id=\"upload\" class=\"text-center col-md-4\">                             \n");
      out.write("                                <input style=\"position: absolute;\" name=\"file-input\" id=\"file-input\" type=\"file\" value=\"\" accept=\"image/jpg,image/jpeg,image/png,image/gif,image\"/>\n");
      out.write("                                <label><i class=\"fa fa-upload\"></i>  Subir imagen </label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"divImage\" class=\"form-group col-md-12\" style=\"margin: 10px 0 10px 0; padding: 0;\">\n");
      out.write("                              ");

                                for (A_PathTarea path : listaPath) {

                                    
      out.write("\n");
      out.write("                                  <div id=\"divimgSalida");
      out.print(path.getIdPath());
      out.write("\" class=\"col-md-2 text-center cont-image\" style=\"border: solid 1px #aba8a8; margin: 2px;padding: 0; border-radius: 5px;\">\n");
      out.write("                                        <label id=\"imgSalida\">");
      out.print(path.getNombrePath());
      out.write("</label>\n");
      out.write("                                        <a onclick=\"eliminarImagen(");
      out.print(path.getIdPath());
      out.write(")\" id=\"imgSalida");
      out.print(path.getIdPath());
      out.write("\" type=\"button\" class=\"btn-purple pull-right eliminarImage\" style=\"padding: 0px 4px;cursor:pointer;\"><i class=\"fa fa-close\"></i></a>\n");
      out.write("                                        <img id=\"imgSalida");
      out.print(path.getIdPath());
      out.write("\" width=\"100%\" height=\"100%\" src=\"../../folder_picture/Tareas/");
      out.print(path.getPathImage());
      out.write("\" />\n");
      out.write("                                    </div>\n");
      out.write("                            ");
  } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\" >\n");
      out.write("                                                       <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Repetir cada</label>\n");
      out.write("                            <select id=\"idRepeticion\" name=\"idRepeticion\"  class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                <option value=\"0\" disabled selected=\"selected\">Selecione una opción</option>\n");
      out.write("                              ");

                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        String select = "";
                                        String disabled = "";
                                        if(tarea.getIdRepeticionTarea() == item.getIdRepeticionTarea())
                                            select = "Selected";
                                        if(item.getEstadoRepeticion() != 1){
                                            disabled = "disabled";
                                        }                                       
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getIdRepeticionTarea());
      out.write('"');
      out.write(' ');
      out.print(select);
      out.write(' ');
      out.print(disabled);
      out.write('>');
      out.print(item.getNombreRepeticion());
      out.write("</option>\n");
      out.write("                               ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                            <div id=\"fechaInicio\" class=\"form-group col-md-6\" >\n");
      out.write("                            <label>Fecha incio:</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                                <input type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"datepicker1\" autocomplete=\"off\" value=\"");
      out.print(tarea.getFechaInicio());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                        </div> \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                            <div class=\"row row-days\">\n");
      out.write("                                <div class=\"form-group col-sm-1 col-day\">\n");
      out.write("                                    <label>D</label>\n");
      out.write("                                    ");

                                        String d = "";
                                        if(tarea.getDomingo() > 0){
                                            d = "checked";
                                        }
                                    
      out.write("\n");
      out.write("                                    <input type=\"checkbox\" name=\"D\" id=\"D\"  class=\"flat-red\" ");
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
      out.write("                                    <input type=\"checkbox\" name=\"L\" id=\"L\"  class=\"flat-red\" ");
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
      out.write("                                    <input type=\"checkbox\" name=\"Ma\" id=\"Ma\"  class=\"flat-red\" ");
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
      out.write("                                    <input type=\"checkbox\" name=\"Mi\" id=\"Mi\"  class=\"flat-red\" ");
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
      out.write("                                    <input type=\"checkbox\" name=\"J\" id=\"J\"  class=\"flat-red\" ");
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
      out.write("                                    <input type=\"checkbox\" name=\"V\" id=\"V\"  class=\"flat-red\" ");
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
      out.write("                                    <input type=\"checkbox\" name=\"S\" id=\"S\"  class=\"flat-red\" ");
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
      out.write("                                  <input type=\"text\" class=\"form-control timepicker\" name=\"horaInicio\" autocomplete=\"off\" ");
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
      out.write("                            <select name=\"idEstado\" class=\"form-control select2\" style=\"width: 100%;\">\n");
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
      out.write("                    \n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("                    </div>  \n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    \n");
      out.write("    var nombreFichero = 'notImage.jpg';\n");
      out.write("    var numImage = 0;\n");
      out.write("    var listaImage = [];\n");
      out.write("    \n");
      out.write("    $(function() {\n");
      out.write("    $('#file-input').change(function(e) { \n");
      out.write("      if(e != undefined){\n");
      out.write("                var f = e.target.files,\n");
      out.write("            len = f.length;\n");
      out.write("        for (var i=0;i<len;i++){\n");
      out.write("            nombreFichero = f[i].name;\n");
      out.write("        }\n");
      out.write("      addImage(e); \n");
      out.write("      }      \n");
      out.write("       \n");
      out.write("     });\n");
      out.write("\n");
      out.write("     function addImage(e){\n");
      out.write("      \n");
      out.write("      var file = e.target.files[0],\n");
      out.write("      imageType = /image.*/;\n");
      out.write("    \n");
      out.write("      if (!file.type.match(imageType))\n");
      out.write("       return;\n");
      out.write("  \n");
      out.write("      var reader = new FileReader();\n");
      out.write("      reader.onload = fileOnload;\n");
      out.write("      reader.readAsDataURL(file);\n");
      out.write("     }     \n");
      out.write("  \n");
      out.write("     function fileOnload(e) {\n");
      out.write("        $('#divImage').append('<div id=\"divimgSalida'+numImage+'\" class=\"col-md-2 text-center cont-image\" style=\"border: solid 1px #aba8a8; margin: 2px;padding: 0; border-radius: 5px;\"> \\n\\\n");
      out.write("                                <label id=\"imgSalida'+numImage+'\">'+$('#tituloImage').val()+'</label>\\n\\\n");
      out.write("                                <a onclick=\"eliminarImagen('+numImage+')\" id=\"imgSalida'+numImage+'\" type=\"button\" class=\"btn-purple pull-right eliminarImage\" style=\"padding: 0px 4px;cursor:pointer;\"><i class=\"fa fa-close\"></i></a>\\n\\\n");
      out.write("                                <img id=\"imgSalida'+numImage+'\" width=\"100%\" height=\"100%\" src=\"\" /> \\n\\\n");
      out.write("                            </div>');\n");
      out.write("      var result=e.target.result;\n");
      out.write("      $('.cont-image #imgSalida'+numImage).attr(\"src\",result);\n");
      out.write("      \n");
      out.write("//      console.log(\"result: \", result);\n");
      out.write("      listaImage.push({id:numImage, titulo:$('#tituloImage').val(), nameImage:nombreFichero, path:e});\n");
      out.write("  \n");
      out.write("//      saveImageDB($('#tituloImage').val(), nombreFichero);\n");
      out.write("\n");
      out.write("     console.log(listaImage);\n");
      out.write("     saveImage(e);\n");
      out.write("     numImage++; \n");
      out.write("     $('#tituloImage').val('');\n");
      out.write("     }\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    function saveImage(e) {        \n");
      out.write("//      PARA GUARDAR LA IMAGEN\n");
      out.write("        var formData = new FormData();\n");
      out.write("        var files = $('#file-input')[0].files[0];\n");
      out.write("//        var files = e;\n");
      out.write("\n");
      out.write("        formData.append('file',files);\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'guardarFile.jsp',\n");
      out.write("            type: 'post',\n");
      out.write("            data: formData, \n");
      out.write("            contentType: false,\n");
      out.write("            processData: false,\n");
      out.write("            success: function(data) {\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function saveImageDB(idTarea, name, path){\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'guardarFileDB.jsp',\n");
      out.write("            data:{idTarea:idTarea, name:name, path:path},\n");
      out.write("            type: 'post',\n");
      out.write("            success: function(response) {\n");
      out.write("                if (response != 0) {\n");
      out.write("//                    $(\".card-img-top\").attr(\"src\", response);\n");
      out.write("//                    cargarImagen('../../folder_picture/diagrama-de-sectores.png');\n");
      out.write("//                        cargarImagen('../../folder_picture/'+nombreFichero);\n");
      out.write("                } else {\n");
      out.write("                    alert('Formato de imagen incorrecto.');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function eliminarImagen(e){\n");
      out.write("        $(\"#divimgSalida\"+e).remove();\n");
      out.write("        \n");
      out.write("        for (var i = 0; i < listaImage.length; i++) {\n");
      out.write("            if (listaImage[i].id == e) {\n");
      out.write("              listaImage.splice(i, 1);\n");
      out.write("              break;\n");
      out.write("            }\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("       $.ajax({\n");
      out.write("            url: 'eliminarPath.jsp',\n");
      out.write("            data:{idPath:e},\n");
      out.write("            type: 'post',\n");
      out.write("            success: function(response) {}\n");
      out.write("        });     \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    $(document).ready(function () {\n");
      out.write("    //bootstrap WYSIHTML5 - text editor\n");
      out.write("    $(\".textarea\").wysihtml5();\n");
      out.write("\n");
      out.write("    //Timepicker\n");
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
      out.write("        $('#idRepeticion').on('change', function() {\n");
      out.write("            \n");
      out.write("            switch(this.value){\n");
      out.write("                case '1':\n");
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
      out.write("                    \n");
      out.write("            }\n");
      out.write("       \n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $('.form_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                titulo:{\n");
      out.write("                    message: 'El titulo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El titulo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 3,\n");
      out.write("                            max: 100,\n");
      out.write("                            message: 'El titulo tiene que ser mas de 3 y menos de 100 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El titulo solo puede constar de letras, números y guiones bajos.'\n");
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
      out.write("                            regexp: /^([-a-z/()*.,%&$#¿?¡!0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'\n");
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
      out.write("                },\n");
      out.write("                idRepeticion:{\n");
      out.write("                    message: 'La repeticón no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La repeticón no puede ser vacio.'\n");
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
