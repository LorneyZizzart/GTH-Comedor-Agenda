/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Empleado;
import Entidad.Evento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Roberto
 */
public class EventoModel {

    public String InsertOrUpdate(Evento evento) {
        String respuesta = "Ok";
        if (evento.getEvento_id() == 0) {
            //insertamos
            respuesta = InsertEvento(evento);
        } else {
            // insertamos
            respuesta = UpdateEvento(evento);
        }
        return respuesta;
    }

    public String InsertEvento(Evento evento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Evento\n"
                    + "           (Nombre_evento, Fecha_creacion, Empleado_id \n"
                    + "		   ,Fecha_inicio, Fecha_fin, Estado, Detalle) \n"
                    + "           VALUES ('" + evento.getNombre_evento() + "', CONVERT(date, SYSDATETIME()), '" + evento.getEmpleado_id() + "'\n"
                    + "		   ,'" + evento.getFecha_inicio() + "', '" + evento.getFecha_fin() + "', 1,'" + evento.getDetalle() + "') \n";
            System.out.println(" --  Insrtamos :" + sql);
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.EventoModel.InsertEvento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String UpdateEvento(Evento evento) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Evento\n"
                    + "   SET Nombre_evento = '" + evento.getNombre_evento() + "'     \n"
                    + "      ,Fecha_actualizacion = CONVERT(date, SYSDATETIME())\n"
                    + "      ,Empleado_id = '" + evento.getEmpleado_id() + "'\n"
                    + "      ,Fecha_inicio = '" + evento.getFecha_inicio() + "'\n"
                    + "      ,Fecha_fin = '" + evento.getFecha_fin() + "'\n"
                    + "      ,Detalle = '" + evento.getDetalle() + "'\n"
                    + " WHERE Evento_id = '" + evento.getEvento_id() + "'";
            System.out.println(sql);
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.EventoModel.UpdateEvento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public List<Evento> GetAllEventoActivo() {
        List<Evento> eventos = new ArrayList<Evento>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Evento_id, Nombre_evento, Fecha_creacion, Fecha_actualizacion\n"
                    + "      ,Empleado_id, FORMAT (Fecha_inicio, 'dd/MM/yyyy')Fecha_inicio,  FORMAT (Fecha_fin, 'dd/MM/yyyy')Fecha_fin, Estado, Detalle \n"
                    + "  FROM Evento \n"
                    + "  WHERE Estado = '1'";
            System.out.println("GetAllEventosActivos :" + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Evento e = new Evento();
                e.setEvento_id(res.getInt("Evento_id"));
                e.setNombre_evento(res.getString("Nombre_evento"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setFecha_inicio(res.getString("Fecha_inicio"));
                e.setFecha_fin(res.getString("Fecha_fin"));
                e.setEstado(res.getInt("Estado"));
                e.setDetalle(res.getString("Detalle"));
                eventos.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.EventoModel.GetAllEventoActivo() " + e.getMessage());
        }
        return eventos;
    }

    public List<Evento> GetAllEventoPasados() {
        List<Evento> eventos = new ArrayList<Evento>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Evento_id, Nombre_evento, Fecha_creacion, Fecha_actualizacion\n"
                    + "      ,Empleado_id, Fecha_inicio, Fecha_fin, Estado, Detalle\n"
                    + "  FROM Evento \n"
                    + "  WHERE Estado = '1'";
            System.out.println("GetAllEventosActivos :" + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Evento e = new Evento();
                e.setEvento_id(res.getInt("Evento_id"));
                e.setNombre_evento(res.getString("Nombre_evento"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setFecha_inicio(res.getString("Fecha_inicio"));
                e.setFecha_fin(res.getString("Fecha_fin"));
                e.setEstado(res.getInt("Estado"));
                e.setDetalle(res.getString("Detalle"));
                eventos.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.EventoModel.GetAllEventoActivo() " + e.getMessage());
        }
        return eventos;
    }

    public Evento GetEventobyId(int id) {
        Evento e = new Evento();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT Evento_id, Nombre_evento, Fecha_creacion, Fecha_actualizacion\n"
                    + "      ,Empleado_id, FORMAT (Fecha_inicio, 'dd/MM/yyyy')Fecha_inicio,  FORMAT (Fecha_fin, 'dd/MM/yyyy')Fecha_fin, Estado, Detalle\n"
                    + "  FROM Evento \n"
                    + "  WHERE Evento_id = '" + id + "'";
            System.out.println("GetEventobyId :" + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                e.setEvento_id(res.getInt("Evento_id"));
                e.setNombre_evento(res.getString("Nombre_evento"));
                e.setFecha_creacion(res.getString("Fecha_creacion"));
                e.setFecha_actualizacion(res.getString("Fecha_actualizacion"));
                e.setEmpleado_id(res.getInt("Empleado_id"));
                e.setFecha_inicio(res.getString("Fecha_inicio"));
                e.setFecha_fin(res.getString("Fecha_fin"));
                e.setEstado(res.getInt("Estado"));
                e.setDetalle(res.getString("Detalle"));
            }
            db.cierraConexion();
        } catch (SQLException ee) {
            System.out.println("Modelo.EventoModel.GetEventobyId() " + ee.getMessage());
        }
        return e;
    }

    public String DesactivarEvento(int empleado_id, int evento_id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Evento\n"
                    + "   SET Estado = '0'     \n"
                    + "  ,Empleado_id = '" + empleado_id + "' \n"
                    + " WHERE Evento_id = '" + evento_id + "'";;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (Exception e) {
            respuesta = "Modelo.EventoModel.DesactivarEvento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String EliminarEvento(int empleado_id, int evento_id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Evento\n"
                    + "   SET Estado = '6'     \n"
                    + "  ,Empleado_id = '" + empleado_id + "' \n"
                    + " WHERE Evento_id = '" + evento_id + "'";;
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.EventoModel.EliminarEvento() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public List<Empleado> GetAllEmpleadoEvento(int evento_di) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id	  \n"
                    + "FROM Empleado e\n"
                    + "inner join Evento_participantes ep\n"
                    + "on e.Empleado_id = ep.Empleado_id\n"
                    + "WHERE ep.Evento_id = '" + evento_di + "' and ep.Estado = 1\n"
                    + "order by e.Apellido_paterno, e.Apellido_materno, e.Nombre";
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
            System.out.println("Modelo.EventoModel.GetAllEmpleado()" + e.getMessage());
        }
        return empleados;
    }

    public List<Empleado> GetAllEmpleadoNoEstanaEnEvento(int evento_di) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "SELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id	  \n"
                    + "FROM Empleado e\n"
                    + "WHERE e.Estado = 1 and e.Empleado_id not in (select Empleado_id from Evento_participantes where Estado = 1 and Evento_id = '" + evento_di + "')\n"
                    + "order by e.Apellido_paterno, e.Apellido_materno, e.Nombre";
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

    public List<Empleado> Juego_cantidad_asistencia(int catnidad, int id_evento) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "SELECT e.Empleado_id, e.Nombre, e.Apellido_paterno, e.Apellido_materno, e.email, e.Fecha_nacimiento, e.Telefono, e.Fecha_creacion, e.Estado, e.Estado_civil_id,\n"
                    + "(select count(*) \n"
                    + "from Evento_Actividad ea\n"
                    + "inner join  Evento_actividad_participantes eap\n"
                    + "on ea.Evento_Actividad_id = eap.Evento_Actividad_id\n"
                    + "where ea.Evento_id = '" + id_evento + "' and eap.Empleado_id = e.Empleado_id) participacion\n"
                    + "FROM Empleado e \n"
                    + "inner join Evento_participantes  ep\n"
                    + "on e.Empleado_id = ep.Empleado_id\n"
                    + "where ep.Evento_id = '" + id_evento + "' and e.Estado = 1  and e.Empleado_id not in (select ee.Empleado_id from Evento_participante_ganador ee where ee.Evento_id = '" + id_evento + "' )";
            System.out.println("Juego_cantidad_asistencia():  " + sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {

                if (catnidad == 0) {
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
                    e.setEstado_civil_id(res.getInt("participacion"));

                    Empleado_cargoModel cargo = new Empleado_cargoModel();
                    e.setCargo(cargo.GetEmpleadoCargoByIdEmpleado(e.getEmpleado_id()));

                    empleados.add(e);
                } else {
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
                    int participoen = res.getInt("participacion");

                    Empleado_cargoModel cargo = new Empleado_cargoModel();
                    e.setCargo(cargo.GetEmpleadoCargoByIdEmpleado(e.getEmpleado_id()));
                    if (participoen >= catnidad) {
                        empleados.add(e);
                    }

                }

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

    public String guarda_ganador_eventos(int empleado_id, int evento_id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Evento_participante_ganador\n"
                    + "			(Empleado_id, Evento_id)\n"
                    + "     VALUES\n"
                    + "           ('" + empleado_id + "','" + evento_id + "')";
            db.insertar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.EventoModel.guarda_ganador_eventos()" + e.getMessage());
        }
        return respuesta;
    }

}
