package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_ProcedimientoTarea;

public final class verProceso_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
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

    String idProceso = _encript.ValorADesencriptar(request.getParameter("id")); 
    A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
    procedimiento = _proceso.getProcedimientoById(Integer.parseInt(idProceso));

      out.write("\n");
      out.write("<div style=\" padding: 0 2% 2% 2%; border: solid 1px #d2d2d2; background-color: white;\">\n");
      out.write("    <!--titulo-->\n");
      out.write("\n");
      out.write("        <div class=\"box-header\" style=\"padding: 0;margin: 27px 0 0 0\"> \n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <h4 class=\"box-title\" style=\"font-weight: bold\">");
      out.print(procedimiento.getNombreProcedimiento());
      out.write("</h4>\n");
      out.write("            </div>\n");
      out.write("        </div>     \n");
      out.write("                <div class=\"box-body\">\n");
      out.write("                    <p>");
      out.print(procedimiento.getDescripcionProcedimiento());
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("</div>\n");
      out.write("                <div class=\"box-footer\" style=\"padding: 8px 0 0 0;background-color: #eaeaea;\">\n");
      out.write("                        <button type=\"button\" class=\"btn-purple pull-right btn-cProcess\" data-dismiss=\"modal\"><i class=\"fa fa-arrow-left\"></i> Volver</button>\n");
      out.write("                    </div>\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    $(\".btn-cProcess\").click(function (e) {\n");
      out.write("                        $(\"#formulario_registro #modelViewTarea\").removeClass( \"modelViewTarea\");\n");
      out.write("        $(\"#titleModal\").html(\"Procesos\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            \n");
      out.write("            $.post('procesosTarea.jsp',\n");
      out.write("            {id: localStorage.getItem(\"idTarea\")},\n");
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
      out.write("                    </script>");
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
