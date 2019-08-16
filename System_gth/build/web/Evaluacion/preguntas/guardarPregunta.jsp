<%@page import="Entidad.Pregunta"%>
<jsp:useBean id="_pregunta" class="Controlador.PreguntaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idCuestionarioEncript = request.getParameter("idCuestionario");
    String idUsuarioEncript = request.getParameter("idUsuario");
    String idPreguntaEncript = request.getParameter("idPregunta");

    Pregunta pregunta = new Pregunta();
    pregunta.setCuestionario_id(Integer.parseInt(_encript.ValorADesencriptar(idCuestionarioEncript)));
    pregunta.setUsuario_crea(Integer.parseInt(_encript.ValorADesencriptar(idUsuarioEncript)));
    pregunta.setUsuario_actualiza(Integer.parseInt(_encript.ValorADesencriptar(idUsuarioEncript)));
    pregunta.setPregunta_id(Integer.parseInt(_encript.ValorADesencriptar(idPreguntaEncript)));
    pregunta.setTipo_id(Integer.parseInt(request.getParameter("idTipo")));
    pregunta.setNombre(request.getParameter("pregunta"));
    pregunta.setOrden(Integer.parseInt(request.getParameter("orden")));

    int estado = 0;
    try {
        if (request.getParameter("estado").equalsIgnoreCase("on")) {
            estado = 1;
        } else {
            estado = 0;
        }
    } catch (Exception e) {
        estado = 0;
    }

    pregunta.setEstado(estado);

    String resultado = _pregunta.CreateOrUpdatePregunta(pregunta);
    if (resultado.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<%
    if (idPreguntaEncript.isEmpty() || idPreguntaEncript == null) {
%>
<script type="text/javascript">
    $(document).ready(function () {
        /*$("#mensaje").hide(3000, function () {
         location.reload();
         });*/
        $("form")[0].reset();
        setTimeout("location.reload()", 1000);
    });
</script>
<%
} else {
%>
<script type="text/javascript">
    $(document).ready(function () {

        /*$("#mensajeEditar").hide(3000, function () {
         location.reload();
         });*/
        $("form")[0].reset();
        setTimeout("location.reload()", 1000);
    });
</script>
<%
    }
%>
<%} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>