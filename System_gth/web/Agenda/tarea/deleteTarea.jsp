<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    String respuesta = "";
    String[] id = null;
    try {
        id = request.getParameter("id").split("%"); 
        respuesta = _tarea.DeleteTareaById(id[0], Integer.parseInt(id[1]));
    }catch (Exception e) {
        System.out.print("ERROR: "+e);
    }
    
    if(respuesta.equals("Ok"))
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