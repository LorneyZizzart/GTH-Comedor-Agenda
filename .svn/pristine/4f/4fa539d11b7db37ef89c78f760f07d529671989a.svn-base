
<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />


<jsp:useBean id="verPlanObjetivos" class="Controlador.Plan_objetivoController" />
<%
    String objetivo_id = request.getParameter("objetivo_id");
    Plan_objetivo plan_objetivos = new Plan_objetivo();
    plan_objetivos = verPlanObjetivos.GetplanObjetivobyId(Integer.parseInt(objetivo_id));

%>
<div class="wrapper" style="padding-left: 50px; padding-right: 30px">
    <!-- Main content -->
    <section class="invoice">
        <!-- title row -->
        <div class="row">
            <div class="col-xs-12">
                <h3 class="page-header">
                    <i class="fa fa-line-chart"></i> Planificación estratégica  <input type="hidden" id="txt_objetivo_id" class="txt_objetivo_id" value="<%=_encript.ValorAEncriptar(objetivo_id)%>">
                    <small class="pull-right"><img src="../../dist/img/ico_uab.png" alt="Visa"></small>
                </h3>
            </div>
            <!-- /.col -->
        </div>
        <div class="row text-right">
            <div class="btn-group">
                <a class="btn btn-xs btn-info btn_matriz_edita" title="Imprimir" href="print_objetivo.jsp?objetivo_id=<%=_encript.ValorAEncriptar(objetivo_id)%>" target="_blank" ><i class="fa fa-print"></i></a>
                    <button class="btn btn-xs btn-primary btn_objetivo_edita" title="Editar Objetivo"><i class="fa fa-pencil"></i></button>
                    <button class="btn btn-danger btn-xs btn_objetivo_elimina" title="Elimina Objetivo"><i class="fa fa-trash-o"></i></button>
            </div>
        </div>

        <div class="row">
            <!-- accepted payments column -->
            <div class="col-xs-12">
                <h3>Objetivo: <%=plan_objetivos.getTitulo()%></h3>
                <br><%=plan_objetivos.getCreditacion()%>

            </div>

            <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- ./wrapper -->


<div class="modal modal-danger" id="modal_elimina_objetivo">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal" class="modal-title">title</h4>
            </div>
            <div class="modal-body">
                ¿Esta seguro de eliminar el Objetivo?
            </div>
        </div>
        <!-- /.modal-content -->
        <div class="modal-footer">
            <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-outline btn_elimina_objetivo">Eliminar</button>
            <div class="mensaje_elimina_objetivo"></div>
        </div>

    </div>
    <!-- /.modal-dialog -->
</div>

<script type="text/javascript" language="javascript">
    $(document).ready(function () {
        $(".btn_objetivo_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var objetivo_id = $('.txt_objetivo_id').val();
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('objetivo_crear.jsp',
                    {id: objetivo_id, titulo: 'Edita Objetivo'},
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

        $(".btn_objetivo_elimina").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Elimina Objetivo");
            $('#modal_elimina_objetivo').modal('show');
        });

        $(".btn_elimina_objetivo").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var objetivo_id = $('.txt_objetivo_id').val();

            $(".mensaje_elimina_objetivo").html('');
            $(".mensaje_elimina_objetivo").addClass('loader');
            $.post('objetivo_elimina_guarda.jsp',
                    {id: objetivo_id},
                    function (html) {
                        $(".mensaje_elimina_objetivo").html(html);
                        $(".mensaje_elimina_objetivo").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".mensaje_elimina_objetivo").html(alerta);
                $(".mensaje_elimina_objetivo").removeClass('loader');

            });

        });



    });
</script>