/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author DELL-UAB
 */
public class A_PathTarea {
    private int IdPath;
    private int IdTarea;
    private String NombrePath;
    private String Path;
    private String TypeFilePath;
    
    public void setTypeFilePath(String TypeFilePath){
        this.TypeFilePath = TypeFilePath;
    }
    
    public String getTypeFilePath(){
        return this.TypeFilePath;
    }
    
    
    public void setIdTarea(int IdTarea){
        this.IdTarea = IdTarea;
    }
    
    public int getIdTarea(){
        return IdTarea;
    }
    
    public void setNombrePath(String NombrePath){
        this.NombrePath = NombrePath;
    }
    
    public String getNombrePath(){
        return NombrePath;
    }
    
    public void setPath(String Path){
        this.Path = Path;
    }
    
    public String getPath(){
        return Path;
    }
    
    
    public void setIdPath(int IdPath){
        this.IdPath = IdPath;
    }
    
    public int getIdPath(){
        return IdPath;
    }
}
