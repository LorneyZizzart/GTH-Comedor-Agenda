<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController"/>
<%
    String respuesta = "";
    String[] idReserva = request.getParameter("id").split("%");
    try {
        if(Integer.parseInt(idReserva[1]) == 1){
            respuesta = _empleadoReserva.DeleteEmpleadoReserva(Integer.parseInt(idReserva[0]));
        }else{
            respuesta = _empleadoReserva.DeleteReservaExterna(Integer.parseInt(idReserva[0]));
        }
        
    }catch (Exception e) {

        respuesta = ""+e;
    }
    
    if(respuesta.equalsIgnoreCase("Ok"))
{
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Eliminado</h4>
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
    Error: <%=respuesta%>
</div>
<%    }   %>