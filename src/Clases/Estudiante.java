/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class Estudiante extends Usuario{
    private boolean deudor;
    private ArrayList<Boolean> asistencias;
    
    private double puntaje;

    ArrayList<Nota> notas;
    
    
    String Seccion;
    
    
    public Estudiante(String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno, int edad,String celular, String dni, String universidad, 
                   String turno, String sexo)
        {
        super(codigo, contraseña, nombres, apellidoPaterno, apellidoMaterno, edad, celular, dni, universidad, turno,sexo);
        asistencias=new ArrayList<>();
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }
    
    
    
    
    
    
    
    
    public boolean isDeudor() {
        return deudor;
    }

    public void setDeudor(boolean deudor) {
        this.deudor = deudor;
    }

    public ArrayList<Boolean> getAsistencias() {
        if (asistencias == null) {
            asistencias = new ArrayList<>();
        }
        return asistencias;
    }

    public void setAsistencias(ArrayList<Boolean> asistencias) {
        this.asistencias = asistencias;
    }



    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
    
}