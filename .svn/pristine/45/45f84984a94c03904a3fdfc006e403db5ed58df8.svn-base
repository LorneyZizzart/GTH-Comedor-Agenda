<%@page import="Entidad.Plan_subobjetivo"%>
<jsp:useBean id="verPlanSubObjetivos" class="Controlador.Plan_subobjetivoController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String subobjetivo_id = request.getParameter("subobjetivo_id");
    Plan_subobjetivo sub = new Plan_subobjetivo();
    sub = verPlanSubObjetivos.GetSubobjetivobyId(Integer.parseInt(subobjetivo_id));

%>

<div class="wrapper" style="padding-left: 50px; padding-right: 30px">
    <!-- Main content -->
    <section class="invoice">
        <!-- title row -->
        <div class="row">
            <div class="col-xs-12">
                <h3 class="page-header">
                    <i class="fa fa-line-chart"></i> Planificación estratégica  <input type="hidden" id="txt_subobjetivo_id" class="txt_subobjetivo_id" value="<%=_encript.ValorAEncriptar(subobjetivo_id)%>">
                    <small class="pull-right"><img src="../../dist/img/ico_uab.png" alt="Visa"></small>
                </h3>
            </div>
            <!-- /.col -->
        </div>
        <div class="row text-right">
            <div class="btn-group">
                <button class="btn btn-xs btn-primary btn_subobjetivo_edita" title="Editar Objetivo"><i class="fa fa-pencil"></i></button>
                <button class="btn btn-danger btn-xs btn_subobjetivo_elimina" title="Elimina Objetivo"><i class="fa fa-trash-o"></i></button>
            </div>
        </div>

        <div class="row">
            <!-- accepted payments column -->
            <div class="col-xs-12">
                <h3>Subobjetivo: <%=sub.getTitulo()%></h3>
                <br><%=sub.getDescripcion()%>

            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- ./wrapper -->

<div class="modal modal-danger" id="modal_elimina_subobjetivo">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal" class="modal-title">title</h4>
            </div>
            <div class="modal-body">
                ¿Esta seguro de eliminar?
            </div>
        </div>
        <!-- /.modal-content -->
        <div class="modal-footer">
            <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-outline btn_elimina_subobjetivo">Eliminar</button>
            <div class="mensaje_elimina_subobjetivo"></div>
        </div>

    </div>
    <!-- /.modal-dialog -->
</div>

<script type="text/javascript" language="javascript">
    $(document).ready(function () {
        $(".btn_subobjetivo_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var objetivo_id = $('.txt_subobjetivo_id').val();
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('subobjetivo_crear.jsp',
                    {id: objetivo_id, titulo: 'Edita Subobjetivo'},
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
        
        
        $(".btn_subobjetivo_elimina").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Elimina Subobjetivo");
            $('#modal_elimina_subobjetivo').modal('show');
        });
        
        $(".btn_elimina_subobjetivo").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var subobjetivo_id = $('.txt_subobjetivo_id').val();
            //alert(subobjetivo_id);
            
            $(".mensaje_elimina_subobjetivo").html('');
            $(".mensaje_elimina_subobjetivo").addClass('loader');
            $.post('subobjetivo_elimina_guarda.jsp',
                    {id: subobjetivo_id},
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
        
    });
</script>