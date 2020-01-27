<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    
    String resultado = null;
    int idTarea = 0;
    try{
        idTarea = Integer.parseInt(request.getParameter("idTarea"));
        int idEstado = Integer.parseInt(request.getParameter("idEstado"));
        resultado = _tarea.CambiarEstadoTarea(idTarea, idEstado);
        
    }catch(Exception e){
        resultado =  "Se ha producido al cambiar estado. Error: " + e;
    }
    
    if(resultado.equalsIgnoreCase("Ok"))
{
%>
<script type="text/javascript">
    $(document).ready(function () {
        fechaInicio = $('#dp1').val(); fechaFinal = $('#dp2').val();
        renderTable($('#idFuncionario').val(), $('#idRepeat').val(), fechaInicio, fechaFinal);
    });
</script>
<%}else{System.out.print("Error al actulizar el estado de la tarea");%>
<%}%>
