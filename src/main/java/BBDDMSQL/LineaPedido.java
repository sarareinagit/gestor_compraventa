/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDDMSQL;

/**
 *
 * @author Ilerna 4.2.7
 */
public class LineaPedido {
    
    //Atributos
    
    private int cod_pedido;
    private int cod_producto;
    private int cantidad;
    private double precio;
    
    //Constructor 

    public LineaPedido(int cod_pedido, int cod_producto, int cantidad, double precio) {
        this.cod_pedido = cod_pedido;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    //Constructor vacío

    public LineaPedido() {
    }
    
    //Getter and Setter

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
