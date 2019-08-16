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
    
    try{
        if(request.getParameter("opcion").equals("editar")){
            ciclo.setCuestionario_gestion_id(Integer.parseInt(request.getParameter("id")));
            ciclo.setUsuario_crea(Integer.parseInt(_encript.ValorADesencriptar(request.getParameter("idUsuario"))));
            ciclo.setUsuario_actualiza(Integer.parseInt(_encript.ValorADesencriptar(request.getParameter("idUsuario"))));
            ciclo.setDescripciom(request.getParameter("nombre"));
            ciclo.setNombre(request.getParameter("nombre"));
            int estado = 0;
             try {
                if (request.getParameter("estado").equalsIgnoreCase("on")) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            } catch (Exception e) {
                estado = 0;
            }
            ciclo.setEstado(estado);
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