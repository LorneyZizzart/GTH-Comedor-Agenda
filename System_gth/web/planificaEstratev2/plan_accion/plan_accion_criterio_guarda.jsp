<%@page import="Entidad.Plan_accion"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="guardaPlan" class="Controlador.Plan_accionController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />

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
    String subobjetivo_id = request.getParameter("Plan_subobjetivo_id");

    String plan_accion_encro = _encript.ValorAEncriptar(Plan_accion_id);

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
            //location.reload();
            $('#crear_planificacion').modal('hide');
            $('body').removeClass('modal-open');//eliminamos la clase del body para poder hacer scroll
            $('.modal-backdrop').remove();//eliminamos el backdrop del modal
            var plan_id = '<%=plan_accion_encro%>';
            var subo_id = '<%=subobjetivo_id%>';
            //alert(plan_id+" - "+subo_id);
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            $.post('../plan_accion/plan_accion_ver.jsp',
                    {id_pla_ac: plan_id,
                        id: subo_id},
                    function (html) {
                        $(".contenedor_planifica").html(html);
                        $(".contenedor_planifica").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".contenedor_planifica").html(alerta);
                $(".contenedor_planifica").removeClass('loader');

            });


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