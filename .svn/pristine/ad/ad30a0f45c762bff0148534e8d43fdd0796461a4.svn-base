<%-- 
    Document   : crearArea
    Created on : 21/05/2019, 11:50:01 PM
    Author     : pc
--%>
<% int idNivel = 0; %>
         <form id="form_area_guardar" method="post" class="form_area_guardar">
             <input type="hidden" value="<%=idNivel%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="area_nombre"  name="area_nombre">                            
                        </div>  
                        <div class="form-group">
                            <label>Posición</label>
                            <input type="text" class="form-control" id="posicion"  name="posicion">                            
                        </div> 
                        <div class="form-group">
                            <label>Estado</label>
                            <label> <input type="checkbox" name="area_estado" id="area_estado"  class="flat-red"></label>
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
                area_nombre:{
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
                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'
                        }
                    }
                },
                posicion:{
                    message: 'El valor no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La posición no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: 'La posición tiene que ser un número válido '
                        },
                        regexp: {
                            regexp: /^([1-9\s])+$/i,
                            message: 'La posición solo puede tener caracteres númericos del 0 en adelante.'
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
                url: "guardarArea.jsp",
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