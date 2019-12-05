<%@page import="Entidad.Plan_matriz"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="crearPlanMatriz" class="Controlador.Plan_matrizController" />
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

    String plan_accion_id = request.getParameter("plan_accion_id");
    String plan_accion_estado = request.getParameter("plan_accion_estado");
    String mat_quehacer = request.getParameter("mat_quehacer");
    String mat_responsable = request.getParameter("mat_responsable");
    String mat_como = request.getParameter("mat_como");
    String mat_documento = request.getParameter("mat_documento");
    String mat_indicador_nombre = request.getParameter("mat_indicador_nombre");
    String mat_fecha = request.getParameter("mat_fecha");
    String mat_indicador = request.getParameter("mat_indicador");
    String Plan_matriz_id = request.getParameter("Plan_matriz_id");

    Plan_matriz matriz = new Plan_matriz();
    matriz.setPlan_matriz_id(Integer.parseInt(Plan_matriz_id));
    matriz.setQue_hacer(mat_quehacer);
    matriz.setResponsable(mat_responsable);
    matriz.setComo(mat_como);
    matriz.setDocumento_generadi(mat_documento);
    matriz.setIndicadores_resultado(mat_indicador_nombre);
    matriz.setFecha(mat_fecha);
    matriz.setIndicador(mat_indicador);
    matriz.setPlan_accion_id(Integer.parseInt(plan_accion_id));
    matriz.setEmpleado_id(DatoUsuario.getEmpleado_id());
    matriz.setEstado(Integer.parseInt(plan_accion_estado));

    String mensaje = crearPlanMatriz.SaveorUpdateMatriz(matriz);
    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".mensaje").hide(1500, function () {
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