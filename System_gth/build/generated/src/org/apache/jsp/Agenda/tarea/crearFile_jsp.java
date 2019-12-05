package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class crearFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    String idTarea = request.getParameter("id");

      out.write("\n");
      out.write("<form id=\"form_guardar\"  class=\"form_guardar\" action=\"\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    <div id=\"imagenSubida\"></div>\n");
      out.write("    \n");
      out.write("                    <div class=\"form-group\" >\n");
      out.write("                            <label>Título</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"titulo\"  name=\"titulo\">                            \n");
      out.write("                    </div> \n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <!--<input type=\"file\" name=\"file2\" />-->\n");
      out.write("                            <input type=\"file\" class=\"form-control-file\" name=\"image\" id=\"image\" onchange=\"nameImage(this.value)\"><br>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left btn-rlistFile\" data-dismiss=\"modal\"><i class=\"fa fa-arrow-left\"></i> Volver</button>\n");
      out.write("                        <button type=\"button\" class=\"btn-purple pull-right upload\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("                    </div>\n");
      out.write("</form>\n");
      out.write("<script type=\"text/javascript\">  \n");
      out.write("    var nombreFichero = 'user.png';\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        cargarImagen('../../folder_picture/'+nombreFichero);\n");
      out.write("        \n");
      out.write("    });\n");
      out.write("    function nameImage(fic) {\n");
      out.write("        fic = fic.split('\\\\');\n");
      out.write("        nombreFichero = fic[fic.length-1];\n");
      out.write("//        alert(fic[fic.length-1]);\n");
      out.write("      }\n");
      out.write("    $(\".upload\").on('click', function() {\n");
      out.write("        var formData = new FormData();\n");
      out.write("        var files = $('#image')[0].files[0];\n");
      out.write("        formData.append('file',files);\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'guardarFile.jsp?id=");
      out.print(idTarea);
      out.write("',\n");
      out.write("            type: 'post',\n");
      out.write("            data: formData, \n");
      out.write("            contentType: false,\n");
      out.write("            processData: false,\n");
      out.write("            success: function(response) {\n");
      out.write("                if (response != 0) {\n");
      out.write("//                    $(\".card-img-top\").attr(\"src\", response);\n");
      out.write("//                    cargarImagen('../../folder_picture/diagrama-de-sectores.png');\n");
      out.write("                        cargarImagen('../../folder_picture/'+nombreFichero);\n");
      out.write("                } else {\n");
      out.write("                    alert('Formato de imagen incorrecto.');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        return false;\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    function cargarImagen(src){\n");
      out.write("        $.post('imagen.jsp',\n");
      out.write("            {src:src},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\"#imagenSubida\").removeClass('loader');\n");
      out.write("                    $(\"#imagenSubida\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\"#imagenSubida\").removeClass('loader');\n");
      out.write("                $(\"#imagenSubida\").html(alerta);\n");
      out.write("       }); \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    $(\".btn-rlistFile\").click(function (e) {\n");
      out.write("        $(\"#titleModal\").html(\"Archivos relacionados\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            \n");
      out.write("            $.post('listFile.jsp',\n");
      out.write("            {id: localStorage.getItem(\"idTarea\")},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("    }); \n");
      out.write("    \n");
      out.write("    $('.form_guardar').bootstrapValidator({\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                contentType: 'multipart/form-data',\n");
      out.write("                url: \"guardarFile.jsp\",\n");
      out.write("                type: 'POST',\n");
      out.write("                data: $(\".form_guardar\").serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    $(\"#mensaje\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#mensaje\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
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
