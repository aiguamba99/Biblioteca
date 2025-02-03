package ec.edu.intsuperior.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método para insertar un nuevo usuario
    public void insertarUsuario(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, int fk_curso, int fk_tipousuario) {
        String sql = "INSERT INTO usuario (nombre, apellido, cedula, direccion, telefono, correo, fk_curso, fk_tipousuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, cedula);
            pstmt.setString(4, direccion);
            pstmt.setString(5, telefono);
            pstmt.setString(6, correo);
            pstmt.setInt(7, fk_curso);
            pstmt.setInt(8, fk_tipousuario);
            pstmt.executeUpdate();
            System.out.println("Usuario insertado correctamente!");
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    // Método para listar todos los usuarios
    public List<String> listarUsuarios() {
        List<String> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String usuarioInfo = "ID: " + rs.getInt("pk_usuario") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Apellido: " + rs.getString("apellido") +
                        ", Cédula: " + rs.getString("cedula");
                usuarios.add(usuarioInfo);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return usuarios;
    }
}
