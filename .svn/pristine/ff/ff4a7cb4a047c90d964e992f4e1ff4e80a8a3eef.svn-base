<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%  String idEncript = request.getParameter("id");
    int idUsuario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
%>

         <form id="form_area_guardar" method="post" class="form_area_guardar">
             <input type="hidden" value="0" name="id" id="id">
             <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
                    <div class="box-body">
                        
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre">                            
                        </div>  
                        
                        <div class="form-group" >
                            <label>Descuento de desayuno</label>
                            <input type="text" class="form-control" id="descuentoDesayuno"  name="descuentoDesayuno">                            
                        </div>
                        <div class="form-group" >
                            <label>Descuento de almuerzo</label>
                            <input type="text" class="form-control" id="descuentoAlmuerzo"  name="descuentoAlmuerzo">                            
                        </div>
                        <div class="form-group" >
                            <label>Descuento de cena</label>
                            <input type="text" class="form-control" id="descuentoCena"  name="descuentoCena">                            
                        </div>
                        <div class="form-group" >
                            <label>Días anticipacion</label>
                            <input type="text" class="form-control" id="diasAnticipacion"  name="diasAnticipacion">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <label> <input type="checkbox" name="tipo_comensal_estado" id="tipo_comensal_estado"  class="flat-red"></label>
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
        $('.form_area_guardar').bootstrapValidator({
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
                            min: 6,
                            max: 30,
                            message: 'El Nombre tiene que ser mas de 6 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'
                        }
                    }
                },
                descuentoDesayuno: {
                    message: 'El valor no es valido.',
                    validators: 
                    {
                        notEmpty: 
                        {
                            message: 'El descuento no puede ser vacio. '
                        },
                        stringLength: 
                        {
                            min: 1,
                            max: 5,
                            message: 'Solo puede tener 2 caracteres.'
                        },
                        regexp: {
                            regexp: /^([0-9.ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü\s])+$/i,
                            message: 'El descuento solo números y un solo punto.'
                        }
                    }
                },
                descuentoAlmuerzo: {
                    message: 'El valor no es valido.',
                    validators: 
                    {
                        notEmpty: 
                        {
                            message: 'El descuento no puede ser vacio. '
                        },
                        stringLength: 
                        {
                            min: 1,
                            max: 5,
                            message: 'Solo puede tener 2 caracteres.'
                        },
                        regexp: {
                            regexp: /^([0-9.ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü\s])+$/i,
                            message: 'El descuento solo números y un solo punto.'
                        }
                    }
                },
                descuentoCena: {
                    message: 'El valor no es valido.',
                    validators: 
                    {
                        notEmpty: 
                        {
                            message: 'El descuento no puede ser vacio. '
                        },
                        stringLength: 
                        {
                            min: 1,
                            max: 5,
                            message: 'Solo puede tener 2 caracteres.'
                        },
                        regexp: {
                            regexp: /^([0-9.ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü\s])+$/i,
                            message: 'El descuento solo números y un solo punto.'
                        }
                    }
                },
                diasAnticipacion: {
                    message: 'El valor no es valido.',
                    validators: 
                    {
                        notEmpty: 
                        {
                            message: 'El campo no puede ser vacio. '
                        },
                        stringLength: 
                        {
                            min: 1,
                            max: 2,
                            message: 'Solo puede tener 2 caracteres.'
                        },
                        integer: {
                            message: 'El valor debe ser un número entero.'
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
                url: "guardarComensal.jsp",
                data: $(".form_area_guardar").serialize(),
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
    </body>