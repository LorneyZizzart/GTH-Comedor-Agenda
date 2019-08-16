<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />

<%
    String id_cuestionario = request.getParameter("id_gestion");
    String correo_ = request.getParameter("correo_mail");
    String titulo_correo_ = request.getParameter("titulo_correo");

    //out.print(correo_);
    String guarda_correo = _ciclo.SaveCorreoMensaje(id_cuestionario, correo_, titulo_correo_);
    if (guarda_correo.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".mensaje_guarda_correo").hide(2000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=guarda_correo%>
</div>
<%}%>