<%--<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="org.apache.commons.io.output.*" %>--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.File"%>
<%@page import="Entidad.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
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
        tarea.setDescripcion(String.valueOf(request.getParameter("descripcion")));
        tarea.setColor(String.valueOf(request.getParameter("color")));       
        tarea.setHoraInicio(request.getParameter("horaInicio")); 
        tarea.setHoraFinal(request.getParameter("horaFinal"));
        tarea.setIdRepeticionTarea(Integer.parseInt(request.getParameter("idRepeticion")));
        tarea.setIdTipoTarea(Integer.parseInt(request.getParameter("idCategoria")));
        tarea.setIdEstadoTarea(Integer.parseInt(request.getParameter("idEstado")));
        tarea.setPath("");
        if (request.getParameterValues("funcionario") != null) {
            String[] funcionario  = request.getParameterValues("funcionario");
            for(String f : funcionario){
                Empleado e = new Empleado();
                e.setEmpleado_id(Integer.parseInt(f));
                Empleados.add(e);
            }
        }
        tarea.setEmpleados(Empleados);
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
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
 <script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>
