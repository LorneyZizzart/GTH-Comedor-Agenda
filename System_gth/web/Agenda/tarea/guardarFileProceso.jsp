<%@page import="Entidad.A_Tarea"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_procedimiento" class="Controlador.A_ProcedimientoTareaController"/>
<%
                FileItemFactory file_factory = new DiskFileItemFactory();
                        /*ServletFileUpload esta clase convierte los input file a FileItem*/
                ServletFileUpload servlet_up = new ServletFileUpload(file_factory);

                        /*sacando los FileItem del ServletFileUpload en una lista */
                List items = servlet_up.parseRequest(request);


                for(int i=0;i<items.size();i++){
                                /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
                    FileItem item = (FileItem) items.get(0);
                                /*item.isFormField() false=input file; true=text field*/
                    if (! item.isFormField()){
                                        /*cual sera la ruta al archivo en el servidor*/
                                        File archivo_server = new File("E:/Proyectos/GTH/System_gth/web/folder_picture/Procesos/"+item.getName());
                                        
                                        if (!archivo_server.exists()) {
                                            item.write(archivo_server);
                                        }                                       

                                        %>

                                <%
                        out.print(item.getName());

                    }
        }

        
 %>
