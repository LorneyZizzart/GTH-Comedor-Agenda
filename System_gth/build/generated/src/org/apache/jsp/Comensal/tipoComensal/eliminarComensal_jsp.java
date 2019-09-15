package org.apache.jsp.Comensal.tipoComensal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.C_TipoComensal;

public final class eliminarComensal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      Controlador.C_TipoComensalesController _tipoComensalController = null;
      synchronized (_jspx_page_context) {
        _tipoComensalController = (Controlador.C_TipoComensalesController) _jspx_page_context.getAttribute("_tipoComensalController", PageContext.PAGE_SCOPE);
        if (_tipoComensalController == null){
          _tipoComensalController = new Controlador.C_TipoComensalesController();
          _jspx_page_context.setAttribute("_tipoComensalController", _tipoComensalController, PageContext.PAGE_SCOPE);
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
      Controlador.CharacterController _character = null;
      synchronized (_jspx_page_context) {
        _character = (Controlador.CharacterController) _jspx_page_context.getAttribute("_character", PageContext.PAGE_SCOPE);
        if (_character == null){
          _character = new Controlador.CharacterController();
          _jspx_page_context.setAttribute("_character", _character, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idEncript = request.getParameter("id");
    int id = 0;
    C_TipoComensal entidad = new C_TipoComensal();
    
    try {
        id = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        entidad = _tipoComensalController.getTipoComensalById(id);
    }catch (Exception e) {
        id = 0;
    }

      out.write("\n");
      out.write("         <form id=\"form_guardar\" method=\"post\" class=\"form_area_guardar\">\n");
      out.write("             <input type=\"hidden\" value=\"");
      out.print(id);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"box-body\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Nombre</label>\n");
      out.write("                                <input disabled type=\"text\" class=\"form-control\" id=\"tipo_comensal_nombre\"  name=\"tipo_comensal_nombre\" value=\"");
      out.print(_character.CharacterUCFirst(entidad.getNombreComensal()));
      out.write("\">                            \n");
      out.write("                            </div>   \n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Descuento de desayuno</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"descuentoDesayuno\"  name=\"descuentoDesayuno\" value=\"");
      out.print(entidad.getDescuentoDesayuno());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Descuento de almuerzo</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"descuentoAlmuerzo\"  name=\"descuentoAlmuerzo\" value=\"");
      out.print(entidad.getDescuentoAlmuerzo());
      out.write("\">                         \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Descuento de cena</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"descuentoCena\"  name=\"descuentoCena\" value=\"");
      out.print(entidad.getDescuentoCena());
      out.write("\">                          \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Día Inicio</label>\n");
      out.write("                            <input disabled type=\"text\" class=\"form-control\" id=\"diaInicio\"  name=\"diaInicio\" value=\"");
      out.print(entidad.getDiaInicio());
      out.write("\">                            \n");
      out.write("                        </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Estado</label>\n");
      out.write("                                ");

                                    String select = "";
                                    if(entidad.getEstado() > 0){
                                        select = "checked";
                                    }
                                
      out.write("\n");
      out.write("                                <label> <input disabled  type=\"checkbox\" name=\"tipo_comensal_estado\" id=\"tipo_comensal_estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                            </div>   \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id_menu = $(\"#id\").val();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("            $.post('deleteComensal.jsp',\n");
      out.write("                    {id: id_menu},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensaje\").removeClass('loader');\n");
      out.write("                        $(\"#mensaje\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("</script>\n");
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
