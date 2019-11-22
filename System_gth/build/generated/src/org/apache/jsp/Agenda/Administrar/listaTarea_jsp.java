package org.apache.jsp.Agenda.Administrar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_EstadoTarea;
import java.util.ArrayList;
import java.util.List;
import Entidad.A_Tarea;

public final class listaTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_EstadoTareaController _estado = null;
      synchronized (_jspx_page_context) {
        _estado = (Controlador.A_EstadoTareaController) _jspx_page_context.getAttribute("_estado", PageContext.PAGE_SCOPE);
        if (_estado == null){
          _estado = new Controlador.A_EstadoTareaController();
          _jspx_page_context.setAttribute("_estado", _estado, PageContext.PAGE_SCOPE);
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

    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
    int idRepeat = Integer.parseInt(request.getParameter("idRepeat"));
    String dateStart =  request.getParameter("fi");
    String dateEnd =  request.getParameter("ff");
    List<A_Tarea> lista = new ArrayList<A_Tarea>();
    List<A_EstadoTarea> listaEstado = new ArrayList<A_EstadoTarea>();
    if(idRepeat == 8){
       lista = _tarea.getGroupTareaByUser(idUsuario);
    }else{
       listaEstado = _estado.getAllEstadoTarea();
       lista = _tarea.getAllTarea(idUsuario, idRepeat, dateStart, dateEnd);
    }
    


      out.write("\n");
      out.write("    <div class=\"col-xs-12\">            \n");
      out.write("            <div class=\"box box-purple\">\n");
      out.write("                <div class=\"box-header\">\n");
      out.write("                    <h3 class=\"box-title\">Lista de Tareas</h3>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box-header -->\n");
      out.write("                <div class=\"box-body table-responsive\">\n");
      out.write("                    <table id=\"example1\" class=\"display table table-bordered table-striped\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th style=\"width: 3%\">#</th>\n");
      out.write("                                <th style=\"width: 20%\">Titulo</th>\n");
      out.write("                                ");

                                    if(idRepeat==8){
                                
      out.write("\n");
      out.write("                                <th style=\"width: 60%\">Repetición</th>\n");
      out.write("                                <th style=\"width: 7%\">Fecha de registro</th>                                 \n");
      out.write("                                ");

                                    }else{
                                
      out.write("\n");
      out.write("                                \n");
      out.write("                                <th style=\"width: 8%\">Repetición</th>\n");
      out.write("                                <th style=\"width: 10%\">Fecha</th> \n");
      out.write("                                <th style=\"width: 14%\">Estado</th>\n");
      out.write("                                \n");
      out.write("                                ");

                                    }
                                
      out.write("  \n");
      out.write("                                <th style=\"width: 10%\">Opciones</th>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
  int contador = 0;
                                  if(idRepeat==8){
                                      for (A_Tarea item : lista) {
                                          contador++;
                            
      out.write("\n");
      out.write("                            <tr >\n");
      out.write("                                <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                                <td class=\"text-left\" ><a data-id=\"");
      out.print(item.getTitulo());
      out.write('%');
      out.print(idUsuario);
      out.write('%');
      out.print(2);
      out.write("\" class=\"verTarea\" style=\"cursor:pointer;\">");
      out.print(item.getTitulo());
      out.write("</a></td>   \n");
      out.write("                                <td>");
      out.print( item.getNombreRepeticion());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( item.getFechaRegistroTarea());
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\">\n");
      out.write("                                    <div class=\"btn-group \">\n");
      out.write("                                        <a data-id=\"");
      out.print(item.getTitulo());
      out.write('%');
      out.print(idUsuario);
      out.write("\" class=\"formProcess btn btn-xs btn-primary\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Procesos\"><i class=\"fa fa-plus\"></i></a>                                  \n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                      }} else{
                                    for (A_Tarea item : lista) {
                                    contador++;
                                    String color = "rgba(255, 235, 59, 0.3)";
                                    if(item.getIdEstadoTarea() == 2 ){
                                        color = "rgba(76, 175, 80, 0.3)";
                                    }else if(item.getIdEstadoTarea() == 6){
                                        color = "rgba(233, 30, 99, 0.3)";
                                    }  
                                    //posible
//                                    String color = "rgba(255, 235, 59, 0.1)";
//                                    if(item.getIdEstadoTarea() == 2 ){
//                                        color = "rgba(76, 175, 80, 0.1)";
//                                    }else if(item.getIdEstadoTarea() == 6){
//                                        color = "rgba(233, 30, 99, 0.1)";
//                                    } 
                                    //--posible
                            
      out.write("\n");
      out.write("                            <tr id=\"");
      out.print(item.getIdTarea());
      out.write("\" style=\"background: ");
      out.print(color);
      out.write("\">\n");
      out.write("                                <td>");
      out.print(contador);
      out.write("<input type=\"hidden\" name=\"posicion_celda\" value=\"");
      out.print(contador);
      out.write("\" class=\"posicion_celda\"></td>\n");
      out.write("                                <td><a data-id=\"");
      out.print(item.getTitulo());
      out.write('%');
      out.print(idUsuario);
      out.write('%');
      out.print(1);
      out.write("\" class=\"verTarea\" style=\"cursor:pointer;\">");
      out.print(item.getTitulo());
      out.write("</a></td>                         \n");
      out.write("\n");
      out.write("                                <td>");
      out.print( item.getNombreRepeticion());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(String.valueOf(item.getFechaInicio()));
      out.write(' ');
      out.print(item.getHoraInicio());
      out.write("</td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");

                                      for(A_EstadoTarea e : listaEstado){
                                          if(e.getIdEstadoTarea()==item.getIdEstadoTarea()){                                              
                                          
      out.write("\n");
      out.write("                                             ");
      out.print(e.getNombreEstadoTarea());
      out.write("                 \n");
      out.write("                                  ");
 }}  
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"text-center\">\n");
      out.write("                                    <div class=\"btn-group \">\n");
      out.write("                                        <a data-id=\"");
      out.print(item.getTitulo());
      out.write('%');
      out.print(idUsuario);
      out.write("\" class=\"formProcess btn btn-xs btn-primary\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Procesos\"><i class=\"fa fa-plus\"></i></a>                             \n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
          
                                  }}
                            
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                        <tfoot>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Titulo</th>\n");
      out.write("                                ");

                                    if(idRepeat==8){
                                
      out.write("\n");
      out.write("                                <th>Repetición</th>\n");
      out.write("                                <th>Fecha de registro</th>                                 \n");
      out.write("                                ");

                                    }else{
                                
      out.write("\n");
      out.write("                                <th>Repetición</th>\n");
      out.write("                                <th>Fecha</th> \n");
      out.write("                                <th>Estado</th>                                \n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                                <th>Opciones</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </tfoot>\n");
      out.write("                    </table>\n");
      out.write("                         \n");
      out.write("                </div>\n");
      out.write("                <!-- /.box-body -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box -->\n");
      out.write("    </div>\n");
      out.write("                                <div class=\"mensajes\" ></div>\n");
      out.write("\n");
      out.write("    <div class=\"modal fade\" id=\"formulario_registro\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                    <h4 id=\"titleModal\" class=\"modal-title\">title</h4>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"modelViewTarea\" class=\"modal-body cuerpo_registro\"></div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.modal-content -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.modal-dialog -->\n");
      out.write("    </div>\n");
      out.write("                            \n");
      out.write("<script>\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        \n");
      out.write("        $('.formNuevo').tooltip({ boundary: 'window' })\n");
      out.write("        $('#example').tooltip({ boundary: 'window' })\n");
      out.write("        \n");
      out.write("        $('#example1').DataTable( {\n");
      out.write("        initComplete: function () {\n");
      out.write("            this.api().columns().every( function () {\n");
      out.write("                var column = this;\n");
      out.write("                var select = $('<select><option value=\"\"></option></select>')\n");
      out.write("                    .appendTo( $(column.footer()).empty() )\n");
      out.write("                    .on( 'change', function () {\n");
      out.write("                        var val = $.fn.dataTable.util.escapeRegex(\n");
      out.write("                            $(this).val()\n");
      out.write("                        );\n");
      out.write(" \n");
      out.write("                        column\n");
      out.write("                            .search( val ? '^'+val+'$' : '', true, false )\n");
      out.write("                            .draw();\n");
      out.write("                    } );\n");
      out.write(" \n");
      out.write("                column.data().unique().sort().each( function ( d, j ) {\n");
      out.write("                    select.append( '<option value=\"'+d+'\">'+d+'</option>' )\n");
      out.write("                } );\n");
      out.write("            } );\n");
      out.write("        }\n");
      out.write("        } );\n");
      out.write("       \n");
      out.write("    } );\n");
      out.write("    \n");
      out.write("    $(\".formProcess\").click(function (e) {\n");
      out.write("        $(\"#formulario_registro #modelViewTarea\").removeClass(\"modelViewTarea\");\n");
      out.write("        $(\".modal-dialog\").removeClass(\"modalTarea\");\n");
      out.write("        $(\"#titleModal\").html(\"Procesos\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            \n");
      out.write("            localStorage.setItem(\"idTarea\", $(this).attr('data-id'));\n");
      out.write("            \n");
      out.write("            $.post('procesosTarea.jsp',\n");
      out.write("            {id: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $(\".verTarea\").click(function (e){\n");
      out.write("        $(\".modal-dialog\").addClass(\"modalTarea\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        $(\"#titleModal\").html(\"Tarea\");\n");
      out.write("        $(\"#formulario_registro #modelViewTarea\").addClass('modelViewTarea');\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        $.post('verTarea.jsp',\n");
      out.write("            {id: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            }); \n");
      out.write("        \n");
      out.write("    });\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write(" \n");
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