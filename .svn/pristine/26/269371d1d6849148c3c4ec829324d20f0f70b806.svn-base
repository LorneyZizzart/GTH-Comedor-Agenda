<jsp:useBean id="_pregunta" class="Controlador.PreguntaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idPreguntaEncript = request.getParameter("id");
    int idPregunta = 0;
    try{
        idPregunta = Integer.parseInt(request.getParameter("id"));
    }catch (Exception e) {
        idPregunta = 0;
    }
    
    String resultado = _pregunta.EliminaPregunta(idPregunta);
    if(resultado.equals("Ok")){
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Eliminado</h4>
</div>
 <script type="text/javascript">
    $(document).ready(function () {
        $("#mensajeDelete").hide(3000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <h4><i class="icon fa fa-ban"></i> El cuestionario no se puede eliminar</h4>
    <p>Problema: <%=resultado%></p>    
</div>
<%    }   %>