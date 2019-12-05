package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.StringReader;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;
import java.util.List;
import Entidad.A_Tarea;

public final class guardarFileProcesoDB_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      Controlador.A_PathProcedimientoTareaController _path = null;
      synchronized (_jspx_page_context) {
        _path = (Controlador.A_PathProcedimientoTareaController) _jspx_page_context.getAttribute("_path", PageContext.PAGE_SCOPE);
        if (_path == null){
          _path = new Controlador.A_PathProcedimientoTareaController();
          _jspx_page_context.setAttribute("_path", _path, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_ProcedimientoTareaController _proceso = null;
      synchronized (_jspx_page_context) {
        _proceso = (Controlador.A_ProcedimientoTareaController) _jspx_page_context.getAttribute("_proceso", PageContext.PAGE_SCOPE);
        if (_proceso == null){
          _proceso = new Controlador.A_ProcedimientoTareaController();
          _jspx_page_context.setAttribute("_proceso", _proceso, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    
    String resultado = "Ok";
    JSONParser parser = new JSONParser();
    
    try{
        if(request.getParameter("lista") != null){ 
            String js = request.getParameter("lista");
            Object obj = parser.parse(new StringReader(js));
            JSONObject json = (JSONObject) obj;
            JSONArray listaPath = (JSONArray) json.get("listaPath");   
             for(int i = 0; i < listaPath.size(); i++){
                 A_Tarea path = new A_Tarea();
                 JSONObject p = (JSONObject) listaPath.get(i);
                 path.setIdProcedimiento(Integer.parseInt(p.get("idProceso").toString()));
                 path.setNombrePath(p.get("titulo").toString());
                 path.setPathImage(p.get("pathImage").toString());
                 resultado = _path.savePathProcedimiento(path);
             }
        }        
        
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }
    
   out.print(resultado);

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
