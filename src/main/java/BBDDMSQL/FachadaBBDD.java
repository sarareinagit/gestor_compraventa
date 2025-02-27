/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDDMSQL;

import BBDDMSQL.DAOEmpleado;
import BBDDMSQL.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class FachadaBBDD {
    
    //Métodos para Empleado (conectado con DAOEmpleado)
    public void altaEmpleado(Empleado e){
        new DAOEmpleado().altaEmpleado(e);
    }
    
    public Empleado getEmpleado(String nombre) throws SQLException{
        return new DAOEmpleado().getEmpleado(nombre);
    } 
   
    public void eliminarEmpleado(String e) throws SQLException{
        new DAOEmpleado().eliminarEmpleado(e);
    }
    
    public void modificarEmpleado(Empleado e){
        new DAOEmpleado().modificarEmpleado(e);
    }
    
    public ArrayList<Empleado> getAllEmpleado() throws SQLException{
        return new DAOEmpleado().getAll();
    }
    
    
    
    //Métodos para Producto (conectado con DAOProducto)
    public void altaProducto(Producto p){
        new DAOProducto().altaProducto(p);
    }
    
    public Producto getProducto(String nombre) throws SQLException{
        return new DAOProducto().getProducto(nombre);
    }
    
    public void eliminarProducto(String nombre){
        new DAOProducto().eliminarProducto(nombre);
    }
    
    public void modificarProducto(Producto p){
        new DAOProducto().modificarProducto(p);
    }
    
    public ArrayList<Producto> getAllProducto() throws SQLException{
        return new DAOProducto().getAll();
    }
    
}

