package org.apache.jsp.Comensal.tipoComensal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.C_TipoComensal;

public final class guardarComensal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.C_TipoComensalesController _tipoComenzalController = null;
      synchronized (_jspx_page_context) {
        _tipoComenzalController = (Controlador.C_TipoComensalesController) _jspx_page_context.getAttribute("_tipoComenzalController", PageContext.PAGE_SCOPE);
        if (_tipoComenzalController == null){
          _tipoComenzalController = new Controlador.C_TipoComensalesController();
          _jspx_page_context.setAttribute("_tipoComenzalController", _tipoComenzalController, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    C_TipoComensal tipoComensal = new C_TipoComensal();
    tipoComensal.setTipoComensal_id(Integer.parseInt(request.getParameter("id")));
    
    tipoComensal.setNombreComensal(request.getParameter("nombre"));
    tipoComensal.setMinimoDias(1);
    tipoComensal.setDescuentoDesayuno(Double.parseDouble(request.getParameter("descuentoDesayuno")));
    tipoComensal.setDescuentoAlmuerzo(Double.parseDouble(request.getParameter("descuentoAlmuerzo")));
    tipoComensal.setDescuentoCena(Double.parseDouble(request.getParameter("descuentoCena")));
    tipoComensal.setDiasAnticipacion(Integer.parseInt(request.getParameter("diasAnticipacion")));
    tipoComensal.setUsuarioCrea(Integer.parseInt(request.getParameter("idUsuario")));
    int estado = 0;
    try{
        if(request.getParameter("tipo_comensal_estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    tipoComensal.setEstado(estado);
    
    String resultado = _tipoComenzalController.SaveOrUpdate(tipoComensal);
//    String resultado = "";

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
}else{
      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
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
