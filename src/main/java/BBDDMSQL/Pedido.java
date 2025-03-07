/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDDMSQL;

import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Pedido {
    
    
 

    


    //Atributos
    
    private int cod_pedido;
    private int cod_empleado; //(codAcceso)
    private ArrayList<LineaPedido> lineaFactura = new ArrayList<>();
    
    //Constructor

    public Pedido(int cod_pedido, int cod_empleado, ArrayList<LineaPedido> lineaFactura) {
        this.cod_pedido = cod_pedido;
        this.cod_empleado = cod_empleado;
        this.lineaFactura = lineaFactura;
    }
    
    //Constructor vacío

    public Pedido() {
    }
    
    //Getter and Setter

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public ArrayList<LineaPedido> getLineaFactura() {
        return lineaFactura;
    }

    public void setLineaFactura(ArrayList<LineaPedido> lineaFactura) {
        this.lineaFactura = lineaFactura;
    }
    
    
    public Pedido(int cod_empleado) {
    this.cod_empleado = cod_empleado;
    this.lineaFactura = new ArrayList<>();  // Inicialización en el constructor
}

    
}
