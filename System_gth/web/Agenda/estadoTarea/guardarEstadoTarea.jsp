<%@page import="Entidad.A_EstadoTarea"%>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<%
    A_EstadoTarea estadoTarea = new A_EstadoTarea();
    estadoTarea.setIdEstadoTarea(Integer.parseInt(request.getParameter("id")));
    estadoTarea.setNombreEstadoTarea(request.getParameter("nombre"));

    int estado = 0;
    try{
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    estadoTarea.setEstadoEstadoTarea(estado);
    
    String resultado = _estadoTarea.SaveOrUpdate(estadoTarea);
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
