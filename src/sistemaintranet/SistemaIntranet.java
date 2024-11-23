/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaintranet;

import Clases.Coordinador;
import Clases.Estudiante;
import Clases.Profesor;
import Clases.Secciones;
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
    private Secciones organizador;
    
    public SistemaIntranet(){
        listaProfesores= new ArrayList<>();
        listaEstudiantes= new ArrayList<>();
        listaCoordinadores=new ArrayList<>();
        organizador = new Secciones();
        // Coordinadores
        Coordinador coord = new Coordinador("123000", "1234567", "Miguel", "Jose", "Rivas", "919 555055", "2452154", "Masculino");
        listaCoordinadores.add(coord);

        Coordinador coord2 = new Coordinador("321000", "9876543", "Ana", "Maria", "Lopez", "987 555678", "4567890", "Femenino");
        listaCoordinadores.add(coord2);

        Coordinador coord3 = new Coordinador("432000", "8765432", "Carlos", "Eduardo", "Vega", "876 555123", "5678901", "Masculino");
        listaCoordinadores.add(coord3);

        // Profesores
        Profesor profe = new Profesor("2220000", "123456", "Nehil", "Muñoz", "Noseque", "123456789", "1234567", "DSI", "Masculino");
        listaProfesores.add(profe);

        Profesor profe2 = new Profesor("3330000", "654321", "Laura", "Fernandez", "Castro", "987654321", "7654321", "Matemáticas", "Femenino");
        listaProfesores.add(profe2);

        Profesor profe3 = new Profesor("4440000", "111111", "Oscar", "Martinez", "Perez", "876543210", "5432109", "Física", "Masculino");
        listaProfesores.add(profe3);

        Profesor profe4 = new Profesor("5550000", "222222", "Isabel", "Gomez", "Ramirez", "765432198", "4321987", "Historia", "Femenino");
        listaProfesores.add(profe4);

        // Estudiantes
        Estudiante prueba = new Estudiante("22200034", "123456", "Richard Josue", "Pillaca", "Machaca", 21, "919555055", "73934096", "UNMSM", "Mañana", "Masculino");
        

        Estudiante prueba2 = new Estudiante("19000005", "123456", "Monica", "Chilon", "Tintaya", 21, "1111", "11111", "UNI", "Tarde", "Femenino");
        prueba2.setSeccion("BBB");
        listaEstudiantes.add(prueba2);

        Estudiante prueba3 = new Estudiante("100000", "123456", "Zarina", "Paucar", "Zanabria", 10, "22222", "2222", "UNAC", "Mañana", "Femenino");
        listaEstudiantes.add(prueba3);

        Estudiante estudiante4 = new Estudiante("20000001", "333333", "Luis", "Perez", "Garcia", 22, "123123123", "321321321", "UNMSM", "Mañana", "Masculino");
        estudiante4.setSeccion("aaa");
        prueba.setSeccion("aaa");
        
        //PRUEBA 
        
        listaEstudiantes.add(prueba);
        listaEstudiantes.add(estudiante4);
        organizador.getSecciones().add("aaa");
        

        
        Estudiante estudiante5 = new Estudiante("20000002", "444444", "Maria", "Lopez", "Sanchez", 20, "234234234", "432432432", "UNFV", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante5);

        Estudiante estudiante6 = new Estudiante("20000003", "555555", "Jose", "Hernandez", "Martinez", 19, "345345345", "543543543", "UNI", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante6);

        Estudiante estudiante7 = new Estudiante("20000004", "666666", "Clara", "Ramos", "Diaz", 23, "456456456", "654654654", "UNMSM", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante7);

        Estudiante estudiante8 = new Estudiante("20000005", "777777", "Hugo", "Ruiz", "Gonzalez", 18, "567567567", "765765765", "UNAC", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante8);
    
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen de perfil");
        int resultado = fileChooser.showOpenDialog(null);
        
        
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            prueba.cargarImagenDesdeArchivo(archivoSeleccionado);

            // Mostrar la imagen en un JLabel si se cargó correctamente
            ImageIcon imagen = prueba.getImagenPerfil();
            if (imagen != null) {
                JLabel labelImagen = new JLabel(imagen);
                JOptionPane.showMessageDialog(null, labelImagen, "Imagen de Perfil", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen.");
            }
        }
        
        
        
    }
    
    
    
    public static void main(String[] args) {
       
        
        
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
    
    
    
    public Secciones getOrganizador() {
        return organizador;
    }
    
    
    
    
    
    
    
    
    
    
}