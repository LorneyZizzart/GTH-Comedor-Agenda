package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cambiarEstadoTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    
    String resultado = null;
    int idTarea = 0;
    try{
        idTarea = Integer.parseInt(request.getParameter("idTarea"));
        int idEstado = Integer.parseInt(request.getParameter("idEstado"));
        resultado = _tarea.CambiarEstadoTarea(idTarea, idEstado);
        
    }catch(Exception e){
        resultado =  "Se ha producido al cambiar estado. Error: " + e;
    }
    
    if(resultado.equalsIgnoreCase("Ok"))
{

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        fechaInicio = $('#dp1').val(); fechaFinal = $('#dp2').val();\n");
      out.write("        renderTable($('#idFuncionario').val(), $('#idRepeat').val(), fechaInicio, fechaFinal);\n");
      out.write("    });\n");
      out.write("</script>\n");
}else{System.out.print("Error al actulizar el estado de la tarea");
      out.write('\n');
}
      out.write('\n');
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
