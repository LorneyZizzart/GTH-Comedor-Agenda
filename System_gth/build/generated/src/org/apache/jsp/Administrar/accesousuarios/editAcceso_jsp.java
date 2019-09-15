package org.apache.jsp.Administrar.accesousuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.math.BigInteger;
import java.security.*;
import Entidad.Opcion;
import Entidad.Menu;
import java.util.ArrayList;
import java.util.List;
import Entidad.Usuario_opcion;

public final class editAcceso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.MenuController _menu = null;
      synchronized (_jspx_page_context) {
        _menu = (Controlador.MenuController) _jspx_page_context.getAttribute("_menu", PageContext.PAGE_SCOPE);
        if (_menu == null){
          _menu = new Controlador.MenuController();
          _jspx_page_context.setAttribute("_menu", _menu, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Usuario_opcionController _opciones = null;
      synchronized (_jspx_page_context) {
        _opciones = (Controlador.Usuario_opcionController) _jspx_page_context.getAttribute("_opciones", PageContext.PAGE_SCOPE);
        if (_opciones == null){
          _opciones = new Controlador.Usuario_opcionController();
          _jspx_page_context.setAttribute("_opciones", _opciones, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idEncript = request.getParameter("id");
    int id_user = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
    
    List<Menu> menus = new ArrayList<Menu>();
    menus = _menu.getAllMenuAndOpcion();
//
//    int id_user = Integer.parseInt(request.getParameter("id"));
    List<Usuario_opcion> opciones_user = new ArrayList<Usuario_opcion>();
    opciones_user = _opciones.GetAllUsuarioOpcionByUser_id(id_user);

      out.write(" \n");
      out.write("                <div class=\"box-header\">\n");
      out.write("                    <h3 class=\"box-title\">Lista de Modulos y Accesos</h3>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box-header -->\n");
      out.write("                <div class=\"box-body\"><input type=\"hidden\" id=\"idUser_sys\" name=\"idUser_sys\" value=\"");
      out.print(id_user);
      out.write("\"  >\n");
      out.write("                    ");

                        for (Menu item : menus) {
                    
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"box-header with-border\">\n");
      out.write("                            <h3 class=\"box-title\"><i class=\"");
      out.print(item.getIcono());
      out.write("\"></i>  ");
      out.print(item.getNombre());
      out.write("</h3>\n");
      out.write("                            <div class=\"box-tools\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i></button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box-body no-padding\">\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">                                                                \n");
      out.write("                                ");
 for (Opcion o : item.getOpciones()) {
                                        String checked = "";
                                        for (Usuario_opcion opcion : opciones_user) {
                                            if (o.getOpcion_id() == opcion.getOpcion_id()) {
                                                checked = "checked";
                                            }
                                        }
                                
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"checkbox\">\n");
      out.write("                                        <label>\n");
      out.write("                                            <input type=\"checkbox\" name=\"ids\" id=\"ids\" class=\"ids\" value=\"");
      out.print(o.getOpcion_id());
      out.write('"');
      out.write(' ');
      out.print(checked);
      out.write('>');
      out.write(' ');
      out.print(o.getNombre());
      out.write("\n");
      out.write("                                        </label>\n");
      out.write("                                    </div>                                           \n");
      out.write("                                </li>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.box-body -->\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div id=\"mensaje\"></div>\n");
      out.write("                    <!-- /. box -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box-body -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".btn_actualiza_acceso\").click(function () {\n");
      out.write("\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("            var checkboxValues = new Array();\n");
      out.write("            $('input[name=\"ids\"]:checked').each(function () {\n");
      out.write("                //var id = $(this).attr('id');\n");
      out.write("                //var value = $(this).val();\n");
      out.write("                if ($(this).prop('checked')) {\n");
      out.write("                    checkboxValues.push($(this).val());\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            //alert(checkboxValues);\n");
      out.write("            $.post('guarda_accesos.jsp',\n");
      out.write("                    {ids: checkboxValues},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $('.ids').change(function ()\n");
      out.write("        {\n");
      out.write("            var opcion = $(this).val();\n");
      out.write("            var user = $(\"#idUser_sys\").val();\n");
      out.write("            //alert(this.checked);\n");
      out.write("            if (this.checked == true) {\n");
      out.write("                //añadimos\n");
      out.write("                $.post('guarda_accesos.jsp',\n");
      out.write("                        {opcion: opcion,\n");
      out.write("                            user: user,\n");
      out.write("                            accion: 1},\n");
      out.write("                        function (html) {\n");
      out.write("                            if (html.trim() == \"Ok\") {\n");
      out.write("                                toastr.success(\"Añadido Correctamente.\");\n");
      out.write("                            } else {\n");
      out.write("                                toastr.error(\"Se produjo un error.\"+html);\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("            } else {\n");
      out.write("                //Eliminamos\n");
      out.write("                $.post('guarda_accesos.jsp',\n");
      out.write("                        {opcion: opcion,\n");
      out.write("                            user: user,\n");
      out.write("                            accion: 2},\n");
      out.write("                        function (html) {\n");
      out.write("                            if (html.trim() == \"Ok\") {\n");
      out.write("                                toastr.success(\"Quitado Correctamente.\");\n");
      out.write("                            } else {\n");
      out.write("                                toastr.error(\"Se produjo un error.\"+html);\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("            }\n");
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
