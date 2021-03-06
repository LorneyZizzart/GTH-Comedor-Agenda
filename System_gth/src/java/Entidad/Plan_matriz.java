package Entidad;

import java.util.List;

public class Plan_matriz {

    private int Plan_matriz_id;
    private String Que_hacer;
    private String Responsable;
    private String Como;
    private String Documento_generadi;
    private String Indicadores_resultado;
    private String Fecha;
    private String Indicador;
    private int Plan_accion_id;
    private String Fecha_cracion;
    private int Empleado_id;
    private String Fecha_actualizacion;
    private int Empleado_actualiza;
    private int Estado;
    private float Presupuesto;

//Datos adicionales para ver al empleado su nombre
    private String Nombre_creador;
    private String Nombre_actualizador;

    private List<Plan_indica_resultado> Plan_indica_resultado;

    public List<Plan_indica_resultado> getPlan_indica_resultado() {
        return Plan_indica_resultado;
    }

    public void setPlan_indica_resultado(List<Plan_indica_resultado> Plan_indica_resultado) {
        this.Plan_indica_resultado = Plan_indica_resultado;
    }
    
    
    public float getPresupuesto() {
        return Presupuesto;
    }

    public void setPresupuesto(float Presupuesto) {
        this.Presupuesto = Presupuesto;
    }

    public int getPlan_matriz_id() {
        return Plan_matriz_id;
    }

    public void setPlan_matriz_id(int Plan_matriz_id) {
        this.Plan_matriz_id = Plan_matriz_id;
    }

    public String getQue_hacer() {
        return Que_hacer;
    }

    public void setQue_hacer(String Que_hacer) {
        this.Que_hacer = Que_hacer;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }

    public String getComo() {
        return Como;
    }

    public void setComo(String Como) {
        this.Como = Como;
    }

    public String getDocumento_generadi() {
        return Documento_generadi;
    }

    public void setDocumento_generadi(String Documento_generadi) {
        this.Documento_generadi = Documento_generadi;
    }

    public String getIndicadores_resultado() {
        return Indicadores_resultado;
    }

    public void setIndicadores_resultado(String Indicadores_resultado) {
        this.Indicadores_resultado = Indicadores_resultado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getIndicador() {
        return Indicador;
    }

    public void setIndicador(String Indicador) {
        this.Indicador = Indicador;
    }

    public int getPlan_accion_id() {
        return Plan_accion_id;
    }

    public void setPlan_accion_id(int Plan_accion_id) {
        this.Plan_accion_id = Plan_accion_id;
    }

    public String getFecha_cracion() {
        return Fecha_cracion;
    }

    public void setFecha_cracion(String Fecha_cracion) {
        this.Fecha_cracion = Fecha_cracion;
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
