/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BBDDMSQL.Producto;
import BBDDMSQL.Empleado;
import Modelo.Fachada;
import java.sql.SQLException;
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
    
    public void inicio(){
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
                case 1 -> {submenu1();}
                case 2 -> {}
                case 3 -> {submenu2();}
                case 4 -> {}
                default ->{}            
                }
        }while(x!=4);
    
    }
    
    //Submenú para Gestionar Empleado
    public void submenu1(){
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
    
    //Submenú para Gestionar Producto
    public void submenu2(){
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
    

