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
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class A_TareaController {
    public List<A_Tarea> getAllTarea(int idUsuario, int idRepeticion, String fIniio, String fFinal) throws ParseException {        
        A_TareaModel x = new A_TareaModel();
        String setenciaSql = " ";
        String sentenciaUser = " ";
        Calendar calendar = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
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
                calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
                calendarEnd.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
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
                setenciaSql = " AND ta.fechaInicio between '"+calendar.get(Calendar.YEAR)+"/01/01' and '"+calendar.get(Calendar.YEAR)+"/12/31'";
                break;  
            case 7:
//                Predeterminado = 6
                calendar.setTime(parseador.parse(fIniio));
                calendarEnd.setTime(parseador.parse(fFinal));
                setenciaSql = " AND ta.fechaInicio between '"+calendar.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.DATE)+"' and '"+calendarEnd.get(Calendar.YEAR)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.DATE)+"'";
                break; 
            default:
                setenciaSql = "";
        }
        
        setenciaSql = setenciaSql + " ORDER BY ta.fechaInicio ASC";
        if(idUsuario != 0){
            sentenciaUser = " AND ta.idUsuarioCrea = " + idUsuario + " ";
        }
        return x.getAllTarea(sentenciaUser, setenciaSql);
    }
    
    public List<A_Tarea> getGroupTareaByUser(int idUsuario){
        A_TareaModel mod = new A_TareaModel();
        String sentenciaUser = "";
        if(idUsuario != 0){
           sentenciaUser = " AND ta.idUsuarioCrea = " + idUsuario + " "; 
        }
        
        return mod.getGroupTareaByUser(sentenciaUser);
    }
    
    public A_Tarea getTareaById(int idTarea) throws ParseException {
        A_TareaModel mod = new A_TareaModel();
        return mod.getTareaById(idTarea);
    }
    
    public A_Tarea getTareaByTitulo(String titulo, int idUser) throws ParseException{
        A_TareaModel mod = new A_TareaModel();
        return mod.getTareaByTitulo(titulo, idUser );
    }   
    
    public A_Tarea getMaxIdTarea(){
        A_TareaModel mod = new A_TareaModel();
        return mod.getMaxIdTarea();
    }
    
    public String UpdateTarea(A_Tarea tarea, String oldTitulo, int oldIdUser){
        A_TareaModel mod = new A_TareaModel();
        return mod.SaveOrUpdate(tarea, oldTitulo, oldIdUser);
    }
    
    public String CambiarEstadoTarea(int idTarea, int idEstado) {
        A_TareaModel mod = new A_TareaModel();
        return mod.CambiarEstadoTarea(idTarea, idEstado);
    }
    
    public String DeleteTareaById(String titulo, int idUsuario) {
        A_TareaModel mod = new A_TareaModel();
        return mod.DeleteTarea(titulo, idUsuario);
    }
    
    
    
    public String SaveTarea(A_Tarea tarea) throws ParseException{
        A_TareaModel mod = new A_TareaModel();
        String resultado = null;
        if(Integer.parseInt(mod.searchTarea(tarea.getTitulo(), tarea.getIdUserCrea())) == 0){
            Calendar calendarStart = Calendar.getInstance();
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
            A_RepeticionTareaController _repeticionTarea = new A_RepeticionTareaController();
            List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
            listaRepeticionTarea =  _repeticionTarea.getAllRepeticionTarea();
            Date dateStart = parseador.parse(tarea.getFechaInicio());
            calendar.setTime(dateStart);
            calendarStart.setTime(dateStart);                            

            for(A_RepeticionTarea r : listaRepeticionTarea){
                if(r.getIdRepeticionTarea() == tarea.getIdRepeticionTarea()){
                    if(r.getSumarDias() == 0 && r.getSumarMes() == 0 && r.getSumarYear() == 0){return mod.SaveOrUpdate(tarea, null, 0);}
                    else{
                        if(r.getIdRepeticionTarea() == 3){
                            String[] strDays = new String[]{"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};

                            while (calendarStart.get(Calendar.YEAR) <= calendar.get(Calendar.YEAR)) {
                                switch(strDays[calendarStart.get(Calendar.DAY_OF_WEEK) - 1]){
                                    case "Domingo" :
                                        if(tarea.getDomingo() == 1){
                                            dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                            tarea.setFechaInicio(parseador.format(dateStart));
                                            resultado = mod.SaveOrUpdate(tarea, null, 0);
                                        }                                    
                                        break;
                                    case "Lunes" :
                                        if(tarea.getLunes() == 1){
                                            dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                            tarea.setFechaInicio(parseador.format(dateStart));
                                            resultado = mod.SaveOrUpdate(tarea, null, 0);
                                        } 
                                        break;
                                    case "Martes" :
                                        if(tarea.getMartes() == 1){
                                            dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                            tarea.setFechaInicio(parseador.format(dateStart));
                                            resultado = mod.SaveOrUpdate(tarea, null, 0);
                                        } 
                                        break;
                                    case "Miercoles" :
                                        if(tarea.getMiercoles() == 1){
                                            dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                            tarea.setFechaInicio(parseador.format(dateStart));
                                            resultado = mod.SaveOrUpdate(tarea, null, 0);
                                        } 
                                        break;
                                    case "Jueves" :
                                        if(tarea.getJueves() == 1){
                                            dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                            tarea.setFechaInicio(parseador.format(dateStart));
                                            resultado = mod.SaveOrUpdate(tarea, null, 0);
                                        } 
                                        break;    
                                    case "Viernes" :
                                        if(tarea.getViernes() == 1){
                                            dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                            tarea.setFechaInicio(parseador.format(dateStart));
                                            resultado = mod.SaveOrUpdate(tarea, null, 0);
                                        } 
                                        break; 
                                    case "Sabado" :
                                        if(tarea.getSabado() == 1){
                                            dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                                            tarea.setFechaInicio(parseador.format(dateStart));
                                            resultado = mod.SaveOrUpdate(tarea, null, 0);
                                        } 
                                        break;   
                                }

                               calendarStart.add(Calendar.DATE, 1);
                           }

                        }else if(r.getIdRepeticionTarea() == 2  || r.getIdRepeticionTarea() == 6 || r.getIdRepeticionTarea() == 4){
                           while (calendarStart.get(Calendar.YEAR) <= calendar.get(Calendar.YEAR)) {
                               dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                               tarea.setFechaInicio(parseador.format(dateStart));
                               resultado = mod.SaveOrUpdate(tarea, null, 0);
                               calendarStart.add(Calendar.DATE, r.getSumarDias());
                               calendarStart.add(Calendar.MONTH, r.getSumarMes());
                           }
                       }else if(r.getIdRepeticionTarea() == 5 || r.getIdRepeticionTarea() == 7){
                            for (int i = 0; i < 10; i++) {
                               dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                               tarea.setFechaInicio(parseador.format(dateStart));
                               resultado = mod.SaveOrUpdate(tarea, null, 0);
                               calendarStart.add(Calendar.MONTH, r.getSumarMes());
                               calendarStart.add(Calendar.YEAR, r.getSumarYear());
                            }
                       }

                   }
                }
            }
        }else{
            resultado = "El título de la tarea existe.";
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
               if(r.getSumarDias() == 0 && r.getSumarMes() == 0 && r.getSumarYear() == 0){return mod.SaveOrUpdate(tarea, null, 0);}
               else{
                   while(calendarEnd.before(calendarAuxEnd) || calendarEnd.equals(calendarAuxEnd)){                       
                       dateStart = parseador.parse(String.valueOf(calendarStart.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarStart.get(Calendar.MONTH)))+1)+"/"+calendarStart.get(Calendar.YEAR)));
                       dateEnd = parseador.parse(String.valueOf(calendarEnd.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendarEnd.get(Calendar.MONTH)))+1)+"/"+calendarEnd.get(Calendar.YEAR)));
                       tarea.setFechaInicio(parseador.format(dateStart));
                       tarea.setFechaFinal(parseador.format(dateEnd));
                       resultado = mod.SaveOrUpdate(tarea, null, 0);
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
    
    
    
    public List<A_Tarea> getAllTareaCalendar(int idUsuario)  {        
        A_TareaModel x = new A_TareaModel();
        return x.getAllTareaCalendar(idUsuario);
    }
    
    public A_Tarea getTareaPersonalById(int idTarea) {
        A_TareaModel mod = new A_TareaModel();
        return mod.getTareaPersonalById(idTarea);
    }
    
    public String saveTareaPersonal(A_Tarea tarea){
        A_TareaModel mod = new A_TareaModel();
        return mod.saveTareaPersonal(tarea);
    }
    
    public String ActualizarTareaPersonal(A_Tarea tarea, int idTarea){
        A_TareaModel mod = new A_TareaModel();
        return mod.ActualizarTareaPersonal(tarea, idTarea);
    }
    
    public String DeleteTareaPersonal(int idTarea){
        A_TareaModel mod = new A_TareaModel();
        return mod.DeleteTareaPersonal(idTarea);
    }
  
}
