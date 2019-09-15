package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_Tarea;

public final class guardarTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
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

    
    A_Tarea tarea = new A_Tarea();
    String resultado = null;
    try{
        tarea.setIdTarea(Integer.parseInt(request.getParameter("id")));
        
        if(tarea.getIdTarea() == 0)
        tarea.setIdUserCrea(Integer.parseInt(request.getParameter("idUsuario")));
        tarea.setTitulo(String.valueOf(request.getParameter("titulo")));
        tarea.setDescripcion(String.valueOf(request.getParameter("descripcion")));        
        tarea.setIdRepeticionTarea(Integer.parseInt(request.getParameter("idRepeticion")));
        tarea.setIdEstadoTarea(Integer.parseInt(request.getParameter("idEstado")));
        tarea.setFechaInicio(String.valueOf(request.getParameter("fi")));
        tarea.setHoraInicio(request.getParameter("horaInicio"));
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }

    try{
        if(request.getParameter("L").equalsIgnoreCase("on"))
            tarea.setLunes(1);
    }catch(Exception e){
        tarea.setLunes(0);
    }
    
    try{
        if(request.getParameter("Ma").equalsIgnoreCase("on"))
            tarea.setMartes(1);
    }catch(Exception e){
        tarea.setMartes(0);
    }
    
    try{
        if(request.getParameter("Mi").equalsIgnoreCase("on"))
            tarea.setMiercoles(1);
    }catch(Exception e){
        tarea.setMiercoles(0);
    }
    
    try{
        if(request.getParameter("J").equalsIgnoreCase("on"))
            tarea.setJueves(1);
    }catch(Exception e){
        tarea.setJueves(0);
    }
    try{
        if(request.getParameter("V").equalsIgnoreCase("on"))
            tarea.setViernes(1);
    }catch(Exception e){
        tarea.setViernes(0);
    }
    
    try{
        if(request.getParameter("S").equalsIgnoreCase("on"))
            tarea.setSabado(1);;
    }catch(Exception e){
        tarea.setSabado(0);;
    }
    
    try{
        if(request.getParameter("D").equalsIgnoreCase("on"))
            tarea.setDomingo(1);            
    }catch(Exception e){
        tarea.setDomingo(0); 
    }
    if(tarea.getIdTarea() == 0)
    resultado = _tarea.SaveTarea(tarea);
    else resultado = _tarea.UpdateTarea(tarea);
    
    if(resultado.equalsIgnoreCase("Ok")){

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\n");
      out.write("            location.reload();\n");
      out.write("        });\n");
      out.write("        $(\"form\")[0].reset();\n");
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
