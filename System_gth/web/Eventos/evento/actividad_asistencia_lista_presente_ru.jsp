
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
    Empleados = consultaActividad.EmpleadosActividadJuego(actividad.getEvento_Actividad_id(), e_evento_id);

%>
<script src="../../dist/js/ruleta/TweenMax.min.js"></script>
<script src="../../dist/js/ruleta/Winwheel.min.js"></script>

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
                    <h3 class="box-title">Participante presentes actividad <%=actividad.getNombre_actividad()%></h3>
                    <!--<button id="agrega_actividad" type="button" class="btn-purple btn-right_nivel" data-id="<%=_encript.ValorAEncriptar(Integer.toString(e_evento_id))%>" data-actividad="0" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir Actividad">
                        <i class="fa fa-plus"></i>
                    </button>-->
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <center>
                        <button type="button" class="btn btn-primary btn-block" onclick="miRuleta.startAnimation();">Girar Ruleta</button>
                        <br />
                        <br />
                        <canvas id='canvas' height="800" width="800"></canvas>
                    </center>
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
        <!--Modal-->

</section>

<!--Modal-->

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="muestra_ganador">
    <div class="modal-dialog" role="document">
        <div class="modal-content">   
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal" class="modal-title">Personal seleccionado </h4>
            </div>            

            <div class="modal-body cuerpo_registro">

            </div> 
        </div>
    </div>
</div> 

<div class="mensajeDelete"></div>
<%@ include file= "../../masterPage/complemento/footer.jsp" %>


<script>
    var miRuleta = new Winwheel({
        'numSegments': <%=Empleados.size()%>, // Número de segmentos
        'outerRadius': 350, // Radio externo
        'segments': [// Datos de los segmentos

    <%for (Empleado elem : Empleados) {
    %>

            {'fillStyle': '<%=elem.getTelefono()%>', 'text': '<%=elem.getNombre()%> <%=elem.getApellido_paterno()%> <%=elem.getApellido_materno()%> ', 'idempleado': '<%=elem.getEmpleado_id()%>'},
    <%
        }
    %>
        ],
        'animation': {
            'type': 'spinToStop', // Giro y alto
            'duration': 10, // Duración de giro
            'callbackFinished': 'Mensaje()', // Función para mostrar mensaje
            'callbackAfter': 'dibujarIndicador()' // Funciona de pintar indicador
        }
    });
    dibujarIndicador();
    function Mensaje() {
        var SegmentoSeleccionado = miRuleta.getIndicatedSegment();
        // alert("Elemento seleccionado:" + SegmentoSeleccionado.text + "!");
        guardaganador(SegmentoSeleccionado.idempleado);
        $('#muestra_ganador').modal('show');
        $(".cuerpo_registro").html('<h1 class="text-center">' + SegmentoSeleccionado.text + '</h1>');

        miRuleta.stopAnimation(false);
        miRuleta.rotationAngle = 0;
        miRuleta.draw();
        dibujarIndicador();
    }
    function dibujarIndicador() {
        var ctx = miRuleta.ctx;
        ctx.strokeStyle = 'navy';
        ctx.fillStyle = 'black';
        ctx.lineWidth = 2;
        ctx.beginPath();
        ctx.moveTo(370, 0);
        ctx.lineTo(430, 0);
        ctx.lineTo(400, 40);
        ctx.lineTo(371, 0);
        ctx.stroke();
        ctx.fill();
    }

    function generarColor() {
        "#000000".replace(/0/g, function () {
            alert((~~(Math.random() * 16)).toString(16));
            return (~~(Math.random() * 16)).toString(16);
        });
    }

    function guardaganador(empleado) {
        //alert("empleado " + empleado + " evento: " + <%=e_evento_id%>);
        var evento = <%=e_evento_id%>;
        $.post('evento_guarda_ganador.jsp',
                {empleado: empleado,
                    evento: evento},
                function (html) {
                }
        );
    }
</script>