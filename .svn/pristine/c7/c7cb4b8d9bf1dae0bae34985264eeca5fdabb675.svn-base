<%@page import="Entidad.Menu"%>
<jsp:useBean id="getunMenu" class="Controlador.MenuController" />
<%
    int idMenu = 0;
    Menu menu = new Menu();
    try {
        idMenu = Integer.parseInt(request.getParameter("id"));
        menu = getunMenu.getMenuById(idMenu);
    } catch (Exception e) {
        idMenu = 0;
    }
%>
                <form id="form_menu_guardar" method="post" class="form_menu_guardar">
                    <input type="hidden" value="<%=idMenu%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="modulo_nombre"  name="modulo_nombre" placeholder="Ingresar Nombre" value="">                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if (menu.getEstado() > 0) {
                                    select = "checked";
                                }%>
                            <label> <input type="checkbox" name="modulo_estado" id="modulo_estado"  class="flat-red" <%=select%>></label>
                        </div>

                        <div class="form-group">
                            <label>PosiciÛn</label>
                            <input type="text" class="form-control" id="modulo_posicion" name="modulo_posicion" placeholder="Ingresar PosiciÛn" value="">
                        </div>

                        <div class="form-group">
                            <label>Õcono</label>
                            <input type="text" class="form-control"  id="modulo_icono" name="modulo_icono" placeholder="Icono" value="">
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

        $('.form_menu_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                modulo_nombre: {
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'El Nombre tiene que ser mas de 3 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n˙meros y guiones bajos.'
                        }
                    }
                },
                modulo_posicion: {
                    messaje: 'Numero Posicion no es valido',
                    validators: {

                        notEmpty: {
                            message: 'Posicion no puede ser vacio. '
                        },
                        integer: {
                            message: 'El valor tiene que ser numero'
                        }
                    }
                },
                modulo_icono: {
                    messaje: 'El Ìcono no es valido',
                    validators: {

                        notEmpty: {
                            message: 'El Ìcono  no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'El Ìcono tiene que ser mas de 3 y menos de 30 caracteres'
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
                url: "Menu_guardar.jsp",
                data: $(".form_menu_guardar").serialize(),
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