<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="guardaPlan" class="Controlador.Plan_objetivoController" />
<%
    HttpSession sesion = request.getSession();
    //out.print(sesion.getAttribute("USUARIO"));
    if (session.getAttribute("USUARIO") == null) {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Termino su sesión, ingrese nuevamente haga clic <a href="../../"> aquí.</a>
</div>
<%
} else {
    Login_Entidad DatoUsuario = new Login_Entidad();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    String plan_id = request.getParameter("plan_id");
    String plan_titulo = request.getParameter("plan_titulo");
    String plan_creditacion = request.getParameter("plan_creditacion");
    String plan_gestion = request.getParameter("plan_gestion");
    String plan_estado = request.getParameter("plan_estado");
    int emplado_id = DatoUsuario.getEmpleado_id();

    Plan_objetivo plan = new Plan_objetivo();
    plan.setPlan_objetivo_id(Integer.parseInt(plan_id));
    plan.setTitulo(plan_titulo);
    plan.setCreditacion(plan_creditacion);
    plan.setGestion(Integer.parseInt(plan_gestion));
    plan.setEstado(Integer.parseInt(plan_estado));
    plan.setEmpleado_id(emplado_id);

    String mensajereturn = guardaPlan.SaveorUpdateObjetivo(plan);
    String[] parts = mensajereturn.split("##");
    String mensaje = parts[0];
    if (mensaje.equalsIgnoreCase("Ok")) {

        if (parts[1].equalsIgnoreCase("Actualiza")) {

%>
<div class="text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(1500, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%    } else {
    out.print(parts[1]);
%>
<script type="text/javascript">
    $(document).ready(function () {
        $("#titleModal").html("Crear Subobjetivo");
        $.post('subobjetivo_crear.jsp',
                {objetivo_id: <%=parts[1]%>},
                function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                }
        );
    });
</script>
<%
    }
} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=mensaje%>
</div>
<%  }
    }


%>