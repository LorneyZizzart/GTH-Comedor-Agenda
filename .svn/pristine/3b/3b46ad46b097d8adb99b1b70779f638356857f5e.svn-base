<%@page import="Entidad.Plan_indica_resultado"%>
<jsp:useBean id="crearindicador" class="Controlador.Plan_indica_resultadoController" />
<%@page import="Entidad.Login_Entidad"%>

<%

    String subob_id = request.getParameter("subob_id");
    String matri_di = request.getParameter("matriz_id");

    String plan_Accion_encri = request.getParameter("encri_plan_Accion");
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

    String indicador_id = request.getParameter("indicador_id");
    String fecha = request.getParameter("indi_fecha");
    String rango = request.getParameter("indi_rango");
    String nombre = request.getParameter("indi_nombre");
    String matriz_id = request.getParameter("matriz_id");

    Plan_indica_resultado indicador = new Plan_indica_resultado();
    indicador.setPlan_indica_resultado_id(Integer.parseInt(indicador_id));
    indicador.setFecha(fecha);
    indicador.setPlan_estado_id(Integer.parseInt(rango));
    indicador.setEmpleado_id(DatoUsuario.getEmpleado_id());
    indicador.setPlan_matriz_id(Integer.parseInt(matriz_id));
    indicador.setNombre(nombre);

    String respuesta = crearindicador.deleteIndicador(indicador_id, Integer.toString(DatoUsuario.getEmpleado_id()));

    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".contenedor_planifica").html('');
        $(".contenedor_planifica").addClass('loader');

        $.post('../plan_accion/plan_accion_ver.jsp',
                {id_pla_ac: '<%=plan_Accion_encri%>',
                    id: '<%=subob_id%>'},
                function (html) {
                    $(".contenedor_planifica").html(html);
                    $(".contenedor_planifica").removeClass('loader');

                    $('#crear_planificacion').modal('hide');
                    $('body').removeClass('modal-open');//eliminamos la clase del body para poder hacer scroll
                    $('.modal-backdrop').remove();//eliminamos el backdrop del modal
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".contenedor_planifica").html(alerta);
            $(".contenedor_planifica").removeClass('loader');

        });



    });
</script>
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=respuesta%>
</div>
<%
        }

    }
%>
