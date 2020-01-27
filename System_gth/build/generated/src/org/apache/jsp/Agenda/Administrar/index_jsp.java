package org.apache.jsp.Agenda.Administrar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Departamento;
import Entidad.A_RepeticionTarea;
import Entidad.A_Tarea;
import java.util.ArrayList;
import java.util.List;
import Entidad.Login_Entidad;
import Entidad.C_TipoComensal;
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
    _jspx_dependants.add("/Agenda/Administrar/../../masterPage/complemento/head.jsp");
    _jspx_dependants.add("/Agenda/Administrar/../../masterPage/complemento/menu.jsp");
    _jspx_dependants.add("/Agenda/Administrar/../../masterPage/complemento/footer.jsp");
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
      out.write(" \n");
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
      Controlador.EncriptionController __encript = null;
      synchronized (_jspx_page_context) {
        __encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("__encript", PageContext.PAGE_SCOPE);
        if (__encript == null){
          __encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("__encript", __encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<C_TipoComensal> listaReservas = new ArrayList<C_TipoComensal>();
    listaReservas = _empleadoReserva.getNotificaionesDeReservas();
    int contador = 0;
    for (C_TipoComensal item : listaReservas) {
        contador++;
    }
    int NotificaionMostrarTodo = 0; 

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<a href=\"../../Comensal/editarReservas/listaReserva.jsp\"></a>\n");
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
      out.write("        \n");
      out.write("        <!-- bootstrap wysihtml5 - text editor -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Para Mostrar las alertas Toast-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/toast_alert/toastr.css\" />\n");
      out.write("\n");
      out.write("        <script src=\"../../plugins/jQuery/jquery-3.4.1.min.js\"></script>  \n");
      out.write("        <!-- bootstrap datepicker -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/datepicker/datepicker3.css\">\n");
      out.write("        <!--image lightgallery.css-->\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"../../plugins/lightGallery-master/dist/css/lightgallery.css\" /> \n");
      out.write("        \n");
      out.write("        <!--emprimir-->\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/css/myStyle.css\">\n");
      out.write("    \n");
      out.write("        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"../../plugins/tablaEditor/css/tablaEditor.css\" />-->\n");
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
      out.write("                        <ul class=\"nav navbar-nav\"> \n");
      out.write("                            \n");
      out.write("                            <!-- Notifications: mas de 3 platos -> Daniel-17/12/2019 -->\n");
      out.write("                            <li class=\"dropdown notifications-menu\">\n");
      out.write("                              <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                <i class=\"fa fa-bell-o\"></i>\n");
      out.write("                                <span class=\"label label-warning\">");
      out.print(contador);
      out.write("</span>\n");
      out.write("                              </a>\n");
      out.write("                              <ul class=\"dropdown-menu\">\n");
      out.write("                                <li class=\"header\">Tienes ");
      out.print(contador);
      out.write(" notificaciones</li>\n");
      out.write("                                <li>\n");
      out.write("                                  <!-- inner menu: contains the actual data -->\n");
      out.write("                                  <ul class=\"menu\">\n");
      out.write("                                    ");

                                        for (C_TipoComensal item : listaReservas) {
                                    
      out.write("\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"../../Comensal/editarReservas?ListarNotificaion=2&IdTipoComida=");
      out.print(item.getIdTipoComida());
      out.write("&IdEmpleado=");
      out.print(item.getIdEmpleado());
      out.write("&Fecha=");
      out.print(item.getFecha());
      out.write("\">\n");
      out.write("                                            <i class=\"fa fa-user text-aqua\"></i> <b>");
      out.print(item.getNombreEmpleado());
      out.write("</b><br>&#160;&#160;&#160;&#160;");
      out.print( item.getObservacion());
      out.write("\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                  </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"footer\">\n");
      out.write("                                    <a href=\"../../Comensal/editarReservas?ListarNotificaion=1\">Ver todo</a>     \n");
      out.write("                                </li>\n");
      out.write("                              </ul>\n");
      out.write("                            </li>\n");
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
      out.write("                                            <a href=\"../../Funcionario/perfil/historialFuncionario.jsp?i=");
      out.print(__encript.ValorAEncriptar(Integer.toString(DatoUsuario.getEmpleado_id())));
      out.write("\" class=\"btn btn-default btn-flat\">Perfil</a>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"pull-right\">\n");
      out.write("                                            <a class=\"btn btn-default btn-flat btn_salir\" id=\"btn_salir\">Salir</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <!-- Control Sidebar Toggle Button -->\n");
      out.write("                            \n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\" data-toggle=\"control-sidebar\"><i class=\"fa fa-gears\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </header>");
      out.write(' ');
      out.write('\n');
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
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_RepeticionTareaController _repeticion = null;
      synchronized (_jspx_page_context) {
        _repeticion = (Controlador.A_RepeticionTareaController) _jspx_page_context.getAttribute("_repeticion", PageContext.PAGE_SCOPE);
        if (_repeticion == null){
          _repeticion = new Controlador.A_RepeticionTareaController();
          _jspx_page_context.setAttribute("_repeticion", _repeticion, PageContext.PAGE_SCOPE);
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
      out.write('\n');
      Controlador.DepartamentoController _departamento = null;
      synchronized (_jspx_page_context) {
        _departamento = (Controlador.DepartamentoController) _jspx_page_context.getAttribute("_departamento", PageContext.PAGE_SCOPE);
        if (_departamento == null){
          _departamento = new Controlador.DepartamentoController();
          _jspx_page_context.setAttribute("_departamento", _departamento, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<A_RepeticionTarea> listaR = new ArrayList<A_RepeticionTarea>();
    List<Departamento> ListaDepartamento = new ArrayList<Departamento>();
    ListaDepartamento = _departamento.GetAllDepartamento();
    String[] listaRe = new String[]{"Todo", "Hoy", "Semanal", "Quincenal", "Mensual", "Semestral", "Anual", "Predeterminado" , "General"};
    listaR = _repeticion.getAllRepeticionTarea();

      out.write("\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(DatoUsuario.getUser_id());
      out.write("\" name=\"idUsuario\" id=\"idUsuario\">\n");
      out.write("<section class=\"content-header\">\n");
      out.write("    <h1>\n");
      out.write("        Registro\n");
      out.write("        <small> de tareas</small>\n");
      out.write("    </h1>\n");
      out.write("    <ol class=\"breadcrumb\">\n");
      out.write("        <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Inicio</a></li>\n");
      out.write("        <li class=\"active\">Lista de tareas</li>\n");
      out.write("    </ol>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("<section class=\"content\">    \n");
      out.write("        <div class=\"box\" style=\"border-top: none\">\n");
      out.write("            <div class=\"box-header\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12 col-md-4\">\n");
      out.write("                            <div  class=\"form-group\">\n");
      out.write("                                <label class=\"col-md-3 control-label\" style=\"padding: 2% 0 0 0;\">Departamento: </label>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-9 col-xs-12 input-group\">\n");
      out.write("                              <select id=\"idDepartamento\" name=\"idDepartamento\"  class=\"form-control select2\" style=\"width: 100%;\">\n");
      out.write("                                  <option value=\"0\" selected>Todos</option>\n");
      out.write("                                  ");

                                      int d = 0;
                                      for (Departamento item : ListaDepartamento) {
                                          
      out.write("\n");
      out.write("                                          <option value=\"");
      out.print(item.getDepartamento_id());
      out.write("\" >");
      out.print(item.getNombre());
      out.write("</option>                            \n");
      out.write("                                  ");
 d++; }  
      out.write("\n");
      out.write("                              </select>\n");
      out.write("                            </div>\n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"listFuncionarios\" class=\"col-sm-12 col-md-4\">\n");
      out.write("                            \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-12 col-md-4\">\n");
      out.write("                            <div id=\"sfi\" class=\"form-group\">\n");
      out.write("                                <label class=\"col-md-2 control-label\" style=\"padding: 2% 0 0 0;\">Ver:</label>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-10 col-xs-12 input-group\">\n");
      out.write("                              <select id=\"idRepeat\" name=\"idRepeticion\"  class=\"form-control selectRepeticion\" style=\"width: 100%;\">\n");
      out.write("                                  ");

                                      int c = 0;
                                      for(String r : listaRe){
                                          String select = "";
                                          if(c==1)
                                              select = "Selected";
                                          
      out.write("\n");
      out.write("                                          <option value=\"");
      out.print(c);
      out.write('"');
      out.write(' ');
      out.print(select);
      out.write('>');
      out.print(r);
      out.write("</option>                            \n");
      out.write("                                  ");
 c++; }  
      out.write("\n");
      out.write("                              </select>\n");
      out.write("                            </div>\n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-12 col-md-4\">\n");
      out.write("                        <div id=\"sfi\" class=\"form-group\">\n");
      out.write("                            <label class=\"col-sm-3 control-label\" style=\"padding: 2% 0 0 0;\">Fecha incio:</label>\n");
      out.write("                            <div class=\"input-group date col-sm-9 col-xs-12\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                              <input type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"dp1\" autocomplete=\"off\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>       \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-12 col-md-4\">\n");
      out.write("                        <div id=\"sfi\" class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-3 control-label\" style=\"padding: 2% 0 0 0;\">Fecha final:</label>\n");
      out.write("                            <div class=\"input-group date col-md-9 col-xs-12\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                              <input type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"dp2\" autocomplete=\"off\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>       \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-12 col-md-4\">\n");
      out.write("                        <button id=\"filtrarTarea\" type=\"button\" class=\"btn-purple btn-block\" ><i class=\"fa fa-search\"></i> Filtrar</button>   \n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </div>  \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("     \n");
      out.write("    \n");
      out.write("   <div id=\"tablaTarea\" class=\"row\"></div>\n");
      out.write("   \n");
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
      out.write(" \n");
      out.write("<script>\n");
      out.write("     \n");
      out.write("    var fechaInicio  = \"\", fechaFinal = \"\";\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        estadoDate(true);\n");
      out.write("        renderTable(0, 1, fechaInicio, fechaFinal);\n");
      out.write("        renderListFuncionarios(0);\n");
      out.write("    });\n");
      out.write("    $('#idDepartamento').on('change', function() { \n");
      out.write("        renderListFuncionarios(this.value);\n");
      out.write("    });\n");
      out.write("    function renderListFuncionarios(idDepartamento){\n");
      out.write("        $.post('listaFuncionarios.jsp',\n");
      out.write("            {idD: idDepartamento},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\"#listFuncionarios\").removeClass('loader');\n");
      out.write("                    $(\"#listFuncionarios\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("            \n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\"#listFuncionarios\").removeClass('loader');\n");
      out.write("                $(\"#listFuncionarios\").html(alerta);\n");
      out.write("       }); \n");
      out.write("    }\n");
      out.write("    $('#dp1').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("            autoclose: true\n");
      out.write("    });\n");
      out.write("    $('#dp2').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("            autoclose: true\n");
      out.write("    });\n");
      out.write(" \n");
      out.write("    $('#idRepeat').on('change', function() {       \n");
      out.write("        if(this.value == '7'){\n");
      out.write("            estadoDate(false);\n");
      out.write("        }else{\n");
      out.write("            estadoDate(true);\n");
      out.write("            $('#dp1').val('');$('#dp2').val('');\n");
      out.write("        }        \n");
      out.write("    });\n");
      out.write("    \n");
      out.write("    $('#filtrarTarea').click(function (){\n");
      out.write("        fechaInicio = $('#dp1').val(); fechaFinal = $('#dp2').val();\n");
      out.write("        renderTable($('#idFuncionario').val(), $('#idRepeat').val(), fechaInicio, fechaFinal);\n");
      out.write("    })\n");
      out.write("    $('#btnRefresh').click(function (){\n");
      out.write("        fechaInicio = $('#dp1').val(); fechaFinal = $('#dp2').val();\n");
      out.write("        renderTable($('#idFuncionario').val(), $('#idRepeat').val(), fechaInicio, fechaFinal);\n");
      out.write("    })\n");
      out.write("    \n");
      out.write("    function renderTable(idU, idR, fi, ff){\n");
      out.write("        $.post('listaTarea.jsp',\n");
      out.write("            {idUsuario: idU, idRepeat: idR, fi:fi, ff:ff},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\"#tablaTarea\").removeClass('loader');\n");
      out.write("                    $(\"#tablaTarea\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("        {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\"#tablaTarea\").removeClass('loader');\n");
      out.write("                $(\"#tablaTarea\").html(alerta);\n");
      out.write("       }); \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function estadoDate(valor){\n");
      out.write("        $('#dp1').prop('disabled', valor);\n");
      out.write("        $('#dp2').prop('disabled', valor);\n");
      out.write("    }\n");
      out.write("</script>\n");
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
