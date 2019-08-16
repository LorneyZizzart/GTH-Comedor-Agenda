package Controlador;

import Entidad.Cliente;
import Entidad.Cuestionario;
import Entidad.Departamento;
import Entidad.Empleado;
import Entidad.Empleado_cargo;
import Entidad.View_Empleado_Encuesta;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        /*NivelController nivel = new NivelController();
        Nivel n = new Nivel();
        n.setNombre("secundario");
        n.setNivel_id(2);
        n.setEstado(1);
        n.setPosicion(1);
        
        String res = nivel.InsertOrUpdateNivel(n);
        System.out.println(" **** insertar "+res);*/
        // DepartamentoController db = new DepartamentoController();
        // Departamento dep = new Departamento();
        /*dep.setDepartamento_id(2);
        dep.setNombre("ViceRectorado Financiero");
        dep.setEstado(1);
        dep.setDepartamento_id_aux(1);
        dep.setArea_id(1);        
        String mensaje = db.SaveOrUpdateDepartamento(dep);
        /*List<Departamento> departamentos = new ArrayList<Departamento>();
        departamentos = db.GetAllDepartamento();
        for (Departamento d : departamentos) {
            System.out.println(d.getDepartamento_id() + " " + d.getNombre() + " " + d.getEstado() + "  " + d.getFecha_creacion() + " " + d.getDepartamento_id_aux() + "  " + d.getArea_Nombre() + " " + d.getDepartamento_Nombre_dep());

        }*/
        //dep = db.GetDepartamentoById(2);
        //System.out.println(dep.getDepartamento_id() + " " + dep.getNombre() + " " + dep.getEstado() + "  " + dep.getFecha_creacion() + " " + dep.getDepartamento_id_aux() + "  " + dep.getArea_Nombre() + " " + dep.getDepartamento_Nombre_dep());

        /*BasededatosController db = new BasededatosCo/*roller();
        String respuesta = db.Copia_deSeguridad();*/
        EmpleadoController em = new EmpleadoController();
        /*List<Empleado> empleado = new ArrayList<Empleado>();
        
        empleado = em. GetAllEmpleado();
        for (Empleado e : empleado) {
            System.out.print(e.getEmpleado_id() +"  "+ e.getCargo().getId());            
        }*/
 /*Empleado emp = new Empleado();
        emp.setNombre("Estebam");
        emp.setApellido_paterno("Dido");
        emp.setApellido_materno(".");
        emp.setEmail("email@com.com");
        emp.setTelefono("67508819");
        emp.setEstado(1);
        emp.setEstado_civil_id(1);
        emp.setPais_id("BOL");

        Empleado_cargo cargo = new Empleado_cargo();
        //cargo.setEmpleado_id(0);
        cargo.setDepartamento_id(1);;
        cargo.setNivel_id(1);
        cargo.setCargo("TEcnico en sistemas");

        emp.setCargo(cargo);
        
        String respuesta = em.CreateEmpleado(emp);*/

        //EmpleadoController e = new EmpleadoController();
        //String delete = e.deleteEmpldeado(21);
        //System.out.println("Executamos "+delete);
        //UsuarioController us = new UsuarioController();
        //String respu = us.DeleteUsuario(1);
        /*Cuestionario_empleadoController cu = new Cuestionario_empleadoController();
        List<View_Empleado_Encuesta> empleados = new ArrayList<View_Empleado_Encuesta>();
        empleados = cu.GetEmpleadosEncuentaByCuestionarioID(24);
        for (View_Empleado_Encuesta empleado : empleados) {
            System.out.println(" Encuestado --" + empleado.getNombre_empleado());
            for (View_Empleado_Encuesta jefe : empleado.getJefes()) {
                System.out.println("Jefes " + jefe.getNombre_empleado()+" Cargo "+jefe.getNombre_nivel());
            }
            for (View_Empleado_Encuesta pare : empleado.getPares()) {
                System.out.println("Pares " + pare.getNombre_empleado()+" Cargo "+pare.getNombre_nivel());
            }
            
            for (View_Empleado_Encuesta bajo : empleado.getBajos()) {
                System.out.println("bajos " + bajo.getNombre_empleado()+" Cargo "+bajo.getNombre_nivel());
            }
            
            for (Cliente cliente : empleado.getClientes()) {
                System.out.println("Cliente " + cliente.getNombre()+" Correo "+cliente.getCorreo());
            }
            
            System.out.println(" ---------------- ------------------");
        }*/
        
        /*CuestionarioController cu = new CuestionarioController();
        Cuestionario cuesti = new Cuestionario();
        cuesti = cu.ComenzarEvaluacion(0);
        */
        
        Empleado_cargoController ec = new Empleado_cargoController();
        Empleado_cargo mo = new Empleado_cargo();
        mo = ec.GetEmpleadoCargoByEnpleadoCargo_id(1070);

    }

}
