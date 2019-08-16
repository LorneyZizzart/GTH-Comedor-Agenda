
<%@page import="Entidad.Feedback"%>
<jsp:useBean id="_feedback_guarda" class="Controlador.FeedbackController" />
<%
    Feedback retroalimenta = new Feedback();

    retroalimenta.setEmpleado_id(Integer.parseInt(request.getParameter("emple_id")));
    retroalimenta.setAdmin_id(Integer.parseInt(request.getParameter("admin_id")));
    retroalimenta.setFeedback_tipo_id(Integer.parseInt(request.getParameter("retro_tipo_adver")));
    retroalimenta.setFeedback_id(Integer.parseInt(request.getParameter("feedback_id")));
    retroalimenta.setMotivo((request.getParameter("retro_motivo")));

    String fecha = request.getParameter("retro_fecha");
    //   Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
    retroalimenta.setFecha_advertencia(fecha);
    retroalimenta.setDescripcion(request.getParameter("retro_descripcion"));

    String mensaje = _feedback_guarda.Create_or_update(retroalimenta);

    //out.print(mensaje);
    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        setTimeout("location.reload()", 1000);
    });
</script>
<%
} else {
%>
<div class=" text-center alert alert-danger alert-dismissible">
    <h4><i class="icon fa fa-check"></i> se produjo un errro: <%=mensaje%></h4>
</div>
<%
    }
%>