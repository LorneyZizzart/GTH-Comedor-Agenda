<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    A_Tarea tarea = new A_Tarea();
    String resultado = null;
    
    try{
        tarea.setIdTarea(Integer.parseInt(request.getParameter("id")));
        tarea.setIdUserCrea(Integer.parseInt(request.getParameter("idFunc")));
        tarea.setTitulo(request.getParameter("titulo"));
        tarea.setDescripcion(request.getParameter("descripcion"));        
        tarea.setIdRepeticionTarea(Integer.parseInt(request.getParameter("idRepeticion")));
        tarea.setIdEstadoTarea(Integer.parseInt(request.getParameter("idEstado")));
        tarea.setFechaInicio(String.valueOf(request.getParameter("fi")));
        tarea.setHoraInicio(request.getParameter("horaInicio"));
        tarea.setIdTipoTarea(1);
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }

    try{
        if(request.getParameter("L").equalsIgnoreCase("on"))
            tarea.setLunes(1);
    }catch(Exception e){
        tarea.setLunes(0);
    }
    
    try{
        if(request.getParameter("Ma").equalsIgnoreCase("on"))
            tarea.setMartes(1);
    }catch(Exception e){
        tarea.setMartes(0);
    }
    
    try{
        if(request.getParameter("Mi").equalsIgnoreCase("on"))
            tarea.setMiercoles(1);
    }catch(Exception e){
        tarea.setMiercoles(0);
    }
    
    try{
        if(request.getParameter("J").equalsIgnoreCase("on"))
            tarea.setJueves(1);
    }catch(Exception e){
        tarea.setJueves(0);
    }
    try{
        if(request.getParameter("V").equalsIgnoreCase("on"))
            tarea.setViernes(1);
    }catch(Exception e){
        tarea.setViernes(0);
    }
    
    try{
        if(request.getParameter("S").equalsIgnoreCase("on"))
            tarea.setSabado(1);;
    }catch(Exception e){
        tarea.setSabado(0);;
    }
    
    try{
        if(request.getParameter("D").equalsIgnoreCase("on"))
            tarea.setDomingo(1);            
    }catch(Exception e){
        tarea.setDomingo(0); 
    }
    if(request.getParameter("proceso").equalsIgnoreCase("insert")){
//        resultado = "Ok";
        
        resultado = _tarea.SaveTarea(tarea);
        
        if(resultado.equalsIgnoreCase("Ok")){
            A_Tarea auxTarea = new A_Tarea();
            auxTarea = _tarea.getMaxIdTarea();
        %>
        <input type="hidden" value="<%=request.getParameter("titulo")%>" name="gTitulo" id="gTitulo">
        <input type="hidden" value="<%=request.getParameter("idFunc")%>" name="gIdUsuario" id="gIdUsuario">
    <div class=" text-center alert alert-success alert-dismissible">
        <h4><i class="icon fa fa-check"></i> Guardado</h4>
    </div>
     <script type="text/javascript">
        $(document).ready(function () {  
            localStorage.setItem("idTarea", $('#gTitulo').val()+"%"+$('#gIdUsuario').val());
            for (var i = 0; i < listaImage.length; i++) {
                saveImageDB(<%=auxTarea.getIdTarea()%>, listaImage[i].titulo, listaImage[i].nameImage);
                saveImage(listaImage[i].path);
          }
            $("#mensaje").hide(3000, function () {                
                $('.form-group').removeClass('has-success');
                $('.glyphicon-ok').hide();
                $('#btnProcess').show();
                $('#btnGuardar').hide();  
            });
        });    
    </script>
    <%
        
    }}
    else {

        resultado = _tarea.UpdateTarea(tarea, request.getParameter("oldTitulo"), Integer.parseInt(request.getParameter("idFunc")));
        if(resultado.equalsIgnoreCase("Ok")){
        %>
        
        <div class=" text-center alert alert-success alert-dismissible">
            <h4><i class="icon fa fa-check"></i> Actualizado</h4>
        </div>
         <script type="text/javascript">
            $(document).ready(function () {
                
                for (var i = 0; i < listaImage.length; i++) {
                saveImageDB(<%=request.getParameter("id")%>, listaImage[i].titulo, listaImage[i].nameImage);
                }
                
                $("#mensaje").hide(3000, function () {
                    location.reload();
                });
                $("form")[0].reset();
            });   
        </script>
        <%
    }}
    
    if(!resultado.equals("Ok")){
        
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>