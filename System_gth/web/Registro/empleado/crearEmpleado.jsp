<%@page import="Entidad.Cargo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Nivel"%> 
<%@page import="Entidad.Departamento"%>
<%@page import="Entidad.Estado_civil"%>
<%@page import="Entidad.Pais"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_estadoCivil" class="Controlador.Estado_civilController" />
<jsp:useBean id="_pais" class="Controlador.PaisController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<% int idEmpleado = 0; 
    
    List<Nivel> listaNivel = new ArrayList<Nivel>();
    listaNivel = _nivel.getAllNivel();
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Estado_civil > listaEstadoCivil = new ArrayList<Estado_civil>();
    listaEstadoCivil = _estadoCivil.GetAllEstadoCivil();
    
    List<Pais> listaPais = new ArrayList<Pais>();
    listaPais = _pais.GetAllPais();
    
    List<Cargo> cargos = new ArrayList<Cargo>();
    cargos = _cargo.getAllCargoByCargoId();
%>
<form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=idEmpleado%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="">                            
                        </div>  
                        <div class="form-group">
                            <label>Apellido paterno</label>
                            <input type="text" class="form-control" id="apellidoPaterno"  name="apellidoPaterno" value="">                            
                        </div>  
                        <div class="form-group">
                            <label>Apellido materno</label>
                            <input type="text" class="form-control" id="apellidoMaterno"  name="apellidoMaterno" value="">                            
                        </div>  
                        <div class="form-group">
                            <label>Correo electrÛnico</label>
                            <input type="text" class="form-control" id="email"  name="email" value="">                            
                        </div>  
                        <div class="form-group">
                            <label>TelÈfono</label>
                            <input type="text" class="form-control" id="telefono"  name="telefono" value="">                            
                        </div> 
                        <div class="form-group">
                            <label>Estado</label>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red"></label>
                        </div>
                        <div class="form-group">
                            <label>Estado civil</label>
                            <select name="idEstadoCivil" class="form-control selectEstadoCivil" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opciÛn</option>    
                            <%
                                for (Estado_civil item : listaEstadoCivil) {
                                    %>
                            <option value="<%=item.getEstado_civil_id()%>"><%=item.getNombre()%></option>
                            <% } %>    
                            </select>
                        </div>
                        <div class="form-group">
                            <label>PaÌs</label>
                            <select name="idPais" class="form-control selectPais" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opciÛn</option>  
                                <%
                                for (Pais item : listaPais) {
                                    %>
                            <option value="<%=item.getPais_id()%>"><%=item.getPaisNombre()%></option>
                            <% } %> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Grupo</label>
                            <select name="idNivel" class="form-control selectNivel" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opciÛn</option>
                                <%
                                for (Nivel item : listaNivel) {
                                    if(item.getEstado() == 1){
                                    %>
                            <option value="<%=item.getNivel_id()%>"><%=_character.CharacterUCFirst(item.getNombre())%></option>
                            <% }} %> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Departamento</label>
                            <select name="idDepartamento" class="form-control selectDepartamento" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opciÛn</option>
                                <%
                                for (Departamento item : listaDepartamento) {
                                    if(item.getEstado() == 1){
                                    %>
                            <option value="<%=item.getDepartamento_id()%>"><%=_character.CharacterUCFirst(item.getNombre())%></option>
                            <% }} %>  
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Cargo:</label>
                            <select name="idCargo" class="form-control selectCargo" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opciÛn</option>
                                <%
                                for (Cargo item : cargos) {
                                    if(item.getEstado() == 1){
                                    %>
                            <option value="<%=item.getCargo_id()%>"><%=_character.CharacterUCFirst(item.getNombre())%></option>
                            <% } } %>  
                            </select>
                        </div>
                    </div>
                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
    
  <script type="text/javascript">
    $(function () {
        $('.selectEstadoCivil').select2();
        $('.selectPais').select2();
        $('.selectNivel').select2();
        $('.selectDepartamento').select2();
        $('.selectCargo').select2();
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
                            regexp: /^([-a-z0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n˙meros y guiones bajos.'
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
                            regexp: /^([_A-Z.,¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸\s])+$/i,
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
                            regexp: /^([_A-Z.,¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸\s])+$/i,
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
                            message: 'El valor no es una direcciÛn de emailv·lida'
                        }
                    }
                },
                telefono:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El telÈfono no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 15,
                            message: 'El telÈfono tiene que ser un n˙mero v·lido '
                        },
                        regexp: {
                            regexp: /^([-0-9\s])+$/i,
                            message: 'El telÈfono solo puede tener caracteres n˙mericos.'
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
                            message: 'Debe seleccionar un paÌs. '
                        }
                    }
                },
                idNivel: {
                    message: 'El grupo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un grupo de trabajo. '
                        }
                    }
                },
                idDepartamento: {
                    message: 'El departamento no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un departamento de trabajo. '
                        }
                    }
                },
                idCargo: {
                    message: 'El cargo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un cargo de trabajo. '
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