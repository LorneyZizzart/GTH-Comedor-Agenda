package org.apache.jsp.GTH.evaluacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cliente;
import Entidad.View_Empleado_Encuesta;
import java.util.ArrayList;
import java.util.List;

public final class guardar_005fevaluadores_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.Cuestionario_evaluaController _guardar_evaluadores = null;
      synchronized (_jspx_page_context) {
        _guardar_evaluadores = (Controlador.Cuestionario_evaluaController) _jspx_page_context.getAttribute("_guardar_evaluadores", PageContext.PAGE_SCOPE);
        if (_guardar_evaluadores == null){
          _guardar_evaluadores = new Controlador.Cuestionario_evaluaController();
          _jspx_page_context.setAttribute("_guardar_evaluadores", _guardar_evaluadores, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String id_personal = request.getParameter("id_empleado");
    String id_gestion = request.getParameter("id_ciclo_gestion");
    String id_cuestionario = request.getParameter("id_cuestionario");
    String auto_evaluacion = request.getParameter("autoevaluacion");
    
    List<View_Empleado_Encuesta> save_Jefes = new ArrayList<View_Empleado_Encuesta>();
    
    List<View_Empleado_Encuesta> save_Pares = new ArrayList<View_Empleado_Encuesta>();
    
    List<View_Empleado_Encuesta> save_Bajos = new ArrayList<View_Empleado_Encuesta>();
    
    List<Cliente> save_clientes = new ArrayList<Cliente>();

    //out.print("  codigo Personal = " + id_personal + "  gestion_id = " + id_gestion + "  cuestionario_id= " + id_cuestionario);
    //optenemos los Jefes
    try {
        String[] getJefes = request.getParameterValues("jefes[]");
        for (String j : getJefes) {
            View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
            jefe.setEmpleado_id(Integer.parseInt(j));
            save_Jefes.add(jefe);
        }
    } catch (Exception e) {
        System.out.println(" No tiene jefes");
    }

//optenemos los Pares
    try {
        String[] getPares = request.getParameterValues("pares[]");
        for (String p : getPares) {
            View_Empleado_Encuesta par = new View_Empleado_Encuesta();
            par.setEmpleado_id(Integer.parseInt(p));
            save_Pares.add(par);
        }
    } catch (Exception e) {
        System.out.println(" No tiene jefes");
    }

//optenemos los Bajos
    try {
        String[] getbajos = request.getParameterValues("bajos[]");
        for (String b : getbajos) {
            View_Empleado_Encuesta bajo = new View_Empleado_Encuesta();
            bajo.setEmpleado_id(Integer.parseInt(b));
            save_Bajos.add(bajo);
        }
    } catch (Exception e) {
        System.out.println(" No tiene Bajos");
    }
//optenemos los Clientes
   //optenemos los Clientes
    try {
        String[] getclientes = request.getParameterValues("clientes[]");
        for (String b : getclientes) {
            String[] parts = b.split("-");
            String a = parts[0];//codigo
            String bb = parts[1];//tipo E=Empleado, C=Ciente
            Cliente cliente = new Cliente();
            cliente.setCliente_id(Integer.parseInt(a));
            cliente.setTelefono(bb);
            save_clientes.add(cliente);
        }
    } catch (Exception e) {
        System.out.println(" No tiene Clientes");
    }
    
    View_Empleado_Encuesta guardar = new View_Empleado_Encuesta();
    
    guardar.setEmpleado_id(Integer.parseInt(id_personal));
    guardar.setCuestionario_id(Integer.parseInt(id_cuestionario));
    guardar.setCuestionario_gestion_id(Integer.parseInt(id_gestion));
    guardar.setAuto_evaluacion(auto_evaluacion);
    
    guardar.setJefes(save_Jefes);
    guardar.setPares(save_Pares);
    guardar.setBajos(save_Bajos);
    guardar.setClientes(save_clientes);
    
    String guarda_evaluador = _guardar_evaluadores.SaveUnCuestionario_evalua(guardar);
    
    out.print(guarda_evaluador);
    

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
