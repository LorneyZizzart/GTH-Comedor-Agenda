<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<%
    String respuesta = "";
    int id = 0;
    try {
        id = Integer.parseInt(request.getParameter("id"));
        respuesta = _estadoTarea.DeleteEstadoTareaById(id);
    }catch (Exception e) {
        id = 0;
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
}
%>