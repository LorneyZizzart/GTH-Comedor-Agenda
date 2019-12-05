package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.A_Tarea;

public final class procesosTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      Controlador.A_ProcedimientoTareaController _proceso = null;
      synchronized (_jspx_page_context) {
        _proceso = (Controlador.A_ProcedimientoTareaController) _jspx_page_context.getAttribute("_proceso", PageContext.PAGE_SCOPE);
        if (_proceso == null){
          _proceso = new Controlador.A_ProcedimientoTareaController();
          _jspx_page_context.setAttribute("_proceso", _proceso, PageContext.PAGE_SCOPE);
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

    String[] id = request.getParameter("id").split("%"); 
    List<A_Tarea> listaP = new ArrayList<A_Tarea>();
    listaP = _proceso.getAllProcedimientoTarea(id[0],Integer.parseInt(id[1]));

      out.write("\n");
      out.write("<div class=\"box-header\" style=\"padding: 0 0 2% 0\">\n");
      out.write("        <h3 class=\"box-title\">Lista de Procesos</h3>\n");
      out.write("        <a data-id=\"");
      out.print(request.getParameter("id"));
      out.write("\" style=\"cursor:pointer;\" class=\"formNewProcess btn-purple pull-right\" data-toggle=\"modal tooltip\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"Añadir proceso\">\n");
      out.write("                        <i class=\"fa fa-plus\"></i>\n");
      out.write("         </a>\n");
      out.write("    </div>\n");
      out.write("<div class=\"box-body table-responsive\" style=\"padding: 0px 5px 30px 5px;\">\n");
      out.write("                    <table id=\"example1\" class=\"display table table-bordered table-striped\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th style=\"width: 2%\">#</th>\n");
      out.write("                                <th style=\"width: 30%\">Nombre</th>\n");
      out.write("                                <!-- /<th style=\"width: 20%\">Descripción</th>-->\n");
      out.write("                                <th class=\"text-center\" style=\"width: 5%\">Opciones</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                int contador = 0;
                                for (A_Tarea p : listaP) {
                                    contador++;

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                                <td><a data-id=\"");
      out.print(p.getIdProcedimiento());
      out.write("\"class=\"verProceso\" style=\"cursor:pointer;\">");
      out.print(p.getNombreProcedimiento());
      out.write(" </a>    </td>                    \n");
      out.write("                                <td class=\"text-center\">\n");
      out.write("                                    <div class=\"btn-group \">\n");
      out.write("                                        <a data-id=\"");
      out.print(p.getIdProcedimiento());
      out.write('%');
      out.print(request.getParameter("id"));
      out.write("\" class=\"formEditProcess btn btn-xs btn-primary edit_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Editar\"><i class=\"fa fa-edit\"></i></a>                                \n");
      out.write("                                        <a data-id=\"");
      out.print(p.getIdProcedimiento());
      out.write('%');
      out.print(request.getParameter("id"));
      out.write("\" class=\"formDeletProcess btn btn-danger btn-xs delete_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Eliminar\"> <i class=\"fa fa-trash-o\"></i></a>                                \n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                         \n");
      out.write("                </div>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function() {\n");
      out.write("    $('.formNewProcess').tooltip({ boundary: 'window' })\n");
      out.write("    $('.formEditProcess').tooltip({ boundary: 'window' })\n");
      out.write("    $('.formDeletProcess').tooltip({ boundary: 'window' })\n");
      out.write("\n");
      out.write("} );\n");
      out.write("    \n");
      out.write("    $(\".formEditProcess\").click(function (e){\n");
      out.write("        $(\"#formulario_registro #modelViewTarea\").removeClass( \"modelViewTarea\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        $(\"#titleModal\").html(\"Editar tarea\");\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        $.post('editarProceso.jsp',\n");
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
      out.write("    $(\".verProceso\").click(function (e){\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        $(\"#titleModal\").html(\"Proceso\");\n");
      out.write("        $(\"#formulario_registro #modelViewTarea\").addClass('modelViewTarea');\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        $.post('verProceso.jsp',\n");
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
      out.write("\n");
      out.write("    $(\".formNewProcess\").click(function (e) {\n");
      out.write("        $(\"#formulario_registro #modelViewTarea\").removeClass( \"modelViewTarea\");\n");
      out.write("        $(\"#titleModal\").html(\"Nuevo proceso\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            var id = $(this).attr('data-id').split(\"%\");\n");
      out.write("            //console.log(\"title: \", id(0));\n");
      out.write("            $.post('crearProceso.jsp',\n");
      out.write("            \n");
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
      out.write("    $(\".formDeletProcess\").click(function (e){\n");
      out.write("        $(\"#formulario_registro #modelViewTarea\").removeClass( \"modelViewTarea\");\n");
      out.write("        $(\"#titleModal\").html(\"Eliminar proceso\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        \n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        \n");
      out.write("        $.post('deleteProceso.jsp',\n");
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
      out.write("            });        \n");
      out.write("    });\n");
      out.write("</script>\n");
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
