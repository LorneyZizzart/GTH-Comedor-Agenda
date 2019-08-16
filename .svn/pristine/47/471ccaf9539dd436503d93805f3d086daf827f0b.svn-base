package Controlador;

import Entidad.Empleado_cargo;
import Modelo.Empleado_cargoModel;
import java.util.List;

public class Empleado_cargoController {

    /*
    / Selecionar Todos los Empleados
    / consus cargos
    / los que estan en @Activos = 1
     */
    public List<Empleado_cargo> GetAllEmpleadoCargo() {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.GetAllEmpleadoCargo();
    }

    /*
    / Trea un empleado deacuero al Empleado_id
    / la condicion es que el campo 
    / @Activo = 1
    / Alli retornada el cargo del empleado
     */
    public Empleado_cargo GetEmpleadoCargoByIdEmpleado(int empladoId) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.GetEmpleadoCargoByIdEmpleado(empladoId);
    }

    /*
    / Para la creagcion de un Enpleado_cargo
    / Nesecitamos los siguientes Parametros
    / @Empleado_cargo
    / Empleado_id
    / Departamento_id
    / Nivel_id
    / Cargo_id
    
     */
    public String CreateEmpleadoCargo(Empleado_cargo empleado) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.CreateEmpleadoCargo(empleado);
    }

    /*
    / Retornamos Una lista de los cargos que tiene un empleado Empleado_cargo
    / esta busqueda se realiza por el id Empleado_id
    / y nos retorna una lista con los siquientes parametros
    / @Enpleado_cargo
    / Id
    / Empleado_id
    / Empleado_Nombre
    / Departamento_id
    / Departamento_nombre
    / Nivel_id
    / Nivel_nombre
    / Cargo
    / Activo
     */
    public List<Empleado_cargo> GetAllEnpleado_cargoByEmpleadoId(int empleadoId) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.GetAllEnpleado_cargoByEmpleadoId(empleadoId);
    }

    /*
    / Para la Actualizacion de un Enpleado_cargo
    / Nesecitamos los siguientes Parametros
    / @Empleado_cargo
    / Id
    / Empleado_id
    / Departamento_id
    / Nivel_id
    / Cargo_id
    / Activo  si = 0 desactivado si =1 Activado
     */
    public String UpdateEmpleado_cargo(Empleado_cargo empleado) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.UpdateEmpleado_cargo(empleado);
    }

    /*
    / Eliminamos un registro de este empleado
    / para esto nesecitamos que se envie 
    / el siguietne
    / @Empleado_cargo
    / Id
     */
    public String DeleteEmpleado_cargo(int id) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.DeleteEmpleado_cargo(id);
    }

    /*
    / Retorna una lista Empleado_cargo
    / Se requeire el Nivel_id
    / Retorna los siguientes parameros
    / @Empleado_cargo
    / Id
    / Empleado_id
    / Empleado_nombre
    / Cargo
    / Activo
    / Nivel_id    
     */
    public List<Empleado_cargo> getAllEmpleado_cargoByNivel_id(int Nivel_id) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.getAllEmpleado_cargoByNivel_id(Nivel_id);
    }
    
    /*
    / Retorna una lista Empleado_cargo
    / Se requeire el Nivel_id
    / Retorna los siguientes parameros
    / @Empleado_cargo
    / Id
    / Empleado_id
    / Empleado_nombre
    / Cargo
    / Activo
    / Nivel_id    
    / Departamento_id
     */
    public List<Empleado_cargo> getAllEmpleado_cargoByDepartamento_id(int Departamento_id) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.getAllEmpleado_cargoByDepartamento_id(Departamento_id);
    }
    
    /*
    / Trea un empleado deacuero al id
    / la condicion es que el campo 
    / @Activo = 1
    / Alli retornada el cargo del empleado
     */
    public Empleado_cargo GetEmpleadoCargoByEnpleadoCargo_id(int Id) {
        Empleado_cargoModel emple = new Empleado_cargoModel();
        return emple.GetEmpleadoCargoByEnpleadoCargo_id(Id);
    }
}
