package org.apache.jsp.Funcionario.perfil.datoPersonal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Empleado;

public final class datos_005fpersonales_jsp extends org.apache.jasper.runtime.HttpJspBase
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

   Empleado perfil = new Empleado();
//   perfil = empleado;

      out.write("\n");
      out.write("\n");
      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa fa-user bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("\n");
      out.write("            <h3 class=\"timeline-header\"><a>Datos Personales</a></h3>\n");
      out.write("\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa  fa-check-circle-o\"></i> Nombre:</strong>\n");
      out.write("                    ");
      out.print(perfil.getNombre());
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa fa-check-circle-o\"></i> Apellido Paterno: </strong>\n");
      out.write("                     ");
      out.print(perfil.getApellido_paterno());
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa fa-check-circle-o\"></i> Apellido Materno</strong>\n");
      out.write("                    ");
      out.print(perfil.getApellido_materno());
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa fa-calendar\"></i> Fecha Nacimiento: </strong>\n");
      out.write("                    ");
      out.print(perfil.getFecha_nacimiento());
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa fa-flag-checkered\"></i> Pais de Origen:</strong>\n");
      out.write("                    ");
      out.print(perfil.getPaisNombre());
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa  fa-user-plus\"></i> Estado Civil:</strong>\n");
      out.write("                    ");
      out.print(perfil.getEstado_civil_Nombre());
      out.write(" \n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa fa-mobile\"></i> Teléfono:</strong>\n");
      out.write("                    ");
      out.print(perfil.getTelefono());
      out.write(" \n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa fa-envelope-o\"></i> Correo electrónico :</strong>\n");
      out.write("                    ");
      out.print(perfil.getEmail());
      out.write(" \n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul>\n");
      out.write("                \n");
      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa  fa-sun-o bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("\n");
      out.write("            <h3 class=\"timeline-header\"><a>Datos AFP</a></h3>\n");
      out.write("\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa  fa-check-circle-o\"></i> Nombre AFP:</strong>\n");
      out.write("                    AFP FURUTO DE BOLIVIA\n");
      out.write("                </p>\n");
      out.write("                <p class=\"timeline-header no-border\">\n");
      out.write("                    <strong><i class=\"fa fa-check-circle-o\"></i> N.U.A./C.U.A: </strong>\n");
      out.write("                     40001290\n");
      out.write("                </p>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul>                ");
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
