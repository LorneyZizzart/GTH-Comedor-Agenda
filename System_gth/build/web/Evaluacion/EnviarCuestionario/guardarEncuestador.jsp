<%@page import="Entidad.Cliente"%>
<%@page import="java.sql.Array"%>
<%@page import="java.io.StringReader"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.FileReader"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.util.*"%>
<%@page import="Entidad.View_Empleado_Encuesta"%>
<jsp:useBean id="_cuestionarioEmpleado" class="Controlador.Cuestionario_empleadoController" />
<jsp:useBean id="_cuestionarioEvalua" class="Controlador.Cuestionario_evaluaController" />
<%
    int idCuestionario = 0, idEmpleado = 0, autoEvaluacion = 0;
    List<View_Empleado_Encuesta> encuesta = new ArrayList<View_Empleado_Encuesta>();
    JSONParser parser = new JSONParser();
 
    try{
          if(request.getParameter("Object") != null){            
            //Recuperamos el JSON con el nombre "Object" de la vista
            String js = request.getParameter("Object");
            //Convertimos a un objeto
            Object obj = parser.parse(new StringReader(js));
            //Asignamos a un objeto creado de tipo JSONObject
            JSONObject json = (JSONObject) obj;
            //Extraemos el id del cuestionario
            idCuestionario = Integer.parseInt((String) json.get("idCuestionario"));
            //extraemos a todos los funcionarios con sus respectivas listas de jefes-pares-bajos y clientes            
            JSONArray employess = (JSONArray) json.get("empleado");            
            
            for(int i = 0; i < employess.size(); i++){
            // Creamos un empleado para luego llenar la lista de encuesta que son los encuestadores
            View_Empleado_Encuesta empleado = new View_Empleado_Encuesta();
            //a cada empleado le asignamos la encuesta
            empleado.setCuestionario_id(idCuestionario);
            //Asignamos a cada funcionario a un objeto
            JSONObject employee = (JSONObject) employess.get(i);
            //Extraemos el id del empleado
            idEmpleado = Integer.parseInt((String) employee.get("idEmpleado"));
            //llenamos el objeto con el id correspondiente
            empleado.setEmpleado_id(idEmpleado);

            if(employee.get("autoEvaluacion").equals("on")){
                autoEvaluacion = 1;
            }else{
                autoEvaluacion = 0;
            }
            //Extraemos todas las listas del JSON 
            JSONArray JSONjefes = (JSONArray) employee.get("jefe");
            JSONArray JSONpares = (JSONArray) employee.get("par");
            JSONArray JSONbajos = (JSONArray) employee.get("bajo");
            JSONArray JSONclientes = (JSONArray) employee.get("cliente"); 
            //Iteramos cada lista del JSON para luego llenarlo al objeto empleado
            //Iteracion de la lista jefe
            for(int j = 0; j < JSONjefes.size(); j++){
                JSONObject JSONjefe = (JSONObject) JSONjefes.get(j);  
                List<View_Empleado_Encuesta> jefes = new ArrayList<View_Empleado_Encuesta>();
                try{
                    if(JSONjefe.get("idJefe") != null ){
                        JSONArray idj = (JSONArray) JSONjefe.get("idJefe");
                        for(int a = 0; a < idj.size(); a++){
                            View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
                            jefe.setEmpleado_id(Integer.parseInt((String) idj.get(a)));  
                            jefes.add(jefe);
                        }                        
                    }
                }catch (Exception e){
                    jefes = null;
                }
                empleado.setJefes(jefes);
            }
            //Iteracion de la lista par
            for(int p = 0; p < JSONpares.size(); p++){
                JSONObject JSONpar = (JSONObject) JSONpares.get(p);
                List<View_Empleado_Encuesta> pares = new ArrayList<View_Empleado_Encuesta>();
                try{
                    if(JSONpar.get("idPar") != null ){
                        JSONArray idp = (JSONArray) JSONpar.get("idPar");
                        for(int a = 0; a < idp.size(); a++){
                            View_Empleado_Encuesta par = new View_Empleado_Encuesta();
                            par.setEmpleado_id(Integer.parseInt((String) idp.get(a)));
                            pares.add(par);                       }
                        
                    }
                }catch (Exception e){
                    pares = null;
                }
                empleado.setPares(pares);
            }
            //Iteracion de la lista bajo
            for(int b = 0; b < JSONbajos.size(); b++){
                JSONObject JSONbajo = (JSONObject) JSONbajos.get(b);
                List<View_Empleado_Encuesta> bajos = new ArrayList<View_Empleado_Encuesta>();                
                try{
                    if(JSONbajo.get("idBajo") != null ){
                       JSONArray idb = (JSONArray) JSONbajo.get("idBajo");
                        for(int a = 0; a < idb.size(); a++){
                            View_Empleado_Encuesta bajo = new View_Empleado_Encuesta();
                            bajo.setEmpleado_id(Integer.parseInt((String) idb.get(a)));
                            bajos.add(bajo);
                        }                          
                    }
                }catch (Exception e){
                    bajos = null;
                }
                empleado.setBajos(bajos);
            }
            //Iteracion de la lista cliente
            for(int c = 0; c < JSONclientes.size(); c++){
                JSONObject JSONcliente = (JSONObject) JSONclientes.get(c);
                List<Cliente> clientes = new ArrayList<Cliente>();
                
                try{
                    if(JSONcliente.get("idCliente") != null ){
                       JSONArray idc = (JSONArray) JSONcliente.get("idCliente");
                        for(int a = 0; a < idc.size(); a++){
                            Cliente cliente = new Cliente();
                            cliente.setCliente_id(Integer.parseInt((String) idc.get(a)));
                            clientes.add(cliente);
                        }                         
                    }
                }catch (Exception e){
                    clientes = null;
                } 
                empleado.setClientes(clientes);
                } 
            encuesta.add(empleado);
            }
            
          }
    }catch (Exception e){
        idCuestionario = 0;
    }
    
    String resultado = _cuestionarioEvalua.SaveCuestionario_evalua(encuesta);

    if (resultado.equalsIgnoreCase("Ok")) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
//            location.reload();
        });
//        $("form")[0].reset();
    });
</script>
<%} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <p>ERROR: <%=resultado%></p>
</div>
<%}%>

