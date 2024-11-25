/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaintranet;

import Clases.Asistencia;
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
        
        
        
        //ALUMNO DE PRUEBA CON TODO
        Estudiante prueba = new Estudiante("22200034", "123456", "Richard Josue", "Pillaca", "Machaca", 21, 
            "919555055", "73934096", "UNMSM", "Mañana", "Masculino");
        
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-01", "22200034", true)); // Asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-02", "22200034", false)); // No asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-03", "22200034", true)); // Asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-04", "22200034", false)); // No asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-05", "22200034", true)); // Asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-06", "22200034", false)); // No asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-07", "22200034", true)); // Asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-08", "22200034", true)); // Asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-09", "22200034", false)); // No asistió
        prueba.getListaA().agregarAsistencia(new Asistencia("2024-11-10", "22200034", true)); // Asistió
        
        prueba.setSeccion("UNMSM-Mañana");
        listaEstudiantes.add(prueba);
        
        
        

        Estudiante prueba2 = new Estudiante("19000005", "123456", "Monica", "Chilon", "Tintaya", 21, 
            "1111", "11111", "UNI", "Tarde", "Femenino");

        Estudiante prueba3 = new Estudiante("100000", "123456", "Zarina", "Paucar", "Zanabria", 10, 
            "22222", "2222", "UNAC", "Mañana", "Femenino");

        Estudiante estudiante4 = new Estudiante("20000001", "333333", "Luis", "Perez", "Garcia", 22, 
            "123123123", "321321321", "UNMSM", "Mañana", "Masculino");

        Estudiante estudiante5 = new Estudiante("20000002", "444444", "Maria", "Lopez", "Sanchez", 20, 
            "234234234", "432432432", "UNFV", "Tarde", "Femenino");

        Estudiante estudiante6 = new Estudiante("20000003", "555555", "Jose", "Hernandez", "Martinez", 19, 
            "345345345", "543543543", "UNI", "Mañana", "Masculino");

        Estudiante estudiante7 = new Estudiante("20000004", "666666", "Clara", "Ramos", "Diaz", 23, 
            "456456456", "654654654", "UNMSM", "Tarde", "Femenino");

        Estudiante estudiante8 = new Estudiante("20000005", "777777", "Hugo", "Ruiz", "Gonzalez", 18, 
            "567567567", "765765765", "UNAC", "Mañana", "Masculino");

        
        estudiante4.setSeccion("UNMSM-Mañana");

        prueba2.setSeccion("UNI-Tarde");

        prueba3.setSeccion("UNAC-Mañana");
        estudiante8.setSeccion("UNAC-1");

        estudiante5.setSeccion("UNFV-Tarde");

        estudiante6.setSeccion("UNI-Mañana");

        estudiante7.setSeccion("UNMSM-Tarde");

        // Agregar los estudiantes a la lista
        
        listaEstudiantes.add(prueba2);
        listaEstudiantes.add(prueba3);
        listaEstudiantes.add(estudiante4);
        listaEstudiantes.add(estudiante5);
        listaEstudiantes.add(estudiante6);
        listaEstudiantes.add(estudiante7);
        listaEstudiantes.add(estudiante8);

        // Agregar las secciones al organizador
        organizador.getSecciones().add("UNMSM-Mañana");
        organizador.getSecciones().add("UNI-Tarde");
        organizador.getSecciones().add("UNAC-Mañana");
        organizador.getSecciones().add("UNFV-Tarde");
        organizador.getSecciones().add("UNI-Mañana");
        organizador.getSecciones().add("UNMSM-Tarde");
        organizador.getSecciones().add("UNAC-1");

        
        
        
        
        //NUEVOS ETUDIANTES CON SECCIONES
        Estudiante estudiante21 = new Estudiante("20000021", "111111", "Andrea", "Santos", "Mendoza", 20, 
            "111222333", "111111111", "UNMSM", "Mañana", "Femenino");

        Estudiante estudiante22 = new Estudiante("20000022", "222222", "Gabriel", "Ramirez", "Rojas", 22, 
            "222333444", "222222222", "UNI", "Tarde", "Masculino");

        Estudiante estudiante23 = new Estudiante("20000023", "333333", "Laura", "Mendoza", "Torres", 21, 
            "333444555", "333333333", "UNAC", "Mañana", "Femenino");

        Estudiante estudiante24 = new Estudiante("20000024", "444444", "Carlos", "Lopez", "Castro", 24, 
            "444555666", "444444444", "UNFV", "Tarde", "Masculino");

        Estudiante estudiante25 = new Estudiante("20000025", "555555", "Daniela", "Gomez", "Sanchez", 19, 
            "555666777", "555555555", "UNMSM", "Tarde", "Femenino");

        Estudiante estudiante26 = new Estudiante("20000026", "666666", "Sebastian", "Vargas", "Perez", 23, 
            "666777888", "666666666", "UNI", "Mañana", "Masculino");

        Estudiante estudiante27 = new Estudiante("20000027", "777777", "Mariana", "Flores", "Diaz", 21, 
            "777888999", "777777777", "UNAC", "Mañana", "Femenino");

        Estudiante estudiante28 = new Estudiante("20000028", "888888", "Fernando", "Gutierrez", "Garcia", 22, 
            "888999000", "888888888", "UNMSM", "Mañana", "Masculino");

        Estudiante estudiante29 = new Estudiante("20000029", "999999", "Valeria", "Morales", "Salas", 20, 
            "999000111", "999999999", "UNFV", "Tarde", "Femenino");

        Estudiante estudiante30 = new Estudiante("20000030", "101010", "Javier", "Espinoza", "Velasco", 22, 
            "000111222", "101010101", "UNI", "Tarde", "Masculino");

        // Asignar Secciones a los Nuevos Estudiantes
        estudiante21.setSeccion("UNMSM-Mañana");
        estudiante22.setSeccion("UNI-Tarde");
        estudiante23.setSeccion("UNAC-Mañana");
        estudiante24.setSeccion("UNFV-Tarde");
        estudiante25.setSeccion("UNMSM-Tarde");
        estudiante26.setSeccion("UNI-Mañana");
        estudiante27.setSeccion("UNAC-Mañana");
        estudiante28.setSeccion("UNMSM-Mañana");
        estudiante29.setSeccion("UNFV-Tarde");
        estudiante30.setSeccion("UNI-Tarde");

        // Agregar los Nuevos Estudiantes a la Lista
        listaEstudiantes.add(estudiante21);
        listaEstudiantes.add(estudiante22);
        listaEstudiantes.add(estudiante23);
        listaEstudiantes.add(estudiante24);
        listaEstudiantes.add(estudiante25);
        listaEstudiantes.add(estudiante26);
        listaEstudiantes.add(estudiante27);
        listaEstudiantes.add(estudiante28);
        listaEstudiantes.add(estudiante29);
        listaEstudiantes.add(estudiante30);

        
        
        
        
        
        
        
        //ESTUDIANTES SIN SECCIONES
        
        
        Estudiante estudiante9 = new Estudiante("20000006", "888888", "Lucia", "Fernandez", "Gomez", 21, "678678678", "876876876", "UNMSM", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante9);

        Estudiante estudiante10 = new Estudiante("20000007", "999999", "Carlos", "Ortiz", "Salinas", 22, "789789789", "987987987", "UNI", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante10);

        Estudiante estudiante11 = new Estudiante("20000008", "111222", "Andrea", "Lozano", "Quispe", 20, "890890890", "098098098", "UNAC", "Mañana", "Femenino");
        listaEstudiantes.add(estudiante11);

        Estudiante estudiante12 = new Estudiante("20000009", "333444", "Fernando", "Diaz", "Ramirez", 23, "901901901", "109109109", "UNFV", "Tarde", "Masculino");
        listaEstudiantes.add(estudiante12);

        Estudiante estudiante13 = new Estudiante("20000010", "555666", "Patricia", "Campos", "Zeballos", 19, "912912912", "210210210", "UNMSM", "Mañana", "Femenino");
        listaEstudiantes.add(estudiante13);

        Estudiante estudiante14 = new Estudiante("20000011", "777888", "Jorge", "Sanchez", "Morales", 21, "923923923", "321321321", "UNI", "Tarde", "Masculino");
        listaEstudiantes.add(estudiante14);

        Estudiante estudiante15 = new Estudiante("20000012", "999000", "Sofia", "Rojas", "Rivera", 18, "934934934", "432432432", "UNAC", "Mañana", "Femenino");
        listaEstudiantes.add(estudiante15);

        Estudiante estudiante16 = new Estudiante("20000013", "112233", "Raul", "Perez", "Torres", 22, "945945945", "543543543", "UNFV", "Tarde", "Masculino");
        listaEstudiantes.add(estudiante16);

        Estudiante estudiante17 = new Estudiante("20000014", "445566", "Marcela", "Velasquez", "Mendoza", 23, "956956956", "654654654", "UNMSM", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante17);

        Estudiante estudiante18 = new Estudiante("20000015", "778899", "Gonzalo", "Flores", "Cruz", 19, "967967967", "765765765", "UNI", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante18);

        Estudiante estudiante19 = new Estudiante("20000016", "123789", "Elena", "Paredes", "Nuñez", 20, "978978978", "876876876", "UNAC", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante19);

        Estudiante estudiante20 = new Estudiante("20000017", "456123", "Oscar", "Ramirez", "Gutierrez", 21, "989989989", "987987987", "UNMSM", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante20);
        
        
        Estudiante estudiante31 = new Estudiante("20000031", "111000", "Daniel", "Martinez", "Campos", 21, "100100100", "200200200", "UNMSM", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante31);

        Estudiante estudiante32 = new Estudiante("20000032", "222111", "Luciana", "Morales", "Diaz", 22, "101101101", "201201201", "UNI", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante32);

        Estudiante estudiante33 = new Estudiante("20000033", "333222", "Juan", "Fernandez", "Lopez", 20, "102102102", "202202202", "UNAC", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante33);

        Estudiante estudiante34 = new Estudiante("20000034", "444333", "Camila", "Gutierrez", "Soto", 23, "103103103", "203203203", "UNFV", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante34);

        Estudiante estudiante35 = new Estudiante("20000035", "555444", "Miguel", "Castro", "Ramirez", 19, "104104104", "204204204", "UNMSM", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante35);

        Estudiante estudiante36 = new Estudiante("20000036", "666555", "Paola", "Espinoza", "Cruz", 22, "105105105", "205205205", "UNI", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante36);

        Estudiante estudiante37 = new Estudiante("20000037", "777666", "Luis", "Ramos", "Gomez", 20, "106106106", "206206206", "UNAC", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante37);

        Estudiante estudiante38 = new Estudiante("20000038", "888777", "Karla", "Salinas", "Zeballos", 23, "107107107", "207207207", "UNFV", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante38);

        Estudiante estudiante39 = new Estudiante("20000039", "999888", "Alejandro", "Mendoza", "Nuñez", 21, "108108108", "208208208", "UNMSM", "Mañana", "Masculino");
        listaEstudiantes.add(estudiante39);

        Estudiante estudiante40 = new Estudiante("20000040", "000999", "Angela", "Vega", "Torres", 19, "109109109", "209209209", "UNI", "Tarde", "Femenino");
        listaEstudiantes.add(estudiante40);
     
        
        
        
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