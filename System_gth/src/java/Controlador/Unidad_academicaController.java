package Controlador;

import Entidad.Unidad_academica;
import Modelo.Unidad_academicaModel;
import java.util.List;

public class Unidad_academicaController {

    /*
    Trae todos las unidades academicas que estan en estado 1 activo
     */
    public List<Unidad_academica> GetAllUnidadAcademica() {
        Unidad_academicaModel mod = new Unidad_academicaModel();
        return mod.GetAllUnidadAcademica();
    }
}
