<%@page import="Entidad.A_Tarea"%>
<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_TipoTarea"%>
<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_tipoTarea" class="Controlador.A_TipoTareaController"/>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_repeticionTarea" class="Controlador.A_RepeticionTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String id = _encript.ValorADesencriptar(request.getParameter("id")); 
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_TipoTarea> listaTipoTarea = new ArrayList<A_TipoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaById(Integer.parseInt(id));
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();
    listaTipoTarea = _tipoTarea.getAllTipoTarea();
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=id%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>Título</label>
                            <input disabled type="text" class="form-control" id="titulo"  name="titulo" value="<%=tarea.getTitulo()%>" >                            
                        </div>                         
                        <div class="form-group">
                            <label>Color</label>

                            <div class="input-group my-colorpicker2">
                                <input disabled type="text" class="form-control" name="color" value="<%=tarea.getColor()%>">
                              <div class="input-group-addon">
                                <i></i>
                              </div>
                            </div>
                            <!-- /.input group -->
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea disabled class="form-control" rows="3" id="descripcion"  name="descripcion"><%=tarea.getDescripcion()%></textarea>
                        </div>
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input disabled type="text" class="form-control pull-right" name="fi" id="datepicker1" value="<%=tarea.getFechaInicio()%>">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                  <input disabled type="text" class="form-control timepicker" name="horaInicio" value="<%=tarea.getHoraInicio()%>">

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha final:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input disabled type="text" class="form-control pull-right" name="ff" id="datepicker2" value="<%=tarea.getFechaFinal()%>">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                <input disabled type="text" class="form-control timepicker" name="horaFinal" value="<%=tarea.getHoraFinal()%>">

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                        <div class="form-group">
                            <label>Repetir cada</label>
                            <select disabled name="idRepeticion"  class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opción</option>
                              <%
                                    
                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        if(item.getEstadoRepeticion()== 1){
                                        String Seleccionar = "";    
                                    if (item.getIdRepeticionTarea() == tarea.getIdRepeticionTarea()) {
                                            Seleccionar = "Selected";
                                        }
                                    %>
                                   <option value="<%=item.getIdRepeticionTarea()%>" <%=Seleccionar%>><%=item.getNombreRepeticion()%></option>
                               <% } } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Categoria</label>
                            <select disabled name="idCategoria"  class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opción</option>
                              <%
                                    String Select = "";
                                    for(A_TipoTarea item : listaTipoTarea){
                                        if(item.getEstadoTipoTarea()== 1){
                                            
                                    if (item.getIdTipoTarea()== tarea.getIdTipoTarea()) {
                                            Select = "Selected";
                                        }
                                    %>
                                   <option value="<%=item.getIdTipoTarea()%>" <%=Select%>><%=item.getNombreTarea()%></option>
                               <% } } %>
                            </select>
                        </div>
                         <div class="form-group">
                            <label>Estado</label>
                            <select disabled name="idEstado" class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opción</option>
                              <%
                                    String Selec = "";
                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        if(item.getEstadoEstadoTarea()== 1){
                                            if (item.getIdEstadoTarea()== tarea.getIdEstadoTarea()) {
                                            Selec = "Selected";
                                        }
                                            %>
                                   <option value="<%=item.getIdEstadoTarea()%>" <%=Selec%>><%=item.getNombreEstadoTarea()%></option>
                               <% } } %>
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
      $(document).ready(function () {
        $(".btn_eliminar").click(function () {
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('deleteTarea.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>