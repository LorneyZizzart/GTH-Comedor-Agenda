package Entidad;

public class Cargo {

    private int Cargo_id;
    private String Nombre;
    private String Descripcion;
    private int Estado;

    public int getCargo_id() {
        return Cargo_id;
    }

    public void setCargo_id(int Cargo_id) {
        this.Cargo_id = Cargo_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

}
