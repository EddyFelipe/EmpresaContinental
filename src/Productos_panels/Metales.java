/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos_panels;

import Clases.Conexion;
import Clases.Insertar_producto;
import Forms.Productos;
import java.awt.event.KeyEvent;
import java.sql.Connection;
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
public class Metales extends javax.swing.JPanel {
    Conexion con= new Conexion();;
    Connection cn= con.ConectarBaseDatos();
    public String index="";
    /**
     * Creates new form Metales
     */
    public Metales() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(36, 41, 46));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 35, -1, -1));

        txtipo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtipoKeyTyped(evt);
            }
        });
        add(txtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 35, 140, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 100, -1, -1));

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Medida");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 170, -1, -1));

        txtmedida.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtmedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmedidaKeyTyped(evt);
            }
        });
        add(txtmedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 140, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio Venta");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 240, -1, -1));

        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });
        add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 140, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar3.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setInheritsPopupMenu(true);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agre2.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agre1.png"))); // NOI18N
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(verificar()!=0){
            Insertar_producto insertar = new Insertar_producto();
            String tipo;
            int cantidad,categoriaid;
            double medida,precio;
        
            tipo=txtipo.getText();
            cantidad= Integer.valueOf(txtcantidad.getText());
            medida = Double.valueOf(txtmedida.getText());
            precio = Double.valueOf(txtprecio.getText());
            categoriaid=id_categoria(index);
        
            insertar.insertar_producto(tipo, cantidad,0,"","",0,0, medida, precio,categoriaid);
            limpiar();
            JOptionPane.showMessageDialog(null,"Producto Ingresado Exitosamente");
        }else{
            
            JOptionPane.showMessageDialog(null,"Debe de completar los campos para ingresar el producto");
        }
          
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtipoKeyTyped
        // TODO add your handling code here:
        char validar =evt.getKeyChar();
            if(!Character.isLetter(validar)){
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtipoKeyTyped

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // TODO add your handling code here:
        char validar=evt.getKeyChar();

            if(!Character.isDigit(validar)){
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtmedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmedidaKeyTyped
        // TODO add your handling code here:
         char validar=evt.getKeyChar();

            if(!Character.isDigit(validar)){
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtmedidaKeyTyped

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        
            if((c<'0'||c>'9') && (c!= KeyEvent.VK_BACK_SPACE) && (c!='.')) evt.consume();
    }//GEN-LAST:event_txtprecioKeyTyped

    public void limpiar(){
        
        txtcantidad.setText("");
        txtipo.setText("");
        txtmedida.setText("");
        txtprecio.setText("");
    }
    
    public int id_categoria(String categoria){
        
        Statement st;
        int idcategoria=0;
          try {
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id FROM categoria WHERE categoria='"+categoria+"'");
              
        while (rs.next()) {
          
            idcategoria=rs.getInt(1);
            
        }    
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
       return idcategoria;
    }

    public int verificar(){
        
        if(!"".equals(txtipo.getText())&&!"".equals(txtcantidad.getText())&&!"".equals(txtmedida.getText())&&!"".equals(txtprecio.getText())){
            
            return 1;
        }else{
            
            return 0;
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
