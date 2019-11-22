package Entidad;

public class Plan_accion {

    private int Plan_accion_id;
    private String Nombre;
    private String Contexto;
    private String Fecha_creacion;
    private int Empleado_id;
    private String Fecha_actualizacion;
    private int Empleado_actualiza;
    private int Estado;
    private int Plan_subobjetivo_id;
    private String Criterio;

    //Datos adicionales para ver al empleado su nombre
    private String Nombre_creador;
    private String Nombre_actualizador;

    public String getCriterio() {
        return Criterio;
    }

    public void setCriterio(String Criterio) {
        this.Criterio = Criterio;
    }

    public int getPlan_accion_id() {
        return Plan_accion_id;
    }

    public void setPlan_accion_id(int Plan_accion_id) {
        this.Plan_accion_id = Plan_accion_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContexto() {
        return Contexto;
    }

    public void setContexto(String Contexto) {
        this.Contexto = Contexto;
    }

    public String getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(String Fecha_creacion) {
        this.Fecha_creacion = Fecha_creacion;
    }

    public int getEmpleado_id() {
        return Empleado_id;
    }

    public void setEmpleado_id(int Empleado_id) {
        this.Empleado_id = Empleado_id;
    }

    public String getFecha_actualizacion() {
        return Fecha_actualizacion;
    }

    public void setFecha_actualizacion(String Fecha_actualizacion) {
        this.Fecha_actualizacion = Fecha_actualizacion;
    }

    public int getEmpleado_actualiza() {
        return Empleado_actualiza;
    }

    public void setEmpleado_actualiza(int Empleado_actualiza) {
        this.Empleado_actualiza = Empleado_actualiza;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getPlan_subobjetivo_id() {
        return Plan_subobjetivo_id;
    }

    public void setPlan_subobjetivo_id(int Plan_subobjetivo_id) {
        this.Plan_subobjetivo_id = Plan_subobjetivo_id;
    }

    public String getNombre_creador() {
        return Nombre_creador;
    }

    public void setNombre_creador(String Nombre_creador) {
        this.Nombre_creador = Nombre_creador;
    }

    public String getNombre_actualizador() {
        return Nombre_actualizador;
    }

    public void setNombre_actualizador(String Nombre_actualizador) {
        this.Nombre_actualizador = Nombre_actualizador;
    }

}
