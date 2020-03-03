<%@page import="Entidad.C_TipoComida"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Reporte Comensal</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../dist/externo/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../dist/externo/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<%@page import="Entidad.C_TipoComensal"%>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    List<C_TipoComensal> listaReservas = new ArrayList<C_TipoComensal>();
    List<String> idsComensal =  new ArrayList<String>();
    List<String> idsComida = new ArrayList<String>();
    String fechaInicio = null;  String fechaFinal = null;
    Boolean orderAlfa = false, orderDate = false;
    double saldo = 0.0;
    int idComensal = Integer.parseInt(request.getParameter("idComensal"));
    try {
        
        fechaInicio =  request.getParameter("fi");
        fechaFinal = request.getParameter("ff");
        
        if (request.getParameterValues("c") != null) {
            String[] comensales  = request.getParameterValues("c");
            for (String c : comensales) {
                idsComensal.add(c);
            }
        }
         
        if (request.getParameterValues("a") != null) {
            String[] comidas = request.getParameterValues("a");
            for (String c : comidas) {
                idsComida.add(c);
            }
        }
    } catch (Exception e) {
        idsComensal = null;
        idsComida = null;
    }
    
    try{
        if(request.getParameter("oA").equalsIgnoreCase("on")) 
        orderAlfa = true;
    }catch(Exception e){
        orderAlfa = false;
    }
    
     try{
        if(request.getParameter("oF").equalsIgnoreCase("on")) 
            orderDate = true;
    }catch(Exception e){
        orderDate = false;
    }
        
    listaReservas = _empleadoReserva.getReservasForParams(fechaInicio, fechaFinal, idsComensal, idsComida, orderAlfa, orderDate, idComensal);
    
    for(C_TipoComensal c : listaReservas){
        if(c.getIdTipoComida() == 1){
            saldo = saldo + ((c.getCosto()-c.getDescuentoDesayuno())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 2){
            saldo = saldo + ((c.getCosto()-c.getDescuentoAlmuerzo())-c.getDescuentoAdicional())*c.getCantidad();
        }else if(c.getIdTipoComida() == 3){
            saldo = saldo + ((c.getCosto()-c.getDescuentoCena())-c.getDescuentoAdicional())*c.getCantidad();
       }
    }

%>

<body onload="window.print();" >
<div >
  <!-- Main content -->
  <section class="invoice">
    <!-- title row -->
    <div class="row">
      <div class="col-xs-12" style="margin-bottom: 2%;">
          <img class="img-responsive pull-left" src="../../images/uab_logo_y_texto.png" alt="User profile picture" style="width: 15%">
          <h3 class="text-center" style="width: 85%" ><strong>LISTA DE RESERVAS</strong></h3>
          <small class="pull-right"><strong>Fecha inicio:</strong> <%=fechaInicio%> <strong>&nbsp;Fecha final:</strong> <%=fechaFinal%></small>
        </div>
    </div>
    <!-- Table row -->
    <div class="row">
      <div class="col-xs-12 table-responsive">
        <table class="table table-bordered table-striped">
          <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Tipo de alimento</th>
                                <th style="width: 8%">Fecha</th>
                                <th>Cantidad</th>
                                <th style="width: 10%">Costo</th>
                                <th style="width: 10%">Descuento de comensal</th>
                                <th style="width: 10%">Descuento de adicional</th>
                                <th style="width: 10%">Precio total</th>
                                <th>Comensal</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (C_TipoComensal item : listaReservas) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=item.getNombreEmpleado()%></td>                         
                                <td><%= item.getNombreComida()%></td>
                                <td><%= item.getFecha()%></td>
                                <td><%= item.getCantidad()%></td>
                                <td><%= item.getCosto()%> Bs.</td>                                
                                <%
                                   if(item.getIdTipoComida() == 1){
                                      %><td><%= item.getDescuentoDesayuno()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 2){
                                      %><td><%= item.getDescuentoAlmuerzo()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 3){
                                      %><td><%= item.getDescuentoCena()%> Bs.</td><%  
                                   }
                                %>
                                <td><%= item.getDescuentoAdicional()%> Bs.</td>
                                <%
                                   if(item.getIdTipoComida() == 1){
                                      %><td><%=((item.getCosto()-item.getDescuentoDesayuno())-item.getDescuentoAdicional())*item.getCantidad()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 2){
                                      %><td><%= ((item.getCosto()-item.getDescuentoAlmuerzo())-item.getDescuentoAdicional())*item.getCantidad()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 3){
                                      %><td><%= ((item.getCosto()-item.getDescuentoCena())-item.getDescuentoAdicional())*item.getCantidad()%> Bs.</td><%  
                                   }
                                %>
                                <td><%= item.getNombreComensal()%></td>
                            </tr>
                            <%
                                }
                            %>
                            <tr>
                                <td colspan="8" class="text-right"><strong>COSTO TOTAL</strong></td>
                                <td colspan="2"><%=saldo%> Bs.</td>
                            </tr>
                        </tbody>
        </table>
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->
    <!-- /.row -->
  </section>
    <section>
        <div style="text-align: center; margin-top: 100px;">
            <div style="border-top: 1px solid #716f6f;
                        margin: 0 30% 0 30%;
                        border-style: dotted;
                        border-bottom: none;
                        border-left: none;
                        border-right: none;">
                <p style="margin: 0;">Sandra Mischel Charcas Enriquez</p>
                <span style="text-transform: uppercase; color: #909090;">GESTIÓN DEL TALENTO HUMANO</span>
            </div>
        </div>                        
    </section>
  <!-- /.content -->
</div>
<!-- ./wrapper -->
</body>
</html>