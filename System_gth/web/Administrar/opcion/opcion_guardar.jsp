<%@page import="Entidad.Opcion"%>
<jsp:useBean id="consultOpcion" class="Controlador.OpcionController" />
<%
    Opcion op = new Opcion();
    op.setOpcion_id(Integer.parseInt(request.getParameter("id")));
    
    op.setNombre(request.getParameter("opcion_nombre"));
    op.setUrl(request.getParameter("opcion_url"));
    op.setDescriocion(request.getParameter("opcion_descripcion"));
    op.setOrden(Integer.parseInt(request.getParameter("opcion_posicion")));
    op.setMenu_id(Integer.parseInt(request.getParameter("idMenu")));
    int estado = 0;
    try {
        if (request.getParameter("opcion_estado").equalsIgnoreCase("on")) {
            estado = 1;
        }
    } catch (Exception e) {
        estado = 0;
    }
    op.setEstado(estado);
    
    String resultado = consultOpcion.InsertUpdateOpcion(op);
    if (resultado.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
            window.top.location.href = "../opcion";
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
<%
    }

    /*id	4
modulo_nombre	Funcionarioss
modulo_estado	on
modulo_posicion	4
modulo_icono	fa+fa-fw+fa-userss*/
%>