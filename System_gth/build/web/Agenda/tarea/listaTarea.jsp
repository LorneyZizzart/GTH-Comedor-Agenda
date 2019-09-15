<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%> 
<jsp:useBean id="_tarea" class="Controlador.A_TareaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
    int idRepeat = Integer.parseInt(request.getParameter("idRepeat"));
    List<A_Tarea> lista = new ArrayList<A_Tarea>();
    lista = _tarea.getAllTarea(idUsuario, idRepeat);

%>
    <div class="col-xs-12">            
            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Tareas</h3>
                    <a data-id="<%=idUsuario%>" style="cursor:pointer;" class="formNuevo btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="A�adir tarea">
                        <i class="fa fa-plus"></i>
                    </a>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="display table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th style="width: 2%">#</th>
                                <th style="width: 8%">Titulo</th>
                                <th>Descripci�n</th>
                                <th style="width: 8%">Repetici�n</th>
                                <th style="width: 10%">Fecha</th> 
                                <th style="width: 5%">Estado</th>
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
                                <td><%=item.getTitulo()%></td>                         
                                <td><%= item.getDescripcion()%></td>
                                <td><%= item.getNombreRepeticion()%></td>
                                <td><%=String.valueOf(item.getFechaInicio())%> <%=item.getHoraInicio()%></td>
                                <td><%= item.getNombreEstadoTarea()%></td>
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=item.getIdTarea()%>" class="formProcess btn btn-xs btn-info edit_button" data-toggle="tooltip" data-placement="bottom" title="Procesos"><i class="fa fa-plus"></i></a>     
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
                                <th>Descripci�n</th> 
                                <th>Repetici�n</th>
                                <th>Fecha</th>
                                <th>Estado</th>               
                                <th>Opciones</th>
                            </tr>
                        </tfoot>
                    </table>
                         
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
    </div>

    <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog modal-dialog-edit">
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
    
    $(".formNuevo").click(function (e) {
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
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
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
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
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
        $(".modal-dialog-edit").width("40%");
        $(".modal-dialog-edit").css('margin-right', "30%");
        $(".modal-dialog-edit").css('margin-left', "30%");
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
</script>
 
