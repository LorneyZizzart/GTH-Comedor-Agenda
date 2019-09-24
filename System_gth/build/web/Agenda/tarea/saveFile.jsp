<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>

        <%
//        este archivo aun no utilizamos xke encontramos otra alternativa
            String archivourl = "E:\\file";
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            factory.setSizeThreshold(1024);
            
            factory.setRepository(new File(archivourl));
            
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            
            try{
                
                List<FileItem> partes = upload.parseRequest(request);
                
                for(FileItem items: partes){
                    File file = new File(archivourl,items.getName());
                    System.out.print("nombre: "+items.getName());
                    items.write(file);
                }
                
                out.print("<h2>ARCHIVO CORRECTAMENTE SUBIDO.....</h2>"+"\n\n"+"<a href='index.jsp'>VOVLER AL MENU</a>");

                
            }catch(Exception e){
                out.print("Exception: "+e.getMessage()+"");
            } finally {

            }

        %>
