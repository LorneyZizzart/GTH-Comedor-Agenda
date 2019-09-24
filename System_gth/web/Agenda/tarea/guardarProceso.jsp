<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_ProcedimientoTarea"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_procedimiento" class="Controlador.A_ProcedimientoTareaController"/>
<%
    
    
    String resultado = null;
    try{        
        if(Integer.parseInt(request.getParameter("id")) == 0){
            A_ProcedimientoTarea p = new A_ProcedimientoTarea();
            p.setIdProcedimiento(Integer.parseInt(request.getParameter("idProceso"))); 
            p.setNombreProcedimiento(request.getParameter("nombre"));
            p.setDescripcionProcedimiento(request.getParameter("descripcion"));
            resultado = _procedimiento.UpdateProcedimientoTarea(p);
        }else{
            A_Tarea tarea = new A_Tarea();
            tarea.setIdTarea(Integer.parseInt(request.getParameter("id")));  
            tarea.setNombreProcedimiento(request.getParameter("nombre"));
            tarea.setDescripcionProcedimiento(request.getParameter("descripcion"));
            resultado = _procedimiento.SaveProcedimiento(tarea);
        }
        
        
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }
    
    if(resultado.equalsIgnoreCase("Ok")){
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
 <script type="text/javascript">
     
    $(document).ready(function () {         
        $("#mensaje").hide(3000, function () {
            $('.form-group').removeClass('has-success');
            $('.glyphicon-ok').hide();
        });
        $("#formGuardarProceso")[0].reset();
    });
</script>
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>
