package Entidad;

import java.util.List;

public class View_Empleado_Encuesta {

    private int Empleado_id;
    private String Nombre_empleado;
    private String Nombre_nivel;
    private int Posicion;
    private int Cuestionario_id;
    private String Cuestionario_Nombre;
    private int Cuestionario_gestion_id;
    private String Correo_electonico;
    private String Auto_evaluacion;

    private int Cuestionario_evalua_id;

    private List<View_Empleado_Encuesta> Jefes;
    private List<View_Empleado_Encuesta> Pares;
    private List<View_Empleado_Encuesta> Bajos;
    private List<Cliente> Clientes;

    private int Envio_correo;
    private int Lleno_cuestionario;

    /*
    / En caso que ya este selecionado,
    / mandamos otra lista de los que ya estan 
    / guardados en la db
     */
    private List<View_Empleado_Encuesta> Select_Jefes;
    private List<View_Empleado_Encuesta> Select_Pares;
    private List<View_Empleado_Encuesta> Select_Bajos;
    private List<Cliente> Select_Clientes;

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

    private int Verifica_correo;

    public int getVerifica_correo() {
        return Verifica_correo;
    }

    public void setVerifica_correo(int Verifica_correo) {
        this.Verifica_correo = Verifica_correo;
    }

    public int getCuestionario_evalua_id() {
        return Cuestionario_evalua_id;
    }

    public void setCuestionario_evalua_id(int Cuestionario_evalua_id) {
        this.Cuestionario_evalua_id = Cuestionario_evalua_id;
    }

    public String getAuto_evaluacion() {
        return Auto_evaluacion;
    }

    public void setAuto_evaluacion(String Auto_evaluacion) {
        this.Auto_evaluacion = Auto_evaluacion;
    }

    public String getCorreo_electonico() {
        return Correo_electonico;
    }

    public void setCorreo_electonico(String Correo_electonico) {
        this.Correo_electonico = Correo_electonico;
    }

    public int getCuestionario_gestion_id() {
        return Cuestionario_gestion_id;
    }

    public void setCuestionario_gestion_id(int Cuestionario_gestion_id) {
        this.Cuestionario_gestion_id = Cuestionario_gestion_id;
    }

    public String getCuestionario_Nombre() {
        return Cuestionario_Nombre;
    }

    public void setCuestionario_Nombre(String Cuestionario_Nombre) {
        this.Cuestionario_Nombre = Cuestionario_Nombre;
    }

    public List<View_Empleado_Encuesta> getSelect_Jefes() {
        return Select_Jefes;
    }

    public void setSelect_Jefes(List<View_Empleado_Encuesta> Select_Jefes) {
        this.Select_Jefes = Select_Jefes;
    }

    public List<View_Empleado_Encuesta> getSelect_Pares() {
        return Select_Pares;
    }

    public void setSelect_Pares(List<View_Empleado_Encuesta> Select_Pares) {
        this.Select_Pares = Select_Pares;
    }

    public List<View_Empleado_Encuesta> getSelect_Bajos() {
        return Select_Bajos;
    }

    public void setSelect_Bajos(List<View_Empleado_Encuesta> Select_Bajos) {
        this.Select_Bajos = Select_Bajos;
    }

    public List<Cliente> getSelect_Clientes() {
        return Select_Clientes;
    }

    public void setSelect_Clientes(List<Cliente> Select_Clientes) {
        this.Select_Clientes = Select_Clientes;
    }

    public int getCuestionario_id() {
        return Cuestionario_id;
    }

    public void setCuestionario_id(int Cuestionario_id) {
        this.Cuestionario_id = Cuestionario_id;
    }

    public View_Empleado_Encuesta() {
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

    public String getNombre_nivel() {
        return Nombre_nivel;
    }

    public void setNombre_nivel(String Nombre_nivel) {
        this.Nombre_nivel = Nombre_nivel;
    }

    public int getPosicion() {
        return Posicion;
    }

    public void setPosicion(int Posicion) {
        this.Posicion = Posicion;
    }

    public List<View_Empleado_Encuesta> getJefes() {
        return Jefes;
    }

    public void setJefes(List<View_Empleado_Encuesta> Jefes) {
        this.Jefes = Jefes;
    }

    public List<View_Empleado_Encuesta> getPares() {
        return Pares;
    }

    public void setPares(List<View_Empleado_Encuesta> Pares) {
        this.Pares = Pares;
    }

    public List<View_Empleado_Encuesta> getBajos() {
        return Bajos;
    }

    public void setBajos(List<View_Empleado_Encuesta> Bajos) {
        this.Bajos = Bajos;
    }

    public List<Cliente> getClientes() {
        return Clientes;
    }

    public void setClientes(List<Cliente> Clientes) {
        this.Clientes = Clientes;
    }

}
