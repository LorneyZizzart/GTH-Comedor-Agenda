package org.apache.jsp.Agenda.Administrar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.A_PathTarea;
import java.util.ArrayList;
import java.util.List;
import Entidad.A_Tarea;

public final class verTarea_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_ProcedimientoTareaController _proceso = null;
      synchronized (_jspx_page_context) {
        _proceso = (Controlador.A_ProcedimientoTareaController) _jspx_page_context.getAttribute("_proceso", PageContext.PAGE_SCOPE);
        if (_proceso == null){
          _proceso = new Controlador.A_ProcedimientoTareaController();
          _jspx_page_context.setAttribute("_proceso", _proceso, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_PathTareaController _path = null;
      synchronized (_jspx_page_context) {
        _path = (Controlador.A_PathTareaController) _jspx_page_context.getAttribute("_path", PageContext.PAGE_SCOPE);
        if (_path == null){
          _path = new Controlador.A_PathTareaController();
          _jspx_page_context.setAttribute("_path", _path, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String[] id = request.getParameter("id").split("%"); 
    A_Tarea tarea = new A_Tarea();
    List<A_Tarea> procesos = new ArrayList<A_Tarea>();
    List<A_PathTarea> listaPath = new ArrayList<A_PathTarea>();
    tarea = _tarea.getTareaByTitulo(id[0], Integer.parseInt(id[1]));
    listaPath = _path.getAllPath(id[0], Integer.parseInt(id[1]));

    if(Integer.parseInt(id[2]) == 1){
        tarea = _tarea.getTareaById(tarea.getIdTarea());
        procesos = _proceso.getAllProcedimientoTarea(tarea.getTitulo(),tarea.getIdUserCrea());
    }else{
        procesos = _proceso.getAllProcedimientoTarea(id[0], Integer.parseInt(id[1]));
    }
    

      out.write("\n");
      out.write("<div style=\" padding: 0 2% 2% 2%; border: solid 1px #d2d2d2; background-color: white;\">\n");
      out.write("    <!--titulo-->\n");
      out.write("\n");
      out.write("        <div class=\"box-header\" style=\"padding: 0;margin: 27px 0 0 0\"> \n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <h4 class=\"box-title\" style=\"font-weight: bold\">");
      out.print(tarea.getTitulo());
      out.write("</h4>\n");
      out.write("            </div>   \n");
      out.write("            <div class=\"row\" style=\"margin: 20px 0 0 0;\">\n");
      out.write("                <div class=\"col-md-6 col-xs-12\" style=\"padding-left: 10px;\">\n");
      out.write("                    <p> <a class=\"name\">Tipo de repetición: </a>");
      out.print(tarea.getNombreRepeticion());
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 col-xs-12\" style=\"padding-left: 10px;\">\n");
      out.write("                    <p> <a class=\"name\">Fecha de inicio: </a>");
      out.print(tarea.getFechaInicio());
      out.write(' ');
      out.print(tarea.getHoraInicio());
      out.write(" </p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 col-xs-12\" style=\"padding-left: 10px;\">\n");
      out.write("                    <p> <a class=\"name\">Dias: </a>\n");
      out.write("                        ");
if(tarea.getLunes()> 0){
      out.write("\n");
      out.write("                        <span >Lunes </span>\n");
      out.write("                        ");
 } if(tarea.getMartes()> 0){
      out.write("\n");
      out.write("                        <span>Martes </span>\n");
      out.write("                        ");
 } if(tarea.getMiercoles()> 0){
      out.write("\n");
      out.write("                        <span>Miercoles </span>\n");
      out.write("                        ");
 } if(tarea.getJueves()> 0){
      out.write("\n");
      out.write("                        <span>Jueves </span>\n");
      out.write("                        ");
 } if(tarea.getViernes()> 0){
      out.write("\n");
      out.write("                        <span>Viernes </span>\n");
      out.write("                        ");
 } if(tarea.getSabado()> 0){
      out.write("\n");
      out.write("                        <span>Sábado </span>\n");
      out.write("                        ");
 } if(tarea.getDomingo()> 0){
      out.write("\n");
      out.write("                        <span>Domingo </span></p>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                </div>\n");
      out.write("                ");

                if(Integer.parseInt(id[2]) == 1){
                
      out.write("\n");
      out.write("                <div class=\"col-md-6 col-xs-12\" style=\"padding-left: 10px;\">\n");
      out.write("                    <p> <a class=\"name\">Estado: </a>");
      out.print(tarea.getNombreEstadoTarea());
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                 ");
  } 
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>     \n");
      out.write("                <div class=\"box-body\">\n");
      out.write("                    <p>");
      out.print(tarea.getDescripcion());
      out.write("</p>\n");
      out.write("                    ");

                                int contador = 0;
                                for (A_Tarea p : procesos) {
                                    contador++;

            
      out.write("\n");
      out.write("\n");
      out.write("            <h5 class=\"box-title\" style=\"font-weight: bold\">");
      out.print(contador);
      out.write('.');
      out.write(' ');
      out.print(p.getNombreProcedimiento());
      out.write("</h5>\n");
      out.write("             <p>");
      out.print(p.getDescripcionProcedimiento());
      out.write("</p>\n");
      out.write("    ");
  } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"box-footer\">\n");
      out.write("                    <h4>IMAGENES DE REFERENCIA</h4>\n");
      out.write("                    ");

                                for (A_PathTarea path : listaPath) {

            
      out.write("\n");
      out.write("                            <div id=\"divimgSalida\" class=\"col-md-2 text-center cont-image\" style=\"border: solid 1px #aba8a8; margin: 2px;padding: 0;\">\n");
      out.write("                                \n");
      out.write("                                <img id=\"imgSalida'+numImage+'\" width=\"100%\" height=\"100%\" src=\"../../folder_picture/");
      out.print(path.getPathImage());
      out.write("\" />\n");
      out.write("                                <label id=\"imgSalida\">");
      out.print(path.getNombrePath());
      out.write("</label>\n");
      out.write("                            </div>\n");
      out.write("    ");
  } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("</div>");
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
