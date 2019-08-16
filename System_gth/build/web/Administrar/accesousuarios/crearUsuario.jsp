<%@page import="java.util.*"%>
<%@page import="Entidad.Empleado"%>
<%@page import="Entidad.Usuario"%>
<jsp:useBean id="empleadosConsulta" class="Controlador.EmpleadoController" />
<%
    String opcion = "registerUser";
    List<Empleado> empleados = new ArrayList<Empleado>();
    empleados = empleadosConsulta.GetAllEmpleadoNotUser();
%>
<form id="form_usuario_guardar" method="post" class="form_usuario_guardar">
    <input type="hidden" value="<%=opcion%>" name="editOpcion" id="editOpcion">
    <div class="box-body">
        <input type="hidden" name="id" id="id" value="0">
        <div class="form-group">
            <label>Personal</label>
            <select class="form-control select2 idEmpleado" name='idEmpleado' id='idEmpleado' style="width: 100%;">
                <option value="">- Seleccionar -</option>
                <% for (Empleado e : empleados) {
                %>
                <option value="<%=e.getEmpleado_id()%>"><%=e.getNombre()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <label>Nombre Usuario</label>
            <input type="text" class="form-control" id="usuario"  name="usuario" placeholder="Ingresar Nombre" >                            
        </div>                        
        <div class="form-group">
            <label>Estado</label>
            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" ></label>
        </div>
        <div class="form-group">
            <label>Perfil</label>
            <input type="text" class="form-control" id="perfil"  name="perfil" placeholder="Ingresar perfil" >                            
        </div> 
        <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Correo electrónico">
        </div>

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
        <button type="submit" class="btn btn-primary pull-right"><i class="fa fa-save"></i> Guardar</button>
    </div>
</form>
<div id="mensaje"></div>


<script>
    $(function () {
        $('.select2').select2()
    });
</script>

<script type="text/javascript">
    $(document).ready(function () {

        $(".idEmpleado").change(function () {
            $("#mensaje").addClass("loader");
            alert("Handler for .change() called." + $(this).val());
            $.ajax({
                type: "POST",
                url: "get_maul_user.jsp",
                data: {id_empleado: $(this).val()},
                success: function (data)
                {
                    $("#mensaje").removeClass("loader");
                    $("#email").val(data);
                    
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#mensaje").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#mensaje").html(menn);
                }
            });
        });

        $('.form_usuario_guardar').bootstrapValidator({
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
                },
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
            e.preventDefault();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");

            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "usuario_guardar.jsp",
                data: $(".form_usuario_guardar").serialize(),
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