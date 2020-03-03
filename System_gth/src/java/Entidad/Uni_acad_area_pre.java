package Entidad;

public class Uni_acad_area_pre {

    private int Uni_acad_area_pre_id;
    private String Nombre;
    private int Estado;
    private String Gestion ;
    private int Unidad_academica_id;
    private int Puntuacion;
    private float Nota;
    private String Css;
    private String Nota_estado;

    public String getCss() {
        return Css;
    }

    public void setCss(String Css) {
        this.Css = Css;
    }    

    public String getNota_estado() {
        return Nota_estado;
    }

    public void setNota_estado(String Nota_estado) {
        this.Nota_estado = Nota_estado;
    }

    public float getNota() {
        return Nota;
    }

    public void setNota(float Nota) {
        this.Nota = Nota;
    }

    public int getUni_acad_area_pre_id() {
        return Uni_acad_area_pre_id;
    }

    public void setUni_acad_area_pre_id(int Uni_acad_area_pre_id) {
        this.Uni_acad_area_pre_id = Uni_acad_area_pre_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public String getGestion() {
        return Gestion;
    }

    public void setGestion(String Gestion) {
        this.Gestion = Gestion;
    }

    public int getUnidad_academica_id() {
        return Unidad_academica_id;
    }

    public void setUnidad_academica_id(int Unidad_academica_id) {
        this.Unidad_academica_id = Unidad_academica_id;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(int Puntuacion) {
        this.Puntuacion = Puntuacion;
    }
    
}
