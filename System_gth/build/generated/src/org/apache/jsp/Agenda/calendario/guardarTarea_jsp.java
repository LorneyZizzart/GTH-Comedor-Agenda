package org.apache.jsp.Agenda.calendario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.io.File;
import Entidad.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
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
    List<Empleado> Empleados = new ArrayList<Empleado>();
    try{
        tarea.setIdTarea(Integer.parseInt(request.getParameter("id")));
        
        if(tarea.getIdTarea() == 0)
        tarea.setIdUserCrea(Integer.parseInt(request.getParameter("idUsuario")));
        tarea.setFechaInicio(request.getParameter("fi"));
        tarea.setFechaFinal(request.getParameter("ff"));
        tarea.setAuxFechaFinal(request.getParameter("fechaFinal"));
        tarea.setTitulo(String.valueOf(request.getParameter("titulo")));
        tarea.setCodigo("");
        tarea.setVersion("");
        tarea.setDescripcion("");
        tarea.setColor("");       
        tarea.setHoraInicio(request.getParameter("horaInicio")); 
        tarea.setHoraFinal(request.getParameter("horaFinal"));
        tarea.setIdRepeticionTarea(Integer.parseInt(request.getParameter("idRepeticion")));
        tarea.setIdTipoTarea(Integer.parseInt(request.getParameter("idCategoria")));
        tarea.setIdEstadoTarea(Integer.parseInt(request.getParameter("idEstado")));     

        resultado = _tarea.SaveOrUpdateCalendar(tarea);
        
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }
    
//    File file ;
//    int maxFileSize = 5000 * 1024;
//    int maxMemSize = 5000 * 1024;
//    ServletContext context = pageContext.getServletContext();
//    String filePath = context.getInitParameter("file-upload");
//             
//
//    // Verify the content type
//    String contentType = request.getContentType();
//    
//    if ((contentType.indexOf("multipart/form-data") >= 0)) {
//        resultado = "Ok";
//         DiskFileItemFactory factory = new DiskFileItemFactory();
//      // maximum size that will be stored in memory
//      factory.setSizeThreshold(maxMemSize);
//      
//      // Location to save data that is larger than maxMemSize.
//      factory.setRepository(new File("E:\\JS\\GTH\\System_gth\\web\\AgendaArchivos"));
//
//      // Create a new file upload handler
//      ServletFileUpload upload = new ServletFileUpload(factory);
//      
//      // maximum file size to be uploaded.
//      upload.setSizeMax( maxFileSize );
//      
//      try { 
//         // Parse the request to get file items.
//         List fileItems = upload.parseRequest(request);
//
//         // Process the uploaded file items
//         Iterator i = fileItems.iterator();
//
//         while ( i.hasNext () ) {
//            FileItem fi = (FileItem)i.next();
//            if ( !fi.isFormField () ) {
//               // Get the uploaded file parameters
//               String fieldName = fi.getFieldName();
//               String fileName = fi.getName();
//               boolean isInMemory = fi.isInMemory();
//               long sizeInBytes = fi.getSize();
//            
//               // Write the file
//               if( fileName.lastIndexOf("\\") >= 0 ) {
//                  file = new File( filePath + 
//                  fileName.substring( fileName.lastIndexOf("\\"))) ;
//               } else {
//                  file = new File( filePath + 
//                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
//               }
//               fi.write( file ) ;
//               out.println("Uploaded Filename: " + filePath + 
//               fileName + "<br>");
//            }
//         }
//      } catch(Exception ex) {
//         System.out.println(ex);
//      }
//    }

//    otro

//    String urlArchive = "E:\\JS\\GTH\\System_gth\\web\\AgendaArchivos";
//    DiskFileItemFactory factory = new DiskFileItemFactory();
//    factory.setSizeThreshold(1024);
//    factory.setRepository(new File(urlArchive));
//    ServletFileUpload upload = new ServletFileUpload(factory);
//    try {
//            List<FileItem> partes = upload.parseRequest(request);
//            for(FileItem item : partes){
//                File file =  new File(urlArchive, item.getName());
//                item.write(file);
//            }
//            resultado = "Ok";
//        } catch (Exception e) {
//            resultado =  "No se logro captar el archivo. Error: " + e;
//        }

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
