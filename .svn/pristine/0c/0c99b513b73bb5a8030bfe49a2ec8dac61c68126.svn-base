<%-- 
    Document   : guardarArea
    Created on : 22/05/2019, 08:43:44 AM
    Author     : pc
--%>
<%@page import="Entidad.C_TipoComida"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<%
    C_TipoComida tipoComida = new C_TipoComida();
    tipoComida.setIdTipoComida(Integer.parseInt(request.getParameter("id")));
    tipoComida.setNombreComida(request.getParameter("nombre"));
    tipoComida.setCosto(Double.parseDouble(request.getParameter("costo")));
    tipoComida.setHora(request.getParameter("hora"));
    tipoComida.setColor(request.getParameter("color"));
    tipoComida.setDetalle(request.getParameter("detalle"));
    tipoComida.setHorasAnticipacion(request.getParameter("horaAnticipacion"));
    int estado = 0;
    try{
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    tipoComida.setEstado(estado);
    
    String resultado = _tipoComida.SaveOrUpdate(tipoComida);
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
