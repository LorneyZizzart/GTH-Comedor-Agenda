<%@page import="Entidad.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />   
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<%
    String idEncript = request.getParameter("id");    
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    List<Sector_Cuestionario> departamentos = new ArrayList<Sector_Cuestionario>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Cargo> listaCargo = new ArrayList<Cargo>();
    List<Sector_Cuestionario> cargos = new ArrayList<Sector_Cuestionario>();
    listaCargo = _cargo.getAllCargoByCargoId();
    
    int idCuestionario = 0;
    Cuestionario cuestionario = new Cuestionario();
    
    try {
        idCuestionario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cuestionario = _cuestionario.GetCuestionariobyCuestionario_id(idCuestionario);
        departamentos = cuestionario.getSectores().getDepartamentos();
        cargos = cuestionario.getSectores().getCargo();
    }catch (Exception e) {
        idCuestionario = 0;
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idCuestionario%>" name="id" id="id">
                    <div class="box-body">
                         <div class="form-group">
                            <label>Nombre del cuestionario</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" placeholder="Ingresar nombre" value="<%=cuestionario.getNombre()%>">                           
                        </div>   
                        <div class="form-group">
                            <label>Cargo</label>
                            <select disabled name="idCargo" class="form-control select2 selectNivel" multiple="multiple" style="width: 100%;">
                                <option disabled>Selecione una opción</option>
                              <%
                                for (Cargo item : listaCargo) {
                                     String Select = "";
                                for (Sector_Cuestionario sector : cargos){
                                    if(item.getCargo_id()== sector.getArea_id())
                                        Select = "Selected";
                                }
                            %>
                            <option value="<%=item.getCargo_id()%>" <%=Select%>><%=item.getNombre()%></option>
                            <%}%>
                            </select>
                        </div>  
                        
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea disabled class="form-control" rows="3" id="descripcion"  name="descripcion"><%=cuestionario.getDetalle()%></textarea>
                        </div>
                        <div class="form-group">
                            <label>Activar</label>
                            <%
                                String select = "";
                                if(cuestionario.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div> 
                        <div class="form-group">
                            <label>Departamemto</label>
                            <select disabled name="idDepartamento" class="form-control select2 selectDepartamento" multiple="multiple" style="width: 100%;">
                              <option disabled>Selecione una opción</option>
                              <%
                                for (Departamento item : listaDepartamento) {
                                    String Select = "";
                                for (Sector_Cuestionario sector : departamentos){
                                    if(item.getDepartamento_id() == sector.getArea_id())
                                        Select = "Selected";
                                }
                            %>
                            <option value="<%=item.getDepartamento_id()%>" <%=Select%>><%=item.getNombre()%></option>
                              <% } %>
                            </select>
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
    $(function () {
        $('.select2').select2()
    });
    
    $(document).ready(function () {
        $(".btn_eliminar").click(function () {
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('deleteCuestionario.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });
</script>

 
