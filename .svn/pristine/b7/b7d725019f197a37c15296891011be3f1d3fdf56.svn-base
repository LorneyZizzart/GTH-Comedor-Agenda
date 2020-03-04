<%@page import="Entidad.Plan_subobjetivo"%>
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="crearPlanSubObjetivos" class="Controlador.Plan_subobjetivoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String objetivo_id = request.getParameter("objetivo_id");
    String titulo_form = request.getParameter("titulo");
    String id = "";
    Plan_subobjetivo sub = new Plan_subobjetivo();
    sub = null;

    try {
        id = request.getParameter("id").replace(" ", "+");
        id = _encript.ValorADesencriptar(id);
        sub = crearPlanSubObjetivos.GetSubobjetivobyId(Integer.parseInt(id));
        objetivo_id = Integer.toString(sub.getPlan_objetivo_id());

    } catch (Exception e) {
        id = "0";
    }

    //out.print(id);
%>
<div class="box-header">
    <h3 class="box-title"><%=titulo_form%></h3>    
</div>
<form class="form-horizontal form_subobjetivo_nuevo" id="form_subobjetivo_nuevo" method="post">
    <input type="hidden" class="form-control" id="objetivo_id" name="objetivo_id" value="<%=objetivo_id%>">
    <input type="hidden" class="form-control" id="subobjetivo_id" name="subobjetivo_id" value="<%=id%>">
    <input type="hidden" class="form-control" id="subobjetivo_estado" name="subobjetivo_estado" value="1">
    <div class="box-body">
        <!--<div class="form-group">
            <label class="col-sm-2 control-label">Título</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sub_titulo" name="sub_titulo" placeholder="Título" value="<%if(sub!=null){out.print(sub.getTitulo());}%>">
            </div>
        </div>-->
        <div class="form-group">
            <label class="col-sm-2 control-label">Título</label>
            <div class="col-sm-10">                
                <input type="text" class="form-control" id="sub_titulo" name="sub_titulo" placeholder="Título" value="<%if(sub!=null){out.print(sub.getTitulo());}%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Descripción</label>
            <div class="col-sm-10">                
                <textarea class="sub_descri form-control" id="sub_descri" name="sub_descri" placeholder="Escriba la descripción"><%if(sub!=null){out.print(sub.getDescripcion());}%></textarea>
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

<!-- Bootstrap WYSIHTML5 -->
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script>
    $(function () {
        $(".sub_descri").wysihtml5();
    });
    $('.form_subobjetivo_nuevo').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            sub_titulo: {
                message: 'El Título no es valido.',
                validators: {
                    notEmpty: {
                        message: 'El Título no puede ser vacio. '
                    },
                    stringLength: {
                        min: 6,
                        max: 200,
                        message: 'El Nombre tiene que ser mas de 6 y menos de 200 caracteres'
                    }
                }
            },
            sub_descri: {
                message: 'El valor no es valido.',
                validators: {
                    notEmpty: {
                        message: 'La Descripción no puede ser vacio. '
                    }
                }
            }
        }
    }).on('success.form.bv', function (e) {
        // Prevent submit form
        e.preventDefault();
        $("#mensaje").show();
        $("#mensaje").addClass("loader");


        var $form = $(e.target),
                validator = $form.data('bootstrapValidator');
        $.ajax({
            type: "POST",
            url: "subobjetivo_crear_guarda.jsp",
            contentType: "application/x-www-form-urlencoded;charset=ISO-8859-15",
            data: $(".form_subobjetivo_nuevo").serialize(),
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