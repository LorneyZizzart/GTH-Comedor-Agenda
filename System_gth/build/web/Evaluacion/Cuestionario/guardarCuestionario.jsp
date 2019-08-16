<%@page import="Entidad.Departamento"%>
<%@page import="Entidad.Area"%>
<%@page import="Entidad.Nivel"%>
<%@page import="java.util.*"%>
<%@page import="Entidad.Cuestionario"%>
<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController"/>
<%
    Cuestionario cuestionario = new Cuestionario();
    cuestionario.setCuestionario_id(Integer.parseInt(request.getParameter("id")));
    cuestionario.setUsuario_crea(Integer.parseInt(request.getParameter("idUsuario")));
    cuestionario.setNombre(request.getParameter("nombre"));
    cuestionario.setDetalle(request.getParameter("descripcion"));


    List<String> listaCargo = new ArrayList<String>();
    List<String> listaArea = new ArrayList<String>();
    List<String> listaDepartamento = new ArrayList<String>();
    
    try {
        if (request.getParameterValues("idCargo") != null) {
            String[] nivel = request.getParameterValues("idCargo");
            for (String s : nivel) {
                listaCargo.add(s);

            }
        }
        if (request.getParameterValues("idDepartamento") != null) {
            String[] departamento = request.getParameterValues("idDepartamento");
            for (String s : departamento) {
                listaDepartamento.add(s);
            }
        }

    } catch (Exception e) {
        listaCargo = null;
        listaArea = null;
        listaDepartamento = null;
    }
    
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
    
    cuestionario.setEstado(estado);

    String resultado = _cuestionario.CreateOrUpdateCuestionario(cuestionario, listaCargo, listaDepartamento);

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