package org.apache.jsp.planificaEstrate.plan_005faccion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Login_Entidad;
import Entidad.Plan_accion_files;
import Entidad.Plan_accion;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.Calendar;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      Controlador.Plan_accion_filesController guardar_file = null;
      synchronized (_jspx_page_context) {
        guardar_file = (Controlador.Plan_accion_filesController) _jspx_page_context.getAttribute("guardar_file", PageContext.PAGE_SCOPE);
        if (guardar_file == null){
          guardar_file = new Controlador.Plan_accion_filesController();
          _jspx_page_context.setAttribute("guardar_file", guardar_file, PageContext.PAGE_SCOPE);
        }
      }
      out.write(' ');
      out.write('\n');

    HttpSession sesion = request.getSession();
    //out.print(sesion.getAttribute("USUARIO"));
    if (session.getAttribute("USUARIO") == null) {

      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    Termino su sesión, ingrese nuevamente haga clic <a href=\"../../\"> aquí.</a>\n");
      out.write("</div>\n");

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

                        if (resultado.equalsIgnoreCase("Ok")) {
      out.write("\n");
      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\".loading_file\").hide(1500, function () {\n");
      out.write("            location.reload();\n");
      out.write("        });\n");
      out.write("        $(\"form\")[0].reset();\n");
      out.write("    });\n");
      out.write("</script>\n");
} else {
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

      out.write('\n');
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
