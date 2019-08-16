package Controlador;

import Entidad.Cliente;
import Modelo.ClienteModel;
import java.util.List;

public class ClienteController {

    /* Traemmos una lista de todos los clientes
    * en este caso todos lo que son de tipo_cliente_id =1
    * Los parametros que retornan son los siguientes
    * @Cliente
    * Cliente_id
    * Nombre
    * Correo
    * Telefono
    * Estado
     */
    public List<Cliente> getAllClientes() {
        ClienteModel cli = new ClienteModel();
        return cli.getAllClientes();
    }

    /* 
    * Hacemos la busqueda por Cliente_id
    * Los parametros que retornan son los siguientes
    * @Cliente
    * Cliente_id
    * Nombre
    * Correo
    * Telefono
    * Estado
     */
    public Cliente getClienteByClienteId(int id) {
        ClienteModel cli = new ClienteModel();
        return cli.getClienteByClienteId(id);
    }
  

    /* 
    * Hacemos la eliminacion del cliente
    * requerimo el parametros 
    * @Cliente_id
    * -Retorna Ok en caso que se realize la operacion
     */
    public String DeleteCliente(int clienteId) {
        ClienteModel cli = new ClienteModel();
        return cli.DeleteCliente(clienteId);
    }
    
     /* 
    * Hacemos actualizacion o insercion
    * requerimo Los parametros 
    * @Cliente
    * Cliente_id
    * Nombre
    * Correo
    * Telefono
    * Estado
    * -Retorna Ok en caso que se realize la operacion
     */
    
    public String InsertOrUpdateCliente(Cliente cliente) {
        ClienteModel cli = new ClienteModel();
        return cli.InsertOrUpdateCliente(cliente);
    }
}
