/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos_panels;

import Clases.Insertar_producto;

/**
 *
 * @author carlo
 */
public class Hilo extends javax.swing.JPanel {

    /**
     * Creates new form Hilo
     */
    public Hilo() {
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
        txtcantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcolor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(36, 41, 46));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 40, -1, -1));

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 140, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 100, -1, -1));

        txtmarca.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 140, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Color");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 160, -1, -1));

        txtcolor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 140, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio Venta");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 220, -1, -1));

        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 140, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar3.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agre2.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agre1.png"))); // NOI18N
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Insertar_producto insertar = new Insertar_producto();
        
        int cantidad;
        String marca,color;
        double precio;
        
        cantidad= Integer.valueOf(txtcantidad.getText());
        marca = txtmarca.getText();
        color = txtcolor.getText();
        precio= Double.valueOf(txtprecio.getText());
        
        insertar.insertar_producto("Hilo","", cantidad,0, color, marca,0,0,0, precio,7);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcolor;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
