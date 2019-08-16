package Controlador;

import Entidad.Sector_Cuestionario;
import Entidad.View_Sector_cuestionario;

public class Sector_CuestionarioController {

    public String CreateSector_cuestionario(Sector_Cuestionario sector) {
        Modelo.Sector_CuestionarioModel mod = new Modelo.Sector_CuestionarioModel();
        return mod.CreateSector_cuestionario(sector);
    }

    /*
    / Creamos un objeto View_Sector_cuestionario donde cargaremos todas
    / las areas que tenemmos 
    / Tendremos 
    / NIVELES
    / AREA
    / DEPARTAMENTO
    */
    public View_Sector_cuestionario GetAllAreasByCuestionario_id(int cuestionario_id) {
        Modelo.Sector_CuestionarioModel mod = new Modelo.Sector_CuestionarioModel();
        return mod.GetAllAreasByCuestionario_id(cuestionario_id);
    }
    
    /*
    / Elimanos Sector Cuestionario 
    /
    */
    
    public String DeleteSectorCuestionariobyCuestionarioId(int Cuestionario_id){
        Modelo.Sector_CuestionarioModel mod = new Modelo.Sector_CuestionarioModel();
        return mod.DeleteSectorCuestionariobyCuestionarioId(Cuestionario_id);
    }
    
}
