<%@page import="Entidad.Menu"%>
<jsp:useBean id="guardaMenu" class="Controlador.MenuController" />
<%
    Menu menu = new Menu();
    menu.setMenu_id(Integer.parseInt(request.getParameter("id")));
    menu.setNombre(request.getParameter("modulo_nombre"));
    menu.setPosicion(Integer.parseInt(request.getParameter("modulo_posicion")));
    menu.setIcono(request.getParameter("modulo_icono"));
    menu.setUrl("#");
    int estado = 0;
    try {
        if (request.getParameter("modulo_estado").equalsIgnoreCase("on")) {
            estado = 1;
        } else {
            estado = 0;
        }
    } catch (Exception e) {
        estado = 0;
    }
    menu.setEstado(estado);

    String resultado = guardaMenu.Menu_guarda_actualiza(menu);
    if (resultado.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
            location.reload()
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
    <%=resultado%>
</div>
<% } %>