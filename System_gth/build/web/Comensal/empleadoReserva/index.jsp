<%@page import="Entidad.C_Empleado_Reserva"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>

<jsp:useBean id="_reservaEmpleado" class="Controlador.C_EmpleadoReservaController"/>
<%
    List<C_Empleado_Reserva> listaReservasEmpleado = new ArrayList<C_Empleado_Reserva>();
    listaReservasEmpleado = _reservaEmpleado.getReservasEmpleado(DatoUsuario.getUser_id());
%>
        <style>
        .disabled{
        background-color: #eee;
        }
        </style>
<section class="content-header">
    <h1>
        Registro
        <small> de Reservas</small>
    </h1>   
</section>
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
<script type="text/javascript">   
    document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var date = moment();
    let counter = 0;
    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
      nowIndicator: true,
      now : new Date(),
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      locale : 'es',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(e) {          
        $(".modal-dialog").width(400);
        $("#titleModal").html("Crear Reserva");
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('crearReserva.jsp',
                {fechaInicio: FullCalendar.formatDate(e.start, {
                                locale: 'es'
                            }),
                fechaFin: FullCalendar.formatDate(e.end, {
                                locale: 'es'
                            }),
                idUser: $("#idUsuario").val(),
                diaInicio : FullCalendar.formatDate(e.start, {
                                day: 'numeric'
                            }),
                fechaNow: FullCalendar.formatDate(new Date(), {
                                locale: 'es'
                            })},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
        
//        var title = prompt('Event Title:');
//        if (title) {
//          calendar.addEvent({
//            title: title,
//            start: arg.start,
//            end: arg.end,
//            allDay: arg.allDay
//          })
//        }
//        calendar.unselect();
//        var inicioDate = FullCalendar.formatDate(e.start, {
//                month: 'long',
//                year: 'numeric',
//                day: 'numeric',
//                locale: 'es'
//              });
//        console.log('date incio: ' + FullCalendar.formatDate(e.start, {
//
//                day: 'numeric'
//            }));
//        console.log('date fin ' + e.end);
      },
      dayRender(date, cell) {
        let thisDate = moment(date.date);
        let now = moment().subtract(1,'d');
        let dateIsBefore = now > thisDate;
        if (dateIsBefore){
        $(date.el).addClass('disabled');
        }
       },
      selectAllow: function(select) {
        let yesterday = moment().subtract(1, 'd');
        return yesterday.diff(select.start) <= 0;
      },
      eventClick(e){
          console.log(e);
        $(".modal-dialog").width(400);
        $("#titleModal").html("Editar Reserva");
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('editarReserva.jsp',
                {id: e.event.id,
                 nombre: e.event.title,
                 fechaInicial: FullCalendar.formatDate(e.event.start, {
                                locale: 'es'
                            }),
                 fechaNow: FullCalendar.formatDate(new Date(), {
                                locale: 'es'
                            })},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
      },
      editable: false,
      eventLimit: true, // allow "more" link when too many events  
        events: [
            <%
            for(C_Empleado_Reserva item : listaReservasEmpleado){
               %>{
                id: <%=item.getIdEmpleadoReserva()%>,
                title: '<%=item.getNombreComida()%>',
                start: '<%=item.getFecha()%>T<%=item.getHora()%>:00',
                backgroundColor: '<%=item.getColor()%>',
                borderColor: '<%=item.getColor()%>',
                },
            <%}%>
        {
        id: (++counter).toString(),
        title: 'Meeting',
        start: '2018-07-12T10:30:00',
        end: '2018-07-12T12:30:00'
        }
        ],
        timeFormat: 'H(:mm)'
    });

    

    calendar.render();
    
  });   
    
</script>