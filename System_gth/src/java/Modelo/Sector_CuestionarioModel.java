package Modelo;

import Conexion.ConectaSqlServer;
import Entidad.Sector_Cuestionario;
import Entidad.View_Sector_cuestionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Sector_CuestionarioModel {

    public String CreateSector_cuestionario(Sector_Cuestionario sector) {
        String guarda = "";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "INSERT INTO Sector_Cuestionario\n"
                    + "           (Cuestionario_id, Area_id, Sector, Fecha_creacion)\n"
                    + "     VALUES\n"
                    + "           ('" + sector.getCuestionario_id() + "', '" + sector.getArea_id() + "', '" + sector.getSector() + "', CONVERT(date, SYSDATETIME()))";
            db.insertar(sql);
            guarda = "Ok";
            db.cierraConexion();
        } catch (SQLException e) {
            guarda = "Modelo.Sector_CuestionarioModel.CreateSector_cuestionario() " + e.getMessage();
            System.out.println(guarda);
        }
        return guarda;
    }

    public View_Sector_cuestionario GetAllAreasByCuestionario_id(int cuestionario_id) {
        View_Sector_cuestionario Sectores = new View_Sector_cuestionario();
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();

            List<Sector_Cuestionario> Cargos = new ArrayList<Sector_Cuestionario>();
            String sqlCargo = "SELECT sc.SectorEncuesta_id, sc.Cuestionario_id, sc.Area_id, sc.Sector, sc.Fecha_creacion, c.Nombre\n"
                    + "FROM Sector_Cuestionario sc \n"
                    + "inner join Cargo c\n"
                    + "on sc.Area_id = c.Cargo_id\n"
                    + "where Cuestionario_id = '" + cuestionario_id + "' and Sector = 'Cargo'";
            ResultSet resCar = db.consulta(sqlCargo);
            while (resCar.next()) {
                Sector_Cuestionario niv = new Sector_Cuestionario();
                niv.setSectorEncuesta_id(resCar.getInt("SectorEncuesta_id"));
                niv.setSector_nombre(resCar.getString("Nombre"));
                niv.setCuestionario_id(resCar.getInt("Cuestionario_id"));
                niv.setArea_id(resCar.getInt("Area_id"));
                niv.setSector(resCar.getString("Sector"));
                niv.setFecha_creacion(resCar.getDate("Fecha_creacion"));
                Cargos.add(niv);
            }
            Sectores.setCargo(Cargos);

            List<Sector_Cuestionario> niveles = new ArrayList<Sector_Cuestionario>();
            String sqlNivel = "SELECT SectorEncuesta_id, Cuestionario_id, Area_id, Sector, Fecha_creacion\n"
                    + "  FROM Sector_Cuestionario where Cuestionario_id = '" + cuestionario_id + "' and Sector = 'Nivel'";
            ResultSet resNiv = db.consulta(sqlNivel);
            while (resNiv.next()) {
                Sector_Cuestionario niv = new Sector_Cuestionario();
                niv.setSectorEncuesta_id(resNiv.getInt("SectorEncuesta_id"));
                niv.setCuestionario_id(resNiv.getInt("Cuestionario_id"));
                niv.setArea_id(resNiv.getInt("Area_id"));
                niv.setSector(resNiv.getString("Sector"));
                niv.setFecha_creacion(resNiv.getDate("Fecha_creacion"));
                niveles.add(niv);
            }
            Sectores.setNiveles(niveles);

            List<Sector_Cuestionario> areas = new ArrayList<Sector_Cuestionario>();
            String sqlArea = "SELECT SectorEncuesta_id, Cuestionario_id, Area_id, Sector, Fecha_creacion\n"
                    + "  FROM Sector_Cuestionario where Cuestionario_id = '" + cuestionario_id + "' and Sector = 'Area'";
            ResultSet resAre = db.consulta(sqlArea);
            while (resAre.next()) {
                Sector_Cuestionario are = new Sector_Cuestionario();
                are.setSectorEncuesta_id(resAre.getInt("SectorEncuesta_id"));
                are.setCuestionario_id(resAre.getInt("Cuestionario_id"));
                are.setArea_id(resAre.getInt("Area_id"));
                are.setSector(resAre.getString("Sector"));
                are.setFecha_creacion(resAre.getDate("Fecha_creacion"));
                areas.add(are);
            }
            Sectores.setAreas(areas);

            List<Sector_Cuestionario> departamentos = new ArrayList<Sector_Cuestionario>();
            String sqlDepartamento = "SELECT sc.SectorEncuesta_id, sc.Cuestionario_id, sc.Area_id, sc.Sector, sc.Fecha_creacion, d.Nombre\n"
                    + "FROM Sector_Cuestionario sc\n"
                    + "inner join Departamento d\n"
                    + "on sc.Area_id = d.Departamento_id\n"
                    + "where Cuestionario_id = '" + cuestionario_id + "' and Sector = 'Departamento'";
            ResultSet resDep = db.consulta(sqlDepartamento);
            while (resDep.next()) {
                Sector_Cuestionario dep = new Sector_Cuestionario();
                dep.setSectorEncuesta_id(resDep.getInt("SectorEncuesta_id"));
                dep.setCuestionario_id(resDep.getInt("Cuestionario_id"));
                dep.setArea_id(resDep.getInt("Area_id"));
                dep.setSector(resDep.getString("Sector"));
                dep.setSector_nombre(resDep.getString("Nombre"));
                dep.setFecha_creacion(resDep.getDate("Fecha_creacion"));
                departamentos.add(dep);
            }
            Sectores.setDepartamentos(departamentos);

            db.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Modelo.Sector_CuestionarioModel.GetAllAreasByCuestionario_id() " + e.getMessage());
        }
        return Sectores;
    }

    public String DeleteSectorCuestionariobyCuestionarioId(int Cuestionario_id) {
        String respuesta = "Ok";
        try {
            ConectaSqlServer db = new ConectaSqlServer();
            db.conectar();
            String sql = "DELETE FROM Sector_Cuestionario\n"
                    + "      WHERE Cuestionario_id = '" + Cuestionario_id + "'";
            db.insertar(sql);
            db.actualizar(sql);
            db.cierraConexion();
        } catch (SQLException e) {
            respuesta = "Modelo.Sector_CuestionarioModel.DeleteSectorCuestionariobyCuestionarioId() " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

}
