package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.select;
import static javafx.beans.binding.Bindings.select;
import static javafx.beans.binding.Bindings.select;


public class Cliente {
   private String nombre,direccion,nit;
   private int idCliente;
   
   public Cliente(){}
   
    public int InsertarCliente(String NombreClien, String DireccionClien,String NitClien,Connection ConexionBase){
       try {
           PreparedStatement stm;
           
           stm = ConexionBase.prepareStatement("INSERT INTO cliente(nombre,nit,iddireccion) VALUES(?,?,?)");
           stm.setString(1, NombreClien);
           stm.setString(2, NitClien);
       } catch (SQLException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
       }
       return 0;
  }
  private int idDireccion(String DireccionClien,Connection ConexionBases){
      
      int id = 0;
       try {
           PreparedStatement stm;
          
           stm = ConexionBases.prepareStatement("SELECT * FROM direccion WHERE direccion.direccion = ? ");
           stm.setString(1, DireccionClien);
           ResultSet consulta = stm.executeQuery();
           
           if(consulta.next()){
            id = consulta.getInt("iddireccion");
           }else{
            stm = ConexionBases.prepareStatement("INSERT INTO direccion(direccion) VALUES(?)");
            stm.setString(1, DireccionClien);
            stm.executeUpdate();
            Statement st = ConexionBases.createStatement();
            consulta = st.executeQuery("select last_insert_id()");
            consulta.next();
            id = consulta.getInt(1);
           }
       } catch (SQLException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
       }
       return id;
  }
}
