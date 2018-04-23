/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Insertar_producto {

        String sql= "INSERT INTO producto(tipo,cantidad,yardaje,color,marca,tamaño,numero,medida,precio_venta,visible,categoria_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
    public void insertar_producto(String tipo, int cantidad,int yardaje,String color,String marca,int tamaño,int numero,double medida,double precio_venta,int categoria_id){
        
        Conexion con = new Conexion();
        Connection cn= con.ConectarBaseDatos();
            try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.setString(1,tipo);
            pps.setInt(2,cantidad);
            pps.setInt(3,yardaje);
            pps.setString(4,color);
            pps.setString(5,marca);
            pps.setInt(6,tamaño);
            pps.setInt(7,numero);
            pps.setDouble(8,medida);
            pps.setDouble(9,precio_venta);
            pps.setInt(10,1);
            pps.setInt(11,categoria_id);
            
            pps.executeUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(Insertar_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
  public static DefaultTableModel MostrarProducto(DefaultTableModel Modelo,Connection ConexionBsse){
    
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT nombre,existencia,precio_venta FROM producto");
          
              while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getString(1),consulta.getInt(2),consulta.getDouble(3)});
            }
            st.close();
            consulta.close();
        
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
  

    
}
