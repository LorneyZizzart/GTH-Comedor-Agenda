/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Empleado_docente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Empleado_docenteModelo {

    public List<Empleado_docente> getAllDocenteByGestionArea(String gestion, String area) {
        List<Empleado_docente> profesores = new ArrayList<Empleado_docente>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String areasql = "";
            if (!area.equalsIgnoreCase("0")) {
                areasql = " and Unidad_academica_id='" + area + "'";
            }

            String sql = "SELECT Empleado_docente_id ,Empleado_id, Gestion,Unidad_academica_id,Fecha_creacion, Usuario_crea, Fecha_Actualiza, Usuario_actualiza\n"
                    + "      ,Estado ,Codigo_uab, dbo.UnidadAcademica_Nombre(Unidad_academica_id) as Nombre_unidad, dbo.Nombre_de_empleado(Empleado_id) as Nombre_empleado,"
                    + "      (select isnull(sum(b.Puntuacion),0) puntos from Uni_acad_pre a inner join Uni_acad_emple_res b on a.Uni_acad_pre = b.Uni_acad_pre  where Uni_acad_area_pre_id='" + area + "' and b.Empleado_docente_id = Empleado_docente.Empleado_docente_id) nota\n"
                    + "  FROM Empleado_docente WHERE Gestion = '" + gestion + "' AND ESTADO = '1' " + areasql;
            System.out.println(sql);
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado_docente d = new Empleado_docente();
                d.setEmpleado_docente_id(res.getInt("Empleado_docente_id"));
                d.setEmpleado_id(res.getInt("Empleado_id"));
                d.setGestion(res.getString("gestion"));
                d.setUnidad_academica_id(res.getInt("Unidad_academica_id"));
                d.setFecha_creacion(res.getString("fecha_creacion"));
                d.setUsuario_crea(res.getInt("Usuario_crea"));
                d.setFecha_Actualiza(res.getString("fecha_actualiza"));
                d.setUsuario_actualiza(res.getInt("Usuario_actualiza"));
                d.setEstado(res.getInt("Estado"));
                d.setCodigo_uab(res.getString("Codigo_uab"));

                d.setNombre_profesor(res.getString("Nombre_empleado"));
                d.setNombre_unidad(res.getString("Nombre_unidad"));
                d.setNota(res.getFloat("nota"));
                profesores.add(d);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_docenteModelo.getAllDocenteByGestionArea() " + e.getMessage());
        }
        return profesores;
    }

    public List<Empleado_docente> getAllEmpleadoByGestionArea(String gestion, String area) {
        List<Empleado_docente> empleados = new ArrayList<Empleado_docente>();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select Empleado_id, dbo.Nombre_de_empleado(Empleado_id) as Nombre_empleado \n"
                    + "  from Empleado \n"
                    + "  where Estado = 1 and Empleado_id not in(select Empleado_id from Empleado_docente ed where ed.Gestion = '" + gestion + "' and ed.Unidad_academica_id = '" + area + "' and Estado = '1')";
            ResultSet res = db.consulta(sql);
            while (res.next()) {
                Empleado_docente e = new Empleado_docente();
                e.setEmpleado_docente_id(res.getInt("Empleado_id"));
                e.setNombre_profesor(res.getString("Nombre_empleado"));
                empleados.add(e);
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Empleado_docenteModelo.getAllEmpleadoByGestionArea() " + e.getMessage());
        }
        return empleados;
    }

    public String AgregarProfesor(Empleado_docente prof) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Empleado_docente(Empleado_id, Gestion, Unidad_academica_id, Fecha_creacion,Usuario_crea, Estado, Codigo_uab)\n"
                    + "VALUES('" + prof.getEmpleado_id() + "','" + prof.getGestion() + "','" + prof.getUnidad_academica_id() + "',getdate(),'" + prof.getUsuario_crea() + "','1','" + prof.getCodigo_uab() + "')";
            db.insertar(sql);
            if (prof.getCodigo_uab().length() > 4) {
                String sqls = "UPDATE Empleado\n"
                        + "    SET Codigo_SisAcad = '" + prof.getCodigo_uab() + "'\n"
                        + "    WHERE Empleado_id = '" + prof.getEmpleado_id() + "'";
                System.out.println("Actualiz " + sqls);
                db.actualizar(sqls);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Empleado_docenteModelo.AgregarProfesor() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String ElimiarProfesor(String codigo_prof, String codigo_usuario) {
        String mensaje = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "update Empleado_docente \n"
                    + "set Estado = 6,\n"
                    + "	Fecha_Actualiza = SYSDATETIME(),\n"
                    + "	Usuario_actualiza = '" + codigo_usuario + "'\n"
                    + "where Empleado_docente_id = '" + codigo_prof + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            mensaje = "Modelo.Empleado_docenteModelo.ElimiarProfesor() " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String GetEmpleadoCodAcad(String id) {
        String idd = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "select isnull (Codigo_SisAcad,'') id from Empleado where Empleado_id = '" + id + "'";
            System.out.println(" Busca Codigo: " + sql);
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                idd = res.getString("id");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            idd = "0";
            System.out.println("Modelo.Empleado_docenteModelo.GetEmpleadoCodAcad() " + e.getMessage());
        }
        return idd;
    }

}
