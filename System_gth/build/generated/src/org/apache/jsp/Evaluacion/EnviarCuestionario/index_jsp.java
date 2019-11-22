package org.apache.jsp.Evaluacion.EnviarCuestionario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Cliente;
import Entidad.View_Empleado_Encuesta;
import Entidad.Cuestionario;
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
    _jspx_dependants.add("/Evaluacion/EnviarCuestionario/../../masterPage/complemento/head.jsp");
    _jspx_dependants.add("/Evaluacion/EnviarCuestionario/../../masterPage/complemento/menu.jsp");
    _jspx_dependants.add("/Evaluacion/EnviarCuestionario/../../masterPage/complemento/footer.jsp");
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
      out.write('\n');
      Controlador.EncriptionController __encript = null;
      synchronized (_jspx_page_context) {
        __encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("__encript", PageContext.PAGE_SCOPE);
        if (__encript == null){
          __encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("__encript", __encript, PageContext.PAGE_SCOPE);
        }
      }
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
      out.write("        \n");
      out.write("        <!-- bootstrap wysihtml5 - text editor -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Para Mostrar las alertas Toast-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../bootstrap/toast_alert/toastr.css\" />\n");
      out.write("\n");
      out.write("        <script src=\"../../plugins/jQuery/jquery-3.4.1.min.js\"></script>    \n");
      out.write("        <!-- bootstrap datepicker -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../plugins/datepicker/datepicker3.css\">\n");
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
      out.write('\n');
        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
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
      Controlador.CuestionarioController _cuestionario = null;
      synchronized (_jspx_page_context) {
        _cuestionario = (Controlador.CuestionarioController) _jspx_page_context.getAttribute("_cuestionario", PageContext.PAGE_SCOPE);
        if (_cuestionario == null){
          _cuestionario = new Controlador.CuestionarioController();
          _jspx_page_context.setAttribute("_cuestionario", _cuestionario, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Cuestionario_empleadoController _cuestionarioEmpleado = null;
      synchronized (_jspx_page_context) {
        _cuestionarioEmpleado = (Controlador.Cuestionario_empleadoController) _jspx_page_context.getAttribute("_cuestionarioEmpleado", PageContext.PAGE_SCOPE);
        if (_cuestionarioEmpleado == null){
          _cuestionarioEmpleado = new Controlador.Cuestionario_empleadoController();
          _jspx_page_context.setAttribute("_cuestionarioEmpleado", _cuestionarioEmpleado, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String idEncript = request.getParameter("e").replace(" ", "+");;
    int idCuestionario = 0;
    Cuestionario cuestionario = new Cuestionario();
    List<View_Empleado_Encuesta> listaEmpleadoCuestionario = new ArrayList<View_Empleado_Encuesta>();
    try {
        idCuestionario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cuestionario = _cuestionario.GetCuestionariobyCuestionario_id(idCuestionario);
        listaEmpleadoCuestionario = _cuestionarioEmpleado.GetEmpleadosEncuentaByCuestionarioID(idCuestionario);
    } catch (Exception e) {
        idCuestionario = 0;
    }

      out.write("\n");
      out.write("<section class=\"content-header\">\n");
      out.write("    <h1>\n");
      out.write("        ");
      out.print(cuestionario.getNombre());
      out.write("\n");
      out.write("        <small> cuestionario</small>\n");
      out.write("    </h1>\n");
      out.write("    <ol class=\"breadcrumb\">\n");
      out.write("        <li><a href=\"../../masterPage/complemento/index.jsp\"><i class=\"fa fa-home\"></i> Home</a></li>\n");
      out.write("        <li><a href=\"../Cuestionario/index.jsp\"><i class=\"fa fa-th-list\"></i> Lista de cuentas</a></li>\n");
      out.write("        <li class=\"active\">Envios de cuestionario</li>\n");
      out.write("    </ol>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<!-- Main content -->\n");
      out.write("<section class=\"content\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-12\">            \n");
      out.write("            <div class=\"box box-purple\">\n");
      out.write("                <div class=\"box-header with-border\">\n");
      out.write("                    <h3 class=\"box-title\">Eniviar cuestionario</h3>\n");
      out.write("                    <!-- /.box-tools -->\n");
      out.write("                    <div id=\"mensaje\"></div>\n");
      out.write("                </div>\n");
      out.write("                <form id=\"form_enviar\" method=\"post\" class=\"form_enviar\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(cuestionario.getCuestionario_id());
      out.write("\" name=\"idCuestionario\" id=\"idCuestionario\">\n");
      out.write("                    <div class=\"box-body no-padding\">\n");
      out.write("\n");
      out.write("                        <div class=\"table-responsive mailbox-messages table-responsive\">\n");
      out.write("                            <table class=\"table table-hover table-striped\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th class=\"text-center\">#</th>\n");
      out.write("                                        <th>Nombre</th>\n");
      out.write("                                        <th style=\"width: 5%\">Autoevaluación</th>\n");
      out.write("                                        <th style=\"width: 19%\">Jefes</th>\n");
      out.write("                                        <th style=\"width: 19%\">Pares</th>\n");
      out.write("                                        <th style=\"width: 19%\">Bajos</th>\n");
      out.write("                                        <th style=\"width: 19%\">Clientes</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");

                                        int contador = 0;
                                        for (View_Empleado_Encuesta empleado : listaEmpleadoCuestionario) {
                                            contador++;
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(contador);
      out.write(" <input type=\"hidden\" name=\"posicion_celda\" value=\"");
      out.print(contador);
      out.write("\" class=\"posicion_celda\"> </td>\n");
      out.write("\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print(empleado.getEmpleado_id());
      out.write("\" name=\"idEmpleado");
      out.print(contador);
      out.write("\" id=\"idEmpleado");
      out.print(contador);
      out.write("\">\n");
      out.write("                                <td class=\"mailbox-name\">");
      out.print(empleado.getNombre_empleado());
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\"><input class=\"autoEvaluacion\" name=\"autoEvaluacion\" id=\"autoEvaluacion");
      out.print(contador);
      out.write("\" type=\"checkbox\"></td>\n");
      out.write("                                <td class=\"mailbox-subject\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <select name=\"idJefe");
      out.print(contador);
      out.write("\" id=\"idJefe");
      out.print(contador);
      out.write("\"  class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">\n");
      out.write("                                            ");

                                                for (View_Empleado_Encuesta jefe : empleado.getJefes()) {
                                                    String Select = "";
                                                    for(View_Empleado_Encuesta auxJefe : empleado.getSelect_Jefes()){
                                                        if(jefe.getEmpleado_id() == auxJefe.getEmpleado_id())
                                                            Select = "Selected";
                                                    }
                                            
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(jefe.getEmpleado_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(jefe.getNombre_empleado());
      out.write("</option>\n");
      out.write("                                            ");
 }
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"mailbox-attachment\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <select name=\"idPar");
      out.print(contador);
      out.write("\" id=\"idPar");
      out.print(contador);
      out.write("\" class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">\n");
      out.write("                                            ");

                                                for (View_Empleado_Encuesta pares : empleado.getPares()) {
                                                    String Select = "";
                                                    for(View_Empleado_Encuesta auxPares : empleado.getSelect_Pares()){
                                                        if(pares.getEmpleado_id() == auxPares.getEmpleado_id())
                                                            Select = "Selected";
                                                    }

                                            
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(pares.getEmpleado_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(pares.getNombre_empleado());
      out.write("</option>\n");
      out.write("                                            ");
 }
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"mailbox-date\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <select name=\"idBajo");
      out.print(contador);
      out.write("\" id=\"idBajo");
      out.print(contador);
      out.write("\" class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">\n");
      out.write("                                            ");

                                                for (View_Empleado_Encuesta bajo : empleado.getBajos()) {
                                                    String Select = "";
                                                    for(View_Empleado_Encuesta auxBajo : empleado.getSelect_Bajos()){
                                                        if(bajo.getEmpleado_id() == auxBajo.getEmpleado_id())
                                                            Select = "Selected";
                                                    }
                                            
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(bajo.getEmpleado_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(bajo.getNombre_empleado());
      out.write("</option>\n");
      out.write("                                            ");
 }
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"mailbox-date\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <select name=\"idCliente");
      out.print(contador);
      out.write("\" id=\"idCliente");
      out.print(contador);
      out.write("\" class=\"form-control select2\" multiple=\"multiple\" style=\"width: 100%;\">\n");
      out.write("                                            ");

                                                for (Cliente cliente : empleado.getClientes()) {
                                                    String Select = "";
                                                    for(Cliente auxCliente : empleado.getSelect_Clientes()){
                                                        if(cliente.getCliente_id() == auxCliente.getCliente_id())
                                                            Select = "Selected";
                                                    }

                                            
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(cliente.getCliente_id());
      out.write('"');
      out.write(' ');
      out.print(Select);
      out.write('>');
      out.print(cliente.getNombre());
      out.write("</option>\n");
      out.write("                                            ");
 } 
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
   }
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <!-- /.table -->\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.mail-box-messages -->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box-footer no-padding\">\n");
      out.write("                        <div class=\"mailbox-controls\">\n");
      out.write("                            <!-- Check all button -->\n");
      out.write("                            <!--<button type=\"submit\" class=\"btn-purple pull-right btn-enviar\"><i class=\"fa fa-save\"></i> Guardar </button>-->\n");
      out.write("                            <button type=\"button\" class=\"btn-purple pull-right btn-enviar_datos\"><i class=\"fa fa-save\"></i> Guardar </button>\n");
      out.write("                            <br><br>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                                \n");
      out.write("            </div>\n");
      out.write("            <!-- /.box -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.row -->\n");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("        $('.select2').select2()\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("    $(\".btn-enviar_datos\").click(function () {\n");
      out.write("        var jsonEncuesta = {};\n");
      out.write("        var array = [];\n");
      out.write("        var funcionario = [];\n");
      out.write("        var valor = $(\".posicion_celda\").each(function () {\n");
      out.write("            var id = $(this).val();\n");
      out.write("            array.push(id);\n");
      out.write("        });\n");
      out.write("        array.forEach(function (element) {\n");
      out.write("            \n");
      out.write("            funcionario.push({\n");
      out.write("               \"idEmpleado\" :  $('#idEmpleado' + element).val(),\n");
      out.write("               \"autoEvaluacion\" : $(\".autoEvaluacion\").val(),\n");
      out.write("               \"jefe\" : [{\n");
      out.write("                   \"idJefe\" : $('#idJefe' + element).val()\n");
      out.write("               }],\n");
      out.write("               \"par\" : [{\n");
      out.write("                   \"idPar\" : $('#idPar' + element).val()\n");
      out.write("               }],\n");
      out.write("               \"bajo\" : [{\n");
      out.write("                   \"idBajo\" : $('#idBajo' + element).val()\n");
      out.write("               }],\n");
      out.write("               \"cliente\" : [{\n");
      out.write("                   \"idCliente\" : $('#idCliente' + element).val()\n");
      out.write("               }]\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        });\n");
      out.write("        jsonEncuesta.idCuestionario = $(\"#idCuestionario\").val();\n");
      out.write("        jsonEncuesta.empleado = funcionario;\n");
      out.write("        var jsonString = JSON.stringify(jsonEncuesta);\n");
      out.write("        console.log(jsonString);\n");
      out.write("        $.ajax({\n");
      out.write("            type: \"POST\",\n");
      out.write("            url: \"guardarEncuestador.jsp\",\n");
      out.write("            data: {\"Object\" :jsonString},\n");
      out.write("            success: function (data)\n");
      out.write("            {\n");
      out.write("                $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                $(\"#mensaje\").html(data);\n");
      out.write("            }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                $(\"#mensaje\").html(menn);\n");
      out.write("            }\n");
      out.write("        });\n");
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
