<%-- 
    Document   : deleteEmpleado
    Created on : 29/05/2019, 05:47:17 PM
    Author     : pc
--%>
<%@page import="Entidad.Empleado"%>
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController"/>
<%
    int idEmpleado = 0;
    String resultado = null;
    try {
        idEmpleado = Integer.parseInt(request.getParameter("id"));
        resultado = _empleado.deleteEmpldeado(idEmpleado);
    }catch (Exception e) {
        idEmpleado = 0;
    }
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
    <h4><i class="icon fa fa-ban"></i> El empleado no se puede eliminar</h4>
    <p>Problema: <%=resultado%></p>    
</div>
<%    }   %>
