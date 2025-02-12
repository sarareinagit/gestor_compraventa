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
public class DAOProducto {
       ConexionMySQL conexion = new ConexionMySQL();
       PreparedStatement ps=null;
    
    //Método para añadir nuevo producto   
    public void altaProducto(Producto p){
        try {
            Connection con = conexion.conectarMySQL();
            ps = con.prepareStatement("INSERT INTO productos (cod_producto, nombre, precio) VALUES(?,?,?)");
            ps.setInt(1, p.getCod_producto());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("Producto Guardado");            
            }else {
                System.out.println("Error al Guardar producto");           
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    //Método para buscar producto por nombre
    public Producto getProducto(String nombre_) throws SQLException{
        Connection con = conexion.conectarMySQL();
        Producto p = new Producto();
   	ps = con.prepareStatement("SELECT * FROM productos WHERE nombre = ?");
    	ps.setString(1, nombre_);
    	ResultSet rs = ps.executeQuery();
        if (rs.next()){
            p.setCod_producto(rs.getInt("cod_producto"));
            p.setNombre(rs.getNString("nombre"));
            p.setPrecio(rs.getDouble("precio"));
        }else{       
            p=null;
        }
        return p;
    }
    
    //Método para eliminar Producto por nombre  
    public void eliminarProducto(String nombre){
        try {
            Connection con = conexion.conectarMySQL();
            ps = con.prepareStatement("DELETE FROM productos WHERE nombre = ?");
            ps.setString(1, nombre);
            int res = ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    //Método para modificar/actualizar producto
    public void modificarProducto(Producto p){
        try {
            Connection con = conexion.conectarMySQL();
            ps = con.prepareStatement("UPDATE productos SET cod_acceso=?, precio=? where nombre=?");
            ps.setInt(1, p.getCod_producto());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getNombre());
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("Producto Modificado");            
            } else {
                System.out.println("Error al Modificar producto");           
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    //Listar productos
    public ArrayList<Producto> getAll() throws SQLException{
        ArrayList<Producto> lista = new ArrayList();
        Connection con = conexion.conectarMySQL();
	ps = con.prepareStatement("SELECT * FROM productos");
    	ResultSet rs = ps.executeQuery();
        while(rs.next()){ 
            Producto p = new Producto();
            p.setCod_producto(rs.getInt("cod_producto"));
            p.setNombre(rs.getNString("nombre"));
            p.setPrecio(rs.getDouble("precio"));
            lista.add(p);
        }        
        return lista;
    }
}
