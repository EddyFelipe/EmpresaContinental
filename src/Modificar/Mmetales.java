/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modificar;

import Clases.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Mmetales extends javax.swing.JPanel {
    Conexion con = new Conexion();
    Connection cn= con.ConectarBaseDatos();
    public int id_producto;

    /**
     * Creates new form Mmetales
     */
    public Mmetales(int id) {
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
        txtipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtmedida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        btguardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(36, 41, 46));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 30));

        txtipo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtipoKeyTyped(evt);
            }
        });
        add(txtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 140, 30));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 30));

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, 30));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Medida");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 30));

        txtmedida.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtmedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmedidaKeyTyped(evt);
            }
        });
        add(txtmedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 140, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio Venta");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 30));

        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });
        add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 140, 30));

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
        if(verificar()!=0){
            modificar();
        }else{
            JOptionPane.showMessageDialog(null,"Debe completar los campos para modificar");
        }
        
    }//GEN-LAST:event_btguardarActionPerformed

    private void txtipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtipoKeyTyped
        // TODO add your handling code here:
        char validar =evt.getKeyChar();
            if(Character.isLetter(validar)){
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtipoKeyTyped

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // TODO add your handling code here:
        char validar=evt.getKeyChar();

            if(Character.isDigit(validar)){
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtmedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmedidaKeyTyped
        // TODO add your handling code here:
         char validar=evt.getKeyChar();

            if(Character.isDigit(validar)){
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtmedidaKeyTyped

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        
        if((c<'0'||c>'9') && (c!= KeyEvent.VK_BACK_SPACE) && (c!='.')) evt.consume();
    }//GEN-LAST:event_txtprecioKeyTyped

    public void mostrar(int idproducto){
        
        try {
            String sql="SELECT tipo,cantidad,medida,precio_venta FROM producto WHERE id_producto='"+idproducto+"'";
            Statement st;
            
            st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            txtipo.setText(rs.getString(1));
            txtcantidad.setText(rs.getString(2));
            txtmedida.setText(rs.getString(3));
            txtprecio.setText(rs.getString(4));
            
            
         }
        } catch (SQLException ex) {
            Logger.getLogger(Mmetales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(){
        String tipo;
        int cantidad,medida;
        float precio;
        
        tipo=txtipo.getText();
        cantidad=Integer.valueOf(txtcantidad.getText());
        medida=Integer.valueOf(txtmedida.getText());
        precio=Float.valueOf(txtprecio.getText());
        
        String sql="UPDATE producto SET tipo='"+tipo+"',cantidad='"+cantidad+"',medida='"+medida+"',precio_venta='"+precio+"' WHERE id_producto='"+id_producto+"'";
        PreparedStatement preparado;
        
        try {
            preparado = cn.prepareStatement(sql);
            preparado.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mmetales.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
     public int verificar(){
        
        if(!"".equals(txtipo.getText())&&!"".equals(txtcantidad.getText())&&!"".equals(txtmedida.getText())&&!"".equals(txtprecio.getText())){
            
            return 1;
        }else{
            
            return 0;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtipo;
    private javax.swing.JTextField txtmedida;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
