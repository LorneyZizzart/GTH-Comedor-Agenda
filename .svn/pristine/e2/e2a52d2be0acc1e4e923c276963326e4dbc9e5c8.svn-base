<%-- 
    Document   : editarEmpleado
    Created on : 24/05/2019, 08:45:24 AM
    Author     : pc
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Estado_civil"%>
<%@page import="Entidad.Pais"%>
<%@page import="Entidad.Empleado"%>
<jsp:useBean id="_estadoCivil" class="Controlador.Estado_civilController" />
<jsp:useBean id="_pais" class="Controlador.PaisController" />
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<% int idEmpleado = 0; 
    String idEncript = request.getParameter("id");  
    
    List<Estado_civil > listaEstadoCivil = new ArrayList<Estado_civil>();
    listaEstadoCivil = _estadoCivil.GetAllEstadoCivil();
    
    List<Pais> listaPais = new ArrayList<Pais>();
    listaPais = _pais.GetAllPais();
    
    Empleado empleado = new Empleado();
    
    try {
        idEmpleado = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        empleado = _empleado.GetEmpleadoByID(idEmpleado);
    }catch (Exception e) {
        idEmpleado = 0;
    }    
%>

<form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=empleado.getEmpleado_id()%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" placeholder="Nombres" value="<%=_character.CharacterUCFirst(empleado.getNombre())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Apellido paterno</label>
                            <input type="text" class="form-control" id="apellidoPaterno"  name="apellidoPaterno" placeholder="Apellido paterno" value="<%=_character.CharacterUCFirst(empleado.getApellido_paterno())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Apellido materno</label>
                            <input type="text" class="form-control" id="apellidoMaterno"  name="apellidoMaterno" placeholder="Apellido materno" value="<%=_character.CharacterUCFirst(empleado.getApellido_materno())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Correo electrónico</label>
                            <input type="text" class="form-control" id="email"  name="email" placeholder="Email" value="<%=empleado.getEmail()%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Teléfono</label>
                            <input type="text" class="form-control" id="telefono"  name="telefono" placeholder="Teléfono" value="<%=empleado.getTelefono()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(empleado.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                        <div class="form-group">
                            <label>Estado civil</label>
                            <select name="idEstadoCivil" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>    
                            <%
                                for (Estado_civil item : listaEstadoCivil) {
                                    String Select = "";
                                    if (item.getEstado_civil_id()== empleado.getEstado_civil_id()) {
                                            Select = "Selected";
                                        }
                                    %>
                            <option value="<%=item.getEstado_civil_id()%>" <%=Select%>><%=item.getNombre()%></option>
                            <% } %>    
                            </select>
                        </div>
                        <div class="form-group">
                            <label>País</label>
                            <select name="idPais" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>  
                                <%
                                for (Pais item : listaPais) {
                                String Select = "";
                                    if (item.getPais_id().equalsIgnoreCase(empleado.getPais_id()) ) {
                                            Select = "Selected";
                                        }
                                    %>
                            <option value="<%=item.getPais_id()%>" <%=Select%>><%=item.getPaisNombre()%></option>
                            <% } %> 
                            </select>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn btn-purple pull-right"><i class="fa fa-refresh"></i> Actualizar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
        $(function () {
        $('.select2').select2()
    });
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
                            message: 'El nombre tiene que ser mas de 3 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'
                        }
                    }
                },
                apellidoPaterno:{
                    message: 'El apellido paterno no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El apellido paterno no puede ser vacio. '
                        },
                        regexp: {
                            regexp: /^([_A-Z.,ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü\s])+$/i,
                            message: 'El apellido paterno de usuario solo puede constar de letras, y guiones bajos.'
                        }
                    }
                },
                apellidoMaterno:{
                    message: 'El apellido materno no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El apellido materno no puede ser vacio. '
                        },
                        regexp: {
                            regexp: /^([_A-Z.,ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü\s])+$/i,
                            message: 'El apellido materno de la persona solo puede constar de letras y guiones bajos.'
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
                telefono:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El teléfono no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 15,
                            message: 'El teléfono tiene que ser un número válido '
                        },
                        regexp: {
                            regexp: /^([-0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El teléfono solo puede tener caracteres númericos.'
                        }
                    }
                },
                idEstadoCivil: {
                    message: 'El area no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un estado civil. '
                        }
                    }
                },
                idPais: {
                    message: 'El area no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un país. '
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
                url: "guardarEmpleado.jsp",
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