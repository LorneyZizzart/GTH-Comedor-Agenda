<%@page import="Entidad.Sector_Cuestionario"%>
<%@page import="Entidad.View_Sector_cuestionario"%>
<%@page import="Entidad.Cuestionario"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %>
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    }
%>
<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    List<Cuestionario> listaCuestionario = new ArrayList<Cuestionario>();
    listaCuestionario = _cuestionario.GetAllCuestionario();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de Cuestionarios</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de cuestionarios</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-xs-12">            
            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de cuestionarios</h3>
                    <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>" class="formNuevo btn-purple btn-right_nivel" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir cuestionario">
                        <i class="fa fa-plus"></i>
                    </a>
                    <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>" name="idUsuario" id="idUsuario">
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>#</th>                                
                                <th>Nombre</th>
                                <th>Cargo</th>
                                <th>Departamento</th>                                
                                <th>Detalle</th>
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Cuestionario item : listaCuestionario) {
                                    contador++;
                                    View_Sector_cuestionario sectores = item.getSectores();

                            %>
                            <tr style="cursor:pointer;" class='clickable-row' data-href="../preguntas/index.jsp?c=<%=_encript.ValorAEncriptar(Integer.toString(item.getCuestionario_id()))%>">
                                <td><%=contador%></td>
                                <td><%=item.getNombre()%></td>
                                <td><%
                                    for (Sector_Cuestionario elem : sectores.getCargo()) {
                                    %>
                                    <span class="label label-success"><%=elem.getSector_nombre()%></span>
                                    
                                    <%
                                        }

                                    %></td>
                                <td><%
                                    for (Sector_Cuestionario elem : sectores.getDepartamentos()) {
                                    %>
                                    <span class="label label-primary"><%=elem.getSector_nombre()%></span>
                                    
                                    <%
                                        }
                                    %>
                                </td>                                
                                <td><%=item.getDetalle()%></td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                        <td class="text-center">
                            <div class="btn-group ">
                                <%String idEncripta = _encript.ValorAEncriptar(Integer.toString(item.getCuestionario_id()));%> 
                                <a href="../preguntas/index.jsp?c=<%=idEncripta%>" class="btn btn-xs btn-info" data-toggle="tooltip" data-placement="bottom" title="Añadir preguntas"><i class="fa fa-plus"></i></a> 
                                <!--<a href="../EnviarCuestionario/index.jsp?e=<%=idEncripta%>" class="btn btn-xs btn-success" data-toggle="tooltip" data-placement="bottom" title="Enviar cuestionario"><i class="fa fa-paper-plane"></i></a>   -->
                                <a data-id="<%=idEncripta%>" class="formEdit btn btn-xs btn-primary" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                <a data-id="<%=idEncripta%>" class="formDelet btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
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
                                <th>Cargo</th>
                                <th>Departamento</th>                                
                                <th>Detalle</th>
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
                <div class="modal-body cuerpo_registro">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                </div>
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

    $(".formNuevo").click(function (e) {
        $("#titleModal").html("Nuevo cuestionario");
        e.preventDefault();
        e.stopImmediatePropagation();
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('crearCuestionario.jsp',
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
        $("#titleModal").html("Editar cuestionario");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        var idUser = $("#idUsuario").val();
        $.post('editarCuestionario.jsp',
                {id: $(this).attr('data-id'), idUser: idUser},
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

    })
    $(".formDelet").click(function (e) {
        $("#titleModal").html("Eliminar cuestionario");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('eliminarCuestionario.jsp',
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

    })
</script>