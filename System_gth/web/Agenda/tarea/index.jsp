<%@page import="Entidad.A_Tarea"%> 
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<A_Tarea> lista = new ArrayList<A_Tarea>();
    lista = _tarea.getAllTarea(DatoUsuario.getUser_id());
%>
<section class="content-header">
    <h1>
        Registro
        <small> de tareas</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de tareas</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Tareas</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Titulo</th>
                                <th>Descripción</th>  
                                <th>Color</th>
                                <th>Repetición</th>
                                <th>Fecha de inicio</th>                                
                                <th>Fecha final</th>
                                <th>Estado</th>
                                <th>Categoria</th>
                                <th>Fecha de registro</th>
                                <th>Fecha de actualización</th>
                                <th style="width: 5%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (A_Tarea item : lista) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=_character.CharacterUCFirst(item.getTitulo())%></td>                         
                                <td><%= item.getDescripcion()%></td>
                                <td class="text-center"><small style="background-color: <%= item.getColor()%> !important;" class="label"> <i class="fa fa-magic"></i> </small></td>
                                <td><%= item.getNombreRepeticion()%></td>
                                <td><%=String.valueOf(item.getFechaInicio())%> <%=item.getHoraInicio()%></td>
                                <td><%= item.getFechaFinal()%> <%=item.getHoraFinal()%></td>
                                <td><%= item.getNombreEstadoTarea()%></td>
                                <td><%= item.getNombreTarea()%></td>
                                <td><%= item.getFechaRegistroTarea()%></td>
                                <%
                                    if(String.valueOf(item.getFechaRegistroTarea()).equals(String.valueOf(item.getFechaActualizacion()))){
                                        %><td></td><%
                                    }else{
                                %>
                                <td><%= item.getFechaActualizacion()%></td>
                                <%
                                    }
                                %>
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getIdTarea()))%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getIdTarea()))%>" class="formEliminar btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                                    </div>
                                </td>
                            </tr>
                            <%
                                }
                            %>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Titulo</th>
                                <th>Descripción</th>  
                                <th>Color</th>    
                                <th>Repetición</th>
                                <th>Fecha de inicio</th>                                
                                <th>Fecha final</th>
                                <th>Estado</th>  
                                <th>Categoria</th>                                
                                <th>Fecha de registro</th>
                                <th>Fecha de actualización</th>
                                <th>Opciones</th>
                            </tr>
                        </tfoot>
                    </table>
                         
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
    <!--Modal-->
    <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModal" class="modal-title">title</h4>
                </div>
                <div class="modal-body cuerpo_registro"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>
    $('.formNuevo').tooltip({ boundary: 'window' })
    $('#example').tooltip({ boundary: 'window' })
    
    $(function () {
        $("#example1").DataTable();
    })
    
    $(".formNuevo").click(function (e) {
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
    
    //Form para eliminar 
    $(".formEliminar").click(function (e){
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
    
</script>
