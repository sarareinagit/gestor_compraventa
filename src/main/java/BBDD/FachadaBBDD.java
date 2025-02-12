/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.util.ArrayList;

/**
 *
 * @author Ilerna 4.2.7
 */
public class FachadaBBDD {

    public Empleado getEmpleado(String nombre){
    return DAOEmpleado.getInstance().getEmpleado(nombre);   
    }
    
    public void altaEmpleado(Empleado e){
    DAOEmpleado.getInstance().altaEmpleado(e);
    }

    public void modificarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarEmpleado(String e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Empleado> getAllEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
