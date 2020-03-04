<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="crearPlanObjetivos" class="Controlador.Plan_objetivoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String id = "";
    Plan_objetivo planob = new Plan_objetivo();
    planob = null;
    String titulo= request.getParameter("titulo");

    try {
        id = request.getParameter("id").replace(" ", "+");
        id = _encript.ValorADesencriptar(id);
        planob = crearPlanObjetivos.GetplanObjetivobyId(Integer.parseInt(id));

    } catch (Exception e) {
        id = "0";
    }

    // out.print(id);
%>
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.css">

<div class="box-header">
    <h3 class="box-title"><%=titulo%></h3>    
</div>
<form class="form-horizontal form_plan_nuevo" id="form_plan_nuevo" method="post">
    <input type="hidden" class="form-control" id="plan_id" name="plan_id" value="<%=id%>">
    <input type="hidden" class="form-control" id="plan_estado" name="plan_estado" value="1">
    <div class="box-body">
        <div class="form-group">
            <label class="col-sm-2 control-label">Título</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="plan_titulo" name="plan_titulo" placeholder="Título" value="<%if (planob != null) {
                        out.print(planob.getTitulo());
                    }%>">
            </div>
        </div>        

        <div class="form-group">
            <label class="col-sm-2 control-label">Descripción</label>
            <div class="col-sm-10">
                
                <textarea class="plan_creditacion form-control" id="plan_creditacion" name="plan_creditacion" placeholder="Escriba la descripción"><%if(planob!=null){out.print(planob.getCreditacion());}%></textarea>
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
<div id="mensaje_objetivo"></div>
<script>
    $(function () {
        $(".plan_creditacion").wysihtml5();
    });
    $('#plan_gestion').datepicker({
        autoclose: true,
        format: "yyyy",
        viewMode: "years",
        minViewMode: "years"
    });

    $('.form_plan_nuevo').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            plan_titulo: {
                message: 'El Título no es valido.',
                validators: {
                    notEmpty: {
                        message: 'El Título no puede ser vacio. '
                    },
                    stringLength: {
                        min: 6,
                        max: 500,
                        message: 'El Nombre tiene que ser mas de 6 y menos de 500 caracteres'
                    }
                }
            },
            plan_creditacion: {
                message: 'El valor no es valido.',
                validators: {
                    notEmpty: {
                        message: 'La Creditación no puede ser vacio. '
                    }
                }
            }
        }
    }).on('success.form.bv', function (e) {
        // Prevent submit form
        e.preventDefault();
        $("#mensaje_objetivo").show();
        $("#mensaje_objetivo").addClass("loader");


        var $form = $(e.target),
                validator = $form.data('bootstrapValidator');
        $.ajax({
            type: "POST",
            url: "objetivo_crear_guarda.jsp",
            data: $(".form_plan_nuevo").serialize(),
            success: function (data)
            {
                $("#mensaje_objetivo").removeClass("loader");
                $("#mensaje_objetivo").html(data);
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#mensaje_objetivo").removeClass("loader");
                var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                $("#mensaje_objetivo").html(menn);
            }
        });
    });
</script>

<!-- Bootstrap WYSIHTML5 -->
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.js"></script>
