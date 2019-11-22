<%@page import="Entidad.C_Empleado_Reserva"%>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController" />
<%
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String resultado = "";
    int idEmpleadoReserva = 0;
    try{
        idEmpleadoReserva = Integer.parseInt(request.getParameter("id"));

        empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad")));

        empleadoReserva.setObservacion(request.getParameter("observacion"));
        
        resultado =  _empleadoReserva.EditEmpleadoReservaById(idEmpleadoReserva, empleadoReserva);
    }catch(Exception e){
        System.out.print("Error: Se ha producido un error al registrar la reserva. " + e);
    }
    if(resultado.equalsIgnoreCase("Ok")){
 %>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Reserva actualizada</h4>
</div>
 <script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Error: <%=resultado%>
</div>
<%    }   %>
