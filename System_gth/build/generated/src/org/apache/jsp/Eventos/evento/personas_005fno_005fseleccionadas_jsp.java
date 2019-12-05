package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Empleado;
import java.util.ArrayList;
import java.util.List;

public final class personas_005fno_005fseleccionadas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EventoController consultaEvento = null;
      synchronized (_jspx_page_context) {
        consultaEvento = (Controlador.EventoController) _jspx_page_context.getAttribute("consultaEvento", PageContext.PAGE_SCOPE);
        if (consultaEvento == null){
          consultaEvento = new Controlador.EventoController();
          _jspx_page_context.setAttribute("consultaEvento", consultaEvento, PageContext.PAGE_SCOPE);
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

    String evento_id = request.getParameter("id");
    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaEvento.GetAllEmpleadoNoEstanaEnEvento(Integer.parseInt(evento_id));

      out.write("\n");
      out.write("<style>\n");
      out.write("    table.dataTable tr th.select-checkbox.selected::after {\n");
      out.write("\n");
      out.write("        margin-top: -11px;\n");
      out.write("        margin-left: -4px;\n");
      out.write("        text-align: center;\n");
      out.write("        text-shadow: rgb(176, 190, 217) 1px 1px, rgb(176, 190, 217) -1px -1px, rgb(176, 190, 217) 1px -1px, rgb(176, 190, 217) -1px 1px;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<div class=\"box-body table-responsive\">\n");
      out.write("    <table id=\"persona_no_select\" class=\"table table-bordered table-striped\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th><input type=\"checkbox\" id=\"select_all\" /> Todos</th>\n");
      out.write("                <th>#</th>\n");
      out.write("                <th>Nombre Personal</th>\n");
      out.write("                <th>Departamento</th>\n");
      out.write("                <th>Cargo</th>\n");
      out.write("                <th>Grupo</th>                \n");
      out.write("                <th></th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                int contador = 0;
                for (Empleado em : Empleados) {
                    contador++;
            
      out.write("\n");
      out.write("            <tr id=\"tr_");
      out.print(em.getEmpleado_id());
      out.write("\">\n");
      out.write("\n");
      out.write("                <td><input type=\"checkbox\" class=\"checkbox\" name=\"empleados[]\" value=\"");
      out.print(em.getEmpleado_id());
      out.write("\"/></td>\n");
      out.write("                <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(em.getApellido_paterno());
      out.write(' ');
      out.print(em.getApellido_materno());
      out.write(' ');
      out.print(em.getNombre());
      out.write("</td>\n");
      out.write("\n");
      out.write("                ");

                    if (em.getCargo() != null) {
                
      out.write("\n");
      out.write("                <td>");
      out.print(_character.CharacterUCFirst(em.getCargo().getDepartamento_nombre()));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(_character.CharacterUCFirst(em.getCargo().getCargo_nombre()));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(_character.CharacterUCFirst(em.getCargo().getNivel_nombre()));
      out.write("</td>\n");
      out.write("                ");

                } else {
                
      out.write("<td></td>\n");
      out.write("                <td></td>\n");
      out.write("                <td></td>");

                    }
                
      out.write("\n");
      out.write("                <td><a data-id=\"");
      out.print(em.getEmpleado_id());
      out.write("\"  data-evento=\"");
      out.print(evento_id);
      out.write("\" class=\"agrega_empleado_uno btn btn-xs btn-success\" data-original-title=\"Agregar a evento\"> <i class=\"fa  fa-user-plus\"></i></a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("        <tfoot>\n");
      out.write("            <tr>\n");
      out.write("                <td></td>\n");
      out.write("                <th>#</th>\n");
      out.write("                <th>Nombre Personal</th>\n");
      out.write("                <th>Departamento</th>\n");
      out.write("                <th>Cargo</th>\n");
      out.write("                <th>Grupo</th>\n");
      out.write("                <th></th>                \n");
      out.write("            </tr>\n");
      out.write("        </tfoot>\n");
      out.write("    </table>\n");
      out.write("    <div class=\"box-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("        <button type=\"button\" class=\"btn-purple pull-right guarda_participantes\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"mensaje\"></div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        /*$(\"#persona_no_select\").DataTable({\n");
      out.write("         \"lengthMenu\": [[10, 25, 50, 100, -1], [10, 25, 50, 100, \"Todo\"]]\n");
      out.write("         });\n");
      out.write("         */\n");
      out.write("\n");
      out.write("        $(function () {\n");
      out.write("            $(\"#persona_no_select\").DataTable({\n");
      out.write("                \"lengthMenu\": [[10, 25, 50, 100, -1], [10, 25, 50, 100, \"Todo\"]]\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $('#select_all').on('click', function () {\n");
      out.write("            if (this.checked) {\n");
      out.write("                $('.checkbox').each(function () {\n");
      out.write("                    this.checked = true;\n");
      out.write("                });\n");
      out.write("            } else {\n");
      out.write("                $('.checkbox').each(function () {\n");
      out.write("                    this.checked = false;\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        $('.guarda_participantes').on('click', function () {\n");
      out.write("            var selected = new Array();\n");
      out.write("            $('[name=\"empleados[]\"]:checked').each(\n");
      out.write("                    function () {\n");
      out.write("                        selected.push($(this).val());\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("            if (selected.length > 0) {\n");
      out.write("\n");
      out.write("                $(\".mensaje\").addClass('loader');\n");
      out.write("                $.post('personas_no_seleccionadas_guardar.jsp',\n");
      out.write("                        {id_evento: ");
      out.print(evento_id);
      out.write(",\n");
      out.write("                            personales: selected},\n");
      out.write("                        function (html) {\n");
      out.write("                            $(\".mensaje\").removeClass('loader');\n");
      out.write("                            $(\".mensaje\").html(html);\n");
      out.write("                        }\n");
      out.write("                ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("                {\n");
      out.write("                    var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                    $(\".mensaje\").removeClass('loader');\n");
      out.write("                    $(\".mensaje\").html(alerta);\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            } else {\n");
      out.write("                alert(\"No selecciono nada\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("        $('.agrega_empleado_uno').click(function () {\n");
      out.write("            var evento = $(this).attr('data-evento');\n");
      out.write("            var empleado = $(this).attr('data-id');\n");
      out.write("\n");
      out.write("            $.post('personas_no_seleccionadas_guardar_uno.jsp',\n");
      out.write("                    {id_evento: evento,\n");
      out.write("                        personales: empleado},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\".mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("                $(\".mensaje\").removeClass('loader');\n");
      out.write("                $(\".mensaje\").html(alerta);\n");
      out.write("            });\n");
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
