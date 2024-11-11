/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Richard
 */
public class Estudiante extends Usuario{
    private boolean deudor;
    private boolean asistencia;
    private String universidad, turno, ciclo;
    private double puntaje;

    
    public Estudiante(String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno, int edad)
        {
        super(codigo, contraseña, nombres, apellidoPaterno, apellidoMaterno, edad);
        
    }
    
    
    
    
    
    
    
    
    public boolean isDeudor() {
        return deudor;
    }

    public void setDeudor(boolean deudor) {
        this.deudor = deudor;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
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

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
    
}