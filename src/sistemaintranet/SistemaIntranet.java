/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaintranet;

import Clases.Coordinador;
import Clases.Estudiante;
import Clases.Profesor;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class SistemaIntranet {

    
    ArrayList<Profesor> listaProfesores;
    ArrayList<Estudiante> listaEstudiantes ;
    ArrayList<Coordinador> listaCoordinadores;
    
    
    public SistemaIntranet(){
        listaProfesores= new ArrayList<>();
        listaEstudiantes= new ArrayList<>();
    }
    
    
    
    public static void main(String[] args) {
       
        SistemaIntranet Sis= new SistemaIntranet();
        
        Estudiante Prueba = new Estudiante("22200034", "123456", "Richard Josue", "Pillaca", "Machaca", 21);
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen de perfil");
        int resultado = fileChooser.showOpenDialog(null);
        
        
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            Prueba.cargarImagenDesdeArchivo(archivoSeleccionado);

            // Mostrar la imagen en un JLabel si se cargó correctamente
            ImageIcon imagen = Prueba.getImagenPerfil();
            if (imagen != null) {
                JLabel labelImagen = new JLabel(imagen);
                JOptionPane.showMessageDialog(null, labelImagen, "Imagen de Perfil", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen.");
            }
        }
        
        
        Estudiante Prueba2 = new Estudiante("19000005", "123456", "Monica", "Chilon", "Tintaya", 21);
        Estudiante Prueba3 = new Estudiante("100000", "123456", "Zarina", "Paucar", "Zanabria", 10);

      
        Sis.listaEstudiantes.add(Prueba);
        Sis.listaEstudiantes.add(Prueba2);
        Sis.listaEstudiantes.add(Prueba3);
    
        
        
        
        
        
    }

    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public ArrayList<Coordinador> getListaCoordinadores() {
        return listaCoordinadores;
    }

    public void setListaCoordinadores(ArrayList<Coordinador> listaCoordinadores) {
        this.listaCoordinadores = listaCoordinadores;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}