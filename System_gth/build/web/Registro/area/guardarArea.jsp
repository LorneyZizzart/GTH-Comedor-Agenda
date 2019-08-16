<%-- 
    Document   : guardarArea
    Created on : 22/05/2019, 08:43:44 AM
    Author     : pc
--%>
<%@page import="Entidad.Area"%>
<jsp:useBean id="_area" class="Controlador.AreaController"/>
<%
    Area area = new Area();
    area.setArea_id(Integer.parseInt(request.getParameter("id")));
    area.setPosicion(Integer.parseInt(request.getParameter("posicion")));
    area.setNombre(request.getParameter("area_nombre"));
    int estado = 0;
    try{
        if(request.getParameter("area_estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    
    area.setEstado(estado);
    
    String resultado = _area.InsertOrUpdateArea(area);
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
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>
