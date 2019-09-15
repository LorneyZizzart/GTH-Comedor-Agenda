package org.apache.jsp.Administrar.modulo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Menu;

public final class editMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.MenuController getunMenu = null;
      synchronized (_jspx_page_context) {
        getunMenu = (Controlador.MenuController) _jspx_page_context.getAttribute("getunMenu", PageContext.PAGE_SCOPE);
        if (getunMenu == null){
          getunMenu = new Controlador.MenuController();
          _jspx_page_context.setAttribute("getunMenu", getunMenu, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.CharacterController _character = null;
      synchronized (_jspx_page_context) {
        _character = (Controlador.CharacterController) _jspx_page_context.getAttribute("_character", PageContext.PAGE_SCOPE);
        if (_character == null){
          _character = new Controlador.CharacterController();
          _jspx_page_context.setAttribute("_character", _character, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    int idMenu = 0;
    Menu menu = new Menu();
    try {
        idMenu = Integer.parseInt(request.getParameter("id"));
        menu = getunMenu.getMenuById(idMenu);
    } catch (Exception e) {
        idMenu = 0;
    }



      out.write("\n");
      out.write("                <!-- /.box-header -->\n");
      out.write("                <!-- form start -->\n");
      out.write("                <form id=\"form_menu_guardar\" method=\"post\" class=\"form_menu_guardar\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(idMenu);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"modulo_nombre\"  name=\"modulo_nombre\" placeholder=\"Ingresar Nombre\" value=\"");
      out.print(_character.CharacterUCFirst(menu.getNombre()));
      out.write("\">                            \n");
      out.write("                        </div>                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Estado</label>\n");
      out.write("                            ");

                                String select = "";
                                if (menu.getEstado() > 0) {
                                    select = "checked";
                                }
      out.write("\n");
      out.write("                            <label> <input type=\"checkbox\" name=\"modulo_estado\" id=\"modulo_estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Posición</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"modulo_posicion\" name=\"modulo_posicion\" placeholder=\"Ingresar Posición\" value=\"");
      out.print(menu.getPosicion());
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Ìcono</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\"  id=\"modulo_icono\" name=\"modulo_icono\" placeholder=\"Icono\" value=\"");
      out.print(menu.getIcono());
      out.write("\">\n");
      out.write("                        </div>                        \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn-purple pull-right\"><i class=\"fa fa-refresh\"></i> Actualizar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <div id=\"mensaje\"></div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        $('.form_menu_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                modulo_nombre: {\n");
      out.write("                    message: 'El nombre no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El nombre no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 6,\n");
      out.write("                            max: 30,\n");
      out.write("                            message: 'El Nombre tiene que ser mas de 6 y menos de 30 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                modulo_posicion: {\n");
      out.write("                    messaje: 'Numero Posicion no es valido',\n");
      out.write("                    validators: {\n");
      out.write("\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Posicion no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        integer: {\n");
      out.write("                            message: 'El valor tiene que ser numero'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                modulo_icono: {\n");
      out.write("                    messaje: 'El ícono no es valido',\n");
      out.write("                    validators: {\n");
      out.write("\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El ícono no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 3,\n");
      out.write("                            max: 30,\n");
      out.write("                            message: 'El ícono tiene que ser mas de 3 y menos de 30 caracteres'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"Menu_guardar.jsp\",\n");
      out.write("                data: $(\".form_menu_guardar\").serialize(),\n");
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
