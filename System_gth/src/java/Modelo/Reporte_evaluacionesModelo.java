package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Cuestionario;
import Entidad.Pregunta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reporte_evaluacionesModelo {

    public List<Cuestionario> GetAllCuestionario_Empleado(int Cuestionario_gestion_id, int empleado_id) {
        List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();
        try {
            List<String> id_cuestionaios = new ArrayList<String>();

            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            String sql = "select DISTINCT Cuestionario_id from Cuestioario_evalua \n"
                    + "where Cuestionario_gestion_id  ='" + Cuestionario_gestion_id + "' and A_empleado_id = '" + empleado_id + "' ";
            ResultSet ids = db.consulta(sql);
            while (ids.next()) {
                id_cuestionaios.add(ids.getString("Cuestionario_id"));
            }

            for (String id : id_cuestionaios) {
                CuestionarioModel cu = new CuestionarioModel();
                Cuestionario cues = new Cuestionario();
                cues = cu.GetCuestionariobyCuestionario_id(Integer.parseInt(id));

                PreguntaModel premod = new PreguntaModel();
                List<Pregunta> Preguntas = new ArrayList<Pregunta>();
                Preguntas = premod.GetAllPreguntaByCuestionarioId(Integer.parseInt(id));
                Preguntas = Add_nota_preguntas(Preguntas, empleado_id, Cuestionario_gestion_id);

                cues.setPreguntas(Preguntas);
                cues = Add_nota_Cuestionario(cues);
                cuestionarios.add(cues);
            }

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Reporte_evaluacionesModelo.GetAllCuestionario_Empleado() " + e.getMessage());
        }
        return cuestionarios;
    }

    public List<Pregunta> Add_nota_preguntas(List<Pregunta> Preguntas, int empleado_id, int Cuestionario_gestion_id) {
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            for (Pregunta Pre : Preguntas) {
                float nota = 0;
                int contador = 0;

                String sql = "select Nota from Cuestioario_evalua ce\n"
                        + "inner join Cuestionario_respuestas cr\n"
                        + "on ce.Cuestionario_evalua_id = cr.Cuestionario_evalua_id\n"
                        + "where Cuestionario_gestion_id  ='" + Cuestionario_gestion_id + "' and A_empleado_id = '" + empleado_id + "' and Pregunta_id ='" + Pre.getPregunta_id() + "' ";
                ResultSet res = db.consulta(sql);
                while (res.next()) {
                    nota = res.getFloat("Nota") + nota;
                    contador++;
                }
                float promedio = 0;
                promedio = nota / contador;

                if (promedio > 1) {

                } else {
                    promedio = 0;
                }

                Pre.setPromedio(promedio);

                int nota_entero = (int) promedio;

                Pre.setColor_pintar(Get_CollorPintar(nota_entero));
                Pre.setDesempeno(Get_desempeno(nota_entero));

                Pre.setPromedio_entero(nota_entero);

            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Reporte_evaluacionesModelo.Add_nota_preguntas() " + e.getMessage() + " Cuestionario :" + Cuestionario_gestion_id + " Empleado_id:" + empleado_id);
        }
        return Preguntas;
    }

    public Cuestionario Add_nota_Cuestionario(Cuestionario cuestionario) {
        try {
            float cantidad_preguntas = 0;
            float nota = 0;

            List<Pregunta> preguntas = new ArrayList<Pregunta>();
            preguntas = cuestionario.getPreguntas();

            for (Pregunta pregunta : preguntas) {
                cantidad_preguntas++;
                nota = nota + pregunta.getPromedio();
            }

            float promedio = nota / cantidad_preguntas;
            int nota_entero = (int) promedio;

            cuestionario.setColor_pintar(Get_CollorPintar(nota_entero));
            cuestionario.setDesempeno(Get_desempeno(nota_entero));

            cuestionario.setPromedio_entero(nota_entero);
            cuestionario.setPromedio(promedio);

        } catch (NumberFormatException e) {
            System.out.println("Modelo.Reporte_evaluacionesModelo.Add_nota_Cuestionario() " + e.getMessage());
        }
        return cuestionario;
    }

    public Cuestionario GetCuestionario_Empleado_by_cuestionario_id(int cuestionario_id, int Cuestionario_gestion_id, int empleado_id) {
        Cuestionario cues = new Cuestionario();
        try {
            CuestionarioModel cu = new CuestionarioModel();

            cues = cu.GetCuestionariobyCuestionario_id(cuestionario_id);

            PreguntaModel premod = new PreguntaModel();
            List<Pregunta> Preguntas = new ArrayList<Pregunta>();
            Preguntas = premod.GetAllPreguntaByCuestionarioId(cuestionario_id);

            Preguntas = Add_nota_preguntas(Preguntas, empleado_id, Cuestionario_gestion_id);

            cues.setPreguntas(Preguntas);
            cues = Add_nota_Cuestionario(cues);
        } catch (Exception e) {
            System.out.println("Modelo.Reporte_evaluacionesModelo.GetCuestionario_Empleado_by_cuestionario_id() " + e.getMessage());
        }
        return cues;
    }

    public String Get_CollorPintar(int banco_respuestas_id) {
        String color = "ed1c24";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select Css from Banco_respuestas where Banco_Respuestas_id = '" + banco_respuestas_id + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                color = res.getString("Css");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Reporte_evaluacionesModelo.Get_CollorPintar() " + e.getMessage());
        }
        return color;
    }

    public String Get_desempeno(int banco_respuestas_id) {
        String desempeno = ".";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "Select Seccion from Banco_respuestas where Banco_Respuestas_id = '" + banco_respuestas_id + "'";
            ResultSet res = db.consulta(sql);
            if (res.next()) {
                desempeno = res.getString("Seccion");
            }
            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Reporte_evaluacionesModelo.Get_CollorPintar() " + e.getMessage());
        }
        return desempeno;
    }
}
