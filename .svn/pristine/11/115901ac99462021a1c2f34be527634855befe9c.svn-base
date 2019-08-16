package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cuestionario;
import Entidad.Pregunta;
import Entidad.Sector_Cuestionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuestionarioModel {
    
    public List<Cuestionario> GetAllCuestionario() {
        List<Cuestionario> Cuestionarios = new ArrayList<Cuestionario>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Cuestionario_id, Nombre, Estado, Fecha_cracion, Usuario_crea, Fecha_actualiza, Usuario_actualiza, Detalle\n"
                    + "FROM Cuestionario WHERE Estado <>6 ";
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
                Cuestionarios.add(c);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.CuestionarioModel.GetAllCuestionario() " + e.getMessage());
        }
        return Cuestionarios;
    }
    
    public Cuestionario GetCuestionariobyCuestionario_id(int cuestionario_id) {
        Cuestionario c = new Cuestionario();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Cuestionario_id, Nombre, Estado, Fecha_cracion, Usuario_crea, Fecha_actualiza, Usuario_actualiza, Detalle\n"
                    + "FROM Cuestionario WHERE Cuestionario_id= '" + cuestionario_id + "' ";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                c.setCuestionario_id(res.getInt("Cuestionario_id"));
                c.setNombre(res.getString("Nombre"));
                c.setEstado(res.getInt("Estado"));
                c.setFecha_cracion(res.getDate("Fecha_cracion"));
                c.setUsuario_crea(res.getInt("Usuario_crea"));
                c.setFecha_actualiza(res.getDate("Fecha_actualiza"));
                c.setUsuario_actualiza(res.getInt("Usuario_actualiza"));
                c.setDetalle(res.getString("Detalle"));
            }
            Sector_CuestionarioModel sector = new Sector_CuestionarioModel();
            c.setSectores(sector.GetAllAreasByCuestionario_id(cuestionario_id));
            
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.CuestionarioModel.GetCuestionariobyCuestionario_id() " + e.getMessage());
        }
        return c;
    }
    
    public String CreateOrUpdateCuestionario(Cuestionario cuestionario, List<String> cargo, List<String> departamento) {
        String mensaje = "";
        try {
            if (cuestionario.getCuestionario_id() == 0) {
                //inserta
                mensaje = CreateCuestionario(cuestionario, cargo, departamento);
            } else {
                //Actualiza
                mensaje = UpdateCuestionario(cuestionario, cargo, departamento);
            }
        } catch (Exception e) {
        }
        return mensaje;
        
    }
    
    public String CreateCuestionario(Cuestionario cuestionario, List<String> cargo, List<String> departamento) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Cuestionario(Nombre, Estado, Fecha_cracion ,Usuario_crea, Detalle)\n"
                    + "     VALUES('" + cuestionario.getNombre() + "','" + cuestionario.getEstado() + "',CONVERT(date, SYSDATETIME()),'" + cuestionario.getUsuario_crea() + "','" + cuestionario.getDetalle() + "')";
            db.insertar(sql);
            int Cuestionario_id = getMaxCuestionario_id();
            
            db.cierraConexion();
            mensaje = CreateSectorCuestionario(Cuestionario_id, cargo, departamento);

            //Cuestionario_empleadoModelo cuEm = new Cuestionario_empleadoModelo();
            //mensaje = cuEm.AddCuestionarioEmpleadoByCuestionario_id(Cuestionario_id);
        } catch (SQLException e) {
            mensaje = "Modelo.CuestionarioModel.CreateCuestionario() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
    
    public String UpdateCuestionario(Cuestionario cuestionario, List<String> cargo, List<String> departamento) {
        String mensaje = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Cuestionario\n"
                    + "   SET Nombre = '" + cuestionario.getNombre() + "'\n"
                    + "      ,Estado = '" + cuestionario.getEstado() + "'\n"
                    + "      ,Fecha_actualiza = CONVERT(date, SYSDATETIME())\n"
                    + "      ,Usuario_actualiza = '" + cuestionario.getUsuario_actualiza() + "'\n"
                    + "      ,Detalle = '" + cuestionario.getDetalle() + "'\n"
                    + " WHERE Cuestionario_id = '" + cuestionario.getCuestionario_id() + "'";
            db.actualizar(sql);
            /// eliminamos Sector  y volemos a crear con nuevos sectores
            Sector_CuestionarioModel sector = new Sector_CuestionarioModel();
            mensaje = sector.DeleteSectorCuestionariobyCuestionarioId(cuestionario.getCuestionario_id());
            mensaje = CreateSectorCuestionario(cuestionario.getCuestionario_id(), cargo, departamento);

            // Alas personas que pertenecen a un cuestionario y luego los volvemos a cargar
            /*Cuestionario_empleadoModelo emple = new Cuestionario_empleadoModelo();
            mensaje = emple.DeleteEmpleadoByCuestionario_id(cuestionario.getCuestionario_id());

            mensaje = emple.AddCuestionarioEmpleadoByCuestionario_id(cuestionario.getCuestionario_id());*/
            db.cierraConexion();
            mensaje = "Ok";
        } catch (SQLException e) {
            mensaje = "Modelo.CuestionarioModel.UpdateCuestionario() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
    
    public String DeleteCuestionariobyCuestionario_id(int cuestionario_id) {
        String mensaje = "";
        try {
            
            PreguntaModel pregun = new PreguntaModel();
            List<Pregunta> pregunta = new ArrayList<Pregunta>();
            pregunta = pregun.GetAllPreguntaByCuestionarioId(cuestionario_id);
            if (pregunta.size() == 0) {
                //Eliminamos Cuestionario
                ConectaSqlServer db = new ConectaSqlServer();
                db.conectar();
                String sql = "DELETE FROM Cuestionario\n"
                        + "      WHERE Cuestionario_id = '" + cuestionario_id + "'";
                db.insertar(sql);
                db.cierraConexion();
                mensaje = "Ok";
            } else {
                //Tiene preguntas
                mensaje = "No se puede eliminar por que tiene preguntas.<br> Elimine primero las preguntas.";
            }
        } catch (SQLException e) {
            mensaje = "Modelo.CuestionarioModel.DeleteCuestionariobyCuestionario_id() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }
    
    public int getMaxCuestionario_id() {
        int id = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select MAX(Cuestionario_id) id from Cuestionario ";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                id = res.getInt("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.CuestionarioModel.getMaxCuestionario_id() " + e.getMessage());
        }
        return id;
    }
    
    public String CreateSectorCuestionario(int Cuestionario_id, List<String> cargo, List<String> departamento) {
        String respuesta = "Ok";
        try {
            Sector_CuestionarioModel mo = new Sector_CuestionarioModel();
            
            List<Sector_Cuestionario> dep = new ArrayList<Sector_Cuestionario>();
            for (String item : departamento) {
                Sector_Cuestionario d = new Sector_Cuestionario();
                d.setCuestionario_id(Cuestionario_id);
                d.setArea_id(Integer.parseInt(item));
                d.setSector("Departamento");
                dep.add(d);
                respuesta = mo.CreateSector_cuestionario(d);
            }
            
            List<Sector_Cuestionario> are = new ArrayList<Sector_Cuestionario>();
            for (String item : cargo) {
                Sector_Cuestionario d = new Sector_Cuestionario();
                d.setCuestionario_id(Cuestionario_id);
                d.setArea_id(Integer.parseInt(item));
                d.setSector("Cargo");
                are.add(d);
                respuesta = mo.CreateSector_cuestionario(d);
            }
        } catch (NumberFormatException e) {
            respuesta = "Modelo.CuestionarioModel.CreateSectorCuestionario() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    public String DeleteCuestionarioByCuestionarioIdCambiaEstato6(int cuestionario_id) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Cuestionario \n"
                    + "   SET Estado= '6'\n"
                    + " WHERE Cuestionario_id = '" + cuestionario_id + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.CuestionarioModel.DeleteCuestionarioByCuestionarioIdCambiaEstato6() " + e.getMessage());
        }
        return mensaje;
    }
    
    public Cuestionario ComenzarEvaluacion(int cuestionario_evalua_id) {
        Cuestionario cuestionario = new Cuestionario();
        try {
            
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            
            String sql = "SELECT c.Cuestionario_id, c.Nombre, c.Estado, c.Fecha_cracion, c.Usuario_crea, c.Fecha_actualiza, c.Usuario_actualiza, ce.LLeno_cuestionario\n"
                    + "FROM Cuestionario c \n"
                    + "inner join Cuestioario_evalua ce\n"
                    + "on c.Cuestionario_id= ce.Cuestionario_id\n"
                    + "WHERE ce.Cuestionario_evalua_id = '" + cuestionario_evalua_id + "' and  c.Estado<> 6 ";
            
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                cuestionario.setCuestionario_id(res.getInt("Cuestionario_id"));
                cuestionario.setNombre(res.getString("Nombre"));
                cuestionario.setEstado(res.getInt("Estado"));
                cuestionario.setFecha_cracion(res.getDate("Fecha_cracion"));
                cuestionario.setUsuario_crea(res.getInt("Usuario_crea"));
                cuestionario.setFecha_actualiza(res.getDate("Fecha_actualiza"));
                cuestionario.setUsuario_actualiza(res.getInt("Usuario_actualiza"));
                cuestionario.setLLeno_cuestionario(res.getInt("LLeno_cuestionario"));
            }
            
            db.cierraConexion();
            PreguntaModel preguntamodelo = new PreguntaModel();
            cuestionario.setPreguntas(preguntamodelo.GetAllPreguntaByCuestionarioId(cuestionario.getCuestionario_id()));
            
        } catch (SQLException e) {
            System.out.println("Modelo.CuestionarioModel.ComenzarEvaluacion() " + e.getMessage());
        }
        return cuestionario;
    }
}
