<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="eliminaEvento" class="Controlador.EventoController" />
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

    int evento_id = Integer.parseInt(request.getParameter("id"));
    int empleado_id = DatoUsuario.getEmpleado_id();

    String respuesta = eliminaEvento.EliminarEvento(empleado_id, evento_id);
    if (respuesta.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".mensaje_desactiva").hide(2000, function () {
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