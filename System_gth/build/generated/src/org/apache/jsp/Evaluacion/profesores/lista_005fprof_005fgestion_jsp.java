package org.apache.jsp.Evaluacion.profesores;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Empleado_docente;
import java.util.ArrayList;
import java.util.List;

public final class lista_005fprof_005fgestion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Empleado_docenteController profesoresGet = null;
      synchronized (_jspx_page_context) {
        profesoresGet = (Controlador.Empleado_docenteController) _jspx_page_context.getAttribute("profesoresGet", PageContext.PAGE_SCOPE);
        if (profesoresGet == null){
          profesoresGet = new Controlador.Empleado_docenteController();
          _jspx_page_context.setAttribute("profesoresGet", profesoresGet, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');


    String gestion = request.getParameter("gestion");

    String area = "";
    try {
        area = request.getParameter("area");
    } catch (Exception e) {
        area = "0";
    }

    List<Empleado_docente> profesores = new ArrayList<Empleado_docente>();
    // out.print("Gestion " + gestion + " area " + area);
    profesores = profesoresGet.getAllDocenteByGestionArea(gestion, area);

    if (!area.equalsIgnoreCase("0")) {

      out.write("\n");
      out.write("<div class=\"box-header\">\n");
      out.write("    <h3 class=\"box-title\"></h3>\n");
      out.write("    <a href=\"#\" class=\"btn-purple btn-right_nivel mod_agregar_prof\" data-toggle=\"tooltip\" title=\"Añadir Profesor\"><i class=\"fa fa-plus\"></i></a>   \n");
      out.write("</div>\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("<table class=\"table table-hover\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>#</th>\n");
      out.write("            <th>Código</th>\n");
      out.write("            <th>Nombre</th>\n");
      out.write("            <th>Area</th>\n");
      out.write("            <th>Gestión</th>\n");
      out.write("            <th>Codigo Universidad</th>\n");
      out.write("            <th></th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");
 int cont = 0;
            for (Empleado_docente p : profesores) {
                cont++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(cont);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(p.getEmpleado_docente_id());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(p.getNombre_profesor());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(p.getNombre_unidad());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(p.getGestion());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(p.getCodigo_uab());
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <div class=\"btn-group\">\n");
      out.write("                    <a data-id=\"");
      out.print(p.getEmpleado_docente_id());
      out.write("\" class=\"formDelete btn btn-danger btn-xs button_delete_prof\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Eliminar\"> <i class=\"fa fa-trash-o\"></i></a>                                \n");
      out.write("                </div>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("<div class=\"lista_porfesores_div\"></div>\n");
      out.write("\n");
      out.write("<div class=\"modal fade\" id=\"registro_nuevo_pro\">\n");
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
      out.write("</div>    \n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(\".mod_agregar_prof\").click(function (e) {\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        var gestion = $(\".gestion\").val();\n");
      out.write("        var area = $(\".area\").val();\n");
      out.write("        $(\"#titleModal\").html(\"Añadir Profesor \");\n");
      out.write("        if (gestion == '0') {\n");
      out.write("            toastr.error(\"Seleccione Gestion.\");\n");
      out.write("            return null;\n");
      out.write("        }\n");
      out.write("        if (area == '0') {\n");
      out.write("            toastr.error(\"Seleccione Área.\");\n");
      out.write("            return null;\n");
      out.write("        }\n");
      out.write("        $('#registro_nuevo_pro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('form_agrega_prof.jsp',\n");
      out.write("                {area: area, gestion: gestion},\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("            $(\".cuerpo_registro\").html(alerta);\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('.button_delete_prof').click(function (e) {\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        var id = $(this).attr('data-id');\n");
      out.write("        $.post('elimina_prof.jsp',\n");
      out.write("                {id: id},\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".lista_porfesores_div\").html(html);\n");
      out.write("                    $(\".lista_porfesores_div\").removeClass('loader');\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".lista_porfesores_div\").removeClass('loader');\n");
      out.write("            $(\".lista_porfesores_div\").html(alerta);\n");
      out.write("        });\n");
      out.write("       \n");
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
