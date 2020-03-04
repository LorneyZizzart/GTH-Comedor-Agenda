<%@page import="Entidad.C_Empleado_Reserva"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="Entidad.C_TipoComensal"%> 
<%@page import="Entidad.C_Empleado_Reserva"%>

<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>

<jsp:useBean id="_reservaEmpleado" class="Controlador.C_EmpleadoReservaController"/>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController" />
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />

<%
    List<C_Empleado_Reserva> listaReservasEmpleado = new ArrayList<C_Empleado_Reserva>();
    listaReservasEmpleado = _reservaEmpleado.getReservasEmpleado(DatoUsuario.getUser_id());
%>

<%
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    listaTipoComida = _tipoComida.getAllTipoComida();
%>

<%
    List<C_TipoComensal> lista = new ArrayList<C_TipoComensal>();
    lista = _tipoComensal.getAllTipoComensal();
%>

        <style>
        .disabled{
        background-color: #eee;
        }
        
        .call-reservas:hover{
            color: #000;
        }
        </style>
<!--informacion de descuentos y precio de las comidas raul navarro -->
<section class="content">    
    <h1 style="margin: 0"><small> Informaciones</small></h1>   
    <div class="row">
        <div class="col-sm-12 col-md-6">
          <!-- small box -->
          <div class="small-box bg-yellow table-responsive no-padding">
            <div class="inner">
              <h4><%=lista.get(0).getNombreComensal()%><span class="pull-right" style="font-weight: normal; font-size: 15px;"><%=lista.get(0).getDiasAnticipacion()%> días de anticipación</span></h4>

               <table class="table table-bordered">
                <tr>
                  <th>Comida</th>
                  <th>Costo</th>
                  <th>Descuento</th>
                  <th>Anticipación</th>
                  <th>Precio total</th>
                </tr>               
                    <%
                    int contadorO = 0;
                    for (C_TipoComida item : listaTipoComida) {
                    %>
                  <tr>
                  <td>(<%=item.getHora()%>) <%=item.getNombreComida()%></td>
                  <td><%=item.getCosto()%> Bs.</td>
                  <%
                    if (contadorO  == 0) {
                  %>
                  <td><%=lista.get(0).getDescuentoDesayuno()%> Bs.</td>
                  <td><%=item.getHorasAnticipacion()%> Horas</td>
                  <%            
                    }
                  if (contadorO  == 1) {
                  %>
                  <td><%=lista.get(0).getDescuentoAlmuerzo()%> Bs.</td>
                  <td><%=item.getHorasAnticipacion()%> Horas</td>
                  <%            
                   }
                   if (contadorO  == 2) {
                  %>
                  <td><%=lista.get(0).getDescuentoCena()%> Bs.</td>
                  <td><%=item.getHorasAnticipacion()%> Horas</td>
                  <%            
                   }
                  %>
                  <%
                    if (contadorO  == 0) {
                  %>
                  <td><%=item.getCosto()-lista.get(0).getDescuentoDesayuno()%> Bs.</td>
                  <%            
                    }
                  if (contadorO  == 1) {
                  %>
                  <td><%=item.getCosto()-lista.get(0).getDescuentoAlmuerzo()%> Bs.</td>
                  <%            
                   }
                   if (contadorO  == 2) {
                  %>
                  <td><%=item.getCosto()-lista.get(0).getDescuentoCena()%> Bs.</td>
                  <%            
                   }
                  %>
                </tr>
                <%contadorO++;}%>
              </table>
            </div>
            <div class="icon">
                <i class="fa fa-fw fa-user"></i>
            </div>
            
          </div>
        </div>
        <div class="col-sm-12 col-md-6">
          <!-- small box -->
          <div class="small-box bg-green table-responsive no-padding">
            <div class="inner">
                <h4><%=lista.get(1).getNombreComensal()%><span class="pull-right" style="font-weight: normal; font-size: 15px;"><%=lista.get(1).getDiasAnticipacion()%> días de anticipación</span></h4>

               <table class="table table-bordered">
                <tr>
                  <th>Comida</th>
                  <th>Costo</th>
                  <th>Descuento</th>
                  <th>Anticipación</th>
                  <th>Precio total</th>
                </tr>
                <%
                    int contadorM = 0;
                    for (C_TipoComida item : listaTipoComida) {
                %> 
                <tr>
                    <th>(<%=item.getHora()%>) <%=item.getNombreComida()%> </th>
                  <td><%=item.getCosto()%> Bs.</td>
                  <%
                  if (contadorM  == 0) {
                  %>
                  <td><%=lista.get(1).getDescuentoDesayuno()%> Bs.</td>
                  <td><%=item.getHorasAnticipacion()%> Horas</td>
                  <%            
                    }
                    if (contadorM  == 1) {
                  %>
                  <td><%=lista.get(1).getDescuentoAlmuerzo()%> Bs.</td>
                  <td><%=item.getHorasAnticipacion()%> Horas</td>
                  <%            
                    }
                  if (contadorM  == 2) {
                 %>
                  <td><%=lista.get(1).getDescuentoCena()%> Bs.</td>
                  <td><%=item.getHorasAnticipacion()%> Horas</td>
                  <%            
                    }
                  %>
                  <%
                  if (contadorM  == 0) {
                  %>
                  <td><%=item.getCosto()-lista.get(1).getDescuentoDesayuno()%> Bs.</td>
                  <%            
                    }
                    if (contadorM  == 1) {
                  %>
                  <td><%=item.getCosto()-lista.get(1).getDescuentoAlmuerzo()%> Bs.</td>
                  <%            
                    }
                  if (contadorM  == 2) {
                 %>
                  <td><%=item.getCosto()-lista.get(1).getDescuentoCena()%> Bs.</td>
                  <%            
                    }
                  %>
                </tr>
                <%contadorM++;}%>
              </table>
            </div>
            <div class="icon">
                <i class="fa fa-fw fa-user"></i>
            </div>
          </div>
        </div>
        <!-- ./col -->
        
        
    </div>
    <h1 style="margin: 0"><small> Calendario</small></h1>   
<input type="hidden" value="<%=DatoUsuario.getUser_id()%>" name="idUsuario" id="idUsuario">
<div class="box box-purple " id="he">
            <div class="box-body no-padding ">
              <!-- THE CALENDAR -->
              <div id="calendar" style="margin: 0.5%p;"></div>
                <!--!important;-->
            </div>
            <!-- /.box-body -->
</div>

<div class="row">

        <!-- ./col -->
        <div class="col-sm-12">
            <div class="box-footer" style="background-color: transparent; border: transparent;">
              <div class="row">
                <div class="col-sm-12 col-md-6 border-right">
                  <div class="description-block">
                    <p style="color: #909090; margin: 0;">Sandra Mischel Charcas Enriquez</p>
                    <span class="description-text">GESTIÓN DEL TALENTO HUMANO</span>
                    <h5 class="description-header">71724382</h5>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
                <div class="col-sm-12 col-md-6">
                  <div class="description-block">
                    <p style="color: #909090; margin: 0;">Dina Gladys Mena Sarco</p>
                    <span class="description-text">Administrador del comedor</span>
                    <h5 class="description-header">71737615</h5>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div>
        </div>
        <!-- ./col -->
        
        
    </div>
          <!-- /. box -->
    <!-- /.row -->
    <!--Modal-->
    <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog modal-dialog-edit">
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
<!--<script src="https://code.jquery.com/jquery-3.4.1.js"></script>-->
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
        $(document).ready(function(){
        $("button").click(function(){
          $("div").attr("height", "500");
        });
      });
</script>