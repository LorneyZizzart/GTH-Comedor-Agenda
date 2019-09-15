package org.apache.jsp.Respuesta.respuesta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Pregunta_opcion;
import Entidad.Pregunta;
import java.util.*;
import Entidad.Cuestionario;
import Entidad.Login_Entidad;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Respuesta/respuesta/head.jsp");
    _jspx_dependants.add("/Respuesta/respuesta/footer.jsp");
  }

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
      Controlador.LoginController _login = null;
      synchronized (_jspx_page_context) {
        _login = (Controlador.LoginController) _jspx_page_context.getAttribute("_login", PageContext.PAGE_SCOPE);
        if (_login == null){
          _login = new Controlador.LoginController();
          _jspx_page_context.setAttribute("_login", _login, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>GTH | Encuesta</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <!-- Bootstrap validator -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/css/bootstrapValidator.css\"/>\n");
      out.write("        <!-- Select2 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/select2/select2.min.css\">\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/externo/font-awesome.min.css\">\n");
      out.write("        <!-- Ionicons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/externo/ionicons.min.css\">\n");
      out.write("        <!-- DataTables -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/datatables/dataTables.bootstrap.css\">\n");
      out.write("        <!-- Theme style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/css/AdminLTE.min.css\">\n");
      out.write("        <!-- AdminLTE Skins. Choose a skin from the css/skins\n");
      out.write("             folder instead of downloading all of them to reduce the load. -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/css/skins/_all-skins.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/css/myStyle.css\">\n");
      out.write("\n");
      out.write("        <!-- Para Mostrar las alertas Toast-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/toast_alert/toastr.css\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("        ");
      Controlador.EncriptionController _encripta = null;
      synchronized (_jspx_page_context) {
        _encripta = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encripta", PageContext.PAGE_SCOPE);
        if (_encripta == null){
          _encripta = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encripta", _encripta, PageContext.PAGE_SCOPE);
        }
      }
      out.write("   \n");
      out.write("        ");

            String idEncrip = request.getParameter("iasdfsdfasdf121as2dd1f21sf12d");
            idEncrip = idEncrip.replace(" ", "+");
            int id = Integer.parseInt(_encripta.ValorADesencriptar(idEncrip));
            Login_Entidad usuario_evalua = new Login_Entidad();
            usuario_evalua = _login.evaluacion_login((id));

        
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .loader{\n");
      out.write("                background-image: url(../../bootstrap/images/ajax-loader.gif);\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-position: center;\n");
      out.write("                height: 100px;                \n");
      out.write("            }          \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition  skin-purple-light sidebar-mini\">\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("            <header class=\"main-header\">\n");
      out.write("                <!-- Logo -->\n");
      out.write("                <a class=\"logo logo-respuesta\">\n");
      out.write("                    <span class=\"logo-lg\"><b>GTH</b>UAB</span>\n");
      out.write("                </a>\n");
      out.write("                <!-- Header Navbar: style can be found in header.less -->\n");
      out.write("                <nav class=\"navbar navbar-static-top\">\n");
      out.write("                    <!-- Sidebar toggle button-->\n");
      out.write("                    <div class=\"navbar-custom-menu\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">   \n");
      out.write("                            <!-- User Account: style can be found in dropdown.less -->\n");
      out.write("                            <li class=\"dropdown user user-menu\">\n");
      out.write("                                <a class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("\n");
      out.write("                                    ");
if (usuario_evalua.getUser_id() > 0) {
                                    
      out.write("\n");
      out.write("                                    <input id=\"cuestionario_id_evalua\" type=\"hidden\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("                                    <img src=\"../../dist/img/user2-160x160.jpg\" class=\"user-image\" alt=\"User Image\">\n");
      out.write("                                    <span class=\"hidden-xs\">");
      out.print(usuario_evalua.getNombreCompleto());
      out.write("</span>");

                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </header>");
      out.write(" \n");
      out.write("\n");
      Controlador.CuestionarioController _cuestionario = null;
      synchronized (_jspx_page_context) {
        _cuestionario = (Controlador.CuestionarioController) _jspx_page_context.getAttribute("_cuestionario", PageContext.PAGE_SCOPE);
        if (_cuestionario == null){
          _cuestionario = new Controlador.CuestionarioController();
          _jspx_page_context.setAttribute("_cuestionario", _cuestionario, PageContext.PAGE_SCOPE);
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
      out.write('\n');
//Verificamos que aya usuario
    if (usuario_evalua.getUser_id() > 0) {
        Cuestionario cuestionario = new Cuestionario();
        List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
        List<Pregunta_opcion> opciones = new ArrayList<Pregunta_opcion>();
        cuestionario = _cuestionario.ComenzarEvaluacion(id);

        if (cuestionario == null) {
            //en caso que no se encuente el cuestionario    


      out.write("\n");
      out.write("No se encontro cuestionario\n");
} else {

    if (cuestionario.getLLeno_cuestionario() == 1) {
        //En caso que este lleno el cuestionario


      out.write("\n");
      out.write("<section class=\"content-encuesta\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12\">            \n");
      out.write("\n");
      out.write("            <div class=\"box box-purple box-encuesta\">\n");
      out.write("                <div class=\"box-header\">\n");
      out.write("                    <h2>El cuestionario se encuentra llenado.</h2>                    \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- /.box-body -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("</section>\n");
} else {
    //out.print("Estado cuestionario " + cuestionario.getLLeno_cuestionario());
    listaPreguntas = cuestionario.getPreguntas();
    int contador = 0;

      out.write("\n");
      out.write("\n");
      out.write("<section class=\"content-encuesta\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12\">            \n");
      out.write("\n");
      out.write("            <div class=\"box box-purple box-encuesta\">\n");
      out.write("                <div class=\"box-header\">\n");
      out.write("                    <h2>");
      out.print(cuestionario.getNombre());
      out.write("</h2>\n");
      out.write("                    <p class=\"pull-right\">Descripción:\n");
      out.write("                        <span style=\"background-color: #ed1c24\" class=\"badge\">Malo</span> \n");
      out.write("                        <span style=\"background-color: #fff200; color: #000\" class=\"badge\">Regular</span>\n");
      out.write("                        <span style=\"background-color: #00a2e8\" class=\"badge\">Bueno</span>\n");
      out.write("                        <span style=\"background-color: #22b14c\" class=\"badge\">Excelente</span>\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- /.box-header -->\n");
      out.write("                <div class=\"box-body table-responsive\">\n");
      out.write("\n");
      out.write("                    <div id=\"form_guardar\" class=\"form_guardar\">\n");
      out.write("                        ");


                            for (Pregunta item : listaPreguntas) {
                                contador++;
                                if (item.getEstado() == 1) {
                        
      out.write("\n");
      out.write("                        <div class=\"form-group group-pregunta\">\n");
      out.write("                            <label class=\"nombre-pregunta\">");
      out.print(contador);
      out.write(" - ");
      out.print(item.getNombre());
      out.write("</label>\n");
      out.write("                            <table class=\"text-center table\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr >\n");
      out.write("                                        ");


                                            for (Pregunta_opcion opcion : item.getPreguntaOpcion()) {
                                        
      out.write("\n");
      out.write("                                        <th style=\"background-color: #");
      out.print(opcion.getCss());
      out.write('"');
      out.write('>');
      out.print(opcion.getOpcion());
      out.write("</th>                                \n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                    </tr>                                    \n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                <input type=\"hidden\" id=\"pregunta_id_");
      out.print(contador);
      out.write("\" value=\"");
      out.print(item.getPregunta_id());
      out.write("\">\n");
      out.write("                                ");

                                    for (Pregunta_opcion opcion : item.getPreguntaOpcion()) {
                                
      out.write("\n");
      out.write("                                <td style=\"background-color: #");
      out.print(opcion.getCss());
      out.write("\">\n");
      out.write("                                    <input type=\"radio\" name=\"respuesta_");
      out.print(contador);
      out.write("\" data-pregunta=\"");
      out.print(item.getPregunta_id());
      out.write("\" value=\"");
      out.print(opcion.getOpcion());
      out.write("\" >\n");
      out.write("                                </td>\n");
      out.write("                                ");
}
                                
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>   \n");
      out.write("                        ");
}
                            }
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"box-footer footer-encuesta\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-default pull-left cerrar_pestania\" data-dismiss=\"modal\" onClick=\"Finalizar();\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                            <button type=\"botton\" class=\"btn-purple pull-right\" id=\"enviar_respuestas\"><i class=\"fa fa-send\"></i> Enviar</button>\n");
      out.write("                            <input type=\"hidden\" id=\"tamanio_preguntas\" value=\"");
      out.print(contador);
      out.write("\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"mensaje_encuesta\"></div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box-body -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
}
    }
} else {
    // En caso que no aya usuario

      out.write("\n");
      out.write("No hay usuario\n");
      out.write("\n");
      out.write("<section class=\"content-encuesta\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12\">            \n");
      out.write("\n");
      out.write("            <div class=\"box box-purple box-encuesta\">\n");
      out.write("                <div class=\"box-header\">\n");
      out.write("                    <h2>No se encontró usuario para realizar la encuesta.</h2>                    \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- /.box-body -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("</section>\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<!-- jQuery 2.2.3 -->\n");
      out.write("<!--<script src=\"../../plugins/jQuery/jquery-2.2.3.min.js\"></script>-->\n");
      out.write("<script src=\"../../plugins/jQuery/jquery-3.4.1.min.js\"></script>\n");
      out.write("<!-- Bootstrap 3.3.6 -->\n");
      out.write("<script src=\"../../bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    /* $(\".cerrar_pestania\").click(function (e) {\n");
      out.write("     e.preventDefault();\n");
      out.write("     e.stopImmediatePropagation();\n");
      out.write("     \n");
      out.write("     window.open(\"\", \"_self\");\n");
      out.write("     window.close();\n");
      out.write("     });*/\n");
      out.write("    function Finalizar() {\n");
      out.write("        window.location.href = '../../index.jsp';\n");
      out.write("    }\n");
      out.write("    $(\"#enviar_respuestas\").click(function (e) {\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("        $('#mensaje_encuesta').html('');\n");
      out.write("        var cantidad_preguntas = $('#tamanio_preguntas').val();\n");
      out.write("\n");
      out.write("        var array_nota = [];\n");
      out.write("        for (var i = 1; i <= cantidad_preguntas; i++) {\n");
      out.write("            var seleccion = 'respuesta_' + i;\n");
      out.write("            var opcion_seleccionado = $(\"input[name=\" + seleccion + \"]:checked\").val()\n");
      out.write("            if (opcion_seleccionado == null) {\n");
      out.write("                var mensaje = '<div class=\"alert alert-warning\" role=\"alert\"> <strong>Ups!</strong> Se requiere de seleccione una respuesta en la pregunta .<strong>' + i + '</strong> </div>';\n");
      out.write("                $('#mensaje_encuesta').html(mensaje);\n");
      out.write("                return false;\n");
      out.write("            } else {\n");
      out.write("                var pregunta_id = $('#pregunta_id_' + i).val();\n");
      out.write("                var cuestionario_id_evalua = $('#cuestionario_id_evalua').val();\n");
      out.write("                var guardar = opcion_seleccionado + '-' + pregunta_id + '-' + cuestionario_id_evalua;\n");
      out.write("                array_nota.push(guardar);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        //alert(array_nota);\n");
      out.write("        $.ajax({\n");
      out.write("            type: \"POST\",\n");
      out.write("            url: \"guarda_respuestas.jsp\",\n");
      out.write("            data: {ids: array_nota},\n");
      out.write("            success: function (data)\n");
      out.write("            {\n");
      out.write("                $(\"#mensaje_encuesta\").removeClass(\"loader\");\n");
      out.write("                $(\"#mensaje_encuesta\").html(data);\n");
      out.write("            }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                $(\"#mensaje_encuesta\").removeClass(\"loader\");\n");
      out.write("                var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                $(\"#mensaje_encuesta\").html(menn);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("</html>");
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
