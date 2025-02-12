/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestor;


import BBDDMSQL.ConexionMySQL;
import BBDDMSQL.DAOEmpleado;
import BBDDMSQL.Empleado;
import java.sql.SQLException;
  


/**
 *
 * @author Ilerna 4.2.7
 */
public class GESTOR {

    public static void main(String[] args) throws SQLException {
        //new Principal().autenticar();
        ConexionMySQL enlace = new ConexionMySQL();
        enlace.conectarMySQL();
        DAOEmpleado emp =new DAOEmpleado();
        emp.altaEmpleado(new Empleado("Luis","Luis",2));
        
    }
}
