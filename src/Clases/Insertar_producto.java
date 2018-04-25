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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Insertar_producto {

       private static ArrayList<Integer> idProducto;
    String sql= "INSERT INTO producto(tipo,cantidad,yardaje,color,marca,tamaño,numero,medida,precio_venta,visible,categoria_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
    private static void SetArray(ArrayList<Integer> arr){idProducto = arr; }
    public static ArrayList getAraayId(){ return idProducto; }
    
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
    
   //Metodos para mostrar los productos que pertenecen a alguna categoria
  public static DefaultTableModel MostrarTela(Connection ConexionBsse,int id){
     
      DefaultTableModel Modelo = new DefaultTableModel();
      Modelo.addColumn("Nombre"); Modelo.addColumn("Color"); Modelo.addColumn("Existencia"); Modelo.addColumn("Q. Venta");
      
      ArrayList<Integer> ids = new ArrayList<>();
       //Reiniciando los ids de los productos
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT tipo,color,cantidad,precio_venta,id_producto FROM producto WHERE categoria_id = '"+id+"'");
          
              while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getString(1),consulta.getString(2),consulta.getInt(3),consulta.getDouble(4)});
              ids.add(consulta.getInt(5));
            }
            SetArray(ids);
            st.close();
            consulta.close();      
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
  
    public static DefaultTableModel MostrarEtiqueta(Connection ConexionBsse,int id){
     
      DefaultTableModel Modelo = new DefaultTableModel();
      Modelo.addColumn("Marca"); Modelo.addColumn("Existencia"); Modelo.addColumn("Q. Venta");
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT marca,cantidad,precio_venta,id_producto FROM producto WHERE categoria_id = '"+id+"'");
          
          ArrayList<Integer> ids = new ArrayList<>();
          
            while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getString(1),consulta.getInt(2),consulta.getDouble(3)});
              ids.add(consulta.getInt(4));
            }
            SetArray(ids);
            st.close();
            consulta.close();      
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
      public static DefaultTableModel MostrarCarrito(Connection ConexionBsse,int id){
     
      DefaultTableModel Modelo = new DefaultTableModel();
      Modelo.addColumn("Tamaño"); Modelo.addColumn("Numero"); Modelo.addColumn("Color"); Modelo.addColumn("Existencia"); Modelo.addColumn("Q Venta");
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT tamaño,numero,color,cantidad,precio_venta,id_producto FROM producto WHERE categoria_id = '"+id+"'");
          
          ArrayList<Integer> ids = new ArrayList<>();
          
            while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getString(1),consulta.getInt(2),consulta.getString(3),consulta.getInt(4),consulta.getDouble(5)});
              ids.add(consulta.getInt(6));
            }
            SetArray(ids);
            st.close();
            consulta.close();      
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
      
        public static DefaultTableModel MostrarMetalesyPlastico(Connection ConexionBsse,int id){
     
      DefaultTableModel Modelo = new DefaultTableModel();
      Modelo.addColumn("Nombre"); Modelo.addColumn("Medida");  Modelo.addColumn("Existencia"); Modelo.addColumn("Q Venta");
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT tipo,medida,cantidad,precio_venta,id_producto FROM producto WHERE categoria_id = '"+id+"'");
          
          ArrayList<Integer> ids = new ArrayList<>();
          
             while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getString(1),consulta.getInt(2),consulta.getDouble(3)});
              ids.add(consulta.getInt(4));
             }
             SetArray(ids);
            st.close();
            consulta.close();      
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
        
          public static DefaultTableModel MostrarCorrea(Connection ConexionBsse,int id){
     
      DefaultTableModel Modelo = new DefaultTableModel();
      Modelo.addColumn("Numero"); Modelo.addColumn("Color");  Modelo.addColumn("Existencia"); Modelo.addColumn("Q Venta");
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT numero,color,cantidad,precio_venta,id_producto FROM producto WHERE categoria_id = '"+id+"'");
          
           ArrayList<Integer> ids = new ArrayList<>();
            
             while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getInt(1),consulta.getString(2),consulta.getInt(3),consulta.getDouble(4)});
              ids.add(consulta.getInt(5));
             }
             SetArray(ids);
            st.close();
            consulta.close();      
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
       public static DefaultTableModel MostrarZipper(Connection ConexionBsse,int id){
     
      DefaultTableModel Modelo = new DefaultTableModel();
      Modelo.addColumn("Tamaño"); Modelo.addColumn("Numero");  Modelo.addColumn("Color");  Modelo.addColumn("Existencia"); Modelo.addColumn("Q Venta");
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT tamaño,numero,color,cantidad,precio_venta,id_producto FROM producto WHERE categoria_id = '"+id+"'");
          ArrayList<Integer> ids = new ArrayList<>();
              while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getString(1),consulta.getInt(2),consulta.getString(3),consulta.getInt(4),consulta.getDouble(5)});
               ids.add(consulta.getInt(6));
             }
              SetArray(ids);
            st.close();
            consulta.close();      
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
   
    public static DefaultTableModel MostrarHilo(Connection ConexionBsse,int id){
     
      DefaultTableModel Modelo = new DefaultTableModel();
      Modelo.addColumn("Marca"); Modelo.addColumn("Color");  Modelo.addColumn("Existencia"); Modelo.addColumn("Q Venta");
      try {
          Statement st = ConexionBsse.createStatement();
          ResultSet consulta = st.executeQuery("SELECT marca,color,cantidad,precio_venta,id_producto FROM producto WHERE categoria_id = '"+id+"'");
          ArrayList<Integer> ids = new ArrayList<>();
             
           while(consulta.next()){
              Modelo.addRow(new Object[]{consulta.getString(1),consulta.getString(2),consulta.getInt(3),consulta.getDouble(4)});
              ids.add(consulta.getInt(5));
           }
           SetArray(ids);
            st.close();
            consulta.close();      
      } catch (SQLException ex) {
          Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
      }
     return Modelo;
  }
  
  public static DefaultListModel Categoria(Connection Conexion){
         DefaultListModel listaCategoria = new DefaultListModel();
            try {
                Statement st = Conexion.createStatement();
                ResultSet consulta = st.executeQuery("SELECT categoria FROM categoria");
                
                while(consulta.next()){
                  listaCategoria.addElement(consulta.getString(1));
                }
                st.close();
                consulta.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
      return listaCategoria;
  }

}
