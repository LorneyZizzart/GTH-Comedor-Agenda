<jsp:useBean id="_login" class="Controlador.LoginController" />
<%@page import="Entidad.Login_Entidad"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GTH | Encuesta</title>
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
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet" href="../../bootstrap/css/myStyle.css">

        <!-- Para Mostrar las alertas Toast-->
        <link rel="stylesheet" href="../../bootstrap/toast_alert/toastr.css" />


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <jsp:useBean id="_encripta" class="Controlador.EncriptionController" />   
        <%
            String idEncrip = request.getParameter("iasdfsdfasdf121as2dd1f21sf12d");
            idEncrip = idEncrip.replace(" ", "+");
            int id = Integer.parseInt(_encripta.ValorADesencriptar(idEncrip));
            Login_Entidad usuario_evalua = new Login_Entidad();
            usuario_evalua = _login.evaluacion_login((id));
            usuario_evalua.setEmpleado_id(usuario_evalua.getUser_id());
            usuario_evalua.setAccion("Comienza la evaluacion. Encuesta_id :" + id);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("USUARIO", usuario_evalua);

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
                <a class="logo logo-respuesta">
                    <span class="logo-lg"><b>GTH</b>UAB</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">   
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a class="dropdown-toggle" data-toggle="dropdown">

                                    <%if (usuario_evalua.getUser_id() > 0) {
                                    %>
                                    <input id="cuestionario_id_evalua" type="hidden" value="<%=id%>">
                                    <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                                    <span class="hidden-xs"><%=usuario_evalua.getNombreCompleto()%></span><%
                                        }
                                    %>

                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>