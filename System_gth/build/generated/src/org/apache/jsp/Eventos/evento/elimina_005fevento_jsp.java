package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Evento;

public final class elimina_005fevento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EventoController editarEvento = null;
      synchronized (_jspx_page_context) {
        editarEvento = (Controlador.EventoController) _jspx_page_context.getAttribute("editarEvento", PageContext.PAGE_SCOPE);
        if (editarEvento == null){
          editarEvento = new Controlador.EventoController();
          _jspx_page_context.setAttribute("editarEvento", editarEvento, PageContext.PAGE_SCOPE);
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

    Evento e_evento = new Evento();
    int evento_id = 0;

    try {
        String desencriptar = _encript.ValorADesencriptar(request.getParameter("evento_id"));
        evento_id = Integer.parseInt(desencriptar);
        e_evento = editarEvento.GetEventobyId(evento_id);
    } catch (Exception e) {
        System.err.println(" -- - " + e.getMessage());
        evento_id = 0;
        e_evento = null;
    }

    // out.print(evento_id);

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"tab-pane\" id=\"settings\">\n");
      out.write("    <form class=\"form-horizontal\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label class=\"col-sm-4 control-label\">Nombre evento</label>\n");
      out.write("\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("\n");
      out.write("                <input disabled=\"\" type=\"text\" class=\"form-control\" value=\"");
 if (e_evento != null) {
                        out.print(e_evento.getNombre_evento());
                    }
                       
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"inputEmail\" class=\"col-sm-4 control-label\">Fecha Inicio</label>\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <input disabled=\"\" type=\"text\" class=\"form-control\" value=\"");
if (e_evento != null) {
                        out.print(e_evento.getFecha_inicio());
                    }
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"inputName\" class=\"col-sm-4 control-label\">Fecha Fin</label>\n");
      out.write("\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <input disabled=\"\" type=\"text\" class=\"form-control\" value=\"");
if (e_evento != null) {
                        out.print(e_evento.getFecha_fin());
                    }
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"inputExperience\" class=\"col-sm-4 control-label\">Detalle</label>\n");
      out.write("\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <textarea disabled=\"\" class=\"form-control\">");
if (e_evento != null) {
                        out.print(e_evento.getDetalle());
                    }
      out.write("</textarea>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"box-footer\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-danger pull-right btn_desactivar\" data-id=\"");
      out.print(evento_id);
      out.write("\"><i class=\"fa fa-save\"></i> Eliminar</button>\n");
      out.write("        </div>      \n");
      out.write("        <div class=\"mensaje_desactiva\">\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("<!-- /.tab-pane -->\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".btn_desactivar\").click(function (e) {\n");
      out.write("\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("\n");
      out.write("            $.post('elimina_evento_guardar.jsp',\n");
      out.write("                    {id: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".mensaje_desactiva\").removeClass('loader');\n");
      out.write("                        $(\".mensaje_desactiva\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".mensaje_desactiva\").removeClass('loader');\n");
      out.write("                $(\".mensaje_desactiva\").html(alerta);\n");
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
