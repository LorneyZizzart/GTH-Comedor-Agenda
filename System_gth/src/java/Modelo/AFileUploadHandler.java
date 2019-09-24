/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Invitado1
 */
public class AFileUploadHandler extends HttpServlet{
    
    String urlSaveFile = "E:\\Proyectos\\GTH\\Files\\";
    
    private static final long serialVersionUID = 1 ;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String file_name = null;
        String id = null;
        String path = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
        return;
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
        List < FileItem > fields = upload.parseRequest(request);
        Iterator < FileItem > it = fields.iterator();
        if (!it.hasNext()) {
        return;
        }
        while (it.hasNext()) {
        FileItem fileItem = it.next();
        boolean isFormField = fileItem.isFormField();
        if (isFormField) {
        if (file_name == null) {
            if(fileItem.getFieldName().equals("id")){
                id = fileItem.getString();
                System.out.print("id: "+id);
            }

        if (fileItem.getFieldName().equals("nombreFile")) {

        file_name = fileItem.getString();
        System.out.print("name: "+file_name);
        }
        }
        } else {
        if (fileItem.getSize() > 0) {
        path = urlSaveFile+id+"\\" + fileItem.getName();
        fileItem.write(new File(path));
        System.out.print("direccion: " + path);
        }
        }
        
        
        }
        String result = this.savePathTarea(id, file_name, path);
        if(result.equals("Ok")){
            System.out.print("Archivo almacenado correctamente");
        }else{
            System.out.print("El archivo no fue almacenado correctamente: "+result);
        }
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        out.println("<script type='text/javascript'>");
        out.println("window.location.href='index.jsp?filename="+file_name+"'");
        out.println("</script>");
        out.close();
        }
    }
    
    public String savePathTarea(String idTarea, String nameFile, String pathFile){
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO APath\n"
                    + "  (idTarea, nombre, path)"
                    + "  VALUES\n"
                    + "  ("+idTarea+",'"+nameFile+"','"+pathFile+"')";
            db.insertar(sql);
            db.cierraConexion();
                       
        } catch (SQLException e) {
            respuesta = "Modelo.AFileUploadHandler.savePathTarea() " + e.getMessage();
        }
        return respuesta;
    }
    
}
