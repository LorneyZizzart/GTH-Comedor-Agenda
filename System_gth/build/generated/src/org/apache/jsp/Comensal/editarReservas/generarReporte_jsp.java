package org.apache.jsp.Comensal.editarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.C_TipoComida;
import java.util.ArrayList;
import java.util.List;
import Entidad.C_TipoComensal;

public final class generarReporte_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <title>Reporte Comensal</title>\n");
      out.write("  <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("  <!-- Bootstrap 3.3.7 -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../bootstrap/css/bootstrap.min.css\">\n");
      out.write("  <!-- Font Awesome -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../dist/externo/font-awesome.min.css\">\n");
      out.write("  <!-- Ionicons -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../dist/externo/ionicons.min.css\">\n");
      out.write("  <!-- Theme style -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../dist/css/AdminLTE.min.css\">\n");
      out.write("\n");
      out.write("  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("  <!--[if lt IE 9]>\n");
      out.write("  <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("  <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("  <![endif]-->\n");
      out.write("\n");
      out.write("  <!-- Google Font -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n");
      out.write("</head>\n");
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
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<C_TipoComensal> listaReservas = new ArrayList<C_TipoComensal>();
    List<C_TipoComensal> listaReservasExternas = new ArrayList<C_TipoComensal>();
    List<String> idsComensal =  new ArrayList<String>();
    List<String> idsComida = new ArrayList<String>();
    String fechaInicio = null;  String fechaFinal = null;
    Boolean orderAlfa = false, orderDate = false;
    double saldo = 0.0;
    double saldoExterno = 0.0;
    int tipoFuncionario = 0;
    String[] idComensal = null;
    try {
        tipoFuncionario = Integer.parseInt(request.getParameter("tipoRFuncionario"));
        idComensal = request.getParameter("idEmpleado").split("%");
        fechaInicio =  request.getParameter("fi");
        fechaFinal = request.getParameter("ff");
        
        if (request.getParameterValues("c") != null) {
            String[] comensales  = request.getParameterValues("c");
            for (String c : comensales) {
                idsComensal.add(c);
            }
        }
         
        if (request.getParameterValues("a") != null) {
            String[] comidas = request.getParameterValues("a");
            for (String c : comidas) {
                idsComida.add(c);
            }
        }
    } catch (Exception e) {
        idsComensal = null;
        idsComida = null;
    }
    
    try{
        if(request.getParameter("oA").equalsIgnoreCase("on")) 
        orderAlfa = true;
    }catch(Exception e){
        orderAlfa = false;
    }
    
     try{
        if(request.getParameter("oF").equalsIgnoreCase("on")) 
            orderDate = true;
    }catch(Exception e){
        orderDate = false;
    }
    if(tipoFuncionario == 0){
        listaReservas = _empleadoReserva.getReservasForParams(fechaInicio, fechaFinal, idsComensal, idsComida, orderAlfa, orderDate, Integer.parseInt(idComensal[0]));
        listaReservasExternas = _empleadoReserva.getReservasExternasForParams(fechaInicio, fechaFinal, idsComensal, idsComida, orderAlfa, orderDate, Integer.parseInt(idComensal[0]));
    }else if(tipoFuncionario == 1){
        listaReservas = _empleadoReserva.getReservasForParams(fechaInicio, fechaFinal, idsComensal, idsComida, orderAlfa, orderDate, Integer.parseInt(idComensal[0]));
    }else if(tipoFuncionario == 2){
       listaReservasExternas = _empleadoReserva.getReservasExternasForParams(fechaInicio, fechaFinal, idsComensal, idsComida, orderAlfa, orderDate, Integer.parseInt(idComensal[0]));
    }
    
    
    for(C_TipoComensal c : listaReservas){
        if(c.getIdTipoComida() == 1){
            saldo = saldo + ((c.getCosto()-c.getDescuentoDesayuno())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 2){
            saldo = saldo + ((c.getCosto()-c.getDescuentoAlmuerzo())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 3){
            saldo = saldo + ((c.getCosto()-c.getDescuentoCena())-c.getDescuentoAdicional())*c.getCantidad();
       }
    }
    
    for(C_TipoComensal c : listaReservasExternas){
        if(c.getIdTipoComida() == 1){
            saldoExterno = saldoExterno + ((c.getCosto()-c.getDescuentoDesayuno())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 2){
            saldoExterno = saldoExterno + ((c.getCosto()-c.getDescuentoAlmuerzo())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 3){
            saldoExterno = saldoExterno + ((c.getCosto()-c.getDescuentoCena())-c.getDescuentoAdicional())*c.getCantidad();
       }
    }
    
   


      out.write("\n");
      out.write("\n");
      out.write("<body onload=\"window.print();\" >\n");
      out.write("<div >\n");
      out.write("  <!-- Main content -->\n");
      out.write("  <section class=\"invoice\">\n");
      out.write("    <!-- title row -->\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-xs-12\" style=\"margin-bottom: 2%;\">\n");
      out.write("          <img class=\"img-responsive pull-left\" src=\"../../images/uab_logo_y_texto.png\" alt=\"User profile picture\" style=\"width: 15%\">\n");
      out.write("          <h3 class=\"text-center\" style=\"width: 85%\" ><strong>LISTA DE RESERVAS</strong></h3>\n");
      out.write("          <small class=\"pull-right\"><strong>Fecha inicio:</strong> ");
      out.print(fechaInicio);
      out.write(" <strong>&nbsp;Fecha final:</strong> ");
      out.print(fechaFinal);
      out.write("</small>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Table row -->\n");
      out.write("    ");

    if(tipoFuncionario == 0 || tipoFuncionario == 1){
    
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-xs-12 table-responsive\">\n");
      out.write("        <table class=\"table table-bordered table-striped\">\n");
      out.write("          <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Nombre completo</th>\n");
      out.write("                                <th>Tipo de alimento</th>\n");
      out.write("                                <th style=\"width: 8%\">Fecha</th>\n");
      out.write("                                <th>Cantidad</th>\n");
      out.write("                                <th style=\"width: 10%\">Costo</th>\n");
      out.write("                                <th style=\"width: 10%\">Descuento de comensal</th>\n");
      out.write("                                <th style=\"width: 10%\">Descuento de adicional</th>\n");
      out.write("                                <th style=\"width: 10%\">Precio total</th>\n");
      out.write("                                <th>Comensal</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                int contador = 0;
                                for (C_TipoComensal item : listaReservas) {
                                    contador++;

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(contador);
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(item.getNombreEmpleado());
      out.write("</td>                         \n");
      out.write("                                <td>");
      out.print( item.getNombreComida());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( item.getFecha());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( item.getCantidad());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( item.getCosto());
      out.write(" Bs.</td>                                \n");
      out.write("                                ");

                                   if(item.getIdTipoComida() == 1){
                                      
      out.write("<td>");
      out.print( item.getDescuentoDesayuno());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 2){
                                      
      out.write("<td>");
      out.print( item.getDescuentoAlmuerzo());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 3){
                                      
      out.write("<td>");
      out.print( item.getDescuentoCena());
      out.write(" Bs.</td>");
  
                                   }
                                
      out.write("\n");
      out.write("                                <td>");
      out.print( item.getDescuentoAdicional());
      out.write(" Bs.</td>\n");
      out.write("                                ");

                                   if(item.getIdTipoComida() == 1){
                                      
      out.write("<td>");
      out.print(((item.getCosto()-item.getDescuentoDesayuno())-item.getDescuentoAdicional())*item.getCantidad());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 2){
                                      
      out.write("<td>");
      out.print( ((item.getCosto()-item.getDescuentoAlmuerzo())-item.getDescuentoAdicional())*item.getCantidad());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 3){
                                      
      out.write("<td>");
      out.print( ((item.getCosto()-item.getDescuentoCena())-item.getDescuentoAdicional())*item.getCantidad());
      out.write(" Bs.</td>");
  
                                   }
                                
      out.write("\n");
      out.write("                                <td>");
      out.print( item.getNombreComensal());
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"8\" class=\"text-right\"><strong>COSTO TOTAL</strong></td>\n");
      out.write("                                <td colspan=\"2\">");
      out.print(saldo);
      out.write(" Bs.</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("        </table>\n");
      out.write("      </div>\n");
      out.write("      <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("                            ");

    }
    if(tipoFuncionario == 0 || tipoFuncionario == 2){
                            
      out.write("\n");
      out.write("                            <h4 style=\"font-weight: bold;\">COMENSALES EXTERNOS</h4>                       \n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-xs-12 table-responsive\">\n");
      out.write("        <table class=\"table table-bordered table-striped\">\n");
      out.write("          <thead\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Nombre completo</th>\n");
      out.write("                                <th>Tipo de alimento</th>\n");
      out.write("                                <th style=\"width: 8%\">Fecha</th>\n");
      out.write("                                <th>Cantidad</th>\n");
      out.write("                                <th style=\"width: 10%\">Costo</th>\n");
      out.write("                                <th style=\"width: 10%\">Descuento de comensal</th>\n");
      out.write("                                <th style=\"width: 10%\">Descuento de adicional</th>\n");
      out.write("                                <th style=\"width: 10%\">Precio total</th>\n");
      out.write("                                <th>Comensal</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                int contadorE = 0;
                                for (C_TipoComensal item : listaReservasExternas) {
                                    contadorE++;

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(contadorE);
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(item.getNombreEmpleado());
      out.write("</td>                         \n");
      out.write("                                <td>");
      out.print( item.getNombreComida());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( item.getFecha());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( item.getCantidad());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( item.getCosto());
      out.write(" Bs.</td>                                \n");
      out.write("                                ");

                                   if(item.getIdTipoComida() == 1){
                                      
      out.write("<td>");
      out.print( item.getDescuentoDesayuno());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 2){
                                      
      out.write("<td>");
      out.print( item.getDescuentoAlmuerzo());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 3){
                                      
      out.write("<td>");
      out.print( item.getDescuentoCena());
      out.write(" Bs.</td>");
  
                                   }
                                
      out.write("\n");
      out.write("                                <td>");
      out.print( item.getDescuentoAdicional());
      out.write(" Bs.</td>\n");
      out.write("                                ");

                                   if(item.getIdTipoComida() == 1){
                                      
      out.write("<td>");
      out.print(((item.getCosto()-item.getDescuentoDesayuno())-item.getDescuentoAdicional())*item.getCantidad());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 2){
                                      
      out.write("<td>");
      out.print( ((item.getCosto()-item.getDescuentoAlmuerzo())-item.getDescuentoAdicional())*item.getCantidad());
      out.write(" Bs.</td>");
 
                                   }else if(item.getIdTipoComida() == 3){
                                      
      out.write("<td>");
      out.print( ((item.getCosto()-item.getDescuentoCena())-item.getDescuentoAdicional())*item.getCantidad());
      out.write(" Bs.</td>");
  
                                   }
                                
      out.write("\n");
      out.write("                                <td>");
      out.print( item.getNombreComensal());
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"8\" class=\"text-right\"><strong>COSTO TOTAL</strong></td>\n");
      out.write("                                <td colspan=\"2\">");
      out.print(saldoExterno);
      out.write(" Bs.</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("        </table>\n");
      out.write("      </div>\n");
      out.write("      <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("    <!-- /.row -->\n");
      out.write("    <!-- /.row -->\n");
      out.write("  </section>\n");
      out.write("    <section>\n");
      out.write("        <div style=\"text-align: center; margin-top: 100px;  padding-top: 100px;\">\n");
      out.write("            <div style=\"border-top: 1px solid #716f6f;\n");
      out.write("                        margin: 0 30% 0 30%;\n");
      out.write("                        border-style: dotted;\n");
      out.write("                        border-bottom: none;\n");
      out.write("                        border-left: none;\n");
      out.write("                        border-right: none;\">\n");
      out.write("                <p style=\"margin: 0;\">Sandra Mischel Charcas Enriquez</p>\n");
      out.write("                <span style=\"text-transform: uppercase; color: #909090;\">GESTIÓN DEL TALENTO HUMANO</span>\n");
      out.write("            </div>\n");
      out.write("        </div>                        \n");
      out.write("    </section>\n");
      out.write("  <!-- /.content -->\n");
      out.write("</div>\n");
      out.write("<!-- ./wrapper -->\n");
      out.write("</body>\n");
      out.write("</html>");
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
