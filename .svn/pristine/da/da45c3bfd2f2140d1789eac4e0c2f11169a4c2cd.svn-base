package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cliente;
import Entidad.View_Empleado_Encuesta;
import java.sql.SQLException;
import java.util.List;

public class Cuestionario_evaluaModel {

    //Jefe, Par, Bajo,Cliente
    public String SaveCuestionario_evalua(List<View_Empleado_Encuesta> encuestados) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            int cuestionario_id = encuestados.get(0).getCuestionario_id();
            String sqlelimina = "DELETE FROM Cuestioario_evalua\n"
                    + "      WHERE Cuestionario_id = '" + cuestionario_id + "' ";
            db.insertar(sqlelimina);

            for (View_Empleado_Encuesta encuestado : encuestados) {
                if (encuestado.getJefes().size() > 0) {
                    for (View_Empleado_Encuesta jefe : encuestado.getJefes()) {
                        String sqlJefes = "INSERT INTO Cuestioario_evalua\n"
                                + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                                + "     VALUES\n"
                                + "           ('" + encuestado.getCuestionario_id() + "','" + jefe.getEmpleado_id() + "','" + encuestado.getEmpleado_id() + "','1','Jefe' , '" + encuestado.getCuestionario_gestion_id() + "') ";
                        db.insertar(sqlJefes);
                    }
                }

                if (encuestado.getPares().size() > 0) {
                    for (View_Empleado_Encuesta par : encuestado.getPares()) {
                        String sqlPares = "INSERT INTO Cuestioario_evalua\n"
                                + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                                + "     VALUES\n"
                                + "           ('" + encuestado.getCuestionario_id() + "','" + par.getEmpleado_id() + "','" + encuestado.getEmpleado_id() + "','1','Par', '" + encuestado.getCuestionario_gestion_id() + "') ";
                        db.insertar(sqlPares);
                    }
                }

                if (encuestado.getBajos().size() > 0) {
                    for (View_Empleado_Encuesta bajo : encuestado.getBajos()) {
                        String sqlBajo = "INSERT INTO Cuestioario_evalua\n"
                                + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                                + "     VALUES\n"
                                + "           ('" + encuestado.getCuestionario_id() + "','" + bajo.getEmpleado_id() + "','" + encuestado.getEmpleado_id() + "','1','Bajo', '" + encuestado.getCuestionario_gestion_id() + "') ";
                        db.insertar(sqlBajo);
                    }
                }

                if (encuestado.getClientes().size() > 0) {
                    for (Cliente cliente : encuestado.getClientes()) {
                        String sqlBajo = "INSERT INTO Cuestioario_evalua\n"
                                + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                                + "     VALUES\n"
                                + "           ('" + encuestado.getCuestionario_id() + "','" + cliente.getCliente_id() + "','" + encuestado.getEmpleado_id() + "','1','Cliente', '" + encuestado.getCuestionario_gestion_id() + "') ";
                        db.insertar(sqlBajo);
                    }
                }
            }
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Cuestionario_evaluaModel.SaveCuestionario_evalua() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String SaveUnCuestionario_evalua(View_Empleado_Encuesta encuestado) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            int cuestionario_id = encuestado.getCuestionario_id();
            String sqlelimina = "DELETE FROM Cuestioario_evalua\n"
                    + "      WHERE Cuestionario_id = '" + cuestionario_id + "' "
                    + "            and Cuestionario_gestion_id = '" + encuestado.getCuestionario_gestion_id() + "' "
                    + "            and A_empleado_id = '" + encuestado.getEmpleado_id() + "' ";
            db.insertar(sqlelimina);

            //verificamos si se autoevaluara 
            if (encuestado.getAuto_evaluacion().equalsIgnoreCase("Ok")) {
                String sqlAutoeva = "INSERT INTO Cuestioario_evalua\n"
                        + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                        + "     VALUES\n"
                        + "           ('" + encuestado.getCuestionario_id() + "','" + encuestado.getEmpleado_id() + "','" + encuestado.getEmpleado_id() + "','1','Autoevaluacion' , '" + encuestado.getCuestionario_gestion_id() + "') ";
                db.insertar(sqlAutoeva);
            }
            // insertamos a los Jefes
            for (View_Empleado_Encuesta jefe : encuestado.getJefes()) {
                String sqlJefes = "INSERT INTO Cuestioario_evalua\n"
                        + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                        + "     VALUES\n"
                        + "           ('" + encuestado.getCuestionario_id() + "','" + jefe.getEmpleado_id() + "','" + encuestado.getEmpleado_id() + "','1','Jefe' , '" + encuestado.getCuestionario_gestion_id() + "') ";
                db.insertar(sqlJefes);
            }

            // insertamos a los pares 
            for (View_Empleado_Encuesta par : encuestado.getPares()) {
                String sqlPares = "INSERT INTO Cuestioario_evalua\n"
                        + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                        + "     VALUES\n"
                        + "           ('" + encuestado.getCuestionario_id() + "','" + par.getEmpleado_id() + "','" + encuestado.getEmpleado_id() + "','1','Par', '" + encuestado.getCuestionario_gestion_id() + "') ";
                db.insertar(sqlPares);
            }

            //Insertamos a los bajos
            for (View_Empleado_Encuesta bajo : encuestado.getBajos()) {
                String sqlBajo = "INSERT INTO Cuestioario_evalua\n"
                        + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                        + "     VALUES\n"
                        + "           ('" + encuestado.getCuestionario_id() + "','" + bajo.getEmpleado_id() + "','" + encuestado.getEmpleado_id() + "','1','Bajo', '" + encuestado.getCuestionario_gestion_id() + "') ";
                db.insertar(sqlBajo);
            }

            // Insertamos a los Clientes
            for (Cliente cliente : encuestado.getClientes()) {
                String sqlCliente = "INSERT INTO Cuestioario_evalua\n"
                        + "           (Cuestionario_id, Evalua_empleado_id, A_empleado_id, Estado, Tipo, Cuestionario_gestion_id)\n"
                        + "     VALUES\n"
                        + "           ('" + encuestado.getCuestionario_id() + "','" + cliente.getCliente_id() + "','" + encuestado.getEmpleado_id() + "','1','Cliente', '" + encuestado.getCuestionario_gestion_id() + "') ";
                db.insertar(sqlCliente);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Cuestionario_evaluaModel.SaveUnCuestionario_evalua() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    public String update_lleno_cuestionario(int Cuestionario_evalua_id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "UPDATE Cuestioario_evalua\n"
                    + "   SET LLeno_cuestionario = '1'\n"
                    + "      ,Fecha_lleno_cuestionario = CONVERT(date, SYSDATETIME()) \n"
                    + " WHERE Cuestionario_evalua_id = '" + Cuestionario_evalua_id + "'";
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Cuestionario_evaluaModel.update_lleno_cuestionario() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

}
