<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>

<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    List<A_Tarea> listaTareas = new ArrayList<A_Tarea>();
    listaTareas = _tarea.getAllTareaCalendar(DatoUsuario.getUser_id());
%>
        <style>
        .disabled{
        background-color: #eee;
        }
        </style>
<section class="content-header">
    <h1>
        Calendario
        <small> de tareas</small>
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
        <div id="modal-dialog" class="modal-dialog modalTarea">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModal" class="modal-title">title</h4>
                </div>
                <div id="modelViewTarea" class="modal-body cuerpo_registro"></div>
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
        $("#formulario_registro #modal-dialog").removeClass( "modalTarea"); 
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        $("#titleModal").html("Crear nota personal");
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('crearTarea.jsp',
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
          
           
           $('#formulario_registro').modal('show');
           $(".cuerpo_registro").html('');
           $(".cuerpo_registro").addClass('loader');
           
          if(e.event.groupId == '1'){    
              $("#titleModal").html("Tarea");
              $("#formulario_registro #modal-dialog").addClass( "modalTarea");
              $("#formulario_registro #modelViewTarea").addClass('modelViewTarea');
           $.post('verTarea.jsp',
                {id: e.event.id,
                 title: e.event.title},
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
          }else{
              $("#titleModal").html("Nota personal");
              $("#formulario_registro #modal-dialog").removeClass( "modalTarea");
              $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
             $.post('verTareaPersonal.jsp',
                {id: e.event.id},
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
          }
      },
      editable: false,
      eventLimit: true, // allow "more" link when too many events  
        events: [
            <%
            for(A_Tarea item : listaTareas){
                String color = "";
                if(item.getIdTipoTarea()==1){
                  color = "#f39c12 !important";
                    if(item.getIdEstadoTarea() == 2 ){
//                      verde
                        color = "#00a65a !important";
                    }else if(item.getIdEstadoTarea() == 6){
//                      rojo
                        color = "#dd4b39 !important";
                    } 
                }

               %>{
                id: <%=item.getIdTarea()%>,
                groupId: '<%=item.getIdTipoTarea()%>',
                idUser: <%=item.getIdUserCrea()%>,
                title: '<%=item.getTitulo()%>',
                start: '<%=item.getFechaInicio()%>',
                end: '<%=item.getFechaFinal()%>',
                backgroundColor: '<%=color%>',
                borderColor: '<%=color%>'
                },
            <%}%>
        {
        id: (++counter).toString(),
        title: 'Meeting',
        start: '2016-12-01T10:30:00',
        end: '2016-12-02T12:30:00'
        }
        ],
        timeFormat: 'H(:mm)t'
    });

    

    calendar.render();
    
  });   
    
</script>