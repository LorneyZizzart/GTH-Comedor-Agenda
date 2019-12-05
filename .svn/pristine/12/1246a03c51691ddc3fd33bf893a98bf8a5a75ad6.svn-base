<%@page import="Entidad.Evento_Actividad"%>
<jsp:useBean id="traer_Actividad" class="Controlador.Evento_ActividadController" />
<%
    String e_evento_id = request.getParameter("id_evento");
    int e_actividad_id = Integer.parseInt(request.getParameter("id_actividad"));
    Evento_Actividad evento = new Evento_Actividad();
    if (e_actividad_id == 0) {
        evento = null;
    } else {
        evento = traer_Actividad.GetActividadesByActividad_id(e_actividad_id);
    }

%>
<form id="form_actividad_guardar" method="post" class="form_actividad_guardar">   
    <input type="hidden" name="evento_id" id="evento_id" value="<%=e_evento_id%>">
    <input type="hidden" name="actividad_id" id="actividad_id" value="<%=e_actividad_id%>">
    <div class="box-body">

        <div class="form-group" >
            <label>Nombre actividad</label>
            <input type="text" class="form-control" id="actividad_nombre"  name="actividad_nombre" value="<% if (evento != null) {
                    out.print(evento.getNombre_actividad());
                }%>">
        </div>

        <div class="form-group" >
            <div class="row">
                <div class="col-md-6">
                    <label>Fecha inicio</label>
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control" id="actividad_inicio_fecha"  name="actividad_inicio_fecha" value="<% if (evento != null) {
                                out.print(evento.getFecha_inicio_actividad());
                            }%>">                            
                    </div>        
                </div>
                <div class="col-md-6 bootstrap-timepicker">
                    <label>Hora inicio</label>
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-clock-o"></i>
                        </div>
                        <input type="text" class="form-control timepicker" id="actividad_inicio_hora"  name="actividad_inicio_hora" value="<% if (evento != null) {
                                out.print(evento.getHora_inicio_actividad());
                            }%>">                            
                    </div>
                </div>
            </div>            
        </div>

        <div class="form-group" >
            <div class="row">
                <div class="col-md-6">
                    <label>Fecha fin</label>
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control" id="actividad_fin_fecha"  name="actividad_fin_fecha" value="<% if (evento != null) {
                                out.print(evento.getFecha_fin_actividad());
                            }%>">
                    </div>
                </div>
                <div class="col-md-6 bootstrap-timepicker">
                    <label>Hora fin</label>
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-clock-o"></i>
                        </div>
                        <input type="text" class="form-control actividad_fin_hora" id="actividad_fin_hora"  name="actividad_fin_hora" value="<% if (evento != null) {
                                out.print(evento.getHora_fin_actividad());
                            }%>">
                    </div>
                </div>
            </div>

        </div>


        <div class="form-group" >
            <label>Detalle</label>
            <textarea class="form-control" rows="3" id="actividad_detalle"  name="actividad_detalle"><% if (evento != null) {
                    out.print(evento.getDescripcion());
                }%></textarea>            
        </div>        
    </div>
    <!-- /.box-body -->

    <div class="box-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
    </div>
</form>
<div id="mensaje"></div>

<script>
    //Timepicker
    $(".timepicker").timepicker({
        showInputs: false
    });
    $(".actividad_fin_hora").timepicker({
        showInputs: false
    });

    $('#actividad_inicio_fecha').datepicker({
        autoclose: true,
        language: 'es'
    });

    $('#actividad_fin_fecha').datepicker({
        autoclose: true,
        language: 'es'
    });

    $('.form_actividad_guardar').bootstrapValidator({
        message: 'Este valor no es valido',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            actividad_nombre: {
                message: 'El nombre no es valido.',
                validators: {
                    notEmpty: {
                        message: 'El nombre no puede ser vacio. '
                    },
                    stringLength: {
                        min: 6,
                        max: 200,
                        message: 'El Nombre tiene que ser mas de 6 y menos de 200 caracteres'
                    }
                }
            },
            actividad_inicio_fecha: {
                validators: {
                    notEmpty: {
                        message: 'Fecha es requerido. '
                    },
                    date: {
                        format: 'DD/MM/YYYY',
                        message: 'La fecha no es valida.'
                    }
                }
            },
            actividad_inicio_hora: {
                validators: {
                    notEmpty: {
                        message: 'Fecha es requerido. '
                    }
                }
            },
            actividad_fin_fecha: {
                validators: {
                    notEmpty: {
                        message: 'Fecha es requerido. '
                    },
                    date: {
                        format: 'DD/MM/YYYY',
                        message: 'La fecha no es valida.'
                    }
                }
            },
            actividad_fin_hora: {
                validators: {
                    notEmpty: {
                        message: 'Fecha es requerido. '
                    }
                }
            },
            actividad_detalle: {
                message: 'El detalle no es valido.',
                validators: {
                    notEmpty: {
                        message: 'El detalle no puede ser vacio. '
                    },
                    stringLength: {
                        min: 6,
                        max: 500,
                        message: 'El Nombre tiene que ser mas de 6 y menos de 500 caracteres'
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
            url: "actividad_crear_guardar.jsp",
            data: $(".form_actividad_guardar").serialize(),
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