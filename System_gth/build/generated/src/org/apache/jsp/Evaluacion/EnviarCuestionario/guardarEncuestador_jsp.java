package org.apache.jsp.Evaluacion.EnviarCuestionario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cliente;
import java.sql.Array;
import java.io.StringReader;
import org.json.simple.JSONObject;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.util.*;
import Entidad.View_Empleado_Encuesta;

public final class guardarEncuestador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      Controlador.Cuestionario_empleadoController _cuestionarioEmpleado = null;
      synchronized (_jspx_page_context) {
        _cuestionarioEmpleado = (Controlador.Cuestionario_empleadoController) _jspx_page_context.getAttribute("_cuestionarioEmpleado", PageContext.PAGE_SCOPE);
        if (_cuestionarioEmpleado == null){
          _cuestionarioEmpleado = new Controlador.Cuestionario_empleadoController();
          _jspx_page_context.setAttribute("_cuestionarioEmpleado", _cuestionarioEmpleado, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Cuestionario_evaluaController _cuestionarioEvalua = null;
      synchronized (_jspx_page_context) {
        _cuestionarioEvalua = (Controlador.Cuestionario_evaluaController) _jspx_page_context.getAttribute("_cuestionarioEvalua", PageContext.PAGE_SCOPE);
        if (_cuestionarioEvalua == null){
          _cuestionarioEvalua = new Controlador.Cuestionario_evaluaController();
          _jspx_page_context.setAttribute("_cuestionarioEvalua", _cuestionarioEvalua, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    int idCuestionario = 0, idEmpleado = 0, autoEvaluacion = 0;
    List<View_Empleado_Encuesta> encuesta = new ArrayList<View_Empleado_Encuesta>();
    JSONParser parser = new JSONParser();
 
    try{
          if(request.getParameter("Object") != null){            
            //Recuperamos el JSON con el nombre "Object" de la vista
            String js = request.getParameter("Object");
            //Convertimos a un objeto
            Object obj = parser.parse(new StringReader(js));
            //Asignamos a un objeto creado de tipo JSONObject
            JSONObject json = (JSONObject) obj;
            //Extraemos el id del cuestionario
            idCuestionario = Integer.parseInt((String) json.get("idCuestionario"));
            //extraemos a todos los funcionarios con sus respectivas listas de jefes-pares-bajos y clientes            
            JSONArray employess = (JSONArray) json.get("empleado");            
            
            for(int i = 0; i < employess.size(); i++){
            // Creamos un empleado para luego llenar la lista de encuesta que son los encuestadores
            View_Empleado_Encuesta empleado = new View_Empleado_Encuesta();
            //a cada empleado le asignamos la encuesta
            empleado.setCuestionario_id(idCuestionario);
            //Asignamos a cada funcionario a un objeto
            JSONObject employee = (JSONObject) employess.get(i);
            //Extraemos el id del empleado
            idEmpleado = Integer.parseInt((String) employee.get("idEmpleado"));
            //llenamos el objeto con el id correspondiente
            empleado.setEmpleado_id(idEmpleado);

            if(employee.get("autoEvaluacion").equals("on")){
                autoEvaluacion = 1;
            }else{
                autoEvaluacion = 0;
            }
            //Extraemos todas las listas del JSON 
            JSONArray JSONjefes = (JSONArray) employee.get("jefe");
            JSONArray JSONpares = (JSONArray) employee.get("par");
            JSONArray JSONbajos = (JSONArray) employee.get("bajo");
            JSONArray JSONclientes = (JSONArray) employee.get("cliente"); 
            //Iteramos cada lista del JSON para luego llenarlo al objeto empleado
            //Iteracion de la lista jefe
            for(int j = 0; j < JSONjefes.size(); j++){
                JSONObject JSONjefe = (JSONObject) JSONjefes.get(j);  
                List<View_Empleado_Encuesta> jefes = new ArrayList<View_Empleado_Encuesta>();
                try{
                    if(JSONjefe.get("idJefe") != null ){
                        JSONArray idj = (JSONArray) JSONjefe.get("idJefe");
                        for(int a = 0; a < idj.size(); a++){
                            View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
                            jefe.setEmpleado_id(Integer.parseInt((String) idj.get(a)));  
                            jefes.add(jefe);
                        }                        
                    }
                }catch (Exception e){
                    jefes = null;
                }
                empleado.setJefes(jefes);
            }
            //Iteracion de la lista par
            for(int p = 0; p < JSONpares.size(); p++){
                JSONObject JSONpar = (JSONObject) JSONpares.get(p);
                List<View_Empleado_Encuesta> pares = new ArrayList<View_Empleado_Encuesta>();
                try{
                    if(JSONpar.get("idPar") != null ){
                        JSONArray idp = (JSONArray) JSONpar.get("idPar");
                        for(int a = 0; a < idp.size(); a++){
                            View_Empleado_Encuesta par = new View_Empleado_Encuesta();
                            par.setEmpleado_id(Integer.parseInt((String) idp.get(a)));
                            pares.add(par);                       }
                        
                    }
                }catch (Exception e){
                    pares = null;
                }
                empleado.setPares(pares);
            }
            //Iteracion de la lista bajo
            for(int b = 0; b < JSONbajos.size(); b++){
                JSONObject JSONbajo = (JSONObject) JSONbajos.get(b);
                List<View_Empleado_Encuesta> bajos = new ArrayList<View_Empleado_Encuesta>();                
                try{
                    if(JSONbajo.get("idBajo") != null ){
                       JSONArray idb = (JSONArray) JSONbajo.get("idBajo");
                        for(int a = 0; a < idb.size(); a++){
                            View_Empleado_Encuesta bajo = new View_Empleado_Encuesta();
                            bajo.setEmpleado_id(Integer.parseInt((String) idb.get(a)));
                            bajos.add(bajo);
                        }                          
                    }
                }catch (Exception e){
                    bajos = null;
                }
                empleado.setBajos(bajos);
            }
            //Iteracion de la lista cliente
            for(int c = 0; c < JSONclientes.size(); c++){
                JSONObject JSONcliente = (JSONObject) JSONclientes.get(c);
                List<Cliente> clientes = new ArrayList<Cliente>();
                
                try{
                    if(JSONcliente.get("idCliente") != null ){
                       JSONArray idc = (JSONArray) JSONcliente.get("idCliente");
                        for(int a = 0; a < idc.size(); a++){
                            Cliente cliente = new Cliente();
                            cliente.setCliente_id(Integer.parseInt((String) idc.get(a)));
                            clientes.add(cliente);
                        }                         
                    }
                }catch (Exception e){
                    clientes = null;
                } 
                empleado.setClientes(clientes);
                } 
            encuesta.add(empleado);
            }
            
          }
    }catch (Exception e){
        idCuestionario = 0;
    }
    
    String resultado = _cuestionarioEvalua.SaveCuestionario_evalua(encuesta);

    if (resultado.equalsIgnoreCase("Ok")) {

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\n");
      out.write("//            location.reload();\n");
      out.write("        });\n");
      out.write("//        $(\"form\")[0].reset();\n");
      out.write("    });\n");
      out.write("</script>\n");
} else {
      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    <p>ERROR: ");
      out.print(resultado);
      out.write("</p>\n");
      out.write("</div>\n");
}
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
