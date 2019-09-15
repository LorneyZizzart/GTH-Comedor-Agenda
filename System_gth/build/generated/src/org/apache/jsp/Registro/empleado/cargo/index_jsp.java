package org.apache.jsp.Registro.empleado.cargo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.Empleado_cargo;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Empleado_cargoController _cargo = null;
      synchronized (_jspx_page_context) {
        _cargo = (Controlador.Empleado_cargoController) _jspx_page_context.getAttribute("_cargo", PageContext.PAGE_SCOPE);
        if (_cargo == null){
          _cargo = new Controlador.Empleado_cargoController();
          _jspx_page_context.setAttribute("_cargo", _cargo, PageContext.PAGE_SCOPE);
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
      Controlador.CharacterController _character = null;
      synchronized (_jspx_page_context) {
        _character = (Controlador.CharacterController) _jspx_page_context.getAttribute("_character", PageContext.PAGE_SCOPE);
        if (_character == null){
          _character = new Controlador.CharacterController();
          _jspx_page_context.setAttribute("_character", _character, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idEncript = request.getParameter("id");  
    int idEmpleado = 0;
    List<Empleado_cargo> listaCargo = new ArrayList<Empleado_cargo>();
    
    try {
        idEmpleado = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        listaCargo = _cargo.GetAllEnpleado_cargoByEmpleadoId(idEmpleado);
    }catch (Exception e) {
        idEmpleado = 0;
    }   
    

      out.write("\n");
      out.write("<a data-id=\"");
      out.print(idEmpleado);
      out.write("\" class=\"nuevoCargo btn-purple btn-right_nivel\" data-toggle=\"modal tooltip\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"Añadir cargo\">\n");
      out.write("<i class=\"fa fa-plus\"></i>\n");
      out.write("</a> \n");
      out.write("\n");
      out.write(" <br>\n");
      out.write("<br>\n");
      out.write("<table id=\"exampleCargo\" class=\"table table-bordered table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Inicio</th>\n");
      out.write("                                <th>Final</th>\n");
      out.write("                                <th>Cargo</th>\n");
      out.write("                                <th>Grupo</th>\n");
      out.write("                                <th>Departamento</th>\n");
      out.write("                                <th>Estado</th>\n");
      out.write("                                <th style=\"width: 10%\">Opciones</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                int contador = 0;
                                for (Empleado_cargo item : listaCargo) {
                                    contador++;

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(item.getFecha_inicio());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(item.getFecha_fin());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(_character.CharacterUCFirst(item.getCargo_nombre()));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(_character.CharacterUCFirst(item.getNivel_nombre()));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(_character.CharacterUCFirst(item.getDepartamento_nombre()));
      out.write("</td>\n");
      out.write("                                <td>");
 if (item.getActivo()== 1) {
      out.write("<span class=\"badge bg-green\">Activo</span> </td>");
} else {
      out.write("<span class=\"badge bg-red\">Inactivo</span> </td>");
}
      out.write(" \n");
      out.write("                                \n");
      out.write("                                <td class=\"text-center\">\n");
      out.write("                                    <div class=\"btn-group \">\n");
      out.write("                                        <a data-id=\"");
      out.print(_encript.ValorAEncriptar(Integer.toString(item.getId())));
      out.write("\" class=\"formEditCargo btn btn-xs btn-primary edit_button\" title=\"Editar\"><i class=\"fa fa-edit\"></i></a>                                \n");
      out.write("                                        <a data-id=\"");
      out.print(_encript.ValorAEncriptar(Integer.toString(item.getId())));
      out.write("\" class=\"formEliminarCargo btn btn-danger btn-xs delete_button\" title=\"Eliminar\"> <i class=\"fa fa-trash-o\"></i></a>                                \n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                        \n");
      out.write("<div class=\"modal fade\" id=\"formulario_registro_cargo\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close cerrar\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                    <h4 id=\"titleModalCargo\" class=\"modal-title\">title</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body cuerpo_registro\"></div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.modal-content -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.modal-dialog -->\n");
      out.write("    </div>\n");
      out.write("<script>   \n");
      out.write("    \n");
      out.write("    $('.nuevoCargo').tooltip({ boundary: 'window' })    \n");
      out.write("    $('.formEditCargo').tooltip({ boundary: 'window' })\n");
      out.write("    $('.formEliminarCargo').tooltip({ boundary: 'window' })\n");
      out.write("    \n");
      out.write("    $(\".nuevoCargo\").click(function (e) {\n");
      out.write("        $(\".modal-dialog\").width(600);\n");
      out.write("        $(\"#titleModal\").html(\"Añadir de cargo\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('cargo/crearCargo.jsp',\n");
      out.write("                {id: $(this).attr('data-id')},\n");
      out.write("        function (html) {\n");
      out.write("            $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("            $(\".cuerpo_registro\").html(html);\n");
      out.write("        }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("            $(\".cuerpo_registro\").html(alerta);\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("    $(\".formEditCargo\").click(function (e) {\n");
      out.write("        $(\".modal-dialog\").width(600);\n");
      out.write("        $(\"#titleModal\").html(\"Editar de cargo\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('cargo/editarCargo.jsp',\n");
      out.write("                {id: $(this).attr('data-id')},\n");
      out.write("        function (html) {\n");
      out.write("            $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("            $(\".cuerpo_registro\").html(html);\n");
      out.write("        }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("            $(\".cuerpo_registro\").html(alerta);\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("    $(\".formEliminarCargo\").click(function (e) {\n");
      out.write("        $(\".modal-dialog\").width(600);\n");
      out.write("        $(\"#titleModal\").html(\"Eliminar de cargo\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("\n");
      out.write("        $.post('cargo/eliminarCargo.jsp',\n");
      out.write("                {id: $(this).attr('data-id')},\n");
      out.write("        function (html) {\n");
      out.write("            $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("            $(\".cuerpo_registro\").html(html);\n");
      out.write("        }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            var alerta = \"<p class='bg-danger'>error: \" + errorThrown + \"</p>\";\n");
      out.write("            $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("            $(\".cuerpo_registro\").html(alerta);\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("    \n");
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
