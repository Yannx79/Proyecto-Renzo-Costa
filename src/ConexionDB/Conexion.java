package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yannx
 */
public class Conexion {

    private Connection conexion;

    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/renzocosta";

    public Conexion() {
        conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                System.out.println("CONEXION ESTABLECIDA");
            }
        } catch (SQLException e) {
            System.err.println("CONEXION FALLIDA ERROR " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void desconectar() {
        conexion = null;
        System.out.println("CONEXION TERMINADA");
    }

}
