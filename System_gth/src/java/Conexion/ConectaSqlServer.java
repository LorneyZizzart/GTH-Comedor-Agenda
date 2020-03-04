package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaSqlServer {

    //variables miembro
    private String usuario;
    private String clave;
    private String url;
    private String driverClassName;
    private Connection conn = null;
    private Statement estancia;

    //CONSTRUCTORES
    //Constructor que toma los datos de conexion por medio de parametros
    public ConectaSqlServer(String usuario, String clave, String url, String driverClassName) {
        this.usuario = usuario;
        this.clave = clave;
        this.url = url;
        this.driverClassName = driverClassName;
    }

    //Constructor que crea la conexion sin parametros con unos definidos en la clase
    //(meter los datos correspondientes)
    public ConectaSqlServer() {
        //poner los datos apropiados
        this.usuario = "sa";        
        this.clave = "1844";        
        this.url = "jdbc:sqlserver://192.168.3.30:1433;databaseName=GTH-COPIA";
        //this.url = "jdbc:sqlserver://192.168.3.30:1433;databaseName=GTH";
        this.driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    //metodos para recuperar los datos de conexion
    public String getClave() {
        return clave;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public Connection getConn() {
        return conn;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    //metodos para establecer los valores de conexion
    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) throws SQLException {
        this.usuario = usuario;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

//la conexion propiamente dicha
    public void conectar() throws SQLException {
        try {
            Class.forName(this.driverClassName).newInstance();
            this.conn = DriverManager.getConnection(this.url, this.usuario, this.clave);

        } catch (Exception err) {
            System.out.println("Error " + err.getMessage());
        }
    }
    //Cerrar la conexion

    public void cierraConexion() throws SQLException {
        this.conn.close();
    }

//METODOS PARA TRABAJAR CON LA BASE DE DATOS
    /*public ResultSet consulta(String consulta) throws SQLException {
        this.estancia = (Statement) conn.createStatement();
        return this.estancia.executeQuery(consulta);
    }*/
    public ResultSet consulta(String consulta) throws SQLException {
        try {
            this.estancia = (Statement) conn.createStatement();
            return this.estancia.executeQuery(consulta);
        } catch (SQLException e) {
            System.out.println("Exception happened! Abort! Abort!");
            throw e;
        }

    }

    public void actualizar(String actualiza) throws SQLException {
        this.estancia = (Statement) conn.createStatement();
        estancia.executeUpdate(actualiza);
    }

    public ResultSet borrar(String borra) throws SQLException {
        Statement st = (Statement) this.conn.createStatement();
        return (ResultSet) st.executeQuery(borra);
    }

    public int insertar(String inserta) throws SQLException {
        Statement st = (Statement) this.conn.createStatement();
        return st.executeUpdate(inserta);
    }

}
