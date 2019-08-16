<%@page import="Entidad.Cargo"%>
<%@page import="Entidad.Departamento"%>
<%@page import="java.util.*"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<% int idCuestionario = 0; 
    String idEncript = request.getParameter("id");
    int idUsuario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Cargo> cargos = new ArrayList<Cargo>();
    cargos = _cargo.getAllCargoByCargoId();
%>         
<form id="form_guardar" method="post" class="form_guardar">
                <input type="hidden" value="<%=idCuestionario%>" name="id" id="id">
                <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
                    <div class="box-body">
                         <div class="form-group">
                            <label>Nombre del cuestionario</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="">                            
                        </div>   
                        <div class="form-group">
                            <label>Cargo</label>
                            <select name="idCargo" class="form-control select2 selectNivel" multiple="multiple" style="width: 100%;">
                                <option disabled>Selecione una opciÛn</option>
                              <%
                                for (Cargo item : cargos) {
                                if(item.getEstado() == 1){
                            %>
                            <option value="<%=item.getCargo_id()%>"><%=item.getNombre()%></option>
                              <% }else{
                                   %>
                                 <option disabled ><%=item.getNombre()%></option>  
                              <%
                                }
                                } %>
                            </select>
                        </div>                        
                        <div class="form-group">
                            <label>DescripciÛn</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Activar</label>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red"></label>
                        </div> 
                       <div class="box collapsed-box box-opcion-departamento">
                        <div class="box-header">

                          <div class="box-tools pull-right">
                              <button type="button" class="btn btn-box-tool btn-opcion-departamento" data-widget="collapse"><i class="fa fa-plus"></i>
                            </button>
                          </div>
                          <!-- /.box-tools -->
                        </div>
                        <!-- /.box-header -->
                        <div style="padding: 0" class="box-body">
                          <div class="form-group">
                            <label>Departamemto</label>
                            <select name="idDepartamento" class="form-control select2 selectDepartamento" multiple="multiple" style="width: 100%;">
                              <option disabled>Selecione una opciÛn</option>
                              <%
                                for (Departamento item : listaDepartamento) {
                                if(item.getEstado() == 1){
                            %>
                            <option value="<%=item.getDepartamento_id()%>"><%=item.getNombre()%></option>
                              <% }else{
                                    %>
                                    <option disabled ><%=item.getNombre()%></option>  
                              <%
                                }
                                } %>
                            </select>
                            </div>
                        </div>
                        <!-- /.box-body -->
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
                    },
                descripcion:{
                    message: 'La descripciÛn no es valido.',
                    validators: {
                        stringLength: {
                            min: 0,
                            max: 550,
                            message: 'La descripciÛn tiene que ser mas de 0 y menos de 550 caracteres'
                        }
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
