<jsp:useBean id="copiadatabase" class="Controlador.BasededatosController" />
<%
    String resultado = copiadatabase.Copia_deSeguridad();
    if (resultado.equalsIgnoreCase("Ok")) {
%>
<div class="alert alert-success alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-check"></i> Copia de base de datos realizado con exito!</h4>
</div>

<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%
    }

%>