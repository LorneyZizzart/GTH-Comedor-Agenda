
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Empleado"%>
<%@page import="Entidad.Evento_Actividad"%>
<%@page import="Entidad.Evento"%>

<jsp:useBean id="consultaEvento" class="Controlador.EventoController" />
<jsp:useBean id="consultaActividad" class="Controlador.Evento_ActividadController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String e_cod_id = request.getParameter("evento_id");

    String e_acti_id = request.getParameter("cantidad");

    int e_evento_id = Integer.parseInt((e_cod_id));
    Evento evento = new Evento();
    evento = consultaEvento.GetEventobyId(e_evento_id);

    //out.print("Actividad " + actividad.getEvento_Actividad_id() + "   Evento: " + e_evento_id);
    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaEvento.Juego_cantidad_asistencia(Integer.parseInt(e_acti_id), e_evento_id); //consultaActividad.EmpleadosPresenteActividad(actividad.getEvento_Actividad_id(), e_evento_id);

%>
<script src="../../dist/js/ruleta/TweenMax.min.js"></script>
<script src="../../dist/js/ruleta/Winwheel.min.js"></script>


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
        //alert("Elemento seleccionado:" + SegmentoSeleccionado.idempleado + "!");
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