<%@page import="Entidad.Cargo"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<%
    List<Cargo> cargos = new ArrayList<Cargo>();
    cargos = _cargo.getAllCargoByCargoId();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de Cargos</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li class="active">Lista de cargos</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Cargos</h3>
                    <button id="formNuevo" type="button" class="btn-purple btn-right_nivel" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir cargo">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Descripción</th>
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Cargo item : cargos) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=item.getNombre()%></td>
                                <td><%=item.getDescripcion()%></td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                        <td class="text-center">
                            <div class="btn-group ">  
                                <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getCargo_id()))%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar cargo"><i class="fa fa-edit"></i></a>                                
                                <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getCargo_id()))%>" class="formEliminar btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar cargo"> <i class="fa fa-trash-o"></i></a>                                
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
                                <th>Descripción</th>
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
        $("#titleModal").html("Crear cargo");
        e.preventDefault();
        e.stopImmediatePropagation();
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        //$.post('lista_cuenta_duplicada.jsp',
        $.post('crearCargo.jsp',
                {id: $(this).attr('data-id')},
        function (html) {
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(html);
        }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(alerta);
        });
    });
    
    $(".formEdit").click(function (e) {
        $("#titleModal").html("Editar cargo");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('editarCargo.jsp',
                {id: $(this).attr('data-id')},
        function (html) {
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(html);
        }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(alerta);
        });

    });
    $(".formEliminar").click(function (e) {
        $("#titleModal").html("Eliminar cargo");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('eliminarCargo.jsp',
                {id: $(this).attr('data-id')},
        function (html) {
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(html);
        }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(alerta);
        });

    });
</script>