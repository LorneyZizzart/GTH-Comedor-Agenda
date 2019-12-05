
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
<jsp:useBean id="consultaEventoActividad" class="Controlador.Evento_ActividadController" />

<%
    String e_cod_id = request.getParameter("iddsesasdasdf");
    e_cod_id = e_cod_id.replace(" ", "+");

    int e_evento_id = Integer.parseInt(e_cod_id);
    Evento evento = new Evento();

    evento = consultaEvento.GetEventobyId(e_evento_id);
    int cantidad_actividad = consultaEventoActividad.Cantidad_ActividadesEvento(e_evento_id);

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
                    <h1 class="box-title"><%=evento.getNombre_evento()%></h1>

                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">

                    <div class="box-body">
                        <div class="row">
                            <div class="col-xs-3">
                                Buscar actividades participadas
                            </div>
                            <div class="col-xs-4">
                                <select class="form-control" id="cantidad_participa" name="cantidad_participa">
                                    <option value="0">Todos</option>
                                    <% for (int i = 1; i <= cantidad_actividad; i++) {
                                    %>
                                    <option value="<%=i%>"> <%=i%> Actividades</option>
                                    <%
                                        }%>

                                </select>
                            </div>
                            <div class="col-xs-5">
                                <button type="button" class="btn_buscar_cantidad btn btn-primary pull-left">Buscar</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 ver_ruleta"></div>
                        </div>
                    </div>


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



        $('.btn_buscar_cantidad').click(function () {
            var evento = <%=e_evento_id%>;
            var cantidad = $('#cantidad_participa').val();

            $(".ver_ruleta").html("");
            $(".ver_ruleta").addClass('loader');
            $.post('evento_evento_ruleta_busca.jsp',
                    {cantidad: cantidad,
                        evento_id: evento},
                    function (html) {
                        $(".ver_ruleta").removeClass('loader');
                        $(".ver_ruleta").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".ver_ruleta").removeClass('loader');
                $(".ver_ruleta").html(alerta);
            });

        });

    });
</script>