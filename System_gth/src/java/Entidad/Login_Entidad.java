package Entidad;

public class Login_Entidad {

    private int User_id;
    private String Usuario;
    private String Contrasena;
    private int Estado;
    private String Mensage;
    private String Perfil;
    private String Correo;
    private String NombreCompleto;
    private String Nombre;
    private int Empleado_id;
    private String Foto_Empleado;
    private String Accion;

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String Accion) {
        this.Accion = Accion;
    }

    public String getFoto_Empleado() {
        return Foto_Empleado;
    }

    public void setFoto_Empleado(String Foto_Empleado) {
        this.Foto_Empleado = Foto_Empleado;
    }

    public int getEmpleado_id() {
        return Empleado_id;
    }

    public void setEmpleado_id(int Empleado_id) {
        this.Empleado_id = Empleado_id;
    }
    
    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public String getMensage() {
        return Mensage;
    }

    public void setMensage(String Mensage) {
        this.Mensage = Mensage;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

}
