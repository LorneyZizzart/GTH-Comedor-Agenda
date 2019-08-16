<jsp:useBean id="_cuestionarioGestion" class="Controlador.Cuestionario_gestionController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    int idEmpleado = 0;
    String idEmpleadoEncriptado = _encript.ValorADesencriptar(request.getParameter("id").replace(" ", "+"));
    String resultado = null;
    try {
        idEmpleado = Integer.parseInt(idEmpleadoEncriptado);
        resultado = _cuestionarioGestion.DeleteEmpledadodeGestion(idEmpleado);
    }catch (Exception e) {
        idEmpleado = 0;
    }
    if(resultado.equalsIgnoreCase("Ok")){
%>
 <script type="text/javascript">
    $(document).ready(function () {
            location.reload();
    });
</script>
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <h4><i class="icon fa fa-ban"></i> Alert</h4>
    <p>Problema: <%=resultado%></p>    
</div>
<%    }   %>