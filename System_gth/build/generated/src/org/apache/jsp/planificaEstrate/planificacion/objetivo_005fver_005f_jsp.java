package org.apache.jsp.planificaEstrate.planificacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.Login_Entidad;
import Entidad.Plan_subobjetivo;
import Entidad.Plan_objetivo;

public final class objetivo_005fver_005f_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Plan_objetivoController verPlanObjetivos = null;
      synchronized (_jspx_page_context) {
        verPlanObjetivos = (Controlador.Plan_objetivoController) _jspx_page_context.getAttribute("verPlanObjetivos", PageContext.PAGE_SCOPE);
        if (verPlanObjetivos == null){
          verPlanObjetivos = new Controlador.Plan_objetivoController();
          _jspx_page_context.setAttribute("verPlanObjetivos", verPlanObjetivos, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Plan_subobjetivoController verPlanSubObjetivos = null;
      synchronized (_jspx_page_context) {
        verPlanSubObjetivos = (Controlador.Plan_subobjetivoController) _jspx_page_context.getAttribute("verPlanSubObjetivos", PageContext.PAGE_SCOPE);
        if (verPlanSubObjetivos == null){
          verPlanSubObjetivos = new Controlador.Plan_subobjetivoController();
          _jspx_page_context.setAttribute("verPlanSubObjetivos", verPlanSubObjetivos, PageContext.PAGE_SCOPE);
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
      out.write('\n');
    String objetivo_id = request.getParameter("id").replace(" ", "+");
    objetivo_id = _encript.ValorADesencriptar(objetivo_id);
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {

    }

    Plan_objetivo plan_objetivos = new Plan_objetivo();
    plan_objetivos = verPlanObjetivos.GetplanObjetivobyId(Integer.parseInt(objetivo_id));

    List<Plan_subobjetivo> subobjetivos = new ArrayList<Plan_subobjetivo>();
    subobjetivos = verPlanSubObjetivos.GetAllSubobjeticosbyIdObjetivo(Integer.parseInt(objetivo_id));

      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\" class=\"init\">\n");
      out.write("\n");
      out.write("    td.details-control-subob {\n");
      out.write("        background: url('../../dist/img/details_open.png') no-repeat center center;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("    tr.shown td.details-control-subob {\n");
      out.write("        background: url('../../dist/img/details_close.png') no-repeat center center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<div class=\"row\">\n");
      out.write("    <div class=\"col-xs-12\">            \n");
      out.write("        <div class=\"box box-purple\">\n");
      out.write("            <div class=\"box-header\">                            \n");
      out.write("                <h3 class=\"box-title\">Subobjetivos</h3>\n");
      out.write("                <a href=\"#\" class=\"btn-purple btn-right_nivel subobjetivo_crear\" data-id=\"");
      out.print(plan_objetivos.getPlan_objetivo_id());
      out.write("\" data-toggle=\"tooltip\" title=\"Añadir Subobjetivos\"><i class=\"fa fa-plus\"></i></a>   \n");
      out.write("            </div>\n");
      out.write("            <div class=\"box-body\">\n");
      out.write("                <dl class=\"dl-horizontal\">   \n");
      out.write("                    <dt>Objetivo</dt>\n");
      out.write("                    <dd>");
      out.print(plan_objetivos.getTitulo());
      out.write("</dd>\n");
      out.write("                    <dt>Descripción</dt>\n");
      out.write("                    <dd>");
      out.print(plan_objetivos.getCreditacion());
      out.write("</dd>                            \n");
      out.write("                    <dt>Gestion</dt>\n");
      out.write("                    <dd>");
      out.print(plan_objetivos.getGestion());
      out.write("</dd>                            \n");
      out.write("                </dl>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"box-body table-responsive\">\n");
      out.write("                <h4>Lista de Subobjetivos</h4>\n");
      out.write("                <table id=\"table_sub_ob\" class=\"table table-bordered table-striped\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th></th>\n");
      out.write("                            <th>#</th>\n");
      out.write("                            <th>Título</th>                                 \n");
      out.write("                            <th>Descripción</th>\n");
      out.write("                            <th style=\"width: 10%\">Opciones</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody> \n");
      out.write("                        ");

                            int contador = 0;
                            for (Plan_subobjetivo sub : subobjetivos) {
                                contador++;
                                String id = _encript.ValorAEncriptar(Integer.toString(sub.getPlan_subobjetivo_id()));
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"details-control-subob\" data-id=\"");
      out.print(id);
      out.write("\" ></td>\n");
      out.write("                            <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(sub.getTitulo());
      out.write("</td>\n");
      out.write("                            <td>");
if (sub.getDescripcion().length() == 50) {
                                        out.print(sub.getDescripcion() + ".....");
                                    } else {
                                        out.println(sub.getDescripcion());
                                    }
                                
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <a href=\"subobjetivo_ver.jsp?id=");
      out.print(id);
      out.write("\" class=\"btn btn-xs btn-primary edit_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Ver\"><i class=\"fa fa-search\"></i></a>  \n");
      out.write("                                <a data-id=\"");
      out.print(id);
      out.write("\" class=\"subobjetivo_edita btn btn-xs btn-info edit_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Editar\"><i class=\"fa fa-edit\"></i></a>\n");
      out.write("                                <a data-id=\"");
      out.print(id);
      out.write("\" class=\"subobjetivo_elimi btn btn-xs btn-danger delete_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Eliminar\"> <i class=\"fa fa-trash-o\"></i></a>                                \n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                    <tfoot>\n");
      out.write("                        <tr>\n");
      out.write("                            <th></th>\n");
      out.write("                            <th>#</th>\n");
      out.write("                            <th>Título</th>                                 \n");
      out.write("                            <th>Descripción</th>                               \n");
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
      out.write("<div class=\"modal fade\" id=\"crear_subobjetivo\">\n");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function formato(d, b) {\n");
      out.write("\n");
      out.write("        var fila = $('<div/>')\n");
      out.write("                .addClass('loader')\n");
      out.write("                .text(' Cargando ... ');\n");
      out.write("        $.post('subobjetivo_ver_.jsp',\n");
      out.write("                {id: b},\n");
      out.write("                function (html) {\n");
      out.write("                    fila.html(html);\n");
      out.write("                    fila.removeClass('loader');\n");
      out.write("                });\n");
      out.write("        return fila;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(function () {\n");
      out.write("            $(\"#table_sub_ob\").DataTable();\n");
      out.write("        });\n");
      out.write("        var table = $('#table_sub_ob').DataTable( );\n");
      out.write("        $('#table_sub_ob tbody').on('click', 'td.details-control-subob', function (e) {\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            var tr = $(this).closest('tr');\n");
      out.write("            var row = table.row(tr);\n");
      out.write("            var id = $(this).attr('data-id');\n");
      out.write("\n");
      out.write("            if (row.child.isShown()) {\n");
      out.write("                row.child.hide();\n");
      out.write("                tr.removeClass('shown');\n");
      out.write("            } else {\n");
      out.write("                row.child(formato(row.data(), id)).show();\n");
      out.write("                tr.addClass('shown');\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        $(\".subobjetivo_crear\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModal\").html(\"Crear Subobjetivo\");\n");
      out.write("            $('#crear_subobjetivo').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('subobjetivo_crear.jsp',\n");
      out.write("                    {objetivo_id: $(this).attr('data-id')},\n");
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
      out.write("        $(\".subobjetivo_edita\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModal\").html(\"Actualizar Subobjetivo\");\n");
      out.write("            $('#crear_subobjetivo').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('subobjetivo_crear.jsp',\n");
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
      out.write("        $(\".subobjetivo_elimi\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\"#titleModal\").html(\"Eliminar Subobjetivo\");\n");
      out.write("            $('#crear_subobjetivo').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('subobjetivo_elimina.jsp',\n");
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
