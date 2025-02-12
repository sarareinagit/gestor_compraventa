/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import BBDD.Empleado;
import BBDD.FachadaBBDD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ilerna 4.2.7
 */
public class gestorEmpleado {
    
 public int introducirEmpleado(String nombre, String password) throws Exception{
         
         Empleado pepe = new FachadaBBDD().getEmpleado(nombre);
         System.out.println("Cual es el valor de pepe: "+ pepe.toString());
           if (pepe!=null){
            //Comprobar la contraseña
                if(!pepe.getPassword().equals(password)){
                throw new Exception("La password es incorrecta");
                }
            //Lanzamos excepcion contraseña incorrecta
            }else{
           throw new Exception("El usuario no existe");
        }
            return pepe.getCodAcceso();
     }
     
     public void altaEmpleado(String nombre, String pass, int codigo) throws Exception{
     //Comprobar si el empleado existe
     
     Empleado p = new FachadaBBDD().getEmpleado(nombre);
     if (Objects.nonNull(p)){
     throw new Exception("El empleado existe");
     }
     if (pass.length()<8){
     throw new Exception("La password no tiene tamaño adecuado");
     }
     if(codigo>0){
     }
     new FachadaBBDD().altaEmpleado(new Empleado(nombre,pass,codigo));
     }
     
     public void eliminarEmpleado(String e){
     new FachadaBBDD().eliminarEmpleado(e);
     
     }
     
     public ArrayList<Empleado> getAllEmpleado() throws SQLException{
     return new FachadaBBDD().getAllEmpleado();
     }
     
     public Empleado getEmpleado(String nombre_) throws SQLException{
     return new FachadaBBDD().getEmpleado(nombre_);
     }
     
     public void modificarEmpleado(String nombre, String pass, int codigo) throws Exception{
     new FachadaBBDD().modificarEmpleado(new Empleado(nombre,pass,codigo));
     }
    
}

