
package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Usuario
 */
public class HistorialVenta {
    
    public static DefaultTableModel HistorialVentas(Connection Conexion){
       
         DefaultTableModel modelo = new DefaultTableModel();
         try {
           
            modelo.addColumn("Cliente");
            modelo.addColumn("Direccion"); 
            modelo.addColumn("Nit");
            modelo.addColumn("Fecha venta");
            modelo.addColumn("Descuento"); 
            modelo.addColumn("Monto Pagado");
            
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT  C.nombre,C.direccion,C.nit,F.fecha_venta,F.descuento,F.monto_venta FROM clientes C\n" +
             "INNER JOIN ventas F ON C.id_clientes = F.idclientes;");
           
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6)});
            }
            st.close();
            rs.close();
            
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
         return modelo;
    }
}
