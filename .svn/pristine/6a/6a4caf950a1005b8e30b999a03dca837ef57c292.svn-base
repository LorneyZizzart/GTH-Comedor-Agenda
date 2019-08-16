    <%@page import="Entidad.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />   
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<%
    String idEncript = request.getParameter("id");
    String idUserEncript = request.getParameter("idUser");
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    List<Sector_Cuestionario> departamentos = new ArrayList<Sector_Cuestionario>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Cargo> listaCargo = new ArrayList<Cargo>();
    List<Sector_Cuestionario> cargos = new ArrayList<Sector_Cuestionario>();
    listaCargo = _cargo.getAllCargoByCargoId();
        
    int idCuestionario = 0;
    int idUsuario = 0;
    Cuestionario cuestionario = new Cuestionario();
    
    try {
        idUsuario = Integer.parseInt(_encript.ValorADesencriptar(idUserEncript));
        idCuestionario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cuestionario = _cuestionario.GetCuestionariobyCuestionario_id(idCuestionario);
        cargos = cuestionario.getSectores().getCargo();
        departamentos = cuestionario.getSectores().getDepartamentos();
    }catch (Exception e) {
        idCuestionario = 0;
        idUsuario = 0;
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idCuestionario%>" name="id" id="id">
             <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">

                    <div class="box-body">
                         <div class="form-group">
                            <label>Nombre del cuestionario</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="<%=cuestionario.getNombre()%>">                            
                        </div>   
                        <div class="form-group">
                            <label>Cargo</label>
                            <select name="idCargo" class="form-control select2 selectNivel" multiple="multiple" style="width: 100%;">
                                <option disabled>Selecione una opciÛn</option>
                              <%
                                for (Cargo item : listaCargo) {
                                     String Select = "";
                                for (Sector_Cuestionario sector : cargos){
                                    if(item.getCargo_id()== sector.getArea_id())
                                        Select = "Selected";
                                }
                            %>
                            <option value="<%=item.getCargo_id()%>" <%=Select%>><%=item.getNombre()%></option>
                              <% } %>
                            </select>
                        </div> 
                        <div class="form-group">
                            <label>DescripciÛn</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion"><%=cuestionario.getDetalle()%></textarea>
                        </div>
                        <div class="form-group">
                            <label>Activar</label>
                            <%
                                String select = "";
                                if(cuestionario.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                        <div class="form-group">
                            <label>Departamemto</label>
                            <select name="idDepartamento" class="form-control select2 selectDepartamento" multiple="multiple" style="width: 100%;">
                              <option disabled>Selecione una opciÛn</option>
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
                nombre:{
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
                            regexp: /^([-a-z()0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n˙meros y guiones bajos.'
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
                url: "guardarCuestionario.jsp",
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
