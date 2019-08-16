<%-- 
    Document   : deleteCliente
    Created on : 29/05/2019, 11:22:17 AM
    Author     : pc
--%>
<%@page import="Entidad.Cliente"%>
<jsp:useBean id="_cliente" class="Controlador.ClienteController" />
<%
    int idCliente = Integer.parseInt(request.getParameter("id"));
    String resultado = _cliente.DeleteCliente(idCliente);;
    
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
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%    }   %>