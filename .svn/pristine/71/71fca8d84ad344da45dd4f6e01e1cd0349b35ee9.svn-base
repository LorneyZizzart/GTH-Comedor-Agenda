
<%@page import="Entidad.Empleado"%>
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
<jsp:useBean id="consultaActividad" class="Controlador.Evento_ActividadController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String e_cod_id = request.getParameter("evento");
    e_cod_id = e_cod_id.replace(" ", "+");

    String e_acti_id = request.getParameter("actividad");

    int e_evento_id = Integer.parseInt(_encript.ValorADesencriptar(e_cod_id));
    Evento evento = new Evento();
    evento = consultaEvento.GetEventobyId(e_evento_id);

    Evento_Actividad actividad = new Evento_Actividad();
    actividad = consultaActividad.GetActividadesByActividad_id(Integer.parseInt(e_acti_id));

    //out.print("Actividad " + actividad.getEvento_Actividad_id() + "   Evento: " + e_evento_id);
    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaActividad.EmpleadosNoregistradoActividad(actividad.getEvento_Actividad_id(), e_evento_id);

%>
<section class="content-header">
    <h1>
        Actividad <%=actividad.getNombre_actividad()%>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i> Inicio</a></li>        
        <li><a href="../../Eventos/evento/"><i class="fa fa-dashboard"></i> Eventos</a></li>
        <li><a href="actividad_lista.jsp?iddsesasdasdf=<%=e_cod_id%>"><i class="fa fa-dashboard"></i> Actividades</a></li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Participante no registrados</h3>
                    <!--<button id="agrega_actividad" type="button" class="btn-purple btn-right_nivel" data-id="<%=_encript.ValorAEncriptar(Integer.toString(e_evento_id))%>" data-actividad="0" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir Actividad">
                        <i class="fa fa-plus"></i>
                    </button>-->
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="box-body table-responsive">
                        <table id="persona_no_select" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th> Registrar</th>
                                    <th>#</th>
                                    <th>Nombre Personal</th>
                                    <th>Departamento</th>
                                    <th>Cargo</th>
                                    <th>Grupo</th>                
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int contador = 0;
                                    for (Empleado em : Empleados) {
                                        contador++;
                                %>
                                <tr id="tr_<%=em.getEmpleado_id()%>">

                                    <td><button type="button" data-id="<%=em.getEmpleado_id()%>" class="btn btn-default registra_asistencia">Asistencia</button></td>
                                    <td><%=contador%></td>
                                    <td><%=em.getApellido_paterno()%> <%=em.getApellido_materno()%> <%=em.getNombre()%></td>

                                    <%
                                        if (em.getCargo() != null) {
                                    %>
                                    <td><%=_character.CharacterUCFirst(em.getCargo().getDepartamento_nombre())%></td>
                                    <td><%=_character.CharacterUCFirst(em.getCargo().getCargo_nombre())%></td>
                                    <td><%=_character.CharacterUCFirst(em.getCargo().getNivel_nombre())%></td>
                                    <%
                                    } else {
                                    %><td></td>
                                    <td></td>
                                    <td></td><%
                                        }
                                    %>

                                </tr>
                                <%
                                    }
                                %>

                            </tbody>
                            <tfoot>
                                <tr>
                                    <td></td>
                                    <th>#</th>
                                    <th>Nombre Personal</th>
                                    <th>Departamento</th>
                                    <th>Cargo</th>
                                    <th>Grupo</th>                
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
            $("#persona_no_select").DataTable();
        });

        $('.registra_asistencia').click(function () {
            var emple_id = $(this).attr('data-id');

            $.post('actividad_asistencia_registra.jsp',
                    {id_evento: <%=e_evento_id%>,
                        id_actividad: <%=e_acti_id%>,
                        id_empleado: $(this).attr('data-id')},
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