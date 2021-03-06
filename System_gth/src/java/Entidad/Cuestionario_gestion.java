package Entidad;

import java.util.Date;
import java.util.List;

public class Cuestionario_gestion {

    private int Cuestionario_gestion_id;
    private String Nombre;
    private Date Fecha_creacion;
    private int Usuario_crea;
    private Date Fecha_actualiza;
    private int Usuario_actualiza;
    private int Estado;
    private String Descripciom;
    private String Mensaje_correo;
    private String Titulo_correo;
    private String Gestion;
    private List<View_Empleado_Gestion> Empleados;

    public String getGestion() {
        return Gestion;
    }

    public void setGestion(String Gestion) {
        this.Gestion = Gestion;
    }

    
    public String getTitulo_correo() {
        return Titulo_correo;
    }

    public void setTitulo_correo(String Titulo_correo) {
        this.Titulo_correo = Titulo_correo;
    }

    
    public String getMensaje_correo() {
        return Mensaje_correo;
    }

    public void setMensaje_correo(String Mensaje_correo) {
        this.Mensaje_correo = Mensaje_correo;
    }

    public List<View_Empleado_Gestion> getEmpleados() {
        return Empleados;
    }

    public void setEmpleados(List<View_Empleado_Gestion> Empleados) {
        this.Empleados = Empleados;
    }

    public int getCuestionario_gestion_id() {
        return Cuestionario_gestion_id;
    }

    public void setCuestionario_gestion_id(int Cuestionario_gestion_id) {
        this.Cuestionario_gestion_id = Cuestionario_gestion_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(Date Fecha_creacion) {
        this.Fecha_creacion = Fecha_creacion;
    }

    public int getUsuario_crea() {
        return Usuario_crea;
    }

    public void setUsuario_crea(int Usuario_crea) {
        this.Usuario_crea = Usuario_crea;
    }

    public Date getFecha_actualiza() {
        return Fecha_actualiza;
    }

    public void setFecha_actualiza(Date Fecha_actualiza) {
        this.Fecha_actualiza = Fecha_actualiza;
    }

    public int getUsuario_actualiza() {
        return Usuario_actualiza;
    }

    public void setUsuario_actualiza(int Usuario_actualiza) {
        this.Usuario_actualiza = Usuario_actualiza;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public String getDescripciom() {
        return Descripciom;
    }

    public void setDescripciom(String Descripciom) {
        this.Descripciom = Descripciom;
    }

}
