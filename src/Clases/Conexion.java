
package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public Conexion(){}
    
    public Connection ConectarBaseDatos(){
        
        Connection con = null;
        try {
             con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/continental1", "root", "1234");
    
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return con;
    }
    
}
