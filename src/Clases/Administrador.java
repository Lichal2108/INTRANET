package Clases;

/**
 *
 * @author Richard
 */
public class Administrador extends Usuario{
    
    String user, claveSeguridad;
    
    public Administrador(String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno)
        {
        super(codigo, contraseña, nombres, apellidoPaterno, apellidoMaterno);
        
    }
    
    
}