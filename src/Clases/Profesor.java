/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Richard
 */
public class Profesor extends Usuario{
    String curso;
    
        // Constructor
    public Profesor(String codigo, String contraseña, String nombres,
                   String apellidoPaterno, String apellidoMaterno)
        {
        super(codigo, contraseña, nombres, apellidoPaterno, apellidoMaterno);
    }
    
    
}