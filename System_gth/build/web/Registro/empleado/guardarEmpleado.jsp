<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="Entidad.Empleado_cargo"%>
<%@page import="Entidad.Empleado"%>
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController"/>
<%
    Empleado empleado = new Empleado();
    empleado.setEmpleado_id(Integer.parseInt(request.getParameter("id")));
    empleado.setNombre(request.getParameter("nombre"));
    empleado.setApellido_paterno(request.getParameter("apellidoPaterno"));    
    empleado.setApellido_materno(request.getParameter("apellidoMaterno"));
    empleado.setEmail(request.getParameter("email"));
    empleado.setTelefono(request.getParameter("telefono"));
    empleado.setEstado_civil_id(Integer.parseInt(request.getParameter("idEstadoCivil")));
    empleado.setPais_id(request.getParameter("idPais"));
    

    int estado = 0;
    try {
        if(request.getParameter("estado").equalsIgnoreCase("on"))
        estado = 1;
        else estado = 0;
    }catch(Exception e){
        estado = 0;
    }
    empleado.setEstado(estado);
    
    
       
    String resultado = "";
    
    if(Integer.parseInt(request.getParameter("id")) == 0){
        Empleado_cargo cargo = new Empleado_cargo();
        Calendar fecha = new GregorianCalendar();
        String fechaNow="", day="", month="";

        if(fecha.get(fecha.DATE)<10) day = "0"+Integer.toString(fecha.get(fecha.DATE));
        else day = Integer.toString(fecha.get(fecha.DATE));

        if(fecha.get(fecha.MONTH)<10) month = "0"+Integer.toString(fecha.get(fecha.MONTH));
        else month = Integer.toString(fecha.get(fecha.MONTH));

        fechaNow = day +"/"+month+"/"+Integer.toString(fecha.get(fecha.YEAR));

        cargo.setDepartamento_id(Integer.parseInt(request.getParameter("idDepartamento")));
        cargo.setNivel_id(Integer.parseInt(request.getParameter("idNivel")));
        cargo.setCargo_id(Integer.parseInt(request.getParameter("idCargo")));
        
        empleado.setCargo(cargo);
        //validacion de correo
        if(_empleado.validaCorreoEmpleado(empleado.getEmail())==0)        
            resultado = _empleado.CreateEmpleado(empleado);
        else resultado = "emailExiste";
    }
    else{ 
        Empleado empleadoObtenido = new Empleado();
        empleadoObtenido =  _empleado.GetEmpleadoByID(empleado.getEmpleado_id());
        //comparacion de email si el mismo del empleado
        if(empleado.getEmail().equalsIgnoreCase(empleadoObtenido.getEmail())){
            resultado = _empleado.UpdateEmpleado(empleado);
        }else{
            if(_empleado.validaCorreoEmpleado(empleado.getEmail()) == 0)
                resultado = _empleado.UpdateEmpleado(empleado);
            else resultado = "emailExiste";
        }
        
    }
        
    
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
} else if(resultado.equalsIgnoreCase("emailExiste")){
%>
            <div class="alert alert-danger">
                <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
                El correo <strong><%=empleado.getEmail()%></strong> se encuentra en uso.
            </div>
 <%    
}else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%    }   %>