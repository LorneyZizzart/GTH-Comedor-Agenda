<%-- 
    Document   : crearCliente
    Created on : 29/05/2019, 09:54:55 AM
    Author     : pc
--%>
<% int id = 0; %>
<form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=id%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" >                            
                        </div>  
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" id="email" name="email" >
                        </div>  
                        <div class="form-group">
                            <label>Tel�fono</label>
                            <input type="text" class="form-control" id="telefono"  name="telefono">                            
                        </div>                      
                        <div class="form-group">
                            <label>Estado</label>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red"></label>
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
                            regexp: /^([-a-z0-9_-��������������������������������-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n�meros y guiones bajos.'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Email es requerido'
                        },
                        emailAddress: {
                            message: 'El valor no es una direcci�n de emailv�lida'
                        }
                    }
                },
                telefono:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El tel�fono no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 15,
                            message: 'El tel�fono tiene que ser un n�mero v�lido '
                        },
                        regexp: {
                            regexp: /^([-0-9_-��������������������������������-\s])+$/i,
                            message: 'El tel�fono solo puede tener caracteres n�mericos.'
                        }
                    }
                },
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
                url: "guardarCliente.jsp",
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