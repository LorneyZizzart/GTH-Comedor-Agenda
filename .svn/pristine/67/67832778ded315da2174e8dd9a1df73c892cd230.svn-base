<%@page import="Entidad.Cargo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Nivel"%> 
<%@page import="Entidad.Departamento"%>
<%@page import="Entidad.Empleado_cargo"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_empleadoCargo" class="Controlador.Empleado_cargoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<% String idEncript = request.getParameter("id");
    int idCargo = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
    String opcion = "editar";
    List<Nivel> listaNivel = new ArrayList<Nivel>();
    listaNivel = _nivel.getAllNivel();
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Empleado_cargo> listaEmpleadoCargos = new ArrayList<Empleado_cargo>();
    listaEmpleadoCargos = _empleadoCargo.GetAllEmpleadoCargo();
    
    //Probando
    Empleado_cargo empleadoCargo = new Empleado_cargo();
    empleadoCargo = _empleadoCargo.GetEmpleadoCargoByEnpleadoCargo_id(idCargo);
    
    List<Cargo> cargosLista = new ArrayList<Cargo>();
    cargosLista = _cargo.getAllCargoByCargoId();
    

            %>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=empleadoCargo.getEmpleado_id()%>" name="idEmpleado" id="idEmpleado">
    <input type="hidden" value="<%=opcion%>" name="opcion" id="opcion">
    <input type="hidden" value="<%=idCargo%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre completo</label>
                            <input disabled type="text" class="form-control" placeholder="Nombres" value="<%=empleadoCargo.getEmpleado_nombre()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Grupo</label>
                            <select name="idNivel" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>
                                <%
                                for (Nivel nivel : listaNivel) {
                                    String Select = "";
                                    if (nivel.getNivel_id()== empleadoCargo.getNivel_id()) {
                                            Select = "Selected";
                                        }
                                    %>
                            <option value="<%=nivel.getNivel_id()%>" <%=Select%>><%=_character.CharacterUCFirst(nivel.getNombre())%></option>
                            <% } %> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Departamento</label>
                            <select name="idDepartamento" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>
                                <%
                                for (Departamento departamento : listaDepartamento) {
                                    String Select = "";
                                    if (departamento.getDepartamento_id()== empleadoCargo.getDepartamento_id()) {
                                            Select = "Selected";
                                        }
                                    %>
                            <option value="<%=departamento.getDepartamento_id()%>" <%=Select%>><%=_character.CharacterUCFirst(departamento.getNombre())%></option>
                            <% } %>  
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Cargo:</label>
                            <select name="idCargo" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>
                                <%
                                for (Cargo car : cargosLista) {
                                    String Select = "";
                                    if(car.getCargo_id()== empleadoCargo.getCargo_id()){
                                        Select = "Selected";
                                    }
                                    %>
                            <option value="<%=car.getCargo_id()%>" <%=Select%>><%=_character.CharacterUCFirst(car.getNombre())%></option>
                            <% } %>  
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(empleadoCargo.getActivo()> 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                        <div class="form-group">
                            <label>Fecha inicio</label>
                            <input type="text" class="form-control" id="fechaInicio" name="fechaInicio" value="<%=empleadoCargo.getFecha_inicio()%>">                            
                        </div> 
                        <div class="form-group date">
                            <label>Fecha final</label>
                            <input type="text" class="form-control" id="fechaFinal" name="fechaFinal" value="<%=empleadoCargo.getFecha_fin()%>">                            
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
                idNivel: {
                    message: 'El area no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un nivel. '
                        }
                    }
                },
                idDepartamento: {
                    message: 'El area no es valido.',
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
                url: "cargo/guardarCargo.jsp",
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