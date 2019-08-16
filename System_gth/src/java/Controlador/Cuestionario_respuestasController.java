/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Cuestionario_respuestas;
import Modelo.Cuestionario_respuestasModelo;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Cuestionario_respuestasController {

    public String Save_respuestas(List<Cuestionario_respuestas> respuestas) {
        Cuestionario_respuestasModelo mod = new Cuestionario_respuestasModelo();
        return mod.Save_respuestas(respuestas);
    }
}
