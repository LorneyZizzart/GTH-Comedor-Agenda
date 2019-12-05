package org.apache.jsp.Agenda.calendario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_Tarea;

public final class verTareaPersonal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String id = request.getParameter("id");
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaPersonalById(Integer.parseInt(id));
    

      out.write("\n");
      out.write("<div class=\"box-header text-center\" >\n");
      out.write("     <h4 class=\"box-title\" style=\"font-weight: bold\">");
      out.print(tarea.getTitulo());
      out.write("</h4>\n");
      out.write("</div>\n");
      out.write("<div class=\"box-body text-justify\" >\n");
      out.write("    <p>");
      out.print(tarea.getDescripcion());
      out.write("</p>\n");
      out.write("</div>\n");
      out.write("<div class=\"box-footer\">\n");
      out.write("        <a data-id=\"");
      out.print(id);
      out.write("\" type=\"button\" class=\"btnEliminar btn btn-danger pull-left\" ><i class=\"fa fa-trash\"></i> Eliminar</a>\n");
      out.write("        <a data-id=\"");
      out.print(id);
      out.write("\" type=\"button\" class=\"btnEditar btn btn-primary pull-right\"><i class=\"fa fa-edit\"></i> Modificar</a>\n");
      out.write("</div> \n");
      out.write("<div  id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(\".btnEliminar\").click(function () {\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('eliminarTarea.jsp',\n");
      out.write("                    {id: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("    $(\".btnEditar\").click(function (e){\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        $(\"#titleModal\").html(\"Editar nota personal\");\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        $.post('editarTarea.jsp',\n");
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
