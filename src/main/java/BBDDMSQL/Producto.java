/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDDMSQL;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Producto {
     //Atributos
    
    private int cod_producto;
    private String nombre;
    private double precio;
    private int cantidad;
 
    //Constructor 

    public Producto(int cod_producto, String nombre, double precio, int cantidad) {
        this.cod_producto = cod_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    //Constructor vacío

    public Producto() {
    }
    
    //Getter and Setter

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "cod_producto=" + cod_producto + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
   
    
}