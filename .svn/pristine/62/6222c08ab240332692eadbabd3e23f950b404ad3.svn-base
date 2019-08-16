package Controlador;

import Entidad.Cargo;
import Modelo.CargoModelo;
import java.util.List;

public class CargoController {

    /*
    / Realizamos la insercion o la actualizacion de Cargos    
    / para realizar este registro se requiere los siguietes parametros
    / @Cargo
    / - Cargo_id / en caso de actualizacion tiene que ser > 0
    / -Nombre
    / -Descripcion
    / -Estado
     */
    public String SaveOrUpdate(Cargo cargo) {
        CargoModelo mod = new CargoModelo();
        return mod.SaveOrUpdate(cargo);
    }

    /*
    / Retornamos un objeto de tipo Cargo
    / Con los siguientes parametros 
    / @Cargo
    / - Cargo_id
    / -Nombre
    / -Descripcion
    / -Estado
     */
    public Cargo getCargoByCargoId(int cargo_id) {
        CargoModelo mod = new CargoModelo();
        return mod.getCargoByCargoId(cargo_id);
    }

    /*
    / Retornamos un objeto de tipo Cargo
    / Con los siguientes parametros 
    / @Cargo
    / - Cargo_id
    / -Nombre
    / -Descripcion
    / -Estado
     */
    public List<Cargo> getAllCargoByCargoId() {
        CargoModelo mod = new CargoModelo();
        return mod.getAllCargoByCargoId();
    }

    /*
    / Eliminacion. en realidad no se realiza la eliminacion
    / solo cambiamos de estado, el nuevo estado de eliminado sera 6
    / para esto se queriere
    / -Cargo_id
     */
    public String DeleteCargoByCargoId(int cargoId) {
        CargoModelo mod = new CargoModelo();
        return mod.DeleteCargoByCargoId(cargoId);
    }
}
