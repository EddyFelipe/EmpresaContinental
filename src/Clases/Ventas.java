
package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Ventas {
   
   
  public Ventas(){}
  
  public static DefaultTableModel MostrarProducto(DefaultTableModel Modelo,Connection ConexionBsse){
    
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT id_producto,cantidad FROM producto");
          
              while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getInt(1),consulta.getInt(2)});
            }
            st.close();
            consulta.close();
        
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
}
