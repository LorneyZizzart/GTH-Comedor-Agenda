<%-- 
    Document   : editarArea
    Created on : 22/05/2019, 09:16:13 AM
    Author     : pc
--%>
<%@page import="Entidad.C_TipoComida"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idEncript = request.getParameter("id");
    
    int idTipoComida = 0;
    C_TipoComida tipoComida = new C_TipoComida();
    
    try {
        idTipoComida = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        tipoComida = _tipoComida.getTipoComidaById(idTipoComida);        
    }catch (Exception e) {
        idTipoComida = 0;
    }
%>
         <form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=idTipoComida%>" name="id" id="id">             
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="<%=tipoComida.getNombreComida()%>">                            
                        </div>   
                        <div class="form-group">
                            <label>Costo <span data-toggle="tooltip" title="El sistema automaticamente expresara en bolivianos." class="badge">!</span></label>
                            <input type="text" class="form-control" id="costo"  name="costo" value="<%=tipoComida.getCosto()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Hora de ingreso <span data-toggle="tooltip" title="Horario de ingreso al comedor, debe ser un formato de HH:MM." class="badge">!</span></label>
                            <input type="text" class="form-control" id="hora"  name="hora" value="<%=tipoComida.getHora()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Color del item</label>
                            <input type="text" class="form-control" id="color"  name="color" value="<%=tipoComida.getColor()%>">                           
                        </div>
                        <div class="form-group">
                            <label>Horas de anticipaciÛn <span data-toggle="tooltip" title="Se restara a la hora de ingreso al comedor, debe ser un formato de HH:MM." class="badge">!</span></label>
                            <input type="text" class="form-control" id="horaAnticipacion"  name="horaAnticipacion" value="<%=tipoComida.getHorasAnticipacion()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Detalles</label>
                            <textarea class="form-control" rows="3" id="detalle"  name="detalle"><%=tipoComida.getDetalle()%></textarea>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(tipoComida.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>   
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-refresh"></i> Actualizar</button>
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
                nombre:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'El Nombre tiene que ser mas de 6 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n˙meros y guiones bajos.'
                        }
                    }
                },
                costo:{
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El costo no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: 'El costo debe ser un valor valido.'
                        },
                        regexp: {
                            regexp: /^([0-9.\s])+$/i,
                            message: 'La posiciÛn solo puede tener caracteres n˙mericos del 0 en adelante.'
                        }
                    }
                },
                hora:{
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La hora no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: 'La hora tiene que ser un valor valido.'
                        },
                        regexp: {
                            regexp: /^([0-9:\s])+$/i,
                            message: 'Debe ser en formato de hora 00:00'
                        }
                    }
                },
                horaAnticipacion:{
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La hora de anticipaciÛn no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: 'La hora tiene que ser un valor valido.'
                        },
                        regexp: {
                            regexp: /^([0-9:\s])+$/i,
                            message: 'Debe ser en formato de hora 00:00'
                        }
                    }
                },
                color:{
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El color no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 20,
                            message: 'El color tiene que ser un valor valido.'
                        },
                        regexp: {
                            regexp: /^([0-9a-zA-z#\s])+$/i,
                            message: 'El color tiene que contener valores validos.'
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
                url: "guardarTipoComida.jsp",
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