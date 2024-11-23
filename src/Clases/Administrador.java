package Clases;

/**
 *
 * @author Richard
 */
public class Administrador extends Usuario{
    
    String user, claveSeguridad;
    
    public Administrador(String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno, String celular, String dni, String sexo)
        {
        super(codigo, contraseña, nombres, apellidoPaterno, apellidoMaterno, celular, dni, sexo);
    }
    
    
}