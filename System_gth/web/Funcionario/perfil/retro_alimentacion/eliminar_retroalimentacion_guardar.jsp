<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="_feedback_guarda" class="Controlador.FeedbackController" />
<%
    String id = request.getParameter("id");

    
    Login_Entidad DatoUsuario = new Login_Entidad();
    HttpSession sesion = request.getSession();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    String mensaje = _feedback_guarda.delete_feedback_by_id(Integer.parseInt(id), DatoUsuario.getEmpleado_id());// _feedback_guarda.Create_or_update(retroalimenta);

    if (mensaje.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        setTimeout("location.reload()", 1000);
    });
</script>
<%
} else {
%>
<div class=" text-center alert alert-danger alert-dismissible">
    <h4><i class="icon fa fa-check"></i> se produjo un errro: <%=mensaje%></h4>
</div>
<%
    }
%>