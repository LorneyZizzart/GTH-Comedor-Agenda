package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_PathTarea;
import java.util.ArrayList;
import java.util.List;

public final class listFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_PathTareaController _path = null;
      synchronized (_jspx_page_context) {
        _path = (Controlador.A_PathTareaController) _jspx_page_context.getAttribute("_path", PageContext.PAGE_SCOPE);
        if (_path == null){
          _path = new Controlador.A_PathTareaController();
          _jspx_page_context.setAttribute("_path", _path, PageContext.PAGE_SCOPE);
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

    String idTarea = request.getParameter("id");
    List<A_PathTarea> listaP = new ArrayList<A_PathTarea>();
    listaP =null;// _path.getAllPath(Integer.parseInt(idTarea));

      out.write("\n");
      out.write("<div class=\"box-header\" style=\"padding: 0 0 2% 0\">\n");
      out.write("        <h3 class=\"box-title\">Lista de archivos</h3>\n");
      out.write("        <a data-id=\"");
      out.print(idTarea);
      out.write("\" style=\"cursor:pointer;\" class=\"formNewFile btn-purple pull-right\" data-toggle=\"modal tooltip\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"Añadir archivo\">\n");
      out.write("                        <i class=\"fa fa-plus\"></i>\n");
      out.write("         </a>\n");
      out.write("                        <div id=\"mensajeFile\"></div>\n");
      out.write("    </div>\n");
      out.write("<div class=\"box-body table-responsive\" style=\"padding: 0px 5px 30px 5px;\">\n");
      out.write("                    <table id=\"example1\" class=\"display table table-bordered table-striped\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th style=\"width: 2%\">#</th>                                \n");
      out.write("                                <th style=\"width: 20%\">Archivo</th>\n");
      out.write("                                <th style=\"width: 2%\">Opciones</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                int contador = 0;
                                for (A_PathTarea p : listaP) {
                                    contador++;

                            
      out.write("\n");
      out.write("                            <tr id=\"");
      out.print(p.getIdPath());
      out.write("\">\n");
      out.write("                                <td>");
      out.print(contador);
      out.write("</td>    \n");
      out.write("                                ");

                                    String typeFile = "archivo";
                                    if(p.getTypeFilePath().equals("png") || p.getTypeFilePath().equals("jpeg") || p.getTypeFilePath().equals("jpg") || p.getTypeFilePath().equals("gif") || p.getTypeFilePath().equals("svg")){
                                      typeFile = "image";                                      
                                    }else if(p.getTypeFilePath().equals("docx")){
                                        typeFile = "docx";    
                                    }else if(p.getTypeFilePath().equals("xlsx")){
                                        typeFile = "excel";    
                                    }else if(p.getTypeFilePath().equals("pptx")){
                                        typeFile = "powerpoint";    
                                    }else if(p.getTypeFilePath().equals("mp3")){
                                        typeFile = "audio";    
                                    }else if(p.getTypeFilePath().equals("mp4")){
                                        typeFile = "video";    
                                    }else if(p.getTypeFilePath().equals("pdf")){
                                       typeFile = "pdf";     
                                    }
                                
      out.write("\n");
      out.write("                                <td><a href=\"downloadFile.jsp\" target=\"_blank\"><img style=\"width: 40px;\" src=\"../../images/");
      out.print(typeFile);
      out.write(".png\" alt=\"message user image\"> ");
      out.print(p.getNombrePath());
      out.write("</a></td>          \n");
      out.write("                                <td class=\"text-center\">\n");
      out.write("                                    <div class=\"btn-group \">                          \n");
      out.write("                                        <button href=\"../../../../Files/\" data-id=\"");
//=p.getPath()
      out.write("\" class=\"DownloadFile btn btn-success btn-xs\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Descargar\"> <i class=\"fa  fa-download\"></i></button>                                \n");
      out.write("                                        <a data-id=\"");
      out.print(p.getIdPath());
      out.write("\" class=\"DeletFile btn btn-danger btn-xs delete_button\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Eliminar\"> <i class=\"fa fa-trash-o\"></i></a>           \n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                         \n");
      out.write("                </div>\n");
      out.write("<script>\n");
      out.write("    $(\".formNewFile\").click(function (e) {\n");
      out.write("        $(\".modal-dialog-edit\").width(\"25%\");\n");
      out.write("        $(\".modal-dialog-edit\").css('margin-right', \"37.5%\");\n");
      out.write("        $(\".modal-dialog-edit\").css('margin-left', \"37.5%\");\n");
      out.write("        $(\"#titleModal\").html(\"Adjuntar nuevo archivo\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('crearFile.jsp',\n");
      out.write("            {id: $(this).attr('data-id')},\n");
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
      out.write("    });\n");
      out.write("    $(\".DeletFile\").click(function (e) {\n");
      out.write("        var id = $(this).attr('data-id');\n");
      out.write("//       console.log('#'+id);\n");
      out.write("        $('#'+id).hide();\n");
      out.write("            $(\"#mensajeFile\").show();\n");
      out.write("            $(\"#mensajeFile\").addClass(\"loader\");\n");
      out.write("            $.post('eliminarFile.jsp',\n");
      out.write("                    {id: id},\n");
      out.write("                    function (html) {\n");
      out.write("                        $(\"#mensajeFile\").removeClass('loader');\n");
      out.write("                        $(\"#mensajeFile\").html(html);\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    function descargarArchivo(contenidoEnBlob, nombreArchivo) {\n");
      out.write("        var reader = new FileReader();\n");
      out.write("        reader.onload = function (event) {\n");
      out.write("            var save = document.createElement('a');\n");
      out.write("            save.href = event.target.result;\n");
      out.write("            save.target = '_blank';\n");
      out.write("            save.download = nombreArchivo || 'archivo.dat';\n");
      out.write("            var clicEvent = new MouseEvent('click', {\n");
      out.write("                'view': window,\n");
      out.write("                    'bubbles': true,\n");
      out.write("                    'cancelable': true\n");
      out.write("            });\n");
      out.write("            save.dispatchEvent(clicEvent);\n");
      out.write("            (window.URL || window.webkitURL).revokeObjectURL(save.href);\n");
      out.write("        };\n");
      out.write("        reader.readAsDataURL(contenidoEnBlob);\n");
      out.write("    };\n");
      out.write("    \n");
      out.write("    $(\".DownloadFile\").click(function (e) {\n");
      out.write("        var url = $(this).attr('data-id');\n");
      out.write("        var cmd = \"explorer.exe /e,\"+url;\n");
      out.write("    \tRegWsh = new ActiveXObject(\"WScript.Shell\");\n");
      out.write("        RegWsh.Run(cmd);\n");
      out.write("    });\n");
      out.write("                            \n");
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
