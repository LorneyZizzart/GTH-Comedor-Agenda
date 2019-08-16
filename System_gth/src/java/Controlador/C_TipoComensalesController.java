/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;
import Entidad.C_TipoComensal;
import Modelo.C_TipoComensalModel;
/**
 *
 * @author pc
 */
public class C_TipoComensalesController {
    
    /*
    / Retornamos un objeto de C_TipoComensal
    / Con los siguientes parametros 
    / @Cargo
    / -Id
    / -Nombre
    / -MinimiDias
    / -Estado
    / -fechaRegistro
    / -UsuarioCrea
    / -fechaActualizacion
     */
    
     public List<C_TipoComensal> getAllTipoComensal() {
        C_TipoComensalModel mod = new C_TipoComensalModel();
        return mod.getAllTipoComensal();
    }
     
    /*
    / Retornamos un objeto de tipo TipoComensal
    / Con los siguientes parametros 
    / @TipoComensal
    / -Id
    / -Nombre
    / -MinimiDias
    / -Estado
    / -fechaRegistro
    / -UsuarioCrea
    / -fechaActualizacion
     */
    public C_TipoComensal getTipoComensalById(int idTipoComensal) {
        C_TipoComensalModel mod = new C_TipoComensalModel();
        return mod.getTipoComensalById(idTipoComensal);
    }
     
     /*
    / Realizamos la insercion o la actualizacion de TipoComensal    
    / para realizar este registro se requiere los siguietes parametros
    / @TipoComensal
    / -Id / en caso de actualizacion tiene que ser > 0
    / -Nombre
    / -MinimiDias
    / -Estado
    / -UsuarioCrea
     */
     
    public String SaveOrUpdate(C_TipoComensal tipoComensal) {
        C_TipoComensalModel mod = new C_TipoComensalModel();
        return mod.SaveOrUpdate(tipoComensal);
    }
    
    /*
    / Se elimina el tipo de COmensal
    / para esto se queriere
    / - tipoComensal_Id 
     */
    public String DeleteTipoComensalById(int tipoComensal_Id) {
        C_TipoComensalModel mod = new C_TipoComensalModel();
        return mod.DeleteTipoComensal(tipoComensal_Id);
    }
}
