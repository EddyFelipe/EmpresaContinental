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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author igeni
 */
public class InsertarEmpleado {
    
    private PreparedStatement Insertar;
    private Statement St;
    
     
    public void Insertar(String nombres, String apellidos, String direccion) throws SQLException
    {
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("INSERT INTO empleados (nombre, apellido, estado, direccion)"+" values (?, ?, ?, ?)");
        
            Insertar.setString(1, nombres);
            Insertar.setString(2, apellidos);
            Insertar.setString(3, "Activo");
            Insertar.setString(4, direccion);
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void Modificar(String nombres, String apellidos, String direccion, int id) throws SQLException
    {
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("UPDATE empleados SET nombre = ?, apellido = ?, direccion = ? WHERE id_empleados = ?");
        
            Insertar.setString(1, nombres);
            Insertar.setString(2, apellidos);
            Insertar.setString(3, direccion);
            Insertar.setInt(4, id);
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void Eliminar(Object id) throws SQLException
    {
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("UPDATE empleados SET estado = ? WHERE id_empleados = ?");
        
            Insertar.setString(1, "Inactivo");
            Insertar.setInt(2, (int)id);
            
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void InsertarUsuario(String usuario, String contrasena, Object fila) throws SQLException
    {
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("UPDATE empleados SET usuario = ?, contrasena = ? WHERE id_empleados = ?");
            Insertar.setString(1, usuario);
            Insertar.setString(2, contrasena);
            Insertar.setInt(3, (int)fila);
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void ModificarUsuario(String contrasena, Object fila) throws SQLException
    {
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("UPDATE empleados contrasena = ? WHERE id_empleados = ?");
            Insertar.setString(1, contrasena);
            Insertar.setInt(2, (int)fila);
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void EliminarUsuario(String contrasena, Object fila) throws SQLException
    {
        Clases.Conexion con = new Clases.Conexion();
        Connection cn=con.ConectarBaseDatos();
        try
        {
            Insertar = cn.prepareStatement("UPDATE empleados usuario = ?, contrasena = ? WHERE id_empleados = ?");
            Insertar.setString(1, "");
            Insertar.setString(2, "");
            Insertar.setInt(3, (int)fila);
            Insertar.executeUpdate();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public DefaultTableModel Buscar(DefaultTableModel modelo)
    {
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
        String[] datos = new String[20];
        Statement st;
          try {
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_empleados, nombre, apellido, estado, direccion, usuario FROM empleados");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            System.out.println(datos[0]);
            datos[1]= rs.getString(2);
            System.out.println(datos[1]);
            datos[2]= rs.getString(3);
            System.out.println(datos[2]);
            datos[3]= rs.getString(5);
            System.out.println(datos[3]);
            datos[4]= rs.getString(4);
            System.out.println(datos[4]);
            datos[5]= rs.getString(6);
            System.out.println(datos[5]);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(InsertarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
          }
        return modelo;
    }
    
    public DefaultTableModel Filtro(DefaultTableModel modelo, String busqueda)
    {
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
        String[] datos = new String[6];
        Statement st;
          try {
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_empleados, nombre, apellido, estado, direccion, usuario FROM empleados WHERE nombre like"+'"'+ busqueda +"%"+'"');
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            System.out.println(datos[0]);
            datos[1]= rs.getString(2);
            System.out.println(datos[1]);
            datos[2]= rs.getString(3);
            System.out.println(datos[2]);
            datos[3]= rs.getString(5);
            System.out.println(datos[3]);
            datos[4]= rs.getString(4);
            System.out.println(datos[4]);
            datos[4]= rs.getString(6);
            System.out.println(datos[5]);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(InsertarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
          }
        return modelo;
    }
    
    public int ObtenerId(String nick)
    {
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
        String[] datos = new String[6];
        Statement st;
          try {
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_empleados from empleados where usuario = "+'"'+nick+'"');
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(InsertarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
          }
        return Integer.parseInt(datos[0]);
    }
    
    public boolean BuscarUsuario(String usuario)
    {
        Conexion con = new Conexion();
        Connection cn=con.ConectarBaseDatos();
        String[] datos = new String[5];
        Statement st;
          try {
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT usuario FROM empleados");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            try
            {
                if (datos[0].equals(usuario))
                return true;
            }
            catch (Exception ex)
            {
                return false;
            }
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(InsertarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
          }
        return false;
    }
}
