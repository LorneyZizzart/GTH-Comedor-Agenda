/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_RepeticionTarea;
import Entidad.A_Tarea;
import Controlador.A_RepeticionTareaController;
import Modelo.A_TareaModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Invitado1
 */
public class A_TareaController {
    public List<A_Tarea> getAllTarea(int idUsuario) {
        A_TareaModel x = new A_TareaModel();
        return x.getAllTarea(idUsuario);
    }
    
    public A_Tarea getTareaById(int idTarea) {
        A_TareaModel mod = new A_TareaModel();
        return mod.getTareaById(idTarea);
    }
    
    public String SaveOrUpdate(A_Tarea tarea){
        A_TareaModel mod = new A_TareaModel();
        return mod.SaveOrUpdate(tarea);
    }
    
    public String SaveOrUpdateCalendar(A_Tarea tarea) throws ParseException {
        A_TareaModel mod = new A_TareaModel();
        String resultado = null;
        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd= Calendar.getInstance();  
        Calendar calendarAuxEnd = Calendar.getInstance();
        SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
        A_RepeticionTareaController _repeticionTarea = new A_RepeticionTareaController();
        List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
        listaRepeticionTarea =  _repeticionTarea.getAllRepeticionTarea();
        Date dateStart = parseador.parse(tarea.getFechaInicio());
        Date dateEnd = parseador.parse(tarea.getFechaFinal());
        Date dateAuxEnd = parseador.parse(tarea.getAuxFechaFinal());
        calendarStart.setTime(dateStart);
        calendarEnd.setTime(dateEnd);
        calendarAuxEnd.setTime(dateAuxEnd);
        for(A_RepeticionTarea r : listaRepeticionTarea){
            if(r.getIdRepeticionTarea() == tarea.getIdRepeticionTarea()){
               if(r.getSumarDias() == 0 && r.getSumarMes() == 0 && r.getSumarYear() == 0){return mod.SaveOrUpdate(tarea);}
               else{
                   while(calendarEnd.before(calendarAuxEnd) || calendarEnd.equals(calendarAuxEnd)){                       
                       dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                       dateEnd = parseador.parse(String.valueOf(calendarEnd.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.YEAR)));
                       tarea.setFechaInicio(parseador.format(dateStart));
                       tarea.setFechaFinal(parseador.format(dateEnd));
                       resultado = mod.SaveOrUpdate(tarea);
                       calendarStart.add(Calendar.DATE, r.getSumarDias());
                       calendarStart.add(Calendar.MONTH, r.getSumarMes());
                       calendarStart.add(Calendar.YEAR, r.getSumarYear());
                       calendarEnd.add(Calendar.DAY_OF_MONTH, r.getSumarDias());
                       calendarEnd.add(Calendar.MONTH, r.getSumarMes());
                       calendarEnd.add(Calendar.YEAR, r.getSumarYear());
                   }
               }
               break;
            }
        }
        return resultado;
    }
    
    public String DeleteTareaById(int idTarea) {
        A_TareaModel mod = new A_TareaModel();
        return mod.DeleteTarea(idTarea);
    }
    
    public List<A_Tarea> getAllTareaCalendar(int idUsuario) {        
        A_TareaModel x = new A_TareaModel();
        List<A_Tarea> tareas = new ArrayList<A_Tarea>();
        tareas = x.getAllTarea(idUsuario);
        for(A_Tarea item : tareas){
            String[] fechaInicio = item.getFechaInicio().split("/");
            String[] fechaFinal = item.getFechaFinal().split("/");
            item.setFechaInicio(fechaInicio[2]+"-"+fechaInicio[1]+"-"+fechaInicio[0]);
            item.setFechaFinal(fechaFinal[2]+"-"+fechaFinal[1]+"-"+fechaFinal[0]);
            String horaInicio = item.getHoraInicio().replace(" ","");
            String horaFinal = item.getHoraFinal().replace(" ","");
            item.setHoraInicio(horaInicio.substring(0, 5));
            item.setHoraFinal(horaFinal.substring(0, 5));
        }
        return tareas;
    }
    
}