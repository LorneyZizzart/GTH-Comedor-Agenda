<%@page import="Entidad.Plan_indica_resultado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Plan_matriz"%>
<%@page import="Entidad.Plan_accion"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="verPlan" class="Controlador.Plan_accionController" />
<jsp:useBean id="matriz_ver" class="Controlador.Plan_matrizController" />
<jsp:useBean id="indicador_ver" class="Controlador.Plan_indica_resultadoController" />

<%
    String subob_id = request.getParameter("id");
    String Plan_accion_id = "";
    Plan_accion plan = new Plan_accion();
    String id = "";
    try {
        Plan_accion_id = request.getParameter("id_pla_ac").replace(" ", "+");
        Plan_accion_id = _encript.ValorADesencriptar(Plan_accion_id);
        plan = verPlan.GetPlan_AccionByPlanAccion_id(Integer.parseInt(Plan_accion_id));
        id = _encript.ValorAEncriptar(Integer.toString(plan.getPlan_accion_id()));

    } catch (Exception e) {
        Plan_accion_id = "0";
        plan = null;
    }
%>
<div class="wrapper" style="padding-left: 50px; padding-right: 30px">
    <!-- Main content -->
    <section class="invoice">
        <!-- title row -->
        <div class="row">
            <div class="col-xs-12">
                <h3 class="page-header">
                    <i class="fa fa-line-chart"></i> Planificación estratégica  <input type="hidden" id="txt_planaccion_id" class="txt_planaccion_id" value="<%=_encript.ValorAEncriptar(Plan_accion_id)%>">
                    <small class="pull-right"><img src="../../dist/img/ico_uab.png" alt="Visa"></small>
                </h3>
            </div>
            <!-- /.col -->
        </div>
        <div class="row text-right">
            <div class="btn-group">
                <button class="btn btn-xs btn-primary btn_planaccion_edita" title="Editar Plan de accion"><i class="fa fa-pencil"></i></button>
                <button class="btn btn-danger btn-xs btn_planaccion_elimina" title="Elimina Plan de accion"><i class="fa fa-trash-o"></i></button>
            </div>
        </div>

        <div class="row">
            <!-- accepted payments column -->
            <div class="col-xs-12">
                <h3>Plan de Acción: <%=plan.getNombre()%></h3>
                <br><%//=plan.getContexto()%>
                
                <b>Criterio: </b><label class="criterio_plan_Accion" data-id="<%=id%>"> <% if (plan.getCriterio() != null) {
                        out.print(plan.getCriterio());
                    } else {
                        out.print("No Tiene");
                    }%></label>

            </div>
        </div>
        <!-- /.row -->

        <div class="row">
            <!-- accepted payments column -->
            <div class="col-md-4">    
                <a class="btn btn-block btn-social btn-instagram btn_ver_adjuntos">
                    <i class="fa fa-paperclip"></i> Ver Archivos adjuntos  
                </a></div>
            <div class="col-md-8"></div>            
        </div>

        <br>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Matriz Documento Historia <div class="btn-right_nivel btn-group">
                        <!--<button class="btn btn-xs btn-info btn_matriz_edita" title="Imprimir"><i class="fa fa-print"></i>-->
                        <button class="btn btn-xs btn-primary btn_matriz_edita" title="Editar Plan de accion"><i class="fa fa-pencil"></i></button>                        
                    </div></h3>
                    <%
                        Plan_matriz matriz = new Plan_matriz();
                        int plan_matriz_id = 0;
                        try {
                            matriz = matriz_ver.getMatrizByPlanAccionId(Integer.parseInt(Plan_accion_id));
                            plan_matriz_id = matriz.getPlan_matriz_id();
                        } catch (Exception e) {
                            matriz = null;
                            plan_matriz_id = 0;
                        }

                    %>
            </div>

            <input type="hidden" id="txt_matriz_id" class="txt_matriz_id" value="<%=plan_matriz_id%>">
            <div class="panel-body">
                <b>Que hacer :</b> <%if (matriz != null) {
                        out.print(matriz.getQue_hacer());
                    }%>

                <b>Responsable :</b><%if (matriz != null) {
                        out.print(matriz.getResponsable());
                    }%>
                <br><br>
                <b>Como: </b> <%if (matriz != null) {
                        out.print(matriz.getComo());
                    }%>

                <b>Documento generado :</b> <%if (matriz != null) {
                        out.print(matriz.getDocumento_generadi());
                    }%>
                <br><br>
                <b>Presupuesto :</b> <%if (matriz != null) {
                        out.print(matriz.getPresupuesto() + "Bs.");
                    }%>


            </div>
        </div>

        <%if (matriz != null) {
        %>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Indicadores de Resultados <div class="btn-right_nivel btn-group">
                        <button class="btn btn-xs btn-primary btn_agrega_indicador" title="Crear Indicador"><i class="fa fa-plus"></i></button>                        
                    </div></h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped">
                    <thead>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Fecha</th>
                    <th>Indicador</th>
                    <th></th>
                    </thead>
                    <tbody>
                        <%
                            int contador = 0;
                            List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
                            indicadores = indicador_ver.GetAllIndicadorByEmepleado(Integer.toString(2), Integer.toString(matriz.getPlan_matriz_id()));
                            for (Plan_indica_resultado i : indicadores) {
                                contador++;
                        %>
                        <tr>
                            <td><%=contador%></td>
                            <td><%=i.getNombre()%></td>
                            <td><%=i.getFecha()%></td>
                            <td><%=i.getEstado_nombre()%></td>
                            <td><div class="btn-right_nivel btn-group">
                                    <button class="btn btn-xs btn-primary btn_indicador_edita" data-id="<%=i.getPlan_indica_resultado_id()%>" title="Editar Indicador"><i class="fa fa-pencil"></i></button>
                                    <button class="btn btn-danger btn-xs btn_indicador_elimina_" data-id="<%=i.getPlan_indica_resultado_id()%>" title="Elimina Indicador"><i class="fa fa-trash-o"></i></button>
                                </div>
                            </td>
                        </tr>
                        <%
                            }
                        %>

                    </tbody>
                </table>
            </div>
        </div>
        <%
            }
        %>




    </section>

    <!-- /.content -->
</div>
<!-- ./wrapper -->

<!-- /.row -->
<div class="modal fade" id="crear_planificacion">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal" class="modal-title">title</h4>
            </div>
            <div class="modal-body cuerpo_registro"></div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<div class="modal modal-danger" id="modal_elimina_planaccion">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal-plna" class="modal-title modal-title-plan">title</h4>
            </div>
            <div class="modal-body">
                ¿Esta seguro de eliminar?
            </div>
        </div>
        <!-- /.modal-content -->
        <div class="modal-footer">
            <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-outline btn_elimina_planaccion">Eliminar</button>
            <div class="mensaje_elimina_subobjetivo"></div>
        </div>

    </div>
    <!-- /.modal-dialog -->
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".criterio_plan_Accion").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Actualiza Criterio");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/plan_accion_criterio.jsp',
                    {
                        id_pla_ac: $(this).attr('data-id')},
                    function (html) {
                        $(".cuerpo_registro").removeClass('loader');
                        $(".cuerpo_registro").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
        });

        $(".btn_planaccion_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var subobjetivo_id = '<%=subob_id%>';
            var plan_accion_id = $('.txt_planaccion_id').val();

            // alert(subobjetivo_id + " -- " + plan_accion_id);

            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            $.post('../plan_accion/plan_accion_crear.jsp',
                    {id_pla_ac: plan_accion_id,
                        id: subobjetivo_id,
                        titulo: 'Edita Plan de Acción'},
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

        $(".btn_planaccion_elimina").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal-plna").html("Elimina Plan de Acción");
            $('#modal_elimina_planaccion').modal('show');
        });

        $(".btn_elimina_planaccion").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var planacionid = $('.txt_planaccion_id').val();
            // alert(planacionid);

            $(".mensaje_elimina_subobjetivo").html('');
            $(".mensaje_elimina_subobjetivo").addClass('loader');
            $.post('../plan_accion/plan_accion_elimina_guarda.jsp',
                    {id: planacionid},
                    function (html) {
                        $(".mensaje_elimina_subobjetivo").html(html);
                        $(".mensaje_elimina_subobjetivo").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".mensaje_elimina_subobjetivo").html(alerta);
                $(".mensaje_elimina_subobjetivo").removeClass('loader');

            });
        });

        $(".btn_ver_adjuntos").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var planacionid = $('.txt_planaccion_id').val();
            // alert(planacionid);

            $("#titleModal").html("Archivos Adjuntos");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');


            $.post('../plan_accion/plan_archivos.jsp',
                    {id_pla_ac: planacionid},
                    function (html) {
                        $(".cuerpo_registro").html(html);
                        $(".cuerpo_registro").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").html(alerta);
                $(".cuerpo_registro").removeClass('loader');

            });

        });

        $(".btn_matriz_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var subobjetivo_id = '<%=subob_id%>';
            var plan_accion_id = $('.txt_planaccion_id').val();

            // alert(subobjetivo_id + " -- " + plan_accion_id);

            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            $.post('../matriz/matriz_crea.jsp',
                    {id_pla_ac: plan_accion_id,
                        id: subobjetivo_id,
                        titulo: 'Edita Matriz'},
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

        $(".btn_agrega_indicador").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var subobjetivo_id = '<%=subob_id%>';
            var plan_accion_id = $('.txt_planaccion_id').val();
            var indicado_id = '0';
            var matriz_id = $('.txt_matriz_id').val();


            $("#titleModal").html("Crear Indicador");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');


            $.post('../matriz/crea_indicador.jsp',
                    {id_pla_ac: plan_accion_id,
                        sub_obje: subobjetivo_id,
                        indicador: indicado_id,
                        matrizid: matriz_id},
                    function (html) {
                        $(".cuerpo_registro").html(html);
                        $(".cuerpo_registro").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").html(alerta);
                $(".cuerpo_registro").removeClass('loader');

            });
        });

        $(".btn_indicador_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var subobjetivo_id = '<%=subob_id%>';
            var plan_accion_id = $('.txt_planaccion_id').val();
            var matriz_id = $('.txt_matriz_id').val();
            var indicador_id = $(this).attr('data-id');

            $("#titleModal").html("Edidar Indicador");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');

            $.post('../matriz/crea_indicador.jsp',
                    {id_pla_ac: plan_accion_id,
                        sub_obje: subobjetivo_id,
                        indicador: indicador_id,
                        matrizid: matriz_id},
                    function (html) {
                        $(".cuerpo_registro").html(html);
                        $(".cuerpo_registro").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").html(alerta);
                $(".cuerpo_registro").removeClass('loader');

            });
        });
        //btn_indicador_elimina
        $(".btn_indicador_elimina_").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var subobjetivo_id = '<%=subob_id%>';
            var plan_accion_id = $('.txt_planaccion_id').val();
            var matriz_id = $('.txt_matriz_id').val();
            var indicador_id = $(this).attr('data-id');

            $("#titleModal").html("Elimina Indicador");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');

            $.post('../matriz/elimina_indicador.jsp',
                    {id_pla_ac: plan_accion_id,
                        sub_obje: subobjetivo_id,
                        indicador: indicador_id,
                        matrizid: matriz_id},
                    function (html) {
                        $(".cuerpo_registro").html(html);
                        $(".cuerpo_registro").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").html(alerta);
                $(".cuerpo_registro").removeClass('loader');

            });
        });

    });
</script>