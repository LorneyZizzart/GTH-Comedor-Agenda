package org.apache.jsp.Funcionario.Ver.retro_005falimentacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Feedback;
import Entidad.Login_Entidad;
import Entidad.Feedback_tipo;
import java.util.ArrayList;
import java.util.List;

public final class form_005freg_005fretro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      Controlador.FeedbackController _feedback = null;
      synchronized (_jspx_page_context) {
        _feedback = (Controlador.FeedbackController) _jspx_page_context.getAttribute("_feedback", PageContext.PAGE_SCOPE);
        if (_feedback == null){
          _feedback = new Controlador.FeedbackController();
          _jspx_page_context.setAttribute("_feedback", _feedback, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    int retroalimetacion_id = 0;
    String retro_id = request.getParameter("id");
    retroalimetacion_id = Integer.parseInt(retro_id);

    //out.print(retro_id);
    HttpSession sesion = request.getSession();
    Login_Entidad DatoUsuario = new Login_Entidad();
    List<Feedback_tipo> feedbacks = new ArrayList<Feedback_tipo>();
    feedbacks = _feedback.get_All_TiposAdventendia();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    Feedback datos = new Feedback();
    try {
        datos = _feedback.Get_feedback_by_id(retroalimetacion_id);
    } catch (Exception e) {
        out.print(e.getMessage());
    }



      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<form class=\"form-horizontal form_create_retoralimentacion\"> \n");
      out.write("    <input type=\"hidden\" id =\"admin_id\" name=\"admin_id\" value=\"");
      out.print(DatoUsuario.getEmpleado_id());
      out.write("\">\n");
      out.write("    <input type=\"hidden\" id =\"emple_id\" name=\"emple_id\">\n");
      out.write("    <input type=\"hidden\" id =\"feedback_id\" name=\"feedback_id\" value=\"");
      out.print(retroalimetacion_id);
      out.write("\">\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label for=\"inputName\" class=\"col-sm-2 control-label\">Tipo Feedback</label>\n");
      out.write("        <div class=\"col-sm-10\">\n");
      out.write("            <select class=\"form-control\" id=\"retro_tipo_adver\" name=\"retro_tipo_adver\">\n");
      out.write("                <option value=\"\"></option>\n");
      out.write("                ");

                    for (Feedback_tipo fe : feedbacks) {
                        String select = "";
                        if (datos.getFeedback_tipo_id() == fe.getFeedback_tipo_id()) {
                            select = "selected";
                        }

                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(fe.getFeedback_tipo_id());
      out.write('"');
      out.write(' ');
      out.print(select);
      out.write('>');
      out.print(fe.getNombre());
      out.write("</option>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label for=\"inputEmail\" class=\"col-sm-2 control-label\">Motivo</label>\n");
      out.write("        <div class=\"col-sm-10\">\n");
      out.write("            <input type=\"text\" class=\"form-control\"  id=\"retro_motivo\" name=\"retro_motivo\" placeholder=\"Motivo\" value=\"");
 if (datos.getMotivo() != null) {
                    out.print(datos.getMotivo());
                }
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label for=\"inputName\" class=\"col-sm-2 control-label\">Fecha</label>\n");
      out.write("        <div class=\"col-sm-10\">\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"retro_fecha\" name=\"retro_fecha\" placeholder=\"Fecha\" value=\"");
if (datos.getFecha_advertencia() != null) {
                    out.print(datos.getFecha_advertencia());
                }
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label for=\"inputExperience\" class=\"col-sm-2 control-label\">Descripción</label>\n");
      out.write("        <div class=\"col-sm-10\">\n");
      out.write("            <textarea class=\"form-control retro_descripcion\" id=\"retro_descripcion\" name=\"retro_descripcion\" placeholder=\"Descripción\">");
if (datos.getDescripcion() != null) {
                    out.print(datos.getDescripcion());
                }
      out.write("</textarea>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("            <button type=\"submit\" class=\"btn btn-purple\">Guardar</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <div id=\"mensaje_guarda_nota\"></div>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("<script src=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        $(\".retro_descripcion\").wysihtml5();\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    var valor = $('#idEmpleado_id').val();\n");
      out.write("    $('#emple_id').val(valor);\n");
      out.write("\n");
      out.write("    $('#retro_fecha').datepicker({\n");
      out.write("        autoclose: true,\n");
      out.write("    });//.datepicker(\"setDate\", new Date());\n");
      out.write("\n");
      out.write("    //$('#retro_fecha').data(\"Datepicker\").show();\n");
      out.write("\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $('.form_create_retoralimentacion').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                retro_motivo: {\n");
      out.write("                    message: 'Motivo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Motivo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 3,\n");
      out.write("                            max: 100,\n");
      out.write("                            message: 'El motivo tiene que ser mas de 3 y menos de 100 caracteres'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                retro_fecha: {\n");
      out.write("                    message: 'Fecha no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Motivo no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        date: {\n");
      out.write("                            format: 'DD/MM/YYYY',\n");
      out.write("                            message: 'Fecha no valida, formto(dd/mm/yyyy)'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                retro_descripcion: {\n");
      out.write("                    message: 'Descripción no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Descripción no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                retro_tipo_adver: {\n");
      out.write("                    message: 'Tipo Advertencia no valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Descripción no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Debe seleccionar Tipo Advertencia. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#mensaje_guarda_nota\").show();\n");
      out.write("            $(\"#mensaje_guarda_nota\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"retro_alimentacion/guarda_retroalimentacion.jsp\",\n");
      out.write("                data: $(\".form_create_retoralimentacion\").serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#mensaje_guarda_nota\").removeClass(\"loader\");\n");
      out.write("                    $(\"#mensaje_guarda_nota\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#mensaje_guarda_nota\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#mensaje_guarda_nota\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
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
