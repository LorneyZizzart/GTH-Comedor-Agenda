package Controlador;

import Entidad.Nivel;
import Entidad.Empleado_cargo;
import java.util.List;

public class NivelController {

    //Nos retorna toda la lista de la tabla Nivel
    public List<Nivel> getAllNivel() {
        Modelo.NivelModel op = new Modelo.NivelModel();
        return op.getAllNivel();
    }

    /*Realiza 2 acciones
    / Inserta: si mandamos Nivel_id = 0 
    / Actualiza: si mandamos Nivel_id con un valor >0
    / Requerimos los siguientes parametros
    / @Nivel
    / Nivel_id
    / Nombre
    / Estado    
    / Posicion
    */
    public String InsertOrUpdateNivel(Nivel nivel) {
        Modelo.NivelModel op = new Modelo.NivelModel();
        return op.InsertOrUpdateNivel(nivel);
    }

    //Retorna un objeto Nivel dependiendo que
    //Nivel_id se envie
    public Nivel getNivelById(int id) {
        Modelo.NivelModel op = new Modelo.NivelModel();
        return op.getNivelById(id);
    }

    /*
    / Se requeire el Nivel_id para eliminar
    / Elimina si List<Empleado_cargo> = 0
    / No elimina cuando existe Empleado_cargo
    / Si no elimina retorna los siguientes parameros
    / @Empleado_cargo
    / Id
    / Empleado_id
    / Empleado_nombre
    / Cargo
    / Activo
    / Nivel_id    
     */
    public List<Empleado_cargo> DeleteNivel(int nivelId) {
        Modelo.NivelModel op = new Modelo.NivelModel();
        return op.DeleteNivel(nivelId);
    }
}
