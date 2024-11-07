
package ConexionBaseDatos;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Richard
 */
public class Conexion {
    
    Connection conectar = null;
    String usuario = "root";
    String contraseña = "vaGF2B*t8&dQSS";
    String bd ="dbintranet";
    String ip="localhost";
    String puerto="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    public Connection establecerConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(cadena,usuario,contraseña);
            JOptionPane.showMessageDialog(null, "SE ESTABLECION LA CONEXION CORRECTAMENTE");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "NO SE ESTABLECIO CONECCION"+e.toString());
        }
        return conectar;
    }
    
}
