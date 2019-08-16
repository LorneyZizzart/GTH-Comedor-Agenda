<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="consultaOpcion" class="Controlador.OpcionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<Opcion> ListaOpcion = new ArrayList<Opcion>();
    ListaOpcion = consultaOpcion.GetAllOpciones();
%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Administrar
        <small> Opci�n</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Panel</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Opciones</h3> 
                    <button id="formNuevo" type="button" class="btn-purple btn-right_nivel" data-toggle="modal" data-target="#modal-default" data-toggle="tooltip" data-placement="bottom" title="A�adir opci�n">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>URL</th>
                                <th>Descripci�n</th>
                                <th>Men�</th>
                                <th>Estado</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody>  
                            <%
                                int contador = 0;
                                for (Opcion item : ListaOpcion) {
                                    contador++;
                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=_character.CharacterUCFirst(item.getNombre())%></td>
                                <td><%=item.getUrl()%></td>
                                <td><%=item.getDescriocion()%> </td>
                                <td><%=_character.CharacterUCFirst(item.getNombre_menu())%> </td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}
                                %> 
                        <td class="text-center" ><div class="btn-group">
                                <a data-id="<%=item.getOpcion_id()%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                <a data-id="<%=item.getOpcion_id()%>" class="formDelete btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                            </div></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>URL</th>
                                <th>Descripci�n</th>
                                <th>Men�</th>
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
        <!-- /.col -->
    </div>
    <!-- /.row -->
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
    $('#formNuevo').tooltip({ boundary: 'window' })
    $('#example').tooltip({ boundary: 'window' })
    $(function () {
        $("#example1").DataTable();
    });
    
    $("#formNuevo").click(function (e) {
        $("#titleModal").html("Crear Opci�n");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            $.post('crearOpcion.jsp',
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
    
    $(".formEdit").click(function (e){
        $("#titleModal").html("Editar Opci�n");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('editOpcion.jsp',
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
        
    })
    
    $(".formDelete").click(function (e){
        $("#titleModal").html("Eliminar Opci�n");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('eliminaopcion.jsp',
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
        
    })
</script>