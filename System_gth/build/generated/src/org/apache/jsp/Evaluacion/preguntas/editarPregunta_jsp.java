package org.apache.jsp.Evaluacion.preguntas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Entidad.Pregunta;
import Entidad.Tipo;

public final class editarPregunta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    String idUsuarioEncript = request.getParameter("idUser");
    String idCuestionariooEncript = request.getParameter("idCuestionario");
    
    List<Tipo> listaTipoPregunta = new ArrayList<Tipo>();
    listaTipoPregunta = _tipoPregunta.GetAllTipo();

    int idPregunta = 0;
    Pregunta pregunta = new Pregunta();    

    try {
        idPregunta = Integer.parseInt(_encript.ValorADesencriptar(idPreguntaEncript));
        pregunta = _pregunta.GetPreguntaByPregunta_Id(idPregunta);
    }catch (Exception e) {
        idPregunta = 0;
    }

      out.write("\n");
      out.write("<form id=\"form_editar\" method=\"post\" class=\"form_editar\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idCuestionariooEncript);
      out.write("\" name=\"idCuestionario\" id=\"idCuestionario\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idPreguntaEncript);
      out.write("\" name=\"idPregunta\" id=\"idPregunta\">\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(idUsuarioEncript);
      out.write("\" name=\"idUsuario\" id=\"idUsuario\">\n");
      out.write("            <div class=\"box-body\">\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                <label>Tipo</label>\n");
      out.write("                <select name=\"idTipo\" class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                  <option>Selecione una opción</option>\n");
      out.write("                    ");

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
      out.write("                   <input type=\"text\" class=\"form-control\" id=\"pregunta\"  name=\"pregunta\" value=\"");
      out.print(pregunta.getNombre());
      out.write("\">                            \n");
      out.write("                </div>                  \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                   <label>Orden</label>\n");
      out.write("                   <input type=\"text\" class=\"form-control\" id=\"orden\"  name=\"orden\" value=\"");
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
      out.write("                        <button type=\"submit\" class=\"btn btn-primary pull-right\"><i class=\"fa fa-refresh\"></i> Actualizar</button>\n");
      out.write("                    </div>\n");
      out.write(" </form>\n");
      out.write("<div id=\"mensajeEditar\"></div>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $('.form_editar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                idTipo: {\n");
      out.write("                    message: 'El tipo de pregunta no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Debe seleccionar un tipo de pregunta. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                pregunta:{\n");
      out.write("                    message: 'La pregunta no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'La pregunta no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 6,\n");
      out.write("                            max: 100,\n");
      out.write("                            message: 'El Nombre tiene que ser mas de 6 y menos de 100 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z()0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü¿?-\\s])+$/i,\n");
      out.write("                            message: 'La pregunta solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                orden: {\n");
      out.write("                    message: 'El valor del orden no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El valor del orden no puede ser vacio.'\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 1,\n");
      out.write("                            max: 3,\n");
      out.write("                            message: 'El valor del orden tiene que ser de 1 a 3 caracteres.'\n");
      out.write("                        },\n");
      out.write("                        integer: {\n");
      out.write("                            message: 'El valor tiene que ser un número.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#mensajeEditar\").show();\n");
      out.write("            $(\"#mensajeEditar\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"guardarPregunta.jsp\",\n");
      out.write("                data: $(\".form_editar\").serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#mensajeEditar\").removeClass(\"loader\");\n");
      out.write("                    $(\"#mensajeEditar\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#mensajeEditar\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#mensajeEditar\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
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
