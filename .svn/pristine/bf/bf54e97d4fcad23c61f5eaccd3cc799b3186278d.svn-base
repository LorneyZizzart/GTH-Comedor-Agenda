<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.StringReader"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_path" class="Controlador.A_PathProcedimientoTareaController"/>
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController" />
<%
    
    String resultado = "Ok";
    JSONParser parser = new JSONParser();
    
    try{
        if(request.getParameter("lista") != null){ 
            String js = request.getParameter("lista");
            Object obj = parser.parse(new StringReader(js));
            JSONObject json = (JSONObject) obj;
            JSONArray listaPath = (JSONArray) json.get("listaPath");   
             for(int i = 0; i < listaPath.size(); i++){
                 A_Tarea path = new A_Tarea();
                 JSONObject p = (JSONObject) listaPath.get(i);
                 path.setIdProcedimiento(Integer.parseInt(p.get("idProceso").toString()));
                 path.setNombrePath(p.get("titulo").toString());
                 path.setPathImage(p.get("pathImage").toString());
                 resultado = _path.savePathProcedimiento(path);
             }
        }        
        
    }catch(Exception e){
        resultado =  "No se resivieron todos los parametros. Error: " + e;
    }
    
   out.print(resultado);
%>
