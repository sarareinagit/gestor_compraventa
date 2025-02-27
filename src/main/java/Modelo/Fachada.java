/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import BBDDMSQL.Empleado;
import BBDDMSQL.Producto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Fachada {
    
    
    //EMPLEADOS
    
  public int autenticar(String nombre, String password) throws Exception{
    return new gestorEmpleado().introducirEmpleado(nombre, password);
    
    }
    
    public void altaEmpleado(String nombre, String pass, int codigo) throws Exception{
    new gestorEmpleado().altaEmpleado(nombre, pass, codigo);
    }
    
    public void eliminarEmpleado(String e) throws SQLException{
    new gestorEmpleado().eliminarEmpleado(e);
    }
    
    public ArrayList<Empleado> getAllEmpleado() throws SQLException{
        return new gestorEmpleado().getAllEmpleado();
    }
    
    public Empleado getEmpleado(String nombre) throws SQLException{
        return new gestorEmpleado().getEmpleado(nombre);
    }
    
    public void modificarEmpleado(String nombre, String pass, int codigo) throws Exception{
    new gestorEmpleado().modificarEmpleado(nombre, pass, codigo);
    }

  
   //PRODUCTOS
    
    
    public void altaProducto(int cod_acceso, String nombre, double precio, int cantidad) throws Exception{
        new gestorProducto().altaProducto(cod_acceso, nombre, precio, cantidad);
   
    }
    
    public void eliminarProducto(String p) throws SQLException{
        new gestorProducto().eliminarProducto(p);
    
    }
    
    public ArrayList<Producto> getAllProducto() throws SQLException{
        return new gestorProducto().getAllProducto();
       
    }
    
    public Producto getProducto(String nombre) throws SQLException{
        return new gestorProducto().getProducto(nombre);
        
    }
    
    public void modificarProducto(int cod_acceso, String nombre, double precio, int cantidad) throws Exception{
        new gestorProducto().modificarProducto(cod_acceso, nombre, precio, cantidad);
    
    }
}
