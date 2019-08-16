<%-- 
    Document   : guardarCliente
    Created on : 29/05/2019, 09:59:49 AM
    Author     : Jhonny
--%>
<%@page import="Entidad.Cliente"%>
<jsp:useBean id="_cliente" class="Controlador.ClienteController"/>
<%
    Cliente cliente = new Cliente();
    cliente.setCliente_id(Integer.parseInt(request.getParameter("id")));
    cliente.setNombre(request.getParameter("nombre"));
    cliente.setCorreo(request.getParameter("email"));    
    cliente.setTelefono(request.getParameter("telefono"));
    int estado = 0;
    try {
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){ 
        estado = 0;
    }
    cliente.setEstado(estado);
    
    String resultado = _cliente.InsertOrUpdateCliente(cliente);
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
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%    }   %>