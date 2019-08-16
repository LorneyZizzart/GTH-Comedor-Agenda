<%-- 
    Document   : deleteArea
    Created on : 27/05/2019, 10:20:56 AM
    Author     : pc
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Departamento"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<%
    int idTipoComida = 0; 
    String resultado = null;
    try {
        idTipoComida = Integer.parseInt(request.getParameter("id"));
        resultado = _tipoComida.DeleteTipoComidaById(idTipoComida);
    }catch (Exception e) {
        idTipoComida = 0;
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
    <h4><i class="icon fa fa-ban"></i> Alert</h4>
    <p>Problema: <%=resultado%></p>    
</div>
<%    }   %>