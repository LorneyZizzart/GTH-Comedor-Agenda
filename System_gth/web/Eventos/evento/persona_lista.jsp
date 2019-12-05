<%@page import="Entidad.Empleado"%>
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
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String e_cod_id = request.getParameter("iddsesasdasdf");
    e_cod_id = e_cod_id.replace(" ", "+");

    int e_evento_id = Integer.parseInt(_encript.ValorADesencriptar(e_cod_id));
    Evento evento = new Evento();

    evento = consultaEvento.GetEventobyId(e_evento_id);

    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaEvento.GetAllEmpleadoEvento(e_evento_id);
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
                    <h3 class="box-title">Lista de participantes</h3>
                    <button id="formNuevoArea" type="button" class="btn-purple btn-right_nivel" data-id="<%=e_evento_id%>" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir Participantes">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre participante</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th>Grupo</th>         
                                <th></th>  
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Empleado em : Empleados) {
                                    contador++;
                            %>
                            <tr id="<%=em.getEmpleado_id()%>">
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
                                <td><a data-id="<%=_encript.ValorAEncriptar(Integer.toString(em.getEmpleado_id()))%>" class="empleado_elimina btn btn-xs btn-danger delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Nombre participante</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th>Grupo</th>  
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

<div class="modal fade" role="dialog"  id="registro_persona_evento">
    <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="titleModal">Modal Header</h4>
            </div>
            <div class="modal-body cuerpo_registro">
                <p>Some text in the modal.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

        $("#formNuevoArea").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Añadir Participantes");
            $('#registro_persona_evento').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('personas_no_seleccionadas.jsp',
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

        $('.empleado_elimina').click(function () {
            var emple_id = $(this).attr('data-id');

            $.post('persona_elimina_de_evento.jsp',
                    {id: $(this).attr('data-id'),
                        evento_id:<%=e_evento_id%>},
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