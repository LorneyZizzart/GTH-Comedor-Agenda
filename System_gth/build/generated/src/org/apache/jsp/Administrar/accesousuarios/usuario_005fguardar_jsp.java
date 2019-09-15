package org.apache.jsp.Administrar.accesousuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Usuario;

public final class usuario_005fguardar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.UsuarioController _usuario = null;
      synchronized (_jspx_page_context) {
        _usuario = (Controlador.UsuarioController) _jspx_page_context.getAttribute("_usuario", PageContext.PAGE_SCOPE);
        if (_usuario == null){
          _usuario = new Controlador.UsuarioController();
          _jspx_page_context.setAttribute("_usuario", _usuario, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    Usuario usuario = new Usuario();
    Usuario usuarioObtenido = new Usuario();
    String opcion = request.getParameter("editOpcion");
    String resultado = null;
    
    usuario.setUser_id(Integer.parseInt(request.getParameter("id")));
    usuarioObtenido = _usuario.GetDatosParaActualizarByUser_id(Integer.parseInt(request.getParameter("id")));
    
    if("editUser".equalsIgnoreCase(opcion)){
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setPerfil(request.getParameter("perfil").toLowerCase());
        usuario.setEmail(request.getParameter("email").trim());
        int estado = 0;        
        try {
            if (request.getParameter("estado").equalsIgnoreCase("on")) {
                estado = 1;
            }
        } catch (Exception e) {
            estado = 0;
        }
        usuario.setEstado(estado);
        if(usuarioObtenido.getEmail().equalsIgnoreCase(usuario.getEmail())){
             resultado = _usuario.UpdateUserDatosPersonales(usuario);
        }else{
            int validaCorreo = _usuario.validaCorreo(usuario.getEmail());
            if (validaCorreo > 0) 
               resultado = "emailExistente";            
            else 
               resultado = _usuario.UpdateUserDatosPersonales(usuario);
        }
        
    }else if("editPassword".equalsIgnoreCase(opcion)){
         usuario.setContrasena(request.getParameter("contrasena"));
         resultado = _usuario.UpdatePassword(usuario);
    }else if("registerUser".equalsIgnoreCase(opcion)){
        usuario.setEmpleado_id(Integer.parseInt(request.getParameter("idEmpleado")));
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setPerfil(request.getParameter("perfil").toLowerCase());
        usuario.setEmail(request.getParameter("email").trim());
        usuario.setContrasena(request.getParameter("contrasena"));
        int estado = 0;        
        try {
            if (request.getParameter("estado").equalsIgnoreCase("on")) {
                estado = 1;
            }
        } catch (Exception e) {
            estado = 0;
        }
        usuario.setEstado(estado);
        if(_usuario.validaCorreo(usuario.getEmail())==0)
            resultado = _usuario.CreateUsuario(usuario);
        else
            resultado = "emailExistente";
    }else{
        
    }   

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

    } else if(resultado.equalsIgnoreCase("emailExistente")){
 
      out.write("\n");
      out.write("            <div class=\"alert alert-danger\">\n");
      out.write("                <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("                El correo <strong>");
      out.print(usuario.getEmail());
      out.write("</strong> se encuentra en uso.\n");
      out.write("            </div>\n");
      out.write(" ");

    } else {

      out.write("\n");
      out.write("<div class=\"text-center alert alert-danger alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa  fa-close\"></i> Se ha produciso un error</h4>\n");
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
