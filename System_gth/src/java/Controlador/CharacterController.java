package Controlador;

public class CharacterController {
    public static String CharacterUCFirst(String cadena){
        if(cadena == null || cadena.isEmpty()) return cadena;
        else return cadena.substring(0,1).toUpperCase() + cadena.substring(1);        
    }
}