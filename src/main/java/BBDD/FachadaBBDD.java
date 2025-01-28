/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

/**
 *
 * @author Ilerna 4.2.7
 */
public class FachadaBBDD {
    
    public Empleado getEmpleado(String nombre){
        return DAOEmpleado.getInstance().getEmpleado(nombre);
        
    }
    
}
