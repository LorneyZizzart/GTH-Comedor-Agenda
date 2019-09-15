<%@page import="Entidad.C_TipoComensal"%>
<jsp:useBean id="_tipoComenzalController" class="Controlador.C_TipoComensalesController"/>
<%
    C_TipoComensal tipoComensal = new C_TipoComensal();
    tipoComensal.setTipoComensal_id(Integer.parseInt(request.getParameter("id")));
    
    tipoComensal.setNombreComensal(request.getParameter("nombre"));
    tipoComensal.setMinimoDias(1);
    tipoComensal.setDescuentoDesayuno(Double.parseDouble(request.getParameter("descuentoDesayuno")));
    tipoComensal.setDescuentoAlmuerzo(Double.parseDouble(request.getParameter("descuentoAlmuerzo")));
    tipoComensal.setDescuentoCena(Double.parseDouble(request.getParameter("descuentoCena")));
    tipoComensal.setDiaInicio(Integer.parseInt(request.getParameter("diaInicio")));
    tipoComensal.setDiaFin(Integer.parseInt(request.getParameter("diaFin")));
    tipoComensal.setUsuarioCrea(Integer.parseInt(request.getParameter("idUsuario")));
    int estado = 0;
    try{
        if(request.getParameter("tipo_comensal_estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    tipoComensal.setEstado(estado);
    
    String resultado = _tipoComenzalController.SaveOrUpdate(tipoComensal);
//    String resultado = "";

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
