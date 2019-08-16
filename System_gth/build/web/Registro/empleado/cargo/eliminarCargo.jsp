<%@page import="Entidad.Cargo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Nivel"%> 
<%@page import="Entidad.Departamento"%>
<%@page import="Entidad.Empleado_cargo"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_cargo" class="Controlador.Empleado_cargoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<jsp:useBean id="_empleadoCargo" class="Controlador.Empleado_cargoController" />
<%  String idEncript = request.getParameter("id");
    int idEmpleadoCargo = Integer.parseInt(_encript.ValorADesencriptar(idEncript));

    List<Nivel> listaNivel = new ArrayList<Nivel>();
    listaNivel = _nivel.getAllNivel();
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Empleado_cargo> cargos = new ArrayList<Empleado_cargo>();
    cargos = _cargo.GetAllEmpleadoCargo();
    
    Empleado_cargo empleadoCargo = new Empleado_cargo();
    empleadoCargo = _empleadoCargo.GetEmpleadoCargoByEnpleadoCargo_id(idEmpleadoCargo);
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=empleadoCargo.getId()%>" name="idCargo" id="idCargo">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre completo</label>
                            <input disabled type="text" class="form-control"  value="<%=_character.CharacterUCFirst(empleadoCargo.getEmpleado_nombre())%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Grupo</label>
                            <select disabled name="idNivel" class="form-control select2" style="width: 100%;">
                            <option><%=_character.CharacterUCFirst(empleadoCargo.getNivel_nombre())%></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Departamento</label>
                            <select disabled name="idDepartamento" class="form-control select2" style="width: 100%;">
                              <option><%=_character.CharacterUCFirst(empleadoCargo.getDepartamento_nombre())%></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Cargo:</label>
                            <select disabled name="idCargo" class="form-control select2" style="width: 100%;">
                               <option><%=_character.CharacterUCFirst(empleadoCargo.getCargo_nombre())%></option>
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
                            <input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>>
                        </div>
                        <div class="form-group">
                            <label>Fecha inicio</label>
                            <input disabled type="text" class="form-control" id="fechaInicio" name="fechaInicio" value="<%=empleadoCargo.getFecha_inicio()%>">   
                        </div> 
                        <div class="form-group date">
                            <label>Fecha final</label>
                            <input disabled type="text" class="form-control" id="fechaFinal" name="fechaFinal" value="<%=empleadoCargo.getFecha_fin()%>"> 
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="button" class="btn btn-danger pull-right btn_eliminar"><i class="fa fa-trash-o"></i> Eliminar</button>
                    </div>
                </form>

<div id="mensaje"></div>
<script type="text/javascript">
    $(document).ready(function () {

        $(".btn_eliminar").click(function () {
            var id_menu = $("#idCargo").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('cargo/eliminar_eliminarCargo.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });
</script>