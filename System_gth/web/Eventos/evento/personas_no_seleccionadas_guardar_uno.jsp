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
    String personas = request.getParameter("personales");

    Evento_participantes par = new Evento_participantes();
    par.setEmpleado_id(Integer.parseInt(personas));
    par.setEvento_id(Integer.parseInt(evento));
    par.setRegistra_personal_id(DatoUsuario.getEmpleado_id());

    String respuesta = guardaEventoParti.AnadirUnParticipantes(par);

    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<script type="text/javascript">
    toastr.success("Agregado Correctamente.");
    $("#tr_<%=personas%>").remove();
</script>
<%
} else {
    //out.print("Se produjo un error :" + respuesta);
%>
<script type="text/javascript">
    toastr.error("Se produjo un error." +<%=respuesta%>);
</script>
<%
        }
    }


%>

