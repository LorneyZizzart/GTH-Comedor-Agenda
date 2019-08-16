package Controlador;

import Entidad.Menu;
import Entidad.Usuario;
import Modelo.MenuModel;
import java.util.List;

public class MenuController {

    public List<Menu> getAllMenu() {
        MenuModel model = new MenuModel();
        return model.getAllMenu();
    }

    public Menu getMenuById(int id) {
        MenuModel model = new MenuModel();
        return model.getMenuById(id);
    }

    public String Menu_guarda_actualiza(Menu menu) {
        MenuModel model = new MenuModel();
        return model.Menu_guarda_actualiza(menu);
    }

    public List<Usuario> Elimina(int id) {
        MenuModel model = new MenuModel();
        return model.Elimina(id);
    }
    
    public List<Menu> getAllMenuAndOpcion() {
        MenuModel model = new MenuModel();
        return model.getAllMenuAndOpcion();
    }
}
