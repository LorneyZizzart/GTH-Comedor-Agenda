package Entidad;

import java.util.List;

public class View_Enviar_correo {

    private int Cuestionario_id;
    private String Cuestionario_nombre;
    private int Cuestionario_gestion_id;
    private int Cuestionario_evalua_id;
    private int Empleado_id;
    private View_Empleado_Encuesta Auto_evaluacion;
    private List<View_Empleado_Encuesta> Lista_jefes;
    private List<View_Empleado_Encuesta> Lista_pares;
    private List<View_Empleado_Encuesta> Lista_bajos;
    private List<View_Empleado_Encuesta> Lista_clientes;

    private String Evaluador_nombre;
    private String Evaluador_correo;
    
    private int Envio_correo;
    private int Lleno_cuestionario;

    public int getEnvio_correo() {
        return Envio_correo;
    }

    public void setEnvio_correo(int Envio_correo) {
        this.Envio_correo = Envio_correo;
    }

    public int getLleno_cuestionario() {
        return Lleno_cuestionario;
    }

    public void setLleno_cuestionario(int Lleno_cuestionario) {
        this.Lleno_cuestionario = Lleno_cuestionario;
    }

    public int getCuestionario_evalua_id() {
        return Cuestionario_evalua_id;
    }

    public void setCuestionario_evalua_id(int Cuestionario_evalua_id) {
        this.Cuestionario_evalua_id = Cuestionario_evalua_id;
    }

    public String getEvaluador_nombre() {
        return Evaluador_nombre;
    }

    public void setEvaluador_nombre(String Evaluador_nombre) {
        this.Evaluador_nombre = Evaluador_nombre;
    }

    public String getEvaluador_correo() {
        return Evaluador_correo;
    }

    public void setEvaluador_correo(String Evaluador_correo) {
        this.Evaluador_correo = Evaluador_correo;
    }

    public int getCuestionario_gestion_id() {
        return Cuestionario_gestion_id;
    }

    public void setCuestionario_gestion_id(int Cuestionario_gestion_id) {
        this.Cuestionario_gestion_id = Cuestionario_gestion_id;
    }

    public int getEmpleado_id() {
        return Empleado_id;
    }

    public void setEmpleado_id(int Empleado_id) {
        this.Empleado_id = Empleado_id;
    }

    public View_Empleado_Encuesta getAuto_evaluacion() {
        return Auto_evaluacion;
    }

    public void setAuto_evaluacion(View_Empleado_Encuesta Auto_evaluacion) {
        this.Auto_evaluacion = Auto_evaluacion;
    }

   
   

    public int getCuestionario_id() {
        return Cuestionario_id;
    }

    public void setCuestionario_id(int Cuestionario_id) {
        this.Cuestionario_id = Cuestionario_id;
    }

    public String getCuestionario_nombre() {
        return Cuestionario_nombre;
    }

    public void setCuestionario_nombre(String Cuestionario_nombre) {
        this.Cuestionario_nombre = Cuestionario_nombre;
    }

    public List<View_Empleado_Encuesta> getLista_jefes() {
        return Lista_jefes;
    }

    public void setLista_jefes(List<View_Empleado_Encuesta> Lista_jefes) {
        this.Lista_jefes = Lista_jefes;
    }

    public List<View_Empleado_Encuesta> getLista_pares() {
        return Lista_pares;
    }

    public void setLista_pares(List<View_Empleado_Encuesta> Lista_pares) {
        this.Lista_pares = Lista_pares;
    }

    public List<View_Empleado_Encuesta> getLista_bajos() {
        return Lista_bajos;
    }

    public void setLista_bajos(List<View_Empleado_Encuesta> Lista_bajos) {
        this.Lista_bajos = Lista_bajos;
    }

    public List<View_Empleado_Encuesta> getLista_clientes() {
        return Lista_clientes;
    }

    public void setLista_clientes(List<View_Empleado_Encuesta> Lista_clientes) {
        this.Lista_clientes = Lista_clientes;
    }

}
