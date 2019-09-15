package org.apache.jsp.Comensal.empleadoReserva;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.C_Empleado_Reserva;
import Entidad.Login_Entidad;
import Entidad.Opcion;
import Entidad.Login_Entidad;
import java.util.ArrayList;
import java.util.List;
import Entidad.Menu;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/Comensal/empleadoReserva/../../masterPage/complemento/head.jsp");
    _jspx_dependants.add("/Comensal/empleadoReserva/../../masterPage/complemento/menu.jsp");
    _jspx_dependants.add("/Comensal/empleadoReserva/../../masterPage/complemento/footer.jsp");
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

      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible; Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("        <title>GTH | Dashboard</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <!-- Bootstrap validator -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/css/bootstrapValidator.css\"/>\n");
      out.write("        <!-- Select2 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/select2/select2.min.css\">\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/externo/font-awesome.min.css\">\n");
      out.write("        <!-- Ionicons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/externo/ionicons.min.css\">\n");
      out.write("        <!-- DataTables -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/datatables/dataTables.bootstrap.css\">\n");
      out.write("        <!-- Theme style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/css/AdminLTE.min.css\">\n");
      out.write("        <!-- Bootstrap Color Picker -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/colorpicker/bootstrap-colorpicker.min.css\">\n");
      out.write("        <!-- Bootstrap time Picker -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/timepicker/bootstrap-timepicker.min.css\">\n");
      out.write("        <!-- fullCalendar -->\n");
      out.write("        <link rel='stylesheet' href=\"../../dist/fullcalendar-4.2.0/packages/core/main.min.css\">\n");
      out.write("        <link rel='stylesheet' href=\"../../dist/fullcalendar-4.2.0/packages/daygrid/main.min.css\">\n");
      out.write("        <link rel='stylesheet' href=\"../../dist/fullcalendar-4.2.0/packages/timegrid/main.min.css\">\n");
      out.write("        <!-- AdminLTE Skins. Choose a skin from the css/skins\n");
      out.write("             folder instead of downloading all of them to reduce the load. -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../dist/css/skins/_all-skins.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/css/myStyle.css\">\n");
      out.write("\n");
      out.write("        <!-- Para Mostrar las alertas Toast-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/toast_alert/toastr.css\" />\n");
      out.write("\n");
      out.write("        <script src=\"../../plugins/jQuery/jquery-3.4.1.min.js\"></script>    \n");
      out.write("        <!-- bootstrap datepicker -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/datepicker/datepicker3.css\">\n");
      out.write("        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"../../plugins/tablaEditor/css/tablaEditor.css\" />-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        ");

            String Nombre_Usuario = "";
            Login_Entidad DatoUsuario = new Login_Entidad();

            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("USUARIO") == null) {
        
      out.write("\n");
      out.write("        <script>window.location.href = '../../login.jsp';</script>\n");
      out.write("        ");

            } else {
                DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
            }
        
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .loader{\n");
      out.write("                background-image: url(../../bootstrap/images/ajax-loader.gif);\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-position: center;\n");
      out.write("                height: 100px;                \n");
      out.write("            }          \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition  skin-purple-light sidebar-mini\">\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("            <header class=\"main-header\">\n");
      out.write("                <!-- Logo -->\n");
      out.write("                <a href=\"../../masterPage/complemento/index.jsp\" class=\"logo\">\n");
      out.write("                    <!-- mini logo for sidebar mini 50x50 pixels -->\n");
      out.write("                    <span class=\"logo-mini\"><b>GTH</b></span>\n");
      out.write("                    <!-- logo for regular state and mobile devices -->\n");
      out.write("                    <span class=\"logo-lg\"><b>GTH</b>UAB</span>\n");
      out.write("                </a>\n");
      out.write("                <!-- Header Navbar: style can be found in header.less -->\n");
      out.write("                <nav class=\"navbar navbar-static-top\">\n");
      out.write("                    <!-- Sidebar toggle button-->\n");
      out.write("                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("                    <div class=\"navbar-custom-menu\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">                            \n");
      out.write("\n");
      out.write("                            <!-- User Account: style can be found in dropdown.less -->\n");
      out.write("                            <li class=\"dropdown user user-menu\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                    <img src=\"../../folder_picture/../images/user.png\" class=\"user-image\" alt=\"User Image\">\n");
      out.write("                                    <span class=\"hidden-xs\">");
      out.print(DatoUsuario.getNombreCompleto());
      out.write("</span>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <!-- User image -->\n");
      out.write("                                    <li class=\"user-header\">\n");
      out.write("                                        <img src=\"../../folder_picture/../images/user.png\" class=\"img-circle\" alt=\"User Image\">\n");
      out.write("\n");
      out.write("                                        <p>\n");
      out.write("                                            ");
      out.print(DatoUsuario.getNombreCompleto());
      out.write(" - ");
      out.print(DatoUsuario.getPerfil());
      out.write("\n");
      out.write("                                            <small>Member since Nov. 2012</small>\n");
      out.write("                                        </p>\n");
      out.write("                                    </li>\n");
      out.write("\n");
      out.write("                                    <li class=\"user-footer\">\n");
      out.write("                                        <div class=\"pull-left\">\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-default btn-flat\">Perfil</a>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"pull-right\">\n");
      out.write("                                            <a class=\"btn btn-default btn-flat btn_salir\" id=\"btn_salir\">Salir</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <!-- Control Sidebar Toggle Button -->\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\" data-toggle=\"control-sidebar\"><i class=\"fa fa-gears\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </header>");
      out.write(" \n");
      out.write("\n");
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession sesionmenu = request.getSession();
    if (sesionmenu.getAttribute("USUARIO") == null) {
        out.print("<script>window.location.href = 'login.jsp';</script>");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!-- Left side column. contains the logo and sidebar -->\n");
      out.write("<aside class=\"main-sidebar\">\n");
      out.write("    <!-- sidebar: style can be found in sidebar.less -->\n");
      out.write("    <section class=\"sidebar\">\n");
      out.write("        <!-- Sidebar user panel -->\n");
      out.write("        <div class=\"user-panel\">\n");
      out.write("            <div class=\"pull-left image\">\n");
      out.write("                <img src=\"../../folder_picture/../images/user.png\" class=\"img-circle\" alt=\"User Image\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"pull-left info\">\n");
      out.write("                <p>Admin</p>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- sidebar menu: : style can be found in sidebar.less -->\n");
      out.write("        <ul class=\"sidebar-menu\">\n");
      out.write("            <li class=\"header\">MENÚ PRINCIPAL</li>\n");
      out.write("\n");
      out.write("            ");


                List<Menu> menu = new ArrayList<Menu>();

                menu = (ArrayList<Menu>) sesionmenu.getAttribute("MENU");

                for (Menu item : menu) {
            
      out.write("\n");
      out.write("            <li class=\"treeview\">\n");
      out.write("                <a href=\"#\">\n");
      out.write("                    <i class=\"");
      out.print(item.getIcono());
      out.write("\"></i> <span>");
      out.print(item.getNombre());
      out.write("</span>\n");
      out.write("                    <span class=\"pull-right-container\">\n");
      out.write("                        <i class=\"fa fa-angle-left pull-right\"></i>\n");
      out.write("                    </span>\n");
      out.write("                </a>\n");
      out.write("\n");
      out.write("                ");

                    for (Opcion elem : item.getOpciones()) {
                
      out.write("\n");
      out.write("                <ul class=\"treeview-menu\">\n");
      out.write("                    <li><a href=\"");
      out.print(elem.getUrl());
      out.write("\"><i class=\"fa fa-circle-o\"></i> ");
      out.print(elem.getNombre());
      out.write("</a></li>                    \n");
      out.write("                </ul>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </li>\n");
      out.write("            ");

                }
            
      out.write("            \n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </section>\n");
      out.write("    <!-- /.sidebar -->\n");
      out.write("</aside>\n");
      out.write("\n");
      out.write("<!-- Content Wrapper. Contains page content -->\n");
      out.write("<div class=\"content-wrapper\">");
      out.write(' ');
      out.write('\n');
    }

      out.write('\n');
      out.write('\n');
      Controlador.C_EmpleadoReservaController _reservaEmpleado = null;
      synchronized (_jspx_page_context) {
        _reservaEmpleado = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("_reservaEmpleado", PageContext.PAGE_SCOPE);
        if (_reservaEmpleado == null){
          _reservaEmpleado = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("_reservaEmpleado", _reservaEmpleado, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<C_Empleado_Reserva> listaReservasEmpleado = new ArrayList<C_Empleado_Reserva>();
    listaReservasEmpleado = _reservaEmpleado.getReservasEmpleado(DatoUsuario.getUser_id());

      out.write("\n");
      out.write("        <style>\n");
      out.write("        .disabled{\n");
      out.write("        background-color: #eee;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("<section class=\"content-header\">\n");
      out.write("    <h1>\n");
      out.write("        Registro\n");
      out.write("        <small> de Reservas</small>\n");
      out.write("    </h1>   \n");
      out.write("</section>\n");
      out.write("<section class=\"content\">\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(DatoUsuario.getUser_id());
      out.write("\" name=\"idUsuario\" id=\"idUsuario\">\n");
      out.write("          <div class=\"box box-purple\">\n");
      out.write("            <div class=\"box-body no-padding\">\n");
      out.write("              <!-- THE CALENDAR -->\n");
      out.write("              <div id=\"calendar\" style=\"margin: 0.5%\"></div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box-body -->\n");
      out.write("          </div>\n");
      out.write("          <!-- /. box -->\n");
      out.write("    <!-- /.row -->\n");
      out.write("    <!--Modal-->\n");
      out.write("    <div class=\"modal fade\" id=\"formulario_registro\">\n");
      out.write("        <div class=\"modal-dialog modal-dialog-edit\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                    <h4 id=\"titleModal\" class=\"modal-title\">title</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body cuerpo_registro\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.modal-content -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.modal-dialog -->\n");
      out.write("    </div>\n");
      out.write("</section>\n");
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
      out.write("<script src=\"../../plugins/timepicker/bootstrap-timepicker.min.js\"></script>\n");
      out.write("<!-- fullCalendar -->\n");
      out.write("\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/core/main.js'></script>\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/interaction/main.js'></script>\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/daygrid/main.js'></script>\n");
      out.write("<script src='../../dist/fullcalendar-4.2.0/packages/timegrid/main.js'></script> \n");
      out.write("<!--moment-->\n");
      out.write("<!-- daterangepicker -->\n");
      out.write("<!--<script src=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js\"></script>\n");
      out.write("<script src=\"../../plugins/daterangepicker/daterangepicker.js\"></script>-->\n");
      out.write("\n");
      out.write("<!-- bootstrap datepicker -->\n");
      out.write("<script src=\"../../plugins/datepicker/bootstrap-datepicker.js\"></script>\n");
      out.write("\n");
      out.write("<!--<script type=\"text/javascript\" src=\"http://www.prepbootstrap.com/Content/shieldui-lite/dist/js/shieldui-lite-all.min.js\"></script>-->\n");
      out.write("<!--<script src='.. ../../plugins/tablaEditor/js/shieldui-lite-all.js'></script>--> \n");
      out.write("<!--<script type=\"text/javascript\" src=\"http://www.prepbootstrap.com/Content/data/shortGridData.js\"></script>-->\n");
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
      out.write(" \n");
      out.write("<script type=\"text/javascript\">   \n");
      out.write("    document.addEventListener('DOMContentLoaded', function() {\n");
      out.write("    var calendarEl = document.getElementById('calendar');\n");
      out.write("    var date = moment();\n");
      out.write("    let counter = 0;\n");
      out.write("    var calendar = new FullCalendar.Calendar(calendarEl, {\n");
      out.write("      plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],\n");
      out.write("      nowIndicator: true,\n");
      out.write("      now : new Date(),\n");
      out.write("      header: {\n");
      out.write("        left: 'prev,next today',\n");
      out.write("        center: 'title',\n");
      out.write("        right: 'dayGridMonth,timeGridWeek,timeGridDay'\n");
      out.write("      },\n");
      out.write("      locale : 'es',\n");
      out.write("      navLinks: true, // can click day/week names to navigate views\n");
      out.write("      selectable: true,\n");
      out.write("      selectMirror: true,\n");
      out.write("      select: function(e) {          \n");
      out.write("        $(\"#titleModal\").html(\"Crear Reserva\");\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        $.post('crearReserva.jsp',\n");
      out.write("                {fechaInicio: FullCalendar.formatDate(e.start, {\n");
      out.write("                                locale: 'es'\n");
      out.write("                            }),\n");
      out.write("                fechaFin: FullCalendar.formatDate(e.end, {\n");
      out.write("                                locale: 'es'\n");
      out.write("                            }),\n");
      out.write("                idUser: $(\"#idUsuario\").val(),\n");
      out.write("                diaInicio : FullCalendar.formatDate(e.start, {\n");
      out.write("                                day: 'numeric'\n");
      out.write("                            }),\n");
      out.write("                fechaNow: FullCalendar.formatDate(new Date(), {\n");
      out.write("                                locale: 'es'\n");
      out.write("                            })},\n");
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
      out.write("        \n");
      out.write("//        var title = prompt('Event Title:');\n");
      out.write("//        if (title) {\n");
      out.write("//          calendar.addEvent({\n");
      out.write("//            title: title,\n");
      out.write("//            start: arg.start,\n");
      out.write("//            end: arg.end,\n");
      out.write("//            allDay: arg.allDay\n");
      out.write("//          })\n");
      out.write("//        }\n");
      out.write("//        calendar.unselect();\n");
      out.write("//        var inicioDate = FullCalendar.formatDate(e.start, {\n");
      out.write("//                month: 'long',\n");
      out.write("//                year: 'numeric',\n");
      out.write("//                day: 'numeric',\n");
      out.write("//                locale: 'es'\n");
      out.write("//              });\n");
      out.write("//        console.log('date incio: ' + FullCalendar.formatDate(e.start, {\n");
      out.write("//\n");
      out.write("//                day: 'numeric'\n");
      out.write("//            }));\n");
      out.write("//        console.log('date fin ' + e.end);\n");
      out.write("      },\n");
      out.write("      dayRender(date, cell) {\n");
      out.write("        let thisDate = moment(date.date);\n");
      out.write("        let now = moment().subtract(1,'d');\n");
      out.write("        let dateIsBefore = now > thisDate;\n");
      out.write("        if (dateIsBefore){\n");
      out.write("        $(date.el).addClass('disabled');\n");
      out.write("        }\n");
      out.write("       },\n");
      out.write("      selectAllow: function(select) {\n");
      out.write("        let yesterday = moment().subtract(1, 'd');\n");
      out.write("        return yesterday.diff(select.start) <= 0;\n");
      out.write("      },\n");
      out.write("      eventClick(e){\n");
      out.write("          console.log(e);\n");
      out.write("        $(\"#titleModal\").html(\"Editar Reserva\");\n");
      out.write("        $('#formulario_registro').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('');\n");
      out.write("        $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("        $.post('editarReserva.jsp',\n");
      out.write("                {id: e.event.id,\n");
      out.write("                 nombre: e.event.title,\n");
      out.write("                 fechaInicial: FullCalendar.formatDate(e.event.start, {\n");
      out.write("                                locale: 'es'\n");
      out.write("                            }),\n");
      out.write("                 fechaNow: FullCalendar.formatDate(new Date(), {\n");
      out.write("                                locale: 'es'\n");
      out.write("                            })},\n");
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
      out.write("      },\n");
      out.write("      editable: false,\n");
      out.write("      eventLimit: true, // allow \"more\" link when too many events  \n");
      out.write("        events: [\n");
      out.write("            ");

            for(C_Empleado_Reserva item : listaReservasEmpleado){
               
      out.write("{\n");
      out.write("                id: ");
      out.print(item.getIdEmpleadoReserva());
      out.write(",\n");
      out.write("                title: '");
      out.print(item.getNombreComida());
      out.write("',\n");
      out.write("                start: '");
      out.print(item.getFecha());
      out.write('T');
      out.print(item.getHora());
      out.write(":00',\n");
      out.write("                backgroundColor: '");
      out.print(item.getColor());
      out.write("',\n");
      out.write("                borderColor: '");
      out.print(item.getColor());
      out.write("',\n");
      out.write("                },\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        {\n");
      out.write("        id: (++counter).toString(),\n");
      out.write("        title: 'Meeting',\n");
      out.write("        start: '2018-07-12T10:30:00',\n");
      out.write("        end: '2018-07-12T12:30:00'\n");
      out.write("        }\n");
      out.write("        ],\n");
      out.write("        timeFormat: 'H(:mm)'\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    calendar.render();\n");
      out.write("    \n");
      out.write("  });   \n");
      out.write("    \n");
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
