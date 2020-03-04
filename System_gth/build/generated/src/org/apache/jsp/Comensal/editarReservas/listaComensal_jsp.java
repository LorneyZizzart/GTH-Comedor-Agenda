package org.apache.jsp.Comensal.editarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Usuario;
import java.util.ArrayList;
import java.util.List;

public final class listaComensal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.UsuarioController consultaUser = null;
      synchronized (_jspx_page_context) {
        consultaUser = (Controlador.UsuarioController) _jspx_page_context.getAttribute("consultaUser", PageContext.PAGE_SCOPE);
        if (consultaUser == null){
          consultaUser = new Controlador.UsuarioController();
          _jspx_page_context.setAttribute("consultaUser", consultaUser, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_EmpleadoReservaController consultarComensal = null;
      synchronized (_jspx_page_context) {
        consultarComensal = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("consultarComensal", PageContext.PAGE_SCOPE);
        if (consultarComensal == null){
          consultarComensal = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("consultarComensal", consultarComensal, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    
    List<Usuario> Usuarios = new ArrayList<Usuario>();
    
    int idTipoComensal = 0;
    try{
        idTipoComensal = Integer.parseInt(request.getParameter("idTipoComensal"));
        if(idTipoComensal == 0){
            List<Usuario> listInternos = new ArrayList<Usuario>();
            List<Usuario> listExternos = new ArrayList<Usuario>();
            listInternos = consultaUser.GetAllUser();
            listExternos = consultarComensal.getNombresComensalesExternos();
            Usuarios.addAll(listInternos);
            Usuarios.addAll(listExternos);

        }else if(idTipoComensal == 1){
            List<Usuario> listInternos = new ArrayList<Usuario>();
            listInternos = consultaUser.GetAllUser();
            Usuarios.addAll(listInternos);      
        }else if(idTipoComensal == 2){
            
            List<Usuario> listExternos = new ArrayList<Usuario>();
            listExternos = consultarComensal.getNombresComensalesExternos();
            Usuarios.addAll(listExternos);
        }
    }catch(Exception e){
        
    }
    
    

      out.write("\n");
      out.write("\n");
      out.write("                          <select id=\"idEmpleado\" name=\"idEmpleado\" class=\"form-control selectFuncionario\" style=\"width: 100%;\">\n");
      out.write("                              <option value=\"0%2\" selected>Todos</option>\n");
      out.write("                          ");

                                    for(Usuario item : Usuarios){
                                        if(item.getEstado() == 1){
                                            
      out.write("\n");
      out.write("                                   <option value=\"");
      out.print(item.getEmpleado_id());
      out.write('%');
      out.print(item.getFuncionario());
      out.write('"');
      out.write('>');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                                    ");

                                        }
                                    }
                         
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        \n");
      out.write("                        <script>\n");
      out.write("                            $(document).ready(function() {\n");
      out.write("                                $('.selectFuncionario').select2();\n");
      out.write("                            })\n");
      out.write("                        </script>");
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
