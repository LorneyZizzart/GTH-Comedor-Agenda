<%@page import="Entidad.Plan_matriz"%>
<!-- bootstrap wysihtml5 - text editor -->

<link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="matriz_ver" class="Controlador.Plan_matrizController" />
<%
    String plan_accion_id = request.getParameter("id_pla_ac").replace(" ", "+");
    plan_accion_id = _encript.ValorADesencriptar(plan_accion_id);
    String Plan_matriz_id = "0";

    Plan_matriz matriz = new Plan_matriz();
    matriz = matriz_ver.getMatrizByPlanAccionId(Integer.parseInt(plan_accion_id));
    if (matriz != null) {
        Plan_matriz_id = Integer.toString(matriz.getPlan_matriz_id());
    }
%>
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Plan de Acción Matriz</h3>

                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form_plan_accion_nuevo" id="form_plan_accion_nuevo">
                        <input type="hidden" class="form-control" id="plan_accion_id" name="plan_accion_id" value="<%=plan_accion_id%>">
                        <input type="hidden" class="form-control" id="plan_accion_estado" name="plan_accion_estado" value="1">
                        <input type="hidden" class="form-control" id="Plan_matriz_id" name="Plan_matriz_id" value="<%=Plan_matriz_id%>">

                        <div class="box-group" id="accordion">
                            <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                            <div class="panel box box-primary">
                                <div class="box-header with-border">
                                    <h4 class="box-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#quehacer">
                                            Que hacer 
                                        </a>
                                    </h4>
                                </div>
                                <div id="quehacer" class="panel-collapse collapse in">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Que Hacer : </label>                    
                                            <textarea style="width: 100%" class="matriz_quehacer_ form-control" id="mat_quehacer" name="mat_quehacer" placeholder="Que hacer"><%if (matriz != null) {
                                                    out.print(matriz.getQue_hacer());
                                                }%></textarea>
                                        </div><br><br>
                                        <div class="form-group">
                                            <label>Responsable:</label>
                                            <input type="text" class="form-control" name="mat_responsable" id="mat_responsable" placeholder="Responsable" value="<%if (matriz != null) {
                                                    out.print(matriz.getResponsable());
                                                }%>">
                                        </div>
                                        <div class="box-footer">                                            
                                            <button type="button" class="btn btn-purple pull-right btn-guarda-qhacer">Guardar área</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel box box-primary">
                                <div class="box-header with-border">
                                    <h4 class="box-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#comohacer">
                                            Como hacer
                                        </a>
                                    </h4>
                                </div>
                                <div id="comohacer" class="panel-collapse collapse">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Como:</label>
                                            <textarea class="matriz_como_ form-control" id="mat_como" name="mat_como" placeholder="Como"><%if (matriz != null) {
                                                    out.print(matriz.getComo());
                                                }%></textarea>                    
                                        </div>
                                        <div class="form-group">
                                            <label>Documento generado:</label>
                                            <input type="text" class="form-control" name="mat_documento" id="mat_documento" placeholder="Documento generado" value="<%if (matriz != null) {
                                                    out.print(matriz.getDocumento_generadi());
                                                }%>">
                                        </div>   
                                    </div>
                                </div>
                            </div>
                            <div class="panel box box-primary">
                                <div class="box-header with-border">
                                    <h4 class="box-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#indicadorresultado">
                                            Indicadores de Resultado
                                        </a>
                                    </h4>
                                </div>
                                <div id="indicadorresultado" class="panel-collapse collapse">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Nombre:</label>
                                            <input type="text" class="form-control" name="mat_indicador_nombre" id="mat_indicador_nombre" placeholder="Nombre" value="<%if (matriz != null) {
                                                    out.print(matriz.getIndicadores_resultado());
                                                }%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Fecha:</label>
                                            <input type="text" class="form-control" name="mat_fecha" id="mat_fecha" placeholder="Fecha" value="<%if (matriz != null) {
                                                    out.print(matriz.getFecha());
                                                }%>"></div>
                                        <div class="form-group">
                                            <label>Indicador:</label>
                                            <input type="text" class="form-control" name="mat_indicador" id="mat_indicador" placeholder="Indicador" value="<%if (matriz != null) {
                                                    out.print(matriz.getIndicador());
                                                }%>">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </di

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-purple pull-right">Guardar</button>
                            </div>
                            <div class="mensaje"></div>
                    </form>
                </div>
                <!-- /.box -->
            </div>
        </div>
        <!-- /.row -->
    </div>
</section>

<!-- Bootstrap WYSIHTML5 -->
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script>
    $(document).ready(function () {
        $(function () {
            $(".matriz_como_").wysihtml5();
            $(".matriz_quehacer_").wysihtml5();
        });

        $('.form_plan_accion_nuevo').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                quehacer: {
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
                mat_indicador_nombre: {
                    message: 'Nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Nombre no puede ser vacio. '
                        }
                    }
                }
                ,
                mat_fecha: {
                    message: 'Fecha no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Fecha no puede ser vacio. '
                        },
                        date: {
                            format: 'DD/MM/YYYY',
                            message: 'Fecha Invalida DD/MM/YYYY'
                        }
                    }
                },
                mat_indicador: {
                    message: 'Indicador no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Indicador no puede ser vacio. '
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
                url: "../plan_accion/matriz_nuevo_guardar.jsp",
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
        $(".btn-guarda-qhacer").click(function () {
            var 
        });
    });
</script>
