package Controlador;

import Entidad.Uni_acad_pre;
import Modelo.Uni_acad_preModel;

import java.util.List;

public class Uni_acad_preController {

    /*
        Traemos las preguntas deacuerdo al area que
        pertenece, listara deacuerdo al orden dado y que se encuentren es estado 1, 
        para esto requerimos la variable
        -   Area = Uni_acad_area_pre_id
     */
    public List<Uni_acad_pre> getPreguntasByArea(String area) {
        Uni_acad_preModel mod = new Uni_acad_preModel();
        return mod.getPreguntasByArea(area);
    }

    public String ImportaNotaSisAcad(String doc_uab, String docente_id, String area_id, String gestion) {
        Uni_acad_preModel mod = new Uni_acad_preModel();
        return mod.ImportaNotaSisAcad(doc_uab, docente_id, area_id, gestion);
    }

    /*
        Traemos la lista de preguntas mas las notas el color y en que estado esta(bueno, excelente....)
        para esto requerimos el 2 valores
        - Empleado_docente_id
        - Uni_acad_area_pre_id
     */
    public List<Uni_acad_pre> getPreguntasAndNota(String Empleado_id, String Uni_acad_area_pre_id,String gestion) {
        Uni_acad_preModel mod = new Uni_acad_preModel();
        return mod.getPreguntasAndNota(Empleado_id, Uni_acad_area_pre_id, gestion);
    }
}
