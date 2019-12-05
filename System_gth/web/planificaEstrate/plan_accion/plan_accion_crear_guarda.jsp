<%@page import="Entidad.Plan_accion"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="guardaPlan" class="Controlador.Plan_accionController" />
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
    String subobjetivo_id = request.getParameter("subob_id");
    String plan_accion_id = request.getParameter("Plan_accion_id");
    String plan_estado = request.getParameter("Plan_estado");
    String plan_titulo = request.getParameter("planac_nombre");
    String plan_contex = request.getParameter("planac_contexto");

    Plan_accion plan = new Plan_accion();
    plan.setPlan_accion_id(Integer.parseInt(plan_accion_id));
    plan.setNombre(plan_titulo);
    plan.setContexto(plan_contex);
    plan.setEmpleado_id(DatoUsuario.getEmpleado_id());
    plan.setEstado(Integer.parseInt(plan_estado));
    plan.setPlan_subobjetivo_id(Integer.parseInt(subobjetivo_id));

    String mensaje = guardaPlan.SaveOrUpdatePlan_accion(plan);
    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
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
<%
} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=mensaje%>
</div>
<%  }
    }%>