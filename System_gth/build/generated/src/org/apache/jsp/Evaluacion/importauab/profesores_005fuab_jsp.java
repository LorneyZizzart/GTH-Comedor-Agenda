package org.apache.jsp.Evaluacion.importauab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Uni_acad_area_pre;
import Entidad.Empleado_docente;
import java.util.ArrayList;
import java.util.List;

public final class profesores_005fuab_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Empleado_docenteController profesoresGet = null;
      synchronized (_jspx_page_context) {
        profesoresGet = (Controlador.Empleado_docenteController) _jspx_page_context.getAttribute("profesoresGet", PageContext.PAGE_SCOPE);
        if (profesoresGet == null){
          profesoresGet = new Controlador.Empleado_docenteController();
          _jspx_page_context.setAttribute("profesoresGet", profesoresGet, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Uni_acad_area_preController areapreguntas = null;
      synchronized (_jspx_page_context) {
        areapreguntas = (Controlador.Uni_acad_area_preController) _jspx_page_context.getAttribute("areapreguntas", PageContext.PAGE_SCOPE);
        if (areapreguntas == null){
          areapreguntas = new Controlador.Uni_acad_area_preController();
          _jspx_page_context.setAttribute("areapreguntas", areapreguntas, PageContext.PAGE_SCOPE);
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
    profesores = profesoresGet.getAllDocenteByGestionArea(gestion, area);

    Uni_acad_area_pre area_pregunta = new Uni_acad_area_pre();
    area_pregunta = areapreguntas.GetAreaPregunta(gestion, area);

    if (!area.equalsIgnoreCase("0")) {

      out.write("\n");
      out.write("<div class=\"box-header\">\n");
      out.write("    <h3 class=\"box-title\"></h3>   \n");
      out.write("</div>\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("<p class=\"lead text-center\">");
      out.print(area_pregunta.getNombre());
      out.write(" . Gestión: ");
      out.print(area_pregunta.getGestion());
      out.write(". Puntuación sobre: ");
      out.print(area_pregunta.getPuntuacion());
      out.write("</p>\n");
      out.write("<p class=\"text-center\">\n");
      out.write("    <button type=\"button\" class=\"btn btn-purple btn_ver_preguntas\">Ver Preguntas</button>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("<table class=\"table table-hover\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>#</th>\n");
      out.write("            <th>Nombre</th>\n");
      out.write("            <th>Area</th>\n");
      out.write("            <th>Gestión</th>\n");
      out.write("            <th>Codigo Universidad</th>\n");
      out.write("            <th>Estado</th>\n");
      out.write("            <th>Importar</th>\n");
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
      out.write("            <td>");
if (p.getNota() > 0) {
                
      out.write("\n");
      out.write("                <span class=\"badge bg-green\">Importado </span></td>\n");
      out.write("                ");

                    } else {    
      out.write("\n");
      out.write("    <span class=\"badge bg-red\">No Importado </span></td>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("<td>\n");
      out.write("    <div class=\"btn-group\">\n");
      out.write("        ");
if (p.getNota() > 0) {
                
      out.write("\n");
      out.write("        <a data-id=\"");
      out.print(p.getEmpleado_docente_id());
      out.write("\" data-uab=\"");
      out.print(p.getCodigo_uab());
      out.write("\" class=\"btn btn-success btn-xs\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Importado\"> \n");
      out.write("            <i class=\"fa fa-clipboard\"></i>\n");
      out.write("        </a>                                \n");
      out.write("            ");
}else{
      out.write("\n");
      out.write("            <a data-id=\"");
      out.print(p.getEmpleado_docente_id());
      out.write("\" data-uab=\"");
      out.print(p.getCodigo_uab());
      out.write("\" class=\"btn btn-success btn-xs button_import_evaluacion\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Importar\"> \n");
      out.write("            <i class=\"fa fa-clipboard\"></i>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </a>      \n");
      out.write("    </div>\n");
      out.write("</td>\n");
      out.write("</tr>\n");

    }

      out.write("\n");
      out.write("</tbody>\n");
      out.write("</table>\n");
      out.write("<div class=\"importa_evaluacion_div\"></div>\n");
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
      out.write("    $(\".btn_ver_preguntas\").click(function (e) {\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("\n");
      out.write("        var area = '1';\n");
      out.write("        $(\"#titleModal\").html(\"Preguntas \");\n");
      out.write("\n");
      out.write("        $('#registro_nuevo_pro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('preguntas_ver.jsp',\n");
      out.write("                {area: area},\n");
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
      out.write("    $('.button_import_evaluacion').click(function (e) {\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        var docente_id = $(this).attr('data-id');\n");
      out.write("        var cod_uab = $(this).attr('data-uab');\n");
      out.write("        var area_id = '");
      out.print(area);
      out.write("';\n");
      out.write("        var gestion = '");
      out.print(gestion);
      out.write("';\n");
      out.write("        //alert(\"docente: \" + docente_id + \" area: \" + area_id + \" gestion:\" + gestion);\n");
      out.write("\n");
      out.write("        $(\".importa_evaluacion_div\").html('');\n");
      out.write("        $(\".importa_evaluacion_div\").addClass('loader');\n");
      out.write("        $.post('importa_evaluacion.jsp',\n");
      out.write("                {docente_id: docente_id,\n");
      out.write("                    area_id: area_id,\n");
      out.write("                    gestion: gestion,\n");
      out.write("                    cod_uab: cod_uab},\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".importa_evaluacion_div\").html(html);\n");
      out.write("                    $(\".importa_evaluacion_div\").removeClass('loader');\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".importa_evaluacion_div\").removeClass('loader');\n");
      out.write("            $(\".importa_evaluacion_div\").html(alerta);\n");
      out.write("        });\n");
      out.write("\n");
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
