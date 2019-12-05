package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.Empleado;
import Entidad.Evento;
import Entidad.Area;

public final class evento_005fcredencial_005fprint_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Eventos/evento/../../masterPage/complemento/footer.jsp");
  }

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
      out.write(" \n");
      out.write("\n");
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {

      out.write('\n');
      out.write('\n');
    }

      out.write('\n');
      Controlador.EventoController consultaEvento = null;
      synchronized (_jspx_page_context) {
        consultaEvento = (Controlador.EventoController) _jspx_page_context.getAttribute("consultaEvento", PageContext.PAGE_SCOPE);
        if (consultaEvento == null){
          consultaEvento = new Controlador.EventoController();
          _jspx_page_context.setAttribute("consultaEvento", consultaEvento, PageContext.PAGE_SCOPE);
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
      Controlador.CharacterController _character = null;
      synchronized (_jspx_page_context) {
        _character = (Controlador.CharacterController) _jspx_page_context.getAttribute("_character", PageContext.PAGE_SCOPE);
        if (_character == null){
          _character = new Controlador.CharacterController();
          _jspx_page_context.setAttribute("_character", _character, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"../../bootstrap/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"../../dist/css/AdminLTE.min.css\">\n");

    String e_cod_id = request.getParameter("iddsesasdasdf");
    e_cod_id = e_cod_id.replace(" ", "+");

    int e_evento_id = Integer.parseInt(_encript.ValorADesencriptar(e_cod_id));
    Evento evento = new Evento();

    evento = consultaEvento.GetEventobyId(e_evento_id);

    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaEvento.GetAllEmpleadoEvento(e_evento_id);

      out.write("\n");
      out.write("<body onload=\"window.print();\">\n");
      out.write("    <section class=\"content-header\">\n");
      out.write("        <h1>\n");
      out.write("            Evento\n");
      out.write("            <small>");
      out.print(evento.getNombre_evento());
      out.write("</small>\n");
      out.write("        </h1>\n");
      out.write("\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <section class=\"content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-12\">            \n");
      out.write("\n");
      out.write("                <div class=\"box box-purple\">\n");
      out.write("                    <div class=\"box-header\">\n");
      out.write("                        <h3 class=\"box-title\">Lista de participantes</h3>                           \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-header -->\n");
      out.write("                    <div class=\"box-body table-responsive\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            ");

                                int contador = 0;
                                for (Empleado em : Empleados) {
                                    contador++;
                            
      out.write("\n");
      out.write("                            <div class=\"col-md-3\">\n");
      out.write("                                <div class=\"box box-purple\">\n");
      out.write("                                    <div class=\"box-body box-profile\">\n");
      out.write("                                        <img class=\"img-responsive\" src=\"../../images/logo_uab_3.jpg\" alt=\"User profile picture\">\n");
      out.write("\n");
      out.write("                                        <h4  class=\"text-muted text-center\">");
      out.print(evento.getNombre_evento());
      out.write("</h4>\n");
      out.write("\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-1\"></div>\n");
      out.write("                                            <div class=\"col-md-10\"><div id=\"output_");
      out.print(em.getEmpleado_id());
      out.write("\" class=\"img-thumbnail img-bordered\"></div></div>\n");
      out.write("                                            <div class=\"col-md-1\"></div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <ul class=\"list-group list-group-unbordered\">\n");
      out.write("                                            <li class=\"list-group-item\">\n");
      out.write("                                                <h3 class=\"profile-username text-center\">");
      out.print(em.getApellido_paterno());
      out.write(' ');
      out.print(em.getApellido_materno());
      out.write(" </h3>\n");
      out.write("                                                <h3 class=\"profile-username text-center\">");
      out.print(em.getNombre());
      out.write(" </h3>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"list-group-item\">\n");
      out.write("                                            <center>");
      out.print(_encript.ValorAEncriptar(Integer.toString(em.getEmpleado_id())));
      out.write("</center>\n");
      out.write("                                            </li>                                        \n");
      out.write("                                        </ul>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.box-body -->\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /.col -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("        <!--Modal-->\n");
      out.write("\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <!--Modal-->\n");
      out.write("\n");
      out.write("    <div class=\"modal fade\" role=\"dialog\"  id=\"registro_persona_evento\">\n");
      out.write("        <div class=\"modal-dialog modal-lg\">\n");
      out.write("\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\" id=\"titleModal\">Modal Header</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body cuerpo_registro\">\n");
      out.write("                    <p>Some text in the modal.</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- /.content-wrapper -->\n");
      out.write("\n");
      out.write("<footer class=\"main-footer\">\n");
      out.write("    <div class=\"pull-right hidden-xs\">\n");
      out.write("        <b>Version</b> 0.1\n");
      out.write("    </div>\n");
      out.write("    <strong>Copyright &copy; 2019 <a href=\"http://www.uab.edu.bo\">UAB</a>.</strong> All rights\n");
      out.write("    reserved.\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<!-- Control Sidebar -->\n");
      out.write("<aside class=\"control-sidebar control-sidebar-dark\">\n");
      out.write("    <!-- Create the tabs -->\n");
      out.write("    <ul class=\"nav nav-tabs nav-justified control-sidebar-tabs\">\n");
      out.write("        <li><a href=\"#control-sidebar-home-tab\" data-toggle=\"tab\"><i class=\"fa fa-home\"></i></a></li>\n");
      out.write("    </ul>\n");
      out.write("    <!-- Tab panes -->\n");
      out.write("    <div class=\"tab-content\">\n");
      out.write("        <!-- Home tab content -->\n");
      out.write("        <div class=\"tab-pane\" id=\"control-sidebar-home-tab\">\n");
      out.write("            <h3 class=\"control-sidebar-heading\">Recent Activity</h3>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</aside>\n");
      out.write("<!-- /.control-sidebar -->\n");
      out.write("<!-- Add the sidebar's background. This div must be placed\n");
      out.write("     immediately after the control sidebar -->\n");
      out.write("<div class=\"control-sidebar-bg\"></div>\n");
      out.write("\n");
      out.write("<!-- ./wrapper -->\n");
      out.write("<script src=\"../../dist/js/CKEditor/ckeditor.js\"></script>\n");
      out.write("<script src=\"../../dist/js/CKEditor/es.js\"></script>\n");
      out.write("<!-- jQuery 2.2.3 -->\n");
      out.write("<!--<script src=\"../../plugins/jQuery/jquery-2.2.3.min.js\"></script>-->\n");
      out.write("<script src=\"../../plugins/jQuery/jquery-3.4.1.min.js\"></script>\n");
      out.write("<script src=\"../../plugins/jQueryUI/jquery-ui.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Bootstrap 3.3.6 -->\n");
      out.write("<script src=\"../../bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Bootstrap validator -->\n");
      out.write("<script type=\"text/javascript\" src=\"../../dist/js/bootstrapValidator.js\"></script>\n");
      out.write("<!-- Slimscroll -->\n");
      out.write("<script src=\"../../plugins/slimScroll/jquery.slimscroll.min.js\"></script>\n");
      out.write("<!-- FastClick -->\n");
      out.write("<script src=\"../../plugins/fastclick/fastclick.js\"></script>\n");
      out.write("<!-- AdminLTE App -->\n");
      out.write("<script src=\"../../dist/js/app.min.js\"></script>\n");
      out.write("<!-- bootstrap color picker -->\n");
      out.write("<script src=\"../../plugins/colorpicker/bootstrap-colorpicker.min.js\"></script>\n");
      out.write("<!-- DataTables -->\n");
      out.write("<script src=\"../../plugins/datatables/jquery.dataTables.min.js\"></script>\n");
      out.write("<script src=\"../../plugins/datatables/dataTables.bootstrap.min.js\"></script>\n");
      out.write("<!-- Select2 -->\n");
      out.write("<script src=\"../../plugins/select2/select2.full.min.js\"></script>\n");
      out.write("<!--<script src='../../dist/fullcalendar-4.2.0/packages/moment/main.min.js'></script>--> \n");
      out.write("<!-- Para Mostrar las alertas Toast-->        \n");
      out.write("<script src=\"../../bootstrap/toast_alert/toastr.js\"></script>\n");
      out.write("<!-- bootstrap time picker -->\n");
      out.write("<script src=\"../../plugins/timepicker/bootstrap-timepicker.js\"></script>\n");
      out.write("<!-- fullCalendar -->\n");
      out.write("\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/core/main.js'></script>\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/interaction/main.js'></script>\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/daygrid/main.js'></script>\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/timegrid/main.js'></script> \n");
      out.write("<!-- bootstrap datepicker -->\n");
      out.write("<script src=\"../../plugins/datepicker/bootstrap-datepicker.js\"></script>\n");
      out.write("<!-- Bootstrap WYSIHTML5 -->\n");
      out.write("<!--<script src=\"https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js\"></script>-->\n");
      out.write("<script src=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\n");
      out.write("<script src=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/picturefill/2.3.1/picturefill.min.js\"></script>\n");
      out.write("<script src=\"../../plugins/lightGallery-master/dist/js/lightgallery-all.min.js\"></script>\n");
      out.write("<script src=\"../../plugins/lightGallery-master/lib/jquery.mousewheel.min.js\"></script>\n");
      out.write("<!--imprimir-->\n");
      out.write("<script src=\"../../plugins/demoPrint2/jQuery.print.js\"></script>\n");
      out.write("<script src='../../dist/js/moment.js'></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("    $(\"#btn_salir\").click(function () {\n");
      out.write("        $.post('../../masterPage/complemento/salir.jsp',\n");
      out.write("                {mensaje: 'Salir'},\n");
      out.write("                function (html) {\n");
      out.write("                    $(\".salir_pagin_session\").html(html);\n");
      out.write("                }\n");
      out.write("        ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            $(\".salir_pagin_session\").html(\"<p class='text-danger'>\" + errorThrown + \"</p>\");\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<div class=\"salir_pagin_session\"></div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--Genera QR-->\n");
      out.write("    <script src=\"../../dist/js/qr/jquery.qrcode.min.js\"></script>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(function () {\n");
      out.write("            $(\"#example1\").DataTable();\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        jQuery(function () {\n");
      out.write("        ");
 for (Empleado e : Empleados) {
        
      out.write("\n");
      out.write("            jQuery('#output_");
      out.print(e.getEmpleado_id());
      out.write("').qrcode(\"");
      out.print(_encript.ValorAEncriptar(Integer.toString(e.getEmpleado_id())));
      out.write("\");\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("        })\n");
      out.write("\n");
      out.write("    });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>");
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
