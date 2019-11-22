package Entidad;

import java.util.Date;
import java.util.List;

public class Cuestionario {

    private int Cuestionario_id;
    private String Nombre;
    private int Estado;
    private Date Fecha_cracion;
    private int Usuario_crea;
    private Date Fecha_actualiza;
    private int Usuario_actualiza;
    private String Detalle;

    // Par mostrar el usuario que creo el cuestionario
    private String Nombre_Usuario_crea;
    private String Nombre_Usuario_actualiza;
    //Vista para poder ver que Sectores son agrupados
    private View_Sector_cuestionario Sectores;

    //Para agrupar Las preguntas
    private List<Pregunta> Preguntas;

    // para verificar si se lleno, si se lleno = 1
    private int LLeno_cuestionario;

    // Para tenes una nota de la encuensta;
    private float Promedio;
    private int Promedio_entero;
    private String Color_pintar;
    private String Desempeno;

    private List<View_Empleado_Encuesta> View_Empleado_Encuesta;

    public List<View_Empleado_Encuesta> getView_Empleado_Encuesta() {
        return View_Empleado_Encuesta;
    }

    public void setView_Empleado_Encuesta(List<View_Empleado_Encuesta> View_Empleado_Encuesta) {
        this.View_Empleado_Encuesta = View_Empleado_Encuesta;
    }

    public String getDesempeno() {
        return Desempeno;
    }

    public void setDesempeno(String Desempeno) {
        this.Desempeno = Desempeno;
    }

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

    public float getPromedio() {
        return Promedio;
    }

    public void setPromedio(float Promedio) {
        this.Promedio = Promedio;
    }

    public int getLLeno_cuestionario() {
        return LLeno_cuestionario;
    }

    public void setLLeno_cuestionario(int LLeno_cuestionario) {
        this.LLeno_cuestionario = LLeno_cuestionario;
    }

    public List<Pregunta> getPreguntas() {
        return Preguntas;
    }

    public void setPreguntas(List<Pregunta> Preguntas) {
        this.Preguntas = Preguntas;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public View_Sector_cuestionario getSectores() {
        return Sectores;
    }

    public void setSectores(View_Sector_cuestionario Sectores) {
        this.Sectores = Sectores;
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

    public Date getFecha_cracion() {
        return Fecha_cracion;
    }

    public void setFecha_cracion(Date Fecha_cracion) {
        this.Fecha_cracion = Fecha_cracion;
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
