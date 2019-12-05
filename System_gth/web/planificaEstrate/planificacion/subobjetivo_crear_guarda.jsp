<%@page import="Entidad.Plan_subobjetivo"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="guardaPlansubobjetivo" class="Controlador.Plan_subobjetivoController" />
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

    String objetivo_id = request.getParameter("objetivo_id");
    String subobjetivo_id = request.getParameter("subobjetivo_id");
    String subobjetivo_titulo = request.getParameter("sub_titulo");
    String subobjetivo_descripcion = request.getParameter("sub_descri");
    String subobjetivo_estado = request.getParameter("subobjetivo_estado");

    int empleado_id = DatoUsuario.getEmpleado_id();

    Plan_subobjetivo subobjetivo = new Plan_subobjetivo();
    subobjetivo.setPlan_subobjetivo_id(Integer.parseInt(subobjetivo_id));
    subobjetivo.setPlan_objetivo_id(Integer.parseInt(objetivo_id));
    subobjetivo.setTitulo(subobjetivo_titulo);
    subobjetivo.setDescripcion(subobjetivo_descripcion);
    subobjetivo.setEmpleado_id(empleado_id);
    subobjetivo.setEstado(Integer.parseInt(subobjetivo_estado));

    String mensaje = guardaPlansubobjetivo.SaveorUpdateSubobjetivo(subobjetivo);

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