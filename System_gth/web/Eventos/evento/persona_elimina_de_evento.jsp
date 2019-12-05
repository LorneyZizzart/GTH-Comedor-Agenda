<%@page import="Entidad.Evento_participantes"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="guardaEvento" class="Controlador.Evento_participantesController" />
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

    String evento_id = request.getParameter("evento_id");
    String empleado_id = request.getParameter("id");

    int e_emple_id = Integer.parseInt(_encript.ValorADesencriptar(empleado_id));

    Evento_participantes participante = new Evento_participantes();
    participante.setEmpleado_id(e_emple_id);
    participante.setEvento_id(Integer.parseInt(evento_id));
    participante.setRegistra_personal_id(DatoUsuario.getEmpleado_id());

    String respuesta = guardaEvento.EliminaParticipanteEvento(participante);
    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<script type="text/javascript">
    toastr.success("Quitado Correctamente.");
    $("#<%=e_emple_id%>").remove();
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