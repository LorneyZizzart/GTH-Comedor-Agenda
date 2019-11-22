package org.apache.jsp.Comensal.verReserva;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Usuario;
import java.util.ArrayList;
import java.util.List;
import Entidad.C_TipoComensal;

public final class listaReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Controlador.UsuarioController consultaUser = null;
      synchronized (_jspx_page_context) {
        consultaUser = (Controlador.UsuarioController) _jspx_page_context.getAttribute("consultaUser", PageContext.PAGE_SCOPE);
        if (consultaUser == null){
          consultaUser = new Controlador.UsuarioController();
          _jspx_page_context.setAttribute("consultaUser", consultaUser, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<C_TipoComensal> listaReservas = new ArrayList<C_TipoComensal>();
     List<Usuario> Usuarios = new ArrayList<Usuario>();
    Usuarios = consultaUser.GetAllUser();
    int idEmpleado = Integer.parseInt(request.getParameter("idUsuario"));
    int idRepeticion = Integer.parseInt(request.getParameter("idRepeticion"));
    String fi = request.getParameter("fi");
    String ff = request.getParameter("ff");
    List<String> idsComensal =  new ArrayList<String>();
    List<String> idsComida = new ArrayList<String>();
    double saldo = 0.0;
    
    for(Usuario u : Usuarios){
        if(u.getUser_id() == idEmpleado){
            idEmpleado = u.getEmpleado_id();
        }
    }
    
    try { 
        
        if (request.getParameterValues("co[]") != null) {
            String[] comensales  = request.getParameterValues("co[]");
            for (String c : comensales) {
                idsComensal.add(c);
            }
        }
    } catch (Exception e) {
    }
    
    try {
        if (request.getParameterValues("al[]") != null) {
            String[] comidas = request.getParameterValues("al[]");
            for (String c : comidas) {
                idsComida.add(c);
            }
        }
    } catch (Exception e) {
    }
    
    listaReservas = _empleadoReserva.getAllReservaEmpleado(idEmpleado, idRepeticion, fi, ff, idsComensal, idsComida);
    
    for(C_TipoComensal c : listaReservas){
        if(c.getIdTipoComida() == 1){
            saldo = saldo + ((c.getCosto()-c.getDescuentoDesayuno())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 2){
            saldo = saldo + ((c.getCosto()-c.getDescuentoAlmuerzo())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 3){
            saldo = saldo + ((c.getCosto()-c.getDescuentoCena())-c.getDescuentoAdicional())*c.getCantidad();
       }
    }

      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"col-xs-12\">            \n");
      out.write("\n");
      out.write("            <div class=\"box box-purple\">\n");
      out.write("                <div class=\"box-header\">\n");
      out.write("                    <h3 class=\"box-title\">Lista de reservas</h3>\n");
      out.write("                    <a data-id=\"");
      out.print(idEmpleado);
      out.write("\"  class=\"formNuevo btn-purple pull-right\" data-toggle=\"modal tooltip\" data-target=\"#modal-default\" data-placement=\"bottom\" title=\"Crear reporte\">\n");
      out.write("                        <i class=\"fa fa-file-pdf-o\"></i>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box-header -->\n");
      out.write("                <div class=\"box-body table-responsive\">\n");
      out.write("                    <table id=\"example1\" class=\"table table-bordered table-striped\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Nombre completo</th>\n");
      out.write("                                <th>Tipo de alimento</th>\n");
      out.write("                                <th>Fecha</th>\n");
      out.write("                                <th>Cantidad</th>\n");
      out.write("                                <th>Costo</th>\n");
      out.write("                                <th>Descuento</th>\n");
      out.write("                                <th>Descuento adicional</th>\n");
      out.write("                                <th>Precio total</th>\n");
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
      out.write(" Bs.</td>\n");
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
      out.write("                        </tbody>\n");
      out.write("                        <tfoot>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Nombre completo</th>\n");
      out.write("                                <th>Tipo de alimento</th>\n");
      out.write("                                <th>Fecha</th>\n");
      out.write("                                <th>Cantidad</th>\n");
      out.write("                                <th>Costo</th>\n");
      out.write("                                <th>Descuento</th>\n");
      out.write("                                <th>Descuento adicional</th>\n");
      out.write("                                <th>Precio total</th>\n");
      out.write("                                <th>Comensal</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </tfoot>\n");
      out.write("                    </table>\n");
      out.write("                         \n");
      out.write("                </div>\n");
      out.write("                <!-- /.box-body -->\n");
      out.write("                <div class=\"box-footer\">\n");
      out.write("              <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-6 col-xs-6\">\n");
      out.write("                  <div class=\"description-block border-right\">\n");
      out.write("                    <h5 class=\"description-header\">");
      out.print(listaReservas.size());
      out.write("</h5>\n");
      out.write("                    <span class=\"description-text\">CANTIDAD DE RESERVAS</span>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- /.description-block -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col -->\n");
      out.write("                <div class=\"col-sm-6 col-xs-6\">\n");
      out.write("                  <div class=\"description-block border-right\">\n");
      out.write("                    <h5 class=\"description-header\">");
      out.print(saldo);
      out.write(" Bs.</h5>\n");
      out.write("                    <span class=\"description-text\">COSTO TOTAL</span>\n");
      out.write("                  </div>\n");
      out.write("                  <!-- /.description-block -->\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <!-- /.row -->\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col -->\n");
      out.write("\n");
      out.write("        <!-- /.col -->\n");
      out.write("        <div class=\"modal fade\" id=\"formulario_registro\">\n");
      out.write("        <div class=\"modal-dialog modal-comensal\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                    <h4 id=\"titleModal\" class=\"modal-title\">title</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body cuerpo_registro\"></div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.modal-content -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.modal-dialog -->\n");
      out.write("    </div>\n");
      out.write("<script>\n");
      out.write("    $(function () {\n");
      out.write("        $(\"#example1\").DataTable();\n");
      out.write("    });            \n");
      out.write("    $(\".formNuevo\").click(function (e) {\n");
      out.write("        $(\"#titleModal\").html(\"Generar reporte\");\n");
      out.write("        e.preventDefault();\n");
      out.write("        e.stopImmediatePropagation();\n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            //$.post('lista_cuenta_duplicada.jsp',\n");
      out.write("            $.post('crearReporte.jsp',\n");
      out.write("            {e: $(this).attr('data-id')},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("    });\n");
      out.write("</script>");
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
