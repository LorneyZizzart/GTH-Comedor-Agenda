<%-- 
    Document   : eliminarDepartamento
    Created on : 27/05/2019, 11:06:48 AM
    Author     : Jhonny
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Area"%> 
<%@page import="Entidad.Departamento"%>
<jsp:useBean id="_area" class="Controlador.AreaController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String idEncript = request.getParameter("id");
    int idDepartamento = 0;
    Departamento departamento = new Departamento();
    
    List<Area> listaArea = new ArrayList<Area>();
    listaArea = _area.getAllArea();
    
    List<Departamento> ListaDepartamento = new ArrayList<Departamento>();
    ListaDepartamento = _departamento.GetAllDepartamento();
    
    try {
        idDepartamento = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        departamento = _departamento.GetDepartamentoById(idDepartamento);
    }catch (Exception e) {
        idDepartamento = 0;
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=idDepartamento%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Area</label>
                            <select disabled name="idArea" class="form-control select2" style="width: 100%;">
                                <option value="">Selecione una opción</option>
                            <%
                                for (Area item : listaArea) {
                                    String Select = "";
                                    if (item.getArea_id() == departamento.getArea_id()) {
                                            Select = "Selected";
                                        }
                                if(item.getEstado() == 1){
                            %>
                            <option value="<%=item.getArea_id()%>" <%=Select%>><%=item.getNombre()%></option>
                              <% } } %>
                            </select>
                        </div>
                            <div class="form-group">
                            <label>Departamento</label>
                            <select disabled name="idDepartamento" class="form-control select2" style="width: 100%;">
                                <option value="0"></option>
                            <%
                                for (Departamento item : ListaDepartamento) {
                                    String Select = "";
                                    if (item.getNombre().equalsIgnoreCase(departamento.getDepartamento_Nombre_dep())) {
                                            Select = "Selected";
                                        }
                                if(item.getEstado() == 1){
                            %>
                            <option value="<%=item.getDepartamento_id()%>" <%=Select%>><%=item.getNombre()%></option>
                              <% } } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" placeholder="Ingresar nombre" value="<%=_character.CharacterUCFirst(departamento.getNombre())%>">                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label
                            <%
                                String select = "";
                                if(departamento.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
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
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('deleteDepartamento.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>
