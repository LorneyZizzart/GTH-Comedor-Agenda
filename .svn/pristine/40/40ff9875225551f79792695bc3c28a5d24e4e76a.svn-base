<%@page import="Modelo.C_EmpleadoReservaModel"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="Entidad.C_Empleado_Reserva"%>
<%@page import="Entidad.C_TipoComensal"%>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController" />
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController" />
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController"/>
<%     
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    listaComensal = _tipoComensal.getAllTipoComensal();
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String resultado = "";
    Calendar calendar = Calendar.getInstance();
    //variable para obtener la fecha de hoy
    Calendar dateNow = Calendar.getInstance();
    try {        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStart = formatter.parse(request.getParameter("fechaInicio"));
        Date dateEnd = formatter.parse(request.getParameter("fechaFin"));
//        System.out.print("dateStart "+dateStart);
        int dias=(int) ((dateEnd.getTime()-dateStart.getTime())/86400000);
//        System.out.print("dias "+dias);   
        
        for(C_TipoComida tipoComida : listaTipoComida){
            if(request.getParameter("cantidad"+tipoComida.getNombreComida())!= null){
                empleadoReserva.setIdTipoComida(tipoComida.getIdTipoComida());
                empleadoReserva.setIdUser(Integer.parseInt(request.getParameter("idUsuario")));//OK
//                se habilitara la opcion de cantidades cuando se registren la cantidad de miembros en la familia
//                empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad"+tipoComida.getNombreComida())));
                empleadoReserva.setCantidad(1);

                empleadoReserva.setObservacion(String.valueOf(request.getParameter("observacion")));
                calendar.setTime(dateStart);
                for(int i = 1; i <= dias; i++){                    
                    for(C_TipoComensal item : listaComensal){
                        if(calendar.get(Calendar.DATE) >= item.getDiaInicio() && item.getEstado() == 1){
                            empleadoReserva.setIdTipoComensal(item.getTipoComensal_id());
                        }
//                        else if(dateNow.get(Calendar.MONTH) != calendar.get(Calendar.MONTH) && item.getEstado() == 1){
//                            empleadoReserva.setIdTipoComensal(item.getTipoComensal_id());
//                        }
                    }
//                    System.out.print("fechas: "+calendar.getTime());
//                    se suma un 1 al MONTH porque los meses de calendar inician con 0
//                    System.out.print(i+" fechas: "+calendar.get(Calendar.YEAR)+"/"+Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)+1))+"/"+calendar.get(Calendar.DATE));
                    empleadoReserva.setFecha(calendar.get(Calendar.YEAR)+"/"+Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)+1))+"/"+calendar.get(Calendar.DATE));
                    resultado = _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
                    calendar.add(Calendar.DATE, 1);
                }
            }
        }   
    }catch(Exception e){
        resultado = "Se ha producido "+e+" un error al registrar la reserva.";
        System.out.print("Error: Se ha producido un error al registrar la reserva. " + e);
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
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Error: <%=resultado%>
</div>
<%    }   %>
