<%@page import="Entidad.C_Empleado_Reserva"%>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController"/>
<%
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String resultado = "Ok";
    
    try{
        empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        empleadoReserva.setIdTipoComensal(Integer.parseInt(request.getParameter("idTipoCo")));
        empleadoReserva.setObservacion(request.getParameter("observacion"));
        empleadoReserva.setDescuentoAdicional(Double.parseDouble(request.getParameter("descuentoAdicional")));
        empleadoReserva.setNotificacion(0);
        empleadoReserva.setListarNotifiacion(0);
        resultado = _empleadoReserva.EditEmpleadoReservaById(Integer.parseInt(request.getParameter("idReserva")), empleadoReserva);
    }catch(Exception e){
        resultado = "Se ha producido un error, no llegaron todos los atributos.";
    }    
    
    if(resultado.equalsIgnoreCase("Ok")){
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
 <script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>
