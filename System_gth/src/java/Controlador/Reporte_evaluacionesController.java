package Controlador;

import Entidad.Cuestionario;
import java.util.List;

public class Reporte_evaluacionesController {

    /*
/ Taemos todos los cuestioanrio que se realizaron a un funancionario 
/ para esto requerimos los siguientes datos 
/ @ Cuestionario_gestion_id --es el id de la tabla Cuestionario_gestion
/ @ empleado_id  -- Es el id de la tabla empleado
     */
    public List<Cuestionario> GetAllCuestionario_Empleado(int Cuestionario_gestion_id, int empleado_id) {
        Modelo.Reporte_evaluacionesModelo mode = new Modelo.Reporte_evaluacionesModelo();
        return mode.GetAllCuestionario_Empleado(Cuestionario_gestion_id, empleado_id);
    }

    public Cuestionario GetCuestionario_Empleado_by_cuestionario_id(int cuestionario_id, int Cuestionario_gestion_id, int empleado_id) {
        Modelo.Reporte_evaluacionesModelo mode = new Modelo.Reporte_evaluacionesModelo();
        return mode.GetCuestionario_Empleado_by_cuestionario_id(cuestionario_id, Cuestionario_gestion_id, empleado_id);
    }
}
