<%@page import="Entidad.Cargo"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Nivel"%> 
<%@page import="Entidad.Departamento"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<%
    int idEmpleado = Integer.parseInt(request.getParameter("id"));
    String opcion = "registrar";
    List<Nivel> listaNivel = new ArrayList<Nivel>();
    listaNivel = _nivel.getAllNivel();
    
    List<Departamento> listaDepartamento = new ArrayList<Departamento>();
    listaDepartamento = _departamento.GetAllDepartamento();
    
    List<Cargo> cargos = new ArrayList<Cargo>();
    cargos = _cargo.getAllCargoByCargoId();
    
    Calendar fecha = new GregorianCalendar();
    String fechaNow="", day="", month="";
    
    if(fecha.get(fecha.DATE)<10) day = "0"+Integer.toString(fecha.get(fecha.DATE));
    else day = Integer.toString(fecha.get(fecha.DATE));
    fecha.add(fecha.MONTH, 1);
    if(fecha.get(fecha.MONTH)<10) month = "0"+Integer.toString(fecha.get(fecha.MONTH));
    else month = Integer.toString(fecha.get(fecha.MONTH));
        
    fechaNow = day +"/"+month+"/"+Integer.toString(fecha.get(fecha.YEAR));
    
%>

<form id="form_guardar" method="post" class="form_guardar">
        <input type="hidden" value="<%=idEmpleado%>" name="idEmpleado" id="idEmpleado">
        <input type="hidden" value="<%=opcion%>" name="opcion" id="opcion">
    
                    <div class="box-body"> 
                        <div class="form-group">
                            <label>Grupo</label>
                            <select name="idNivel" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>
                                <%
                                for (Nivel item : listaNivel) {                                    
                                    %>
                            <option value="<%=item.getNivel_id()%>" ><%=_character.CharacterUCFirst(item.getNombre())%></option>
                            <% } %> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Departamento</label>
                            <select name="idDepartamento" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>
                                <%
                                for (Departamento item : listaDepartamento) {
                                    
                                    %>
                            <option value="<%=item.getDepartamento_id()%>" ><%=_character.CharacterUCFirst(item.getNombre())%></option>
                            <% } %>  
                            </select>
                        </div> 
                        <div class="form-group">
                            <label>Cargo:</label>
                            <select name="idCargo" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opción</option>
                                <%
                                for (Cargo item : cargos) {
                                    if(item.getEstado() == 1){
                                    %>
                            <option value="<%=item.getCargo_id()%>"><%=_character.CharacterUCFirst(item.getNombre())%></option>
                            <% } } %>  
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Fecha inicio</label>
                            <input type="text" class="form-control" id="fechaInicio" name="fechaInicio" value="<%=fechaNow%>">                            
                        </div> 
                        <div class="form-group date">
                            <label>Fecha final</label>
                            <input type="text" class="form-control" id="fechaFinal" name="fechaFinal">                            
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
        $('.select2').select2();
    });
    
    //Date picker
//    $('#datepicker').datepicker({
//      autoclose: true
//    })
    
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