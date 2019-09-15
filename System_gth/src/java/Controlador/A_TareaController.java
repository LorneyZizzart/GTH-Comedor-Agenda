/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.A_RepeticionTarea;
import Entidad.A_Tarea;
import Controlador.A_RepeticionTareaController;
import Modelo.AFileUploadHandler;
import Modelo.A_TareaModel;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Invitado1
 */
public class A_TareaController {
    public List<A_Tarea> getAllTarea(int idUsuario, int idRepeticion) throws ParseException {        
        A_TareaModel x = new A_TareaModel();
        String setenciaSql = null;
        Calendar calendar = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        SimpleDateFormat parseador = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        Date date = new Date();
        calendar.setTime(date);
        calendarEnd.setTime(date);        
        switch(idRepeticion){
            case 1:
//                hoy = 1
                setenciaSql = " AND ta.fechaInicio = '"+calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE)+"'";
                break;
            case 2:
//                Semanal = 2
                calendar.add(Calendar.DATE, -(calendar.get(Calendar.DAY_OF_WEEK)-1));
                calendarEnd.add(Calendar.DATE, 7);
                setenciaSql = " AND ta.fechaInicio between '"+calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE)+"' and '"+calendarEnd.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.DATE)+"'";
                break;
            case 3:
//                Quincenal = 3
                calendar.add(Calendar.DATE, -(calendar.get(Calendar.DAY_OF_WEEK)-1));
                calendarEnd.add(Calendar.DATE, 15);
                setenciaSql = " AND ta.fechaInicio between '"+calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE)+"' and '"+calendarEnd.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.DATE)+"'";
                break; 
            case 4:
//                Mensual = 4
                calendar.add(Calendar.DATE, -(calendar.get(Calendar.DAY_OF_WEEK)-1));
                calendarEnd.add(Calendar.MONTH, 1);
                setenciaSql = " AND ta.fechaInicio between '"+calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE)+"' and '"+calendarEnd.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.DATE)+"'";
                break;
            case 5:
//                Semestral = 5
                calendar.add(Calendar.DATE, -(calendar.get(Calendar.DAY_OF_WEEK)-1));
                calendarEnd.add(Calendar.MONTH, 6);
                setenciaSql = " AND ta.fechaInicio between '"+calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE)+"' and '"+calendarEnd.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.DATE)+"'";
                break;
            case 6:
//                Anual = 6
                calendar.add(Calendar.DATE, -(calendar.get(Calendar.DAY_OF_WEEK)-1));
                calendarEnd.add(Calendar.YEAR, 1);
                setenciaSql = " AND ta.fechaInicio between '"+calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE)+"' and '"+calendarEnd.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.DATE)+"'";
                break;  
            default:
                setenciaSql = "";
        }
        
        setenciaSql = setenciaSql + " ORDER BY ta.fechaInicio ASC";
        return x.getAllTarea(idUsuario, setenciaSql);
    }
    
    public A_Tarea getTareaById(int idTarea) throws ParseException {
        A_TareaModel mod = new A_TareaModel();
        return mod.getTareaById(idTarea);
    }
    
    public String UpdateTarea(A_Tarea tarea){
        A_TareaModel mod = new A_TareaModel();
        return mod.SaveOrUpdate(tarea);
    }
    
    public String DeleteTareaById(int idTarea) {
        A_TareaModel mod = new A_TareaModel();
        return mod.DeleteTarea(idTarea);
    }
    
    public String SaveTarea(A_Tarea tarea) throws ParseException{
        A_TareaModel mod = new A_TareaModel();
        String resultado = null;
        Calendar calendarStart = Calendar.getInstance();
        SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
        A_RepeticionTareaController _repeticionTarea = new A_RepeticionTareaController();
        List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
        listaRepeticionTarea =  _repeticionTarea.getAllRepeticionTarea();
        Date dateStart = parseador.parse(tarea.getFechaInicio());
        calendarStart.setTime(dateStart);
        for(A_RepeticionTarea r : listaRepeticionTarea){
            if(r.getIdRepeticionTarea() == tarea.getIdRepeticionTarea()){
                if(r.getSumarDias() == 0 && r.getSumarMes() == 0 && r.getSumarYear() == 0){return mod.SaveOrUpdate(tarea);}
                else{
                    if(r.getIdRepeticionTarea() == 3){
                        String[] strDays = new String[]{"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
                        
                        while (calendarStart.get(Calendar.YEAR) <= 2019) {
                            switch(strDays[calendarStart.get(Calendar.DAY_OF_WEEK) - 1]){
                                case "Domingo" :
                                    if(tarea.getDomingo() == 1){
                                        dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                        tarea.setFechaInicio(parseador.format(dateStart));
                                        resultado = mod.SaveOrUpdate(tarea);
                                    }                                    
                                    break;
                                case "Lunes" :
                                    if(tarea.getLunes() == 1){
                                        dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                        tarea.setFechaInicio(parseador.format(dateStart));
                                        resultado = mod.SaveOrUpdate(tarea);
                                    } 
                                    break;
                                case "Martes" :
                                    if(tarea.getMartes() == 1){
                                        dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                        tarea.setFechaInicio(parseador.format(dateStart));
                                        resultado = mod.SaveOrUpdate(tarea);
                                    } 
                                    break;
                                case "Miercoles" :
                                    if(tarea.getMiercoles() == 1){
                                        dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                        tarea.setFechaInicio(parseador.format(dateStart));
                                        resultado = mod.SaveOrUpdate(tarea);
                                    } 
                                    break;
                                case "Jueves" :
                                    if(tarea.getJueves() == 1){
                                        dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                        tarea.setFechaInicio(parseador.format(dateStart));
                                        resultado = mod.SaveOrUpdate(tarea);
                                    } 
                                    break;    
                                case "Viernes" :
                                    if(tarea.getViernes() == 1){
                                        dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                        tarea.setFechaInicio(parseador.format(dateStart));
                                        resultado = mod.SaveOrUpdate(tarea);
                                    } 
                                    break; 
                                case "Sabado" :
                                    if(tarea.getSabado() == 1){
                                        dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                        tarea.setFechaInicio(parseador.format(dateStart));
                                        resultado = mod.SaveOrUpdate(tarea);
                                    } 
                                    break;   
                            }
                            
                           calendarStart.add(Calendar.DATE, 1);
                       }
                        
                    }else if(r.getIdRepeticionTarea() == 2  || r.getIdRepeticionTarea() == 6 || r.getIdRepeticionTarea() == 4){
                       while (calendarStart.get(Calendar.YEAR) <= 2019) {
                           dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                           tarea.setFechaInicio(parseador.format(dateStart));
                           resultado = mod.SaveOrUpdate(tarea);
                           calendarStart.add(Calendar.DATE, r.getSumarDias());
                           calendarStart.add(Calendar.MONTH, r.getSumarMes());
                       }
                   }else if(r.getIdRepeticionTarea() == 5 || r.getIdRepeticionTarea() == 7){
                        for (int i = 0; i < 10; i++) {
                           dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                           tarea.setFechaInicio(parseador.format(dateStart));
                           resultado = mod.SaveOrUpdate(tarea);
                           calendarStart.add(Calendar.MONTH, r.getSumarMes());
                           calendarStart.add(Calendar.YEAR, r.getSumarYear());
                        }
                   }
                   
               }
            }
        }
        return resultado;
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
    
    
    
    public List<A_Tarea> getAllTareaCalendar(int idUsuario) throws ParseException {        
        A_TareaModel x = new A_TareaModel();
        List<A_Tarea> tareas = new ArrayList<A_Tarea>();
        tareas = x.getAllTarea(idUsuario, "");
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
    
    public void UploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        AFileUploadHandler mod = new AFileUploadHandler();
        try {
                mod.doPost( request, response);
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            } 
        
    }
    
}
