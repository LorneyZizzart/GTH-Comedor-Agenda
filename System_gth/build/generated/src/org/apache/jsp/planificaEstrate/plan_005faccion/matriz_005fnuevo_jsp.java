package org.apache.jsp.planificaEstrate.plan_005faccion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Plan_matriz;

public final class matriz_005fnuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- bootstrap wysihtml5 - text editor -->\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">\n");
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
      Controlador.Plan_matrizController matriz_ver = null;
      synchronized (_jspx_page_context) {
        matriz_ver = (Controlador.Plan_matrizController) _jspx_page_context.getAttribute("matriz_ver", PageContext.PAGE_SCOPE);
        if (matriz_ver == null){
          matriz_ver = new Controlador.Plan_matrizController();
          _jspx_page_context.setAttribute("matriz_ver", matriz_ver, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String plan_accion_id = request.getParameter("id_pla_ac").replace(" ", "+");
    plan_accion_id = _encript.ValorADesencriptar(plan_accion_id);
    String Plan_matriz_id = "0";

    Plan_matriz matriz = new Plan_matriz();
    matriz = matriz_ver.getMatrizByPlanAccionId(Integer.parseInt(plan_accion_id));
    if (matriz != null) {
        Plan_matriz_id = Integer.toString(matriz.getPlan_matriz_id());
    }

      out.write("\n");
      out.write("<section class=\"content\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <!-- left column -->\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("            <!-- general form elements -->\n");
      out.write("            <div class=\"box box-primary\">\n");
      out.write("                <div class=\"box-header with-border\">\n");
      out.write("                    <h3 class=\"box-title\">Plan de Acción Matriz</h3>\n");
      out.write("\n");
      out.write("                    <!-- /.box-header -->\n");
      out.write("                    <!-- form start -->\n");
      out.write("                    <form class=\"form_plan_accion_nuevo\" id=\"form_plan_accion_nuevo\">\n");
      out.write("                        <input type=\"hidden\" class=\"form-control\" id=\"plan_accion_id\" name=\"plan_accion_id\" value=\"");
      out.print(plan_accion_id);
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" class=\"form-control\" id=\"plan_accion_estado\" name=\"plan_accion_estado\" value=\"1\">\n");
      out.write("                        <input type=\"hidden\" class=\"form-control\" id=\"Plan_matriz_id\" name=\"Plan_matriz_id\" value=\"");
      out.print(Plan_matriz_id);
      out.write("\">\n");
      out.write("\n");
      out.write("                        <div class=\"box-group\" id=\"accordion\">\n");
      out.write("                            <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->\n");
      out.write("                            <div class=\"panel box box-primary\">\n");
      out.write("                                <div class=\"box-header with-border\">\n");
      out.write("                                    <h4 class=\"box-title\">\n");
      out.write("                                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#quehacer\">\n");
      out.write("                                            Que hacer \n");
      out.write("                                        </a>\n");
      out.write("                                    </h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"quehacer\" class=\"panel-collapse collapse in\">\n");
      out.write("                                    <div class=\"box-body\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Que Hacer : </label>                    \n");
      out.write("                                            <textarea style=\"width: 100%\" class=\"matriz_quehacer_ form-control\" id=\"mat_quehacer\" name=\"mat_quehacer\" placeholder=\"Que hacer\">");
if (matriz != null) {
                                                    out.print(matriz.getQue_hacer());
                                                }
      out.write("</textarea>\n");
      out.write("                                        </div><br><br>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Responsable:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"mat_responsable\" id=\"mat_responsable\" placeholder=\"Responsable\" value=\"");
if (matriz != null) {
                                                    out.print(matriz.getResponsable());
                                                }
      out.write("\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"box-footer\">                                            \n");
      out.write("                                            <button type=\"button\" class=\"btn btn-purple pull-right btn-guarda-qhacer\">Guardar área</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel box box-primary\">\n");
      out.write("                                <div class=\"box-header with-border\">\n");
      out.write("                                    <h4 class=\"box-title\">\n");
      out.write("                                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#comohacer\">\n");
      out.write("                                            Como hacer\n");
      out.write("                                        </a>\n");
      out.write("                                    </h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"comohacer\" class=\"panel-collapse collapse\">\n");
      out.write("                                    <div class=\"box-body\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Como:</label>\n");
      out.write("                                            <textarea class=\"matriz_como_ form-control\" id=\"mat_como\" name=\"mat_como\" placeholder=\"Como\">");
if (matriz != null) {
                                                    out.print(matriz.getComo());
                                                }
      out.write("</textarea>                    \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Documento generado:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"mat_documento\" id=\"mat_documento\" placeholder=\"Documento generado\" value=\"");
if (matriz != null) {
                                                    out.print(matriz.getDocumento_generadi());
                                                }
      out.write("\">\n");
      out.write("                                        </div>   \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel box box-primary\">\n");
      out.write("                                <div class=\"box-header with-border\">\n");
      out.write("                                    <h4 class=\"box-title\">\n");
      out.write("                                        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#indicadorresultado\">\n");
      out.write("                                            Indicadores de Resultado\n");
      out.write("                                        </a>\n");
      out.write("                                    </h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"indicadorresultado\" class=\"panel-collapse collapse\">\n");
      out.write("                                    <div class=\"box-body\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Nombre:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"mat_indicador_nombre\" id=\"mat_indicador_nombre\" placeholder=\"Nombre\" value=\"");
if (matriz != null) {
                                                    out.print(matriz.getIndicadores_resultado());
                                                }
      out.write("\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Fecha:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"mat_fecha\" id=\"mat_fecha\" placeholder=\"Fecha\" value=\"");
if (matriz != null) {
                                                    out.print(matriz.getFecha());
                                                }
      out.write("\"></div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Indicador:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"mat_indicador\" id=\"mat_indicador\" placeholder=\"Indicador\" value=\"");
if (matriz != null) {
                                                    out.print(matriz.getIndicador());
                                                }
      out.write("\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            </di\n");
      out.write("\n");
      out.write("                            <div class=\"box-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-purple pull-right\">Guardar</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"mensaje\"></div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<!-- Bootstrap WYSIHTML5 -->\n");
      out.write("<script src=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(function () {\n");
      out.write("            $(\".matriz_como_\").wysihtml5();\n");
      out.write("            $(\".matriz_quehacer_\").wysihtml5();\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $('.form_plan_accion_nuevo').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                quehacer: {\n");
      out.write("                    message: 'Que hacer no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Que hacer no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 6,\n");
      out.write("                            max: 200,\n");
      out.write("                            message: 'Que hacer tiene que ser mas de 6 y menos de 200 caracteres'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                mat_responsable: {\n");
      out.write("                    message: 'El valor no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Responsable no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                matriz_como: {\n");
      out.write("                    message: 'Como no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Como, no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                mat_documento: {\n");
      out.write("                    message: 'Documento generado no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Documento generado no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                mat_indicador_nombre: {\n");
      out.write("                    message: 'Nombre no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Nombre no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                ,\n");
      out.write("                mat_fecha: {\n");
      out.write("                    message: 'Fecha no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Fecha no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        date: {\n");
      out.write("                            format: 'DD/MM/YYYY',\n");
      out.write("                            message: 'Fecha Invalida DD/MM/YYYY'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                mat_indicador: {\n");
      out.write("                    message: 'Indicador no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Indicador no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\".mensaje\").show();\n");
      out.write("            $(\".mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target);\n");
      out.write("            var validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"../plan_accion/matriz_nuevo_guardar.jsp\",\n");
      out.write("                data: $form.serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\".mensaje\").removeClass(\"loader\");\n");
      out.write("                    $(\".mensaje\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\".mensaje\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\".mensaje\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("        $(\".btn-guarda-qhacer\").click(function () {\n");
      out.write("            var \n");
      out.write("        });\n");
      out.write("    });\n");
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
