/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.C_Empleado_Reserva;
import Entidad.C_TipoComensal;
import Entidad.Usuario;
import Modelo.C_EmpleadoReservaModel;
import Modelo.C_ComensalExterno;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class C_EmpleadoReservaController {
    
    public Usuario getUsuarioById(int idUsuario){
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.SearchUserData(idUsuario);
    }
    
    public List<C_TipoComensal> getReservasForParams(String fechaInicio, String fechaFinal, List<String> idsComensal, List<String> idsComidas, boolean orderAlpha, boolean orderDate, int idComensal) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        String date1[] =  fechaInicio.split("/");
        String date2[] = fechaFinal.split("/");
        String dateStart =  date1[2]+"/"+date1[1]+"/"+date1[0];
        String dateEnd = date2[2]+"/"+date2[1]+"/"+date2[0];
        String query = "";
        
        if(idComensal != 0){
            query = " AND er.IdEmpleado = " + idComensal + " ";
        }
        
        if(dateStart.equals(dateEnd)){
            query = query + " AND er.Fecha = '" + dateStart+"' ";
        }else{
            query = query + " AND er.Fecha BETWEEN '"+dateStart+"' AND '"+dateEnd+"' ";
        }
        query = query + " AND er.IdTipoComensal IN ( ";
        int i = 0;
        for(String c : idsComensal){
            if(i==0)
                query = query + c;
            else if(i>0)
                query = query + ", " + c;
            i++;
        }
        query = query + " ) AND er.IdTipoComida IN ( ";
        int f = 0;
        for(String a : idsComidas){
            if(f==0)
                query = query + a;
            if(f>0)
                query =  query + ", " + a;
            f++;
        }
        query = query + ") ";        
        
        if(orderAlpha == true && orderDate == true){
            query = query + " ORDER BY em.Apellido_paterno, er.Fecha ASC ";
        }else if(orderAlpha == true){
            query = query + " ORDER BY em.Apellido_paterno ASC ";
        }else if(orderDate == true){
            query = query + " ORDER BY er.Fecha ASC ";
        }        
        return mod.getReservasForParams(query);
    }
    /*
    / Realizamos un petición  de la lista de reservas realizadas por el empleado    
    / atraves del idUsuario y nos retorna cada objeto con los siguietes parametros
    / @getReservasEmpleado
    / -IdEmpleadoReserva 
    / -IdEmpleado
    / -IdTipoComida
    / -IdTipoComensal
    / -NombreComida
    / -Hora
    / -Costo
    / -Color
    / -Fecha
    / -Cantidad
    / -Estado 
    / -Observacion
    / -Cancelar
    / -FechaCancelacion
    / -fechaRegistro
    / -fechaActulizacion
    / -NombreComensal
    / -DescuentoComensal
    / -DiaInicioComensal
    / -NombreEmpleado
    / -TelefonoEmpleado
    */
    public List<C_TipoComensal> getAllReservaEmpleado(int idComensal, int ver, String fi, String ff, List<String> idsComensal, List<String> idsComidas) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        String query = "";
        
        if(idComensal != 0){
           query =  " AND er.IdEmpleado = " + idComensal + " ";
        }
        
        if(idsComensal.size() !=0 && Integer.parseInt(idsComensal.get(0)) != 0){
            query = query + " AND tco.Id IN ( ";
            int i = 0;
            for(String c : idsComensal){
                if(i==0)
                    query = query + c;
                else if(i>0)
                    query = query + ", " + c;
                i++;
            }
            query = query + " ) ";
        }
        
        if(idsComidas.size() !=0 && Integer.parseInt(idsComidas.get(0)) != 0){
            query = query + " AND tc.IdTipoComida IN ( ";
            int i = 0;
            for(String c : idsComidas){
                if(i==0)
                    query = query + c;
                else if(i>0)
                    query = query + ", " + c;
                i++;
            }
            query = query + " ) ";
        }
        
        switch(ver){
            case 1:
                Calendar calendar = Calendar.getInstance();
                Date date = new Date();
                calendar.setTime(date);
                query = query + "AND er.Fecha = '" + calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE) +"'";
                break;
            case 2:
                String date1[] =  fi.split("/");
                String date2[] = ff.split("/");
                String dateStart =  date1[2]+"/"+date1[1]+"/"+date1[0];
                String dateEnd = date2[2]+"/"+date2[1]+"/"+date2[0];
                query = query + "AND er.Fecha BETWEEN '" + dateStart +"' AND '"+dateEnd+"'";
                break;
        }            
        
        return mod.getAllReservaEmpleado(query);
    }
    
    public List<C_Empleado_Reserva> getReservaByIdDate(int idUsuario, String fecha){
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.getReservaByIdDate(idUsuario, fecha);
    }
    /*
    / Realizamos un petición  de la lista de reservas realizadas por el empleado    
    / atraves del idUsuario y nos retorna cada objeto con los siguietes parametros
    / @getReservasEmpleado
    / -IdEmpleadoReserva 
    / -IdEmpleado
    / -IdTipoComida
    / -IdTipoComensal
    / -Fecha
    / -Cantidad
    / -Estado 
    / -Observacion
    / -Cancelar
    / -FechaCancelacion
    / -fechaRegistro
    / -fechaActulizacion
     */
    public List<C_Empleado_Reserva> getReservasEmpleado(int idUsuario) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.getReservasEmpleado(idUsuario);
    }
    /*
    / Realizamos un petición  de una reserva del empleado    
    / atraves del idUsuario y la fecha y retorna un objeto con los siguietes parametros
    / @getReservasEmpleado
    / -IdEmpleadoReserva 
    / -IdEmpleado
    / -IdTipoComida
    / -IdTipoComensal
    / -Fecha
    / -Cantidad
    / -Estado 
    / -Observacion
    / -Cancelar
    / -FechaCancelacion
    / -fechaRegistro
    / -fechaActulizacion
     */
    public C_Empleado_Reserva getReservaEmpleadoById(int IdEmpleadoReserva) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.getReservaEmpleadoById(IdEmpleadoReserva);
    }
    /*
    / Realizamos la insercion  de ReservaEmpleado   
    / para realizar este registro se requiere los siguietes parametros
    / @ReservaEmpleado
    / -IdTipoComensal 
    / -IdUsuario
    / -Fecha
    / -Cantidad
    / -Observacion
    / -IdTipoComida
     */
    public String SaveEmpleadoReserva(C_Empleado_Reserva empleadoReserva) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.SaveReservaEmpleado(empleadoReserva);
    }
    /*
    / Realizamos la actualizacion  de ReservaEmpleado   
    / para realizar este registro se requiere los siguietes parametros
    / @ReservaEmpleado
    / -idReservaEmpleado 
    / {empleadoReserva}
    / -Cantidad 
    / -Observacion 
     */
    public String EditEmpleadoReservaById(int idReservaEmpleado, C_Empleado_Reserva empleadoReserva) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.EditReservaEmpleado(idReservaEmpleado, empleadoReserva);
    }
    
    public String EditEmpleadoReservaCalendario(int idReservaEmpleado, C_Empleado_Reserva empleadoReserva) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.EditReservaEmpleadoCalendario(idReservaEmpleado, empleadoReserva);
    }
    /*
    / Para eliminar la reserva necesitamos el ID de reserva   
    / seguira guardado en la DB solo se cambiara de estado a 6
    / @ReservaEmpleado [parametros]
    / -IdEmpleadoReserva
     */
    public String DeleteEmpleadoReserva(int idEmpleadoReserva){
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.DeleteReservaEmpleado(idEmpleadoReserva);
    }
    
    
//    lista todas las reservas que tengan la varible notificaion en 1
    public List<C_TipoComensal> getNotificaionesDeReservas(){
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.getReservasDeNotificaiones();
    }
    
//    COMENSAL EXTERNO
    
    public List<Usuario> getNombresComensalesExternos(){
        C_ComensalExterno mod = new C_ComensalExterno();
        return mod.getListComensalExterno();
    }
    
    public List<C_TipoComensal> getReservasExternasForParams(String fechaInicio, String fechaFinal, List<String> idsComensal, List<String> idsComidas, boolean orderAlpha, boolean orderDate, int idComensal) {
        C_ComensalExterno mod = new C_ComensalExterno();
        String date1[] =  fechaInicio.split("/");
        String date2[] = fechaFinal.split("/");
        String dateStart =  date1[2]+"/"+date1[1]+"/"+date1[0];
        String dateEnd = date2[2]+"/"+date2[1]+"/"+date2[0];
        String query = "";
        
        if(idComensal != 0){
            query = " AND cd.idComensalExterno  = " + idComensal + " ";
        }
        
        if(dateStart.equals(dateEnd)){
            query = query + " AND ce.Fecha = '" + dateStart+"' ";
        }else{
            query = query + " AND ce.Fecha BETWEEN '"+dateStart+"' AND '"+dateEnd+"' ";
        }
        query = query + " AND ce.IdTipoComensal IN ( ";
        int i = 0;
        for(String c : idsComensal){
            if(i==0)
                query = query + c;
            else if(i>0)
                query = query + ", " + c;
            i++;
        }
        query = query + " ) AND ce.IdTipoComida IN ( ";
        int f = 0;
        for(String a : idsComidas){
            if(f==0)
                query = query + a;
            if(f>0)
                query =  query + ", " + a;
            f++;
        }
        query = query + ") ";        
        
        if(orderAlpha == true && orderDate == true){
            query = query + " ORDER BY cd.nombreCompleto, ce.Fecha ASC ";
        }else if(orderAlpha == true){
            query = query + " ORDER BY cd.nombreCompleto ASC ";
        }else if(orderDate == true){
            query = query + " ORDER BY ce.Fecha ASC ";
        }        
        return mod.getReservasExternasForParams(query);
    }
    
    public List<C_TipoComensal> getAllComensalExterno(int ver, int idComensalExterno, String fi, String ff, List<String> idsComensal, List<String> idsComidas) {
        C_ComensalExterno mod = new C_ComensalExterno();
        String query = "";
        
        if(idsComensal.size() !=0 && Integer.parseInt(idsComensal.get(0)) != 0){
            query = query + " AND tc.Id IN ( ";
            int i = 0;
            for(String c : idsComensal){
                if(i==0)
                    query = query + c;
                else if(i>0)
                    query = query + ", " + c;
                i++;
            }
            query = query + " ) ";
        }
        
        if(idComensalExterno !=0 ){
            query = query + " AND ce.idComensalExterno = " + idComensalExterno + " ";
        }
        
        if(idsComidas.size() !=0 && Integer.parseInt(idsComidas.get(0)) != 0){
            query = query + " AND tco.IdTipoComida IN ( ";
            int i = 0;
            for(String c : idsComidas){
                if(i==0)
                    query = query + c;
                else if(i>0)
                    query = query + ", " + c;
                i++;
            }
            query = query + " ) ";
        }
        
        switch(ver){
            case 1:
                Calendar calendar = Calendar.getInstance();
                Date date = new Date();
                calendar.setTime(date);
                query = query + "AND ce.Fecha = '" + calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE) +"'";
                break;
            case 2:
                String date1[] =  fi.split("/");
                String date2[] = ff.split("/");
                String dateStart =  date1[2]+"/"+date1[1]+"/"+date1[0];
                String dateEnd = date2[2]+"/"+date2[1]+"/"+date2[0];
                query = query + "AND ce.Fecha BETWEEN '" + dateStart +"' AND '"+dateEnd+"'";
                break;
        }  
        return mod.getAllComensalExterno(query);
    }
    
    public C_Empleado_Reserva getReservaExternoById(int IdEmpleadoReserva) {
        C_ComensalExterno mod = new C_ComensalExterno();
        return mod.getReservaExternoById(IdEmpleadoReserva);
    }
    
    public List<C_Empleado_Reserva> getReservaExternoByIdDate(int idUsuario, String fecha, int idTipoComida){
        C_ComensalExterno mod = new C_ComensalExterno();
        return mod.getReservaExternaByIdDate(idUsuario, fecha, idTipoComida);
    }
    
    public String SaveComensalExterno(int calidad, C_Empleado_Reserva empleadoReserva) {
        C_ComensalExterno mod = new C_ComensalExterno();
        if(calidad == 0){
            String insertComensalExterno = mod.SaveComensalExterno(empleadoReserva);
            if(insertComensalExterno.equalsIgnoreCase("Ok")){
                int idComensal = mod.getMaxComensalExterno();
                if(idComensal != 0){
                    return mod.SaveReservaExterno(idComensal, empleadoReserva);
                }else{
                    return "No se logro obtener el ultimo registro de comensal externo";
                }
            }else{
                return insertComensalExterno;
            }  
        }else{
            return mod.SaveReservaExterno(empleadoReserva.getIdEmpleado(), empleadoReserva);
        }
      
    }
    
     public String EditReservaExterno(int idReservaEmpleado, C_Empleado_Reserva empleadoReserva) {
        C_ComensalExterno mod = new C_ComensalExterno();
        return mod.EditReservaExteno(idReservaEmpleado, empleadoReserva);
    }
     
     public String DeleteReservaExterna(int idReservaExterna){
        C_ComensalExterno mod = new C_ComensalExterno();
        return mod.DeleteReservaExterno(idReservaExterna);
    }
      
}
