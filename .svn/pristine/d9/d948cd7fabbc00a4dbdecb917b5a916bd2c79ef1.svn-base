package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Empleado;
import Entidad.Evento_Actividad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.sql.rowset.CachedRowSet;

public class Evento_ActividadModel {

    public String CreateorUpdateEventoActividad(Evento_Actividad actividad) {
        String respuesta = "Ok";
        try {
            if (actividad.getEvento_Actividad_id() == 0) {
                // Insertamos
                respuesta = CreateActividad(actividad);
            } else {
                //actualizamos
                respuesta = ActualizarActividad(actividad);
            }
        } catch (Exception e) {
            respuesta = "Modelo.Evento_ActividadModel.CreateorUpdateEventoActividad() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String CreateActividad(Evento_Actividad actividad) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Evento_Actividad\n"
                    + "           (Nombre_actividad, Fecha_creacion\n"
                    + "           ,Empleado_id, Descripcion, Fecha_inicio_actividad\n"
                    + "		   ,Fecha_fin_actividad, Estado, Evento_id)\n"
                    + "     VALUES\n"
                    + "           ('" + actividad.getNombre_actividad() + "', CONVERT(date, SYSDATETIME()) \n"
                    + "           ,'" + actividad.getEmpleado_id() + "', '" + actividad.getDescripcion() + "', CONVERT(datetime,'" + actividad.getFecha_inicio_actividad() + "')\n"
                    + "           ,CONVERT(datetime,'" + actividad.getFecha_fin_actividad() + "'), '1', '" + actividad.getEvento_id() + "')";
            System.out.println("Creamos Actividad : " + sql);
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Evento_ActividadModel.CreateActividad() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public List<Evento_Actividad> GetAllActividadesByEvento_id(int Evento_id) {
        List<Evento_Actividad> Actividades = new ArrayList<Evento_Actividad>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Evento_Actividad_id, Nombre_actividad, Fecha_creacion\n"
                    + "      ,Fecha_actualizacion, Empleado_id, Descripcion\n"
                    + "      ,CONVERT(nvarchar, Fecha_inicio_actividad, 101) Fecha_inicio_actividad, right(convert(varchar(25), Fecha_inicio_actividad, 100), 7) hora_inicio_actividad\n"
                    + "	  ,CONVERT(nvarchar, Fecha_fin_actividad, 101) Fecha_fin_actividad, right(convert(varchar(25), Fecha_fin_actividad, 100), 7) hora_fin_actividad ,Estado\n"
                    + "      ,Evento_id\n"
                    + "  FROM Evento_Actividad\n"
                    + " WHERE Evento_id = '" + Evento_id + "' and Estado  ='1' order by Fecha_inicio_actividad ";
            System.out.println("Todas la actividades del evento : " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Evento_Actividad a = new Evento_Actividad();
                a.setEvento_Actividad_id(res.getInt("Evento_Actividad_id"));
                a.setNombre_actividad(res.getString("Nombre_actividad"));
                a.setFecha_creacion(res.getString("Fecha_creacion"));
                a.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                a.setEmpleado_id(res.getInt("Empleado_id"));
                a.setDescripcion(res.getString("Descripcion"));
                a.setFecha_inicio_actividad(res.getString("Fecha_inicio_actividad"));
                a.setHora_inicio_actividad(res.getString("hora_inicio_actividad"));
                a.setFecha_fin_actividad(res.getString("Fecha_fin_actividad"));
                a.setHora_fin_actividad(res.getString("hora_fin_actividad"));
                a.setEstado(res.getInt("Estado"));
                Actividades.add(a);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_ActividadModel.GetAllActividadesByEvento_id() " + e.getMessage());
        }
        return Actividades;
    }

    public Evento_Actividad GetActividadesByActividad_id(int actividad_id) {
        Evento_Actividad a = new Evento_Actividad();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Evento_Actividad_id, Nombre_actividad, Fecha_creacion\n"
                    + "      ,Fecha_actualizacion, Empleado_id, Descripcion\n"
                    + "      ,CONVERT(nvarchar, Fecha_inicio_actividad, 101) Fecha_inicio_actividad, right(convert(varchar(25), Fecha_inicio_actividad, 100), 7) hora_inicio_actividad\n"
                    + "	  ,CONVERT(nvarchar, Fecha_fin_actividad, 101) Fecha_fin_actividad, right(convert(varchar(25), Fecha_fin_actividad, 100), 7) hora_fin_actividad ,Estado\n"
                    + "      ,Evento_id\n"
                    + "  FROM Evento_Actividad\n"
                    + " WHERE Evento_Actividad_id = '" + actividad_id + "' order by Fecha_inicio_actividad ";
            System.out.println("GetActividadesByActividad_id : " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {

                a.setEvento_Actividad_id(res.getInt("Evento_Actividad_id"));
                a.setNombre_actividad(res.getString("Nombre_actividad"));
                a.setFecha_creacion(res.getString("Fecha_creacion"));
                a.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                a.setEmpleado_id(res.getInt("Empleado_id"));
                a.setDescripcion(res.getString("Descripcion"));
                a.setFecha_inicio_actividad(res.getString("Fecha_inicio_actividad"));
                a.setHora_inicio_actividad(res.getString("hora_inicio_actividad"));
                a.setFecha_fin_actividad(res.getString("Fecha_fin_actividad"));
                a.setHora_fin_actividad(res.getString("hora_fin_actividad"));
                a.setEstado(res.getInt("Estado"));
                // Actividades.add(a);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_ActividadModel.GetAllActividadesByEvento_id() " + e.getMessage());
        }
        return a;
    }

    public String ActualizarActividad(Evento_Actividad actividad) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "UPDATE Evento_Actividad\n"
                    + "   SET Nombre_actividad = '" + actividad.getNombre_actividad() + "'\n"
                    + "      ,Fecha_actualizacion = ''\n"
                    + "      ,Empleado_id = '" + actividad.getEmpleado_id() + "'\n"
                    + "      ,Descripcion = '" + actividad.getDescripcion() + "'\n"
                    + "      ,Fecha_inicio_actividad = CONVERT(datetime,'" + actividad.getFecha_inicio_actividad() + "') \n"
                    + "      ,Fecha_fin_actividad = CONVERT(datetime,'" + actividad.getFecha_fin_actividad() + "')\n"
                    + " WHERE Evento_Actividad_id = '" + actividad.getEvento_Actividad_id() + "'";
            System.out.println(" ActualizarActividad : " + Sql);
            db.actualizar(Sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Evento_ActividadModel.ActualizarActividad() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String EliminaActividad(Evento_Actividad actividad) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String Sql = "UPDATE Evento_Actividad\n"
                    + "   SET Fecha_actualizacion = CONVERT(date, SYSDATETIME()) \n"
                    + "      ,Empleado_id = '" + actividad.getEmpleado_id() + "'\n"
                    + "      ,Estado = '6'\n"
                    + " WHERE Evento_Actividad_id = '" + actividad.getEvento_Actividad_id() + "'";
            db.actualizar(Sql);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Evento_ActividadModel.EliminaActividad() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public List<Empleado> EmpleadosNoregistradoActividad(int id_actividad, int id_evento) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id	  \n"
                    + "FROM Empleado e  inner join Evento_participantes ep\n"
                    + "  on e.Empleado_id = ep.Empleado_id\n"
                    + " WHERE ep.Evento_id = '" + id_evento + "' and ep.Estado = '1'\n"
                    + " and ep.Empleado_id not in (select Empleado_id from Evento_actividad_participantes where Evento_Actividad_id = '" + id_actividad + "') \n"
                    + " order by e.Apellido_paterno, e.Apellido_materno, e.Nombre";
            System.out.println("EmpleadosNoregistradoActividad : " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre(res.getString("Nombre"));
                e.setApellido_paterno(res.getString("Apellido_paterno"));
                e.setApellido_materno(res.getString("Apellido_materno"));
                e.setEmail(res.getString("email"));
                e.setFecha_nacimiento(res.getString("Fecha_nacimiento"));
                e.setTelefono(res.getString("Telefono"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setEstado(res.getInt("Estado"));

                Empleado_cargoModel cargo = new Empleado_cargoModel();
                e.setCargo(cargo.GetEmpleadoCargoByIdEmpleado(e.getEmpleado_id()));

                empleados.add(e);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.EventoModel.GetAllEmpleadoNoEstanaEnEvento()" + e.getMessage());
        }
        return empleados;
    }

    public String RegistroAsistenciaActividad(int empleado_id, int actividad_id) {
        String res = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            if (seRegisto(empleado_id, actividad_id) == 0) {
                String sql = "INSERT INTO Evento_actividad_participantes\n"
                        + "           (Evento_Actividad_id, Empleado_id, fecha_registro)\n"
                        + "     VALUES\n"
                        + "           ( '" + actividad_id + "','" + empleado_id + "',CONVERT(datetime,SYSDATETIME()))";
                db.insertar(sql);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            res = "Modelo.Evento_ActividadModel.RegistroAsistenciaActividad() " + e.getMessage();
            System.out.println("Modelo.Evento_ActividadModel.RegistroAsistenciaActividad() " + e.getMessage());
        }
        return res;
    }

    public int seRegisto(int empleado_id, int actividad_id) {
        int resultado = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select count(*)total \n"
                    + "from Evento_actividad_participantes \n"
                    + "where Evento_Actividad_id = '" + actividad_id + "' and Empleado_id = '" + empleado_id + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                resultado = res.getInt("total");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_ActividadModel.seRegisto() " + e.getMessage());
        }
        return resultado;
    }

    public List<Empleado> EmpleadosPresenteActividad(int id_actividad, int id_evento) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "sELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id	  \n"
                    + "FROM Empleado e  inner join Evento_actividad_participantes eap\n"
                    + "  on e.Empleado_id = eap.Empleado_id\n"
                    + " WHERE eap.Evento_Actividad_id = '" + id_actividad + "' \n"
                    + " order by e.Apellido_paterno, e.Apellido_materno, e.Nombre";
            System.out.println("EmpleadosPresenteActividad():  " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre(res.getString("Nombre"));
                e.setApellido_paterno(res.getString("Apellido_paterno"));
                e.setApellido_materno(res.getString("Apellido_materno"));
                e.setEmail(res.getString("email"));
                e.setFecha_nacimiento(res.getString("Fecha_nacimiento"));
                e.setTelefono(res.getString("Telefono"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setEstado(res.getInt("Estado"));
                e.setTelefono(ColorRamdom());

                Empleado_cargoModel cargo = new Empleado_cargoModel();
                e.setCargo(cargo.GetEmpleadoCargoByIdEmpleado(e.getEmpleado_id()));

                empleados.add(e);

            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_ActividadModel.EmpleadosPresenteActividad() " + e.getMessage());
        }
        return empleados;
    }

    public String ColorRamdom() {

        Random random = new Random();

        int nextInt = random.nextInt(0xffffff + 1);

        String colorCode = String.format("#%06x", nextInt);

        // print it
        return colorCode;
    }

    public int Cantidad_ActividadesEvento(int evento_id) {
        int cantidad = 0;
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select COUNT(*) cantidad from Evento_Actividad where Evento_id = '" + evento_id + "' and Estado = '1'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                cantidad = res.getInt("cantidad");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_ActividadModel.Cantidad_ActividadesEvento() " + e.getMessage());
        }
        return cantidad;
    }

    public List<Empleado> EmpleadosActividadJuego(int id_actividad, int id_evento) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "sELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id	  \n"
                    + "FROM Empleado e  inner join Evento_actividad_participantes eap\n"
                    + "  on e.Empleado_id = eap.Empleado_id\n"
                    + " WHERE eap.Evento_Actividad_id = '" + id_actividad + "' and e.Empleado_id not in (select epg.Empleado_id from Evento_participante_ganador epg WHERE epg.Evento_id ='"+id_evento+"')  \n"
                    + " order by e.Apellido_paterno, e.Apellido_materno, e.Nombre";
            System.out.println("EmpleadosActividadJuego():  " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setNombre(res.getString("Nombre"));
                e.setApellido_paterno(res.getString("Apellido_paterno"));
                e.setApellido_materno(res.getString("Apellido_materno"));
                e.setEmail(res.getString("email"));
                e.setFecha_nacimiento(res.getString("Fecha_nacimiento"));
                e.setTelefono(res.getString("Telefono"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setEstado(res.getInt("Estado"));
                e.setTelefono(ColorRamdom());

                Empleado_cargoModel cargo = new Empleado_cargoModel();
                e.setCargo(cargo.GetEmpleadoCargoByIdEmpleado(e.getEmpleado_id()));

                empleados.add(e);

            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Evento_ActividadModel.EmpleadosActividadJuego() " + e.getMessage());
        }
        return empleados;
    }

}
