package org.apache.jsp.Comensal.editarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.C_Empleado_Reserva;

public final class eliminarReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_EmpleadoReservaController _empleadoReserva = null;
      synchronized (_jspx_page_context) {
        _empleadoReserva = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("_empleadoReserva", PageContext.PAGE_SCOPE);
        if (_empleadoReserva == null){
          _empleadoReserva = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("_empleadoReserva", _empleadoReserva, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String[] idReserva = request.getParameter("id").split("%");
    if(Integer.parseInt(idReserva[1]) == 1){
        empleadoReserva = _empleadoReserva.getReservaEmpleadoById(Integer.parseInt(idReserva[0]));
    }else{
        empleadoReserva = _empleadoReserva.getReservaExternoById(Integer.parseInt(idReserva[0]));
    }

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(idReserva[0]);
      out.write('%');
      out.print(idReserva[1]);
      out.write("\" name=\"idReserva\" id=\"idReserva\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre completo: </label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" value=\"");
      out.print(empleadoReserva.getNombreEmpleado());
      out.write("\">                            \n");
      out.write("                        </div>                          \n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Teléfono</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" value=\"");
      out.print(empleadoReserva.getTelefono());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Observación</label>\n");
      out.write("                            <textarea disabled class=\"form-control\" rows=\"3\" id=\"observacion\"  name=\"observacion\">");
      out.print(empleadoReserva.getObservacion());
      out.write("</textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Cantidad</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"cantidad\"  name=\"cantidad\" value=\"");
      out.print(empleadoReserva.getCantidad());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Descuento adicional</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"descuentoAdicional\"  name=\"descuentoAdicional\" value=\"");
      out.print(empleadoReserva.getDescuentoAdicional());
      out.write("\">  \n");
      out.write("                        </div>   \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("      $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#idReserva\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('deleteReserva.jsp',\n");
      out.write("                    {id: id_menu},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("</script>");
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
