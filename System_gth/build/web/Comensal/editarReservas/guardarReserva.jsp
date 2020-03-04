<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="Entidad.C_Empleado_Reserva"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController" />
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController" />
<%
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    List<C_Empleado_Reserva> reservasNow = new ArrayList<C_Empleado_Reserva>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String resultado = "";
    try{
        
        
        Date date = formatter.parse(request.getParameter("fi"));
        calendar.setTime(date);
        empleadoReserva.setFecha(calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
        int tipoComensal = 1;
        if(Integer.parseInt(request.getParameter("tipoComensal")) == 1){
            tipoComensal = 2;
        }
        empleadoReserva.setIdTipoComensal(tipoComensal);
        empleadoReserva.setNotificacion(0);
        empleadoReserva.setListarNotifiacion(0);
        empleadoReserva.setObservacion(request.getParameter("observacion"));


        if(Integer.parseInt(request.getParameter("funcionario")) == 1){
            empleadoReserva.setIdUser(Integer.parseInt(request.getParameter("idEmpleado")));
            reservasNow = _empleadoReserva.getReservaByIdDate(empleadoReserva.getIdUser(), calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
            if(reservasNow.size() > 0){
                for(C_TipoComida item : reservasNow){
                    if(item.getIdTipoComida() != Integer.parseInt(request.getParameter("idTipoComida"))){
                        empleadoReserva.setIdTipoComida(Integer.parseInt(request.getParameter("idTipoComida")));
                        empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                        resultado = _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
                    }else{
                        resultado = "La reserva para el " + item.getNombreComida() +" se encuentra registrado en la fecha eligida";
                    }
                }
            }else{
                empleadoReserva.setIdTipoComida(Integer.parseInt(request.getParameter("idTipoComida")));
                empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                resultado = _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
            }          

        }else{
            if(Integer.parseInt(request.getParameter("idCalidad")) == 0){
                empleadoReserva.setNombreCompleto(request.getParameter("nombreCompleto"));
                try{
                    empleadoReserva.setCelular(Integer.parseInt(request.getParameter("celular")));
                    empleadoReserva.setIdTipoComida(Integer.parseInt(request.getParameter("idTipoComida")));                       
                    resultado = _empleadoReserva.SaveComensalExterno(Integer.parseInt(request.getParameter("idCalidad")), empleadoReserva);
                }catch(Exception e){} 
            }else{
                try{
                    empleadoReserva.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleadoExterno")));
                    reservasNow = _empleadoReserva.getReservaExternoByIdDate(empleadoReserva.getIdEmpleado(), calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE), Integer.parseInt(request.getParameter("idTipoComida")));

                    if(reservasNow.size() > 0){                        
                        boolean entrar = false;
                        for(C_TipoComida item : reservasNow){
                            if(item.getIdTipoComida() == Integer.parseInt(request.getParameter("idTipoComida"))){
                                System.out.print("entro1");
                                entrar = false;
                            }else{
                                entrar = true;
                                System.out.print("entro2");
                                empleadoReserva.setNombreComida(item.getNombreComida());
                            }
                        }
                        if(entrar == true){
                            empleadoReserva.setIdTipoComida(Integer.parseInt(request.getParameter("idTipoComida")));
                            empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                            resultado = _empleadoReserva.SaveComensalExterno(Integer.parseInt(request.getParameter("idCalidad")),empleadoReserva);
                        }else{
                            resultado = "La reserva del la comida seleccionada se encuentra registrado en la fecha eligida";
                        }
                        
                        
                    }else{
                        empleadoReserva.setIdTipoComida(Integer.parseInt(request.getParameter("idTipoComida")));                       
                        resultado = _empleadoReserva.SaveComensalExterno(Integer.parseInt(request.getParameter("idCalidad")), empleadoReserva);
                    }
                }catch(Exception e){}                
            }
            
        }
    }catch(Exception e){
        resultado = "No se obtuvo todos los datos: " + e;
        System.out.print("No se obtuvo todos los datos: " + e);
    }
    if(resultado.equalsIgnoreCase("Ok")){
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Reserva realizada</h4>
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
<div class="alert alert-warning alert-dismissible">
    <button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%    }   %>