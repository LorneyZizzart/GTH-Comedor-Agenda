<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="guardaEvento" class="Controlador.EventoController" />
<%@page import="Entidad.Evento"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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

    String e_nombre = request.getParameter("evento_nombre");
    String e_fecha_inicio = request.getParameter("evento_inicio");
    String e_fecha_fin = request.getParameter("evento_fin");
    String e_detalle = request.getParameter("evento_detalle");
    int e_evento_di = Integer.parseInt(request.getParameter("evento_id"));

    try {
        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(e_fecha_inicio);
        Date fin = new SimpleDateFormat("dd/MM/yyyy").parse(e_fecha_fin);
        if (fin.before(inicio)) {


%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>    
    Fecha  Inicio del evento tiene que ser mayor o igual a la fecha de finalización.
</div>
<%} else {

    Evento e = new Evento();
    e.setEvento_id(e_evento_di);
    e.setNombre_evento(e_nombre);
    e.setEmpleado_id(DatoUsuario.getEmpleado_id());
    e.setFecha_inicio(e_fecha_inicio);
    e.setFecha_fin(e_fecha_fin);
    e.setDetalle(e_detalle);
    String respuesta = guardaEvento.InsertOrUpdate(e);
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