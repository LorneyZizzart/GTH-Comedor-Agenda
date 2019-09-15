package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.Menu;
import Entidad.Login_Entidad;

public final class valida_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.LoginController loginController = null;
      synchronized (application) {
        loginController = (Controlador.LoginController) _jspx_page_context.getAttribute("loginController", PageContext.APPLICATION_SCOPE);
        if (loginController == null){
          loginController = new Controlador.LoginController();
          _jspx_page_context.setAttribute("loginController", loginController, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write('\n');

    String usuario = request.getParameter("correo");
    String contrasenia = request.getParameter("password");

    //out.print("Usuario :" + usuario + "<br> contra : " + contrasenia + " <br>");
    Login_Entidad login = new Login_Entidad();
    login = loginController.Iniciar_sesion(usuario, contrasenia);
    if (login.getEstado() == 1) {
        // le manda al index
        HttpSession sesion = request.getSession();
        sesion.setAttribute("USUARIO", login);

        List<Menu> menu = new ArrayList<Menu>();
        menu = loginController.MenuUsuario(login.getUser_id());
        sesion.setAttribute("MENU", menu);

        out.print("<script>window.location.href = 'masterPage/complemento/index.jsp';</script>");

    } else {
        out.print("<p class='text-danger'>" + login.getMensage() + "</p> ");
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
