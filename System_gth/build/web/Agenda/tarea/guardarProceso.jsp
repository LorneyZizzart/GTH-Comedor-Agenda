<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_ProcedimientoTarea"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_procedimiento" class="Controlador.A_ProcedimientoTareaController"/>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    
    String[] id = request.getParameter("id").split("%"); 
    String resultado = null;
    try{        
        if(request.getParameter("proceso").equalsIgnoreCase("update")){
            A_ProcedimientoTarea p = new A_ProcedimientoTarea();
            p.setIdProcedimiento(Integer.parseInt(request.getParameter("idProceso"))); 
            p.setNombreProcedimiento(request.getParameter("nombre"));
            p.setDescripcionProcedimiento(request.getParameter("descripcion"));
            resultado = _procedimiento.UpdateProcedimientoTarea(p);
        }else{
            A_Tarea tarea = new A_Tarea();
            tarea.setTitulo(id[0]);
            tarea.setIdUserCrea(Integer.parseInt(id[1]));
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
                
//            $("#formulario_registro").modal('hide');//ocultamos el modal
//            $('body').removeClass('modal-open');//eliminamos la clase del body para poder hacer scroll
//            $('.modal-backdrop').remove();//eliminamos el backdrop del modal
            
            $('#formulario_registro').modal('show');
            $("#titleModal").html("Procesos");
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            $.post('procesosTarea.jsp',
            {id: localStorage.getItem("idTarea")},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
            
            
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
