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
    Empleado pepe = null;
    ArrayList<Empleado> listaEmpleados = new ArrayList();
    
    //Necesitamos tener un empleado inicial, un objeto único en el sistema -> SINGLETON
    
    private static final DAOEmpleado INSTANCE = new DAOEmpleado();
    // El constructor privado no permite que se genere un constructor por defecto
    private DAOEmpleado() {
        listaEmpleados.add(new Empleado("Pepe","pepe",1));
    }

    public static DAOEmpleado getInstance() {
        return INSTANCE;
    }

    
    
    
    //Getter and Setter del ArrayList

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
        
    }
    
    //Método para comprobar si en la lista de empleados está un empleado específico
    public Empleado getEmpleado(String nombre){
        for(Empleado e: listaEmpleados){
            if(e.getNombre().equals(nombre)){
                pepe = e;
            }
        }
        return pepe;
    }
    
    
}
