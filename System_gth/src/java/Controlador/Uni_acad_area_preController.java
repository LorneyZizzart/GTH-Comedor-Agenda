package Controlador;

import Entidad.Uni_acad_area_pre;
import java.util.List;

public class Uni_acad_area_preController {

    /*
    Traemos un objeto Uni_acad_area_pre 
    Requerimos las variables;
    -Gestion
    -Unidad_academica_id
     */
    public Uni_acad_area_pre GetAreaPregunta(String gestion, String unidad_id) {
        Modelo.Uni_acad_area_preModel mod = new Modelo.Uni_acad_area_preModel();
        return mod.GetAreaPregunta(gestion, unidad_id);
    }

    /*
        Traemos el nombre del area de las preguntas
        traemos una lista de de todas las coincidencias de las en que que encuente al 
        empleado y la gestion , para esto requerimos los siguientes datos
        -Empleado_id
        -Gestion
        
     */
    public List<Uni_acad_area_pre> GetProfAreasNota(String Empleado_id, String Gestion) {
        Modelo.Uni_acad_area_preModel mod = new Modelo.Uni_acad_area_preModel();
        return mod.GetProfAreasNota(Empleado_id, Gestion);
    }
}
