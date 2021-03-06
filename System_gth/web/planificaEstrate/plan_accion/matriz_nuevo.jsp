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
                    <h3 class="box-title">Plan de Acci�n Matriz</h3>

                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form_plan_accion_nuevo" id="form_plan_accion_nuevo">
                        <input type="hidden" class="form-control" id="plan_accion_id" name="plan_accion_id" value="<%=plan_accion_id%>">
                        <input type="hidden" class="form-control" id="plan_accion_estado" name="plan_accion_estado" value="1">
                        <input type="text" class="form-control" id="Plan_matriz_id" name="Plan_matriz_id" value="<%=Plan_matriz_id%>">

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
                                        <div>
                                            <label>Que Hacer : </label>                    
                                            <textarea style="width: 100%" class="matriz_quehacer_ form-control" id="mat_quehacer" name="mat_quehacer" placeholder="Que hacer"><%if (matriz != null) {
                                                    out.print(matriz.getQue_hacer());
                                                }%></textarea>
                                        </div><br>
                                        <div>
                                            <label>Responsable:</label>
                                            <input type="text" class="form-control" name="mat_responsable" id="mat_responsable" placeholder="Responsable" value="<%if (matriz != null) {
                                                    out.print(matriz.getResponsable());
                                                }%>">
                                        </div>
                                        <div class="box-footer">                                            
                                            <button type="button" class="btn btn-purple pull-right btn-guarda-qhacer">Guardar �rea</button>
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
                                        <div class="">
                                            <label>Como:</label>
                                            <textarea class="matriz_como_ form-control" style="width: 100%" id="mat_como" name="mat_como" placeholder="Como"><%if (matriz != null) {
                                                    out.print(matriz.getComo());
                                                }%></textarea>                    
                                        </div>
                                        <br>

                                        <div class="">
                                            <label>Documento generado:</label>
                                            <input type="text" class="form-control" name="mat_documento" id="mat_documento" placeholder="Documento generado" value="<%if (matriz != null) {
                                                    out.print(matriz.getDocumento_generadi());
                                                }%>">
                                        </div>   
                                        <div class="box-footer">                                            
                                            <button type="button" class="btn btn-purple pull-right btn-guarda-comohacer">Guardar Como hacer</button>
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

                                            <button type="button" class="btn btn-purple pull-right btn-guarda-indicador">Guardar Indicador</button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--
                        <div class="box-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-purple pull-right">Guardar</button>                            
                        </div>
                        -->
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

        $(".btn-guarda-qhacer").click(function (e) {
            e.stopImmediatePropagation();
            var que_hacer_ = $('#mat_quehacer').val();
            if (1 > que_hacer_.length) {
                toastr.error("Se requiere campo: Que Hacer");
                return false;
            }
            var que_hacer_res = $('#mat_responsable').val();
            if (1 > que_hacer_res.length) {
                toastr.error("Se requiere Responsable");
                return false;
            }
            var dataString = $('#form_plan_accion_nuevo').serialize();
            //var $form = $(e.target);
            $.ajax({
                type: "POST",
                url: "../plan_accion/matriz_nuevo_guardar.jsp",
                data: dataString,
                success: function (data)
                {
                    $(".mensaje").removeClass("loader");
                    toastr.success(data);

                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(".mensaje").removeClass("loader");
                    var menn = "Se produjo un error " + errorThrown + "  " + textStatus;
                    //$(".mensaje").html(menn);
                    toastr.error(menn);
                }
            });
        });

        $(".btn-guarda-comohacer").click(function (e) {
            e.stopImmediatePropagation();
            var como_hacer_ = $('#mat_como').val();
            if (1 > como_hacer_.length) {
                toastr.error("Se requiere campo: Como Hacer");
                return false;
            }
            var mat_documento = $('#mat_documento').val();
            if (1 > mat_documento.length) {
                toastr.error("Se requiere campo: Documento generado");
                return false;
            }
            var dataString = $('#form_plan_accion_nuevo').serialize();
            //var $form = $(e.target);
            $.ajax({
                type: "POST",
                url: "../plan_accion/matriz_nuevo_guardar.jsp",
                data: dataString,
                success: function (data)
                {
                    $(".mensaje").removeClass("loader");
                    toastr.success(data);

                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(".mensaje").removeClass("loader");
                    var menn = "Se produjo un error " + errorThrown + "  " + textStatus;
                    //$(".mensaje").html(menn);
                    toastr.error(menn);
                }
            });


        });

        $(".btn-guarda-indicador").click(function (e) {
            e.stopImmediatePropagation();
            var como_hacer_ = $('#mat_indicador_nombre').val();
            if (1 > como_hacer_.length) {
                toastr.error("Se requiere campo: Nombre");
                return false;
            }
            var mat_documento = $('#mat_fecha').val();
            if (1 > mat_documento.length) {
                toastr.error("Se requiere campo: Fecha");
                return false;
            }

            var mat_indicador = $('#mat_indicador').val();
            if (1 > mat_documento.length) {
                toastr.error("Se requiere campo: Indicador");
                return false;
            }
            var dataString = $('#form_plan_accion_nuevo').serialize();
            //var $form = $(e.target);
            $.ajax({
                type: "POST",
                url: "../plan_accion/matriz_nuevo_guardar.jsp",
                data: dataString,
                success: function (data)
                {
                    $(".mensaje").removeClass("loader");
                    toastr.success(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(".mensaje").removeClass("loader");
                    var menn = "Se produjo un error " + errorThrown + "  " + textStatus;
                    //$(".mensaje").html(menn);
                    toastr.error(menn);
                }
            });
        });
    });
</script>
