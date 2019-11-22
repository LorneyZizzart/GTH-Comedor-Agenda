<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%> 
<jsp:useBean id="_tarea" class="Controlador.A_TareaController" />
<jsp:useBean id="_estado" class="Controlador.A_EstadoTareaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
    int idRepeat = Integer.parseInt(request.getParameter("idRepeat"));
    String dateStart =  request.getParameter("fi");
    String dateEnd =  request.getParameter("ff");
    List<A_Tarea> lista = new ArrayList<A_Tarea>();
    List<A_EstadoTarea> listaEstado = new ArrayList<A_EstadoTarea>();
    if(idRepeat == 8){
       lista = _tarea.getGroupTareaByUser(idUsuario);
    }else{
       listaEstado = _estado.getAllEstadoTarea();
       lista = _tarea.getAllTarea(idUsuario, idRepeat, dateStart, dateEnd);
    }
    

%>
    <div class="col-xs-12">            
            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Tareas</h3>
<!--                    <a href="nuevoTarea.jsp" class="btn-purple pull-right" data-toggle="tooltip" title="Nueva tarea">
                        <i class="fa fa-android"></i>
                    </a>-->
                    <a data-id="<%=idUsuario%>" style="cursor:pointer;" class="formNuevo btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir tarea">
                        <i class="fa fa-plus"></i>
                    </a>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="display table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th style="width: 3%">#</th>
                                <th style="width: 20%">Titulo</th>
                                <%
                                    if(idRepeat==8){
                                %>
                                <th style="width: 60%">Repetición</th>
                                <th style="width: 7%">Fecha de registro</th>                                 
                                <%
                                    }else{
                                %>
                                
                                <th style="width: 8%">Repetición</th>
                                <th style="width: 10%">Fecha</th> 
                                <th style="width: 14%">Estado</th>
                                
                                <%
                                    }
                                %>  
                                <th style="width: 10%">Opciones</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <%  int contador = 0;
                                  if(idRepeat==8){
                                      for (A_Tarea item : lista) {
                                          contador++;
                            %>
                            <tr >
                                <td><%=contador%></td>
                                <td class="text-left" ><a data-id="<%=item.getTitulo()%>%<%=idUsuario%>%<%=2%>" class="verTarea" style="cursor:pointer;"><%=item.getTitulo()%></a></td>   
                                <td><%= item.getNombreRepeticion()%></td>
                                <td><%= item.getFechaRegistroTarea()%></td>
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=item.getTitulo()%>%<%=idUsuario%>" class="formProcess btn btn-xs btn-info" data-toggle="tooltip" data-placement="bottom" title="Procesos"><i class="fa fa-plus"></i></a>     
<!--                                        <a data-id="<%/*=item.getTitulo()*/%>%<%/*=idUsuario*/%>" class="listUploadFile btn btn-xs btn-warning"  data-toggle="tooltip" data-placement="bottom" title="Archivos"><i class="fa fa-folder"></i></a>    -->
                                        <a data-id="<%=item.getTitulo()%>%<%=idUsuario%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=item.getTitulo()%>%<%=idUsuario%>" class="formEliminar btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                                    </div>
                                </td>
                            </tr>
                            <%
                                      }} else{
                                    for (A_Tarea item : lista) {
                                    contador++;
                                    String color = "rgba(255, 235, 59, 0.3)";
                                    if(item.getIdEstadoTarea() == 2 ){
                                        color = "rgba(76, 175, 80, 0.3)";
                                    }else if(item.getIdEstadoTarea() == 6){
                                        color = "rgba(233, 30, 99, 0.3)";
                                    }  
                                    //posible
//                                    String color = "rgba(255, 235, 59, 0.1)";
//                                    if(item.getIdEstadoTarea() == 2 ){
//                                        color = "rgba(76, 175, 80, 0.1)";
//                                    }else if(item.getIdEstadoTarea() == 6){
//                                        color = "rgba(233, 30, 99, 0.1)";
//                                    } 
                                    //--posible
                            %>
                            <tr id="<%=item.getIdTarea()%>" style="background: <%=color%>">
                                <td><%=contador%><input type="hidden" name="posicion_celda" value="<%=contador%>" class="posicion_celda"></td>
                                <td><a data-id="<%=item.getTitulo()%>%<%=idUsuario%>%<%=1%>" class="verTarea" style="cursor:pointer;"><%=item.getTitulo()%></a></td>                         

                                <td><%= item.getNombreRepeticion()%></td>
                                <td><%=String.valueOf(item.getFechaInicio())%> <%=item.getHoraInicio()%></td>
                                <td><select id="idEstadoTarea" name="idEstadoTarea" class="changeEstadoTarea form-control selectRepeticion" style="width: 100%; background-color: transparent; border: 0.1px solid;">
                                  <%
                                      for(A_EstadoTarea e : listaEstado){
                                          String select = "";
                                          if(e.getIdEstadoTarea()==item.getIdEstadoTarea())
                                              select = "Selected";
                                          %>
                                          <option value="<%=item.getIdTarea()%>-<%=e.getIdEstadoTarea()%>" <%=select%>> <%=e.getNombreEstadoTarea()%></option>                            
                                  <% }  %>
                              </select></td>
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=item.getTitulo()%>%<%=idUsuario%>" class="formProcess btn btn-xs btn-primary" data-toggle="tooltip" data-placement="bottom" title="Procesos"><i class="fa fa-plus"></i></a>                             
                                    </div>
                                </td>
                            </tr>
                            <%          
                                  }}
                            %>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Titulo</th>
                                <%
                                    if(idRepeat==8){
                                %>
                                <th>Repetición</th>
                                <th>Fecha de registro</th>                                 
                                <%
                                    }else{
                                %>
                                <th>Repetición</th>
                                <th>Fecha</th> 
                                <th>Estado</th>                                
                                <%
                                    }
                                %>
                                <th>Opciones</th>
                            </tr>
                        </tfoot>
                    </table>
                         
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
    </div>
                                <div class="mensajes" ></div>

    <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog modalTarea">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModal" class="modal-title">title</h4>
                </div>
                <div id="modelViewTarea" class="modal-body cuerpo_registro"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
                            
<script>
    $(document).ready(function() {
        
        $('.formNuevo').tooltip({ boundary: 'window' })
        $('#example').tooltip({ boundary: 'window' })
        
        $('#example1').DataTable( {
        initComplete: function () {
            this.api().columns().every( function () {
                var column = this;
                var select = $('<select><option value=""></option></select>')
                    .appendTo( $(column.footer()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        }
        } );
       
    } );
    
    $('.changeEstadoTarea').on('change', function() { 
        var data = (this.value).split("-");
            $(".mensajes").show();
            $(".mensajes").addClass("loader");
            $.post('cambiarEstadoTarea.jsp',
                    {idTarea: data[0], idEstado:data[1]},
                    function (html) {
                        $(".mensajes").removeClass('loader');
                        $(".mensajes").html(html);
//                        console.log("Se ha producido un error al cambiar el estado");
                    }
            );
    });
    
    
    $(".formNuevo").click(function (e) {
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        $("#titleModal").html("Crear tarea");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearTarea.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
    //Form para editar 
    $(".formEdit").click(function (e){
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        e.preventDefault();
        e.stopImmediatePropagation();
        $("#titleModal").html("Editar tarea");
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('editarTarea.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            }); 
        
    });
    
    $(".verTarea").click(function (e){
        e.preventDefault();
        e.stopImmediatePropagation();
        $("#titleModal").html("Tarea");
        $("#formulario_registro #modelViewTarea").addClass('modelViewTarea');
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('verTarea.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            }); 
        
    });
    
    //Form para eliminar 
    $(".formEliminar").click(function (e){
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        $("#titleModal").html("Eliminar tarea");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('eliminarTarea.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });        
    });
    
    $(".formProcess").click(function (e) {
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        $("#titleModal").html("Procesos");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            localStorage.setItem("idTarea", $(this).attr('data-id'));
            
            $.post('procesosTarea.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
    
    $(".listUploadFile").click(function (e) {
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        $(".modal-dialog-edit").width("40%");
        $(".modal-dialog-edit").css('margin-right', "30%");
        $(".modal-dialog-edit").css('margin-left', "30%");
        $("#titleModal").html("Archivos relacionados");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            localStorage.setItem("idTarea", $(this).attr('data-id'));
            
            $.post('listFile.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
    
    
    $(".formFile").click(function (e) {
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
        $("#titleModal").html("Crear tarea");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('uploadFile.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
    
    $(".formUploadFile").click(function (e) {
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
        $("#titleModal").html("Upload File");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('indexFile.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
</script>
 
