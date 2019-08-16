<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />
<%
    int idCiclo = 0;
    try{
        idCiclo = Integer.parseInt(request.getParameter("id"));
    }catch(Exception e){
        idCiclo = 0;
    }
    String resultado = _ciclo.DeleteCuestionario_gestion(idCiclo);
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