<%--<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="org.apache.commons.io.output.*" %>--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.File"%>
<%@page import="Entidad.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    A_Tarea tarea = new A_Tarea();
    String resultado = null;
    try{
        if(Integer.parseInt(request.getParameter("id"))==0){
            tarea.setIdUserCrea(Integer.parseInt(request.getParameter("idUsuario")));
            tarea.setTitulo(request.getParameter("titulo"));
            tarea.setDescripcion(request.getParameter("descripcion"));
            tarea.setFechaInicio(request.getParameter("fi"));
            tarea.setFechaFinal(request.getParameter("ff"));
            resultado = _tarea.saveTareaPersonal(tarea);
        }else{
            tarea.setTitulo(request.getParameter("titulo"));
            tarea.setDescripcion(request.getParameter("descripcion"));
            resultado = _tarea.ActualizarTareaPersonal(tarea, Integer.parseInt(request.getParameter("id")));
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
