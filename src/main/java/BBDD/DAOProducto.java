/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class DAOProducto {
 // Lista de productos
    private ArrayList<Producto> listaProductos;

    // Constructor público
    public DAOProducto() {
        // Inicializa la lista de productos y añade uno por defecto
        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(1, "Leche semidesnatada", 0.86));
    }

    // Método para obtener la lista de productos
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    // Método para establecer la lista de productos
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    // Método para obtener un producto por su nombre
    public Producto getProducto(String nombre) {
        Producto emp = null;
        for (Producto p: listaProductos) {
            if (p.getNombre().equals(nombre)) {
                System.out.println("entrooooo");
                emp = p;
            }
        }
        return emp;
    }

    // Método para agregar un nuevo producto
    public void altaProducto(Producto p) {
        listaProductos.add(p);
    }
    
}
