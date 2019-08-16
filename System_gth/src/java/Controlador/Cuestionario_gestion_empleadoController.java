package Controlador;

import Modelo.Cuestionario_gestion_empleadoModelo;

public class Cuestionario_gestion_empleadoController {

    /*
    / Eliminamos a un empleado de la gestion 
    / para esto requerimos le id 
    / - Cuestionario_gestion_empleado_id
     */
    public String DeleteEmpledadodeGestion(int Cuestionario_gestion_empleado_id) {
        Cuestionario_gestion_empleadoModelo mod = new Cuestionario_gestion_empleadoModelo();
        return mod.DeleteEmpledadodeGestion(Cuestionario_gestion_empleado_id);
    }
}
