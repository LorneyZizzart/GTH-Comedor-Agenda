package org.apache.jsp.Evaluacion.preguntas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Pregunta;

public final class guardarPregunta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.PreguntaController _pregunta = null;
      synchronized (_jspx_page_context) {
        _pregunta = (Controlador.PreguntaController) _jspx_page_context.getAttribute("_pregunta", PageContext.PAGE_SCOPE);
        if (_pregunta == null){
          _pregunta = new Controlador.PreguntaController();
          _jspx_page_context.setAttribute("_pregunta", _pregunta, PageContext.PAGE_SCOPE);
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

    String idCuestionarioEncript = request.getParameter("idCuestionario");
    String idUsuarioEncript = request.getParameter("idUsuario");
    String idPreguntaEncript = request.getParameter("idPregunta");

    Pregunta pregunta = new Pregunta();
    pregunta.setCuestionario_id(Integer.parseInt(_encript.ValorADesencriptar(idCuestionarioEncript)));
    pregunta.setUsuario_crea(Integer.parseInt(_encript.ValorADesencriptar(idUsuarioEncript)));
    pregunta.setUsuario_actualiza(Integer.parseInt(_encript.ValorADesencriptar(idUsuarioEncript)));
    pregunta.setPregunta_id(Integer.parseInt(_encript.ValorADesencriptar(idPreguntaEncript)));
    pregunta.setTipo_id(Integer.parseInt(request.getParameter("idTipo")));
    pregunta.setNombre(request.getParameter("pregunta"));
    pregunta.setOrden(Integer.parseInt(request.getParameter("orden")));

    int estado = 0;
    try {
        if (request.getParameter("estado").equalsIgnoreCase("on")) {
            estado = 1;
        } else {
            estado = 0;
        }
    } catch (Exception e) {
        estado = 0;
    }

    pregunta.setEstado(estado);

    String resultado = _pregunta.CreateOrUpdatePregunta(pregunta);
    if (resultado.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");

    if (idPreguntaEncript.isEmpty() || idPreguntaEncript == null) {

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        /*$(\"#mensaje\").hide(3000, function () {\n");
      out.write("         location.reload();\n");
      out.write("         });*/\n");
      out.write("        $(\"form\")[0].reset();\n");
      out.write("        setTimeout(\"location.reload()\", 1000);\n");
      out.write("    });\n");
      out.write("</script>\n");

} else {

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        /*$(\"#mensajeEditar\").hide(3000, function () {\n");
      out.write("         location.reload();\n");
      out.write("         });*/\n");
      out.write("        $(\"form\")[0].reset();\n");
      out.write("        setTimeout(\"location.reload()\", 1000);\n");
      out.write("    });\n");
      out.write("</script>\n");

    }

      out.write('\n');
} else {
      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    ");
      out.print(resultado);
      out.write("\n");
      out.write("</div>\n");
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
