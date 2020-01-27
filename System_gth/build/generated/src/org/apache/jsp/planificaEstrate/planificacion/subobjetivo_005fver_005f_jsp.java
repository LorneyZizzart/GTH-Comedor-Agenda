package org.apache.jsp.planificaEstrate.planificacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.Plan_accion;
import Entidad.Plan_subobjetivo;
import Entidad.Login_Entidad;

public final class subobjetivo_005fver_005f_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Plan_subobjetivoController verSubObjetivos = null;
      synchronized (_jspx_page_context) {
        verSubObjetivos = (Controlador.Plan_subobjetivoController) _jspx_page_context.getAttribute("verSubObjetivos", PageContext.PAGE_SCOPE);
        if (verSubObjetivos == null){
          verSubObjetivos = new Controlador.Plan_subobjetivoController();
          _jspx_page_context.setAttribute("verSubObjetivos", verSubObjetivos, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Plan_accionController verPlanes = null;
      synchronized (_jspx_page_context) {
        verPlanes = (Controlador.Plan_accionController) _jspx_page_context.getAttribute("verPlanes", PageContext.PAGE_SCOPE);
        if (verPlanes == null){
          verPlanes = new Controlador.Plan_accionController();
          _jspx_page_context.setAttribute("verPlanes", verPlanes, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
    String subobjetivo_id = request.getParameter("id").replace(" ", "+");
    subobjetivo_id = _encript.ValorADesencriptar(subobjetivo_id);
    Plan_subobjetivo sub = new Plan_subobjetivo();
    sub = null;
    HttpSession sesionmenus = request.getSession();

    sub = verSubObjetivos.GetSubobjetivobyId(Integer.parseInt(subobjetivo_id));

    List<Plan_accion> planes = new ArrayList<Plan_accion>();
    planes = verPlanes.GetAllPlan_accionBySubobjetivo_id(Integer.parseInt(subobjetivo_id));


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"row\">\n");
      out.write("    <div class=\"col-xs-12\">            \n");
      out.write("        <div class=\"box box-purple\">\n");
      out.write("            <div class=\"box-header\">   \n");
      out.write("                <h3 class=\"box-title\">Planes de Acción</h3>\n");
      out.write("                <a href=\"#\" class=\"btn-purple btn-right_nivel planaccion_crear\" data-id=\"");
      out.print(sub.getPlan_subobjetivo_id());
      out.write("\" data-toggle=\"tooltip\" title=\"Añadir Plan de Acción\"><i class=\"fa fa-plus\"></i></a>                       \n");
      out.write("            </div>\n");
      out.write("            <div class=\"box-body\">\n");
      out.write("                <dl class=\"dl-horizontal\">\n");
      out.write("                    <dt>Subobjetivo</dt>\n");
      out.write("                    <dd>");
      out.print(sub.getTitulo());
      out.write("</dd>\n");
      out.write("                    <dt>Descripción</dt>\n");
      out.write("                    <dd>");
      out.print(sub.getDescripcion());
      out.write("</dd>                                                         \n");
      out.write("                </dl>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box-header -->\n");
      out.write("\n");
      out.write("            <div class=\"box-body table-responsive\">\n");
      out.write("                <h4>Lista Planes de Acción</h4>\n");
      out.write("                <table id=\"table_planaccion\" class=\"table table-bordered table-striped\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>#</th>\n");
      out.write("                            <th>Título</th>                                 \n");
      out.write("                            <th>Contexto Institucional</th>\n");
      out.write("                            <th style=\"width:70px\">Matriz</th>\n");
      out.write("                            <th>Archivos</th>\n");
      out.write("                            <th>Criterio</th>\n");
      out.write("                            <th style=\"width:70px\">Opciones</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody> \n");
      out.write("                        ");

                            int cont = 0;
                            for (Plan_accion p : planes) {
                                cont++;
                                String id = _encript.ValorAEncriptar(Integer.toString(p.getPlan_accion_id()));

                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(cont);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(p.getNombre());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(p.getContexto());
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <a data-accion=\"");
      out.print(id);
      out.write("\" class=\"matriz_edita btn btn-xs btn-info edit_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Editar Matriz\"><i class=\"fa fa-edit\"></i></a>\n");
      out.write("                                <a data-accion=\"");
      out.print(id);
      out.write("\" class=\"matriz_ver btn btn-xs btn-primary edit_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Ver\"><i class=\"fa fa-search\"></i></a>  \n");
      out.write("                            </td>\n");
      out.write("                            <td><a data-accion=\"");
      out.print(id);
      out.write("\" class=\"ver_archivos btn btn-xs btn-info\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Ver archivos\"><i class=\"fa fa-file\"></i></a></td>\n");
      out.write("                            <td><label class=\"criterio_plan_Accion\" data-id=\"");
      out.print(id);
      out.write("\"> ");
 if (p.getCriterio() != null) {
                                    out.print(p.getCriterio());
                                } else {
                                    out.print("No Tiene");
                                }
      out.write("</label></td>\n");
      out.write("                            <td>\n");
      out.write("                                <a data-id=\"");
      out.print(p.getPlan_subobjetivo_id());
      out.write("\" data-accion=\"");
      out.print(id);
      out.write("\" class=\"planaccion_edita btn btn-xs btn-info\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Editar\"><i class=\"fa fa-edit\"></i></a>\n");
      out.write("                                <a data-id=\"");
      out.print(p.getPlan_subobjetivo_id());
      out.write("\" data-accion=\"");
      out.print(id);
      out.write("\" class=\"planaccion_elimi btn btn-xs btn-danger\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Eliminar\"> <i class=\"fa fa-trash-o\"></i></a>                                \n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                    <tfoot>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>#</th>\n");
      out.write("                            <th>Título</th>                                 \n");
      out.write("                            <th>Contexto Institucional</th>\n");
      out.write("                            <th>Matriz</th>\n");
      out.write("                            <th>Archivos</th>\n");
      out.write("                            <th>Criterio</th>\n");
      out.write("                            <th style=\"width: 10%\">Opciones</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </tfoot>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box-body -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.box -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.col -->\n");
      out.write("</div>\n");
      out.write("<!-- /.row -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- /.row -->\n");
      out.write("<div class=\"modal fade\" id=\"crear_planificacion\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                <h4 id=\"titleModal\" class=\"modal-title\">title</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body cuerpo_registro\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.modal-content -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.modal-dialog -->\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- /.row -->\n");
      out.write("<div class=\"modal fade\" id=\"crear_matriz\">\n");
      out.write("    <div class=\"modal-dialog modal-lg\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                <h4 id=\"titleModalMatriz\" class=\"modal-title\">title</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body cuerpo_registro\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.modal-content -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.modal-dialog -->\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function formatomatriz(d, b) {\n");
      out.write("\n");
      out.write("        var fila = $('<div/>')\n");
      out.write("                .addClass('loader')\n");
      out.write("                .text(' Cargando ... ');\n");
      out.write("        $.post('../plan_accion/matriz_nuevo.jsp',\n");
      out.write("                {id_pla_ac: b},\n");
      out.write("                function (html) {\n");
      out.write("                    fila.html(html);\n");
      out.write("                    fila.removeClass('loader');\n");
      out.write("                });\n");
      out.write("        /*$.ajax({\n");
      out.write("         data: {\"id_pla_ac\": b},\n");
      out.write("         type: \"GET\",\n");
      out.write("         dataType: \"html\",\n");
      out.write("         url: \"../plan_accion/matriz_nuevo.jsp\",\n");
      out.write("         }).done(function (data, textStatus, jqXHR) {\n");
      out.write("         if (console && console.log) {\n");
      out.write("         console.log(\"La solicitud se ha completado correctamente.\");\n");
      out.write("         fila.html(data);\n");
      out.write("         }\n");
      out.write("         }).fail(function (jqXHR, textStatus, errorThrown) {\n");
      out.write("         if (console && console.log) {\n");
      out.write("         console.log(\"La solicitud a fallado: \" + textStatus);\n");
      out.write("         fila.html(\"La solicitud a fallado: \" + textStatus);\n");
      out.write("         }\n");
      out.write("         });\n");
      out.write("         fila.removeClass('loader');*/\n");
      out.write("        return fila;\n");
      out.write("    }\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(function () {\n");
      out.write("            $(\"#table_planaccion\").DataTable();\n");
      out.write("        });\n");
      out.write("        var tabless = $('#table_planaccion').DataTable();\n");
      out.write("\n");
      out.write("        $('#table_planaccion tbody').on('click', '.matriz_edita', function (e) {\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            var tr = $(this).closest('tr');\n");
      out.write("            var row = tabless.row(tr);\n");
      out.write("            var id = $(this).attr('data-accion');\n");
      out.write("\n");
      out.write("\n");
      out.write("            if (row.child.isShown()) {\n");
      out.write("                row.child.hide();\n");
      out.write("                tr.removeClass('shown');\n");
      out.write("            } else {\n");
      out.write("                row.child(formatomatriz(row.data(), id)).show();\n");
      out.write("                tr.addClass('shown');\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $(\".planaccion_crear\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModal\").html(\"Crear Plan de acción\");\n");
      out.write("            $('#crear_planificacion').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('../plan_accion/plan_accion_crear.jsp',\n");
      out.write("                    {id: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                        $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        $(\".planaccion_edita\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModal\").html(\"Editar Plan de acción\");\n");
      out.write("            $('#crear_planificacion').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('../plan_accion/plan_accion_crear.jsp',\n");
      out.write("                    {id: $(this).attr('data-id'),\n");
      out.write("                        id_pla_ac: $(this).attr('data-accion')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                        $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        $(\".planaccion_elimi\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModal\").html(\"Eliminar Plan de acción\");\n");
      out.write("            $('#crear_planificacion').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('../plan_accion/plan_accion_elimina.jsp',\n");
      out.write("                    {id: $(this).attr('data-id'),\n");
      out.write("                        id_pla_ac: $(this).attr('data-accion')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                        $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $(\".matriz_editas\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModalMatriz\").html(\"Crear Matriz\");\n");
      out.write("            $('#crear_matriz').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('../plan_accion/matriz_nuevo.jsp',\n");
      out.write("                    {\n");
      out.write("                        id_pla_ac: $(this).attr('data-accion')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                        $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $(\".matriz_ver\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModalMatriz\").html(\"Ver Matriz\");\n");
      out.write("            $('#crear_matriz').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('../plan_accion/matriz_ver.jsp',\n");
      out.write("                    {\n");
      out.write("                        id_pla_ac: $(this).attr('data-accion')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                        $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $(\".ver_archivos\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModalMatriz\").html(\"Ver Archivos\");\n");
      out.write("            $('#crear_matriz').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('../plan_accion/plan_archivos.jsp',\n");
      out.write("                    {\n");
      out.write("                        id_pla_ac: $(this).attr('data-accion')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                        $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $(\".criterio_plan_Accion\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModal\").html(\"Actualiza Criterio\");\n");
      out.write("            $('#crear_planificacion').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('../plan_accion/plan_accion_criterio.jsp',\n");
      out.write("                    {\n");
      out.write("                        id_pla_ac: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                        $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
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
