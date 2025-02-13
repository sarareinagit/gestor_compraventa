/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDDMSQL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Ilerna 4.2.7
 */
public class DAOEmpleado {
       ConexionMySQL conexion = new ConexionMySQL();
       PreparedStatement ps=null;
    
    public void altaEmpleado(Empleado e){
    try {
        Connection con = conexion.conectarMySQL();
        ps = con.prepareStatement("INSERT INTO empleado (nombre, codAcceso, password) VALUES(?,?,?) ");
        ps.setString(1, e.getNombre());
        ps.setInt(2, e.getCodAcceso());
        ps.setString(3, e.getPassword());
        int res = ps.executeUpdate();
        if (res > 0) {
            System.out.println("Persona Guardada");            
        } else {
            System.out.println("Error al Guardar persona");           
        }
        con.close();
    } catch (SQLException ex) {
        System.err.println(ex);
    }
    }
    
    public Empleado getEmpleado(String nombre_) throws SQLException{
        Connection con = conexion.conectarMySQL();
	Empleado e = new Empleado();
   	ps = con.prepareStatement("SELECT * FROM empleado WHERE nombre = ?");
    	ps.setString(1, nombre_);
    	ResultSet rs = ps.executeQuery();
        if (rs.next()){
           
            e.setNombre(rs.getString("nombre"));
            e.setCodAcceso(rs.getInt("codAcceso"));
            e.setPassword(rs.getString("password"));
        }
        else{       
        e=null;
        }
        return e;
    }
    
    public void eliminarEmpleado(String nombre) throws SQLException{
    
        Connection con = conexion.conectarMySQL();
        ps = con.prepareStatement("DELETE FROM empleado WHERE nombre = ?");
        ps.setString(1, nombre);
        int res = ps.executeUpdate();
        con.close();
    }
    
    public ArrayList<Empleado> getAll() throws SQLException{
        ArrayList<Empleado> lista = new ArrayList();
        Connection con = conexion.conectarMySQL();
	ps = con.prepareStatement("SELECT * FROM empleado");
    	ResultSet rs = ps.executeQuery();
        while(rs.next()){ 
            Empleado e = new Empleado();
            e.setNombre(rs.getString("nombre"));
            e.setCodAcceso(rs.getInt("codAcceso"));
            e.setPassword(rs.getString("password"));
            lista.add(e);
        }        
        return lista;
    }
    
    public void modificarEmpleado(Empleado e){
    try {
        Connection con = conexion.conectarMySQL();
        ps = con.prepareStatement("UPDATE empleado SET codAcceso=?, password=? where nombre=?");
     
        ps.setInt(1, e.getCodAcceso());
        ps.setString(2, e.getPassword());
         ps.setString(3, e.getNombre());
        int res = ps.executeUpdate();
        if (res > 0) {
            System.out.println("Persona Modificada");            
        } else {
            System.out.println("Error al Modificar persona");           
        }
        con.close();
    } catch (SQLException ex) {
        System.err.println(ex);
    }
    }
    
}
