package org.apache.jsp.GTH.ciclo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Entidad.View_Empleado_Gestion;
import java.util.List;

public final class listaEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Cuestionario_gestionController _cuestionarioGestion = null;
      synchronized (_jspx_page_context) {
        _cuestionarioGestion = (Controlador.Cuestionario_gestionController) _jspx_page_context.getAttribute("_cuestionarioGestion", PageContext.PAGE_SCOPE);
        if (_cuestionarioGestion == null){
          _cuestionarioGestion = new Controlador.Cuestionario_gestionController();
          _jspx_page_context.setAttribute("_cuestionarioGestion", _cuestionarioGestion, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idCicloEncript = _encript.ValorADesencriptar(request.getParameter("id")).replace(" ", "+");  
    List<View_Empleado_Gestion> listaEmpleado = new ArrayList<View_Empleado_Gestion>();
    int idCiclo = 0;
    
    try {
        idCiclo = Integer.parseInt(idCicloEncript);
        listaEmpleado = _cuestionarioGestion.GetAllEmpleadoNoRegistradoEnGestion(idCiclo);
    }catch (Exception e) {
        idCiclo = 0;
    }   
    

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(_encript.ValorAEncriptar(idCicloEncript));
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("    <button type=\"button\" class=\"agregarEmpleado btn-purple pull-right\">\n");
      out.write("    <i class=\"fa fa-save\"></i><b> Guardar</b>\n");
      out.write("    </button> \n");
      out.write("<br><br>\n");
      out.write("\n");
      out.write("<table id=\"tableListEmploy\" class=\"table table-bordered table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Nombre completo</th>\n");
      out.write("                                <th>Departamento</th>\n");
      out.write("                                <th>Cargo</th>\n");
      out.write("                                <th class=\"text-right\" style=\"width: 10%\">\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default btn-sm checkbox-toggle comprobar\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Marcar todos\"><i class=\"fa fa-square-o\"></i>\n");
      out.write("                                </button>\n");
      out.write("                                </th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                             int contador = 0;
                                for(View_Empleado_Gestion item : listaEmpleado){
                                    contador++;
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"text-center\">");
      out.print(contador);
      out.write(" <input type=\"hidden\" name=\"posicion_celda\" value=\"");
      out.print(contador);
      out.write("\" class=\"posicion_celda\"> </td>\n");
      out.write("                                <input hidden> \n");
      out.write("                                <td><input hidden value=\"");
      out.print(item.getEmpleado_id());
      out.write("\" name=\"idEmpleado");
      out.print(contador);
      out.write("\" id=\"idEmpleado");
      out.print(contador);
      out.write('"');
      out.write('>');
      out.print(item.getNombre_empleado());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(item.getNombre_departamento());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(item.getNombre_cargo());
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\"><input class=\"selectEmpleado");
      out.print(contador);
      out.write("\" name=\"agregarEmpleado\" id=\"agregarEmpleado\" type=\"checkbox\" data-placement=\"left\" data-toggle=\"tooltip\" title=\"Marcar\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                    
                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                        <tfoot>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Nombre completo</th>\n");
      out.write("                                <th>Departamento</th>\n");
      out.write("                                <th>Cargo</th>\n");
      out.write("                                <th class=\"text-center\">Marcar</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </tfoot>\n");
      out.write("                    </table>\n");
      out.write("</form>                          \n");
      out.write("<script type=\"text/javascript\"> \n");
      out.write("        \n");
      out.write("    $('#formNuevo').tooltip({ boundary: 'window' })\n");
      out.write("    $(function () {\n");
      out.write("        $(\"#tableListEmploy\").DataTable();\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("        $(\".agregarEmpleado\").click(function (){    \n");
      out.write("            var jsonEmpleados = {};\n");
      out.write("            var array = [];\n");
      out.write("            var empleado = [];\n");
      out.write("        \n");
      out.write("         var valor = $(\".posicion_celda\").each(function () {\n");
      out.write("            var id = $(this).val();\n");
      out.write("            array.push(id);\n");
      out.write("        });\n");
      out.write("        array.forEach(function (element) {\n");
      out.write("            if( $('.selectEmpleado'+element).prop('checked') ) {\n");
      out.write("               empleado.push({\n");
      out.write("                    \"idEmpleado\" :  $('#idEmpleado' + element).val()\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        jsonEmpleados.idCiclo = $(\"#id\").val();\n");
      out.write("        jsonEmpleados.empleados = empleado;\n");
      out.write("        var jsonString = JSON.stringify(jsonEmpleados);\n");
      out.write("        console.log(jsonString);\n");
      out.write("\n");
      out.write("        $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"guardarCuestionarioGestionEmpleado.jsp\",\n");
      out.write("                data: {\"Object\" :jsonString},\n");
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
      out.write("        \n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
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
