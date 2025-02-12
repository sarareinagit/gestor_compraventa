/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDDMSQL;

import BBDD.*;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Empleado {
    
    //Atributos
    String nombre,password;
    int codAcceso;

    //Constructor
    public Empleado(String nombre, String password, int codAcceso) {
        this.nombre = nombre;
        this.password = password;
        this.codAcceso = codAcceso;
    }
    
    //Constructor vacío
    public Empleado() {
    }
    
    //toString
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", password=" + password + ", codAcceso=" + codAcceso + '}';
    }
    
    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodAcceso() {
        return codAcceso;
    }

    public void setCodAcceso(int codAcceso) {
        this.codAcceso = codAcceso;
    }
    
}

