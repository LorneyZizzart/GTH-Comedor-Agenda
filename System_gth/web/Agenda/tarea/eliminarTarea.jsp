
<%@page import="Entidad.A_PathTarea"%>
<%@page import="Entidad.A_Tarea"%>
<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_repeticionTarea" class="Controlador.A_RepeticionTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_path" class="Controlador.A_PathTareaController"/>
<%
    String[] id = request.getParameter("id").split("%"); 
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    List<A_PathTarea> listaPath = new ArrayList<A_PathTarea>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaByTitulo(id[0], Integer.parseInt(id[1]));
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();
    listaPath = _path.getAllPath(id[0], Integer.parseInt(id[1]));

%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=request.getParameter("id")%>" name="id" id="id">
                    <div class="box-body">
 
                        <div class="form-group" >
                            <label>T�tulo</label>
                            <input disabled type="text" class="form-control" id="titulo"  name="titulo" value="<%=tarea.getTitulo()%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Descripci�n </label>
                            <textarea disabled class="textarea"  id="descripcion"  name="descripcion" style="width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"><%=tarea.getDescripcion()%></textarea>
                        </div>
                        <div id="divImage" class="form-group col-md-12" style="margin: 10px 0 10px 0; padding: 0;">
                              <%
                                for (A_PathTarea path : listaPath) {

                                    %>
                                  <div id="divimgSalida<%=path.getIdPath()%>" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0; border-radius: 5px;">
                                        <label id="imgSalida"><%=path.getNombrePath()%></label>
                                        <img id="imgSalida<%=path.getIdPath()%>" width="100%" height="100%" src="../../folder_picture/Tareas/<%=path.getPathImage()%>" />
                                    </div>
                            <%  } %>
                        </div>
                        <div class="row" >
                                                    <div class="form-group col-md-6">
                            <label>Repetir cada</label>
                            <select disabled id="idRepeticion" name="idRepeticion"  class="form-control select2" style="width: 100%;">
                                <option value="0" disabled selected="selected">Selecione una opci�n</option>
                              <%
                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        String select = "";
                                        if(tarea.getIdRepeticionTarea() == item.getIdRepeticionTarea())
                                            select = "Selected";
                                        if(item.getEstadoRepeticion()== 1){
                                            %>
                                   <option value="<%=item.getIdRepeticionTarea()%>" <%=select%>><%=item.getNombreRepeticion()%></option>
                               <% } } %>
                            </select>
                        </div>
                            <div id="fechaInicio" class="form-group col-md-6" >
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                                <input disabled type="text" class="form-control pull-right" name="fi" id="datepicker1" autocomplete="off" value="<%=tarea.getFechaInicio()%>">
                            </div>
                        </div>
                        </div>

                            <div class="row row-days">
                                <div class="form-group col-sm-1 col-day">
                                    <label>D</label>
                                    <%
                                        String d = "";
                                        if(tarea.getDomingo() > 0){
                                            d = "checked";
                                        }
                                    %>
                                    <input disabled type="checkbox" name="D" id="D"  class="flat-red" <%=d%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>L</label>
                                    <%
                                        String l = "";
                                        if(tarea.getLunes()> 0){
                                            l = "checked";
                                        }
                                    %>
                                    <input disabled type="checkbox" name="L" id="L"  class="flat-red" <%=l%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>M</label>
                                    <%
                                        String ma = "";
                                        if(tarea.getMartes()> 0){
                                            ma = "checked";
                                        }
                                    %>
                                    <input disabled type="checkbox" name="Ma" id="Ma"  class="flat-red" <%=ma%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>M</label>
                                    <%
                                        String mi = "";
                                        if(tarea.getMiercoles()> 0){
                                            mi = "checked";
                                        }
                                    %>
                                    <input disabled type="checkbox" name="Mi" id="Mi"  class="flat-red" <%=mi%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>J</label>
                                    <%
                                        String j = "";
                                        if(tarea.getJueves()> 0){
                                            j = "checked";
                                        }
                                    %>
                                    <input disabled type="checkbox" name="J" id="J"  class="flat-red" <%=j%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>V</label>
                                    <%
                                        String v = "";
                                        if(tarea.getViernes()> 0){
                                            v = "checked";
                                        }
                                    %>
                                    <input disabled type="checkbox" name="V" id="V"  class="flat-red" <%=v%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>S</label>
                                    <%
                                        String s = "";
                                        if(tarea.getSabado()> 0){
                                            s = "checked";
                                        }
                                    %>
                                    <input disabled type="checkbox" name="S" id="S"  class="flat-red" <%=s%>>
                                </div>
                            </div>
                            
                            <div id="horaInicio" class="bootstrap-timepicker" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                  <input disabled type="text" class="form-control timepicker" name="horaInicio" autocomplete="off" <%=tarea.getHoraInicio()%>>

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                         <div class="form-group">
                            <label>Estado</label>
                            <select  disabled name="idEstado" class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opci�n</option>
                              <%
                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        String select = "";
                                        if(tarea.getIdEstadoTarea() == item.getIdEstadoTarea())
                                            select = "Selected";
                                        if(item.getEstadoEstadoTarea()== 1){
                                            %>
                                   <option value="<%=item.getIdEstadoTarea()%>" <%=select%>><%=item.getNombreEstadoTarea()%></option>
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
        //bootstrap WYSIHTML5 - text editor
        $(".textarea").wysihtml5();
        switch($('#idRepeticion').val()){
            case '1':
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    $("#horaInicio").hide();
                    break;
                case '2':
                    $("#fechaInicio").show();
                    $(".row-days").hide();
                    $("#horaInicio").show();
                    break;
                case '3':
                    $("#horaInicio").hide();
                    $("#fechaInicio").show();
                    $(".row-days").show();
                    break;
                case '4':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '5':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '6':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '7':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                default:
                    $(".row-days").hide();
                    $("#fechaInicio").hide();
                    $("#horaInicio").hide();
            
        }
//        ocultar select multiple
        
    });
    
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


</script>