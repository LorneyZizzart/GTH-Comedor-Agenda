<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GTH | Dashboard</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->        
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
        <!-- Bootstrap validator -->
        <link rel="stylesheet" href="../../dist/css/bootstrapValidator.css"/>
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
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="index2.html" class="logo">
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

                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                                    <span class="hidden-xs">Rob</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                        <p>
                                            <small>Member since Nov. 2012</small>
                                        </p>
                                    </li>

                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="#" class="btn btn-default btn-flat">Perfil</a>
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

            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Hola</p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">MENÚ PRINCIPAL</li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> <span>Nomre</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-circle-o"></i>Rob</a></li>                    
                            </ul>
                        </li>


                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">            

                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="page-header">
                                <h2>Using special names such as user[firtName], user.username</h2>
                            </div>

                            <form id="defaultForm" method="post" class="form-horizontal" action="target.php">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Full name</label>
                                    <div class="col-lg-4">
                                        <input type="text" class="form-control" name="user[firstName]" placeholder="First name" />
                                    </div>
                                    <div class="col-lg-4">
                                        <input type="text" class="form-control" name="user[lastName]" placeholder="Last name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Username</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" name="user.username" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Email address</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" name="user.email" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Password</label>
                                    <div class="col-lg-5">
                                        <input type="password" class="form-control" name="user[password]" id="password" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Gender</label>
                                    <div class="col-lg-5">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="gender" value="male" /> Male
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="gender" value="female" /> Female
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="gender" value="other" /> Other
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Birthday</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" name="birthday" /> (YYYY/MM/DD)
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-9 col-lg-offset-3">
                                        <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Sign up</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>



            </div>
            <!-- /.content-wrapper -->

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 0.1
                </div>
                <strong>Copyright &copy; 2019 <a href="http://www.uab.edu.bo">UAB</a>.</strong> All rights
                reserved.
            </footer>

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Create the tabs -->
                <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                    <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <!-- Home tab content -->
                    <div class="tab-pane" id="control-sidebar-home-tab">
                        <h3 class="control-sidebar-heading">Recent Activity</h3>
                    </div>

                </div>
            </aside>
            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>

            <!-- ./wrapper -->

            <!-- jQuery 2.2.3 -->
            <script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
            <!-- Bootstrap 3.3.6 -->
            <script src="../../bootstrap/js/bootstrap.min.js"></script>
            <!-- Bootstrap validator -->
            <script type="text/javascript" src="../../dist/js/bootstrapValidator.js"></script>
            <!-- Slimscroll -->
            <script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
            <!-- FastClick -->
            <script src="../../plugins/fastclick/fastclick.js"></script>
            <!-- AdminLTE App -->
            <script src="../../dist/js/app.min.js"></script>

            <!-- DataTables -->
            <script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>

            <script type="text/javascript" charset="utf-8">
                $("#btn_salir").click(function () {
                    $.post('../../masterPage/complemento/salir.jsp',
                            {mensaje: 'Salir'},
                            function (html) {
                                $(".salir_pagin_session").html(html);
                            }
                    ).fail(function (jqXHR, textStatus, errorThrown)
                    {
                        $(".salir_pagin_session").html("<p class='text-danger'>" + errorThrown + "</p>");
                    });
                });
            </script>

            <div class="salir_pagin_session"></div>

            <script type="text/javascript">
                $(document).ready(function () {
                    $('#defaultForm').bootstrapValidator({
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            'user[firstName]': {
                                validators: {
                                    notEmpty: {
                                        message: 'The first name is required and cannot be empty'
                                    }
                                }
                            },
                            'user[lastName]': {
                                validators: {
                                    notEmpty: {
                                        message: 'The last name is required and cannot be empty'
                                    }
                                }
                            },
                            'user.username': {
                                message: 'The username is not valid',
                                validators: {
                                    notEmpty: {
                                        message: 'The username is required and cannot be empty'
                                    },
                                    stringLength: {
                                        min: 6,
                                        max: 30,
                                        message: 'The username must be more than 6 and less than 30 characters long'
                                    },
                                    regexp: {
                                        regexp: /^[a-zA-Z0-9_\.]+$/,
                                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                                    },
                                    different: {
                                        field: 'user[password]',
                                        message: 'The username and password cannot be the same as each other'
                                    }
                                }
                            },
                            'user.email': {
                                validators: {
                                    emailAddress: {
                                        message: 'The input is not a valid email address'
                                    }
                                }
                            },
                            'user[password]': {
                                // It still work even if you use the selector option
                                //selector: '#password',
                                validators: {
                                    notEmpty: {
                                        message: 'The password is required and cannot be empty'
                                    },
                                    different: {
                                        field: 'user.username',
                                        message: 'The password cannot be the same as username'
                                    }
                                }
                            },
                            birthday: {
                                validators: {
                                    date: {
                                        format: 'YYYY/MM/DD',
                                        message: 'The birthday is not valid'
                                    }
                                }
                            },
                            gender: {
                                validators: {
                                    notEmpty: {
                                        message: 'The gender is required'
                                    }
                                }
                            }
                        }
                    });
                });
            </script>
    </body>
</html>
