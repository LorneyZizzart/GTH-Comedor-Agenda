package Controlador;

import Entidad.Area;
import Entidad.Departamento;
import Modelo.AreaModel;
import java.util.List;

public class AreaController {

    //Nos retorna toda la lista de la tabla Area
    public List<Area> getAllArea() {
        AreaModel area = new AreaModel();
        return area.getAllArea();
    }

    /* Realiza 2 acciones
    / Inserta: si mandamos Nivel_id = 0 
    / Actualiza: si mandamos Nivel_id con un valor > 0
    / Nesecitamos los siguientes parametros
    / @Area
    / Area_id
    / Nombre
    / Posicion
    / Estado    
    */
    public String InsertOrUpdateArea(Area a) {
        AreaModel area = new AreaModel();
        return area.InsertOrUpdateArea(a);
    }

    //Retorna un objeto Nivel dependiendo que
    //Nivel_id se envie
    public Area getAreaById(int id) {
        AreaModel area = new AreaModel();
        return area.getAreaById(id);
    }

    /*
    / Elimina Area, se requiere el Area_id
    / Si se elimino List<Departamento> = 0
    / Si no se elimino List<Departamento> Tiene datos para mostrar
    / Los parametros que retorna si no se elimina es 
    / @Departamento
    / Departamento_id
    / Nombre
    / Estado
    / Area_id
    */
    public List<Departamento> DeleteArea(int area_id) {
        AreaModel area = new AreaModel();
        return area.DeleteArea(area_id);
    }
}
