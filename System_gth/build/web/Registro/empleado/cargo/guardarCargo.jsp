<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidad.Empleado_cargo"%>
<jsp:useBean id="_cargo" class="Controlador.Empleado_cargoController"/>
<%
    Empleado_cargo cargo = new Empleado_cargo();
    cargo.setEmpleado_id(Integer.parseInt(request.getParameter("idEmpleado")));
    cargo.setDepartamento_id(Integer.parseInt(request.getParameter("idDepartamento")));
    cargo.setNivel_id(Integer.parseInt(request.getParameter("idNivel")));
    cargo.setCargo(request.getParameter("cargo"));
    cargo.setFecha_inicio(request.getParameter("fechaInicio"));
    cargo.setCargo_id(Integer.parseInt(request.getParameter("idCargo")));
    //cambiar a null
    String resultado = "";
    String fechaFinal = null;
    try{
        if(request.getParameter("fechaFinal") != null){
            fechaFinal = request.getParameter("fechaFinal");
        }
        
    }catch(Exception e){
        fechaFinal = null;
    }
    cargo.setFecha_fin(fechaFinal);
    
    if(request.getParameter("opcion").equals("editar")){
        cargo.setId(Integer.parseInt(request.getParameter("id")));

        int estado = 0;
        try {
            if(request.getParameter("estado").equalsIgnoreCase("on"))
            estado = 1;
            else estado = 0;
        }catch(Exception e){
            estado = 0;
        }
        cargo.setActivo(estado);
        
        resultado = _cargo.UpdateEmpleado_cargo(cargo);
    }else resultado = _cargo.CreateEmpleadoCargo(cargo);
     
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
<%
} else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Error: <%=resultado%>
</div>
<%    }   %>
