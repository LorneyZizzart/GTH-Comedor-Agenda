package org.apache.jsp.Funcionario.perfil.curriculum;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ver_005fcurriculum_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa fa-university bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("            <h3 class=\"timeline-header\"><a>Formación académica</a>\n");
      out.write("                <button id=\"retro_formacion_academica\" type=\"button\" class=\"btn-purple btn-right_nivel retro_formacion_academica\" data-toggle=\"modal\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"\" data-original-title=\"Añadir Formación Académica\">\n");
      out.write("                    <i class=\"fa fa-plus\"></i>\n");
      out.write("                </button>\n");
      out.write("            </h3>\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <div class=\"box-body table-responsive no-padding\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th><th>Formación</th><th colspan=\"2\">Periodo</th><th>Institución</th><th>Titulo Optenido</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td><td>Bachiller</td><td>02/2002</td><td>11/2005</td><td>Colegio Adventista de Bolivia</td><td>Bachiller en Humanidades</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td><td>Licenciatura</td><td>02/2006</td><td>11/2010</td><td>Universidad Adventista de Bolivia</td><td>Licenciaruta en Administración de Empresas</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul>        \n");
      out.write("\n");
      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa fa-folder-open-o bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("            <h3 class=\"timeline-header\"><a>Conocimientos Complementarios</a>\n");
      out.write("                <button id=\"retro_formacion_academica\" type=\"button\" class=\"btn-purple btn-right_nivel retro_formacion_academica\" data-toggle=\"modal\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"\" data-original-title=\"Añadir Formación Académica\">\n");
      out.write("                    <i class=\"fa fa-plus\"></i>\n");
      out.write("                </button>\n");
      out.write("            </h3>\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <div class=\"box-body table-responsive no-padding\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th><th>Areas del Conocimiento </th><th>Nivel de Conocimiento</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td><td>Ley 1178</td><td>Tengo Buen Conocimiento</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td><td>Reglamento General y Reglamentos Específicos de Universidades Privadas</td><td>Tengo Buen Conocimiento</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul> \n");
      out.write("\n");
      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa fa-briefcase bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("            <h3 class=\"timeline-header\"><a>Cursos</a>\n");
      out.write("                <button id=\"retro_formacion_academica\" type=\"button\" class=\"btn-purple btn-right_nivel retro_formacion_academica\" data-toggle=\"modal\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"\" data-original-title=\"Añadir Formación Académica\">\n");
      out.write("                    <i class=\"fa fa-plus\"></i>\n");
      out.write("                </button>\n");
      out.write("            </h3>\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <div class=\"box-body table-responsive no-padding\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th><th>Nombre del Curso</th><th>Institución</th><th>Titulo Optenido</th><th>Desde</th><th>Hasta</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td><td>Capacitación</td><td>INSTITUTO DE COMERCIO EXTERIOR Y ADUANAS</td><td>CAPACITACION, FISCALIZACION Y MEDIOS DE CONTROL ADUANERO CON UN ENFOQUE LEGAL</td><td>12/09/2013</td><td>13/09/2013</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td><td>Capacitación</td><td>CONTRALORIA GENERAL DEL ESTADO</td><td>CURSOS, RESPONSABILIDAD POR LA FUNCION PUBLICA, VIRTUAL</td><td>26/09/2016</td><td>09/10/2016</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa fa-laptop bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("            <h3 class=\"timeline-header\"><a>Computación</a>\n");
      out.write("                <button id=\"retro_formacion_academica\" type=\"button\" class=\"btn-purple btn-right_nivel retro_formacion_academica\" data-toggle=\"modal\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"\" data-original-title=\"Añadir Formación Académica\">\n");
      out.write("                    <i class=\"fa fa-plus\"></i>\n");
      out.write("                </button>\n");
      out.write("            </h3>\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <div class=\"box-body table-responsive no-padding\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th><th>Paquetes de Computación</th><th>Nivel de Conocimiento</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td><td>MMS Word</td><td>Bueno</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td><td>MS Excel</td><td>Excelente</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>3</td><td>MS PowerPoint</td><td>Muy Bueno</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa fa-cogs bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("            <h3 class=\"timeline-header\"><a>Experiencia Laboral</a>\n");
      out.write("                <button id=\"retro_formacion_academica\" type=\"button\" class=\"btn-purple btn-right_nivel retro_formacion_academica\" data-toggle=\"modal\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"\" data-original-title=\"Añadir Formación Académica\">\n");
      out.write("                    <i class=\"fa fa-plus\"></i>\n");
      out.write("                </button>\n");
      out.write("            </h3>\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <div class=\"box-body table-responsive no-padding\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th><th>Entidad</th><th>Nombre del Jefe Directo</th><th>Desde</th><th>Hasta </th><th>Nombre Cargo</th><th>Describa la Principal Función que Desempeñaba</th><th>Área Relacionada</th><th>Documentación de Respaldo</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td><td>DEPOSITOS ADUANEROS BOLIVIANOS</td><td>FERNANDO PARAVICINI ALLERDING</td><td>13/05/2014</td><td>08/03/2017</td><td>AUXILIAR DE SERVICIOS I FACTURACION</td><td>RECIBIR Y REGISTRAR DOCUMENTACION DE ACUERDO A LA NORMATIVA VIGENTE, ASEGURANDO EL COBRO EXACTO Y OPORTUNO DE LOS SERVICIOS PRESTADO POR LA INSTITUCION</td><td>Control aduanero</td><td>SI</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td><td>UNIVERCIDAD ADVENTISTA DE BOLIVIA</td><td>VICTOR HUGO LIMA</td><td>01/04/2017</td><td>31/12/2018</td><td>DOCENTE</td><td>DOCENTE TIEMPO COMPLETO FACULTAD DE INGENIERIA</td><td>DOCENTE</td><td>SI</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("<ul class=\"timeline timeline-inverse\">\n");
      out.write("    <li>\n");
      out.write("        <i class=\"fa fa-user bg-aqua-active\"></i>\n");
      out.write("        <div class=\"timeline-item\">\n");
      out.write("            <h3 class=\"timeline-header\"><a>Referencias Laborales</a>\n");
      out.write("                <button id=\"retro_formacion_academica\" type=\"button\" class=\"btn-purple btn-right_nivel retro_formacion_academica\" data-toggle=\"modal\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"\" data-original-title=\"Añadir Formación Académica\">\n");
      out.write("                    <i class=\"fa fa-plus\"></i>\n");
      out.write("                </button>\n");
      out.write("            </h3>\n");
      out.write("            <div class=\"timeline-body\">\n");
      out.write("                <div class=\"box-body table-responsive no-padding\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th><th>Señor(a)</th><th>Cargo</th><th>Entidad</th><th>Teléfono </th><th>Relación Laboral con el Postulante</th><th>Ciudad o Población</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td><td>FERNANDO PARAVICINI ALLERDING</td><td>JEFE DE RECINTO</td><td>DEPOSITOS ADUANERO BOLIVIANOS</td><td>77755674</td><td>JEFE INMEDIATO</td><td>LA PAZ, FRONTERA DESAGUADERO</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td><td>VICTOR HUGO LIMA</td><td>GESTION DEL TALENTO HUMANO</td><td>UNIVERSIDAD ADVENTISTA DE BOLIVIA</td><td>77714214</td><td>JEFE INMEDIATO</td><td>COCHABAMBA, VINTO</td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</ul>");
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
