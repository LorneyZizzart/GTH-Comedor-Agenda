<%-- 
    Document   : deleteUsuario
    Created on : 29/05/2019, 06:19:03 PM
    Author     : Jhonny
--%>
<%@page import="Entidad.Usuario"%>
<jsp:useBean id="_usuario" class="Controlador.UsuarioController"/>
<%
    int idUsuario = 0;
    String resultado = null;
    try {
        idUsuario = Integer.parseInt(request.getParameter("id"));
        resultado = _usuario.DeleteUsuario(idUsuario);
    }catch (Exception e) {
        idUsuario = 0;
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