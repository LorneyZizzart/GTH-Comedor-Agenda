package Entidad;

import java.util.List;

public class View_Sector_cuestionario {

    private List<Sector_Cuestionario> Departamentos;
    private List<Sector_Cuestionario> Areas;
    private List<Sector_Cuestionario> Niveles;
    private List<Sector_Cuestionario> Cargo;

    public List<Sector_Cuestionario> getCargo() {
        return Cargo;
    }

    public void setCargo(List<Sector_Cuestionario> Cargo) {
        this.Cargo = Cargo;
    }

    public List<Sector_Cuestionario> getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(List<Sector_Cuestionario> Departamentos) {
        this.Departamentos = Departamentos;
    }

    public List<Sector_Cuestionario> getAreas() {
        return Areas;
    }

    public void setAreas(List<Sector_Cuestionario> Areas) {
        this.Areas = Areas;
    }

    public List<Sector_Cuestionario> getNiveles() {
        return Niveles;
    }

    public void setNiveles(List<Sector_Cuestionario> Niveles) {
        this.Niveles = Niveles;
    }
    
    
    
}
