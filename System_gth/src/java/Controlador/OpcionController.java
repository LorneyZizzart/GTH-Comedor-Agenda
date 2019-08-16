package Controlador;

import Entidad.Opcion;
import Entidad.Usuario;
import Modelo.OpcionModel;
import java.util.List;

public class OpcionController {

    public String EliminaOpcionByidMenu(int id) {
        OpcionModel op = new OpcionModel();
        return op.EliminaOpcionByidMenu(id);
    }

    public List<Opcion> GetAllOpciones() {
        OpcionModel op = new OpcionModel();
        return op.GetAllOpciones();
    }

    public Opcion GetOpcionById(int id) {
        OpcionModel op = new OpcionModel();
        return op.GetOpcionById(id);
    }

    public String InsertUpdateOpcion(Opcion opcion) {
        OpcionModel op = new OpcionModel();
        return op.InsertUpdateOpcion(opcion);
    }

    public List<Usuario> EliminarOpcion(int id) {
        OpcionModel op = new OpcionModel();
        return op.EliminarOpcion(id);
    }
    
    public List<Opcion> GetAllOpcionesByMenu_id(int menuId) {
        OpcionModel op = new OpcionModel();
        return op.GetAllOpcionesByMenu_id(menuId);
    }

}
