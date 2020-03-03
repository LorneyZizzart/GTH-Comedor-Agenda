package org.apache.jsp.Comensal.editarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.C_TipoComida;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import Entidad.C_Empleado_Reserva;

public final class guardarReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.C_TipoComidaController _tipoComida = null;
      synchronized (_jspx_page_context) {
        _tipoComida = (Controlador.C_TipoComidaController) _jspx_page_context.getAttribute("_tipoComida", PageContext.PAGE_SCOPE);
        if (_tipoComida == null){
          _tipoComida = new Controlador.C_TipoComidaController();
          _jspx_page_context.setAttribute("_tipoComida", _tipoComida, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_EmpleadoReservaController _empleadoReserva = null;
      synchronized (_jspx_page_context) {
        _empleadoReserva = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("_empleadoReserva", PageContext.PAGE_SCOPE);
        if (_empleadoReserva == null){
          _empleadoReserva = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("_empleadoReserva", _empleadoReserva, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    List<C_Empleado_Reserva> reservasNow = new ArrayList<C_Empleado_Reserva>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String resultado = "", auxResultado = "";
    try{
        
        
        Date date = formatter.parse(request.getParameter("fi"));
        calendar.setTime(date);
        empleadoReserva.setFecha(calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
        int tipoComensal = 1;
        if(Integer.parseInt(request.getParameter("tipoComensal")) == 1){
            tipoComensal = 2;
        }
        empleadoReserva.setIdTipoComensal(tipoComensal);
        empleadoReserva.setNotificacion(0);
        empleadoReserva.setListarNotifiacion(0);
        empleadoReserva.setObservacion(request.getParameter("observacion"));

        

        if(Integer.parseInt(request.getParameter("funcionario")) == 1){
            empleadoReserva.setIdUser(Integer.parseInt(request.getParameter("idEmpleado")));
            reservasNow = _empleadoReserva.getReservaByIdDate(empleadoReserva.getIdUser(), calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
//            System.out.print(reservasNow.size());
//           for(C_Empleado_Reserva reserva : reservasNow){
//              System.out.print("idREserva");
//              System.out.print(reserva.getIdTipoComida());
//           }
//           for(C_TipoComida tipoComida : listaTipoComida){
//               System.out.print("idPLato");
//              System.out.print(tipoComida.getIdTipoComida());
//           }
//           List<String> idsComida = new ArrayList<String>();
            for(C_TipoComida tipoComida : listaTipoComida){
                for(C_Empleado_Reserva reserva : reservasNow){
                    if(reserva.getIdTipoComida() != tipoComida.getIdTipoComida()){
                        if(request.getParameter("cantidad"+tipoComida.getNombreComida())!= null){
                            empleadoReserva.setIdTipoComida(tipoComida.getIdTipoComida());
                            empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad"+tipoComida.getNombreComida())));
                            _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
                        }                        
                        auxResultado = auxResultado + "<div class='alert alert-success  alert-dismissible'> " +
                                " <button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>" +
                                "<i class='fa fa-check' style='color: green;'></i> Se reservaó: "+tipoComida.getNombreComida() + " satisfactoriamente"+
                                "</div>";
                        break;
                    }else{                        
                        auxResultado = auxResultado + "<div class='alert alert-warning alert-dismissible'> " +
                                " <button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>" +
                                "<i class='fa fa-close' style='color: red;'></i> Existe "+tipoComida.getNombreComida()+" reservado" +
                                "</div>";
                        break;
                    }
                }
                
            }
            

        }else{

            empleadoReserva.setNombreCompleto(request.getParameter("nombreCompleto"));
            empleadoReserva.setCelular(Integer.parseInt(request.getParameter("celular")));
            resultado = _empleadoReserva.SaveComensalExterno(empleadoReserva);
        }
    }catch(Exception e){
        resultado = "No se obtuvo todos los datos: " + e;
        System.out.print("No se obtuvo todos los datos: " + e);
    }
    if(resultado.equalsIgnoreCase("Ok")){

      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Reserva realizada</h4>\n");
      out.write("</div>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\n");
      out.write("            location.reload();\n");
      out.write("        });\n");
      out.write("        $(\"form\")[0].reset();\n");
      out.write("    });\n");
      out.write("</script>\n");

} else {

      out.write("\n");
      out.write("    ");
      out.print(auxResultado);
      out.write('\n');
      out.write('\n');
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
