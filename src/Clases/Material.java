/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class Material {
    String titulo;
    Date fecha;
    byte[] contenidoPDF;
    
        public Material(){
            
            
            
        }
        
        
        public void CargarPDF(){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selecciona un archivo PDF");

            int resultado = fileChooser.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivoPDF = fileChooser.getSelectedFile();

                try {
                    contenidoPDF = java.nio.file.Files.readAllBytes(archivoPDF.toPath());
                    // Aquí tienes el archivo PDF en la variable contenidoPDF
                    System.out.println("Archivo PDF cargado exitosamente en la variable.");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al cargar el archivo PDF.");
                }
            }
            
        }
    
    
    
        
    
    
    
    
}
