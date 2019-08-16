<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GTH | Log in</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="dist/externo/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="dist/externo/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
        <link rel="stylesheet" href="bootstrap/css/myStyle.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .loader{
                background-image: url(bootstrap/images/ajax-loader.gif);
                background-repeat: no-repeat;
                background-position: center;
                height: 100px;                
            }          
        </style>
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="#"><b>GTH</b>V0.1</a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Iniciar sesión</p>

                <form action="index.html" method="post">
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" placeholder="Email" id="email">
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Password" id="password">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> Remember Me
                                </label>
                            </div>
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" id="sigin" class="btn-purple btn-block btn-flat">Ingresar</button>
                        </div>
                        <!-- /.col -->
                    </div>
                    <div class="inicioseccion"></div>
                </form>                              

                <!-- /.login-box-body -->
            </div>
            <!-- /.login-box -->
        </div>

        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="plugins/iCheck/icheck.min.js"></script>

        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });

            $(document).ready(function () {
                $("#sigin").click(function () {
                    var correo = $('#email').val();
                    var password = $('#password').val();
                    $(".inicioseccion").addClass('loader');
                    $.post('valida.jsp',
                            {correo: correo,
                                password: password},
                            function (html) {
                                $(".inicioseccion").removeClass('loader');
                                $(".inicioseccion").html(html);
                            }
                    ).fail(function (jqXHR, textStatus, errorThrown)
                    {
                        $(".inicioseccion").removeClass('loader');
                        $(".inicioseccion").html("<p class='text-danger'>" + errorThrown + " " + textStatus + "</p>");
                    });
                    return false;
                });
            });
        </script>
    </body>
</html>
