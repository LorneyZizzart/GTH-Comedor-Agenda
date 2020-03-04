<%@page import="Entidad.Plan_indica_resultado"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%@page import="Entidad.Plan_matriz"%>
<jsp:useBean id="indicador_ver" class="Controlador.Plan_indica_resultadoController" />
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%   HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
    Login_Entidad DatoUsuarioIndica = new Login_Entidad();
    DatoUsuarioIndica = (Login_Entidad) sesion.getAttribute("USUARIO");

    List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
    indicadores = indicador_ver.GetAllIndicadorCalendarioByUserId(Integer.toString(DatoUsuarioIndica.getEmpleado_id()));
    //DatoUsuario.getEmpleado_id()
    //List<Plan_matriz> mm = new ArrayList<Plan_matriz>();
    //mm = matriz_ver.GetAllMatriz();
%>
<section class="content-header">
    <h1>
        Planificación  
        <small> Estratégica</small>
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
                    <h3 class="box-title">Lista de Planificaciones</h3>
                    <a href="#" class="btn-purple btn-right_nivel planificacion_crear" data-toggle="tooltip" title="Añadir planificación"><i class="fa fa-plus"></i></a>   
                </div>
                <!-- /.box-header -->

                <section class="content">
                    <input type="hidden" value="<%=DatoUsuario.getUser_id()%>" name="idUsuario" id="idUsuario">
                    <div class="box box-purple">
                        <div class="box-body no-padding">
                            <!-- THE CALENDAR -->
                            <div id="calendar" style="margin: 0.5%"></div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /. box -->
                    <!-- /.row -->
                    <!--Modal-->
                    <div class="modal fade" id="formulario_registro">
                        <div class="modal-dialog modal-dialog-edit">
                            <div class="modal-content modal-lg">
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


                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->


    <!-- /.row -->
    <div class="modal fade" id="crear_planificacion">
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
<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        var calendarEl = document.getElementById('calendar');
        var date = moment();
        let counter = 0;
        var calendar = new FullCalendar.Calendar(calendarEl, {
            plugins: ['interaction', 'dayGrid', 'timeGrid'],
            nowIndicator: true,
            now: new Date(),
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay'
            },
            locale: 'es',
            navLinks: true, // can click day/week names to navigate views
            selectable: true,
            selectMirror: true,
            dayRender(date, cell) {
                let thisDate = moment(date.date);
                let now = moment().subtract(1, 'd');
                let dateIsBefore = now > thisDate;
                if (dateIsBefore) {
                    $(date.el).addClass('disabled');
                }
            },
            selectAllow: function (select) {
                let yesterday = moment().subtract(1, 'd');
                return yesterday.diff(select.start) <= 0;
            },
            eventClick(e) {
                console.log(e);
                $("#titleModal").html("Ver Matriz");
                $('#formulario_registro').modal('show');
                $(".cuerpo_registro").html('');
                $(".cuerpo_registro").addClass('loader');
                $.post('../plan_accion/matriz_ver.jsp',
                        {id_pla_ac: e.event.id},
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
            },
            editable: false,
            eventLimit: true, // allow "more" link when too many events  
            events: [
    <%
        
        for (Plan_indica_resultado m : indicadores) {
            String id = _encript.ValorAEncriptar(Integer.toString(m.getPlan_indica_resultado_id()));
    %>
                {
                    id: '<%=id%>',
                    title: '<%=m.getNombre()%>',
                    start: '<%=m.getFecha()%>',
                    end: '<%=m.getFecha()%>'
                },
    <%
        }
    %>

                /*{
                 id: 'S+X8gO9xKUbvumvhsIAm6w==',
                 title: 'Meeting',
                 start: '2019-10-30',
                 end: '2019-10-30'
                 }*/
            ],
            timeFormat: 'H(:mm)'
        });
        calendar.render();
    });

</script>