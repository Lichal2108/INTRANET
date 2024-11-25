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
public class ListaAsistencia {
    private ArrayList<Asistencia> asistencias;

    public ListaAsistencia() {
        asistencias = new ArrayList<>();
    }

    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }
}


