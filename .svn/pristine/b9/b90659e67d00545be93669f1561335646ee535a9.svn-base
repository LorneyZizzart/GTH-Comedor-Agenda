<%@page import="java.util.*"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.StringReader"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_cuestionarioGestion" class="Controlador.Cuestionario_gestionController" />
<%
    String resultado = null;
    List<String> listaEmpleado = new ArrayList<String>();
    JSONParser parser = new JSONParser();
    int idCiclo = 0;
    try{

        if(request.getParameter("Object") != null){
           //Recuperamos el JSON con el nombre "Object" de la vista
            String js = request.getParameter("Object"); 
            //Convertimos a un objeto
            Object obj = parser.parse(new StringReader(js));
            //Asignamos a un objeto creado de tipo JSONObject
            JSONObject json = (JSONObject) obj;
            //Extraemos el id del ciclo
            idCiclo = Integer.parseInt((String) json.get("idCiclo"));
            //Extraemos todas las listas de empleados del JSON 
            JSONArray JSONEmpleados = (JSONArray) json.get("empleados");
            for(int i = 0; i < JSONEmpleados.size(); i++){                
                String idEmploy = null;
                JSONObject JSONEmpleado = (JSONObject) JSONEmpleados.get(i);  
                idEmploy = (String) JSONEmpleado.get("idEmpleado");

                listaEmpleado.add(idEmploy);
  
            }
        }        
    }catch(Exception e){
        listaEmpleado =null;
        idCiclo = 0;
    }
    
    resultado =  _cuestionarioGestion.AgregaEmpleadoAGestion(idCiclo, listaEmpleado);    
    if (resultado.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#formulario_registro').modal('hide');
        $("#mensaje").hide(3000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>
