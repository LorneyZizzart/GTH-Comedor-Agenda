<%-- 
    Document   : editPassword
    Created on : 28/05/2019, 09:12:57 AM
    Author     : pc
--%>
<%@page import="Entidad.Usuario"%>
<jsp:useBean id="_usuario" class="Controlador.UsuarioController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%  String idEncript = request.getParameter("id");
    int idUsuario = 0;
    Usuario usuario = new Usuario();   
    String opcion =  "editPassword";
    try {
        idUsuario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        usuario = _usuario.GetDatosParaActualizarByUser_id(idUsuario);
    }catch (Exception e) {
        idUsuario = 0;
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=usuario.getUser_id()%>" name="id" id="id">
             <input type="hidden" value="<%=opcion%>" name="editOpcion" id="editOpcion">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" class="form-control"  id="contrasena" name="contrasena" placeholder="Contraseña">
                        </div>
                        <div class="form-group">
                            <label>Confimar contraseña</label>
                            <input type="password" class="form-control"  id="confirmPassword" name="confirmPassword" placeholder="Contraseña">
                        </div> 
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn btn-primary pull-right"><i class="fa fa-refresh"></i> Actualizar</button>
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
                contrasena: {
                    validators: {
                        notEmpty: {
                            message: 'Contraseña requerida'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: 'Confirmación de contraseña requerida'
                        },
                        identical: {
                            field: 'contrasena',
                            message: 'La contraseña y la confirmación no son las mismas.'
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
                url: "usuario_guardar.jsp",
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