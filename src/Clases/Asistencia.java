/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Richard
 */
public class Asistencia {
    private String fecha;
    private String codigo; // Cambio a String para que coincida con el código de estudiante
    private boolean asist;

    public Asistencia(String fecha, String codigo, boolean asist) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.asist = asist;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isAsist() {
        return asist;
    }

    public void setAsist(boolean asist) {
        this.asist = asist;
    }
}

