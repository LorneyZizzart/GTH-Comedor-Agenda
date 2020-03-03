<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.C_TipoComensal"%>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController" />
<jsp:useBean id="__encript" class="Controlador.EncriptionController" />

<!DOCTYPE html>
<a href="../../Comensal/editarReservas/listaReserva.jsp"></a>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible; Content-Type" content="text/html; charset=utf-8">
        <title>GTH | Dashboard</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
        <!-- Bootstrap validator -->
        <link rel="stylesheet" href="../../dist/css/bootstrapValidator.css"/>
        <!-- Select2 -->
        <link rel="stylesheet" href="../../plugins/select2/select2.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="../../dist/externo/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="../../dist/externo/ionicons.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="../../plugins/datatables/dataTables.bootstrap.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
        <!-- Bootstrap Color Picker -->
        <link rel="stylesheet" href="../../plugins/colorpicker/bootstrap-colorpicker.min.css">
        <!-- Bootstrap time Picker -->
        <link rel="stylesheet" href="../../plugins/timepicker/bootstrap-timepicker.min.css">
        <!-- fullCalendar -->
        <link rel='stylesheet' href="../../dist/fullcalendar-4.2.0/packages/core/main.min.css">
        <link rel='stylesheet' href="../../dist/fullcalendar-4.2.0/packages/daygrid/main.min.css">
        <link rel='stylesheet' href="../../dist/fullcalendar-4.2.0/packages/timegrid/main.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
        
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

        <!-- Para Mostrar las alertas Toast-->
        <link rel="stylesheet" href="../../bootstrap/toast_alert/toastr.css" />

        <script src="../../plugins/jQuery/jquery-3.4.1.min.js"></script>  
        <!-- bootstrap datepicker -->
        <link rel="stylesheet" href="../../plugins/datepicker/datepicker3.css">
        <!--image lightgallery.css-->
        <link type="text/css" rel="stylesheet" href="../../plugins/lightGallery-master/dist/css/lightgallery.css" /> 
        
        <!--emprimir-->
        
        <link rel="stylesheet" href="../../bootstrap/css/myStyle.css">
    
        <!--<link rel="stylesheet" type="text/css" href="../../plugins/tablaEditor/css/tablaEditor.css" />-->

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <%
            String Nombre_Usuario = "";
            Login_Entidad DatoUsuario = new Login_Entidad();

            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("USUARIO") == null) {
        %>
        <script>window.location.href = '../../login.jsp';</script>
        <%
            } else {
                DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
            }
            List<C_TipoComensal> listaReservas = new ArrayList<C_TipoComensal>();

            int a = 0;
            if(DatoUsuario.getUser_id() == 1 || DatoUsuario.getUser_id() == 3031){
                listaReservas = _empleadoReserva.getNotificaionesDeReservas();
                for (C_TipoComensal item : listaReservas) {
                    a++;
                }
            }
            int NotificaionMostrarTodo = 0; 
        %>
        <style>
            .loader{
                background-image: url(../../bootstrap/images/ajax-loader.gif);
                background-repeat: no-repeat;
                background-position: center;
                height: 100px;                
            }          
        </style>
    </head>
    <body class="hold-transition  skin-purple-light sidebar-mini">
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="../../masterPage/complemento/index.jsp" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>GTH</b></span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>GTH</b>UAB</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav"> 
                            <%
                                 if(DatoUsuario.getUser_id() == 1 || DatoUsuario.getUser_id() == 3031){
                            %>
                            <!-- Notifications: mas de 3 platos -> Daniel-17/12/2019 -->
                            <li class="dropdown notifications-menu">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-bell-o"></i>
                                <span class="label label-warning"><%=a%></span>
                              </a>
                              <ul class="dropdown-menu">
                                <li class="header">Tienes <%=a%> notificaciones</li>
                                <li>
                                  <!-- inner menu: contains the actual data -->
                                  <ul class="menu">
                                    <%
                                        for (C_TipoComensal item : listaReservas) {
                                            String backColor = "";
                                            if(item.getNotificacion()==1){
                                                backColor = "#e4e7ea";
                                            }
                                    %>
                                    <li style="background-color: <%=backColor%>" >
                                        <a href="../../Comensal/editarReservas?ListarNotificaion=2&IdTipoComida=<%=item.getIdTipoComida()%>&IdEmpleado=<%=item.getIdEmpleado()%>&Fecha=<%=item.getFecha()%>">
                                        <!--<a href="../../Comensal/editarReservas?ListarNotificaion=2&IdTipoComida=<%=item.getIdTipoComida()%>&IdTipoComensal=<%=item.getIdTipoComensal()%>&Fecha=<%=item.getFecha()%>">-->
                                            <i class="fa fa-user text-aqua"></i> <b><%=item.getNombreEmpleado()%></b><br><p style="color: #a0a0a0; margin-left: 20px;"><strong>Observaciones: </strong><%= item.getObservacion()%></p>
                                        </a>
                                    </li>
                                    <%
                                        }
                                    %>
                                  </ul>
                                </li>
                                <li class="footer">
                                    <a href="../../Comensal/editarReservas?ListarNotificaion=1">Ver todo</a>     
                                </li>
                              </ul>
                            </li>
                            <%}%>
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="../../folder_picture/../images/user.png" class="user-image" alt="User Image">
                                    <span class="hidden-xs"><%=DatoUsuario.getNombreCompleto()%></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="../../folder_picture/../images/user.png" class="img-circle" alt="User Image">

                                        <p>
                                            <%=DatoUsuario.getNombreCompleto()%> - <%=DatoUsuario.getPerfil()%>
                                            <small>Member since Nov. 2012</small>
                                        </p>
                                    </li>

                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="../../Funcionario/perfil/historialFuncionario.jsp?i=<%=__encript.ValorAEncriptar(Integer.toString(DatoUsuario.getEmpleado_id()))%>" class="btn btn-default btn-flat">Perfil</a>
                                        </div>
                                        <div class="pull-right">
                                            <a class="btn btn-default btn-flat btn_salir" id="btn_salir">Salir</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!-- Control Sidebar Toggle Button -->
                            
                            <li>
                                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>