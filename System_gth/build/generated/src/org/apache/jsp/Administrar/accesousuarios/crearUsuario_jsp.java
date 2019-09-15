package org.apache.jsp.Administrar.accesousuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Entidad.Empleado;
import Entidad.Usuario;

public final class crearUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EmpleadoController empleadosConsulta = null;
      synchronized (_jspx_page_context) {
        empleadosConsulta = (Controlador.EmpleadoController) _jspx_page_context.getAttribute("empleadosConsulta", PageContext.PAGE_SCOPE);
        if (empleadosConsulta == null){
          empleadosConsulta = new Controlador.EmpleadoController();
          _jspx_page_context.setAttribute("empleadosConsulta", empleadosConsulta, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String opcion = "registerUser";
    List<Empleado> empleados = new ArrayList<Empleado>();
    empleados = empleadosConsulta.GetAllEmpleadoNotUser();

      out.write("\n");
      out.write("<form id=\"form_usuario_guardar\" method=\"post\" class=\"form_usuario_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(opcion);
      out.write("\" name=\"editOpcion\" id=\"editOpcion\">\n");
      out.write("    <div class=\"box-body\">\n");
      out.write("        <input type=\"hidden\" name=\"id\" id=\"id\" value=\"0\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Personal</label>\n");
      out.write("            <select class=\"form-control select2 idEmpleado\" name='idEmpleado' id='idEmpleado' style=\"width: 100%;\">\n");
      out.write("                <option value=\"\">- Seleccionar -</option>\n");
      out.write("                ");
 for (Empleado e : empleados) {
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(e.getEmpleado_id());
      out.write('"');
      out.write('>');
      out.print(e.getNombre());
      out.write("</option>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Nombre Usuario</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"usuario\"  name=\"usuario\" placeholder=\"Ingresar Nombre\" >                            \n");
      out.write("        </div>                        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Estado</label>\n");
      out.write("            <label> <input type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ></label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Perfil</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"perfil\"  name=\"perfil\" placeholder=\"Ingresar perfil\" >                            \n");
      out.write("        </div> \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Email</label>\n");
      out.write("            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Correo electrónico\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Contraseña</label>\n");
      out.write("            <input type=\"password\" class=\"form-control\"  id=\"contrasena\" name=\"contrasena\" placeholder=\"Contraseña\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Confimar contraseña</label>\n");
      out.write("            <input type=\"password\" class=\"form-control\"  id=\"confirmPassword\" name=\"confirmPassword\" placeholder=\"Contraseña\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("    <div class=\"box-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary pull-right\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("<div id=\"mensaje\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        $(\".idEmpleado\").change(function () {\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            alert(\"Handler for .change() called.\" + $(this).val());\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"get_maul_user.jsp\",\n");
      out.write("                data: {id_empleado: $(this).val()},\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    $(\"#email\").val(data);\n");
      out.write("                    \n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#mensaje\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $('.form_usuario_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                idEmpleado: {\n");
      out.write("                    message: 'El nombre no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Seleccione a un personal. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                usuario: {\n");
      out.write("                    message: 'Nombre Usuario no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Es requerido el Nombre de Usuario. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                perfil: {\n");
      out.write("                    message: 'Perfil no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Es requerido el Perfil. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                email: {\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Email es requerido'\n");
      out.write("                        },\n");
      out.write("                        emailAddress: {\n");
      out.write("                            message: 'El valor no es una dirección de emailválida'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                contrasena: {\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Contraseña requerida'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                confirmPassword: {\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Confirmación de contraseña requerida'\n");
      out.write("                        },\n");
      out.write("                        identical: {\n");
      out.write("                            field: 'contrasena',\n");
      out.write("                            message: 'La contraseña y la confirmación no son las mismas.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"usuario_guardar.jsp\",\n");
      out.write("                data: $(\".form_usuario_guardar\").serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    $(\"#mensaje\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#mensaje\").html(menn);\n");
      out.write("                }\n");
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
