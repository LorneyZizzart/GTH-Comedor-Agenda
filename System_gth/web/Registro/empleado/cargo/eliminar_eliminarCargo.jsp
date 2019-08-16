<%-- 
    Document   : eliminar_eliminarCargo
    Created on : 24/05/2019, 01:09:53 PM
    Author     : pc
--%>
<jsp:useBean id="_cargo" class="Controlador.Empleado_cargoController" />
<%
    int idEmpleadoCargo = Integer.parseInt(request.getParameter("id"));
    String resultado = _cargo.DeleteEmpleado_cargo(idEmpleadoCargo);
    
    if(resultado.equalsIgnoreCase("Ok")){
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
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%    }   %>