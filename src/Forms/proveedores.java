/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Clases.Proveedor;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ismar
 */
public class proveedores extends javax.swing.JPanel {
     int cont=1;
     int modifier=0;
     int filaSeleccionada=0;
      public DefaultTableModel modelo = new DefaultTableModel(); 
    /**
     * Creates new form proveedores
     */
    public proveedores() {
        initComponents();
                 int gapWidth = 10;
        int gapHeight = 4;
        jTable1.setIntercellSpacing(new Dimension(gapWidth, gapHeight));
        modelo.addColumn("No.");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nombre Empresa");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Dirección");
        modelo.addColumn("Telefóno");
        jTable1.setModel(modelo);
        jPanel2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtDireccion = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtCorreo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtEmpresa = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregarP = new javax.swing.JButton();
        btnModificarp = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1420, 780));
        setMinimumSize(new java.awt.Dimension(1420, 780));
        setPreferredSize(new java.awt.Dimension(1420, 780));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1420, 10));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 10, 740));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pedidop.png"))); // NOI18N
        jButton6.setText("jButton4");
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pedido_click.png"))); // NOI18N
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pedido_mouse.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 100, 110));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminarp.png"))); // NOI18N
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar_click.png"))); // NOI18N
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar_mouse.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 100, 100));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Comprarp.png"))); // NOI18N
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Comprar_click.png"))); // NOI18N
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Comprar_mouse.png"))); // NOI18N
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 100, 100));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setMaximumSize(new java.awt.Dimension(493, 619));
        jPanel2.setMinimumSize(new java.awt.Dimension(493, 619));
        jPanel2.setPreferredSize(new java.awt.Dimension(493, 619));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cont1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 360, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PROVEEDOR");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Empresa:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo electrónico:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Teléfono:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar3.png"))); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agre2.png"))); // NOI18N
        btnAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agre1.png"))); // NOI18N
        btnAceptar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, -1, -1));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 160, 10));

        txtTelefono.setBackground(new java.awt.Color(36, 41, 46));
        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(null);
        txtTelefono.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 160, 30));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 160, 10));

        txtDireccion.setBackground(new java.awt.Color(36, 41, 46));
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(null);
        txtDireccion.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 160, 30));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 160, 10));

        txtCorreo.setBackground(new java.awt.Color(36, 41, 46));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(null);
        txtCorreo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 160, 30));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 160, 10));

        txtEmpresa.setBackground(new java.awt.Color(36, 41, 46));
        txtEmpresa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtEmpresa.setBorder(null);
        txtEmpresa.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 160, 30));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 160, 10));

        txtNombre.setBackground(new java.awt.Color(36, 41, 46));
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 160, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 500, 660));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No. Resgistro", "Nombre", "Nombre Empresa", "Correo Electrónico", "Dirección", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 1090, 650));

        btnAgregarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregarp.png"))); // NOI18N
        btnAgregarP.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar_click.png"))); // NOI18N
        btnAgregarP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar_mouse.png"))); // NOI18N
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, 100));

        btnModificarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificarp.png"))); // NOI18N
        btnModificarp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificar_click.png"))); // NOI18N
        btnModificarp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificar_mouse.png"))); // NOI18N
        btnModificarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarpActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 100, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1418, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int filaselec = jTable1.getSelectedRow();
        if (filaselec>=0) {
             JOptionPane.showMessageDialog(null, "esta seguro de eliminar a este proveedor.");
            modelo.removeRow(filaselec);
            Proveedor delete = new Proveedor();
            try {
                delete.eliminar(filaselec);
                 JOptionPane.showMessageDialog(null, "Proveedor eliminado de forma permanente.");
            } catch (SQLException ex) {
                Logger.getLogger(proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else{
             JOptionPane.showMessageDialog(null, "Por favor, seleccione una casilla.");
            jPanel2.setVisible(false);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         Proveedor enviar = new Proveedor();
        if (modifier==0 && filaSeleccionada ==0) {
            String Dato [] = new String[6];
            Dato[0] = String.valueOf(cont);
            Dato[1] = txtNombre.getText();
            Dato[2] = txtEmpresa.getText();
            Dato[3] = txtCorreo.getText();
            Dato[4] = txtDireccion.getText();
            JOptionPane.showMessageDialog(null, "Proveedor ingresado exitosamente!");
            jPanel2.setVisible(false);
            modelo.addRow(Dato);
            enviar.insertar(txtNombre.getText(), txtEmpresa.getText(), txtCorreo.getText(),txtDireccion.getText());
            txtNombre.setText("");
            txtEmpresa.setText("");
            txtCorreo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            cont++;
        }else{
        try {
            enviar.uptadte(txtNombre.getText(), txtEmpresa.getText(), txtCorreo.getText(),txtDireccion.getText());
        } catch (SQLException ex) {
            Logger.getLogger(proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "Proveedor modificado exitosamente!");
            jPanel2.setVisible(false);
            jTable1.setValueAt(txtNombre.getText(),filaSeleccionada ,1);
            jTable1.setValueAt(txtEmpresa.getText(),filaSeleccionada ,2);
            jTable1.setValueAt(txtCorreo.getText(),filaSeleccionada ,3);
            jTable1.setValueAt(txtDireccion.getText(),filaSeleccionada ,4);
            txtNombre.setText("");
            txtEmpresa.setText("");
            txtCorreo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            filaSeleccionada=0;
            modifier=0;
        }
        
      //  System.out.println("SE HA ENVIADO A LA DATA BASE");
        

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
        // TODO add your handling code here:
         jPanel2.setVisible(true);
    }//GEN-LAST:event_btnAgregarPActionPerformed

    private void btnModificarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarpActionPerformed
        // TODO add your handling code here:
          modifier=1;
        filaSeleccionada=1;
        int filaSelec = jTable1.getSelectedRow();
        if (filaSelec>=0){
            jPanel2.setVisible(true);
            txtNombre.setText(jTable1.getValueAt(filaSelec, 1).toString());
            txtEmpresa.setText(jTable1.getValueAt(filaSelec, 2).toString());
            txtCorreo.setText(jTable1.getValueAt(filaSelec, 3).toString());
            txtDireccion.setText(jTable1.getValueAt(filaSelec, 4).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una casilla.");
        }
    }//GEN-LAST:event_btnModificarpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnModificarp;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}