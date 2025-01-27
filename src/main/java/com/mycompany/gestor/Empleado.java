/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestor;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Empleado {
    
    //Atributos
    
    private String nombre;
    private int cod_empleado;
    private String password;
    
    //Constructor

    public Empleado(String nombre, int cod_empleado, String password) {
        this.nombre = nombre;
        this.cod_empleado = cod_empleado;
        this.password = password;
    }
    
    
    //Constructor vacío

    public Empleado() {
    }
    
    
    //Getter and Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
}
