package conexionmysql;

import java.sql.*;

public class ConexionMySQL {
    //private static final String DRIVER = "org.mysql.jdbc.Driver";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/mysql";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        final String usuario = "root";
        final String password = "root";
        Connection dbConnection = null;
        Statement statement = null;        
        
        try {
            Class.forName(DRIVER);
            dbConnection = DriverManager.getConnection(URL_CONEXION, usuario, password);
            String selectTableSQL = "SELECT * FROM mysql.user";
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String id = rs.getString("Host");
                String usr = rs.getString("User");
                String psw = rs.getString("plugin");
                String nombre = rs.getString("authentication_string");
                System.out.println("userid : " + id);
                System.out.println("usr : " + usr);
                System.out.println("psw : " + psw);
                System.out.println("nombre : " + nombre);
            }              
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }                
    }    
}
