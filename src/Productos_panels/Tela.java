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
public class Tela extends javax.swing.JPanel {

    Conexion con= new Conexion();;
    Connection cn= con.ConectarBaseDatos();
    Insertar_producto insertar = new Insertar_producto();
    public String index="";
    
    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
       // jLabel6.setText(String.valueOf(id));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtipo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboyarda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtcolor = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(36, 41, 46));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtipo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtipoKeyTyped(evt);
            }
        });
        add(txtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 160, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Precio Venta");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        comboyarda.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        comboyarda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50", "100", "200" }));
        add(comboyarda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 160, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Yardaje");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Color");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        txtcantidad.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 160, -1));

        txtcolor.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtcolor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcolorKeyTyped(evt);
            }
        });
        add(txtcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 160, -1));

        txtPrecioVenta.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });
        add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 160, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar3.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agre2.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agre1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(verificar()!=0){
            String tipo=txtipo.getText(),color=txtcolor.getText();
            int cantidad,yardaje,categoriaid;
            double precio;
            precio=Double.valueOf(txtPrecioVenta.getText());
            cantidad= Integer.valueOf(txtcantidad.getText());
            yardaje = Integer.valueOf(String.valueOf(comboyarda.getSelectedItem()));
            categoriaid=id_categoria(index);
        
            insertar.insertar_producto(tipo,cantidad,yardaje,color,"",0,0,0,precio,categoriaid);
            limpiar();
            JOptionPane.showMessageDialog(null,"Producto Ingresado Exitosamente");
        }else{
            JOptionPane.showMessageDialog(null,"Debe de llenar los campos para ingresar el producto");
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

    private void txtcolorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcolorKeyTyped
        // TODO add your handling code here:
         char validar =evt.getKeyChar();
            if(!Character.isLetter(validar)){
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtcolorKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        
            if((c<'0'||c>'9') && (c!= KeyEvent.VK_BACK_SPACE) && (c!='.')) evt.consume();

    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    public void limpiar(){
        
        txtPrecioVenta.setText("");
        txtcantidad.setText("");
        txtcolor.setText("");
        txtipo.setText("");
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
        
        if(!"".equals(txtPrecioVenta.getText())&&!"".equals(txtcantidad.getText())&&!"".equals(txtcolor.getText())&&!"".equals(txtipo.getText())){
            return 1;
        }else{
            return 0;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboyarda;
    public static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcolor;
    private javax.swing.JTextField txtipo;
    // End of variables declaration//GEN-END:variables
}
