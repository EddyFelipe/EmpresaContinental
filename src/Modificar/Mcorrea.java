/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modificar;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Mcorrea extends javax.swing.JPanel {
    Conexion con = new Conexion();
    Connection cn= con.ConectarBaseDatos();
    public int id_producto;

    /**
     * Creates new form Mcorrea
     */
    public Mcorrea(int id) {
        initComponents();
        mostrar(id);
        id_producto=id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcolor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        btguardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(36, 41, 46));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 150, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Color");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        txtcolor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 150, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        txtnumero.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 150, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio Venta");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 150, -1));

        btguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cambios.png"))); // NOI18N
        btguardar.setBorder(null);
        btguardar.setBorderPainted(false);
        btguardar.setContentAreaFilled(false);
        btguardar.setFocusPainted(false);
        btguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cambios2.png"))); // NOI18N
        btguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cambios1.png"))); // NOI18N
        btguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });
        add(btguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarActionPerformed
        // TODO add your handling code here:
        modificar();
    }//GEN-LAST:event_btguardarActionPerformed

    public void mostrar(int idproducto){
        
        String sql="SELECT cantidad,color,numero,precio_venta FROM producto WHERE id_producto='"+idproducto+"'";
        Statement st;
        
        try {
            st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            txtcantidad.setText(rs.getString(1));
            txtcolor.setText(rs.getString(2));
            txtnumero.setText(rs.getString(3));
            txtprecio.setText(rs.getString(4));
            
            
         }
        } catch (SQLException ex) {
            Logger.getLogger(Mcorrea.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void modificar(){
        
        int cantidad,numero;
        String color;
        float precio;
        
        cantidad=Integer.valueOf(txtcantidad.getText());
        color = txtcolor.getText();
        numero =Integer.valueOf(txtnumero.getText());
        precio=Float.valueOf(txtprecio.getText());
        
        String sql="UPDATE producto SET cantidad='"+cantidad+"',color='"+color+"',numero='"+numero+"',precio_venta='"+precio+"' WHERE id_producto='"+id_producto+"'";
        PreparedStatement preparado;
        
        try {
            preparado = cn.prepareStatement(sql);
            preparado.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mcorrea.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcolor;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
