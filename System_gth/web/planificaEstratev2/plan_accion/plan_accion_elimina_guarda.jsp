<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="verPlan" class="Controlador.Plan_accionController" />

<%
    String id_plan_accion = request.getParameter("id");

    HttpSession sesion = request.getSession();
    //out.print(sesion.getAttribute("USUARIO"));
    if (session.getAttribute("USUARIO") == null) {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Termino su sesi�n, ingrese nuevamente haga clic <a href="../../"> aqu�.</a>
</div>
<%
} else {
    Login_Entidad DatoUsuario = new Login_Entidad();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    int empleado_id = DatoUsuario.getEmpleado_id();
    id_plan_accion = id_plan_accion.replace(" ", "+");
    id_plan_accion = _encript.ValorADesencriptar(id_plan_accion);

    String mensaje = verPlan.eliminaplanAccion(id_plan_accion, Integer.toString(empleado_id));
    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<script type="text/javascript">
    $(document).ready(function () {
        location.reload();
    });
</script>
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=mensaje%>
</div>
<%
        }

    }
%>