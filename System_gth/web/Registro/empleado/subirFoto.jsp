<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.*" %>
<%@ page import="java.io.*" %>

<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />

<%
    /*FileItemFactory es una interfaz para crear FileItem*/
    FileItemFactory file_factory = new DiskFileItemFactory();
    String codigo_personal = request.getParameter("cod_per");
    /*ServletFileUpload esta clase convierte los input file a FileItem*/
    ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
    /*sacando los FileItem del ServletFileUpload en una lista */
    List items = servlet_up.parseRequest(request);
    System.out.print(items.size());

    for (int i = 0; i < items.size(); i++) {
        /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
        FileItem item = (FileItem) items.get(i);
        /*item.isFormField() false=input file; true=text field*/
        if (!item.isFormField()) {
            /*cual sera la ruta al archivo en el servidor*/
            Random rnd = new Random();
            int numero = 100000000 + rnd.nextInt(900000000);

            String nombre_foto = codigo_personal + "-" + numero + ".jpeg";
            //File archivo_server = new File("F:/SistemasRoberto/rep_jas_youtube/web/folder_fotos/" + item.getName());
            File archivo_server = new File("F:/SistemasRoberto/System_Gth/System_gth/web/folder_picture/" + nombre_foto);
            /*y lo escribimos en el servido*/
            item.write(archivo_server);

            String actualizar_foto = _empleado.Actualizamos_foto_empleado(nombre_foto, Integer.parseInt(codigo_personal));
            System.out.print("Nombre --> " + item.getName());
            System.out.print("<br> Tipo --> " + item.getContentType());
            System.out.print("<br> tamaño --> " + (item.getSize() / 1240) + "KB");
            System.out.print("<br>");
        }
    }
%>