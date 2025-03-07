/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import BBDDMSQL.FachadaBBDD;
import BBDDMSQL.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class gestorPedido {
     // Instancia de FachadaBBDD
    private FachadaBBDD fachadaBBDD;

    // Constructor
    public gestorPedido() {
        fachadaBBDD = new FachadaBBDD();  // Crear una instancia de FachadaBBDD
    }
    
   // Método para realizar un pedido
    public String realizarPedido(int codEmpleado, ArrayList<Integer> productosSeleccionados, ArrayList<Integer> cantidades) throws SQLException {
        // Aquí puedes agregar la lógica para crear un pedido a partir de los productos seleccionados y las cantidades

        // Crear el pedido
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setCod_empleado(codEmpleado);
        // Agregar productos a la línea de factura...

        // Llamar al método de la FachadaBBDD para insertar el pedido
        boolean exito = fachadaBBDD.realizarPedido(nuevoPedido);
        if (exito) {
            return "Pedido realizado con éxito.";
        } else {
            return "Error al realizar el pedido.";
        }
    }

    // Método para obtener un pedido e imprimir la factura
    public String imprimirFactura(int codPedido) throws SQLException {
        Pedido pedido = fachadaBBDD.obtenerPedido(codPedido);
        if (pedido != null) {
            String factura = "\nFactura del Pedido #" + codPedido + "\n";
            // Calcular el total, iterar sobre la línea de factura...
            return factura;
        } else {
            return "No se encontró el pedido con el código proporcionado.";
        }
    }
}
