<%@page import="Entidad.Nivel"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController"/>
<%
    Nivel nivel = new Nivel();
    nivel.setNivel_id(Integer.parseInt(request.getParameter("id")));  
    nivel.setPosicion(Integer.parseInt(request.getParameter("posicion")));    
    nivel.setNombre(request.getParameter("nivel_nombre"));
    int estado = 0;
    try {
        if(request.getParameter("nivel_estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    nivel.setEstado(estado);
    
    String resultado = _nivel.InsertOrUpdateNivel(nivel);
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
    <%=resultado%>
</div>
<%    }   %>