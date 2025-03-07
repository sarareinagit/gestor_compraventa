/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDDMSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class DAOPedido {
    
    
     ConexionMySQL conexion = new ConexionMySQL();
    PreparedStatement ps=null;
     
    private ArrayList<Pedido> pedidos;
    private ArrayList<Producto> productosDisponibles;
    private ArrayList<Empleado> empleados;

    // Constructor

    public DAOPedido(ArrayList<Pedido> pedidos, ArrayList<Producto> productosDisponibles, ArrayList<Empleado> empleados) {
        this.pedidos = pedidos;
        this.productosDisponibles = productosDisponibles;
        this.empleados = empleados;
    }
    
    //Constructor vacío 

    public DAOPedido() {
    }
    
    

    // Método para realizar un pedido
    public String realizarPedido(int codEmpleado, ArrayList<Integer> productosSeleccionados, ArrayList<Integer> cantidades) {
        // Buscar empleado
        Empleado empleadoSeleccionado = buscarEmpleado(codEmpleado);
        
        if (empleadoSeleccionado == null) {
            return "Empleado no encontrado.";
        }

        // Crear lista de LineaPedido
        ArrayList<LineaPedido> lineaFactura = new ArrayList<>();
        int cantidadProductos = 0;
        
        // Verificar los productos seleccionados
        for (int i = 0; i < productosSeleccionados.size(); i++) {
            int codProducto = productosSeleccionados.get(i);
            Producto productoSeleccionado = buscarProducto(codProducto);

            if (productoSeleccionado == null) {
                return "Producto con código " + codProducto + " no encontrado.";
            }

            // Verificar disponibilidad de stock
            int cantidad = cantidades.get(i);
            if (productoSeleccionado.getCantidad() < cantidad) {
                return "No hay suficiente stock del producto " + productoSeleccionado.getNombre() + ".";
            }

            // Crear la línea de pedido
            LineaPedido linea = new LineaPedido(0, codProducto, cantidad, productoSeleccionado.getPrecio());
            lineaFactura.add(linea);
            cantidadProductos++;
        }

        // Si el pedido tiene productos, creamos el pedido
        if (cantidadProductos > 0) {
            int codPedido = pedidos.size() + 1; // Generar un código único de pedido
            Pedido pedido = new Pedido(codPedido, codEmpleado, lineaFactura);
            pedidos.add(pedido);
            return "Pedido realizado con éxito. Código de pedido: " + codPedido;
        } else {
            return "No se ha agregado ningún producto al pedido.";
        }
    }
    
    
    // Métodos de búsqueda
    private Producto buscarProducto(int codProducto) {
        for (Producto p : productosDisponibles) {
            if (p.getCod_producto() == codProducto) {
                return p;
            }
        }
        return null;
    }

    private Empleado buscarEmpleado(int codEmpleado) {
        for (Empleado e : empleados) {
            if (e.getCodAcceso() == codEmpleado) {
                return e;
            }
        }
        return null;
    }
    
     private Pedido buscarPedido(int codPedido) {
        for (Pedido p : pedidos) {
            if (p.getCod_pedido() == codPedido) {
                return p;
            }
        }
        return null;
    }

    
    
    // Método para imprimir la factura
   public String imprimirFactura(int cod_pedido) {
        Pedido pedidoEncontrado = buscarPedido(cod_pedido);

        if (pedidoEncontrado != null) {
            String factura = "\nFactura del Pedido #" + cod_pedido + "\n";
            double total = 0;
            for (LineaPedido linea : pedidoEncontrado.getLineaFactura()) {
                double subtotal = linea.getPrecio() * linea.getCantidad();
                total += subtotal;
                factura += "Producto " + linea.getCod_producto() + ": " + linea.getCantidad() + " x " + linea.getPrecio() + " = " + subtotal + "\n";
            }
            factura += "Total: " + total;
            return factura;
        } else {
            return "No se encontró el pedido con el código proporcionado.";
        }
    }



// Método para obtener un pedido desde la base de datos

 public Pedido obtenerPedido(int codPedido) throws SQLException {
    Connection con = conexion.conectarMySQL();
    Pedido pedido = null;
    try {
        // Preparamos la consulta para obtener el pedido según el cod_pedido
        ps = con.prepareStatement("SELECT * FROM pedido WHERE cod_pedido = ?");
        ps.setInt(1, codPedido);
        ResultSet rs = ps.executeQuery();
        
        // Si encontramos el pedido
        if (rs.next()) {
            pedido = new Pedido();
            pedido.setCod_pedido(rs.getInt("cod_pedido"));
            pedido.setCod_empleado(rs.getInt("cod_empleado"));
            
            // Ahora recuperamos las líneas de pedido (productos)
            ArrayList<LineaPedido> lineasPedido = new ArrayList<>();
            PreparedStatement psLineas = con.prepareStatement("SELECT * FROM linea_pedido WHERE cod_pedido = ?");
            psLineas.setInt(1, codPedido);
            ResultSet rsLineas = psLineas.executeQuery();
            
            while (rsLineas.next()) {
                LineaPedido linea = new LineaPedido();
                linea.setCod_pedido(rsLineas.getInt("cod_pedido"));
                linea.setCod_producto(rsLineas.getInt("cod_producto"));
                linea.setCantidad(rsLineas.getInt("cantidad"));
                linea.setPrecio(rsLineas.getDouble("precio"));
                lineasPedido.add(linea);
            }
            
            // Establecemos las líneas de pedido al objeto 'pedido'
            pedido.setLineaFactura(new ArrayList<>(lineasPedido));
        }
    } catch (SQLException ex) {
        System.err.println("Error al obtener el pedido: " + ex.getMessage());
    } finally {
        con.close();
    }
    return pedido;
}


    // Método para insertar un pedido en la base de datos
    public boolean insertarPedido(Pedido pedido) throws SQLException {
    Connection con = conexion.conectarMySQL();
    boolean exito = false;
    try {
        // Primero insertamos el pedido en la tabla 'Pedido'
       ps = con.prepareStatement("INSERT INTO Pedido (cod_empleado) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, pedido.getCod_empleado());
        int res = ps.executeUpdate();

        // Si la inserción fue exitosa, obtenemos el ID generado para el pedido
        if (res > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
            int codPedido = rs.getInt(1); // Obtenemos el ID generado
            pedido.setCod_pedido(codPedido); // Asignamos el código de pedido generado
        }


                // Ahora insertamos las líneas de pedido (productos) en la tabla 'LineaPedido'
               if (pedido.getLineaFactura() != null) {
                for (LineaPedido linea : pedido.getLineaFactura()) {
                PreparedStatement psLinea = con.prepareStatement("INSERT INTO linea_pedido (cod_pedido, cod_producto, cantidad, precio) VALUES (?, ?, ?, ?)");
                psLinea.setInt(1, linea.getCod_pedido());
                psLinea.setInt(2, linea.getCod_producto());
                psLinea.setInt(3, linea.getCantidad());
                psLinea.setDouble(4, linea.getPrecio());
                psLinea.executeUpdate();
            }
            } else {
                System.out.println("La lista de líneas de pedido está vacía.");
    }

        }     
    } catch (SQLException ex) {
        System.err.println("Error al insertar el pedido: " + ex.getMessage());
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
        }
    }
    return exito;
}
    
}


