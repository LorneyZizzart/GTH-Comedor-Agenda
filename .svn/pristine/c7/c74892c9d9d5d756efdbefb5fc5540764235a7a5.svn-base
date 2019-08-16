<%@page import="Entidad.Empleado"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<Empleado> listaEmpleado = new ArrayList<Empleado>();
    listaEmpleado = _empleado.GetAllEmpleado();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de Empleados</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li class="active">Lista de empleados</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Empleados</h3>
                    <button id="formNuevo" type="button" class="btn-purple btn-right_nivel" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir empleado">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Correo</th>
                                <th>País</th>
                                <th>Estado</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th>Grupo</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Empleado item : listaEmpleado) {
                                    contador++;

                            %>
                            <tr style="cursor:pointer;" class='clickable-row' data-href="historialEmpleado.jsp?i=<%=_encript.ValorAEncriptar(Integer.toString(item.getEmpleado_id()))%>">
                                <td><%=contador%></td>
                                <td><%=_character.CharacterUCFirst(item.getApellido_paterno())%> <%=_character.CharacterUCFirst(item.getApellido_materno())%> <%=_character.CharacterUCFirst(item.getNombre())%></td>

                                <td><%=item.getEmail()%></td>
                                <td><%=item.getPaisNombre()%></td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                                <%
                                    if (item.getCargo() != null) {
                                %>
                        <td><%=_character.CharacterUCFirst(item.getCargo().getDepartamento_nombre())%></td>
                        <td><%=_character.CharacterUCFirst(item.getCargo().getCargo_nombre())%></td>
                        <td><%=_character.CharacterUCFirst(item.getCargo().getNivel_nombre())%></td>
                        <%
                        } else {
                        %><td></td>
                        <td></td>
                        <td></td><%
                            }
                        %>
                        <td class="text-center">
                            <div class="btn-group ">  
                                <a href="historialEmpleado.jsp?i=<%=_encript.ValorAEncriptar(Integer.toString(item.getEmpleado_id()))%>" class="formHistorial btn btn-xs btn-info" data-toggle="tooltip" data-placement="bottom" title="Ver historial"><i class="fa fa-eye"></i></a> 
                                <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getEmpleado_id()))%>" class="formCargo btn btn-xs btn-success" data-toggle="tooltip" data-placement="bottom" title="Cargo"><i class="fa fa-wrench"></i></a> 
                                <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getEmpleado_id()))%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar empleado"><i class="fa fa-edit"></i></a>                                
                                <a href="foto.jsp?i=<%=_encript.ValorAEncriptar(Integer.toString(item.getEmpleado_id()))%>"  class="btn btn-xs btn-warning edit_button" data-toggle="tooltip" data-placement="bottom" title="Fotografia"><i class="fa fa-picture-o"></i></a>                                
                                <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getEmpleado_id()))%>" class="formEliminar btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar empleado"> <i class="fa fa-trash-o"></i></a>                                
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
                                <th>Nombre completo</th>
                                <th>Correo</th>
                                <th>País</th>
                                <th>Estado</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th>Grupo</th>
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
    $(".clickable-row").click(function () {
        window.location = $(this).data("href");
    });
    $('#formNuevo').tooltip({boundary: 'window'})
    $('#example').tooltip({boundary: 'window'})

    $(function () {
        $("#example1").DataTable();
    });

    $(".formCargo").click(function (e) {
        $(".modal-dialog").width("66%");
        $("#titleModal").html("Lista de cargos");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('cargo/index.jsp',
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
        $(".modal-dialog").width(600);
        $("#titleModal").html("Editar empleado");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('editarEmpleado.jsp',
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
        $(".modal-dialog").width(600);
        $("#titleModal").html("Eliminar empleado");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('eliminarEmpleado.jsp',
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
    $("#formNuevo").click(function (e) {
        $(".modal-dialog").width(600);
        $("#titleModal").html("Registrar empleado");
        e.preventDefault();
        e.stopImmediatePropagation();
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        //$.post('lista_cuenta_duplicada.jsp',
        $.post('crearEmpleado.jsp',
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

    $(".formPhoto").click(function (e) {
        $(".modal-dialog").width(600);
        $("#titleModal").html("Editar Fotografia");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('fotografia/',
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