<%-- 
    Document   : editarDepartamento
    Created on : 22/05/2019, 09:24:45 AM
    Author     : Jhonny
--%>
<%@page import="Entidad.Usuario"%>
<jsp:useBean id="_usuario" class="Controlador.UsuarioController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idEncript = request.getParameter("id");
    int idUsuario =  0;
    Usuario usuario = new Usuario();
    
   String opcion =  "editUser";
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
                            <label>Empleado</label>
                            <input disabled type="text" class="form-control" id="usuario"  name="usuario" value="<%=usuario.getNombre()%>" >                            
                        </div>  
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" class="form-control" id="usuario"  name="usuario" value="<%=usuario.getUsuario()%>" >                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(usuario.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                        <div class="form-group">
                            <label>Perfil</label>
                            <input type="text" class="form-control" id="perfil"  name="perfil" value="<%=usuario.getPerfil()%>" >                            
                        </div> 
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="<%=usuario.getEmail()%>">
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
                idEmpleado: {
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Seleccione a un personal. '
                        }
                    }
                },
                usuario: {
                    message: 'Nombre Usuario no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Es requerido el Nombre de Usuario. '
                        }
                    }
                },
                perfil: {
                    message: 'Perfil no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Es requerido el Perfil. '
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Email es requerido'
                        },
                        emailAddress: {
                            message: 'El valor no es una dirección de emailválida'
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
