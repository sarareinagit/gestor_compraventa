/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Empleado {
    
    //Atributos
    
    private String nombre;
    private String password;
    private int cod_acceso;
    
    //Constructor

    public Empleado(String nombre, String password, int cod_acceso) {
        this.nombre = nombre;
        this.password = password;
        this.cod_acceso = cod_acceso;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCod_acceso() {
        return cod_acceso;
    }

    public void setCod_acceso(int cod_acceso) {
        this.cod_acceso = cod_acceso;
    }
    
    //toString

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", password=" + password + ", cod_acceso=" + cod_acceso + '}';
    }
    
    
    
}
