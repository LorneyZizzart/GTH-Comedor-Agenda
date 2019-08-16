package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cliente;
import Entidad.Cuestionario_empleado;
import Entidad.View_Empleado_Encuesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cuestionario_empleadoModelo {

    public String AddCuestionarioEmpleadoByCuestionario_id(int cuestionario_id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            List<String> Ids = new ArrayList<String>();

            //Optenemos los id empleados relacionados con los Departamentos 
            String dep = "Select Area_id from Sector_Cuestionario where Sector ='Departamento' and Cuestionario_id = '" + cuestionario_id + "' ";
            ResultSet depres = db.consulta(dep);
            while (depres.next()) {
                int idDep = depres.getInt("Area_id");
                String depEmple = "Select Empleado_id from Empleado_cargo where Departamento_id = '" + idDep + "' and Activo = '1' ";
                ResultSet emple = db.consulta(depEmple);
                while (emple.next()) {
                    Ids.add(emple.getString("Empleado_id"));
                }
            }

            //Optenemos los id empleados relacionados con los Nivel
            String niv = "Select Area_id from Sector_Cuestionario where Sector ='Nivel' and Cuestionario_id = '" + cuestionario_id + "' ";
            ResultSet nivres = db.consulta(niv);
            while (nivres.next()) {
                int idAre = nivres.getInt("Area_id");
                String depEmple = "Select Empleado_id from Empleado_cargo where Nivel_id = '" + idAre + "' and Activo = '1' ";
                ResultSet emple = db.consulta(depEmple);
                while (emple.next()) {
                    Ids.add(emple.getString("Empleado_id"));
                }
            }

            //Optenemos los id empleados relacionados con los Area
            String area = "Select Area_id from Sector_Cuestionario where Sector ='Area' and Cuestionario_id = '" + cuestionario_id + "'";
            ResultSet areares = db.consulta(area);
            while (areares.next()) {
                int idAre = areares.getInt("Area_id");
                String depEmple = "Select ec.Empleado_id \n"
                        + "from Empleado_cargo ec \n"
                        + "inner join Departamento d \n"
                        + "on ec.Departamento_id = d.Departamento_id\n"
                        + "where ec.Activo = '1' and d.Area_id = '" + idAre + "' ";
                ResultSet emple = db.consulta(depEmple);
                while (emple.next()) {
                    Ids.add(emple.getString("Empleado_id"));
                }
            }

            HashSet<String> hashSet = new HashSet<String>(Ids);
            Ids.clear();
            Ids.addAll(hashSet);

            for (String Id : Ids) {
                Cuestionario_empleado emple = new Cuestionario_empleado();
                emple.setEmpleado_id(Integer.parseInt(Id));
                emple.setCuestionario_id(cuestionario_id);
                respuesta = CreateCuestionarioEmpleado(emple);
            }

            db.cierraConexion();

        } catch (SQLException ex) {
            respuesta = "Modelo.Cuestionario_empleadoModelo.AddCuestionarioEmpleadoByCuestionario_id() " + ex;
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String CreateCuestionarioEmpleado(Cuestionario_empleado empleado) {
        String result = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Cuestionario_empleado\n"
                    + "           (Empleado_id, Cuestionario_id, Fecha_creacion, Estado)\n"
                    + "     VALUES\n"
                    + "           ('" + empleado.getEmpleado_id() + "','" + empleado.getCuestionario_id() + "',CONVERT(date, SYSDATETIME()),'1')";
            db.insertar(sql);
            db.cierraConexion();

        } catch (SQLException ex) {
            result = "Modelo.Cuestionario_empleadoModelo.CreateCuestionarioEmpleado() " + ex.getMessage();
            System.out.println(result);
        }
        return result;
    }

    public String DeleteEmpleadoByCuestionario_id(int id) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM Cuestionario_empleado\n"
                    + "      WHERE Cuestionario_id = '" + id + "'";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Cuestionario_empleadoModelo.DeleteEmpleadoByCuestionario_id() " + e.getMessage());
        }
        return mensaje;
    }

    public List<View_Empleado_Encuesta> GetEmpleadosEncuentaByCuestionarioID(int cuestionarioId) {
        List<View_Empleado_Encuesta> encuestados = new ArrayList<View_Empleado_Encuesta>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "Select Empleado_id from Cuestionario_empleado where Cuestionario_id  ='" + cuestionarioId + "' and Estado = '1'";
            ResultSet res = db.consulta(Sql);
            while (res.next()) {
                View_Empleado_Encuesta uno = new View_Empleado_Encuesta();
                String empleado = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                        + "from Empleado e \n"
                        + "inner join Empleado_cargo ec\n"
                        + "on e.Empleado_id = ec.Empleado_id\n"
                        + "inner join Nivel n \n"
                        + "on ec.Nivel_id = n.Nivel_id\n"
                        + "where ec.Activo = '1' and e.Empleado_id = '" + res.getInt("Empleado_id") + "'\n"
                        + "order by  n.Posicion ;";
                ResultSet unito = db.consulta(empleado);
                if (unito.next()) {
                    uno.setEmpleado_id(unito.getInt("Empleado_id"));
                    uno.setNombre_empleado(unito.getString("Nombre_empleado"));
                    uno.setNombre_nivel(unito.getString("Nombre_nivel"));
                    uno.setPosicion(unito.getInt("Posicion"));
                }

                // buscamos a los jefes
                List<View_Empleado_Encuesta> jefes = new ArrayList<View_Empleado_Encuesta>();
                String sqljefes = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                        + "from Empleado e \n"
                        + "inner join Empleado_cargo ec\n"
                        + "on e.Empleado_id = ec.Empleado_id\n"
                        + "inner join Nivel n \n"
                        + "on ec.Nivel_id = n.Nivel_id\n"
                        + "where ec.Activo = '1' and n.Posicion < " + uno.getPosicion() + " \n"
                        + "order by  n.Posicion";
                ResultSet jefesrest = db.consulta(sqljefes);
                while (jefesrest.next()) {
                    View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
                    jefe.setEmpleado_id(jefesrest.getInt("Empleado_id"));
                    jefe.setNombre_empleado(jefesrest.getString("Nombre_empleado"));
                    jefe.setNombre_nivel(jefesrest.getString("Nombre_nivel"));
                    jefe.setPosicion(jefesrest.getInt("Posicion"));
                    jefes.add(jefe);
                }
                uno.setJefes(jefes);

                // añadimos los pares
                List<View_Empleado_Encuesta> pares = new ArrayList<View_Empleado_Encuesta>();
                String sqlpares = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                        + "from Empleado e \n"
                        + "inner join Empleado_cargo ec\n"
                        + "on e.Empleado_id = ec.Empleado_id\n"
                        + "inner join Nivel n \n"
                        + "on ec.Nivel_id = n.Nivel_id\n"
                        + "where ec.Activo = '1' and n.Posicion = " + uno.getPosicion() + "  and not e.Empleado_id = '" + uno.getEmpleado_id() + "' \n"
                        + "order by  n.Posicion";
                ResultSet paresrest = db.consulta(sqlpares);
                while (paresrest.next()) {
                    View_Empleado_Encuesta par = new View_Empleado_Encuesta();
                    par.setEmpleado_id(paresrest.getInt("Empleado_id"));
                    par.setNombre_empleado(paresrest.getString("Nombre_empleado"));
                    par.setNombre_nivel(paresrest.getString("Nombre_nivel"));
                    par.setPosicion(paresrest.getInt("Posicion"));
                    pares.add(par);
                }
                uno.setPares(pares);

                // añadimos los bajos
                List<View_Empleado_Encuesta> bajos = new ArrayList<View_Empleado_Encuesta>();
                String sqlbajos = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                        + "from Empleado e \n"
                        + "inner join Empleado_cargo ec\n"
                        + "on e.Empleado_id = ec.Empleado_id\n"
                        + "inner join Nivel n \n"
                        + "on ec.Nivel_id = n.Nivel_id\n"
                        + "where ec.Activo = '1' and n.Posicion > " + uno.getPosicion() + "  \n"
                        + "order by  n.Posicion";
                ResultSet bajosrest = db.consulta(sqlbajos);
                while (bajosrest.next()) {
                    View_Empleado_Encuesta bajo = new View_Empleado_Encuesta();
                    bajo.setEmpleado_id(bajosrest.getInt("Empleado_id"));
                    bajo.setNombre_empleado(bajosrest.getString("Nombre_empleado"));
                    bajo.setNombre_nivel(bajosrest.getString("Nombre_nivel"));
                    bajo.setPosicion(bajosrest.getInt("Posicion"));
                    bajos.add(bajo);
                }
                uno.setBajos(bajos);

                ClienteModel cliente = new ClienteModel();
                uno.setClientes(cliente.getAllClientes());

                //Selecionamos a los que ya estan guardados en la db en la tabla Cuestioario_evalua
                // tiene conecion con a_empleado_id y Cuestionario_id
                List<View_Empleado_Encuesta> select_jefes = new ArrayList<View_Empleado_Encuesta>();
                String selectjefes = "SELECT Evalua_empleado_id\n"
                        + "FROM Cuestioario_evalua where A_empleado_id = '" + uno.getEmpleado_id() + "'  and Cuestionario_id = '" + cuestionarioId + "' and Tipo = 'Jefe' ";
                ResultSet selectjefesql = db.consulta(selectjefes);
                while (selectjefesql.next()) {
                    View_Empleado_Encuesta sj = new View_Empleado_Encuesta();
                    sj.setEmpleado_id(selectjefesql.getInt("Evalua_empleado_id"));
                    select_jefes.add(sj);
                }
                uno.setSelect_Jefes(select_jefes);

                List<View_Empleado_Encuesta> select_pares = new ArrayList<View_Empleado_Encuesta>();
                String selectpares = "SELECT Evalua_empleado_id\n"
                        + "FROM Cuestioario_evalua where A_empleado_id = '" + uno.getEmpleado_id() + "'  and Cuestionario_id = '" + cuestionarioId + "' and Tipo = 'Par' ";
                ResultSet selectparesql = db.consulta(selectpares);
                while (selectparesql.next()) {
                    View_Empleado_Encuesta sj = new View_Empleado_Encuesta();
                    sj.setEmpleado_id(selectparesql.getInt("Evalua_empleado_id"));
                    select_pares.add(sj);
                }
                uno.setSelect_Pares(select_pares);

                List<View_Empleado_Encuesta> select_bajos = new ArrayList<View_Empleado_Encuesta>();
                String selectbajos = "SELECT Evalua_empleado_id\n"
                        + "FROM Cuestioario_evalua where A_empleado_id = '" + uno.getEmpleado_id() + "'  and Cuestionario_id = '" + cuestionarioId + "' and Tipo = 'Bajo' ";
                ResultSet selectbajosql = db.consulta(selectbajos);
                while (selectbajosql.next()) {
                    View_Empleado_Encuesta sj = new View_Empleado_Encuesta();
                    sj.setEmpleado_id(selectbajosql.getInt("Evalua_empleado_id"));
                    select_bajos.add(sj);
                }
                uno.setSelect_Bajos(select_bajos);

                List<Cliente> select_cliente = new ArrayList<Cliente>();
                String selectcliente = "SELECT Evalua_empleado_id\n"
                        + "FROM Cuestioario_evalua where A_empleado_id = '" + uno.getEmpleado_id() + "'  and Cuestionario_id = '" + cuestionarioId + "' and Tipo = 'Cliente' ";
                ResultSet selectclientesql = db.consulta(selectcliente);
                
                while (selectclientesql.next()) {
                    Cliente sj = new Cliente();
                    sj.setCliente_id(selectclientesql.getInt("Evalua_empleado_id"));
                    select_cliente.add(sj);
                }
                uno.setSelect_Clientes(select_cliente);

                encuestados.add(uno);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Cuestionario_empleadoModelo.GetEmpleadosEncuentaByCuestionarioID() " + e.getMessage());
        }
        return encuestados;
    }

}
