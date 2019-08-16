package Entidad;

import java.util.Date;

public class Departamento {

    private int Departamento_id;
    private String Nombre;
    private int Estado;
    private Date Fecha_creacion;
    private int Departamento_id_aux;
    private int Area_id;
    
    //Se añadio estos campos para mostrar
    //los nombres del Area y Departamentos
    //qre estan relacionados con esta tabla
    
    private String Area_Nombre;
    private String Departamento_Nombre_dep;

    public String getArea_Nombre() {
        return Area_Nombre;
    }

    public void setArea_Nombre(String Area_Nombre) {
        this.Area_Nombre = Area_Nombre;
    }

    public String getDepartamento_Nombre_dep() {
        return Departamento_Nombre_dep;
    }

    public void setDepartamento_Nombre_dep(String Departamento_Nombre_dep) {
        this.Departamento_Nombre_dep = Departamento_Nombre_dep;
    }
   

    public int getDepartamento_id() {
        return Departamento_id;
    }

    public void setDepartamento_id(int Departamento_id) {
        this.Departamento_id = Departamento_id;
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

    public Date getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(Date Fecha_creacion) {
        this.Fecha_creacion = Fecha_creacion;
    }

    public int getDepartamento_id_aux() {
        return Departamento_id_aux;
    }

    public void setDepartamento_id_aux(int Departamento_id_aux) {
        this.Departamento_id_aux = Departamento_id_aux;
    }

    public int getArea_id() {
        return Area_id;
    }

    public void setArea_id(int Area_id) {
        this.Area_id = Area_id;
    }
    
    
}
