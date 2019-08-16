/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.C_TipoComida;
import Modelo.C_TipoComidaModel;
import java.util.List;

/**
 *
 * @author pc
 */
public class C_TipoComidaController {
    
    /*
    / Retornamos un objeto de C_TipoComensal
    / Con los siguientes parametros 
    / @C_TipoComensal
    / -Id
    / -Nombre
    / -Costo
    / -Hora
    / -Detalles
    / -Estado
    / -fechaRegistro
    / -fechaActualizacion
     */
    
     public List<C_TipoComida> getAllTipoComida() {
        C_TipoComidaModel mod = new C_TipoComidaModel();
        return mod.getAllTipoComida();
    }
     
    /*
    / Retornamos un objeto de tipo TipoComida
    / Con los siguientes parametros 
    / @TipoComida
    / -Id
    / -Nombre
    / -Costo
    / -Hora
    / -Detalles
    / -Estado
    / -fechaRegistro
    / -fechaActualizacion
     */
    public C_TipoComida getTipoComidaById(int idTipoComida) {
        C_TipoComidaModel mod = new C_TipoComidaModel();
        return mod.getTipoComidaById(idTipoComida);
    }
     
    /*
    / Realizamos la insercion o la actualizacion de TipoComida   
    / para realizar este registro se requiere los siguietes parametros
    / @TipoComida
    / -Id / en caso de actualizacion tiene que ser > 0
    / -Nombre
    / -Costo
    / -Estado
    / -Hora
    / -Detalle
     */
    public String SaveOrUpdate(C_TipoComida tipoComida) {
        C_TipoComidaModel mod = new C_TipoComidaModel();
        return mod.SaveOrUpdate(tipoComida);
    }
    
    /*
    / Para eliminar el tipo de Comida
    / para esto se queriere
    / - idTipoComida 
     */
    public String DeleteTipoComidaById(int idTipoComida) {
        C_TipoComidaModel mod = new C_TipoComidaModel();
        return mod.DeleteTipoComida(idTipoComida);
    }
    
}
