<%@page import="Entidad.A_PathTarea"%>
<jsp:useBean id="_path" class="Controlador.A_PathTareaController"/>
<%
    A_PathTarea path = new A_PathTarea();
    String resultado = "Ok";
    try{
        path.setIdTarea(Integer.parseInt(request.getParameter("idTarea")));
        path.setNombrePath(request.getParameter("name"));
        path.setPathImage(request.getParameter("path"));
        resultado = _path.savePath(path);
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }
    
   out.print(resultado);
%>
