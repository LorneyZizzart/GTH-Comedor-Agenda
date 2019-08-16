/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.C_Empleado_Reserva;
import Entidad.C_TipoComensal;
import Modelo.C_EmpleadoReservaModel;
import java.util.List;

/**
 *
 * @author pc
 */
public class C_EmpleadoReservaController {
    
    public List<C_TipoComensal> getReservasForParams(String fechaInicio, String fechaFinal, List<String> idsComensal, List<String> idsComidas) {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        String date1[] =  fechaInicio.split("/");
        String date2[] = fechaFinal.split("/");
        String dateStart =  date1[2]+"/"+date1[1]+"/"+date1[0];
        String dateEnd = date2[2]+"/"+date2[1]+"/"+date2[0];
        String query = "";
        
        if(dateStart.equals(dateEnd)){
            query = " AND er.Fecha = '" + dateStart+"' ";
        }else{
            query = " AND er.Fecha BETWEEN '"+dateStart+"' AND '"+dateEnd+"' ";
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
        query = query + ")";        
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
    public List<C_TipoComensal> getAllReservaEmpleado() {
        C_EmpleadoReservaModel mod = new C_EmpleadoReservaModel();
        return mod.getAllReservaEmpleado();
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
    
}
