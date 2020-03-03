<%@page import="Entidad.Empleado_docente"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="profesoresController" class="Controlador.Empleado_docenteController"/>
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

    String empleado_id = request.getParameter("empleado_id");
    String codigo_unid = request.getParameter("codigo_univ");
    String gestion = request.getParameter("gestion");
    String area = request.getParameter("area");

    Empleado_docente prof = new Empleado_docente();
    prof.setEmpleado_id(Integer.parseInt(empleado_id));
    prof.setGestion(gestion);
    prof.setUnidad_academica_id(Integer.parseInt(area));
    prof.setUsuario_crea(DatoUsuario.getEmpleado_id());
    prof.setCodigo_uab(codigo_unid);

    String mensaje = profesoresController.AgregarProfesor(prof);

    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<div class="text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".mensaje_anade_prof").hide(1500, function () {
            location.reload();
        });
        $("form")[0].reset();
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