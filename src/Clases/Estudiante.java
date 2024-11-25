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
public class Estudiante extends Usuario {
    private String Seccion;
    private ListaAsistencia listaA;
    private ListaNotas listaN;

    public Estudiante(String codigo, String contraseña, String nombres,
                      String apellidoPaterno, String apellidoMaterno, int edad, String celular, String dni, 
                      String universidad, String turno, String sexo) {
        super(codigo, contraseña, nombres, apellidoPaterno, apellidoMaterno, edad, celular, dni, universidad, turno, sexo);
        this.listaA = new ListaAsistencia();
        this.listaN=new ListaNotas();
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }

    public ListaAsistencia getListaA() {
        return listaA;
    }
}