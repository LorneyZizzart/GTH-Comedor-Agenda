package org.apache.jsp.Evaluacion.profesores;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Empleado_docente;
import java.util.ArrayList;
import java.util.List;

public final class form_005fagrega_005fprof_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String gestion_ = request.getParameter("gestion");
    String area_ = request.getParameter("area");
    List<Empleado_docente> empleados = new ArrayList<Empleado_docente>();
    empleados = profesoresGet.getAllEmpleadoByGestionArea(gestion_, area_);


      out.write("\n");
      out.write("<form class=\"form-horizontal\">\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label class=\"col-sm-3 control-label\">Buscar</label>\n");
      out.write("        <div class=\"col-sm-9\">\n");
      out.write("            <select class=\"form-control select2 idEmpleado\" name='idEmpleado' id='idEmpleado' style=\"width: 100%;\">\n");
      out.write("                <option value=\"0\">- Seleccionar -</option>\n");
      out.write("                ");
 for (Empleado_docente e : empleados) {
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(e.getEmpleado_docente_id());
      out.write('"');
      out.write('>');
      out.print(e.getNombre_profesor());
      out.write("</option>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");

        if (area_.equalsIgnoreCase("1")) {
    
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label for=\"inputPassword3\" class=\"col-sm-3 control-label\">Codigo Sistema Académico</label>\n");
      out.write("        <div class=\"col-sm-9\">\n");
      out.write("            <input type=\"text\" class=\"form-control codigo_univ\" id=\"codigo_univ\" placeholder=\"Codigo UAB\" value=\"\">\n");
      out.write("        </div>\n");
      out.write("    </div>  \n");
      out.write("    <script>\n");
      out.write("        $('.idEmpleado').change(function () {\n");
      out.write("            var id_empleado = $(this).val();\n");
      out.write("\n");
      out.write("            $.post('trae_codigouab.jsp',\n");
      out.write("                    {id_empleado: id_empleado},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".mensaje_anade_prof\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".mensaje_anade_prof\").removeClass('loader');\n");
      out.write("                $(\".mensaje_anade_prof\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("    ");

    } else {
    
      out.write("\n");
      out.write("    <input type=\"hidden\" class=\"codigo_univ\" id=\"codigo_univ\" value=\"-\">\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-purple btn_aniade_profesor\">Guardar</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"mensaje_anade_prof\"></div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('.btn_aniade_profesor').click(function (e) {\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        var empleado_id = $('.idEmpleado').val();\n");
      out.write("        var codigo_univ = $('.codigo_univ').val();\n");
      out.write("        var gestion = '");
      out.print(gestion_);
      out.write("';\n");
      out.write("        var area = '");
      out.print(area_);
      out.write("';\n");
      out.write("        if (empleado_id === '0') {\n");
      out.write("            toastr.error(\"Seleccione profesor.\");\n");
      out.write("            return null;\n");
      out.write("        }\n");
      out.write("        $(\".mensaje_anade_prof\").addClass('loader');\n");
      out.write("        $(\".mensaje_anade_prof\").html(\"\");\n");
      out.write("\n");
      out.write("        $.post('form_agrega_prof_guarda.jsp',\n");
      out.write("                {empleado_id: empleado_id,\n");
      out.write("                    codigo_univ: codigo_univ,\n");
      out.write("                    gestion: gestion,\n");
      out.write("                    area: area},\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".mensaje_anade_prof\").html(html);\n");
      out.write("                    $(\".mensaje_anade_prof\").removeClass('loader');\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".mensaje_anade_prof\").removeClass('loader');\n");
      out.write("            $(\".mensaje_anade_prof\").html(alerta);\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
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
