
<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.Plan_accion_files"%>
<%@page import="Entidad.Plan_accion"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>


<jsp:useBean id="guardar_file" class="Controlador.Plan_accion_filesController" /> 
<%
    HttpSession sesion = request.getSession();
    //out.print(sesion.getAttribute("USUARIO"));
    if (session.getAttribute("USUARIO") == null) {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Termino su sesión, ingrese nuevamente haga clic <a href="../../"> aquí.</a>
</div>
<%
} else {

    Login_Entidad DatoUsuario = new Login_Entidad();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    int id_numeracion = 0;

    Calendar fecha = new GregorianCalendar();
    String hora = fecha.get(Calendar.HOUR_OF_DAY) + "-" + fecha.get(Calendar.MINUTE) + "-" + fecha.get(Calendar.SECOND);

    File file;
    int maxFileSize = 10000 * 1024;
    int maxMemSize = 10000 * 1024;
    //String filePath = "c:/apache-tomcat/webapps/data/";
//    String filePath = "D:/SistemasRoberto/acad10/web/acuerdo_rectoral/files/upload/";
    String filePath = "C:/matriz_upload/";
    String contentType = request.getContentType();
    System.out.print(contentType);
    String ids = request.getParameter("id");
    String cod_personal = request.getParameter("codigo_personal");
    if ((contentType.indexOf("multipart/form-data") >= 0)) {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File("c:\\temp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);
        try {
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            // out.println("<html>");
            // out.println("<body>");
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName().replace(" ", "");
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    //file = new File(filePath + "yourFileName");
                    String name_save = hora + fileName;
                    file = new File(filePath + name_save);
                    if (!fileName.isEmpty()) {
                        fi.write(file);
                        Plan_accion_files f = new Plan_accion_files();
                        f.setNombre(fileName);
                        f.setNombre_archivo(name_save);
                        f.setEstado(1);
                        f.setEmpleado_id(DatoUsuario.getEmpleado_id());
                        f.setPlan_accion_id(Integer.parseInt(ids));

                        String resultado = guardar_file.SaveFile(f);

                        if (resultado.equalsIgnoreCase("Ok")) {%>

<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".loading_file").hide(1500, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%} else {
                                out.print("<div class='alert alert-danger' role='alert'> <strong>Upss!</strong>Se produjo un error al  guardar. " + resultado + "</div>");
                            }
                        } else {
                            out.print("<div class='alert alert-danger' role='alert'> <strong>Upss!</strong>Se produjo un error al  guardar. Seleccione un Archivo </div>");
                        }
                    }
                }

            } catch (Exception ex) {
                out.print("<div class='alert alert-danger' role='alert'> <strong>Upss!</strong>Esta permitido un maximo de 10 MB. <br>" + ex.getMessage() + " </div>");
            }
        } else {
            out.print("<div class='alert alert-danger' role='alert'> <strong>Upss!</strong>Se produjo un error al  guardar. </div>");
        }
    }
%>

