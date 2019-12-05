package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.commons.fileupload.FileItem;
import java.util.List;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import Entidad.A_Tarea;

public final class guardarTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
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

    A_Tarea tarea = new A_Tarea();
    String resultado = null;
    
    try{
        tarea.setIdTarea(Integer.parseInt(request.getParameter("id")));
        tarea.setIdUserCrea(Integer.parseInt(request.getParameter("idFunc")));
        tarea.setTitulo(request.getParameter("titulo"));
        tarea.setDescripcion(request.getParameter("descripcion"));        
        tarea.setIdRepeticionTarea(Integer.parseInt(request.getParameter("idRepeticion")));
        tarea.setIdEstadoTarea(Integer.parseInt(request.getParameter("idEstado")));
        tarea.setFechaInicio(String.valueOf(request.getParameter("fi")));
        tarea.setHoraInicio(request.getParameter("horaInicio"));
        tarea.setIdTipoTarea(1);
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }

    try{
        if(request.getParameter("L").equalsIgnoreCase("on"))
            tarea.setLunes(1);
    }catch(Exception e){
        tarea.setLunes(0);
    }
    
    try{
        if(request.getParameter("Ma").equalsIgnoreCase("on"))
            tarea.setMartes(1);
    }catch(Exception e){
        tarea.setMartes(0);
    }
    
    try{
        if(request.getParameter("Mi").equalsIgnoreCase("on"))
            tarea.setMiercoles(1);
    }catch(Exception e){
        tarea.setMiercoles(0);
    }
    
    try{
        if(request.getParameter("J").equalsIgnoreCase("on"))
            tarea.setJueves(1);
    }catch(Exception e){
        tarea.setJueves(0);
    }
    try{
        if(request.getParameter("V").equalsIgnoreCase("on"))
            tarea.setViernes(1);
    }catch(Exception e){
        tarea.setViernes(0);
    }
    
    try{
        if(request.getParameter("S").equalsIgnoreCase("on"))
            tarea.setSabado(1);;
    }catch(Exception e){
        tarea.setSabado(0);;
    }
    
    try{
        if(request.getParameter("D").equalsIgnoreCase("on"))
            tarea.setDomingo(1);            
    }catch(Exception e){
        tarea.setDomingo(0); 
    }
    if(request.getParameter("proceso").equalsIgnoreCase("insert")){
//        resultado = "Ok";
        
        resultado = _tarea.SaveTarea(tarea);
        
        if(resultado.equalsIgnoreCase("Ok")){
            A_Tarea auxTarea = new A_Tarea();
            auxTarea = _tarea.getMaxIdTarea();
        
      out.write("\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(request.getParameter("titulo"));
      out.write("\" name=\"gTitulo\" id=\"gTitulo\">\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(request.getParameter("idFunc"));
      out.write("\" name=\"gIdUsuario\" id=\"gIdUsuario\">\n");
      out.write("    <div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("        <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("    </div>\n");
      out.write("     <script type=\"text/javascript\">\n");
      out.write("        $(document).ready(function () {  \n");
      out.write("            localStorage.setItem(\"idTarea\", $('#gTitulo').val()+\"%\"+$('#gIdUsuario').val());\n");
      out.write("            for (var i = 0; i < listaImage.length; i++) {\n");
      out.write("                saveImageDB(");
      out.print(auxTarea.getIdTarea());
      out.write(", listaImage[i].titulo, listaImage[i].nameImage);\n");
      out.write("                saveImage(listaImage[i].path);\n");
      out.write("          }\n");
      out.write("            $(\"#mensaje\").hide(3000, function () {                \n");
      out.write("                $('.form-group').removeClass('has-success');\n");
      out.write("                $('.glyphicon-ok').hide();\n");
      out.write("                $('#btnProcess').show();\n");
      out.write("                $('#btnGuardar').hide();  \n");
      out.write("            });\n");
      out.write("        });    \n");
      out.write("    </script>\n");
      out.write("    ");

        
    }}
    else {

        resultado = _tarea.UpdateTarea(tarea, request.getParameter("oldTitulo"), Integer.parseInt(request.getParameter("idFunc")));
        if(resultado.equalsIgnoreCase("Ok")){
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("            <h4><i class=\"icon fa fa-check\"></i> Actualizado</h4>\n");
      out.write("        </div>\n");
      out.write("         <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                \n");
      out.write("                for (var i = 0; i < listaImage.length; i++) {\n");
      out.write("                saveImageDB(");
      out.print(request.getParameter("id"));
      out.write(", listaImage[i].titulo, listaImage[i].nameImage);\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                $(\"#mensaje\").hide(3000, function () {\n");
      out.write("                    location.reload();\n");
      out.write("                });\n");
      out.write("                $(\"form\")[0].reset();\n");
      out.write("            });   \n");
      out.write("        </script>\n");
      out.write("        ");

    }}
    
    if(!resultado.equals("Ok")){
        

      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    ");
      out.print(resultado);
      out.write("\n");
      out.write("</div>\n");
}
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
