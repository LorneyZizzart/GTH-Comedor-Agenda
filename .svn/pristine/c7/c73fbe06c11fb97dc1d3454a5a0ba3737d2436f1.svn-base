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
    String Plan_accion_id = request.getParameter("Plan_accion_id");
    String criterio_nombre = request.getParameter("criterio_nombre");

    Plan_accion p = new Plan_accion();
    p.setCriterio(criterio_nombre);
    p.setPlan_accion_id(Integer.parseInt(Plan_accion_id));

    String mensaje = guardaPlan.UpdatePlanAccionCriterio(p);
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