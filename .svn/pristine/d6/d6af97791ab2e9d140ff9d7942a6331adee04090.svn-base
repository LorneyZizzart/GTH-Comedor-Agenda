package Controlador;

import Entidad.Cuestionario_empleado;
import Entidad.View_Empleado_Encuesta;
import java.util.List;

public class Cuestionario_empleadoController {

    public String AddCuestionarioEmpleadoByCuestionario_id(int cuestionario_id) {
        Modelo.Cuestionario_empleadoModelo mod = new Modelo.Cuestionario_empleadoModelo();
        return mod.AddCuestionarioEmpleadoByCuestionario_id(cuestionario_id);
    }

    public String CreateCuestionarioEmpleado(Cuestionario_empleado empleado) {
        Modelo.Cuestionario_empleadoModelo mod = new Modelo.Cuestionario_empleadoModelo();
        return mod.CreateCuestionarioEmpleado(empleado);
    }

    /*
    / eliminado a grupo de 
    / empleados que pertenecen a una encuesta 
    / requerimos el id del cuestionario
    / @Cuestionario_id
     */
    public String DeleteEmpleadoByCuestionario_id(int id) {
        Modelo.Cuestionario_empleadoModelo mod = new Modelo.Cuestionario_empleadoModelo();
        return mod.DeleteEmpleadoByCuestionario_id(id);
    }

    /*
    / Retornamos todos los empleados vinculados con la encuesta
    / terornamos la lista de Personas que se encuentaran
    / y ellos tiene su propia lista de 
    / Jefes
    / Pares
    / Bajos
    / Clientes
    / para esto requerimos el Cuestionario_id
     */
    public List<View_Empleado_Encuesta> GetEmpleadosEncuentaByCuestionarioID(int cuestionarioId) {
        Modelo.Cuestionario_empleadoModelo mod = new Modelo.Cuestionario_empleadoModelo();
        return mod.GetEmpleadosEncuentaByCuestionarioID(cuestionarioId);
    }

}
