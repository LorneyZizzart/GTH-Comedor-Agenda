package Entidad;

public class Cliente {

    private int Cliente_id;
    private String Nombre;
    private String Correo;
    private String Ci;
    private String Telefono;
    private int Estado;
    private int Tipo_cliente_id;
    
    private int Cuestionario_evalua_id;

    public int getCuestionario_evalua_id() {
        return Cuestionario_evalua_id;
    }

    public void setCuestionario_evalua_id(int Cuestionario_evalua_id) {
        this.Cuestionario_evalua_id = Cuestionario_evalua_id;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    
    public int getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(int Cliente_id) {
        this.Cliente_id = Cliente_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCi() {
        return Ci;
    }

    public void setCi(String Ci) {
        this.Ci = Ci;
    }

    public int getTipo_cliente_id() {
        return Tipo_cliente_id;
    }

    public void setTipo_cliente_id(int Tipo_cliente_id) {
        this.Tipo_cliente_id = Tipo_cliente_id;
    }
    
    
}
