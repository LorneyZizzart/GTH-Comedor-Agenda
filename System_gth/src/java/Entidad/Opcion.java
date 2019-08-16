package Entidad;

public class Opcion {

    private int Opcion_id;
    private String Nombre;
    private String Url;
    private String Descriocion;
    private int Estado;
    private int Orden;
    private int Menu_id;
    private String Nombre_menu;

    public String getNombre_menu() {
        return Nombre_menu;
    }

    public void setNombre_menu(String Nombre_menu) {
        this.Nombre_menu = Nombre_menu;
    }

    public int getOpcion_id() {
        return Opcion_id;
    }

    public void setOpcion_id(int Opcion_id) {
        this.Opcion_id = Opcion_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getDescriocion() {
        return Descriocion;
    }

    public void setDescriocion(String Descriocion) {
        this.Descriocion = Descriocion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
    }

    public int getMenu_id() {
        return Menu_id;
    }

    public void setMenu_id(int Menu_id) {
        this.Menu_id = Menu_id;
    }

}
