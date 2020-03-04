<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="eliminaObjetivo" class="Controlador.Plan_objetivoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String id_objetivo = request.getParameter("id");
%>

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

    int empleado_id = DatoUsuario.getEmpleado_id();
    id_objetivo = id_objetivo.replace(" ", "+");
    id_objetivo = _encript.ValorADesencriptar(id_objetivo);

    String mensaje = eliminaObjetivo.EliminaObjetivo(id_objetivo, Integer.toString(empleado_id));
    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<script type="text/javascript">
    $(document).ready(function () {
        location.reload();        
    });
</script>
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=mensaje%>
</div>
<%
        }

    }
%>