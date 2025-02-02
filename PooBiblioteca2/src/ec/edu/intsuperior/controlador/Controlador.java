
package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Conexion;
import ec.edu.intsuperior.vista.Loggin;


public class Controlador {
    
    Loggin loggin= new Loggin(this);
    Conexion conexion= new Conexion(this);
    
    
    public String getConex(){
        return conexion.conex();
        
    }
    
    public void getLoggin() {
        loggin.setVisible(true);
    }
}
