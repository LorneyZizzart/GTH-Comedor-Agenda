<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    A_Tarea tarea = new A_Tarea();
    String resultado = null;
    try{
        tarea.setIdTarea(Integer.parseInt(request.getParameter("id")));
        if(tarea.getIdTarea() == 0)
        tarea.setIdUserCrea(Integer.parseInt(_encript.ValorADesencriptar(request.getParameter("idUsuario"))));
        tarea.setTitulo(String.valueOf(request.getParameter("titulo")));
        tarea.setDescripcion(String.valueOf(request.getParameter("descripcion")));
        tarea.setColor(String.valueOf(request.getParameter("color")));
        tarea.setFechaInicio(String.valueOf(request.getParameter("fi")));
        tarea.setHoraInicio(request.getParameter("horaInicio"));
        tarea.setFechaFinal(String.valueOf(request.getParameter("ff")));
        tarea.setHoraFinal(request.getParameter("horaFinal"));
        tarea.setIdRepeticionTarea(Integer.parseInt(request.getParameter("idRepeticion")));
        tarea.setIdTipoTarea(Integer.parseInt(request.getParameter("idCategoria")));
        tarea.setIdEstadoTarea(Integer.parseInt(request.getParameter("idEstado")));
        resultado = _tarea.SaveOrUpdate(tarea);
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }

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
