package org.apache.jsp.Registro.empleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.GregorianCalendar;
import java.util.Calendar;
import Entidad.Empleado_cargo;
import Entidad.Empleado;

public final class guardarEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EmpleadoController _empleado = null;
      synchronized (_jspx_page_context) {
        _empleado = (Controlador.EmpleadoController) _jspx_page_context.getAttribute("_empleado", PageContext.PAGE_SCOPE);
        if (_empleado == null){
          _empleado = new Controlador.EmpleadoController();
          _jspx_page_context.setAttribute("_empleado", _empleado, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    Empleado empleado = new Empleado();
    empleado.setEmpleado_id(Integer.parseInt(request.getParameter("id")));
    empleado.setNombre(request.getParameter("nombre"));
    empleado.setApellido_paterno(request.getParameter("apellidoPaterno"));    
    empleado.setApellido_materno(request.getParameter("apellidoMaterno"));
    empleado.setEmail(request.getParameter("email"));
    empleado.setTelefono(request.getParameter("telefono"));
    empleado.setEstado_civil_id(Integer.parseInt(request.getParameter("idEstadoCivil")));
    empleado.setPais_id(request.getParameter("idPais"));
    

    int estado = 0;
    try {
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    empleado.setEstado(estado);
    
    
       
    String resultado = "";
    
    if(Integer.parseInt(request.getParameter("id")) == 0){
        Empleado_cargo cargo = new Empleado_cargo();
        Calendar fecha = new GregorianCalendar();
        String fechaNow="", day="", month="";

        if(fecha.get(fecha.DATE)<10) day = "0"+Integer.toString(fecha.get(fecha.DATE));
        else day = Integer.toString(fecha.get(fecha.DATE));

        if(fecha.get(fecha.MONTH)<10) month = "0"+Integer.toString(fecha.get(fecha.MONTH));
        else month = Integer.toString(fecha.get(fecha.MONTH));

        fechaNow = day +"/"+month+"/"+Integer.toString(fecha.get(fecha.YEAR));

        cargo.setDepartamento_id(Integer.parseInt(request.getParameter("idDepartamento")));
        cargo.setNivel_id(Integer.parseInt(request.getParameter("idNivel")));
        cargo.setCargo_id(Integer.parseInt(request.getParameter("idCargo")));
        
        empleado.setCargo(cargo);
        //validacion de correo
        if(_empleado.validaCorreoEmpleado(empleado.getEmail())==0)        
            resultado = _empleado.CreateEmpleado(empleado);
        else resultado = "emailExiste";
    }
    else{ 
        Empleado empleadoObtenido = new Empleado();
        empleadoObtenido =  _empleado.GetEmpleadoByID(empleado.getEmpleado_id());
        //comparacion de email si el mismo del empleado
        if(empleado.getEmail().equalsIgnoreCase(empleadoObtenido.getEmail())){
            resultado = _empleado.UpdateEmpleado(empleado);
        }else{
            if(_empleado.validaCorreoEmpleado(empleado.getEmail()) == 0)
                resultado = _empleado.UpdateEmpleado(empleado);
            else resultado = "emailExiste";
        }
        
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

} else if(resultado.equalsIgnoreCase("emailExiste")){

      out.write("\n");
      out.write("            <div class=\"alert alert-danger\">\n");
      out.write("                <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("                El correo <strong>");
      out.print(empleado.getEmail());
      out.write("</strong> se encuentra en uso.\n");
      out.write("            </div>\n");
      out.write(" ");
    
}else {

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
