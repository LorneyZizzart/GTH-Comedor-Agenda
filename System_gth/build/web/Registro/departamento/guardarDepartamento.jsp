<%-- 
    Document   : guardarDepartamento
    Created on : 22/05/2019, 09:25:03 AM
    Author     : jhonny
--%>
<%@page import="Entidad.Departamento"%>
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController"/>
<%
    Departamento departamento = new Departamento();
    departamento.setArea_id(Integer.parseInt(request.getParameter("idArea")));
    departamento.setDepartamento_id_aux(Integer.parseInt(request.getParameter("idDepartamento")));
    departamento.setDepartamento_id(Integer.parseInt(request.getParameter("id")));    
    departamento.setNombre(request.getParameter("nombre"));
    int estado = 0;
    try {
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    departamento.setEstado(estado);
    
    String resultado = _departamento.SaveOrUpdateDepartamento(departamento);
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
<div class="text-center alert alert-danger alert-dismissible">
    <h4><i class="icon fa  fa-close"></i> Error</h4>
    <%=resultado%>
</div>
<%    }   %>
