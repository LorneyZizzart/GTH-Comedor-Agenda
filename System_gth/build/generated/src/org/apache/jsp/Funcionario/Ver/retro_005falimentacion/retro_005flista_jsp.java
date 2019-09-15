package org.apache.jsp.Funcionario.Ver.retro_005falimentacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Feedback;
import java.util.ArrayList;
import java.util.List;

public final class retro_005flista_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.FeedbackController _feedback_ver = null;
      synchronized (_jspx_page_context) {
        _feedback_ver = (Controlador.FeedbackController) _jspx_page_context.getAttribute("_feedback_ver", PageContext.PAGE_SCOPE);
        if (_feedback_ver == null){
          _feedback_ver = new Controlador.FeedbackController();
          _jspx_page_context.setAttribute("_feedback_ver", _feedback_ver, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.EncriptionController _encripta = null;
      synchronized (_jspx_page_context) {
        _encripta = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encripta", PageContext.PAGE_SCOPE);
        if (_encripta == null){
          _encripta = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encripta", _encripta, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

 List<Feedback> notas = new ArrayList<Feedback>();


      out.write("\n");
      out.write("<div class=\"box-header\">\n");
      out.write("    <h3 class=\"box-title\">Lista de Retroalimentación</h3>\n");
      out.write("    <button id=\"retro_crear_new\" type=\"button\" class=\"btn-purple btn-right_nivel retro_crear_new\" data-toggle=\"modal\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"\" data-original-title=\"Añadir nivel\">\n");
      out.write("        <i class=\"fa fa-plus\"></i>\n");
      out.write("    </button>\n");
      out.write("</div>\n");
      out.write("<table class=\"table table-hover\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>#</th><th>Título</th><th>Tipo</th><th>Fecha</th><th></th><th></th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");

            int conta = 0;
            for (Feedback nota : notas) {
                conta++;
                String encripta_ = _encripta.ValorAEncriptar(Integer.toString(nota.getFeedback_id()));
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(conta);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(nota.getMotivo());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(nota.getFeedback_tipo_nombre());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(nota.getFecha_advertencia());
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <div class=\"btn-group \">\n");
      out.write("                    <a data-id=\"");
      out.print(nota.getFeedback_id());
      out.write("\" class=\"btn btn-xs btn-primary btn_editar_retro\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"\" data-original-title=\"Editar\"><i class=\"fa fa-edit\"></i></a>\n");
      out.write("                    <a data-id=\"");
      out.print(nota.getFeedback_id());
      out.write("\" class=\"btn btn-xs btn-info btn_ver_retroalimen\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"\" data-original-title=\"Ver\"><i class=\"fa fa-search\"></i></a>\n");
      out.write("                    <a data-id=\"");
      out.print(nota.getFeedback_id());
      out.write("\" class=\"btn btn-xs btn-danger btn_delimia_retro\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"\" data-original-title=Eliminar\"> <i class=\"fa fa-remove\"></i></a>\n");
      out.write("                    <a target=\"_black\" href=\"retro_alimentacion/Vista_impresion.jsp?sdgsdfdgsdfgsdfg=");
      out.print(encripta_);
      out.write("\" class=\"btn btn-xs btn-warning \" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"\" data-original-title=Imprimir\"> <i class=\"fa fa-print\"></i></a>\n");
      out.write("                </div>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"modal fade\" id=\"retro_registro\">\n");
      out.write("    <div class=\"modal-dialog modal-lg\">\n");
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
      out.write("<script>\n");
      out.write("    $(\".retro_crear_new\").on(\"click\", function (e) {\n");
      out.write("        $(\"#titleModal\").html(\"Crear Feedback\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        $('#retro_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        $.post('retro_alimentacion/form_reg_retro.jsp',\n");
      out.write("                {id: 0},\n");
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
      out.write("    });\n");
      out.write("\n");
      out.write("    $(\".btn_editar_retro\").click(function () {\n");
      out.write("        var id_retro = $(this).attr('data-id');\n");
      out.write("        $(\"#titleModal\").html(\"Editar Feedback\");\n");
      out.write("        $('#retro_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('retro_alimentacion/form_reg_retro.jsp',\n");
      out.write("                {id: id_retro},\n");
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
      out.write("    });\n");
      out.write("\n");
      out.write("    $(\".btn_ver_retroalimen\").click(function () {\n");
      out.write("        var id_retro = $(this).attr('data-id');\n");
      out.write("        $(\"#titleModal\").html(\"Ver Feedback\");\n");
      out.write("        $('#retro_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('retro_alimentacion/ver_retroalimetacion.jsp',\n");
      out.write("                {id: id_retro},\n");
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
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("    $(\".btn_delimia_retro\").click(function () {\n");
      out.write("        var id_retro = $(this).attr('data-id');\n");
      out.write("        $(\"#titleModal\").html(\"Eliminar Feedback\");\n");
      out.write("        $('#retro_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('retro_alimentacion/elimar_retroalimetacion.jsp',\n");
      out.write("                {id: id_retro},\n");
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
      out.write("    });\n");
      out.write("    $(\".btn_imprimir_retro\").click(function () {\n");
      out.write("        var id_retro = $(this).attr('data-id');\n");
      out.write("        $(\"#titleModal\").html(\"Imprimir Feedback\");\n");
      out.write("        $('#retro_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('retro_alimentacion/Vista_impresion.jsp',\n");
      out.write("                {id: id_retro},\n");
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
