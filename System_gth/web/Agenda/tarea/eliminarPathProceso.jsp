<jsp:useBean id="_path" class="Controlador.A_PathProcedimientoTareaController"/>
<%
    String resultado = "";
    
    System.out.print("idpATH: "+request.getParameter("idPath"));
    
    try{
        
        int idPath = Integer.parseInt(request.getParameter("idPath"));
        resultado = _path.DeletePathProcedimiento(idPath);
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }    
   out.print(resultado);
%>
