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
public class DAOEmpleado {
    //Empleado pepe = null;
    ArrayList<Empleado> listaEmpleados = new ArrayList();
    private static final DAOEmpleado INSTANCE = new DAOEmpleado();

    private DAOEmpleado() {        
        listaEmpleados.add(new Empleado("pepe", "pepe",1));        
    }
    
    public static DAOEmpleado getInstance() {
        return INSTANCE;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    public Empleado getEmpleado(String nombre){
        Empleado pepe = null;
        for(Empleado e: listaEmpleados){
            if(e.getNombre().equals(nombre)){ 
                System.out.println("entrooooo");
                pepe=e;
            }
        }
    return pepe;
    }
    
    public void altaEmpleado(Empleado e){
        listaEmpleados.add(e);    
    }
    
  
}
