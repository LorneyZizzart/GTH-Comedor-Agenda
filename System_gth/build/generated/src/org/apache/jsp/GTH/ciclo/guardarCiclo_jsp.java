package org.apache.jsp.GTH.ciclo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import Entidad.Cuestionario_gestion;
import org.json.simple.parser.JSONParser;

public final class guardarCiclo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Cuestionario_gestionController _ciclo = null;
      synchronized (_jspx_page_context) {
        _ciclo = (Controlador.Cuestionario_gestionController) _jspx_page_context.getAttribute("_ciclo", PageContext.PAGE_SCOPE);
        if (_ciclo == null){
          _ciclo = new Controlador.Cuestionario_gestionController();
          _jspx_page_context.setAttribute("_ciclo", _ciclo, PageContext.PAGE_SCOPE);
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

    Cuestionario_gestion ciclo = new Cuestionario_gestion();
    List<String> listaEmpleado = new ArrayList<String>();
    String resultado = null;
    JSONParser parser = new JSONParser();
    try{
        if(request.getParameter("Object") != null){
            //Recuperamos el JSON con el nombre "Object" de la vista
            String js = request.getParameter("Object");
            //Convertimos a un objeto
            Object obj = parser.parse(new StringReader(js));
            //Asignamos a un objeto creado de tipo JSONObject
            JSONObject json = (JSONObject) obj;
            //Extraemos el id del ciclo
            ciclo.setCuestionario_gestion_id(Integer.parseInt(_encript.ValorADesencriptar((String) json.get("idCiclo"))));
            ciclo.setUsuario_crea(Integer.parseInt(_encript.ValorADesencriptar((String) json.get("idUsuairo"))));
            ciclo.setUsuario_actualiza(Integer.parseInt(_encript.ValorADesencriptar((String) json.get("idUsuairo"))));
            ciclo.setNombre((String) json.get("nombreCuestionario"));
            ciclo.setDescripciom((String) json.get("descripcion"));
            int estado = 0;
            if((Boolean) json.get("estado")){
              estado = 1;
            } else {
                estado = 0;
            }
            ciclo.setEstado(estado);
            //Extraemos todas las listas del JSON 
            JSONArray JSONEmpleados = (JSONArray) json.get("empleados");
            for(int i = 0; i < JSONEmpleados.size(); i++){
                
                String idEmploy = null;
                JSONObject JSONEmpleado = (JSONObject) JSONEmpleados.get(i);  
                idEmploy = (String) JSONEmpleado.get("idEmpleado");
                System.out.print("Entro "+idEmploy);
                listaEmpleado.add(idEmploy);
            }
        }
        
    }catch(Exception e){
        ciclo = null;
        listaEmpleado = null;
    }
    resultado = _ciclo.SaveorUpdateCuestionario_gestion(ciclo, listaEmpleado);

    if (resultado.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
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
