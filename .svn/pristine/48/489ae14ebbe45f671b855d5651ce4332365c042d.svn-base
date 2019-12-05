<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<%@page import="Entidad.Cuestionario_gestion"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    }
%>
<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    List<Cuestionario_gestion> listaCiclos = new ArrayList<Cuestionario_gestion>();
    listaCiclos = _ciclo.GetAllCuestionario_gestion();
%>
<section class="content-header">
    <h1>
        Registro 
        <small> de Ciclos</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de Ciclos</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Ciclos</h3>
                    <a href="crearCiclo.jsp" class="btn-purple btn-right_nivel" data-toggle="tooltip" title="Añadir ciclo"><i class="fa fa-plus"></i></a>   

                    <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>" name="idUsuario" id="idUsuario">
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
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
                                for (Cuestionario_gestion item : listaCiclos) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=item.getNombre()%></td>
                                <td><%=item.getDescripciom()%></td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 

                        <td class="text-center">
                            <div class="btn-group ">
                                <%String idEncripta = _encript.ValorAEncriptar(Integer.toString(item.getCuestionario_gestion_id()));%> 
                                <a href="../evaluacion/personal_evalua.jsp?c=<%=idEncripta%>" class="btn btn-xs btn-info" data-toggle="tooltip" data-placement="bottom" title="Evaluar Personal"><i class="fa fa-plus"></i></a>  
                                <a href="editarCiclo.jsp?c=<%=idEncripta%>" class="btn btn-xs btn-primary" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                <a data-id="<%=idEncripta%>" class="formDelet btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                                <a class="formCorreo btn bg-yellow btn-xs" data-id="<%=item.getCuestionario_gestion_id()%>" data-toggle="tooltip" data-placement="bottom" title="Edita Correo"> <i class="fa fa-envelope-o"></i></a>
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

    <!-- /.row -->
    <div class="modal fade" id="correo_editar">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModalcorreo" class="modal-title">title</h4>
                </div>
                <div class="modal-body cuerpo_correo"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<!-- Bootstrap WYSIHTML5 -->
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script>
    $('#formNuevo').tooltip({boundary: 'window'})
    $('.title').tooltip({boundary: 'window'})

    $(function () {
        $("#example1").DataTable();
    });

    $(".formCorreo").click(function (e) {
        
        $("#titleModalcorreo").html("Crear Correo Electronico");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#correo_editar').modal('show');
        $(".cuerpo_correo").html('');
        $(".cuerpo_correo").addClass('loader');

        $.post('correo_electronico_edit.jsp',
                {id: $(this).attr('data-id')},
                function (html) {
                    $(".cuerpo_correo").removeClass('loader');
                    $(".cuerpo_correo").html(html);
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_correo").removeClass('loader');
            $(".cuerpo_correo").html(alerta);
        });


    });

    $("#formNuevo").click(function (e) {
        $("#titleModal").html("Crear Ciclo");
        e.preventDefault();
        e.stopImmediatePropagation();
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('crearCiclo.jsp',
                {id: $(this).attr('data-id'), idUser: $("#idUsuario").val()},
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
        $("#titleModal").html("Editar ciclo");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        var idUser = $("#idUsuario").val();
        $.post('editarCiclo.jsp',
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

    });
    $(".formDelet").click(function (e) {
        $("#titleModal").html("Eliminar ciclo");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('eliminarCiclo.jsp',
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