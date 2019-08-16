<%-- 
    Document   : crearNivel
    Created on : 21/05/2019, 09:41:04 AM
    Author     : Jhonny
--%>
<%@page import="Entidad.Nivel"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String idEncript = request.getParameter("id");
    int idNivel = 0;
    Nivel nivel = new Nivel();
    
    try {
        idNivel = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        nivel = _nivel.getNivelById(idNivel);
    }catch (Exception e) {
        idNivel = 0;
    }
%>
         <form id="form_nivel_guardar" method="post" class="form_nivel_guardar">
             <input type="hidden" value="<%=idNivel%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nivel_nombre"  name="nivel_nombre" placeholder="Ingresar nombre" value="<%=_character.CharacterUCFirst(nivel.getNombre())%>">                            
                        </div>      
                        <div class="form-group">
                            <label>Posición</label>
                            <input type="text" class="form-control" id="posicion"  name="posicion" placeholder="Ingresar la posición" value="<%=nivel.getPosicion()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(nivel.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="nivel_estado" id="nivel_estado"  class="flat-red" <%=select%>></label>
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
        $('.form_nivel_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nivel_nombre:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 100,
                            message: 'El Nombre tiene que ser mas de 6 y menos de 100 caracteres'
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
                            regexp: /^([-0-9\s])+$/i,
                            message: 'El teléfono solo puede tener caracteres númericos.'
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
                url: "guardarNivel.jsp",
                data: $(".form_nivel_guardar").serialize(),
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

