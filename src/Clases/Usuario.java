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
    private String apellidoP, apellidoM;
    private String especialidad, universidad, turno, sexo;
    private int edad;

    private byte[] imagenPerfil; 
    
    
    
    private String celular, dni;
    
    
    //ESTUDIANTE
    
    public Usuario( String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno, int edad, String celular, String dni, String universidad
                   ,String turno   , String sexo      ) {
        
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidoP = apellidoPaterno;
        this.apellidoM = apellidoMaterno;
        this.edad = edad;
        this.celular=celular;
        this.dni=dni;
        this.universidad=universidad;
        this.turno=turno;
        this.sexo=sexo;
    }
    
    //PROFESOR
    
    public Usuario( String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno, String celular, String dni, String especialidad, String sexo) {
        
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidoP = apellidoPaterno;
        this.apellidoM = apellidoMaterno;
        this.celular=celular;
        this.dni=dni;
        this.especialidad= especialidad;
        this.sexo=sexo;
    }
    
    //COORDINADOR
    
    public Usuario( String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno, String celular, String dni, String sexo) {
        
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidoP = apellidoPaterno;
        this.apellidoM = apellidoMaterno;
        this.celular=celular;
        this.dni=dni;
        this.sexo=sexo;
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

    
    
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

   

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
}