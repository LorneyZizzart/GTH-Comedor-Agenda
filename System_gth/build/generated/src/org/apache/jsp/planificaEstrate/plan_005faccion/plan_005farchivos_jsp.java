package org.apache.jsp.planificaEstrate.plan_005faccion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Plan_accion_files;
import java.util.ArrayList;
import java.util.List;

public final class plan_005farchivos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Plan_accion_filesController get_file = null;
      synchronized (_jspx_page_context) {
        get_file = (Controlador.Plan_accion_filesController) _jspx_page_context.getAttribute("get_file", PageContext.PAGE_SCOPE);
        if (get_file == null){
          get_file = new Controlador.Plan_accion_filesController();
          _jspx_page_context.setAttribute("get_file", get_file, PageContext.PAGE_SCOPE);
        }
      }
      out.write(' ');
      out.write('\n');

    String id_pla_ac = request.getParameter("id_pla_ac").replace(" ", "+");
    id_pla_ac = _encript.ValorADesencriptar(id_pla_ac);
    //out.print(id_pla_ac);

    List<Plan_accion_files> files = new ArrayList<Plan_accion_files>();
    files = get_file.GetAllFileByPlanacionid(Integer.parseInt(id_pla_ac));

      out.write("\n");
      out.write("<div class=\"box-body no-padding\">\n");
      out.write("    <table class=\"table table-condensed\">\n");
      out.write("        <tr>\n");
      out.write("            <th style=\"width: 10px\">#</th>\n");
      out.write("            <th>Nombre</th>            \n");
      out.write("            <th></th>\n");
      out.write("        </tr>\n");
      out.write("        ");

            int conta = 0;
            for (Plan_accion_files f : files) {
                conta++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(conta);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(f.getNombre());
      out.write("</td>            \n");
      out.write("            <td style=\"width: 100px; \">\n");
      out.write("                <a data-id=\"");
      out.print(f.getPlan_accion_files_id());
      out.write("\" target=\"_blank\" href=\"../files/");
      out.print(f.getNombre_archivo());
      out.write("\" class=\"btn btn-xs btn-info\" data-toggle=\"tooltip\" title=\"Descargar\"><i class=\"fa fa-cloud-download\"></i></a>\n");
      out.write("                <a data-id=\"");
      out.print(f.getPlan_accion_files_id());
      out.write("\" class=\"file_elimi btn btn-xs btn-danger\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Eliminar\"> <i class=\"fa fa-trash-o\"></i></a>\n");
      out.write("            </td>\n");
      out.write("        </tr>  \n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<form id =\"mi_form_file\" class=\"mi_form_file\" name =\"mi_form_file\">\n");
      out.write("    <div class=\"box-body\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label class=\"col-sm-2 control-label\">Subir archivo </label>\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <input type=\"file\" name=\"file\" size=\"50\" id=\"file\" class=\"btn btn-default\"/>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-2\">\n");
      out.write("                <input type=\"submit\" value=\"Guardar Archivo\" id=\"guardar_file\" class=\"btn btn-purple guardar_file\" name=\"guardar_file\" />\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <input type=\"hidden\" name=\"id_pla_ac\" id=\"id_pla_ac\" value=\"");
      out.print(id_pla_ac);
      out.write("\">  \n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("<div class=\"loading_file\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        $(\".mi_form_file\").submit(function (evt) {\n");
      out.write("            evt.preventDefault();\n");
      out.write("            $(\".loading_file\").addClass('loader');\n");
      out.write("            var id = $('#id_pla_ac').val();\n");
      out.write("            var codigo_personal = \"10\";//$('#cod_admin').val();\n");
      out.write("            var formData = new FormData($(this)[0]);\n");
      out.write("            //var formData = $(\".mi_form_file\").serialize();\n");
      out.write("            $.ajax({\n");
      out.write("                url: '../plan_accion/upload.jsp?id=' + id + '&codigo_personal=' + codigo_personal,\n");
      out.write("                type: 'POST',\n");
      out.write("                data: formData,\n");
      out.write("                async: false,\n");
      out.write("                cache: false,\n");
      out.write("                contentType: false,\n");
      out.write("                enctype: 'multipart/form-data',\n");
      out.write("                processData: false,\n");
      out.write("                success: function (response) {\n");
      out.write("                    $(\".loading_file\").removeClass('loader');\n");
      out.write("                    $(\".loading_file\").html(response);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            return false;\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("        $(\".file_elimi\").click(function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            e.stopImmediatePropagation();\n");
      out.write("            $(\".loading_file\").addClass('loader');\n");
      out.write("\n");
      out.write("            $.post('../plan_accion/plan_archivo_elimina.jsp',\n");
      out.write("                    {id: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".loading_file\").removeClass('loader');\n");
      out.write("                        $(\".loading_file\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".loading_file\").removeClass('loader');\n");
      out.write("                $(\".loading_file\").html(alerta);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
      out.write("</script>\n");
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
