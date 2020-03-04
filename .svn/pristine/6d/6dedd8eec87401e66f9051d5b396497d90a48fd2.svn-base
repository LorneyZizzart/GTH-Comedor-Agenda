package Controlador;

public class Send_mailController {

    /*
/ Enviamos correo electronico 
/ para esto nesecitammos el 
/ @cuestionario_gestion_id
/ @Empleado_id
/ 
     */
    public String Enviar_emailEvaluacion(int gestion_id, int persona_id) {
        Modelo.Send_mailModelo mod = new Modelo.Send_mailModelo();
        return mod.Enviar_emailEvaluacion(gestion_id, persona_id);
    }

    /*
/ Enviamos un correo electronico 
/ para esto nesecitammos el 
/ @cuestionario_evalua_id
/ 
     */
    public String Enviar_Un_emailEvaluacion(int cuestionario_evalua_id) {
        Modelo.Send_mailModelo mod = new Modelo.Send_mailModelo();
        return mod.Enviar_Un_emailEvaluacion(cuestionario_evalua_id);
    }
}
