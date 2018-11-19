
package Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class Ventas {
   
   
  
   public Ventas(){}
 
  public static int InsertarCliente(String NombreCliente,String Direccion,String Nit,Connection conexion){
      try {
          PreparedStatement InsertarProducto = conexion.prepareStatement("INSERT INTO clientes(nombre,nit,direccion) VALUES(?,?,?)");
          InsertarProducto.setString(1,NombreCliente);
          InsertarProducto.setString(2, Nit);
          InsertarProducto.setString(3,Direccion);
          InsertarProducto.executeUpdate();
          
      
          Statement st = conexion.createStatement();
          ResultSet consulta = st.executeQuery("SELECT LAST_INSERT_ID()");
          consulta.next();
           return consulta.getInt(1);
            
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
          return 0;
      }
  }
  public static int InsertarFactura(double Total,double descuento,int idCliente,int idEmpleado,Connection conexion){
   
      try {
          PreparedStatement Insertar = conexion.prepareStatement("INSERT INTO ventas(fecha_venta,monto_venta,descuento,idclientes,idempleados) VALUES(?,?,?,?,?)");
          
          Statement Dat = conexion.createStatement();
          ResultSet consultaDate = Dat.executeQuery("SELECT now()");
          consultaDate.next();
          String DateTime = consultaDate.getString(1).toString();
          
          Insertar.setString(1,DateTime);
          Insertar.setDouble(2, Total);
          Insertar.setDouble(3, descuento);
          Insertar.setInt(4,idCliente);
          Insertar.setInt(5,idEmpleado);
          Insertar.executeUpdate();
          
             //Regresa el id de la factura que se acaba de ingresar
          Statement st = conexion.createStatement();
          ResultSet consultaid = st.executeQuery("SELECT LAST_INSERT_ID()");
          consultaid.next();
          return consultaid.getInt(1);
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
          return 0;  
      }
  }
  
  public static int InsertarProducto(int idVentas,Connection conexion,ArrayList<AtributoVentas> ListadoProducto){
      try {
          PreparedStatement InsercionDetalle = conexion.prepareStatement(
                  "INSERT INTO detalle_ventas(descripcion,cantidad,sub_total,idventas,idproducto) VALUES(?,?,?,?,?)");
          Statement st = conexion.createStatement();
          ResultSet Query; 
         int  cont = 0;
          while(cont < ListadoProducto.size()){
              Query = st.executeQuery("SELECT cantidad FROM producto WHERE id_producto = '"+ListadoProducto.get(cont).getIdInsercion()+"'");
              Query.next();
              if(Query.getInt(1) >= ListadoProducto.get(cont).getCantidad()){
                       InsercionDetalle.setString(1, ListadoProducto.get(cont).getDescripcion());
                       InsercionDetalle.setInt(2, ListadoProducto.get(cont).getCantidad());
                       InsercionDetalle.setDouble(3, ListadoProducto.get(cont).getTotal());
                       InsercionDetalle.setInt(4, idVentas);
                       InsercionDetalle.setInt(5, ListadoProducto.get(cont).getIdInsercion());
                       InsercionDetalle.executeUpdate();
                       cont++;
              }
              else return  cont; 
          }
          return -1;
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
          return -1;
      }
  }
    public static boolean StartTransaction(Connection BD){
       try {
           PreparedStatement start = BD.prepareStatement("START TRANSACTION;");
           start.executeUpdate();
           return true;
       } catch (SQLException ex) {
           Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
           return false;
       }
    }
     public static void Commit(Connection BD){
       try {
           PreparedStatement cm = BD.prepareStatement("COMMIT;");
           cm.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public static void Rollback(Connection BD){
       try {
           PreparedStatement rollback = BD.prepareStatement("ROLLBACK;");
           rollback.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
}
