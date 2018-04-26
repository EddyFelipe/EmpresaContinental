/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ismar
 */
public class Proveedor {
     String sql= "INSERT INTO proveedor(repartidor,nombre_empresa,correo,direccion) VALUES(?,?,?,?)";
           String sql1 = "DELETE FROM proveedor WHERE id_proveedor =?";
           String sql2 = "UPDATE proveedor SET repartidor=?,nombre_empresa=?,correo=?,direccion=? WHERE repartidor=?";
    public void insertar(String nombre,String empresa,String correo,String direccion){
        
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
            try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.setString(1,nombre);
            pps.setString(2,empresa);
            pps.setString(3,correo);
            pps.setString(4,direccion);
            pps.executeUpdate();
                System.out.println("se agrego exitosamente el proveedor");
            } catch (SQLException ex) {
                 Logger.getLogger(Insertar_producto.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println("no se agrego correctamente");
            }
    }
    
    public void Modificar(int id,String nombre,String empresa,String correo,String direccion, String telefono){
        
    }
    
    public void eliminar(int id) throws SQLException{
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
               try (PreparedStatement pps = cn.prepareStatement(sql1)) {
                   pps.setInt(1, id);
                   pps.execute();
               }
   }
    
    public void update(String nombre, String empresa,String correo,String direccion,int id) throws SQLException
    {
        PreparedStatement Insertar;
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("UPDATE proveedor SET repartidor = ?,nombre_empresa = ?, correo = ?,direccion = ? ,eliminado= ? WHERE id_proveedor ='"+id+"'");
            Insertar.setString(1, nombre);
            Insertar.setString(2, empresa);
            Insertar.setString(3, correo);
            Insertar.setString(4, direccion);
            Insertar.setBoolean(5, false);
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}

