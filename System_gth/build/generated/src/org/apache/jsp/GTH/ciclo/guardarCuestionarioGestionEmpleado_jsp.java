package org.apache.jsp.GTH.ciclo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.StringReader;
import org.json.simple.parser.JSONParser;

public final class guardarCuestionarioGestionEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      Controlador.Cuestionario_gestionController _cuestionarioGestion = null;
      synchronized (_jspx_page_context) {
        _cuestionarioGestion = (Controlador.Cuestionario_gestionController) _jspx_page_context.getAttribute("_cuestionarioGestion", PageContext.PAGE_SCOPE);
        if (_cuestionarioGestion == null){
          _cuestionarioGestion = new Controlador.Cuestionario_gestionController();
          _jspx_page_context.setAttribute("_cuestionarioGestion", _cuestionarioGestion, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

    String resultado = null;
    List<String> listaEmpleado = new ArrayList<String>();
    JSONParser parser = new JSONParser();
    int idCiclo = 0;
    try{

        if(request.getParameter("Object") != null){
           //Recuperamos el JSON con el nombre "Object" de la vista
            String js = request.getParameter("Object"); 
            //Convertimos a un objeto
            Object obj = parser.parse(new StringReader(js));
            //Asignamos a un objeto creado de tipo JSONObject
            JSONObject json = (JSONObject) obj;
            //Extraemos el id del ciclo
            idCiclo = Integer.parseInt((String) json.get("idCiclo"));
            //Extraemos todas las listas de empleados del JSON 
            JSONArray JSONEmpleados = (JSONArray) json.get("empleados");
            for(int i = 0; i < JSONEmpleados.size(); i++){                
                String idEmploy = null;
                JSONObject JSONEmpleado = (JSONObject) JSONEmpleados.get(i);  
                idEmploy = (String) JSONEmpleado.get("idEmpleado");

                listaEmpleado.add(idEmploy);
  
            }
        }        
    }catch(Exception e){
        listaEmpleado =null;
        idCiclo = 0;
    }
    
    resultado =  _cuestionarioGestion.AgregaEmpleadoAGestion(idCiclo, listaEmpleado);    
    if (resultado.equalsIgnoreCase("Ok")) {

      out.write("\r\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\r\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $('#formulario_registro').modal('hide');\r\n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\r\n");
      out.write("            location.reload();\r\n");
      out.write("        });\r\n");
      out.write("        $(\"form\")[0].reset();\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
} else {
      out.write("\r\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\r\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\r\n");
      out.write("    ");
      out.print(resultado);
      out.write("\r\n");
      out.write("</div>\r\n");
}
      out.write('\r');
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
