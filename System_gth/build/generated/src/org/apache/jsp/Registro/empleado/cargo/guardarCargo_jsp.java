package org.apache.jsp.Registro.empleado.cargo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import Entidad.Empleado_cargo;

public final class guardarCargo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Empleado_cargoController _cargo = null;
      synchronized (_jspx_page_context) {
        _cargo = (Controlador.Empleado_cargoController) _jspx_page_context.getAttribute("_cargo", PageContext.PAGE_SCOPE);
        if (_cargo == null){
          _cargo = new Controlador.Empleado_cargoController();
          _jspx_page_context.setAttribute("_cargo", _cargo, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    Empleado_cargo cargo = new Empleado_cargo();
    cargo.setEmpleado_id(Integer.parseInt(request.getParameter("idEmpleado")));
    cargo.setDepartamento_id(Integer.parseInt(request.getParameter("idDepartamento")));
    cargo.setNivel_id(Integer.parseInt(request.getParameter("idNivel")));
    cargo.setCargo(request.getParameter("cargo"));
    cargo.setFecha_inicio(request.getParameter("fechaInicio"));
    cargo.setCargo_id(Integer.parseInt(request.getParameter("idCargo")));
    //cambiar a null
    String resultado = "";
    String fechaFinal = null;
    try{
        if(request.getParameter("fechaFinal") != null){
            fechaFinal = request.getParameter("fechaFinal");
        }
        
    }catch(Exception e){
        fechaFinal = null;
    }
    cargo.setFecha_fin(fechaFinal);
    
    if(request.getParameter("opcion").equals("editar")){
        cargo.setId(Integer.parseInt(request.getParameter("id")));

        int estado = 0;
        try {
            if(request.getParameter("estado").equalsIgnoreCase("on"))
            estado = 1;
            else estado = 0;
        }catch(Exception e){
            estado = 0;
        }
        cargo.setActivo(estado);
        
        resultado = _cargo.UpdateEmpleado_cargo(cargo);
    }else resultado = _cargo.CreateEmpleadoCargo(cargo);
     
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

} else {

      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    Error: ");
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
