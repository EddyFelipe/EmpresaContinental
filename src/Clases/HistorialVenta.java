
package Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Felipe
 */
public class HistorialVenta {
    
   private ArrayList<Integer> idVentas;
    
    public HistorialVenta(){ idVentas = new ArrayList<>(); }
  
    public  DefaultTableModel HistorialVentas(Connection Conexion){
       
         DefaultTableModel modelo = new DefaultTableModel();
         try {
           
            modelo.addColumn("Cliente");
            modelo.addColumn("Direccion"); 
            modelo.addColumn("Nit");
            modelo.addColumn("Fecha venta");
            modelo.addColumn("Descuento"); 
            modelo.addColumn("Monto Pagado");
            idVentas.clear(); //Limpiando los id de ventas
            
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT  C.nombre,C.direccion,C.nit,F.fecha_venta,F.descuento,F.monto_venta,F.id_ventas FROM clientes C\n" +
             "INNER JOIN ventas F ON C.id_clientes = F.idclientes");

            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6)});
                idVentas.add(rs.getInt(7));
            }
            st.close();
            rs.close();
            
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
         return modelo;
    }
    
    /*FILTRA TODOS LOS PRODUCTOS PERTENECIENTES A LA VENTA SELECCIONADA*/
    public DefaultListModel Productos(int index, Connection BD){
         DefaultListModel listmodel = new DefaultListModel();
        try {
            Statement st = BD.createStatement();
            ResultSet rs = st.executeQuery("SELECT P.tipo FROM ventas V\n" +
                                           "INNER JOIN detalle_ventas DV ON DV.idventas = V.id_ventas\n" +
                                           "INNER JOIN producto P ON P.id_producto = DV.idproducto WHERE V.id_ventas = '"+idVentas.get(index)+"'");
            while(rs.next()){
               listmodel.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listmodel;
    }
    public DefaultTableModel BuscarCoincidencia(String nombre, Connection BD){
    
         DefaultTableModel modelo = new DefaultTableModel();
       try {
            modelo.addColumn("Cliente");
            modelo.addColumn("Direccion"); 
            modelo.addColumn("Nit");
            modelo.addColumn("Fecha venta");
            modelo.addColumn("Descuento"); 
            modelo.addColumn("Monto Pagado");
            idVentas.clear(); //Limpiando los id de ventas
           
           Statement st = BD.createStatement();
            ResultSet rs = st.executeQuery("SELECT  C.nombre,C.direccion,C.nit,F.fecha_venta,F.descuento,F.monto_venta,F.id_ventas FROM clientes C\n" +
             "INNER JOIN ventas F ON C.id_clientes = F.idclientes where match(C.nombre) against('"+nombre+"')");
           while(rs.next()){
              modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6)});
              idVentas.add(rs.getInt(7));
           }
            st.close();
            rs.close();
       } catch (SQLException ex) {
           Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
       }
   return  modelo;
  }
}
