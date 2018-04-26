
package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
   
    private static Connection conexion;
     public Conexion(){}
    public Connection ConectarBaseDatos(){
           
        try {

             conexion = DriverManager.getConnection("jdbc:mariadb://25.42.137.204/continental1","usuario1","Continental1");
             
             System.out.println("Abrio");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return conexion;
    }
    
    //public static Connection getConnection(){ return conexion; }
    
}
