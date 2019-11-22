package Entidad;

public class Evento_participantes {

    private int Evento_participate_id;
    private int Empleado_id;
    private int Evento_id;
    private int Estado;
    private int Registra_personal_id;
    private String Fecha_registro;

    public int getEvento_participate_id() {
        return Evento_participate_id;
    }

    public void setEvento_participate_id(int Evento_participate_id) {
        this.Evento_participate_id = Evento_participate_id;
    }

    public int getEmpleado_id() {
        return Empleado_id;
    }

    public void setEmpleado_id(int Empleado_id) {
        this.Empleado_id = Empleado_id;
    }

    public int getEvento_id() {
        return Evento_id;
    }

    public void setEvento_id(int Evento_id) {
        this.Evento_id = Evento_id;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getRegistra_personal_id() {
        return Registra_personal_id;
    }

    public void setRegistra_personal_id(int Registra_personal_id) {
        this.Registra_personal_id = Registra_personal_id;
    }

    public String getFecha_registro() {
        return Fecha_registro;
    }

    public void setFecha_registro(String Fecha_registro) {
        this.Fecha_registro = Fecha_registro;
    }
    
    

}
