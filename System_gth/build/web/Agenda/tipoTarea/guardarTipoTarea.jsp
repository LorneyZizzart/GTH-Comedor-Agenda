<%@page import="Entidad.A_TipoTarea"%>
<jsp:useBean id="_tipoTarea" class="Controlador.A_TipoTareaController"/>
<%
    A_TipoTarea tipoTarea = new A_TipoTarea();
    tipoTarea.setIdTipoTarea(Integer.parseInt(request.getParameter("id")));
    tipoTarea.setNombreTarea(request.getParameter("tipoTarea"));

    int estado = 0;
    try{
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    tipoTarea.setEstadoTipoTarea(estado);
    
    String resultado = _tipoTarea.SaveOrUpdate(tipoTarea);
//    String resultado = "";

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
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>
