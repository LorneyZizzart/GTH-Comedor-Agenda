
<%@page import="Entidad.Evento_Actividad"%>
<%@page import="Entidad.Evento"%>
<jsp:useBean id="Actividad_lista" class="Controlador.Evento_ActividadController" />

<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="consultaEvento" class="Controlador.EventoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String e_cod_id = request.getParameter("iddsesasdasdf");
    e_cod_id = e_cod_id.replace(" ", "+");

    int e_evento_id = Integer.parseInt(_encript.ValorADesencriptar(e_cod_id));
    Evento evento = new Evento();

    evento = consultaEvento.GetEventobyId(e_evento_id);

    List<Evento_Actividad> Eventos = new ArrayList<Evento_Actividad>();
    Eventos = Actividad_lista.GetAllActividadesByEvento_id(e_evento_id);
%>
<section class="content-header">
    <h1>
        Evento
        <small><%=evento.getNombre_evento()%></small>
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
                    <h3 class="box-title">Lista de actividades</h3>
                    <button id="agrega_actividad" type="button" class="btn-purple btn-right_nivel" data-id="<%=_encript.ValorAEncriptar(Integer.toString(e_evento_id))%>" data-actividad="0" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir Actividad">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre Actividad</th>
                                <th>Fecha incio</th>
                                <th>Fecha finalización</th>
                                <th>Detalle</th>         
                                <th style="width: 90px">Registor</th>  
                                <th style="width: 30px"></th>  
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Evento_Actividad ac : Eventos) {
                                    contador++;
                            %>
                            <tr id="tr_<%=ac.getEvento_Actividad_id()%>">
                                <td><%=contador%></td>
                                <td><%= ac.getNombre_actividad()%></td>                        
                                <td><%=ac.getFecha_inicio_actividad()%> <%=ac.getHora_inicio_actividad()%></td>
                                <td><%=ac.getFecha_fin_actividad()%> <%=ac.getHora_fin_actividad()%></td>
                                <td><%=ac.getDescripcion()%></td>
                                <td>
                                    <div class="btn-group ">
                                        <a href="actividad_asistencia_camara.jsp?actividad_id=<%=ac.getEvento_Actividad_id()%>&evento_id=<%=e_evento_id%>" data-actividad="" class="btn btn-xs btn-default" data-toggle="tooltip" data-placement="bottom" title="Asistencia QR"><i class="fa fa-qrcode"></i></a>
                                        <a href="actividad_asistencia_lista.jsp?evento=<%=e_cod_id%>&actividad=<%=ac.getEvento_Actividad_id()%>" class="btn btn-xs btn-primary" data-toggle="tooltip" data-placement="bottom" title="Registrar Asistencia Lista"> <i class="fa fa-list"></i></a>
                                        <a href="actividad_asistencia_lista_presente.jsp?evento=<%=e_cod_id%>&actividad=<%=ac.getEvento_Actividad_id()%>" class="btn btn-xs btn-success" data-toggle="tooltip" data-placement="bottom" title="Lista Asistencia"> <i class="fa fa-list"></i></a>
                                        <a href="actividad_asistencia_lista_presente_ru.jsp?evento=<%=e_cod_id%>&actividad=<%=ac.getEvento_Actividad_id()%>" class="btn btn-xs btn-danger" data-toggle="tooltip" data-placement="bottom" title="Juego Ruleta"> <i class="fa  fa-gamepad"></i></a>
                                    </div>
                                </td>
                                <td>
                                    <div class="btn-group ">
                                        <a data-id="<%=e_cod_id%>" data-actividad="<%=ac.getEvento_Actividad_id()%>" class="actividad_edita btn btn-xs btn-info edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>
                                        <a data-id="<%=e_cod_id%>" data-actividad="<%=ac.getEvento_Actividad_id()%>" class="actividad_elimina btn btn-xs btn-danger delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>
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
                                <th>Nombre Actividad</th>
                                <th>Fecha incio</th>
                                <th>Fecha finalización</th>
                                <th>Detalle</th>   
                                <th style="width: 30px">Registor</th> 
                                <th></th>
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

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="registro_actividad_evento">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="titleModal" >Modal Header</h4>
            </div>
            <div class="modal-body cuerpo_registro">
                <p>Some text in the modal.</p>
            </div> 
        </div>
    </div>
</div> 

<div class="mensajeDelete"></div>
<%@ include file= "../../masterPage/complemento/footer.jsp" %>


<script type="text/javascript">
    $(document).ready(function () {
        $(function () {
            $("#example1").DataTable();
        });

        $("#agrega_actividad").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Añadir Actividad");
            $('#registro_actividad_evento').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('actividad_crear.jsp',
                    {id_evento: $(this).attr('data-id'),
                        id_actividad: $(this).attr('data-actividad')},
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

        $('.actividad_edita').click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Editar Actividad");
            $('#registro_actividad_evento').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('actividad_crear.jsp',
                    {id_evento: $(this).attr('data-id'),
                        id_actividad: $(this).attr('data-actividad')},
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

        $('.actividad_elimina').click(function () {
            var emple_id = $(this).attr('data-id');

            $.post('actividad_elimina.jsp',
                    {id_evento: $(this).attr('data-id'),
                        id_actividad: $(this).attr('data-actividad')},
                    function (html) {
                        $(".mensajeDelete").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".mensajeDelete").removeClass('loader');
                $(".mensajeDelete").html(alerta);
            });

        });

    });
</script>