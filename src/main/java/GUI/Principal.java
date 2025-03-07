/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BBDDMSQL.Producto;
import BBDDMSQL.Empleado;
import Modelo.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ilerna 4.2.7
 */
public class Principal {
    Scanner sc = new Scanner(System.in);
    Fachada f = new Fachada();
    int llave=897;
    int z=0;
    public void autenticar(){
        System.out.println("Introduce nombre");
        String nombre= sc.next();
        System.out.println("Introduce contraseña");
        String pass = sc.next();
        try {
            llave = f.autenticar(nombre, pass);
            System.out.println(llave);            
            inicio();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if(z<2){
                z++;
            autenticar();
            }
        }        
    }
    
    public void inicio() throws SQLException{
    int x;
        do{
            x=0;
            System.out.println("\nElija una opción:");
            System.out.println("1.- Gestionar Empleado");
            System.out.println("2.- Gestionar Pedido");
            System.out.println("3.- Gestionar Producto");
            System.out.println("4.- Salir");
            x= sc.nextInt();        
            switch(x){
                case 1 -> {menuEmpleado();}
                case 2 -> {menuPedido();}
                case 3 -> {menuProducto();}
                case 4 -> {}
                default ->{}            
                }
        }while(x!=4);
    
    }
    
    //Submenú para Gestionar Empleado
    public void menuEmpleado(){
            int y=0;           
            do{
            System.out.println("\nElija opción:");
            System.out.println("1.- Alta Empleado");
            System.out.println("2.- Modificar Empleado");
            System.out.println("3.- Buscar Empleado");
            System.out.println("4.- Eliminar Empleado");
            System.out.println("5.- Listar Empleado");
            System.out.println("6.- Salir");
            y=sc.nextInt();
            switch(y){
                case 1 -> {
                    try {
                        System.out.println("Introduce el nombre del Empleado");
                        String nombre = sc.next();                     
                        System.out.println("Introduce la password");
                        String pass = sc.next();
                        int codigo = introduceCodigo();
                        f.altaEmpleado(nombre, pass, codigo);
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());    
                        }
                }
            case 2->{ 
                    try {
                        System.out.println("Introduce el nombre del Empleado");
                        String nombre = sc.next(); 
                        Empleado a = new Fachada().getEmpleado(nombre);
                        if(a!=null){
                        System.out.println(a.toString());
                        System.out.println("Introduce la password");
                        String pass = sc.next();
                        int codigo = introduceCodigo();
                        f.modificarEmpleado(nombre, pass, codigo);
                        }else{
                        System.out.println("El empleado no existe");}              
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());    
                        }
            
            
            
            }
            case 3 ->{
                    try {
                        System.out.println("Introduce el nombre del empleado");
                        Empleado a = new Fachada().getEmpleado(sc.next());
                        if (a!=null){
                            System.out.println(a.toString());
                        }else{
                            System.out.println("El empleado no existe");
                        }
                    } catch (SQLException ex) {
                        System.out.println("El usuario no existe.");
                    }
            }

            case 4 ->{
                System.out.println("Indica el nombre del usuario a eliminar");
                try {
                    new Fachada().eliminarEmpleado(sc.next());
                } catch (SQLException ex) {
                   System.out.println("El usuario no existe.");
                }
            
            }
            case 5 ->{
                try {
                    
                    for(Empleado a :new Fachada().getAllEmpleado()){
                        System.out.println(a.toString());
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            case 6 ->{System.out.println("Volviendo al menú principal...");}
            default -> {System.out.println("Introduce un valor adecuado");}
            
            }
            }while(y!=6);
    }
    
    
    //Submenú para Gestionar Pedido
    
    public void menuPedido() throws SQLException{
    
     int x=0;           
            do{
            System.out.println("\nElija opción:");
            System.out.println("1.- Realizar Pedido");
            System.out.println("2.- Imprimir Factura");
            System.out.println("3.- Salir");

            x=sc.nextInt();
                switch(x){
                    case 1 -> {
                        // Solicitar el código de acceso del empleado
                        System.out.println("Ingrese el código de acceso del empleado:");
                        int codEmpleado = sc.nextInt();

                        // Mostrar los productos disponibles
                        System.out.println("\nProductos disponibles:");
                        System.out.println(f.getAllProducto());  // Asegúrate de que este método esté mostrando los productos disponibles

                        // Solicitar los productos que desea agregar al pedido
                        ArrayList<Integer> productosSeleccionados = new ArrayList<>();
                        ArrayList<Integer> cantidades = new ArrayList<>();

                        boolean continuar = true;
                        int maxProductos = 4; // Número máximo de productos permitidos

                        // Bucle para agregar productos al pedido
                        while (continuar && productosSeleccionados.size() < maxProductos) {
                            // Solicitar el nombre del producto
                            System.out.println("\nIntroduce el nombre del producto que deseas agregar (4 máximo):");
                            String nombreProducto = sc.next();

                        try {
                            // Buscar el producto por nombre
                            Producto p = new Fachada().getProducto(nombreProducto);

                            if (p != null) {
                                // Si el producto existe, agregarlo al pedido
                                System.out.println("Producto encontrado: " + p.toString());

                                productosSeleccionados.add(p.getCod_producto());  // Agregar el código del producto al ArrayList

                                // Solicitar la cantidad
                                System.out.println("Ingrese la cantidad para el producto " + p.getNombre() + ":");
                                int cantidad = sc.nextInt();

                                // Validar que la cantidad sea positiva
                                if (cantidad > 0) {
                                    cantidades.add(cantidad);  // Agregar la cantidad al ArrayList
                                } else {
                                    System.out.println("Cantidad inválida. Debe ser mayor que 0.");
                                    // No se agrega el producto si la cantidad no es válida
                                    productosSeleccionados.remove(productosSeleccionados.size() - 1);  // Eliminar el último producto agregado
                                }
                            } else {
                                System.out.println("El producto no existe.");
                            }

                        } catch (SQLException ex) {
                            System.out.println("Error al buscar el producto: " + ex.getMessage());
                        }

                        // Si ya se han seleccionado 4 productos, se muestra un mensaje
                        if (productosSeleccionados.size() >= maxProductos) {
                            System.out.println("Has alcanzado el límite máximo de productos (4 productos).");
                        }
                    }

                    // Llamar a la fachada para realizar el pedido

                    String resultado = null;
                    try {
                        // Verificar que los productos seleccionados y cantidades no estén vacíos
                        if (productosSeleccionados.isEmpty() || cantidades.isEmpty()) {
                            System.out.println("No se ha seleccionado ningún producto o cantidad.");
                        } else {
                            // Imprimir los productos seleccionados y sus cantidades antes de intentar insertar
                            System.out.println("Productos seleccionados para el pedido:");
                            for (int i = 0; i < productosSeleccionados.size(); i++) {
                                System.out.println("Código del Producto: " + productosSeleccionados.get(i) + " Cantidad: " + cantidades.get(i));
                            }

                            // Realizar el pedido en la base de datos
                            resultado = f.realizarPedido(codEmpleado, productosSeleccionados, cantidades);
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error al realizar el pedido: " + ex.getMessage());
                        // Imprimir la traza del error para obtener más detalles
                    }
                    System.out.println(resultado);

                    }
                    
                    case 2 -> { 
                        System.out.println("Ingrese el código del pedido para imprimir la factura:");
                        int codPedido = sc.nextInt();

                        // Llamar a la fachada para imprimir la factura
                        String factura = null;
                        try {
                            factura = f.imprimirFactura(codPedido);
                        } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(factura);
                    } 
                    default -> {
                        System.out.println("Introduce un valor adecuado");
                    }
                }   
            }while(x!=3);
    }
            
    //Submenú para Gestionar Producto
    public void menuProducto(){
    int x=0;           
            do{
            System.out.println("\nElija opción:");
            System.out.println("1.- Alta Producto");
            System.out.println("2.- Modificar Producto");
            System.out.println("3.- Buscar Producto");
            System.out.println("4.- Eliminar Producto");
            System.out.println("5.- Listar Productos");
            System.out.println("6.- Salir");
            x=sc.nextInt();
                switch(x){
                    case 1 -> { try {
                        System.out.println("Introduce el código del producto:");
                        int cod_acceso = sc.nextInt();  
//                        int cod_producto = introduceCodigo();
                        System.out.println("Introduce el nombre del producto:");
                        String nombre = sc.next();
                        
                        System.out.println("Introduce precio:");
                        double precio = sc.nextDouble();
                        System.out.println("Introduce cantidad:");
                        int cantidad = sc.nextInt();
                        f.altaProducto(cod_acceso, nombre, precio, cantidad);
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());    
                        }
                    }
                    case 2 -> { try {
                        System.out.println("Introduce el nombre del producto: ");
                        String nombre = sc.next(); 
                        Producto p = new Fachada().getProducto(nombre);
                        if(p!=null){
                        System.out.println(p.toString());
                        System.out.println("Introduce el código: ");
                        int cod_producto = sc.nextInt();
                        System.out.println("Introduce precio: ");
                        double precio = sc.nextDouble();
                        System.out.println("Introduce cantidad: ");
                        int cantidad = sc.nextInt();    
                        f.modificarProducto(cod_producto, nombre, precio, cantidad);
                        }else{
                        System.out.println("El producto no existe");}              
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());    
                        }
                    }
                    case 3 -> { 
                        try {
                        System.out.println("Introduce el nombre del producto: ");
                        String nombre = sc.next();
                        Producto p = new Fachada().getProducto(nombre);
                        if (p!=null){
                            System.out.println(p.toString());
                        }else{
                            System.out.println("El producto no existe");
                        }
                        } catch (SQLException ex) {
                        System.out.println("El usuario no existe.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Indica el nombre del producto a eliminar: ");
                        try {
                        new Fachada().eliminarProducto(sc.next());
                        } catch (SQLException ex) {
                        System.out.println("El producto no existe.");
                        }
                    }
                    case 5 -> {
                        try {
                        for(Producto p: new Fachada().getAllProducto()){
                        System.out.println(p.toString());
                        }
                        } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    case 6 ->{
                        System.out.println("Volviendo al menú principal...");
                    }
                    
                    default -> {
                        System.out.println("Introduce un valor adecuado");
                    }
                }   
            }while(x!=6);
    }
    
    
    
    public int introduceCodigo(){
       boolean bandera = true;
       int codigo=0;
        do {
            try{
                System.out.print("Introduce un código: ");
                codigo = sc.nextInt();
                bandera = false;
            }
            catch (InputMismatchException ex) {
                System.out.println("Introduce un código válido");
                sc.nextLine();
                }
            }while(bandera);
        return codigo;
            }
                       
}
    

