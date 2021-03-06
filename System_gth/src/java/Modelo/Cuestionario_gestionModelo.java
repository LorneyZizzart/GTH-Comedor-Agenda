package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cliente;
import Entidad.Cuestionario;
import Entidad.Cuestionario_gestion;
import Entidad.View_Empleado_Encuesta;
import Entidad.View_Empleado_Gestion;
import Entidad.View_Enviar_correo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cuestionario_gestionModelo {

    public String SaveorUpdateCuestionario_gestion(Cuestionario_gestion gestion, List<String> empleado_id) {
        String respuesta = "Ok";
        try {
            if (gestion.getCuestionario_gestion_id() == 0) {
                //insertamos
                respuesta = InsertCuestionarioGestion(gestion, empleado_id);

            } else {
                //Actualizamo
                respuesta = UpdateCuestionario_gestion(gestion);
            }
        } catch (Exception e) {
            System.out.println("Controlador.Cuestionario_gestionModelo.SaveorUpdateCuestionario_gestion() " + e.getMessage());
        }
        return respuesta;
    }

    public String InsertCuestionarioGestion(Cuestionario_gestion gestion, List<String> empleado_id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Cuestionario_gestion\n"
                    + "           (Nombre, Fecha_creacion, Usuario_crea, Descripcion, Estado )\n"
                    + "     VALUES\n"
                    + "           ('" + gestion.getNombre() + "',CONVERT(date, SYSDATETIME()),'" + gestion.getUsuario_crea() + "', '" + gestion.getDescripciom() + "',1)";
            db.insertar(sql);
            int gestion_id = GetMaxCuestionariId();
            Cuestionario_gestion_empleadoModelo empleadosave = new Cuestionario_gestion_empleadoModelo();
            respuesta = empleadosave.Insert_Cuestionario_gestion_empleado(gestion_id, empleado_id);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Controlador.Cuestionario_gestionModelo.InsertCuestionarioGestion() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    private String UpdateCuestionario_gestion(Cuestionario_gestion gestion) {
        String respuesta = "Ok";
        try {

            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Cuestionario_gestion\n"
                    + "   SET Nombre = '" + gestion.getNombre() + "'      \n"
                    + "      ,Fecha_actualiza = CONVERT(date, SYSDATETIME()) \n"
                    + "      ,Usuario_actualiza = '" + gestion.getUsuario_actualiza() + "'\n"
                    + "      ,Estado = " + gestion.getEstado() + "\n"
                    + "      ,Descripcion = '" + gestion.getDescripciom() + "'\n"
                    + " WHERE Cuestionario_gestion_id = '" + gestion.getCuestionario_gestion_id() + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Controlador.Cuestionario_gestionModelo.UpdateCuestionario_gestion() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String DeleteCuestionario_gestion(int id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Cuestionario_gestion\n"
                    + "   SET Estado = 6\n"
                    + " WHERE Cuestionario_gestion_id = '" + id + "'";
            db.actualizar(sql);
            db.cierraConexion();

        } catch (SQLException e) {
            respuesta = "Controlador.Cuestionario_gestionModelo.DeleteCuestionario_gestion() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public Cuestionario_gestion GetCuestionario_gestionById(int id) {
        Cuestionario_gestion c = new Cuestionario_gestion();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Cuestionario_gestion_id, Nombre, Fecha_creacion, Usuario_crea, Fecha_actualiza, Usuario_actualiza, Estado, Descripcion, Mensaje_correo, Titulo_correo \n"
                    + "  FROM Cuestionario_gestion\n"
                    + "  WHERE Cuestionario_gestion_id = '" + id + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                c.setCuestionario_gestion_id(res.getInt("Cuestionario_gestion_id"));
                c.setNombre(res.getString("Nombre"));
                c.setFecha_creacion(res.getDate("Fecha_creacion"));
                c.setUsuario_crea(res.getInt("Usuario_crea"));
                c.setFecha_actualiza(res.getDate("Fecha_actualiza"));
                c.setEstado(res.getInt("Estado"));
                c.setDescripciom(res.getString("Descripcion"));
                c.setMensaje_correo(res.getString("Mensaje_correo"));
                c.setTitulo_correo(res.getString("Titulo_correo"));
                c.setEmpleados(GetAllEmpleadoGestionByIdGestion(id));
            }
            for (View_Empleado_Gestion empleado : c.getEmpleados()) {
                //Para ver si se seleccionaron los evaluadores
                //System.out.println("***** ***** ***** Cuestionario_id :" + id + " Empleado_id : " + empleado.getEmpleado_id());
                List<View_Empleado_Encuesta> cuestionarios = new ArrayList<View_Empleado_Encuesta>();
                cuestionarios = GetCuestionarioByGestionEmpleado(id, empleado.getEmpleado_id());
                int cantidad_encu = cuestionarios.size();
                int cantidad_llenado = 0;
                for (View_Empleado_Encuesta cu : cuestionarios) {
                    //System.out.println("   - " + cu.getCuestionario_Nombre());
                    int auto = 0;
                    if (cu.getAuto_evaluacion().equalsIgnoreCase("Ok")) {
                        auto = 1;
                    }
                    int totales_select = auto + cu.getSelect_Jefes().size() + cu.getSelect_Pares().size() + cu.getSelect_Bajos().size() + cu.getSelect_Clientes().size();
                    if (totales_select > 0) {
                        cantidad_llenado++;
                    }

                    //System.out.println("Auto eva : " + auto + " Can_jefe : " + cu.getSelect_Jefes().size() + " pares : " + cu.getSelect_Pares().size() + " bajo : " + cu.getSelect_Bajos().size() + "  cliente : " + cu.getSelect_Clientes().size());
                }
                //System.out.println("*/*/*/*/*/*/* Cantidad Encuesta: " + cantidad_encu + " Cantidad Llenado: " + cantidad_llenado);
                if (cantidad_encu > 0) {
                    if (cantidad_llenado == 0) {
                        empleado.setEstado_evaluadores(0);
                    } else {
                        if (cantidad_llenado == cantidad_encu) {
                            empleado.setEstado_evaluadores(2);
                        } else {
                            empleado.setEstado_evaluadores(1);
                        }
                    }
                } else {
                    empleado.setEstado_evaluadores(-1);
                }

                //Para ver si se enviaron los correos
                List<View_Enviar_correo> correos = new ArrayList<View_Enviar_correo>();
                correos = VerAquienEnviaCorreo(id, empleado.getEmpleado_id());

                int cantidad_encuestas = correos.size();
                int cantidad_llenado_correo = 0;
                for (View_Enviar_correo envi : correos) {
                    System.out.println("   - " + envi.getCuestionario_nombre());
                    int auto = 0;
                    if (envi.getAuto_evaluacion() != null) {
                        auto = 1;
                    }
                    int totales_select = auto + envi.getLista_jefes().size() + envi.getLista_pares().size() + envi.getLista_bajos().size() + envi.getLista_clientes().size();
                    if (totales_select > 0) {
                        cantidad_llenado_correo++;
                    }

                    System.out.println("Auto eva : " + auto + " Can_jefe : " + envi.getLista_jefes().size() + " pares : " + envi.getLista_pares().size() + " bajo : " + envi.getLista_bajos().size() + "  cliente : " + envi.getLista_clientes().size());
                }

                System.out.println("*/*/*/*/*/*/* Cantidad Enviado: " + cantidad_encuestas + " Cantidad Llenado: " + cantidad_llenado_correo);

                if (cantidad_encuestas > 0) {
                    if (cantidad_llenado_correo == 0) {
                        empleado.setEstado_correo(0);
                    } else {
                        if (cantidad_llenado_correo == cantidad_encuestas) {
                            empleado.setEstado_correo(2);
                        } else {
                            empleado.setEstado_correo(1);
                        }
                    }
                } else {
                    empleado.setEstado_correo(-1);
                }
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.Cuestionario_gestionModelo.GetCuestionario_gestionById() " + e.getMessage());
        }
        return c;
    }

    public List<Cuestionario_gestion> GetAllCuestionario_gestion() {
        List<Cuestionario_gestion> gestiones = new ArrayList<Cuestionario_gestion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Cuestionario_gestion_id, Nombre, Fecha_creacion, Usuario_crea, Fecha_actualiza, Usuario_actualiza, Estado, Descripcion,Gestion \n"
                    + "  FROM Cuestionario_gestion\n"
                    + "  WHERE Estado <> 6 ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Cuestionario_gestion c = new Cuestionario_gestion();
                c.setCuestionario_gestion_id(res.getInt("Cuestionario_gestion_id"));
                c.setNombre(res.getString("Nombre"));
                c.setFecha_creacion(res.getDate("Fecha_creacion"));
                c.setUsuario_crea(res.getInt("Usuario_crea"));
                c.setFecha_actualiza(res.getDate("Fecha_actualiza"));
                c.setEstado(res.getInt("Estado"));
                c.setDescripciom(res.getString("Descripcion"));
                c.setGestion(res.getString("Gestion"));
                gestiones.add(c);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.Cuestionario_gestionModelo.GetAllCuestionario_gestion() " + e.getMessage());
        }
        return gestiones;
    }

    public List<View_Empleado_Gestion> GetAllEmpleadoGestion() {
        List<View_Empleado_Gestion> empleados = new ArrayList<View_Empleado_Gestion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select e.Empleado_id, CONCAT(e.Apellido_paterno,' ', e.Apellido_materno,' ',e.Nombre) Nombre_empleado, c.Nombre Nombre_cargo, d.Nombre nombre_departamento\n"
                    + "from Empleado e\n"
                    + "inner join Empleado_cargo ec \n"
                    + "on ec.Empleado_id = e.Empleado_id\n"
                    + "inner join Cargo c\n"
                    + "on c.Cargo_id = ec.Cargo_id\n"
                    + "inner join Departamento d\n"
                    + "on d.Departamento_id = ec.Departamento_id\n"
                    + "where e.Estado = '1' and ec.Activo = '1' order by d.Nombre, e.Apellido_paterno";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                View_Empleado_Gestion e = new View_Empleado_Gestion();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre_empleado(res.getString("Nombre_empleado"));
                e.setNombre_cargo(res.getString("Nombre_cargo"));
                e.setNombre_departamento(res.getString("nombre_departamento"));
                empleados.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.Cuestionario_gestionModelo.GetAllEmpleadoGestion() " + e.getMessage());
        }
        return empleados;
    }

    public int GetMaxCuestionariId() {
        int id = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select MAX( Cuestionario_gestion_id ) id from Cuestionario_gestion ";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getInt("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.Cuestionario_gestionModelo.GetMaxCuestionariId() " + e.getMessage());
        }
        return id;
    }

    public List<View_Empleado_Gestion> GetAllEmpleadoGestionByIdGestion(int gestion_id) {
        List<View_Empleado_Gestion> empleados = new ArrayList<View_Empleado_Gestion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select e.Empleado_id, CONCAT(e.Apellido_paterno,' ', e.Apellido_materno,' ',e.Nombre) Nombre_empleado, c.Nombre Nombre_cargo, d.Nombre nombre_departamento, cge.Cuestionario_gestion_empleado_id\n"
                    + "from Empleado e\n"
                    + "inner join Empleado_cargo ec \n"
                    + "on ec.Empleado_id = e.Empleado_id\n"
                    + "inner join Cargo c\n"
                    + "on c.Cargo_id = ec.Cargo_id\n"
                    + "inner join Departamento d\n"
                    + "on d.Departamento_id = ec.Departamento_id \n"
                    + "inner join Cuestionario_gestion_empleado cge\n"
                    + "on e.Empleado_id = cge.Empleado_id\n"
                    + "inner join Cuestionario_gestion cg\n"
                    + "on cg.Cuestionario_gestion_id = cge.Cuestionario_gestion_id\n"
                    + "where e.Estado = '1' and ec.Activo = '1' and cg.Cuestionario_gestion_id = '" + gestion_id + "' \n"
                    + "order by d.Nombre, e.Apellido_paterno";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                View_Empleado_Gestion e = new View_Empleado_Gestion();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre_empleado(res.getString("Nombre_empleado"));
                e.setNombre_cargo(res.getString("Nombre_cargo"));
                e.setNombre_departamento(res.getString("nombre_departamento"));
                e.setCuestionario_gestion_empleado_id(res.getInt("Cuestionario_gestion_empleado_id"));
                empleados.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.Cuestionario_gestionModelo.GetAllEmpleadoGestion() " + e.getMessage());
        }
        return empleados;
    }

    public String DeleteEmpledadodeGestion(int Cuestionario_gestion_empleado_id) {
        Cuestionario_gestion_empleadoModelo c = new Cuestionario_gestion_empleadoModelo();
        return c.DeleteEmpledadodeGestion(Cuestionario_gestion_empleado_id);
    }

    public List<View_Empleado_Gestion> GetAllEmpleadoNoRegistradoEnGestion(int gestion) {
        List<View_Empleado_Gestion> empleados = new ArrayList<View_Empleado_Gestion>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select e.Empleado_id, CONCAT(e.Apellido_paterno,' ', e.Apellido_materno,' ',e.Nombre) Nombre_empleado, c.Nombre Nombre_cargo, d.Nombre nombre_departamento\n"
                    + "from Empleado e\n"
                    + "inner join Empleado_cargo ec \n"
                    + "on ec.Empleado_id = e.Empleado_id\n"
                    + "inner join Cargo c\n"
                    + "on c.Cargo_id = ec.Cargo_id\n"
                    + "inner join Departamento d\n"
                    + "on d.Departamento_id = ec.Departamento_id\n"
                    + "where e.Estado = '1' and ec.Activo = '1' and e.Empleado_id not in (select Empleado_id from Cuestionario_gestion_empleado where Cuestionario_gestion_id = '" + gestion + "') order by d.Nombre, e.Apellido_paterno";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                View_Empleado_Gestion e = new View_Empleado_Gestion();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre_empleado(res.getString("Nombre_empleado"));
                e.setNombre_cargo(res.getString("Nombre_cargo"));
                e.setNombre_departamento(res.getString("nombre_departamento"));
                empleados.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Controlador.Cuestionario_gestionModelo.GetAllEmpleadoGestion() " + e.getMessage());
        }
        return empleados;
    }

    public String AgregaEmpleadoAGestion(int cuestionario_gestion_id, List<String> IdEmpleado) {
        Cuestionario_gestion_empleadoModelo empleadosave = new Cuestionario_gestion_empleadoModelo();
        return empleadosave.Insert_Cuestionario_gestion_empleado(cuestionario_gestion_id, IdEmpleado);
    }

    public List<View_Empleado_Encuesta> GetCuestionarioByGestionEmpleado(int gestion_id, int empleado_id) {
        //List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();
        List<View_Empleado_Encuesta> Encuestas_empleado = new ArrayList<View_Empleado_Encuesta>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            int cargo_id = 0;
            int dep_id = 0;

            int personal_id = 0;
            String personal_nombre = "";
            int personal_posicion = 0;

            String sqlDatoPersonal = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                    + "from Empleado e \n"
                    + "inner join Empleado_cargo ec\n"
                    + "on e.Empleado_id = ec.Empleado_id\n"
                    + "inner join Nivel n \n"
                    + "on ec.Nivel_id = n.Nivel_id\n"
                    + "where ec.Activo = '1' and e.Empleado_id = '" + empleado_id + "'\n"
                    + "order by  n.Posicion ";
            ResultSet resdatoEmple = db.consulta(sqlDatoPersonal);
            if (resdatoEmple.next()) {
                personal_id = resdatoEmple.getInt("Empleado_id");
                personal_nombre = resdatoEmple.getString("Nombre_empleado");
                personal_posicion = resdatoEmple.getInt("Posicion");
            }

            List<String> cuestioanrio_id = new ArrayList<String>();

            String Sql = "select ec.Departamento_id, ec.Cargo_id \n"
                    + "from Cuestionario_gestion_empleado  c\n"
                    + "inner join Cuestionario_gestion cg \n"
                    + "on c.Cuestionario_gestion_id = cg.Cuestionario_gestion_id \n"
                    + "inner join Empleado_cargo ec\n"
                    + "on c.Empleado_id = ec.Empleado_id\n"
                    + "where cg.Cuestionario_gestion_id = '" + gestion_id + "' and c.Empleado_id  = '" + empleado_id + "' ";
//            System.out.println(" " + Sql);
            ResultSet res = db.consulta(Sql);
            if (res.next()) {
                cargo_id = res.getInt("Cargo_id");
                dep_id = res.getInt("Departamento_id");
            }

            // Traemos todos con los id_cuestionario que tiene coincidencia en cargos 
            String sqlCargo = "select c.Cuestionario_id from Cuestionario c \n"
                    + "inner join Sector_Cuestionario sc\n"
                    + "on c.Cuestionario_id = sc.Cuestionario_id \n"
                    + "where Estado = '1' and Sector = 'Cargo' and Area_id = '" + cargo_id + "' ";
            ResultSet resCargo = db.consulta(sqlCargo);
            while (resCargo.next()) {
                cuestioanrio_id.add(resCargo.getString("Cuestionario_id"));
            }

            // Traemos todos con los id_cuestionario que tiene coincidencia en departamento  
            String sqlDep = "select c.Cuestionario_id from Cuestionario c \n"
                    + "inner join Sector_Cuestionario sc\n"
                    + "on c.Cuestionario_id = sc.Cuestionario_id \n"
                    + "where Estado = '1' and Sector = 'Departamento' and Area_id = '" + dep_id + "' ";
            ResultSet resDep = db.consulta(sqlDep);
            while (resDep.next()) {
                cuestioanrio_id.add(resDep.getString("Cuestionario_id"));
            }

            // eliminarmos los id repetidos 
            Set<String> hashSet = new HashSet<String>(cuestioanrio_id);
            cuestioanrio_id.clear();
            cuestioanrio_id.addAll(hashSet);

            CuestionarioModel cues_mod = new CuestionarioModel();

            for (String item : cuestioanrio_id) {
                //cuestionarios.add(cues_mod.GetCuestionariobyCuestionario_id(Integer.parseInt(item)));
                Cuestionario c = new Cuestionario();
                c = cues_mod.GetCuestionariobyCuestionario_id(Integer.parseInt(item));
                if (c != null) {
                    View_Empleado_Encuesta en_em = new View_Empleado_Encuesta();
                    en_em.setEmpleado_id(personal_id);
                    en_em.setNombre_empleado(personal_nombre);
                    en_em.setCuestionario_id(c.getCuestionario_id());
                    en_em.setCuestionario_Nombre(c.getNombre());
                    // buscamos a los jefes
                    List<View_Empleado_Encuesta> jefes = new ArrayList<View_Empleado_Encuesta>();
                    String sqljefes = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                            + "from Empleado e \n"
                            + "inner join Empleado_cargo ec\n"
                            + "on e.Empleado_id = ec.Empleado_id\n"
                            + "inner join Nivel n \n"
                            + "on ec.Nivel_id = n.Nivel_id\n"
                            // "where ec.Activo = '1' and n.Posicion < " + personal_posicion + " \n"
                            + "where ec.Activo = '1' and not e.Empleado_id = '" + personal_id + "'  \n"
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
                    en_em.setJefes(jefes);

                    // añadimos los pares
                    List<View_Empleado_Encuesta> pares = new ArrayList<View_Empleado_Encuesta>();
                    String sqlpares = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                            + "from Empleado e \n"
                            + "inner join Empleado_cargo ec\n"
                            + "on e.Empleado_id = ec.Empleado_id\n"
                            + "inner join Nivel n \n"
                            + "on ec.Nivel_id = n.Nivel_id\n"
                            // "where ec.Activo = '1' and n.Posicion = " + personal_posicion + "  and not e.Empleado_id = '" + personal_id + "' \n"
                            + "where ec.Activo = '1' and not e.Empleado_id = '" + personal_id + "' \n"
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
                    en_em.setPares(pares);

                    // añadimos los bajos
                    List<View_Empleado_Encuesta> bajos = new ArrayList<View_Empleado_Encuesta>();
                    String sqlbajos = "select e.Empleado_id, CONCAT( e.Apellido_paterno,' ', e.Apellido_materno,' ', e.Nombre) Nombre_empleado, n.Nombre Nombre_nivel, n.Posicion\n"
                            + "from Empleado e \n"
                            + "inner join Empleado_cargo ec\n"
                            + "on e.Empleado_id = ec.Empleado_id\n"
                            + "inner join Nivel n \n"
                            + "on ec.Nivel_id = n.Nivel_id\n"
                            // "where ec.Activo = '1' and n.Posicion > " + personal_posicion + "  \n"
                            + "where ec.Activo = '1' and not e.Empleado_id = '" + personal_id + "'  \n"
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
                    en_em.setBajos(bajos);
                    ClienteModel cliente = new ClienteModel();
                    en_em.setClientes(cliente.getAllClientesMixEmple());

                    Encuestas_empleado.add(en_em);

                    //seleccionamos a los jefes que se asignaron
                    List<View_Empleado_Encuesta> Select_Jefes = new ArrayList<View_Empleado_Encuesta>();
                    String sqlSelectJefes = "select Evalua_empleado_id from Cuestioario_evalua \n"
                            + "where Cuestionario_id = '" + c.getCuestionario_id() + "' and A_empleado_id = '" + personal_id + "' and Cuestionario_gestion_id = '" + gestion_id + "' and Tipo = 'Jefe' ";
                    ResultSet res_sqlSelectJefes = db.consulta(sqlSelectJefes);
                    while (res_sqlSelectJefes.next()) {
                        View_Empleado_Encuesta Selected_Jefes = new View_Empleado_Encuesta();
                        Selected_Jefes.setEmpleado_id(res_sqlSelectJefes.getInt("Evalua_empleado_id"));
                        Select_Jefes.add(Selected_Jefes);
                    }
                    en_em.setSelect_Jefes(Select_Jefes);

                    //seleccionamos a los pares que se asignaron
                    List<View_Empleado_Encuesta> Select_pares = new ArrayList<View_Empleado_Encuesta>();
                    String sqlSelect_pares = "select Evalua_empleado_id from Cuestioario_evalua \n"
                            + "where Cuestionario_id = '" + c.getCuestionario_id() + "' and A_empleado_id = '" + personal_id + "' and Cuestionario_gestion_id = '" + gestion_id + "' and Tipo = 'Par' ";
                    ResultSet res_sqlSelect_pares = db.consulta(sqlSelect_pares);
                    while (res_sqlSelect_pares.next()) {
                        View_Empleado_Encuesta Selected_Par = new View_Empleado_Encuesta();
                        Selected_Par.setEmpleado_id(res_sqlSelect_pares.getInt("Evalua_empleado_id"));
                        Select_pares.add(Selected_Par);
                    }
                    en_em.setSelect_Pares(Select_pares);

                    //seleccionamos a los Bajos que se asignaron
                    List<View_Empleado_Encuesta> Select_bajos = new ArrayList<View_Empleado_Encuesta>();
                    String sqlSelect_bajos = "select Evalua_empleado_id from Cuestioario_evalua \n"
                            + "where Cuestionario_id = '" + c.getCuestionario_id() + "' and A_empleado_id = '" + personal_id + "' and Cuestionario_gestion_id = '" + gestion_id + "' and Tipo = 'Bajo' ";
                    ResultSet res_sqlSelect_bajos = db.consulta(sqlSelect_bajos);
                    while (res_sqlSelect_bajos.next()) {
                        View_Empleado_Encuesta Selected_Par = new View_Empleado_Encuesta();
                        Selected_Par.setEmpleado_id(res_sqlSelect_bajos.getInt("Evalua_empleado_id"));
                        Select_bajos.add(Selected_Par);
                    }
                    en_em.setSelect_Bajos(Select_bajos);

                    //seleccionamos a los Clientes que se asignaron
                    List<Cliente> Select_Clientes = new ArrayList<Cliente>();
                    String sqlSelect_clientes = "select Evalua_empleado_id ,Tipo_cliente from Cuestioario_evalua \n"
                            + "where Cuestionario_id = '" + c.getCuestionario_id() + "' and A_empleado_id = '" + personal_id + "' and Cuestionario_gestion_id = '" + gestion_id + "' and Tipo = 'Cliente' ";
                    System.out.println("******* Select_Clientes : " + sqlSelect_clientes);
                    ResultSet res_sqlSelect_clientes = db.consulta(sqlSelect_clientes);
                    while (res_sqlSelect_clientes.next()) {
                        Cliente Selected_cli = new Cliente();
                        Selected_cli.setCliente_id(res_sqlSelect_clientes.getInt("Evalua_empleado_id"));
                        Selected_cli.setTelefono(res_sqlSelect_clientes.getString("Tipo_cliente"));
                        Select_Clientes.add(Selected_cli);
                    }
                    en_em.setSelect_Clientes(Select_Clientes);

                    // verificamos si se autoevaluara 
                    String SelectAutoevaluacion = "";
                    String sqlAutoEvaluacion = "select Evalua_empleado_id from Cuestioario_evalua \n"
                            + "where Cuestionario_id = '" + c.getCuestionario_id() + "' and A_empleado_id = '" + personal_id + "' and Cuestionario_gestion_id = '" + gestion_id + "' and Tipo = 'Autoevaluacion' ";
                    ResultSet res_sqlSelect_auto = db.consulta(sqlAutoEvaluacion);
                    while (res_sqlSelect_auto.next()) {
                        SelectAutoevaluacion = "Ok";
                    }
// verificamos si se envio correo de este cuestionario 
                    String sql_verif_envio_correo = "select  count(*) Total from Cuestioario_evalua \n"
                            + "where Cuestionario_id = '" + c.getCuestionario_id() + "' and A_empleado_id = '" + personal_id + "' and Cuestionario_gestion_id = '" + gestion_id + "' and Envio_correo = '1' ";
                    ResultSet res_mail = db.consulta(sql_verif_envio_correo);
                    if (res_mail.next()) {
                        en_em.setVerifica_correo(res_mail.getInt("Total"));
                    }
                    en_em.setAuto_evaluacion(SelectAutoevaluacion);
                }
            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Cuestionario_gestionModelo.GetCuestionarioByGestionEmpleado() " + e.getMessage());
        }
        //return cuestionarios;
        return Encuestas_empleado;
    }

    public List<View_Enviar_correo> GetAquienEnviaCorreo(int Cuestionario_gestion_id, int Empleado_id) {
        List<View_Enviar_correo> enviar_correos = new ArrayList<View_Enviar_correo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            List<String> ListaId = new ArrayList<String>();
            String sqlIds = "select DISTINCT(ce.Cuestionario_id)Cuestionario_id \n"
                    + "from Cuestioario_evalua ce \n"
                    + "where ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.A_empleado_id = '" + Empleado_id + "' \n"
                    + "order by ce.Cuestionario_id ";
            System.out.println(sqlIds);
            ResultSet resids = db.consulta(sqlIds);
            while (resids.next()) {
                ListaId.add(resids.getString("Cuestionario_id"));
            }

            for (String id_cuestionario : ListaId) {
                View_Enviar_correo correo_enviar = new View_Enviar_correo();
                //private int Cuestionario_id;
                //private String Cuestionario_nombre;
                correo_enviar.setCuestionario_gestion_id(Cuestionario_gestion_id);
                correo_enviar.setEmpleado_id(Empleado_id);

                String selectCuestio = "select Cuestionario_id, Nombre from Cuestionario where Cuestionario_id = '" + id_cuestionario + "'";
                ResultSet resgetcu = db.consulta(selectCuestio);

                System.out.println(" - " + selectCuestio);
                if (resgetcu.next()) {
                    correo_enviar.setCuestionario_id(resgetcu.getInt("Cuestionario_id"));
                    correo_enviar.setCuestionario_nombre(resgetcu.getString("Nombre"));
                }
                /*
                / Autoevaluacion 
                 */
                View_Empleado_Encuesta auto_eva = new View_Empleado_Encuesta();
                String sql_Auto = "select e.Empleado_id, (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, ce.envio_correo ,ce.LLeno_cuestionario\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Autoevaluacion' ";
                System.err.println(" Auto Evaluacion : " + sql_Auto);
                ResultSet res_auto = db.consulta(sql_Auto);
                if (res_auto.next()) {
                    auto_eva.setEmpleado_id(res_auto.getInt("Empleado_id"));
                    auto_eva.setNombre_empleado(res_auto.getString("Nombre_evaluador"));
                    auto_eva.setCorreo_electonico(res_auto.getString("email"));
                    auto_eva.setCuestionario_evalua_id(res_auto.getInt("Cuestionario_evalua_id"));
                    auto_eva.setEnvio_correo(res_auto.getInt("envio_correo"));
                    auto_eva.setLleno_cuestionario(res_auto.getInt("LLeno_cuestionario"));

                    correo_enviar.setAuto_evaluacion(auto_eva);
                }
                /*
                / Jefes
                 */
                List<View_Empleado_Encuesta> Jefe_eva = new ArrayList<View_Empleado_Encuesta>();
                String sql_jefes = "select e.Empleado_id, (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, ce.envio_correo ,ce.LLeno_cuestionario\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Jefe' ";
                ResultSet res_jefe = db.consulta(sql_jefes);
                while (res_jefe.next()) {
                    View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
                    jefe.setEmpleado_id(res_jefe.getInt("Empleado_id"));
                    jefe.setNombre_empleado(res_jefe.getString("Nombre_evaluador"));
                    jefe.setCorreo_electonico(res_jefe.getString("email"));
                    jefe.setCuestionario_evalua_id(res_jefe.getInt("Cuestionario_evalua_id"));
                    jefe.setEnvio_correo(res_jefe.getInt("envio_correo"));
                    jefe.setLleno_cuestionario(res_jefe.getInt("LLeno_cuestionario"));
                    Jefe_eva.add(jefe);
                }
                correo_enviar.setLista_jefes(Jefe_eva);

                /*
                / Pares
                 */
                List<View_Empleado_Encuesta> Pares_eva = new ArrayList<View_Empleado_Encuesta>();
                String sql_pares = "select e.Empleado_id, (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, ce.envio_correo ,ce.LLeno_cuestionario\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Par' ";
                ResultSet res_pares = db.consulta(sql_pares);
                while (res_pares.next()) {
                    View_Empleado_Encuesta par = new View_Empleado_Encuesta();
                    par.setEmpleado_id(res_pares.getInt("Empleado_id"));
                    par.setNombre_empleado(res_pares.getString("Nombre_evaluador"));
                    par.setCorreo_electonico(res_pares.getString("email"));
                    par.setCuestionario_evalua_id(res_pares.getInt("Cuestionario_evalua_id"));
                    par.setEnvio_correo(res_pares.getInt("envio_correo"));
                    par.setLleno_cuestionario(res_pares.getInt("LLeno_cuestionario"));
                    Pares_eva.add(par);
                }
                correo_enviar.setLista_pares(Pares_eva);

                /*
                / Bajos
                 */
                List<View_Empleado_Encuesta> Pares_bajos = new ArrayList<View_Empleado_Encuesta>();
                String sql_bajos = "select  e.Empleado_id, (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, ce.envio_correo ,ce.LLeno_cuestionario\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Bajo' ";
                ResultSet res_bajos = db.consulta(sql_bajos);
                while (res_bajos.next()) {
                    View_Empleado_Encuesta bajo = new View_Empleado_Encuesta();
                    bajo.setEmpleado_id(res_bajos.getInt("Empleado_id"));
                    bajo.setNombre_empleado(res_bajos.getString("Nombre_evaluador"));
                    bajo.setCorreo_electonico(res_bajos.getString("email"));
                    bajo.setCuestionario_evalua_id(res_bajos.getInt("Cuestionario_evalua_id"));
                    bajo.setEnvio_correo(res_bajos.getInt("envio_correo"));
                    bajo.setLleno_cuestionario(res_bajos.getInt("LLeno_cuestionario"));
                    Pares_bajos.add(bajo);
                }
                correo_enviar.setLista_bajos(Pares_bajos);

                /*
                / Cliente
                 */
                List<View_Empleado_Encuesta> envia_cliente = new ArrayList<View_Empleado_Encuesta>();
                String sql_cliente1 = "select ce.evalua_empleado_id,e.Nombre Nombre_evaluador, e.Correo email, ce.Cuestionario_evalua_id, ce.envio_correo ,ce.LLeno_cuestionario\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Cliente e\n"
                        + "on e.Cliente_id= ce.Evalua_empleado_id "
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.Tipo_cliente = 'Cliente' ";
                String sql_cliente = "select ce.evalua_empleado_id,e.Nombre Nombre_evaluador, e.Correo email, ce.Cuestionario_evalua_id, ce.envio_correo ,ce.LLeno_cuestionario, ce.Tipo_cliente\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Cliente e\n"
                        + "on e.Cliente_id= ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Cliente' and ce.Tipo_cliente ='C'\n"
                        + "union\n"
                        + "select ce.evalua_empleado_id, CONCAT(em.Apellido_paterno,' ',em.Apellido_materno,' ',em.Nombre)Nombre_evaluador,em.email, ce.Cuestionario_evalua_id, ce.envio_correo ,ce.LLeno_cuestionario, ce.Tipo_cliente\n"
                        + "from Cuestioario_evalua ce\n"
                        + "inner join Empleado em\n"
                        + "on ce.Evalua_empleado_id = em.Empleado_id\n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Cliente' and ce.Tipo_cliente ='E'";

                System.out.println("Cliente cuestionario : " + sql_cliente);
                ResultSet res_cliente = db.consulta(sql_cliente);

                while (res_cliente.next()) {
                    View_Empleado_Encuesta cli = new View_Empleado_Encuesta();
                    cli.setEmpleado_id(res_cliente.getInt("Evalua_empleado_id"));
                    cli.setNombre_empleado(res_cliente.getString("Nombre_evaluador"));
                    cli.setCorreo_electonico(res_cliente.getString("email"));
                    cli.setCuestionario_evalua_id(res_cliente.getInt("Cuestionario_evalua_id"));
                    cli.setEnvio_correo(res_cliente.getInt("envio_correo"));
                    cli.setLleno_cuestionario(res_cliente.getInt("LLeno_cuestionario"));
                    envia_cliente.add(cli);
                }
                correo_enviar.setLista_clientes(envia_cliente);

                enviar_correos.add(correo_enviar);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Cuestionario_gestionModelo.GetAquienEnviaCorreo() " + e.getMessage());
        }
        return enviar_correos;
    }

    public String SaveCorreoMensaje(String Cuestionario_gestion_id, String Mensaje_correo, String titulo_correo) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Cuestionario_gestion\n"
                    + "   SET Mensaje_correo = '" + Mensaje_correo + "', "
                    + "   Titulo_correo = '" + titulo_correo + "'\n"
                    + " WHERE Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Cuestionario_gestionModelo.SaveCorreoMensaje() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<View_Enviar_correo> VerAquienEnviaCorreo(int Cuestionario_gestion_id, int Empleado_id) {

        List<View_Enviar_correo> enviar_correos = new ArrayList<View_Enviar_correo>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            List<String> ListaId = new ArrayList<String>();
            String sqlIds = "select DISTINCT(ce.Cuestionario_id)Cuestionario_id \n"
                    + "from Cuestioario_evalua ce \n"
                    + "where ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.A_empleado_id = '" + Empleado_id + "' \n"
                    + "order by ce.Cuestionario_id ";
            //System.out.println(sqlIds);
            ResultSet resids = db.consulta(sqlIds);
            while (resids.next()) {
                ListaId.add(resids.getString("Cuestionario_id"));
            }

            for (String id_cuestionario : ListaId) {
                View_Enviar_correo correo_enviar = new View_Enviar_correo();
                //private int Cuestionario_id;
                //private String Cuestionario_nombre;
                correo_enviar.setCuestionario_gestion_id(Cuestionario_gestion_id);
                correo_enviar.setEmpleado_id(Empleado_id);

                String selectCuestio = "select Cuestionario_id, Nombre from Cuestionario where Cuestionario_id = '" + id_cuestionario + "'";
                ResultSet resgetcu = db.consulta(selectCuestio);

                // System.out.println(" - " + selectCuestio);
                if (resgetcu.next()) {
                    correo_enviar.setCuestionario_id(resgetcu.getInt("Cuestionario_id"));
                    correo_enviar.setCuestionario_nombre(resgetcu.getString("Nombre"));
                }
                /*
                / Autoevaluacion 
                 */
                View_Empleado_Encuesta auto_eva = new View_Empleado_Encuesta();
                String sql_Auto = "select (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, Envio_correo\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Autoevaluacion' and ce.Envio_correo  ='1' ";
                // System.err.println(" Auto Evaluacion : " + sql_Auto);
                ResultSet res_auto = db.consulta(sql_Auto);
                if (res_auto.next()) {
                    auto_eva.setNombre_empleado(res_auto.getString("Nombre_evaluador"));
                    auto_eva.setCorreo_electonico(res_auto.getString("email"));
                    auto_eva.setCuestionario_evalua_id(res_auto.getInt("Cuestionario_evalua_id"));
                    correo_enviar.setAuto_evaluacion(auto_eva);
                }
                /*
                / Jefes
                 */
                List<View_Empleado_Encuesta> Jefe_eva = new ArrayList<View_Empleado_Encuesta>();
                String sql_jefes = "select (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, Envio_correo\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Jefe' and ce.Envio_correo  ='1' ";
                ResultSet res_jefe = db.consulta(sql_jefes);
                while (res_jefe.next()) {
                    View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
                    jefe.setNombre_empleado(res_jefe.getString("Nombre_evaluador"));
                    jefe.setCorreo_electonico(res_jefe.getString("email"));
                    jefe.setCuestionario_evalua_id(res_jefe.getInt("Cuestionario_evalua_id"));
                    Jefe_eva.add(jefe);
                }
                correo_enviar.setLista_jefes(Jefe_eva);

                /*
                / Pares
                 */
                List<View_Empleado_Encuesta> Pares_eva = new ArrayList<View_Empleado_Encuesta>();
                String sql_pares = "select (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, Envio_correo\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Par' and ce.Envio_correo  ='1' ";
                ResultSet res_pares = db.consulta(sql_pares);
                while (res_pares.next()) {
                    View_Empleado_Encuesta par = new View_Empleado_Encuesta();
                    par.setNombre_empleado(res_pares.getString("Nombre_evaluador"));
                    par.setCorreo_electonico(res_pares.getString("email"));
                    par.setCuestionario_evalua_id(res_pares.getInt("Cuestionario_evalua_id"));
                    Pares_eva.add(par);
                }
                correo_enviar.setLista_pares(Pares_eva);

                /*
                / Bajos
                 */
                List<View_Empleado_Encuesta> Pares_bajos = new ArrayList<View_Empleado_Encuesta>();
                String sql_bajos = "select (e.Apellido_paterno +' '+e.Apellido_materno+' '+e.Nombre) Nombre_evaluador, e.email, ce.Cuestionario_evalua_id, Envio_correo\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Empleado e\n"
                        + "on e.Empleado_id = ce.Evalua_empleado_id \n"
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Bajo' and ce.Envio_correo  ='1' ";
                ResultSet res_bajos = db.consulta(sql_bajos);
                while (res_bajos.next()) {
                    View_Empleado_Encuesta bajo = new View_Empleado_Encuesta();
                    bajo.setNombre_empleado(res_bajos.getString("Nombre_evaluador"));
                    bajo.setCorreo_electonico(res_bajos.getString("email"));
                    bajo.setCuestionario_evalua_id(res_bajos.getInt("Cuestionario_evalua_id"));
                    Pares_bajos.add(bajo);
                }
                correo_enviar.setLista_bajos(Pares_bajos);

                /*
                / Cliente
                 */
                List<View_Empleado_Encuesta> envia_cliente = new ArrayList<View_Empleado_Encuesta>();
                String sql_cliente = "select e.Nombre Nombre_evaluador, e.Correo email, ce.Cuestionario_evalua_id, Envio_correo\n"
                        + "from Cuestioario_evalua ce \n"
                        + "inner join Cliente e\n"
                        + "on e.Cliente_id= ce.Evalua_empleado_id "
                        + "where ce.Cuestionario_id = '" + id_cuestionario + "' and ce.A_empleado_id = '" + Empleado_id + "' and ce.Cuestionario_gestion_id = '" + Cuestionario_gestion_id + "' and ce.tipo = 'Cliente' and ce.Envio_correo  ='1' ";
                ResultSet res_cliente = db.consulta(sql_cliente);
                while (res_cliente.next()) {
                    View_Empleado_Encuesta cli = new View_Empleado_Encuesta();
                    cli.setNombre_empleado(res_cliente.getString("Nombre_evaluador"));
                    cli.setCorreo_electonico(res_cliente.getString("email"));
                    cli.setCuestionario_evalua_id(res_cliente.getInt("Cuestionario_evalua_id"));
                    envia_cliente.add(cli);
                }
                correo_enviar.setLista_clientes(envia_cliente);

                enviar_correos.add(correo_enviar);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Cuestionario_gestionModelo.GetAquienEnviaCorreo() " + e.getMessage());
        }
        return enviar_correos;
    }
}
