package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Conexion;
import ec.edu.intsuperior.vista.Loggin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador {

    private Conexion conexion;

    public Controlador() {
        conexion = new Conexion();
    }

    // Método para verificar la conexión a la base de datos
    public String getConex() {
        return conexion.verificarConexion();
    }

    // Método para iniciar sesión
    public String iniciarSesion(String usuario, String password) {
        String sql = "SELECT * FROM usuario WHERE nombre = ? AND contrasena = ?"; // Ajusta la consulta según tu base de datos
        try (Connection conn = conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Establecer los parámetros de la consulta
            pstmt.setString(1, usuario);
            pstmt.setString(2, password);

            // Ejecutar la consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Si hay resultados, las credenciales son válidas
                    return "Inicio de sesión exitoso.";
                } else {
                    // Si no hay resultados, las credenciales son incorrectas
                    return "Credenciales incorrectas.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al iniciar sesión: " + e.getMessage();
        }
    }

    // Método para mostrar la vista de login
    public void getLoggin() {
        Loggin loggin = new Loggin(this);
        loggin.setVisible(true);
   
    }
}

