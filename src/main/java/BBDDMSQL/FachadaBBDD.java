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
    
    public Empleado getEmpleado(String nombre) throws SQLException{
    return new DAOEmpleado().getEmpleado(nombre);
    }
    
    public void altaEmpleado(Empleado e){
    new DAOEmpleado().altaEmpleado(e);
    }
    public void eliminarEmpleado(String e){
    new DAOEmpleado().eliminarEmpleado(e);
    }
    
    public ArrayList<Empleado> getAllEmpleado() throws SQLException{
    return new DAOEmpleado().getAll();
    }
    public void modificarEmpleado(Empleado e){
    new DAOEmpleado().modificarEmpleado(e);
    }
}

