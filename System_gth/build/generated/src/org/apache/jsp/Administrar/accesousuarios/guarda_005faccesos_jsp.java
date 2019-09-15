package org.apache.jsp.Administrar.accesousuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class guarda_005faccesos_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.Usuario_opcionController _opcionesSaveDelete = null;
      synchronized (_jspx_page_context) {
        _opcionesSaveDelete = (Controlador.Usuario_opcionController) _jspx_page_context.getAttribute("_opcionesSaveDelete", PageContext.PAGE_SCOPE);
        if (_opcionesSaveDelete == null){
          _opcionesSaveDelete = new Controlador.Usuario_opcionController();
          _jspx_page_context.setAttribute("_opcionesSaveDelete", _opcionesSaveDelete, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String opcion = request.getParameter("opcion");
    String user = request.getParameter("user");
    String accion = request.getParameter("accion");
    
    String resultado = "";
    
    if (accion.equalsIgnoreCase("1")) {
        //Añadir
        resultado = _opcionesSaveDelete.CreateUsuario_opcion(user, opcion);
    } else if (accion.equalsIgnoreCase("2")) {
        resultado = _opcionesSaveDelete.DeleteUsuario_opcion(user, opcion);
    } else {
        resultado = "No se realizo ninguna accion.";
    }
    out.print(resultado);
    

      out.write('\n');
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
