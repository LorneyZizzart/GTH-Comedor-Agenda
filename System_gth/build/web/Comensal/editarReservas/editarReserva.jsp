<%@page import="Entidad.C_Empleado_Reserva"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController"/>
<%
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String idReserva = _encript.ValorADesencriptar(request.getParameter("id"));
    empleadoReserva = _empleadoReserva.getReservaEmpleadoById(Integer.parseInt(idReserva));
%>
<form id="form_guardar" method="post" class="form_guardar">
            <input type="hidden" value="<%=idReserva%>" name="idReserva" id="idReserva">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre completo: </label>
                            <input disabled type="text" class="form-control" value="<%=empleadoReserva.getNombreEmpleado()%>">                            
                        </div>                          
                        <div class="form-group" >
                            <label>Teléfono</label>
                            <input disabled type="text" class="form-control" value="<%=empleadoReserva.getTelefono()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Observación</label>
                            <textarea class="form-control" rows="3" id="observacion"  name="observacion"><%=empleadoReserva.getObservacion()%></textarea>
                        </div>
                        <div class="form-group" >
                            <label>Cantidad</label>
                            <input type="text" class="form-control" id="cantidad"  name="cantidad" value="<%=empleadoReserva.getCantidad()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Descuento adicional <span data-toggle="tooltip" title="El sistema automaticamente expresara en bolivianos." class="badge">!</span></label>
                            <input type="text" class="form-control" id="descuentoAdicional"  name="descuentoAdicional" value="<%=empleadoReserva.getDescuentoAdicional()%>">  
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
        $('.form_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                cantidad:{
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El cantidad no puede ser vacio. '
                        },
                        integer: {
                            message: 'Debe introducir un valor entero.'
                        }
                    }
                },
                descuentoAdicional:{
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El descuento no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: 'El descuento debe ser un valor valido.'
                        },
                        regexp: {
                            regexp: /^([0-9.\s])+$/i,
                            message: 'El descuento solo puede tener caracteres númericos del 0 en adelante.'
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
                url: "guardarActulizacionReserva.jsp",
                data: $(".form_guardar").serialize(),
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