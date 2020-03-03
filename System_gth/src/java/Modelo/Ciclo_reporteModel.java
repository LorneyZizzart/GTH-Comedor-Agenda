package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cliente;
import Entidad.Cuestionario;
import Entidad.Sector_Cuestionario;
import Entidad.View_Empleado_Encuesta;
import Entidad.View_Sector_cuestionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ciclo_reporteModel {

    public List<Cuestionario> GetAllCuestionarios(int ciclo_id) {
        List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();
        try {
            Conexion.ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Cuestionario_id, Nombre, Estado, Fecha_cracion, Usuario_crea, Fecha_actualiza, Usuario_actualiza, Detalle\n"
                    + "FROM Cuestionario WHERE Estado ='1' ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Cuestionario c = new Cuestionario();
                c.setCuestionario_id(res.getInt("Cuestionario_id"));
                c.setNombre(res.getString("Nombre"));
                c.setEstado(res.getInt("Estado"));
                c.setFecha_cracion(res.getDate("Fecha_cracion"));
                c.setUsuario_crea(res.getInt("Usuario_crea"));
                c.setFecha_actualiza(res.getDate("Fecha_actualiza"));
                c.setUsuario_actualiza(res.getInt("Usuario_actualiza"));
                c.setDetalle(res.getString("Detalle"));
                Sector_CuestionarioModel sector = new Sector_CuestionarioModel();
                c.setSectores(sector.GetAllAreasByCuestionario_id(c.getCuestionario_id()));
                cuestionarios.add(c);
            }
            db.cierraConexion();

            cuestionarios = AnadimosEmpleadoAlCuestionario(cuestionarios, ciclo_id);

        } catch (SQLException e) {
            System.out.println("Modelo.Ciclo_reporteModel.GetAllCuestionarios() " + e.getMessage());
        }
        return cuestionarios;
    }

    public List<Cuestionario> AnadimosEmpleadoAlCuestionario(List<Cuestionario> cuestionario, int ciclo_id) {
        // List<View_Empleado_Encuesta>
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            for (Cuestionario c : cuestionario) {
                String nivel = "";
                List<View_Empleado_Encuesta> empleados = new ArrayList<>();
                System.out.println(c.getNombre());
                int contador = 0;
                for (Sector_Cuestionario sec : c.getSectores().getCargo()) {
                    System.out.println(" - " + sec.getSector_nombre() + " - " + sec.getArea_id());
                    if (contador == 0) {
                        nivel = " " + sec.getArea_id();
                    } else {
                        nivel = nivel + " , " + sec.getArea_id();
                    }
                    contador++;
                }
                String consulta = "Select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) nombre\n"
                        + "from	Cuestionario_gestion_empleado cge\n"
                        + "		inner join Empleado e \n"
                        + "		on cge.Empleado_id = e.Empleado_id\n"
                        + "		inner join Empleado_cargo ec\n"
                        + "		on e.Empleado_id = ec.Empleado_id\n"
                        + "where cge.Cuestionario_gestion_id = '" + ciclo_id + "' and ec.Cargo_id in (" + nivel + ") order by e.Apellido_paterno, e.Apellido_materno, e.Nombre";
                ResultSet res = db.consulta(consulta);
                while (res.next()) {
                    View_Empleado_Encuesta en = new View_Empleado_Encuesta();
                    en.setEmpleado_id(res.getInt("Empleado_id"));
                    en.setNombre_empleado(res.getString("Nombre"));
                    empleados.add(en);
                    System.out.println(" --- " + en.getEmpleado_id());

                    //List<View_Empleado_Encuesta> auto_evaluacion = new ArrayList<View_Empleado_Encuesta>();
                    String auto_eva = "select	Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) nombre , e.email\n"
                            + "from	Cuestioario_evalua ce \n"
                            + "		inner join Empleado e\n"
                            + "		on ce.Evalua_empleado_id = e.Empleado_id\n"
                            + "where	ce.A_empleado_id = " + en.getEmpleado_id() + " and Cuestionario_gestion_id = '" + ciclo_id + "' and \n"
                            + "		Cuestionario_id = '" + c.getCuestionario_id() + "' and Tipo = 'Autoevaluacion'";
                    ResultSet auto_res = db.consulta(auto_eva);
                    if (auto_res.next()) {
                        /* View_Empleado_Encuesta auto = new View_Empleado_Encuesta();
                        auto.setEmpleado_id(res.getInt("Empleado_id"));
                        auto.setNombre_empleado(res.getString("Nombre"));
                        auto_evaluacion.add(auto);*/
                        en.setAuto_evaluacion("SI");
                    } else {
                        en.setAuto_evaluacion(" ");
                    }
                    //en.setAuto_evaluacion(auto_eva);

                    List<View_Empleado_Encuesta> jefe_evaluacion = new ArrayList<View_Empleado_Encuesta>();
                    String jefe_eva = "select	Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) nombre , e.email\n"
                            + "from	Cuestioario_evalua ce \n"
                            + "		inner join Empleado e\n"
                            + "		on ce.Evalua_empleado_id = e.Empleado_id\n"
                            + "where	ce.A_empleado_id = " + en.getEmpleado_id() + " and Cuestionario_gestion_id = '" + ciclo_id + "' and \n"
                            + "		Cuestionario_id = '" + c.getCuestionario_id() + "' and Tipo = 'Jefe'";
                    ResultSet jefe_res = db.consulta(jefe_eva);
                    while (jefe_res.next()) {
                        View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
                        jefe.setEmpleado_id(jefe_res.getInt("Empleado_id"));
                        jefe.setNombre_empleado(jefe_res.getString("Nombre"));
                        jefe_evaluacion.add(jefe);

                    }
                    en.setJefes(jefe_evaluacion);

                    List<View_Empleado_Encuesta> pares_evaluacion = new ArrayList<View_Empleado_Encuesta>();
                    String pares_eva = "select	Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) nombre , e.email\n"
                            + "from	Cuestioario_evalua ce \n"
                            + "		inner join Empleado e\n"
                            + "		on ce.Evalua_empleado_id = e.Empleado_id\n"
                            + "where	ce.A_empleado_id = " + en.getEmpleado_id() + " and Cuestionario_gestion_id = '" + ciclo_id + "' and \n"
                            + "		Cuestionario_id = '" + c.getCuestionario_id() + "' and Tipo = 'Par'";
                    ResultSet pares_res = db.consulta(pares_eva);
                    while (pares_res.next()) {
                        View_Empleado_Encuesta par = new View_Empleado_Encuesta();
                        par.setEmpleado_id(pares_res.getInt("Empleado_id"));
                        par.setNombre_empleado(pares_res.getString("Nombre"));
                        pares_evaluacion.add(par);

                    }
                    en.setPares(pares_evaluacion);

                    List<View_Empleado_Encuesta> Bajo_evaluacion = new ArrayList<View_Empleado_Encuesta>();
                    String Bajo_eva = "select	Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) nombre , e.email\n"
                            + "from	Cuestioario_evalua ce \n"
                            + "		inner join Empleado e\n"
                            + "		on ce.Evalua_empleado_id = e.Empleado_id\n"
                            + "where	ce.A_empleado_id = " + en.getEmpleado_id() + " and Cuestionario_gestion_id = '" + ciclo_id + "' and \n"
                            + "		Cuestionario_id = '" + c.getCuestionario_id() + "' and Tipo = 'Bajo'";
                    ResultSet Bajo_res = db.consulta(Bajo_eva);
                    //System.out.println(" Evaluacion : " + Bajo_eva);
                    while (Bajo_res.next()) {
                        View_Empleado_Encuesta ba = new View_Empleado_Encuesta();
                        ba.setEmpleado_id(Bajo_res.getInt("Empleado_id"));
                        ba.setNombre_empleado(Bajo_res.getString("Nombre"));
                        Bajo_evaluacion.add(ba);

                    }
                    en.setBajos(Bajo_evaluacion);

                    List<Cliente> Cliente_evaluacion = new ArrayList<Cliente>();
                    String Cliente_eva = "select Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) nombre , e.email, ce.Tipo_cliente\n"
                            + "from	Cuestioario_evalua ce \n"
                            + "		inner join Empleado e\n"
                            + "		on ce.Evalua_empleado_id = e.Empleado_id\n"
                            + "where	ce.A_empleado_id = " + en.getEmpleado_id() + " and Cuestionario_gestion_id = '" + ciclo_id + "' and \n"
                            + "		Cuestionario_id = '" + c.getCuestionario_id() + "' and Tipo = 'Cliente' and Tipo_cliente = 'E'\n"
                            + "union\n"
                            + "select  c.Cliente_id Empleado_id, c.Nombre nombre , c.Correo email, ce.Tipo_cliente\n"
                            + "from	Cuestioario_evalua ce \n"
                            + "		inner join Cliente c\n"
                            + "		on ce.Evalua_empleado_id = c.Cliente_id\n"
                            + "where	ce.A_empleado_id = " + en.getEmpleado_id() + " and Cuestionario_gestion_id =  '" + ciclo_id + "'  and \n"
                            + "		Cuestionario_id = '" + c.getCuestionario_id() + "' and Tipo = 'Cliente' and Tipo_cliente = 'C'";
                    ResultSet Cliente_res = db.consulta(Cliente_eva);
                    while (Cliente_res.next()) {
                        Cliente cli = new Cliente();
                        cli.setCliente_id(Cliente_res.getInt("Empleado_id"));
                        cli.setNombre(Cliente_res.getString("Nombre"));
                        Cliente_evaluacion.add(cli);
                    }
                    en.setClientes(Cliente_evaluacion);

                }
                c.setView_Empleado_Encuesta(empleados);
                System.out.println(nivel);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Ciclo_reporteModel.AnadimosEmpleadoAlCuestionario()" + e.getMessage());
        }
        return cuestionario;
    }

}
