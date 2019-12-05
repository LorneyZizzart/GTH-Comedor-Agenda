<%@page import="Entidad.Evento"%>
<%@page import="Entidad.Area"%> 
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="consultaEvento" class="Controlador.EventoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    List<Evento> eventos = new ArrayList<Evento>();
    eventos = consultaEvento.GetAllEventoActivo();
%>
<section class="content-header">
    <h1>
        Eventos 
        <small> Activos</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i> Inicio</a></li>        
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Eventos Vigentes</h3>
                    <button id="formNuevoArea" type="button" class="btn-purple btn-right_nivel" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir Evento">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre Eventos</th>
                                <th>Fecha inicio</th>
                                <th>Fecha fin</th>
                                <th>Detalle</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Evento e : eventos) {
                                    contador++;
                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=e.getNombre_evento()%></td>
                                <td><%=e.getFecha_inicio()%></td>
                                <td><%=e.getFecha_fin()%></td>
                                <td><%=e.getDetalle()%></td>
                                <td style="width: 200px">
                                    <div class="btn-group ">
                                        <a href="persona_lista.jsp?iddsesasdasdf=<%=_encript.ValorAEncriptar(Integer.toString(e.getEvento_id()))%>" class="btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Participantes"><i class="fa fa-users"></i></a>                            
                                        <a href="actividad_lista.jsp?iddsesasdasdf=<%=_encript.ValorAEncriptar(Integer.toString(e.getEvento_id()))%>" class="btn btn-xs btn-success edit_button" data-toggle="tooltip" data-placement="bottom" title="Actividades"><i class="fa fa-calendar-check-o"></i></a>
                                        <a href="evento_genera_qr_personal.jsp?iddsesasdasdf=<%=_encript.ValorAEncriptar(Integer.toString(e.getEvento_id()))%>" class="btn btn-xs btn-default" data-toggle="tooltip" data-placement="bottom" title="Genera QR"><i class="fa fa-qrcode"></i></a>
                                        <a href="evento_evento_ruleta.jsp?iddsesasdasdf=<%=e.getEvento_id()%>" class="btn btn-xs btn-danger" data-toggle="tooltip" data-placement="bottom" title="Juego Ruleta"><i class="fa fa-gamepad"></i></a>
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(e.getEvento_id()))%>" class="event_edita btn btn-xs btn-info edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                            
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(e.getEvento_id()))%>" class="event_desac btn btn-xs btn-warning edit_button" data-toggle="tooltip" data-placement="bottom" title="Desactivar"><i class="fa fa-circle-o"></i></a>
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(e.getEvento_id()))%>" class="event_elimi btn btn-xs btn-danger delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
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

</section>

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

<%@ include file= "../../masterPage/complemento/footer.jsp" %>


<script type="text/javascript">
    $(document).ready(function () {
        $(function () {
            $("#example1").DataTable();
        });

        $("#formNuevoArea").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Crear Evento");
            $('#registro_area').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crear_evento.jsp?evento_id=1',
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

        $(".event_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Editar Evento");
            $('#registro_area').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crear_evento.jsp',
                    {evento_id: $(this).attr('data-id')},
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

        $(".event_desac").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Desactivar Evento");
            $('#registro_area').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('desactivar_evento.jsp',
                    {evento_id: $(this).attr('data-id')},
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

        $(".event_elimi").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Elimina Evento");
            $('#registro_area').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('elimina_evento.jsp',
                    {evento_id: $(this).attr('data-id')},
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
    });
</script>