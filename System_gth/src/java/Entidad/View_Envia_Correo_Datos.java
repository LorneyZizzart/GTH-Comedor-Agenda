package Entidad;

public class View_Envia_Correo_Datos {

    private int Cuestionario_evalua_id;
    private int Evalua_empleado_id;
    private int A_empleado_id;
    private String Evaluador;
    private String Evaluado;
    private String Mensaje_correo;
    private String Email;
    private String Correo_titulo;

    public String getCorreo_titulo() {
        return Correo_titulo;
    }

    public void setCorreo_titulo(String Correo_titulo) {
        this.Correo_titulo = Correo_titulo;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getCuestionario_evalua_id() {
        return Cuestionario_evalua_id;
    }

    public void setCuestionario_evalua_id(int Cuestionario_evalua_id) {
        this.Cuestionario_evalua_id = Cuestionario_evalua_id;
    }

    public int getEvalua_empleado_id() {
        return Evalua_empleado_id;
    }

    public void setEvalua_empleado_id(int Evalua_empleado_id) {
        this.Evalua_empleado_id = Evalua_empleado_id;
    }

    public int getA_empleado_id() {
        return A_empleado_id;
    }

    public void setA_empleado_id(int A_empleado_id) {
        this.A_empleado_id = A_empleado_id;
    }

    public String getEvaluador() {
        return Evaluador;
    }

    public void setEvaluador(String Evaluador) {
        this.Evaluador = Evaluador;
    }

    public String getEvaluado() {
        return Evaluado;
    }

    public void setEvaluado(String Evaluado) {
        this.Evaluado = Evaluado;
    }

    public String getMensaje_correo() {
        return Mensaje_correo;
    }

    public void setMensaje_correo(String Mensaje_correo) {
        this.Mensaje_correo = Mensaje_correo;
    }

}
