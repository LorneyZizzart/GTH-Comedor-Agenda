package Controlador;

import Entidad.Banco_respuestas;
import Modelo.Banco_respuestasModelo;
import java.util.List;

public class Banco_respuestasController {

    /*
    / Verificamos que Tipo tenga sus respuestas
    / o mejor dicho su banco de respuestas para agilizar las opciones de respuestas
    / para esto requerimos 
    / @Tipo_id
    */
    public List<Banco_respuestas> GetAllBancoRespuestasByTipo_id(int tipo_id) {
        Banco_respuestasModelo mod = new Banco_respuestasModelo();
        return mod.GetAllBancoRespuestasByTipo_id(tipo_id);
    }    
}
