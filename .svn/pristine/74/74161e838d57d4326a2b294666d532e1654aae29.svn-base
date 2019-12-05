<%@page import="Entidad.Feedback"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_feedback_ver" class="Controlador.FeedbackController" />
<jsp:useBean id="_encripta" class="Controlador.EncriptionController" />
<%
    List<Feedback> notas = new ArrayList<Feedback>();
//    notas = _feedback_ver.Get_all_feedback_empleado(idEmpleado);
%>
<div class="box-header">
    <h3 class="box-title">Lista de Retroalimentación</h3>
    <!--<button id="retro_crear_new" type="button" class="btn-purple btn-right_nivel retro_crear_new" data-toggle="modal" data-target="#modal-default" data-placement="bottom" title="" data-original-title="Añadir nivel">
        <i class="fa fa-plus"></i>
    </button>-->
</div>
<table class="table table-hover">
    <thead>
        <tr>
            <th>#</th><th>Título</th><th>Tipo</th><th>Fecha</th><th></th><th></th>
        </tr>
    </thead>
    <tbody>
        <%
            int conta = 0;
            for (Feedback nota : notas) {
                conta++;
                String encripta_ = _encripta.ValorAEncriptar(Integer.toString(nota.getFeedback_id()));
        %>
        <tr>
            <td><%=conta%></td>
            <td><%=nota.getMotivo()%></td>
            <td><%=nota.getFeedback_tipo_nombre()%></td>
            <td><%=nota.getFecha_advertencia()%></td>
            <td>
                <div class="btn-group ">
                    <a data-id="<%=nota.getFeedback_id()%>" class="btn btn-xs btn-primary btn_editar_retro" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Editar"><i class="fa fa-edit"></i></a>
                    <a data-id="<%=nota.getFeedback_id()%>" class="btn btn-xs btn-info btn_ver_retroalimen" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Ver"><i class="fa fa-search"></i></a>
                    <a data-id="<%=nota.getFeedback_id()%>" class="btn btn-xs btn-danger btn_delimia_retro" data-toggle="tooltip" data-placement="bottom" title="" data-original-title=Eliminar"> <i class="fa fa-remove"></i></a>
                    <a target="_black" href="retro_alimentacion/Vista_impresion.jsp?sdgsdfdgsdfgsdfg=<%=encripta_%>" class="btn btn-xs btn-warning " data-toggle="tooltip" data-placement="bottom" title="" data-original-title=Imprimir"> <i class="fa fa-print"></i></a>
                </div>
            </td>
        </tr>
        <%
            }
        %>

    </tbody>
</table>


<div class="modal fade" id="retro_registro">
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

<script>
    $(".retro_crear_new").on("click", function (e) {
        $("#titleModal").html("Crear Feedback");
        e.preventDefault();
        e.stopImmediatePropagation();
        $('#retro_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('retro_alimentacion/form_reg_retro.jsp',
                {id: 0},
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

    $(".btn_editar_retro").click(function () {
        var id_retro = $(this).attr('data-id');
        $("#titleModal").html("Editar Feedback");
        $('#retro_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('retro_alimentacion/form_reg_retro.jsp',
                {id: id_retro},
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

    $(".btn_ver_retroalimen").click(function () {
        var id_retro = $(this).attr('data-id');
        $("#titleModal").html("Ver Feedback");
        $('#retro_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('retro_alimentacion/ver_retroalimetacion.jsp',
                {id: id_retro},
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


    $(".btn_delimia_retro").click(function () {
        var id_retro = $(this).attr('data-id');
        $("#titleModal").html("Eliminar Feedback");
        $('#retro_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('retro_alimentacion/elimar_retroalimetacion.jsp',
                {id: id_retro},
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
    $(".btn_imprimir_retro").click(function () {
        var id_retro = $(this).attr('data-id');
        $("#titleModal").html("Imprimir Feedback");
        $('#retro_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('retro_alimentacion/Vista_impresion.jsp',
                {id: id_retro},
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
</script>