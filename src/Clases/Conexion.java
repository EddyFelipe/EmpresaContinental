
package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public Conexion(){}
    
    public void ConectarBaseDatos(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nombre de la base datos", "root", "password");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
