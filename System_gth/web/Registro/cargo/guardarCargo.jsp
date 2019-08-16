<%@page import="Entidad.Cargo"%>
<jsp:useBean id="_cargo" class="Controlador.CargoController"/>
<%
    Cargo cargo = new Cargo();
    String resultado = "";
    cargo.setCargo_id(Integer.parseInt(request.getParameter("idCargo")));
    cargo.setNombre(request.getParameter("nombre"));
    cargo.setDescripcion(request.getParameter("descripcion"));
    int estado = 0;
        try {
            if(request.getParameter("estado").equalsIgnoreCase("on"))
            estado = 1;
            else estado = 0;
        }catch(Exception e){
            estado = 0;
        }
    cargo.setEstado(estado);
    resultado = _cargo.SaveOrUpdate(cargo);
    if(resultado.equalsIgnoreCase("Ok")){
 %>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
 <script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
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
    Error: <%=resultado%>
</div>
<%    }   %>
