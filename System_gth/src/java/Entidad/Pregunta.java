package Entidad;

import java.util.Date;
import java.util.List;

public class Pregunta {

    private int Pregunta_id;
    private int Cuestionario_id;
    private String Nombre;
    private int Estado;
    private int Orden;
    private Date Fecha_creacion;
    private int Usuario_crea;
    private Date Fecha_actualiza;
    private int Usuario_actualiza;
    private int Tipo_id;

    /* 
        Datos complementacion para ver que tipo
        y quienes crearon la pregunta
     */
    private String Nombre_tipo_id;
    private String Nombre_Usuario_crea;
    private String Nombre_Usuario_actualiza;

    /*
        Todas las opciones de Respuestas
     */
    private List<Pregunta_opcion> PreguntaOpcion;

    // Para guardar un promedio de nota de la pregunta
    private float Promedio;
    private int Promedio_entero;
    private String Color_pintar;
    private String Desempeno;

    public int getPromedio_entero() {
        return Promedio_entero;
    }

    public void setPromedio_entero(int Promedio_entero) {
        this.Promedio_entero = Promedio_entero;
    }

    public String getColor_pintar() {
        return Color_pintar;
    }

    public void setColor_pintar(String Color_pintar) {
        this.Color_pintar = Color_pintar;
    }

    public String getDesempeno() {
        return Desempeno;
    }

    public void setDesempeno(String Desempeno) {
        this.Desempeno = Desempeno;
    }

    
    public float getPromedio() {
        return Promedio;
    }

    public void setPromedio(float Promedio) {
        this.Promedio = Promedio;
    }

    public List<Pregunta_opcion> getPreguntaOpcion() {
        return PreguntaOpcion;
    }

    public void setPreguntaOpcion(List<Pregunta_opcion> PreguntaOpcion) {
        this.PreguntaOpcion = PreguntaOpcion;
    }

    public int getPregunta_id() {
        return Pregunta_id;
    }

    public void setPregunta_id(int Pregunta_id) {
        this.Pregunta_id = Pregunta_id;
    }

    public int getCuestionario_id() {
        return Cuestionario_id;
    }

    public void setCuestionario_id(int Cuestionario_id) {
        this.Cuestionario_id = Cuestionario_id;
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

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
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

    public int getTipo_id() {
        return Tipo_id;
    }

    public void setTipo_id(int Tipo_id) {
        this.Tipo_id = Tipo_id;
    }

    public String getNombre_tipo_id() {
        return Nombre_tipo_id;
    }

    public void setNombre_tipo_id(String Nombre_tipo_id) {
        this.Nombre_tipo_id = Nombre_tipo_id;
    }

    public String getNombre_Usuario_crea() {
        return Nombre_Usuario_crea;
    }

    public void setNombre_Usuario_crea(String Nombre_Usuario_crea) {
        this.Nombre_Usuario_crea = Nombre_Usuario_crea;
    }

    public String getNombre_Usuario_actualiza() {
        return Nombre_Usuario_actualiza;
    }

    public void setNombre_Usuario_actualiza(String Nombre_Usuario_actualiza) {
        this.Nombre_Usuario_actualiza = Nombre_Usuario_actualiza;
    }

}
