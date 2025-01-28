/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Fachada {
    
    //Método para introducir datos
    
    public int autenticar(String nombre, String password) throws Exception{
        return new gestorEmpleado().introducirEmpleado(nombre, password);
    }
}
