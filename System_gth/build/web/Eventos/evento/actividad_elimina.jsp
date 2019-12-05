<%@page import="Entidad.Evento_Actividad"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="evento_actividad" class="Controlador.Evento_ActividadController" />

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

    String evento_id = request.getParameter("id_evento");
    String actividad_id = request.getParameter("id_actividad");

    int e_evento_id = Integer.parseInt(_encript.ValorADesencriptar(evento_id));

    Evento_Actividad ac = new Evento_Actividad();
    ac.setEvento_id(e_evento_id);
    ac.setEvento_Actividad_id(Integer.parseInt(actividad_id));
    ac.setEmpleado_id(DatoUsuario.getEmpleado_id());

    String respuesta = evento_actividad.EliminaActividad(ac);

    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<script type="text/javascript">
    toastr.success("Quitado Correctamente.");
    $("#tr_<%=actividad_id%>").remove();
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