package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Conexion;
import ec.edu.intsuperior.vista.Loggin;

public class Controlador {

    private Loggin loggin;
    private Conexion conexion;

    public Controlador() {
        loggin = new Loggin(this);
        conexion = new Conexion();
    }

    // Método para verificar la conexión
    public String getConex() {
        return conexion.verificarConexion();
    }

    // Método para mostrar la vista de login
    public void getLoggin() {
        loggin.setVisible(true);
    }
    
}

