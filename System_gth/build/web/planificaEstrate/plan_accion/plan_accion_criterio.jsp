<%@page import="Entidad.Plan_accion"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="verPlan" class="Controlador.Plan_accionController" />
<%
    String subob_id = request.getParameter("id");
    String Plan_accion_id = "";
    Plan_accion plan = new Plan_accion();
    try {
        Plan_accion_id = request.getParameter("id_pla_ac").replace(" ", "+");
        Plan_accion_id = _encript.ValorADesencriptar(Plan_accion_id);
        plan = verPlan.GetPlan_AccionByPlanAccion_id(Integer.parseInt(Plan_accion_id));

    } catch (Exception e) {
        Plan_accion_id = "0";
        plan = null;
    }
%>
<form class="form-horizontal form_plan_nuevo" id="form_plan_nuevo" method="post">

    <input type="hidden" class="form-control" id="Plan_accion_id" name="Plan_accion_id" value="<%=Plan_accion_id%>">

    <div class="box-body">
        <div class="form-group">
            <label class="col-sm-2 control-label">Nombre Criterio</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="criterio_nombre" name="criterio_nombre" placeholder="Nombre" value="<%if (plan.getCriterio() != null) {
                        out.print(plan.getCriterio());
                    }%>">
            </div>
        </div>            

    </div>
    <!-- /.box-body -->
    <div class="box-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-purple pull-right">Guardar</button>
    </div>

    <!-- /.box-footer -->
</form>
<div id="mensaje"></div>
<script>
    $('.form_plan_nuevo').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            criterio_nombre: {
                message: 'Nombre Criterio no es valido.',
                validators: {
                    notEmpty: {
                        message: 'Nombre Criterio no puede ser vacio. '
                    },
                    stringLength: {
                        min: 1,
                        max: 200,
                        message: 'Nombre Criterio tiene que ser mas de 1 y menos de 50 caracteres'
                    }
                }
            }
        }
    }).on('success.form.bv', function (e) {
        // Prevent submit form
        e.preventDefault();
        $("#mensaje").show();
        $("#mensaje").addClass("loader");


        var $form = $(e.target);
        var validator = $form.data('bootstrapValidator');
        $.ajax({
            type: "POST",
            url: "../plan_accion/plan_accion_criterio_guarda.jsp",
            data: $form.serialize(),
            success: function (data)
            {
                $("#mensaje").removeClass("loader");
                $("#mensaje").html(data);
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#mensaje").removeClass("loader");
                var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                $("#mensaje").html(menn);
            }
        });
    });
</script>