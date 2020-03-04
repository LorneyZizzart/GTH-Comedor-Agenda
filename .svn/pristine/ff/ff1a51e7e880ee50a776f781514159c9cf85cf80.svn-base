<%@page import="Entidad.Plan_matriz"%>
<jsp:useBean id="matriz_ver" class="Controlador.Plan_matrizController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<!-- bootstrap wysihtml5 - text editor -->

<link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<%
    String subob_id = request.getParameter("id");
    String plan_accion_id = request.getParameter("id_pla_ac");
    String plan_accion_id_encrip = request.getParameter("id_pla_ac");
    

    plan_accion_id = _encript.ValorADesencriptar(plan_accion_id);
    String titulo = request.getParameter("titulo");
    //out.print("sub:" + subob_id + " plan:" + plan_accion_id + " titu:" + titulo);
    Plan_matriz matriz = new Plan_matriz();
    String Plan_matriz_id = "0";

    matriz = matriz_ver.getMatrizByPlanAccionId(Integer.parseInt(plan_accion_id));
    if (matriz != null) {
        Plan_matriz_id = Integer.toString(matriz.getPlan_matriz_id());
    }


%>
<div class="container-fluid">
    <div class="row-border">
        <div class="box-header">
            <h3 class="box-title"><%=titulo%></h3>    
        </div>


        <!-- /.box-header -->
        <!-- form start -->
        <form class="form_plan_accion_nuevo form-horizontal" id="form_plan_accion_nuevo">
            <input type="hidden" class="form-control" id="plan_accion_id" name="plan_accion_id" value="<%=plan_accion_id%>">
            <input type="hidden" class="form-control" id="plan_accion_estado" name="plan_accion_estado" value="1">
            <input type="hidden" class="form-control" id="Plan_matriz_id" name="Plan_matriz_id" value="<%=Plan_matriz_id%>">
            <input type="hidden" class="form-control" id="plan_accion_id_encrip" name="plan_accion_id_encrip" value="<%=plan_accion_id_encrip%>">
            <input type="hidden" class="form-control" id="sub_objetivo_id" name="sub_objetivo_id" value="<%=subob_id%>">



            <h4>Que hacer </h4>

            <div class="form-group">
                <label class="col-sm-2 control-label">Que Hacer :</label>
                <div class="col-sm-10">
                    <textarea style="width: 100%" class="matriz_quehacer_ form-control" id="mat_quehacer" name="mat_quehacer" placeholder="Que hacer"><%if (matriz != null) {
                            out.print(matriz.getQue_hacer());
                        }%></textarea>
                </div>
            </div>   

            <div class="form-group">
                <label class="col-sm-2 control-label">Responsable:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="mat_responsable" id="mat_responsable" placeholder="Responsable" value="<%if (matriz != null) {
                            out.print(matriz.getResponsable());
                        }%>">
                </div>
            </div>

            <h4>Como hacer</h4>
            <div class="form-group">
                <label class="col-sm-2 control-label">Como:</label>
                <div class="col-sm-10">
                    <textarea class="matriz_como_ form-control" style="width: 100%" id="mat_como" name="mat_como" placeholder="Como"><%if (matriz != null) {
                            out.print(matriz.getComo());
                        }%></textarea> 
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Documento generado:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="mat_documento" id="mat_documento" placeholder="Documento generado" value="<%if (matriz != null) {
                            out.print(matriz.getDocumento_generadi());
                        }%>">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Presupuesto Bs.:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="mat_presupuesto" id="mat_presupuesto" maxlength="9" placeholder="Documento generado" value="<%if (matriz != null) {
                            out.print(matriz.getPresupuesto());
                        }%>">
                </div>
            </div>

            <div class="box-footer">
                <button type="button" class="btn btn-default pull-left btn_cancel_matriz">Cancelar</button> 
                <button type="submit" class="btn btn-purple pull-right">Guardar</button>                            
            </div>

            <div class="mensaje"></div>
        </form>
    </div></div>

<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script>
    $(document).ready(function () {
        $(function () {
            $(".matriz_como_").wysihtml5();
            $(".matriz_quehacer_").wysihtml5();
        });
        $(".btn_cancel_matriz").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            $.post('../plan_accion/plan_accion_ver.jsp',
                    {id_pla_ac: '<%=plan_accion_id_encrip%>',
                        id: '<%=subob_id%>'},
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

        $("#mat_presupuesto").on("keyup", function () {
            var valid = /^\d{0,6}(\.\d{0,2})?$/.test(this.value),
                    val = this.value;

            if (!valid) {
                console.log("Invalid input!");
                this.value = val.substring(0, val.length - 1);
            }
        });
        $('.form_plan_accion_nuevo').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                mat_quehacer: {
                    message: 'Que hacer no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Que hacer no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 200,
                            message: 'Que hacer tiene que ser mas de 6 y menos de 200 caracteres'
                        }
                    }
                },
                mat_responsable: {
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Responsable no puede ser vacio. '
                        }
                    }
                },
                matriz_como: {
                    message: 'Como no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Como, no puede ser vacio. '
                        }
                    }
                },
                mat_documento: {
                    message: 'Documento generado no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Documento generado no puede ser vacio. '
                        }
                    }
                },
                mat_presupuesto: {
                    message: 'Presupuesto no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Presupuesto no puede ser vacio, o ingrese 0.0'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $(".mensaje").show();
            $(".mensaje").addClass("loader");


            var $form = $(e.target);
            var validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "../matriz/matriz_nuevo_guardar.jsp",
                data: $form.serialize(),
                success: function (data)
                {
                    $(".mensaje").removeClass("loader");
                    $(".mensaje").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(".mensaje").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $(".mensaje").html(menn);
                }
            });
        });
    });
</script>
