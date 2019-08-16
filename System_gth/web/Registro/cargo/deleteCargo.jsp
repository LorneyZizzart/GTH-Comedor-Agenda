<%@page import="Entidad.Cargo"%>
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<%
    int idCargo = 0;
    String resultado = "";
    try{
        idCargo = Integer.parseInt(request.getParameter("id"));
        resultado = _cargo.DeleteCargoByCargoId(idCargo);
        
    }catch (Exception e){
        idCargo = 0;
    }
    if(resultado.equalsIgnoreCase("Ok")){
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Eliminado</h4>
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
    <h4><i class="icon fa fa-ban"></i> Alert</h4>
    <p>Error: <%=resultado%></p>    
</div>
<%    }   %>