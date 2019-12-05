<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.Evento_Actividad"%>
<jsp:useBean id="guardaActividad" class="Controlador.Evento_ActividadController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />

<%
    HttpSession sesion = request.getSession();
    //out.print(sesion.getAttribute("USUARIO"));
    if (session.getAttribute("USUARIO") == null) {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Termino su sesión, ingrese nuevamente haga clic <a href="../../"> aquí.</a>
</div>
<%
} else {
    Login_Entidad DatoUsuario = new Login_Entidad();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    String evento_id = _encript.ValorADesencriptar(request.getParameter("evento_id"));
    String actividad_nombre = request.getParameter("actividad_nombre");
    String actividad_inicio_fecha = request.getParameter("actividad_inicio_fecha");
    String actividad_inicio_hora = request.getParameter("actividad_inicio_hora");
    String actividad_fin_fecha = request.getParameter("actividad_fin_fecha");
    String actividad_fin_hora = request.getParameter("actividad_fin_hora");
    String actividad_detalle = request.getParameter("actividad_detalle");
    String actividad_id = request.getParameter("actividad_id");
    Evento_Actividad evento = new Evento_Actividad();

    try {
        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(actividad_inicio_fecha);
        Date fin = new SimpleDateFormat("dd/MM/yyyy").parse(actividad_fin_fecha);
        if (fin.before(inicio)) {


%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>    
    Fecha  Inicio de la actividad tiene que ser mayor o igual a la fecha de finalización.
</div>
<%} else {

    Evento_Actividad ac = new Evento_Actividad();
    ac.setNombre_actividad(actividad_nombre);
    ac.setEmpleado_id(DatoUsuario.getEmpleado_id());
    ac.setDescripcion(actividad_detalle);
    ac.setFecha_inicio_actividad(actividad_inicio_fecha + " " + actividad_inicio_hora);
    ac.setFecha_fin_actividad(actividad_fin_fecha + " " + actividad_fin_hora);
    ac.setEvento_id(Integer.parseInt(evento_id));
    ac.setEvento_Actividad_id(Integer.parseInt(actividad_id));

    String respuesta = guardaActividad.CreateorUpdateEventoActividad(ac);
    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(2000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%
} else {
    //out.print("Se produjo un error :" + respuesta);
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=respuesta%>
</div>
<%
        }
    }
} catch (Exception e) {

    // out.print("Se produjo un error " + e.getMessage());
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=e.getMessage()%>
</div>
<%
        }
    }
%>