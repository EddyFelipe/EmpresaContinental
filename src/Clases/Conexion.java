
package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public Conexion(){}
    
    public void ConectarBaseDatos(){
        
        Connection con = null;
        try {
             con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/prueba", "root", "1234");
             Statement stm = con.createStatement();
             
             ResultSet resul = stm.executeQuery("SELECT * FROM cliente");
             String nombre;
             int edad;
             while(resul.next()){
               nombre = resul.getString("nombre");
               edad = resul.getInt("edad");
                 System.out.println(nombre+"  edad: "+edad);
             }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      //  return con;
    }
    
}
