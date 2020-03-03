<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible; Content-Type" content="text/html; charset=utf-8">
        <title>GTH | Dashboard</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">        
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">       
        <style>
            .bg {
                /* The image used */
                background-image: url("images/crede_cole.png");



                /* Center and scale the image nicely */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
            .table_ {
                border:2px solid black;
            }
            canvas{
                width: 80px;
                height: 80px
                
            }
        </style>
    </head>
    <body>
       
           
                <div class="row invoice-info">
                    <%

                        int contador = 0;
                        //for (Empleado em : Empleados) {
                        for (int i = 1; i <= 50; i = i + 1) {
                            
                            if (contador == 3) {
                                out.print("</div><br><div class='row invoice-info'>");
                                contador = 0;
                                
                            }
                            System.out.println(contador);
                            
                    %>
                    <div class="col-sm-4 invoice-col <%=contador%>">
                        <table class="table_">
                            <tr style="width: 270px; height: 130px">
                                <td style="width: 120px;"><img src="images/crede_cole_i.png"> </td>
                                <td><div id="output_<%=i%>"></div>
                                    <div class="text-center"><label><%=i%></label></div></td>
                                <td style="width: 20px;"></td>
                            </tr>
                        </table>
                    </div>
                    <%
                        contador++;
                        }
                    %>
              
           
        </div>


    </body>

    <!-- jQuery 2.2.3 -->
    <!--<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>-->
    <script src="plugins/jQuery/jquery-3.4.1.min.js"></script>
    <script src="plugins/jQueryUI/jquery-ui.min.js"></script>


    <!--Genera QR-->
    <script src="dist/js/qr/jquery.qrcode.min.js"></script>


    <script type="text/javascript">
        $(document).ready(function () {


            jQuery(function () {
        <% for (int i = 1; i <= 50; i = i + 1) {
        %>
                jQuery('#output_<%=i%>').qrcode("<%=i%>");
        <%
            }
        %>

            });

        });
    </script>
</html>
