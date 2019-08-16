<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    String respuesta = "";
    int id = 0;
    try {
        id = Integer.parseInt(request.getParameter("id"));
        respuesta = _tarea.DeleteTareaById(id);
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
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=respuesta%>
</div>
<%}%>