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
public class gestorProducto {
    
    public void altaProducto(int cod_acceso, String nombre, double precio) throws Exception{
     //Comprobar si el producto ya existe
     Producto p = new FachadaBBDD().
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
