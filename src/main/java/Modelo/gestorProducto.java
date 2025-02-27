/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



import BBDDMSQL.FachadaBBDD;
import BBDDMSQL.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ilerna 4.2.7
 */
public class gestorProducto {
    
    public void altaProducto(int cod_producto, String nombre, double precio, int cantidad) throws Exception{
     //Comprobar si el producto ya existe
     Producto p = new FachadaBBDD().getProducto(nombre);
     if (Objects.nonNull(p)){
     throw new Exception("El producto existe");
     }
     if (precio<=0){
     throw new Exception("El precio no puede ser menor o igual a 0");
     }
     if (cantidad<=0){
     throw new Exception("La cantidad no puede ser menor o igual a 0");
     }
     if(cod_producto>0){
     }
     new FachadaBBDD().altaProducto(new Producto(cod_producto, nombre, precio, cantidad));
     }
   
     public void modificarProducto(int cod_acceso, String nombre, double precio, int cantidad) throws Exception{
     new FachadaBBDD().modificarProducto(new Producto(cod_acceso, nombre, precio,cantidad));
     }
     
      public Producto getProducto(String nombre_) throws SQLException{
     return new FachadaBBDD().getProducto(nombre_);
     }
      
      
     public void eliminarProducto(String p) throws SQLException{
     new FachadaBBDD().getProducto(p);
     
     }
     
     public ArrayList<Producto> getAllProducto() throws SQLException{
     return new FachadaBBDD().getAllProducto();
     }
     
    
     
    
    
}
