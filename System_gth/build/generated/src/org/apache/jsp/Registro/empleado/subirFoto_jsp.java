package org.apache.jsp.Registro.empleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.*;
import java.io.*;

public final class subirFoto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.EmpleadoController _empleado = null;
      synchronized (_jspx_page_context) {
        _empleado = (Controlador.EmpleadoController) _jspx_page_context.getAttribute("_empleado", PageContext.PAGE_SCOPE);
        if (_empleado == null){
          _empleado = new Controlador.EmpleadoController();
          _jspx_page_context.setAttribute("_empleado", _empleado, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

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
