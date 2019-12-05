<%@page import="Entidad.Evento_participantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%

%>

<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="guardaEventoParti" class="Controlador.Evento_participantesController" />
<%@page import="Entidad.Evento"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%    HttpSession sesion = request.getSession();
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

    String evento = request.getParameter("id_evento");
    String[] personas = request.getParameterValues("personales[]");

    List<Evento_participantes> Participates = new ArrayList<Evento_participantes>();

    for (String p : personas) {
        Evento_participantes par = new Evento_participantes();
        par.setEmpleado_id(Integer.parseInt(p));
        par.setEvento_id(Integer.parseInt(evento));
        par.setRegistra_personal_id(DatoUsuario.getEmpleado_id());
        Participates.add(par);

    }

    String respuesta = guardaEventoParti.AnadirParticipantes(Participates);

    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".mensaje").hide(2000, function () {
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


%>

