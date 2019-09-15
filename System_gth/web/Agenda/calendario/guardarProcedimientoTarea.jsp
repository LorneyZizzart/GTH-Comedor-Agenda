<%@page import="Entidad.A_ProcedimientoTarea"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.File"%>
<%@page import="Entidad.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_procedimiento" class="Controlador.A_ProcedimientoTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
    String resultado = null;
    List<Empleado> Empleados = new ArrayList<Empleado>();
    try{

        
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }
    
    int estado = 0;
    try{
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
    }catch(Exception e){
        estado = 0;
    }
    procedimiento.setEstadoProcedimiento(estado);
        
    resultado =  _procedimiento.AuxSaveOrUpdate(procedimiento);

    if(resultado.equalsIgnoreCase("Ok")){
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
 <script type="text/javascript">
    $(document).ready(function () {
        $("#message").hide(3000, function () {
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
