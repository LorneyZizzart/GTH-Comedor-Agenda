<%@page import="Entidad.Area"%> 
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="consultaNivel" class="Controlador.AreaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<Area> listaArea = new ArrayList<Area>();
    listaArea = consultaNivel.getAllArea();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de Areas</small>
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
                    <h3 class="box-title">Lista de Áreas</h3>
                    <button id="formNuevoArea" type="button" class="btn-purple btn-right_nivel" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir área">
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
                                <th>Posición</th>
                                <th>Fecha de inicio</th>
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Area item : listaArea) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=_character.CharacterUCFirst(item.getNombre())%></td>
                                <td><%=item.getPosicion()%></td>
                                <td><%=item.getFecha_creacion()%></td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getArea_id()))%>" class="formEditArea btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getArea_id()))%>" class="formEliminarArea btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
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
                                <th>Nombre</th>
                                <th>Posición</th>
                                <th>Fecha de inicio</th>
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
    <!--Modal-->
    <div class="modal fade" id="registro_area">
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
    $('#formNuevoArea').tooltip({ boundary: 'window' })
    $('#example').tooltip({ boundary: 'window' })
    function titleModal(e) {
       var title;
       if (e) title = "Crear Área";
       else title = "Editar Área";
       $("#titleModal").html(title);
    }
        
    $(function () {
        $("#example1").DataTable();
    });   
    
    $(".formEditArea").click(function (e){
        titleModal(false)
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#registro_area').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('editarArea.jsp',
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
    
    $(".formEliminarArea").click(function (e){
        $("#titleModal").html("Eliminar área");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#registro_area').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('eliminarArea.jsp',
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
    
    $("#formNuevoArea").click(function (e) {
        titleModal(true);
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#registro_area').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearArea.jsp',
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
