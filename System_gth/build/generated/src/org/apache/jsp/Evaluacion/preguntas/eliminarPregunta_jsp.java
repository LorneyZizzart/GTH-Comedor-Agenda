package org.apache.jsp.Evaluacion.preguntas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Tipo;
import Entidad.Pregunta;
import java.util.*;

public final class eliminarPregunta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.PreguntaController _pregunta = null;
      synchronized (_jspx_page_context) {
        _pregunta = (Controlador.PreguntaController) _jspx_page_context.getAttribute("_pregunta", PageContext.PAGE_SCOPE);
        if (_pregunta == null){
          _pregunta = new Controlador.PreguntaController();
          _jspx_page_context.setAttribute("_pregunta", _pregunta, PageContext.PAGE_SCOPE);
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
      Controlador.TipoController _tipoPregunta = null;
      synchronized (_jspx_page_context) {
        _tipoPregunta = (Controlador.TipoController) _jspx_page_context.getAttribute("_tipoPregunta", PageContext.PAGE_SCOPE);
        if (_tipoPregunta == null){
          _tipoPregunta = new Controlador.TipoController();
          _jspx_page_context.setAttribute("_tipoPregunta", _tipoPregunta, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idPreguntaEncript = request.getParameter("id");

    int idPregunta = 0;
    Pregunta pregunta = new Pregunta();   
    
    List<Tipo> listaTipoPregunta = new ArrayList<Tipo>();
    listaTipoPregunta = _tipoPregunta.GetAllTipo();

    try {
        idPregunta = Integer.parseInt(request.getParameter("id"));
        pregunta = _pregunta.GetPreguntaByPregunta_Id(idPregunta);
    }catch (Exception e) {
        idPregunta = 0;
    }

      out.write("\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idPregunta);
      out.write("\" name=\"id\" id=\"id\">\n");
      out.write("            <div class=\"box-body\">\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                <label>Tipo</label>\n");
      out.write("                <select disabled name=\"idTipo\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                  <option>Selecione una opción</option>\n");
      out.write("                  ");

                    for (Tipo item : listaTipoPregunta) {
                        String Select = "";
                        if(item.getTipo_id() == pregunta.getTipo_id())
                            Select = "Selected";
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(item.getTipo_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </select>\n");
      out.write("              </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                   <label>Pregunta</label>\n");
      out.write("                   <input disabled type=\"text\" class=\"form-control\" id=\"pregunta\"  name=\"pregunta\" value=\"");
      out.print(pregunta.getNombre());
      out.write("\">                            \n");
      out.write("                </div>                  \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                   <label>Orden</label>\n");
      out.write("                   <input disabled type=\"text\" class=\"form-control\" id=\"orden\"  name=\"orden\" value=\"");
      out.print(pregunta.getOrden());
      out.write("\">                            \n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Estado</label>\n");
      out.write("                    ");

                     String select = "";
                      if(pregunta.getEstado() > 0){
                          select = "checked";
                      }
                    
      out.write("\n");
      out.write("                     <label> <input type=\"checkbox\" name=\"estado\" id=\"estado\"  class=\"flat-red\" ");
      out.print(select);
      out.write("></label>\n");
      out.write("                </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger pull-right btn_eliminar\"><i class=\"fa fa-trash-o\"></i> Eliminar</button>\n");
      out.write("                    </div>\n");
      out.write(" </form>\n");
      out.write("<div id=\"mensajeDelete\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".btn_eliminar\").click(function () {\n");
      out.write("            var id = $(\"#id\").val();\n");
      out.write("            $(\"#mensajeDelete\").show();\n");
      out.write("            $(\"#mensajeDelete\").addClass(\"loader\");\n");
      out.write("            $.post('deletePregunta.jsp',\n");
      out.write("                    {id: id},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensajeDelete\").removeClass('loader');\n");
      out.write("                        $(\"#mensajeDelete\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("    });\n");
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
