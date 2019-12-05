package org.apache.jsp.planificaEstrate.planificacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Plan_objetivo;

public final class plan_005fnuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Plan_objetivoController crearPlanObjetivos = null;
      synchronized (_jspx_page_context) {
        crearPlanObjetivos = (Controlador.Plan_objetivoController) _jspx_page_context.getAttribute("crearPlanObjetivos", PageContext.PAGE_SCOPE);
        if (crearPlanObjetivos == null){
          crearPlanObjetivos = new Controlador.Plan_objetivoController();
          _jspx_page_context.setAttribute("crearPlanObjetivos", crearPlanObjetivos, PageContext.PAGE_SCOPE);
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

    String id = "";
    Plan_objetivo planob = new Plan_objetivo();
    planob = null;

    try {
        id = request.getParameter("id").replace(" ", "+");
        id = _encript.ValorADesencriptar(id);
        planob = crearPlanObjetivos.GetplanObjetivobyId(Integer.parseInt(id));

    } catch (Exception e) {
        id = "0";
    }

    // out.print(id);

      out.write("\n");
      out.write("<!-- bootstrap wysihtml5 - text editor -->\n");
      out.write("<link rel=\"stylesheet\" href=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.css\">\n");
      out.write("\n");
      out.write("<form class=\"form-horizontal form_plan_nuevo\" id=\"form_plan_nuevo\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" class=\"form-control\" id=\"plan_id\" name=\"plan_id\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("    <input type=\"hidden\" class=\"form-control\" id=\"plan_estado\" name=\"plan_estado\" value=\"1\">\n");
      out.write("    <div class=\"box-body\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label class=\"col-sm-2 control-label\">Título</label>\n");
      out.write("            <div class=\"col-sm-10\">\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"plan_titulo\" name=\"plan_titulo\" placeholder=\"Título\" value=\"");
if (planob != null) {
                        out.print(planob.getTitulo());
                    }
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label class=\"col-sm-2 control-label\">Gestión</label>\n");
      out.write("            <div class=\"col-sm-10\">\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"plan_gestion\" name=\"plan_gestion\" placeholder=\"Gestion\" value=\"");
if (planob != null) {
                        out.print(planob.getGestion());
                    }
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label class=\"col-sm-2 control-label\">Descripción</label>\n");
      out.write("            <div class=\"col-sm-10\">\n");
      out.write("                \n");
      out.write("                <textarea class=\"plan_creditacion form-control\" id=\"plan_creditacion\" name=\"plan_creditacion\" placeholder=\"Escriba la descripción\">");
if(planob!=null){out.print(planob.getCreditacion());}
      out.write("</textarea>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.box-body -->\n");
      out.write("    <div class=\"box-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("        <button type=\"submit\" class=\"btn btn-purple pull-right\">Guardar</button>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- /.box-footer -->\n");
      out.write("</form>\n");
      out.write("<div id=\"mensaje\"></div>\n");
      out.write("<script>\n");
      out.write("    $(function () {\n");
      out.write("        $(\".plan_creditacion\").wysihtml5();\n");
      out.write("    });\n");
      out.write("    $('#plan_gestion').datepicker({\n");
      out.write("        autoclose: true,\n");
      out.write("        format: \"yyyy\",\n");
      out.write("        viewMode: \"years\",\n");
      out.write("        minViewMode: \"years\"\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('.form_plan_nuevo').bootstrapValidator({\n");
      out.write("        message: 'This value is not valid',\n");
      out.write("        feedbackIcons: {\n");
      out.write("            valid: 'glyphicon glyphicon-ok',\n");
      out.write("            invalid: 'glyphicon glyphicon-remove',\n");
      out.write("            validating: 'glyphicon glyphicon-refresh'\n");
      out.write("        },\n");
      out.write("        fields: {\n");
      out.write("            plan_titulo: {\n");
      out.write("                message: 'El Título no es valido.',\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'El Título no puede ser vacio. '\n");
      out.write("                    },\n");
      out.write("                    stringLength: {\n");
      out.write("                        min: 6,\n");
      out.write("                        max: 500,\n");
      out.write("                        message: 'El Nombre tiene que ser mas de 6 y menos de 500 caracteres'\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            plan_creditacion: {\n");
      out.write("                message: 'El valor no es valido.',\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'La Creditación no puede ser vacio. '\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            plan_gestion: {\n");
      out.write("                message: 'El valor no es valido.',\n");
      out.write("                validators: {\n");
      out.write("                    notEmpty: {\n");
      out.write("                        message: 'La Creditación no puede ser vacio. '\n");
      out.write("                    },\n");
      out.write("                    integer: {\n");
      out.write("                        message: 'El valor tiene que ser número entero'\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    }).on('success.form.bv', function (e) {\n");
      out.write("        // Prevent submit form\n");
      out.write("        e.preventDefault();\n");
      out.write("        $(\"#mensaje\").show();\n");
      out.write("        $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("        var $form = $(e.target),\n");
      out.write("                validator = $form.data('bootstrapValidator');\n");
      out.write("        $.ajax({\n");
      out.write("            type: \"POST\",\n");
      out.write("            url: \"plan_estrate_guardar.jsp\",\n");
      out.write("            data: $(\".form_plan_nuevo\").serialize(),\n");
      out.write("            success: function (data)\n");
      out.write("            {\n");
      out.write("                $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                $(\"#mensaje\").html(data);\n");
      out.write("            }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                $(\"#mensaje\").html(menn);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!-- Bootstrap WYSIHTML5 -->\n");
      out.write("<script src=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.js\"></script>\n");
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
