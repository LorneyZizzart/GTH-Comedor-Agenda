<%@page import="Entidad.Plan_indica_resultado"%>
<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="indicador_vere" class="Controlador.Plan_indica_resultadoController" />
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    int empleado_id = 0;
    List<Plan_indica_resultado> indicador_cal = new ArrayList<Plan_indica_resultado>();
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
        empleado_id = DatoUsuario.getEmpleado_id();

        indicador_cal = indicador_vere.GetAllIndicadorCalendarioAdmin();
    }
%>

<section class="content-header">
    <h1>
        Planificación 
        <small>Estratégica</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i>Inicio </a></li>
        <li class="active">Ver planificaciones</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-md-6">

            <!-- TABLE: LATEST ORDERS -->
            <div class="box box-purple">
                <div class="box-header with-border">
                    <h3 class="box-title">Latest Orders</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                    </div>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div class="table-responsive">
                        <table class="table no-margin">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Personal</th>
                                    <th>Estado</th>
                                    <th>Presupuesto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><a href="pages/examples/invoice.html">OR9842</a></td>
                                    <td>Call of Duty IV</td>
                                    <td><span class="label label-success">Shipped</span></td>
                                    <td>
                                        <div class="sparkbar" data-color="#00a65a" data-height="20">9 Bs</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><a href="pages/examples/invoice.html">OR1848</a></td>
                                    <td>Samsung Smart TV</td>
                                    <td><span class="label label-warning">Pending</span></td>
                                    <td>
                                        <div class="sparkbar" data-color="#f39c12" data-height="20">90 Bs</div>
                                    </td>
                                </tr>                                                             
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.box-body -->
                
            </div>
            <!-- /.box -->
        </div>
        <div class="col-md-6"></div>
    </div>

    <div class="row">
        <!-- Left col -->
        <section class="col-lg-6 connectedSortable">
            <!-- Calendar -->
            <div class="box box-purple">
                <div class="box-header">
                    <i class="fa fa-calendar"></i>
                    <h3 class="box-title">Calendario</h3>
                    <!-- tools box -->
                    <div class="pull-right box-tools">                        
                        <button type="button" class="btn btn-purple btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                    <!-- /. tools -->
                </div>
                <!-- /.box-header -->
                <div class="box-body no-padding">
                    <!--The calendar -->
                    <div id="calendar" style="margin: 0.5%"></div>
                </div>

            </div>
            <!-- /.box -->
        </section>
        <section class="col-lg-6 connectedSortable ver_matriz">

        </section>
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
                $('.ver_matriz').html('');
                $('.ver_matriz').addClass('loader');
                //alert(e.event.id);
                //$.post('../plan_accion/matriz_ver.jsp',
                $.post('matriz_ver.jsp',
                        {id_pla_ac: e.event.id},
                        function (html) {
                            $(".ver_matriz").html(html);
                            $(".ver_matriz").removeClass('loader');
                        }
                ).fail(function (jqXHR, textStatus, errorThrown)
                {
                    var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                    $(".ver_matriz").html(alerta);
                    $(".ver_matriz").removeClass('loader');

                });
                /*$("#titleModal").html("Ver Matriz");
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
                 });*/
            },
            editable: false,
            eventLimit: true, // allow "more" link when too many events  
            events: [
    <%
        for (Plan_indica_resultado m : indicador_cal) {
            String id = _encript.ValorAEncriptar(Integer.toString(m.getPlan_matriz_id()));
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
                 start: '2020-02-19',
                 end: '2020-02-19'
                 }*/
            ],
            timeFormat: 'H(:mm)'
        });
        calendar.render();
    });

</script>