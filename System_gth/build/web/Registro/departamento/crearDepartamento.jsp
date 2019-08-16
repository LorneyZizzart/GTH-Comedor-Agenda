<%-- 
    Document   : crearDepartamento
    Created on : 22/05/2019, 09:24:30 AM
    Author     : Jhonny
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Area"%> 
<%@page import="Entidad.Departamento"%>
<jsp:useBean id="_area" class="Controlador.AreaController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<Area> listaArea = new ArrayList<Area>();
    listaArea = _area.getAllArea();
    
    List<Departamento> ListaDepartamento = new ArrayList<Departamento>();
    ListaDepartamento = _departamento.GetAllDepartamento();
%>
<% int id = 0; %>
         <form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=id%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Area</label>
                            <select name="idArea" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected">Selecione una opciÛn</option>
                            <%
                                for (Area item : listaArea) {
                                if(item.getEstado() == 1){
                            %>
                            <option value="<%=item.getArea_id()%>"><%=_character.CharacterUCFirst(item.getNombre())%></option>
                              <% } } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Departamento</label>
                            <select name="idDepartamento" class="form-control select2" style="width: 100%;">
                                <option value="0" selected="selected">Selecione una opciÛn</option>
                            <%
                                for (Departamento item : ListaDepartamento) {
                                if(item.getEstado() == 1){
                            %>
                            <option value="<%=item.getDepartamento_id()%>"><%=_character.CharacterUCFirst(item.getNombre())%></option>
                              <% } } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" placeholder="Ingresar nombre" value="">                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red"></label>
                        </div>   
                    </div>
                    <!-- /.box-body -->

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
                    }
                },
                idArea: {
                    message: 'El area no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar una area. '
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
                url: "guardarDepartamento.jsp",
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
