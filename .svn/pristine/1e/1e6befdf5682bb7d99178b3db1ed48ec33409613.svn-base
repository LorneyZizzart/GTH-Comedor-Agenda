<jsp:useBean id="profesoresGet" class="Controlador.Empleado_docenteController"/>

<%
    String id_emple = request.getParameter("id_empleado");
    String codigo_univ = profesoresGet.GetEmpleadoCodAcad(id_emple);    
%>
<script>
    $('.codigo_univ').val('<%=codigo_univ%>');
</script>