package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_EstadoTarea;
import Entidad.A_ProcedimientoTarea;
import Entidad.A_Tarea;

public final class guardarProceso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_ProcedimientoTareaController _procedimiento = null;
      synchronized (_jspx_page_context) {
        _procedimiento = (Controlador.A_ProcedimientoTareaController) _jspx_page_context.getAttribute("_procedimiento", PageContext.PAGE_SCOPE);
        if (_procedimiento == null){
          _procedimiento = new Controlador.A_ProcedimientoTareaController();
          _jspx_page_context.setAttribute("_procedimiento", _procedimiento, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    
    
    String resultado = null;
    try{        
        if(Integer.parseInt(request.getParameter("id")) == 0){
            A_ProcedimientoTarea p = new A_ProcedimientoTarea();
            p.setIdProcedimiento(Integer.parseInt(request.getParameter("idProceso"))); 
            p.setNombreProcedimiento(request.getParameter("nombre"));
            p.setDescripcionProcedimiento(request.getParameter("descripcion"));
            resultado = _procedimiento.UpdateProcedimientoTarea(p);
        }else{
            A_Tarea tarea = new A_Tarea();
            tarea.setIdTarea(Integer.parseInt(request.getParameter("id")));  
            tarea.setNombreProcedimiento(request.getParameter("nombre"));
            tarea.setDescripcionProcedimiento(request.getParameter("descripcion"));
            resultado = _procedimiento.SaveProcedimiento(tarea);
        }
        
        
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }
    
    if(resultado.equalsIgnoreCase("Ok")){

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("     \n");
      out.write("    $(document).ready(function () {         \n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\n");
      out.write("            $('.form-group').removeClass('has-success');\n");
      out.write("            $('.glyphicon-ok').hide();\n");
      out.write("        });\n");
      out.write("        $(\"#formGuardarProceso\")[0].reset();\n");
      out.write("    });\n");
      out.write("</script>\n");
}else{
      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    ");
      out.print(resultado);
      out.write("\n");
      out.write("</div>\n");
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
