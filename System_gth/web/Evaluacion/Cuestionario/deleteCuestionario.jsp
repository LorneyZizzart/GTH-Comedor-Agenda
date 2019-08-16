<%-- 
    Document   : deleteCuestionario
    Created on : 6/06/2019, 11:03:51 AM
    Author     : pc
--%>
<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController"/>
<%
    int idCuestionario = 0;
    try{
        idCuestionario = Integer.parseInt(request.getParameter("id"));
    }catch (Exception e) {
        idCuestionario = 0;
    }
    
    String resultado = _cuestionario.DeleteCuestionarioByCuestionarioIdCambiaEstato6(idCuestionario);
    if(resultado.equals("Ok")){
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
    <h4><i class="icon fa fa-ban"></i> El cuestionario no se puede eliminar</h4>
    <p>Problema: <%=resultado%></p>    
</div>
<%    }   %>