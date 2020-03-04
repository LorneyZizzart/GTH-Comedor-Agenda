<%@page import="java.util.Calendar"%>
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

    Calendar fecha = Calendar.getInstance();
    int anio = fecha.get(Calendar.YEAR);

    String plan_id = request.getParameter("plan_id");
    String plan_titulo = request.getParameter("plan_titulo");
    String plan_creditacion = request.getParameter("plan_creditacion");
    String plan_gestion = Integer.toString(anio); // request.getParameter("plan_gestion");
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

        out.print(parts[1]);
%>
<script type="text/javascript">
    $(document).ready(function () {
        $.post('objetivo_ver.jsp',
                {objetivo_id: <%=parts[1]%>},
                function (html) {
                    $(".contenedor_planifica").removeClass('loader');
                    $(".contenedor_planifica").html(html);
                }
        );
        $(".menu_objetivo").html('')
        $(".menu_objetivo").addClass('loader')
        $(".menu_objetivo").load("menu.jsp");
        $(".menu_objetivo").removeClass('loader');
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
    }


%>