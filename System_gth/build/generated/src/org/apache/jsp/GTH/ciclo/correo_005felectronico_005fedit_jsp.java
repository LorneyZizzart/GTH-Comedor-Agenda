package org.apache.jsp.GTH.ciclo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cuestionario_gestion;

public final class correo_005felectronico_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String id_cuestionario = request.getParameter("id");

      out.write('\n');
      Controlador.Cuestionario_gestionController _ciclo = null;
      synchronized (_jspx_page_context) {
        _ciclo = (Controlador.Cuestionario_gestionController) _jspx_page_context.getAttribute("_ciclo", PageContext.PAGE_SCOPE);
        if (_ciclo == null){
          _ciclo = new Controlador.Cuestionario_gestionController();
          _jspx_page_context.setAttribute("_ciclo", _ciclo, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    Cuestionario_gestion cues_gestio = new Cuestionario_gestion();
    cues_gestio = _ciclo.GetCuestionario_gestionById(Integer.parseInt(id_cuestionario));

      out.write("\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(id_cuestionario);
      out.write("\" name=\"id_save_mail_cuestioario\" id=\"id_save_mail_cuestioario\">\n");
      out.write("\n");
      out.write("<b>Tomar nota:</b> <br>Para agregar el nombre del evaluador utilice la siguinte cadena = <b>--Evaluador--</b>\n");
      out.write("<br>\n");
      out.write("Para agregar el nombre de la persona a ser evaluaod utilice la siguinte cadena =<b> --Evaluado--</b>\n");
      out.write("\n");
      out.write("<br><br>\n");
      out.write("\n");
      out.write("<form>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Título Correo:</label>\n");
      out.write("        <input type=\"text\" class=\"form-control titulo_correo\" id=\"titulo_correo\"  name=\"titulo_correo\" value=\"");
 if(cues_gestio.getTitulo_correo()!=null)out.print(cues_gestio.getTitulo_correo());
      out.write("\">                            \n");
      out.write("    </div> \n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Contenido Correo:</label>\n");
      out.write("        <textarea class=\"textarea_mail\" id=\"textarea_mail\" placeholder=\"Escriba el Correo\" style=\"width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;\">\n");
      out.write("            ");
 if(cues_gestio.getMensaje_correo()!=null)out.print(cues_gestio.getMensaje_correo());
      out.write("\n");
      out.write("        </textarea>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<div class=\"pull-right\">\n");
      out.write("    <button type=\"button\" class=\"btn btn-purple btn-sm btn-flat btn_guarda_correo\" title=\"Guardar\">Guardar</button>\n");
      out.write("</div>.\n");
      out.write("<div class = \"mensaje_guarda_correo\"></div>\n");
      out.write("<script>\n");
      out.write("    $(function () {\n");
      out.write("        $(\".textarea_mail\").wysihtml5();\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $(\".btn_guarda_correo\").click(function (e) {\n");
      out.write("        var correo_mail = $('.textarea_mail').val();\n");
      out.write("        var titulo_mail = $('.titulo_correo').val();\n");
      out.write("        var id_gestion = $('#id_save_mail_cuestioario').val();\n");
      out.write("        $(\".mensaje_guarda_correo\").html(\"\");\n");
      out.write("        $(\".mensaje_guarda_correo\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("        $.post('correo_electronico_guarda.jsp',\n");
      out.write("                {\n");
      out.write("                    id_gestion: id_gestion,\n");
      out.write("                    correo_mail: correo_mail,\n");
      out.write("                    titulo_correo: titulo_mail\n");
      out.write("                },\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".mensaje_guarda_correo\").removeClass('loader');\n");
      out.write("                    $(\".mensaje_guarda_correo\").html(html);\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".mensaje_guarda_correo\").removeClass('loader');\n");
      out.write("            $(\".mensaje_guarda_correo\").html(alerta);\n");
      out.write("        });\n");
      out.write("        return null;\n");
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
