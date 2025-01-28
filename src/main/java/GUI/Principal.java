/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BBDD.Empleado;
import Modelo.Fachada;
import java.util.Scanner;


/**
 *
 * @author Ilerna 4.2.7
 */
public class Principal {
    public void autenticar(){
        
            Scanner sc  = new Scanner(System.in);
            Fachada f = new Fachada();
            int llave = 001;
            System.out.println("Introduce nombre: ");
            String nombre = sc.next();
            System.out.println("Introduce contraseña: ");
            String password = sc.next();
            try {
            llave = f.autenticar(nombre, password);
                System.out.println(llave);
            start();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
        }
        
    }
    
    public void start(){
    Scanner sc  = new Scanner(System.in);
    int x=0;
    do{
        System.out.println("\nElija una opción: ");
        System.out.println("1. Gestionar empleado.");
        System.out.println("2. Gestionar pedido.");
        System.out.println("3. Gestionar producto.");
        System.out.println("4. Salir.");
        x=sc.nextInt();
        switch(x){
            case 1 ->{
                int y=0;
                do{
                    System.out.println("\nElija opción: ");
                    System.out.println("1. Alta empleado.");
                    System.out.println("2. Modificar empleado.");
                    System.out.println("3. Consultar/buscar empleado.");
                    System.out.println("4. Volver al menú principal.");
                    y=sc.nextInt();
                    switch(y){
                        case 1 -> {
                            Empleado empleado = new Empleado();
                            System.out.println("\nIntroduce nombre: ");
                            empleado.setNombre(sc.next());
                            System.out.println("Introduce contraseña: ");
                            empleado.setPassword(sc.next());
                            
                            
                        }
                        case 2 -> {}
                        case 3 -> {}
                        case 4 -> {}
                        default -> {}
                    }
                
                }while(y!=4);
            }
            case 2->{}
            case 3 -> {}
            case 4 -> {
                System.out.println("Saliendo...");
            }
            default -> {
                System.out.println("Introduce un valor válido.");
            }
        }
    } 
    while(x!=4);


    } 
}
