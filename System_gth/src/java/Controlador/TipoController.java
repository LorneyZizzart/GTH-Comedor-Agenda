package Controlador;

import Entidad.Tipo;
import java.util.List;

public class TipoController {

    /*
    / Traemos todos los tipos
    / Nointeresa si esta activo no 
    */
    public List<Tipo> GetAllTipo() {
        Modelo.TipoModelo mod = new Modelo.TipoModelo();
        return mod.getAllTipo();
    }
    
    /*
    / Traemos todos los tipos que esten activos
    */
    public List<Tipo> GetAllTipoActivos() {
        Modelo.TipoModelo mod = new Modelo.TipoModelo();
        return mod.GetAllTipoActivos();
    }

}
