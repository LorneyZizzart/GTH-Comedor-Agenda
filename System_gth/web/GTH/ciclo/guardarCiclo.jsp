<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cuestionario_gestion"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    Cuestionario_gestion ciclo = new Cuestionario_gestion();
    List<String> listaEmpleado = new ArrayList<String>();
    String resultado = null;
    JSONParser parser = new JSONParser();
    try{
        if(request.getParameter("Object") != null){
            //Recuperamos el JSON con el nombre "Object" de la vista
            String js = request.getParameter("Object");
            //Convertimos a un objeto
            Object obj = parser.parse(new StringReader(js));
            //Asignamos a un objeto creado de tipo JSONObject
            JSONObject json = (JSONObject) obj;
            //Extraemos el id del ciclo
            ciclo.setCuestionario_gestion_id(Integer.parseInt(_encript.ValorADesencriptar((String) json.get("idCiclo"))));
            ciclo.setUsuario_crea(Integer.parseInt(_encript.ValorADesencriptar((String) json.get("idUsuairo"))));
            ciclo.setUsuario_actualiza(Integer.parseInt(_encript.ValorADesencriptar((String) json.get("idUsuairo"))));
            ciclo.setNombre((String) json.get("nombreCuestionario"));
            ciclo.setDescripciom((String) json.get("descripcion"));
            int estado = 0;
            if((Boolean) json.get("estado")){
              estado = 1;
            } else {
                estado = 0;
            }
            ciclo.setEstado(estado);
            //Extraemos todas las listas del JSON 
            JSONArray JSONEmpleados = (JSONArray) json.get("empleados");
            for(int i = 0; i < JSONEmpleados.size(); i++){
                
                String idEmploy = null;
                JSONObject JSONEmpleado = (JSONObject) JSONEmpleados.get(i);  
                idEmploy = (String) JSONEmpleado.get("idEmpleado");
                System.out.print("Entro "+idEmploy);
                listaEmpleado.add(idEmploy);
            }
        }
        
    }catch(Exception e){
        ciclo = null;
        listaEmpleado = null;
    }
    resultado = _ciclo.SaveorUpdateCuestionario_gestion(ciclo, listaEmpleado);

    if (resultado.equalsIgnoreCase("Ok")) {
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
<%} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>