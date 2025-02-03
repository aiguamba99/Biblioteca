package ec.edu.intsuperior.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=UTC";
    private String user = "root"; // Cambia esto por tu usuario de MySQL
    private String password = "root"; // Cambia esto por tu contraseña de MySQL

    // Constructor por defecto
    public Conexion() {
    }

    // Método para establecer la conexión
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return con;
    }

    // Método para verificar la conexión
    public String verificarConexion() {
        try (Connection conn = conectar()) {
            if (conn != null && conn.isValid(10)) {
                return "Conexión exitosa a la base de datos.";
            } else {
                return "Error: No se pudo establecer una conexión válida.";
            }
        } catch (SQLException e) {
            return "Error al verificar la conexión: " + e.getMessage();
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}


