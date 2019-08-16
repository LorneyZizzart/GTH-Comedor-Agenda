package Entidad;

/**
 *
 * @author Roberto
 */
public class View_Empleado_Gestion {

    private int Cuestionario_gestion_empleado_id;
    private int Empleado_id;
    private String Nombre_empleado;
    private String Nombre_cargo;
    private String Nombre_departamento;
    private int Seleccionado;
    private String Estado;
    private int Estado_evaluadores ; // 0: No tiene asignado evaluadores, 1 Evaluadores Incompleto , 2 evaluadores completo1
    private int Estado_correo ; // 0: No tiene asignado evaluadores, 1 Evaluadores Incompleto , 2 evaluadores completo1

    public int getEstado_correo() {
        return Estado_correo;
    }

    public void setEstado_correo(int Estado_correo) {
        this.Estado_correo = Estado_correo;
    }
    
    public int getEstado_evaluadores() {
        return Estado_evaluadores;
    }

    public void setEstado_evaluadores(int Estado_evaluadores) {
        this.Estado_evaluadores = Estado_evaluadores;
    }
    
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCuestionario_gestion_empleado_id() {
        return Cuestionario_gestion_empleado_id;
    }

    public void setCuestionario_gestion_empleado_id(int Cuestionario_gestion_empleado_id) {
        this.Cuestionario_gestion_empleado_id = Cuestionario_gestion_empleado_id;
    }

    public int getEmpleado_id() {
        return Empleado_id;
    }

    public void setEmpleado_id(int Empleado_id) {
        this.Empleado_id = Empleado_id;
    }

    public String getNombre_empleado() {
        return Nombre_empleado;
    }

    public void setNombre_empleado(String Nombre_empleado) {
        this.Nombre_empleado = Nombre_empleado;
    }

    public String getNombre_cargo() {
        return Nombre_cargo;
    }

    public void setNombre_cargo(String Nombre_cargo) {
        this.Nombre_cargo = Nombre_cargo;
    }

    public String getNombre_departamento() {
        return Nombre_departamento;
    }

    public void setNombre_departamento(String Nombre_departamento) {
        this.Nombre_departamento = Nombre_departamento;
    }

    public int getSeleccionado() {
        return Seleccionado;
    }

    public void setSeleccionado(int Seleccionado) {
        this.Seleccionado = Seleccionado;
    }

}
