<jsp:useBean id="_send_mail_uno" class="Controlador.Send_mailController" />
<%
    String ciclo_id = request.getParameter("ciclo_id");
    String emple_evaluar = request.getParameter("emple_evaluar");
    String evaluador = request.getParameter("evaluador");
    String grupo = request.getParameter("grupo");

    out.print("Ciclo = " + ciclo_id + " evaluar a:" + emple_evaluar + "  evaluador:" + evaluador + " grupo:" + grupo);
    String mensaje = _send_mail_uno.Enviar_Un_email_a_evaluador(Integer.parseInt(ciclo_id), Integer.parseInt(emple_evaluar), Integer.parseInt(evaluador), grupo);

    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<script>
    toastr.success("Correo enviado correctamente.");
</script>
<%
} else {
%>
<script>
    toastr.error("Se produjo un error." + <%=mensaje%>);
</script>
<%
    }

%>