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
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    //variable para obtener la fecha de hoy
    Calendar fechaAnticipacion = Calendar.getInstance();
    Calendar fechaInicial = Calendar.getInstance();
    Date dateNow = formatter.parse(fechaAnticipacion.get(Calendar.DATE)+"/"+(fechaAnticipacion.get(Calendar.MONTH)+1)+"/"+fechaAnticipacion.get(Calendar.YEAR));
    fechaAnticipacion.setTime(dateNow);
    Boolean repeticion = false;
    try{
        if(request.getParameter("repetir").equalsIgnoreCase("on"))
        repeticion = true;
    }catch(Exception e){
        System.out.print("No se marco repetir todo el mes. " + e);
    }
    
    try {        
        Date dateStart = formatter.parse(request.getParameter("fechaInicio"));
        Date dateEnd = formatter.parse(request.getParameter("fechaFin"));
//        System.out.print("dateStart "+dateStart);
        int dias = 0;
        if(request.getParameter("fechaInicio").equals(request.getParameter("fechaFin"))){
            dias = 1;
        }else{
            dias=(int) ((dateEnd.getTime()-dateStart.getTime())/86400000);
        }        
//        System.out.print("dias "+dias);  
//        añadiendo dias de comensaul mensual
         fechaAnticipacion.add(Calendar.DATE, listaComensal.get(1).getDiasAnticipacion());
         
//        para registrar la diversidad de platos que envio el usuario
        for(C_TipoComida tipoComida : listaTipoComida){
            if(request.getParameter("cantidad"+tipoComida.getNombreComida())!= null){
                empleadoReserva.setIdTipoComida(tipoComida.getIdTipoComida());
                empleadoReserva.setIdUser(Integer.parseInt(request.getParameter("idUsuario")));//OK
//                se habilitara la opcion de cantidades cuando se registren la cantidad de miembros en la familia
                if(Integer.parseInt(request.getParameter("cantidad"+tipoComida.getNombreComida())) == 4){
                    empleadoReserva.setCantidad(3); 
                }else{
                    empleadoReserva.setCantidad(Integer.parseInt(request.getParameter("cantidad"+tipoComida.getNombreComida())));
                }
                
//                empleadoReserva.setObservacion(String.valueOf(request.getParameter("observacion")));
                
                if(empleadoReserva.getIdTipoComida() == 1){
                    empleadoReserva.setObservacion(String.valueOf(request.getParameter("observacionDes")));
                }
                if(empleadoReserva.getIdTipoComida() == 2){
                    empleadoReserva.setObservacion(String.valueOf(request.getParameter("observacionAlm")));
                }
                if(empleadoReserva.getIdTipoComida() == 3){
                    empleadoReserva.setObservacion(String.valueOf(request.getParameter("observacionCen")));
                }
                
//                si la reserva nesesita ser notificada -> Daniel
                if(empleadoReserva.getObservacion().equalsIgnoreCase("")){
                    empleadoReserva.setNotificacion(0);
                    empleadoReserva.setListarNotifiacion(0);
                }else{
                    empleadoReserva.setNotificacion(1);
                    empleadoReserva.setListarNotifiacion(1);

                }
                
                calendar.setTime(dateStart);
                fechaInicial.setTime(dateStart);
                for(int i = 1; i <= dias; i++){  
//                   System.out.print("fecha: "+calendar.getTime());  
                   
                    if(calendar.after(fechaAnticipacion) || calendar.equals(fechaAnticipacion)){
                        empleadoReserva.setIdTipoComensal(listaComensal.get(1).getTipoComensal_id());
                    }else{
                        empleadoReserva.setIdTipoComensal(listaComensal.get(0).getTipoComensal_id());
                    }                      
//                    System.out.print("Mes: "+((calendar.get(Calendar.MONTH))+1));
                    empleadoReserva.setFecha(calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
     
//                    System.out.print("fecha repeticion: "+empleadoReserva.getFecha()); 
                    resultado = _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
//                    resultado = "Ok";
                 
//                    calendar.add(Calendar.MONTH, -1);
                    calendar.add(Calendar.DATE, 1);
                }
//                se toma el ultimo dia de registro para la repeticion
                 int monthInitial = calendar.get(Calendar.MONDAY);  
                    while(repeticion == true){
                        fechaInicial.add(Calendar.DATE, 7);
                        calendar.setTime(fechaInicial.getTime());
//                        System.out.print("fecha repeticion: "+calendar.getTime()); 
                       
                        for(int i = 1; i <= dias; i++){  
                            if(monthInitial == calendar.get(Calendar.MONDAY)){
                                if(calendar.after(fechaAnticipacion) || calendar.equals(fechaAnticipacion)){
                                empleadoReserva.setIdTipoComensal(listaComensal.get(1).getTipoComensal_id());
                                }else{
                                    empleadoReserva.setIdTipoComensal(listaComensal.get(0).getTipoComensal_id());
                                }                      
//                                System.out.print("Mes: "+((calendar.get(Calendar.MONTH))+1));
                                empleadoReserva.setFecha(calendar.get(Calendar.YEAR)+"/"+((calendar.get(Calendar.MONTH))+1)+"/"+calendar.get(Calendar.DATE));
                              resultado = _empleadoReserva.SaveEmpleadoReserva(empleadoReserva);
//                                System.out.print("fecha repeticion: "+empleadoReserva.getFecha()); 
//                                resultado = "Ok";
                            }else{
                                repeticion = false;
                            }
                            calendar.add(Calendar.DATE, 1); 
                        }
                    }  
            }
        }   
    }catch(Exception e){
        resultado = "Se ha producido "+e+" un error al registrar la reserva.";
        System.out.print("Se ha producido un error al registrar la reserva." + e);
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
