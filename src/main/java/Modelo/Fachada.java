/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import BBDD.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class Fachada {
    
  public int autenticar(String nombre, String password) throws Exception{
    return new gestorEmpleado().introducirEmpleado(nombre, password);
    
    }
    
    public void altaEmpleado(String nombre, String pass, int codigo) throws Exception{
    new gestorEmpleado().altaEmpleado(nombre, pass, codigo);
    }
    
    public void eliminarEmpleado(String e){
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

  
   
    
}
