package org.apache.jsp.Comensal.empleadoReserva;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.C_EmpleadoReservaModel;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import Entidad.C_TipoComida;
import Entidad.C_Empleado_Reserva;
import Entidad.C_TipoComensal;

public final class guardarReservaEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.C_EmpleadoReservaController _empleadoReserva = null;
      synchronized (_jspx_page_context) {
        _empleadoReserva = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("_empleadoReserva", PageContext.PAGE_SCOPE);
        if (_empleadoReserva == null){
          _empleadoReserva = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("_empleadoReserva", _empleadoReserva, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_TipoComidaController _tipoComida = null;
      synchronized (_jspx_page_context) {
        _tipoComida = (Controlador.C_TipoComidaController) _jspx_page_context.getAttribute("_tipoComida", PageContext.PAGE_SCOPE);
        if (_tipoComida == null){
          _tipoComida = new Controlador.C_TipoComidaController();
          _jspx_page_context.setAttribute("_tipoComida", _tipoComida, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_TipoComensalesController _tipoComensal = null;
      synchronized (_jspx_page_context) {
        _tipoComensal = (Controlador.C_TipoComensalesController) _jspx_page_context.getAttribute("_tipoComensal", PageContext.PAGE_SCOPE);
        if (_tipoComensal == null){
          _tipoComensal = new Controlador.C_TipoComensalesController();
          _jspx_page_context.setAttribute("_tipoComensal", _tipoComensal, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
     
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    listaComensal = _tipoComensal.getAllTipoComensal();
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String resultado = "";
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    //variable para obtener la fecha de hoy
    Calendar fechaAnticipacion = Calendar.getInstance();
    Calendar fechaInicial = Calendar.getInstance();
    Date dateNow = formatter.parse(fechaAnticipacion.get(Calendar.DATE)+"/"+(fechaAnticipacion.get(Calendar.MONTH)+1)+"/"+fechaAnticipacion.get(Calendar.YEAR));
    fechaAnticipacion.setTime(dateNow);
    Boolean repeticion = false;
    try{
        if(request.getParameter("repetir").equalsIgnoreCase("on"))
        repeticion = true;
    }catch(Exception e){
        System.out.print("No se marco repetir todo el mes. " + e);
    }
    
    try {        
        
        Date dateStart = formatter.parse(request.getParameter("fechaInicio"));
        Date dateEnd = formatter.parse(request.getParameter("fechaFin"));
//        System.out.print("dateStart "+dateStart);
        int dias = 0;
        if(request.getParameter("fechaInicio").equals(request.getParameter("fechaFin"))){
            dias = 1;
        }else{
            dias=(int) ((dateEnd.getTime()-dateStart.getTime())/86400000);
        }        
//        System.out.print("dias "+dias);  
//        añadiendo dias de comensaul mensual
         fechaAnticipacion.add(Calendar.DATE, listaComensal.get(1).getDiasAnticipacion());
         
//        para registrar la diversidad de platos que envio el usuario
        for(C_TipoComida tipoComida : listaTipoComida){
            if(request.getParameter("cantidad"+tipoComida.getNombreComida())!= null){
                empleadoReserva.setIdTipoComida(tipoComida.getIdTipoComida());
                empleadoReserva.setIdUser(Integer.parseInt(request.getParameter("idUsuario")));//OK
//                se habilitara la opcion de cantidades cuando se registren la cantidad de miembros en la familia
                empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad"+tipoComida.getNombreComida())));
                empleadoReserva.setObservacion(String.valueOf(request.getParameter("observacion")));
                
                calendar.setTime(dateStart);
                fechaInicial.setTime(dateStart);
                for(int i = 1; i <= dias; i++){  
//                   System.out.print("fecha: "+calendar.getTime());  
                   
                    if(calendar.after(fechaAnticipacion) || calendar.equals(fechaAnticipacion)){
                        empleadoReserva.setIdTipoComensal(listaComensal.get(1).getTipoComensal_id());
                    }else{
                        empleadoReserva.setIdTipoComensal(listaComensal.get(0).getTipoComensal_id());
                    }                      
//                    System.out.print("Mes: "+((calendar.get(Calendar.MONTH))+1));
                    empleadoReserva.setFecha(calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
//                    System.out.print("fecha repeticion: "+empleadoReserva.getFecha()); 
                    resultado = _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
//                    resultado = "Ok";
                 
//                    calendar.add(Calendar.MONTH, -1);
                    calendar.add(Calendar.DATE, 1);
                }
//                se toma el ultimo dia de registro para la repeticion
                 int monthInitial = calendar.get(Calendar.MONDAY);  
                    while(repeticion == true){
                        fechaInicial.add(Calendar.DATE, 7);
                        calendar.setTime(fechaInicial.getTime());
//                        System.out.print("fecha repeticion: "+calendar.getTime()); 
                       
                        for(int i = 1; i <= dias; i++){  
                            if(monthInitial == calendar.get(Calendar.MONDAY)){
                                if(calendar.after(fechaAnticipacion) || calendar.equals(fechaAnticipacion)){
                                empleadoReserva.setIdTipoComensal(listaComensal.get(1).getTipoComensal_id());
                                }else{
                                    empleadoReserva.setIdTipoComensal(listaComensal.get(0).getTipoComensal_id());
                                }                      
//                                System.out.print("Mes: "+((calendar.get(Calendar.MONTH))+1));
                                empleadoReserva.setFecha(calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
                              resultado = _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
//                                System.out.print("fecha repeticion: "+empleadoReserva.getFecha()); 
//                                resultado = "Ok";
                            }else{
                                repeticion = false;
                            }
                            calendar.add(Calendar.DATE, 1); 
                        }
                    }  
            }
        }   
    }catch(Exception e){
        resultado = "Se ha producido "+e+" un error al registrar la reserva.";
        System.out.print("Se ha producido un error al registrar la reserva." + e);
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
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    Error: ");
      out.print(resultado);
      out.write("\n");
      out.write("</div>\n");
    }   
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
