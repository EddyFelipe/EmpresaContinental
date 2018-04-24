/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Clases.*;
import com.sun.glass.events.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Ventas extends javax.swing.JPanel {

    /**
     * Creates new form Ventas
     */
    //DECLARACION DE VARIABLES 
    private String ColumnaVentas[] = {"Producto","Cantidad","Descripcion","Total"};
    private DefaultTableModel ModeloVentas,ModeloProductos;
    private Connection ConexionBaseDatos;
    private boolean ProductoSeleccionado;
    private ArrayList<Clases.AtributoVentas> ListaProductos;
    private int RowSeleccionado,RowCategoria;
    private double Total,Descuento = 0; 
    private DefaultListModel ModeloLista;
    private ArrayList<ElementosCategoria> ProductosCategoria;
    public Ventas() {
        initComponents();
       Grupo1.add(RbYarda);
       Grupo1.add(RbUnidades);
       Grupo1.add(RbMillar);
       Grupo1.add(RbCientos);
       Grupo1.add(RbRollos);
       
       ModeloVentas = new DefaultTableModel();
       ModeloLista = new DefaultListModel();
       ModeloVentas.setColumnIdentifiers(ColumnaVentas);        
       TableVentas.setModel(ModeloVentas);
        
       //Conexion a la base de datos
       Conexion con = new Conexion();
       ConexionBaseDatos = con.ConectarBaseDatos();
    //   ConexionBaseDatos = Clases.Conexion.getConnection();
       
       //Variables
       ProductoSeleccionado = false;
       ListaProductos = new ArrayList<>();
       ProductosCategoria = new ArrayList<>();
       
       //Llamada a metodos
       TablaProductos();  
       ComponentesInit();
       MetodoRadioButon();
       OcultarDescuentos();
       DobleClikJlist();
     //  TableVentas.setComponentPopupMenu(PopMenu);
    }
    
    //Metodos que se van a utilizar en el formulario
    private void ComponentesInit(){
       ModeloLista = Insertar_producto.Categoria(ConexionBaseDatos);
       ListadoTipos.setModel(ModeloLista);
       CargarProductoCategorias();
    }
    
    //Funcion para dar doble click sobre el jtable producto
    private void TablaProductos(){
      TablaProductos.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e){
           
              if(e.getClickCount() == 2){
                ProductoSeleccionado = true;
                RowSeleccionado = TablaProductos.getSelectedRow();
                SelectProducto.setText(ModeloProductos.getValueAt(TablaProductos.getSelectedRow(),0).toString());
              }
          }
        });
    }
    //Funcion para dar doble click sobre el jlist categoria
    private void DobleClikJlist(){
      ListadoTipos.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e){
           
              if(e.getClickCount() == 2){
                  ModeloProductos = ProductosCategoria.get(ListadoTipos.getSelectedIndex()).getModelo();
                  TablaProductos.setModel(ModeloProductos);
                  RowCategoria = ListadoTipos.getSelectedIndex();
              }
          }
        });
    }
    private void MetodoRadioButon(){
       RbCientos.setActionCommand("Cientos");
       RbMillar.setActionCommand("Millar");
       RbRollos.setActionCommand("Rollos");
       RbUnidades.setActionCommand("Unidades");
       RbYarda.setActionCommand("Yarda");
  }
    //METODO para agregar una venta
   private void AgregarVenta(short col){
       
    if(ProductoSeleccionado && Grupo1.getSelection() != null && !txtCantidad.getText().equals("")){
           Clases.AtributoVentas venta = new Clases.AtributoVentas();
           //Seteando los los datos de la venta
           venta.SetProducto(SelectProducto.getText());
           venta.SetDescripcion(Grupo1.getSelection().getActionCommand());
           venta.SetCantidad(Integer.parseInt(txtCantidad.getText()));
           venta.SetTotal(Double.parseDouble(ModeloProductos.getValueAt(RowSeleccionado, col).toString())*venta.getCantidad());
           venta.SetidCategoria(RowCategoria);
           venta.SetidProducto(RowSeleccionado);
           ListaProductos.add(venta);
           ModeloVentas.addRow(new Object[]{ListaProductos.get(ListaProductos.size() - 1).getProducto(),ListaProductos.get(ListaProductos.size() - 1).getCantidad(),
           ListaProductos.get(ListaProductos.size() - 1).getDescripcion(),ListaProductos.get(ListaProductos.size() - 1).getTotal()});
           Total += venta.getTotal();
           
           //Desceleccionar todos los objetos
           Grupo1.clearSelection();
           ProductoSeleccionado = false;
           RowSeleccionado = 0;
           SelectProducto.setText("");
           txtCantidad.setText("");
           lblTotal.setText(Total+"");
           lblDescuento.setText(Descuento+"");
        }
        else 
             JOptionPane.showMessageDialog(this, "No hay nada seleccionado");
   }
   private void OcultarDescuentos(){
    lblDesMsg.setVisible(false);
    txtDescuento.setVisible(false);
    SepDes.setVisible(false);
   }
   private void VisibleDescuento(){
       lblDesMsg.setVisible(true);
       txtDescuento.setVisible(true);
       SepDes.setVisible(true);
   }
   
   //Metodo que carga los productos que pertenecen a distintas categorias
   private void CargarProductoCategorias(){
      
        ProductosCategoria.clear();
        ElementosCategoria c1 = new ElementosCategoria();
        c1.SetModelo(Insertar_producto.MostrarTela(ConexionBaseDatos, 1));
        ProductosCategoria.add(c1);
        ElementosCategoria c2 = new ElementosCategoria();
        ElementosCategoria c3 = new ElementosCategoria();
        ElementosCategoria c4 = new ElementosCategoria();
        ElementosCategoria c5 = new ElementosCategoria();
        ElementosCategoria c6 = new ElementosCategoria();
       
    
   }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo1 = new javax.swing.ButtonGroup();
        PopMenu = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlVentas = new javax.swing.JPanel();
        pnlContenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNitClient = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombreClient = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtDireccionClient = new javax.swing.JTextField();
        SelectProducto = new javax.swing.JLabel();
        btnDescuento = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableVentas = new javax.swing.JTable();
        RbYarda = new javax.swing.JRadioButton();
        RbCientos = new javax.swing.JRadioButton();
        RbMillar = new javax.swing.JRadioButton();
        RbUnidades = new javax.swing.JRadioButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        RbRollos = new javax.swing.JRadioButton();
        lblDescuento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTipos = new javax.swing.JLabel();
        SepDes = new javax.swing.JSeparator();
        txtDescuento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListadoTipos = new javax.swing.JList();
        lblDesMsg = new javax.swing.JLabel();
        pnlConsultas = new javax.swing.JPanel();

        Eliminar.setText("Eliminar Producto");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        PopMenu.add(Eliminar);

        Editar.setText("Editar Producto");
        PopMenu.add(Editar);

        setBackground(new java.awt.Color(36, 41, 46));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        pnlVentas.setBackground(new java.awt.Color(36, 41, 46));

        pnlContenedor.setBackground(new java.awt.Color(36, 41, 46));
        pnlContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos del Clinte:");
        pnlContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 16, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        pnlContenedor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        pnlContenedor.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 260, 10));

        txtNitClient.setBackground(new java.awt.Color(36, 41, 46));
        txtNitClient.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNitClient.setForeground(new java.awt.Color(255, 255, 255));
        txtNitClient.setAlignmentX(1.0F);
        txtNitClient.setAlignmentY(1.0F);
        txtNitClient.setBorder(null);
        pnlContenedor.add(txtNitClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 260, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Direccion:");
        pnlContenedor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));
        pnlContenedor.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 310, 10));

        txtNombreClient.setBackground(new java.awt.Color(36, 41, 46));
        txtNombreClient.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreClient.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreClient.setAlignmentX(1.0F);
        txtNombreClient.setAlignmentY(1.0F);
        txtNombreClient.setBorder(null);
        pnlContenedor.add(txtNombreClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 310, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nit:");
        pnlContenedor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, -1, -1));
        pnlContenedor.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 190, 10));
        pnlContenedor.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 310, 10));

        txtDireccionClient.setBackground(new java.awt.Color(36, 41, 46));
        txtDireccionClient.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDireccionClient.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionClient.setAlignmentX(1.0F);
        txtDireccionClient.setAlignmentY(1.0F);
        txtDireccionClient.setBorder(null);
        pnlContenedor.add(txtDireccionClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 310, 40));

        SelectProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SelectProducto.setForeground(new java.awt.Color(255, 255, 255));
        SelectProducto.setText(".");
        pnlContenedor.add(SelectProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 190, -1));

        btnDescuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Descuento.png"))); // NOI18N
        btnDescuento.setBorder(null);
        btnDescuento.setBorderPainted(false);
        btnDescuento.setContentAreaFilled(false);
        btnDescuento.setFocusPainted(false);
        btnDescuento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDescuento.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Descuento2.png"))); // NOI18N
        btnDescuento.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Descuento1.png"))); // NOI18N
        btnDescuento.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });
        pnlContenedor.add(btnDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 90, 90));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Aceptar.png"))); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Aceptar2.png"))); // NOI18N
        btnAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Aceptar1.png"))); // NOI18N
        btnAceptar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnlContenedor.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, -1, 90));

        TablaProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        TableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableVentas.setFocusable(false);
        TableVentas.getTableHeader().setReorderingAllowed(false);
        TableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableVentasMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(TableVentas);

        pnlContenedor.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 630, 440));

        RbYarda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RbYarda.setForeground(new java.awt.Color(255, 255, 255));
        RbYarda.setText("Yarda");
        pnlContenedor.add(RbYarda, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        RbCientos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RbCientos.setForeground(new java.awt.Color(255, 255, 255));
        RbCientos.setText("Cientos");
        pnlContenedor.add(RbCientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        RbMillar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RbMillar.setForeground(new java.awt.Color(255, 255, 255));
        RbMillar.setText("Millar");
        pnlContenedor.add(RbMillar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        RbUnidades.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RbUnidades.setForeground(new java.awt.Color(255, 255, 255));
        RbUnidades.setText("Unidades");
        pnlContenedor.add(RbUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        txtCantidad.setBackground(new java.awt.Color(36, 41, 46));
        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.setAlignmentX(1.0F);
        txtCantidad.setAlignmentY(1.0F);
        txtCantidad.setBorder(null);
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        pnlContenedor.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 180, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad:");
        pnlContenedor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vender.png"))); // NOI18N
        btnVender.setBorder(null);
        btnVender.setBorderPainted(false);
        btnVender.setContentAreaFilled(false);
        btnVender.setFocusPainted(false);
        btnVender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVender.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vender2.png"))); // NOI18N
        btnVender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vender1.png"))); // NOI18N
        btnVender.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        pnlContenedor.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 610, -1, 90));

        RbRollos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RbRollos.setForeground(new java.awt.Color(255, 255, 255));
        RbRollos.setText("Rollos");
        pnlContenedor.add(RbRollos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        lblDescuento.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(0, 136, 204));
        lblDescuento.setText(".");
        pnlContenedor.add(lblDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 650, 330, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Descuento:");
        pnlContenedor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 660, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total a pagar:");
        pnlContenedor.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 710, -1, -1));

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 136, 204));
        lblTotal.setText(".");
        pnlContenedor.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 700, 320, -1));

        lblTipos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTipos.setForeground(new java.awt.Color(255, 255, 255));
        lblTipos.setText("Tipos");
        pnlContenedor.add(lblTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));
        pnlContenedor.add(SepDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, 210, 10));

        txtDescuento.setBackground(new java.awt.Color(36, 41, 46));
        txtDescuento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(255, 255, 255));
        txtDescuento.setAlignmentX(1.0F);
        txtDescuento.setAlignmentY(1.0F);
        txtDescuento.setBorder(null);
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });
        pnlContenedor.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, 180, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Producto Seleccionado:");
        pnlContenedor.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        TablaProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaProductos.setFocusable(false);
        TablaProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaProductos);

        pnlContenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 350, 300));

        jScrollPane2.setViewportView(ListadoTipos);

        pnlContenedor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 551, 350, 180));

        lblDesMsg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDesMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblDesMsg.setText("Descuento:");
        pnlContenedor.add(lblDesMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, -1, -1));

        javax.swing.GroupLayout pnlVentasLayout = new javax.swing.GroupLayout(pnlVentas);
        pnlVentas.setLayout(pnlVentasLayout);
        pnlVentasLayout.setHorizontalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1418, Short.MAX_VALUE)
            .addGroup(pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1418, Short.MAX_VALUE))
        );
        pnlVentasLayout.setVerticalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
            .addGroup(pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", pnlVentas);

        pnlConsultas.setBackground(new java.awt.Color(36, 41, 46));

        javax.swing.GroupLayout pnlConsultasLayout = new javax.swing.GroupLayout(pnlConsultas);
        pnlConsultas.setLayout(pnlConsultasLayout);
        pnlConsultasLayout.setHorizontalGroup(
            pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1418, Short.MAX_VALUE)
        );
        pnlConsultasLayout.setVerticalGroup(
            pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consultas", pnlConsultas);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 800));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed
          //VisibleDescuento();
       for(int i =0; i < ListaProductos.size(); i++){
           System.out.println(ListaProductos.get(i).getProducto());
       }
    }//GEN-LAST:event_btnDescuentoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
     if(ProductoSeleccionado){ 
       // int tem = Integer.parseInt(ModeloProductos.getValueAt(RowSeleccionado, 1).toString());
      //  if(tem >= Integer.parseInt(txtCantidad.getText())){
       //  ModeloProductos.setValueAt(tem - Integer.parseInt(txtCantidad.getText()),RowSeleccionado, 1);
         AgregarVenta((short)(ModeloProductos.getColumnCount()-1)); 
       // }
      //  else 
          //  JOptionPane.showMessageDialog(this,"Ya no hay existencia");
     }
     else 
          JOptionPane.showMessageDialog(this,"Favor de seleccionar un producto");
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char capturar = evt.getKeyChar();
        if(!Character.isDigit(capturar)){
          evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ AgregarVenta((short)(ModeloProductos.getColumnCount()-1)); }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void TableVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableVentasMouseReleased
         if(evt.isPopupTrigger()){       
            PopMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_TableVentasMouseReleased

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
       ListaProductos.clear();     
       for(int i = 0; i < ModeloVentas.getRowCount(); i++){ ModeloVentas.removeRow(i); i--; }
       Total  = 0;
       lblTotal.setText(""+Total);
    }//GEN-LAST:event_btnVenderActionPerformed

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char capturar = evt.getKeyChar();
        if(!Character.isDigit(capturar)){
          evt.consume();
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        System.out.println("Eliminar Producto: idCategoria:"+ListaProductos.get(TableVentas.getSelectedRow()).getidCategoria()+" idProducto: "+ListaProductos.get(TableVentas.getSelectedRow()).getidProducto());
        ListaProductos.remove(TableVentas.getSelectedRow());
        ModeloVentas.removeRow(TableVentas.getSelectedRow());
    }//GEN-LAST:event_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JList ListadoTipos;
    private javax.swing.JPopupMenu PopMenu;
    private javax.swing.JRadioButton RbCientos;
    private javax.swing.JRadioButton RbMillar;
    private javax.swing.JRadioButton RbRollos;
    private javax.swing.JRadioButton RbUnidades;
    private javax.swing.JRadioButton RbYarda;
    private javax.swing.JLabel SelectProducto;
    private javax.swing.JSeparator SepDes;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTable TableVentas;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnDescuento;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDesMsg;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblTipos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlConsultas;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDireccionClient;
    private javax.swing.JTextField txtNitClient;
    private javax.swing.JTextField txtNombreClient;
    // End of variables declaration//GEN-END:variables
}
