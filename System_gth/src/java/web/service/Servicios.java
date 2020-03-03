/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import Controlador.EmpleadoController;
import Entidad.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.BindingType;
//import org.jvnet.jax_ws_commons.json.JSONBindingID;


/**
 *
 * @author Roberto
 */
@WebService(serviceName = "Servicios")
//@BindingType(JSONBindingID.JSON_BINDING)
public class Servicios {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListaEmpleado")
    public List<Empleado> ListaEmpleado() {
        List<Empleado> empleados = new ArrayList<Empleado>();
        EmpleadoController emple = new EmpleadoController();
        empleados = emple.GetAllEmpleado();
        return empleados;
    }
}
