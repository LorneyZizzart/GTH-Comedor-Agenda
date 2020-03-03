<jsp:useBean id="_path" class="Controlador.A_PathTareaController"/>
<%
    String resultado = "";
    try{
        int idPath = Integer.parseInt(request.getParameter("idPath"));
        resultado = _path.DeletePath(idPath);
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }    
   out.print(resultado);
%>
