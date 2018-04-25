
package Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Ventas {
   
   
  public Ventas(){}
  
  public static boolean InsertarFactura(String NombreCliente,String Nit,String Direccion,double monto,int idEmpleado,Connection conexion,ArrayList<AtributoVentas> ListadoProducto){
      try {
          PreparedStatement InsertarProducto = conexion.prepareStatement("INSERT INTO clientes(nombre,nit,direccion) VALUES(?,?,?)");
          InsertarProducto.setString(1,NombreCliente);
          InsertarProducto.setString(2, Nit);
          InsertarProducto.setString(3,Direccion);
          InsertarProducto.executeUpdate();
          
          int id,cont;
          Statement st = conexion.createStatement();
          ResultSet consulta = st.executeQuery("SELECT LAST_INSERT_ID()");
          consulta.next();
          id = consulta.getInt(1);
          
          //Insercion de la factura 
          PreparedStatement InsercionFactura = conexion.prepareStatement(
         "INSERT INTO ventas(fecha_venta,monto_venta,idclientes,idempleados) VALUES(?,?,?,?)");
          InsercionFactura.setString(1, "now()");
          InsercionFactura.setDouble(2, monto);
          InsercionFactura.setInt(3,id);
          InsercionFactura.setInt(4, idEmpleado);
          InsercionFactura.executeLargeUpdate();
          
          //Regresa el id de la factura que se acaba de ingresar
          ResultSet consultaid = st.executeQuery("SELECT LAST_INSERT_ID()");
          consultaid.next();
          id = consultaid.getInt(1);
          
          //Insertcion de los productos que el cliente compro
          PreparedStatement InsercionDetalle = conexion.prepareStatement(
         "INSERT INTO detalle_ventas(descripcion,cantidad,sub_total,idventas,idproducto) VALUES(?,?,?,?,?)");
          cont = 0;
          while(cont < ListadoProducto.size()){
             InsercionDetalle.setString(1, ListadoProducto.get(cont).getDescripcion());
             InsercionDetalle.setInt(2, ListadoProducto.get(cont).getCantidad());
             InsercionDetalle.setDouble(3, ListadoProducto.get(cont).getTotal());
             InsercionDetalle.setInt(4, id);
             InsercionDetalle.setInt(5, ListadoProducto.get(cont).getIdInsercion());
             InsercionDetalle.executeUpdate();
             cont++;
          }
         
          return true;
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      }
  }
}
