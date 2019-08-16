package Controlador;

import Entidad.Departamento;
import Entidad.Empleado_cargo;
import Modelo.DepartamentoModel;
import java.util.List;

public class DepartamentoController {

    /*Realizamos la insercion y la actualizacion
    *  @Insertamos cuando el valos del Departamento_id =0 
    *   tambien para esto nesecitamos los campos 
    *   -Nombre
    *   -Estado
    *   -Area_id
    *   -Departamento_id_aux
    *  @Actualizamos cuando el valor del Departamento_id >0 
    *   tambien para esto nesecitamos los campos 
    *   -Nombre
    *   -Estado
    *   -Area_id
    *   - Departamento_id_aux
    * Para el campo Departamento_id_aux cuando mando un valor
    * = 0 no lo inserta, lo deja el valor null
     */
    public String SaveOrUpdateDepartamento(Departamento dep) {
        DepartamentoModel mod = new DepartamentoModel();
        return mod.SaveOrUpdateDepartamento(dep);
    }

    /*
    * Trae todos los departamentos
    * retorna una lista con los departamentos
    * a esta lista se añadio do campos mas
    * @ Area_Nombre Como tiene relacion con la 
    *   tabla Area, en este campos se recupera el nombre
    * @ Departamento_Nombre_dep es una relacion de la misma tabla
    *   Departamento, retorna el nombre del departamento dependiente.
     */
    public List<Departamento> GetAllDepartamento() {
        DepartamentoModel mod = new DepartamentoModel();
        return mod.GetAllDepartamento();
    }

    /*
    * Traemos los datos de un departamento
    * Nesecitamos que se mande el Departamento_id
    * Departamento_id tiene que tener un valor 
     */
    public Departamento GetDepartamentoById(int id) {
        DepartamentoModel mod = new DepartamentoModel();
        return mod.GetDepartamentoById(id);
    }

    /*
    / Retornamos una lista de Departamento
    / la busqueda se realiza por el Area_id    
    / retorna los siguientes parametros
    / @Departamento
    / Departamento_id
    / Nombre
    / Estado
    / Area_id
     */
    public List<Departamento> GetAllDepartamentoByIdArea(int areaId) {
        DepartamentoModel mod = new DepartamentoModel();
        return mod.GetAllDepartamentoByIdArea(areaId);
    }

    /*
    / Para eliminar requerimos Departamento_id
    / Si elimina ist<Empleado_cargo> = 0
    / Si ist<Empleado_cargo> es > 0
    / Retorna una lista Empleado_cargo    
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
    public List<Empleado_cargo> DeleteDepartamento(int departamento_id) {
        DepartamentoModel mod = new DepartamentoModel();
        return mod.DeleteDepartamento(departamento_id);
    }
}
