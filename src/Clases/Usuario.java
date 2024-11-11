package Clases;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Usuario {
    
    
    private String codigo, contraseña, nombres;
    private String apellidoP, apellidoM, telefono;
    private int edad;

    private byte[] imagenPerfil; 
    
    
    public Usuario( String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno, int edad) {
        
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidoP = apellidoPaterno;
        this.apellidoM = apellidoMaterno;
        this.edad = edad;
    }
    
    public Usuario(String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno) {
        
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidoP = apellidoPaterno;
        this.apellidoM = apellidoMaterno;
        
    }
    
    
    
    
    public void cargarImagenDesdeArchivo(File archivoImagen) {
        try {
            BufferedImage bufferedImage = ImageIO.read(archivoImagen);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos); // Especifica el formato de la imagen (jpg, png, etc.)
            this.imagenPerfil = baos.toByteArray(); // Guardar la imagen como byte array
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen.");
        }
    }
    
    
    
    
    public ImageIcon getImagenPerfil() {
        if (imagenPerfil != null) {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(imagenPerfil);
                BufferedImage bufferedImage = ImageIO.read(bais);
                return new ImageIcon(bufferedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null; // Retorna null si no hay imagen
    }
    
    
    
    
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
}