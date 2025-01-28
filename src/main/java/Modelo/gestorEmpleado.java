/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import BBDD.Empleado;
import BBDD.FachadaBBDD;

/**
 *
 * @author Ilerna 4.2.7
 */
public class gestorEmpleado {
    
    //Método para introducir empleado
    
    public int introducirEmpleado(String nombre, String password) throws Exception{
        
        Empleado pepe = new FachadaBBDD().getEmpleado(nombre);
        //Si pepe es distinto de null, significa que es un empleado válido
        if (pepe != null){
        //Comprobar la contraseña
        if(!pepe.getPassword().equals(password)){
            throw new Exception("La contraseña es incorrecta.");
        }
        //Lanzamos la excepción de contraseña incorrecta
        }else{
         //Lanzamos la excepción de que el empleado no existe
         throw new Exception("El empleado no existe.");
         
        }
        //Si el nombre y la contraseña son válidos, entonces devuelve el código de acceso
        return pepe.getCod_acceso();
    }
    
}
