<%@page import="Entidad.Feedback"%>
<jsp:useBean id="_feedback_ver" class="Controlador.FeedbackController" />
<jsp:useBean id="_encriptt" class="Controlador.EncriptionController" />
<%
    String id_nota = request.getParameter("sdgsdfdgsdfgsdfg");
    id_nota = id_nota.replace(" ", "+");
    id_nota = _encriptt.ValorADesencriptar(id_nota);
    Feedback datos = new Feedback();
    datos = _feedback_ver.Get_feedback_by_id(Integer.parseInt(id_nota));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="../../../bootstrap/css/bootstrap.min.css">


        <link rel="stylesheet" href="../../../plugins/fullcalendar/fullcalendar.print.css" media="print">
        <!-- Theme style -->
        <link rel="stylesheet" href="../../../dist/css/AdminLTE.min.css">

    </head>

    <body onload="window.print();">

        <div class="row">

            <!-- /.col -->
            <div class="col-md-12">
                <div>

                    <!-- /.box-header -->
                    <div class="box-body no-padding">
                        <div class="mailbox-read-info">
                            <h3><%=datos.getFeedback_tipo_nombre()%></h3>
                            <br>
                            <br>
                            <br>
                            <h4>Motivo: <%=datos.getMotivo()%>
                                <!--<span class="mailbox-read-time pull-right">11/02/2019</span>--></h4>
                            <h4>Fecha: <%=datos.getFecha_advertencia()%></h4>
                        </div>

                        <!-- /.mailbox-controls -->
                        <div class="mailbox-read-message">
                            <p>Estimado <%=datos.getNombre_empleado()%>,</p>

                            <%=datos.getDescripcion()%>
                        </div>
                        <!-- /.mailbox-read-message -->
                    </div>
                    <!-- /.box-body -->


                </div>
                <!-- /. box -->
            </div>
            <!-- /.col -->
        </div>

    </body>


</body>
</html>
