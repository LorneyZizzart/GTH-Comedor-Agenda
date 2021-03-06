package org.apache.jsp.Funcionario.Ver.reporte_005fgestiones;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Uni_acad_area_pre;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import Entidad.Cuestionario;
import java.util.ArrayList;
import java.util.List;

public final class reporte_005fgestion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Reporte_evaluacionesController _reporte_ciclo = null;
      synchronized (_jspx_page_context) {
        _reporte_ciclo = (Controlador.Reporte_evaluacionesController) _jspx_page_context.getAttribute("_reporte_ciclo", PageContext.PAGE_SCOPE);
        if (_reporte_ciclo == null){
          _reporte_ciclo = new Controlador.Reporte_evaluacionesController();
          _jspx_page_context.setAttribute("_reporte_ciclo", _reporte_ciclo, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Uni_acad_area_preController _evalua_docente = null;
      synchronized (_jspx_page_context) {
        _evalua_docente = (Controlador.Uni_acad_area_preController) _jspx_page_context.getAttribute("_evalua_docente", PageContext.PAGE_SCOPE);
        if (_evalua_docente == null){
          _evalua_docente = new Controlador.Uni_acad_area_preController();
          _jspx_page_context.setAttribute("_evalua_docente", _evalua_docente, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String gestion_id = request.getParameter("gestion_id");
    String empleado_id = request.getParameter("empleado_id");

    List<Cuestionario> gestiones = new ArrayList<Cuestionario>();
    gestiones = _reporte_ciclo.GetAllCuestionario_Empleado(Integer.parseInt(gestion_id), Integer.parseInt(empleado_id));
    //(int Cuestionario_gestion_id, int empleado_id

    List<Uni_acad_area_pre> profes = new ArrayList<Uni_acad_area_pre>();

    profes = _evalua_docente.GetProfAreasNota(empleado_id, gestion_id);

    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
    separadoresPersonalizados.setDecimalSeparator('.');

    DecimalFormat formato_personalizado = new DecimalFormat("#.00", separadoresPersonalizados);

    if (gestiones.size() > 0) {
        int contador = 0;
        int tamanioLista = gestiones.size();
        int cuenta_tamanio = 0;
        float promedio_total = 0;

      out.write("\n");
      out.write("<section class=\"invoice\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12 table-responsive\">\n");
      out.write("            <input type=\"hidden\" id=\"des_gestion\" value=\"");
      out.print(gestion_id);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" id=\"des_emple_id\" value=\"");
      out.print(empleado_id);
      out.write("\">\n");
      out.write("\n");
      out.write("            <table class=\"table table-hover\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th style=\"width: 10px\">#</th>\n");
      out.write("                        <th  style=\"white-space:nowrap; padding:5px\">Nombre</th>\n");
      out.write("                        <th>Desempeño</th>\n");
      out.write("                        <th style=\"width: 40px\">Promedio</th>\n");
      out.write("                        <th style=\"width: 40px\"></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
            for (Cuestionario g : gestiones) {
                            cuenta_tamanio++;
                            contador++;
                            promedio_total = promedio_total + g.getPromedio();
                            int nota = (int) (g.getPromedio());
                            float valor_progres = g.getPromedio() * 10;
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                        <td style=\"white-space:nowrap; padding:5px\">");
      out.print(g.getNombre());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"progress progress-xs\">\n");
      out.write("                                <div class=\"progress-bar progress-bar-danger\" style=\"width: ");
      out.print(valor_progres);
      out.write("%;background-color: #");
      out.print(g.getColor_pintar());
      out.write("!important\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <span class=\"badge bg-red\" style=\"width: 90px;background-color: #");
      out.print(g.getColor_pintar());
      out.write("!important\">");
      out.print((formato_personalizado.format(g.getPromedio())));
      out.write(' ');
      out.print(g.getDesempeno());
      out.write("</span></td>\n");
      out.write("                        <td>\n");
      out.write("\n");
      out.write("                            <button type=\"button\" class=\"btn btn-purple btn-xs analiza_desepeño\" data-cuestionaio=\"");
      out.print(g.getCuestionario_id());
      out.write("\">Analizar desempeño</button>                \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        if (tamanioLista == cuenta_tamanio) {
                            //Aqui agragamos en caso que tengo evaluacion commo profesor
                            if (profes.size() > 0) {
                                for (Uni_acad_area_pre p : profes) {
                                    contador++;
                                    //int nota = (int) (p.getNota());
                                    promedio_total = promedio_total + p.getNota();
                                    float valor_progres_ = p.getNota() * 10;
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                        <td style=\"white-space:nowrap; padding:5px\">");
      out.print(p.getNombre());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"progress progress-xs\">\n");
      out.write("                                <div class=\"progress-bar progress-bar-danger\" style=\"width: ");
      out.print(valor_progres_);
      out.write("%;background-color: #");
      out.print(p.getCss());
      out.write("!important\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <span class=\"badge bg-red\" style=\"width: 90px;background-color: #");
      out.print(p.getCss());
      out.write("!important\">");
      out.print((formato_personalizado.format(p.getNota())));
      out.write(' ');
      out.print(p.getNota_estado());
      out.write("</span>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-purple btn-xs analiza_profe\" data-cuestionaio=\"");
      out.print(p.getUni_acad_area_pre_id());
      out.write("\" data-gestion=\"");
      out.print(p.getGestion());
      out.write("\">Analizar desempeño</button>                \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                                    }
                                }
                            }
                        }
                    
      out.write("    \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <h3 class=\"box-title\">Promedio Total = ");
      out.print(formato_personalizado.format(promedio_total / contador));
      out.write("</h3>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<div id=\"ver_analisis\"></div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(\".analiza_profe\").click(function (e) {\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        var id_cuestionario = $(this).attr('data-cuestionaio');\n");
      out.write("        var gestion = $(this).attr('data-gestion');\n");
      out.write("        var empleado_id = '");
      out.print(empleado_id);
      out.write("';\n");
      out.write("\n");
      out.write("        $(\"#ver_analisis\").html(\"\");\n");
      out.write("        $(\"#ver_analisis\").addClass(\"loader\");\n");
      out.write("        $.ajax({\n");
      out.write("            type: \"POST\",\n");
      out.write("            url: \"reporte_gestiones/ver_desempeno_analisis_prof.jsp\",\n");
      out.write("            data: {id_cuestionario: id_cuestionario,\n");
      out.write("                des_gestion: gestion,\n");
      out.write("                des_emple_id: empleado_id},\n");
      out.write("            success: function (data)\n");
      out.write("            {\n");
      out.write("                $(\"#ver_analisis\").removeClass(\"loader\");\n");
      out.write("                $(\"#ver_analisis\").html(data);\n");
      out.write("            }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                $(\"#ver_analisis\").removeClass(\"loader\");\n");
      out.write("                var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                $(\"#ver_analisis\").html(menn);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $(\".analiza_desepeño\").on(\"click\", function () {\n");
      out.write("        var id_cuestionario = $(this).attr('data-cuestionaio');\n");
      out.write("        var des_gestion = $('#des_gestion').val();\n");
      out.write("        var des_emple_id = $('#des_emple_id').val();\n");
      out.write("\n");
      out.write("        $(\"#ver_analisis\").html(\"\");\n");
      out.write("        $(\"#ver_analisis\").addClass(\"loader\");\n");
      out.write("        $.ajax({\n");
      out.write("            type: \"POST\",\n");
      out.write("            url: \"reporte_gestiones/ver_desempeno_analisis.jsp\",\n");
      out.write("            data: {id_cuestionario: id_cuestionario,\n");
      out.write("                des_gestion: des_gestion,\n");
      out.write("                des_emple_id: des_emple_id},\n");
      out.write("            success: function (data)\n");
      out.write("            {\n");
      out.write("                $(\"#ver_analisis\").removeClass(\"loader\");\n");
      out.write("                $(\"#ver_analisis\").html(data);\n");
      out.write("            }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                $(\"#ver_analisis\").removeClass(\"loader\");\n");
      out.write("                var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                $(\"#ver_analisis\").html(menn);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
} else {
    if (profes.size() > 0) {
        int contador = 0;
        int tamanioLista = gestiones.size();
        int cuenta_tamanio = 0;
        float promedio_total = 0;

      out.write("\n");
      out.write("<section class=\"invoice\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12 table-responsive\">\n");
      out.write("            <input type=\"hidden\" id=\"des_gestion\" value=\"");
      out.print(gestion_id);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" id=\"des_emple_id\" value=\"");
      out.print(empleado_id);
      out.write("\">\n");
      out.write("\n");
      out.write("            <table class=\"table table-hover\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th style=\"width: 10px\">#</th>\n");
      out.write("                        <th  style=\"white-space:nowrap; padding:5px\">Nombre</th>\n");
      out.write("                        <th>Desempeño</th>\n");
      out.write("                        <th style=\"width: 40px\">Promedio</th>\n");
      out.write("                        <th style=\"width: 40px\"></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        for (Uni_acad_area_pre p : profes) {
                            contador++;
                            //int nota = (int) (p.getNota());
                            promedio_total = promedio_total + p.getNota();
                            float valor_progres_ = p.getNota() * 10;
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                        <td style=\"white-space:nowrap; padding:5px\">");
      out.print(p.getNombre());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"progress progress-xs\">\n");
      out.write("                                <div class=\"progress-bar progress-bar-danger\" style=\"width: ");
      out.print(valor_progres_);
      out.write("%;background-color: #");
      out.print(p.getCss());
      out.write("!important\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <span class=\"badge bg-red\" style=\"width: 90px;background-color: #");
      out.print(p.getCss());
      out.write("!important\">");
      out.print((formato_personalizado.format(p.getNota())));
      out.write(' ');
      out.print(p.getNota_estado());
      out.write("</span>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-purple btn-xs analiza_profe\" data-cuestionaio=\"");
      out.print(p.getUni_acad_area_pre_id());
      out.write("\" data-gestion=\"");
      out.print(p.getGestion());
      out.write("\">Analizar desempeño</button>                \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }


                    
      out.write("    \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <h3 class=\"box-title\">Promedio Total = ");
      out.print(formato_personalizado.format(promedio_total / contador));
      out.write("</h3>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<div id=\"ver_analisis\"></div>\n");
      out.write("<script>\n");
      out.write("    $(\".analiza_profe\").click(function (e) {\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        var id_cuestionario = $(this).attr('data-cuestionaio');\n");
      out.write("        var gestion = $(this).attr('data-gestion');\n");
      out.write("        var empleado_id = '");
      out.print(empleado_id);
      out.write("';\n");
      out.write("\n");
      out.write("        $(\"#ver_analisis\").html(\"\");\n");
      out.write("        $(\"#ver_analisis\").addClass(\"loader\");\n");
      out.write("        $.ajax({\n");
      out.write("            type: \"POST\",\n");
      out.write("            url: \"reporte_gestiones/ver_desempeno_analisis_prof.jsp\",\n");
      out.write("            data: {id_cuestionario: id_cuestionario,\n");
      out.write("                des_gestion: gestion,\n");
      out.write("                des_emple_id: empleado_id},\n");
      out.write("            success: function (data)\n");
      out.write("            {\n");
      out.write("                $(\"#ver_analisis\").removeClass(\"loader\");\n");
      out.write("                $(\"#ver_analisis\").html(data);\n");
      out.write("            }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                $(\"#ver_analisis\").removeClass(\"loader\");\n");
      out.write("                var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                $(\"#ver_analisis\").html(menn);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");

} else {

      out.write("\n");
      out.write("<div class=\"error-page\">    \n");
      out.write("    <div class=\"error-content\">\n");
      out.write("        <h3><i class=\"fa fa-warning text-yellow\"></i> Oops! No se encontro resultado.</h3>        \n");
      out.write("    </div>\n");
      out.write("    <!-- /.error-content -->\n");
      out.write("</div>\n");
    }
    }

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
