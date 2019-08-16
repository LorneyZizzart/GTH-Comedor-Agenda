<jsp:useBean id="_send_mail" class="Controlador.Send_mailController" />
<%
    String gestion_id = request.getParameter("id_gestion");
    String empleado_id = request.getParameter("id_empleado");

    out.print("Gestion " + gestion_id + " Empleado " + empleado_id);
    String mensaje = _send_mail.Enviar_emailEvaluacion(Integer.parseInt(gestion_id), Integer.parseInt(empleado_id));
    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<div class="alert alert-success" role="alert"> <strong>Ok!</strong> Enviado correctamente. </div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".mensaje_guarda_correo").hide(2000, function () {
            location.reload();
        });
    });
</script>

<%
} else {
%>
<div class="alert alert-danger" role="alert"> <strong>Se produjo un error!</strong> <%=mensaje%>. </div>
<%
    }
%>
