<jsp:useBean id="registra_persona_Actividad" class="Controlador.Evento_ActividadController" />
<%
    String id_evento = request.getParameter("id_evento");
    String id_actividad = request.getParameter("id_actividad");
    String id_empleado = request.getParameter("id_empleado");

    String respuesta = registra_persona_Actividad.RegistroAsistenciaActividad(Integer.parseInt(id_empleado), Integer.parseInt(id_actividad));
    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<script type="text/javascript">
    toastr.success("Registrado Correctamente.");
    $("#tr_<%=id_empleado%>").remove();
</script>
<%
} else {
%>
<script type="text/javascript">
    toastr.error("Se produjo un error." +<%=respuesta%>);
</script>
<%
    }
%>