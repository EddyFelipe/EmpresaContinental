/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Forms.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author igeni
 */
public class Telefono {
    private PreparedStatement Insertar;
    private Statement St;
    
     
    public void Insertar(String numero, int empleado) throws SQLException
    {
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("INSERT INTO telefono (numero, empleados_id_empleados)"+" values (?,?)");
        
            Insertar.setString(1, numero);
            Insertar.setInt(2, empleado);
        
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public DefaultTableModel Buscar(DefaultTableModel modelo, int indice)
    {
        
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
        String[] datos = new String[1];
        Statement st;
          try {
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT numero FROM telefono WHERE empleados_id_empleados = " + indice);
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
        return modelo;
    }
}
