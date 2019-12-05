<%@page import="Entidad.Evento"%>
<jsp:useBean id="editarEvento" class="Controlador.EventoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    Evento e_evento = new Evento();
    int evento_id = 0;

    try {
        String desencriptar = _encript.ValorADesencriptar(request.getParameter("evento_id"));
        evento_id = Integer.parseInt(desencriptar);
        e_evento = editarEvento.GetEventobyId(evento_id);
    } catch (Exception e) {
        System.err.println(" -- - " + e.getMessage());
        evento_id = 0;
        e_evento = null;
    }

    //out.print(evento_id);
%>
<form id="form_evento_guardar" method="post" class="form_evento_guardar">   
    <input type="hidden" value="<%=evento_id%>" name="evento_id" id="evento_id">
    <div class="box-body">

        <div class="form-group" >
            <label>Nombre evento</label>
            <input type="text" class="form-control" id="evento_nombre"  name="evento_nombre" value="<% if (e_evento != null) {
                    out.print(e_evento.getNombre_evento());
                }
                   %>">
        </div>

        <div class="form-group" >
            <label>Fecha inicio</label>
            <div class="input-group date">
                <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                </div>
                <input type="text" class="form-control" id="evento_inicio"  name="evento_inicio" value="<%if (e_evento != null) {
                        out.print(e_evento.getFecha_inicio());
                    }%>">                            
            </div>
        </div>

        <div class="form-group" >
            <label>Fecha fin</label>
            <div class="input-group date">
                <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                </div>
                <input type="text" class="form-control" id="evento_fin"  name="evento_fin" value="<%if (e_evento != null) {
                        out.print(e_evento.getFecha_fin());
                    }%>">
            </div>
        </div>


        <div class="form-group" >
            <label>Detalle</label>
            <textarea class="form-control" rows="3" id="evento_detalle"  name="evento_detalle"><%if (e_evento != null) {
                    out.print(e_evento.getDetalle());
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

<script type="text/javascript">
    $(document).ready(function () {
        $('#evento_inicio').datepicker({
            autoclose: true,
            language: 'es'
        });
        $('#evento_fin').datepicker({
            autoclose: true,
            language: 'es'
        });

        $('.form_evento_guardar').bootstrapValidator({
            message: 'Este valor no es valido',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                evento_nombre: {
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
                evento_inicio: {
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
                evento_fin: {
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
                evento_detalle: {
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
                url: "guardar_evento.jsp",
                data: $(".form_evento_guardar").serialize(),
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
    });
</script>