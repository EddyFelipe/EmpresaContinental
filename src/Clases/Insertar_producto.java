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

/**
 *
 * @author carlo
 */
public class Insertar_producto {

        String sql= "INSERT INTO producto(tipo,cantidad,yardaje,color,marca,tamaño,numero,medida,precio_venta,producto_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
        
    public void insertar_producto(String tipo, int cantidad,int yardaje,String color,String marca,int tamaño,int numero,double medida,double precio_venta,int id_producto){
        
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
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
             pps.setInt(10,id_producto);
            pps.executeUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(Insertar_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
