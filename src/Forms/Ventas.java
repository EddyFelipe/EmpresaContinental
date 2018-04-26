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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Ventas extends javax.swing.JPanel {
    Conexion con = new Conexion();
      Connection cn= con.ConectarBaseDatos();
      DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form Ventas
     */
    //DECLARACION DE VARIABLES 
    private String ColumnaVentas[] = {"Producto","Cantidad","Descripcion","Total"};
    private DefaultTableModel ModeloVentas,ModeloProductos;
    private Connection ConexionBaseDatos;
    private boolean ProductoSeleccionado,HayDescuento;
    private ArrayList<Clases.AtributoVentas> ListaProductos;
    private int RowSeleccionado,RowCategoria;
    private double Total,Descuento = 0; 
    private DefaultListModel ModeloLista;
    private ArrayList<ElementosCategoria> ProductosCategoria;
    public Ventas() {
        initComponents();
        mostrar_nombres_productos();
      /* Grupo1.add(RbYarda);
       Grupo1.add(RbUnidades);
       Grupo1.add(RbMillar);
       Grupo1.add(RbCientos);
       Grupo1.add(RbRollos);*/
       
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
       HayDescuento = true;
       ListaProductos = new ArrayList<>();
       ProductosCategoria = new ArrayList<>();
       
       //Llamada a metodos
       TablaProductos();  
       ComponentesInit();
       //MetodoRadioButon();
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
   /* private void MetodoRadioButon(){
       RbCientos.setActionCommand("Cientos");
       RbMillar.setActionCommand("Millar");
       RbRollos.setActionCommand("Rollos");
       RbUnidades.setActionCommand("Unidades");
       RbYarda.setActionCommand("Yarda");
  }*/
    //METODO para agregar una venta
     private void AgregarVenta(short col){
       
    if(ProductoSeleccionado && !txtCantidad.getText().equals("")){
           Clases.AtributoVentas venta = new Clases.AtributoVentas();
           //Seteando los los datos de la venta
           venta.SetProducto(SelectProducto.getText());
           venta.SetDescripcion("Unidades");
           venta.SetCantidad(Integer.parseInt(txtCantidad.getText()));
           venta.SetTotal(Double.parseDouble(ModeloProductos.getValueAt(RowSeleccionado, col).toString())*venta.getCantidad());
           venta.SetidCategoria(RowCategoria);
           venta.SetidProducto(RowSeleccionado);
        
           //Asigna el id del producto, el que tiene en la base de datos
          ArrayList<Integer> ar =  ProductosCategoria.get(RowCategoria).getIdProducto();
          venta.SetIdInsercion(ar.get(RowSeleccionado));
           
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
        c1.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c1);
        ElementosCategoria c2 = new ElementosCategoria();
        c2.SetModelo(Insertar_producto.MostrarEtiqueta(ConexionBaseDatos, 2));
        c2.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c2);
        ElementosCategoria c3 = new ElementosCategoria();
        c3.SetModelo(Insertar_producto.MostrarCarrito(ConexionBaseDatos, 3));
        c3.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c3);
        ElementosCategoria c4 = new ElementosCategoria();
        c4.SetModelo(Insertar_producto.MostrarMetalesyPlastico(ConexionBaseDatos, 4));
        c4.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c4);
        ElementosCategoria c5 = new ElementosCategoria();
        c5.SetModelo(Insertar_producto.MostrarCorrea(ConexionBaseDatos, 5));
        c5.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c5);
        ElementosCategoria c6 = new ElementosCategoria();
        c6.SetModelo(Insertar_producto.MostrarZipper(ConexionBaseDatos, 6));
        c6.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c6);
        ElementosCategoria c7 = new ElementosCategoria();
        c7.SetModelo(Insertar_producto.MostrarHilo(ConexionBaseDatos, 7));
        c7.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c7);
        ElementosCategoria c8 = new ElementosCategoria();
        c8.SetModelo(Insertar_producto.MostrarMetalesyPlastico(ConexionBaseDatos, 8));
        c8.SetIdProducto(Insertar_producto.getAraayId());
        ProductosCategoria.add(c8); 
   }
    private void VerificarExistencia(){
    if(ProductoSeleccionado){ 
        int tem = Integer.parseInt(ModeloProductos.getValueAt(RowSeleccionado, ModeloProductos.getColumnCount() - 2).toString());
        if(tem >= Integer.parseInt(txtCantidad.getText()) && tem != 0){
         ModeloProductos.setValueAt(tem - Integer.parseInt(txtCantidad.getText()),RowSeleccionado, ModeloProductos.getColumnCount() - 2);
         AgregarVenta((short)(ModeloProductos.getColumnCount()-1)); 
        }
       else 
          JOptionPane.showMessageDialog(this,"Ya no hay existencia");
     }
     else 
          JOptionPane.showMessageDialog(this,"Favor de seleccionar un producto");
   }
      private void AgregarDescuento(){
         if(HayDescuento && ListaProductos.size() != 0){
          VisibleDescuento();
          HayDescuento = false;
        }
        else if(ListaProductos.size() != 0 && !txtDescuento.getText().equals("")){
           
            Total += Descuento;
            Descuento = Double.parseDouble(txtDescuento.getText());
             
            if(Descuento < Total){
             HayDescuento = true;
             Total -= Descuento;
             lblTotal.setText(Total+"");
             lblDescuento.setText(Descuento+"");
             OcultarDescuentos(); 
            }
            else{
                Descuento =  0;
                JOptionPane.showMessageDialog(this,"La cantidad ingresada supera el total");
            }     
        }
        else
          JOptionPane.showMessageDialog(this, "Factura Vacia"); 
    }
  
   public void mostrar_nombres_productos(){
        
         
   
         String sql ="SELECT categoria FROM categoria";
         Statement st ;
         ResultSet rs;
         
          try {
              st= cn.createStatement();
              rs = st.executeQuery(sql);
              while (rs.next()) {
                  
                  jComboBox1.addItem(rs.getString(1));
                 
                  
              } } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
   
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
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaproducto = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        Eliminar.setText("Eliminar Producto");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        PopMenu.add(Eliminar);

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
        pnlContenedor.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 190, 10));
        pnlContenedor.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 310, 10));

        txtDireccionClient.setBackground(new java.awt.Color(36, 41, 46));
        txtDireccionClient.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDireccionClient.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionClient.setAlignmentX(1.0F);
        txtDireccionClient.setAlignmentY(1.0F);
        txtDireccionClient.setBorder(null);
        pnlContenedor.add(txtDireccionClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 310, 40));

        SelectProducto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        SelectProducto.setForeground(new java.awt.Color(0, 136, 204));
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
        pnlContenedor.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, 90));

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
        pnlContenedor.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 180, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad:");
        pnlContenedor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));

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
        pnlConsultas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        tablaproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaproducto);

        pnlConsultas.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 980, 260));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pnlConsultas.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 180, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ver.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ver2.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ver1.png"))); // NOI18N
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlConsultas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categorias");
        pnlConsultas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jTabbedPane1.addTab("Consultas", pnlConsultas);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 800));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed
       AgregarDescuento();
    }//GEN-LAST:event_btnDescuentoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
      VerificarExistencia();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char capturar = evt.getKeyChar();
        if(!Character.isDigit(capturar)){
          evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ VerificarExistencia(); }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void TableVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableVentasMouseReleased
         if(evt.isPopupTrigger()){       
            PopMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_TableVentasMouseReleased

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
     if (ListaProductos.size() != 0) {
           if(HayDescuento){
            if (!txtNombreClient.getText().equals("")) {
                String Direccion = txtDireccionClient.getText().equals("")?"Ciudad":txtDireccionClient.getText();
                String nit = txtNitClient.getText().equals("")?"C/F":txtNitClient.getText();
                int idCliente = Clases.Ventas.InsertarCliente(txtNombreClient.getText(), Direccion, nit, ConexionBaseDatos);                  
                int idFactura = Clases.Ventas.InsertarFactura(Total,Descuento, idCliente, 1, ConexionBaseDatos);
             
                       if (Clases.Ventas.InsertarProducto(idFactura, ConexionBaseDatos, ListaProductos)) {
                            ListaProductos.clear();
                            for (int i = 0; i < ModeloVentas.getRowCount(); i++) {
                                ModeloVentas.removeRow(i);
                                i--;
                            }
                            CargarProductoCategorias();
                            Total = 0;
                            Descuento = 0;
                            lblTotal.setText("" + Total);
                            lblDescuento.setText(""+Descuento);
                            txtNombreClient.setText("");
                            txtDireccionClient.setText("");
                            txtNitClient.setText("");
                        }
                        else
                        JOptionPane.showMessageDialog(this, "La venta no se realizo con exito");
                  
            }
            else
                JOptionPane.showMessageDialog(this, "Favor de Ingresar un Cliente");
           }
           else
                JOptionPane.showMessageDialog(this, "Favor de Terminar de ingresar el descuneto");
        } else {
            JOptionPane.showMessageDialog(this, "Factura Vacia");
        }
    }//GEN-LAST:event_btnVenderActionPerformed

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER && !txtDescuento.getText().equals("")){ AgregarDescuento(); }
    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char capturar = evt.getKeyChar();
        if(!Character.isDigit(capturar)){
          evt.consume();
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        double temporal = Double.parseDouble(ModeloVentas.getValueAt(TableVentas.getSelectedRow(), TableVentas.getColumnCount() - 1).toString());
        if(Total >= temporal){
            
             
             //Actualiza el producto
            switch (ListaProductos.get(TableVentas.getSelectedRow()).getidCategoria()) {
                case 0:
                    ProductosCategoria.get(0).SetModelo(Insertar_producto.MostrarTela(ConexionBaseDatos, 1));
                    if (0 == RowCategoria) {
                        ModeloProductos = ProductosCategoria.get(0).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
                case 1:
                    ProductosCategoria.get(1).SetModelo(Insertar_producto.MostrarEtiqueta(ConexionBaseDatos, 2));
                    if (1 == RowCategoria) {
                         ModeloProductos = ProductosCategoria.get(1).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
                case 2:
                    ProductosCategoria.get(2).SetModelo(Insertar_producto.MostrarCarrito(ConexionBaseDatos, 3));
                    if (2 == RowCategoria) {
                        ModeloProductos = ProductosCategoria.get(2).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
                case 3:
                    ProductosCategoria.get(3).SetModelo(Insertar_producto.MostrarMetalesyPlastico(ConexionBaseDatos, 4));
                    if (3 == RowCategoria) {
                       ModeloProductos = ProductosCategoria.get(3).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
                case 4:
                    ProductosCategoria.get(4).SetModelo(Insertar_producto.MostrarCorrea(ConexionBaseDatos, 5));
                    if (4 == RowCategoria) {
                         ModeloProductos = ProductosCategoria.get(4).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
                case 5:
                    ProductosCategoria.get(5).SetModelo(Insertar_producto.MostrarZipper(ConexionBaseDatos, 6));
                    if (5 == RowCategoria) {
                        ModeloProductos = ProductosCategoria.get(5).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
                case 6:
                    ProductosCategoria.get(6).SetModelo(Insertar_producto.MostrarHilo(ConexionBaseDatos, 7));
                    if (6 == RowCategoria) {
                        ModeloProductos = ProductosCategoria.get(6).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
                case 7:
                    ProductosCategoria.get(7).SetModelo(Insertar_producto.MostrarMetalesyPlastico(ConexionBaseDatos, 8));
                    if (7 == RowCategoria) {
                         ModeloProductos = ProductosCategoria.get(7).getModelo();
                        TablaProductos.setModel(ModeloProductos);
                    }
                    break;
            }
            Total -= temporal;

            lblTotal.setText(Total + "");
            ListaProductos.remove(TableVentas.getSelectedRow());
            ModeloVentas.removeRow(TableVentas.getSelectedRow());
        }
        else
            JOptionPane.showMessageDialog(this, "No puede quedar total a pagar a un saldo negativo");
    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         switch (jComboBox1.getSelectedIndex()) {
              case 0:
                  modelo.setColumnCount(0);
                  modelo.setRowCount(0);
                  mostrar_tela();
                  break;
              case 1:
                  
                  modelo.setColumnCount(0);
                  modelo.setRowCount(0);
                  mostrar_etiqueta();
                  break;
              case 2:
                   modelo.setColumnCount(0);
                  modelo.setRowCount(0);
                  mostrar_carrito();
                  break;
              case 3:
                  modelo.setColumnCount(0);
                  modelo.setRowCount(0);
                  mostrar_metales();
                  break;
              case 4:
                  modelo.setColumnCount(0);
                   modelo.setRowCount(0);
                   mostrar_correa();
                  break;
              case 5:
                   modelo.setColumnCount(0);
                  modelo.setRowCount(0);
                 mostrar_zipper();
                  break;
              case 6:
                  modelo.setColumnCount(0);
                  modelo.setRowCount(0);
                 mostrar_hilo();
                  break;
              case 7:
                  modelo.setColumnCount(0);
                  modelo.setRowCount(0);
                    mostrar_plastico();
                  break;
              default:
                  break;
          }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    
    public void mostrar_tela(){
        
       
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Yardas");
        modelo.addColumn("Color");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[7];
        Statement st;
          try {
            String cat=String.valueOf(jComboBox1.getSelectedItem());
            int id_categoria=id_categoria(cat);
            st=cn.createStatement();
            ResultSet rs=st.executeQuery("SELECT id_producto,tipo,cantidad,yardaje,color,precio_venta,categoria_id FROM producto WHERE categoria_id='"+id_categoria+"' AND visible='"+1+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(7);
            datos[2]= rs.getString(2);
            datos[3]= rs.getString(3);
            datos[4]= rs.getString(4);
            datos[5]= rs.getString(5);
            datos[6]= rs.getString(6);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
    
    }

    public void  mostrar_etiqueta(){
        
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Marca");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[6];
        Statement st;
          try {
               String cat=String.valueOf(jComboBox1.getSelectedItem());
              int id_categoria=id_categoria(cat);
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_producto,categoria_id,cantidad,marca,tamaño,precio_venta FROM producto WHERE categoria_id='"+id_categoria+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
    public void mostrar_carrito(){
        
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Color");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Numero");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[7];
        Statement st;
          try {
               String cat=String.valueOf(jComboBox1.getSelectedItem());
              int id_categoria=id_categoria(cat);
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_producto,categoria_id,cantidad,color,tamaño,numero,precio_venta FROM producto WHERE categoria_id='"+id_categoria+"' AND visible='"+1+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            datos[6]= rs.getString(7);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
    public void mostrar_metales(){
        
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Medida");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[6];
        Statement st;
          try {
              String cat=String.valueOf(jComboBox1.getSelectedItem());
              int id_categoria=id_categoria(cat);
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_producto,categoria_id,tipo,cantidad,medida,precio_venta FROM producto WHERE categoria_id='"+id_categoria+"' AND visible='"+1+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
    public void mostrar_correa(){
        
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Color");
        modelo.addColumn("Numero");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[6];
        Statement st;
          try {
               String cat=String.valueOf(jComboBox1.getSelectedItem());
              int id_categoria=id_categoria(cat);
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_producto,categoria_id,cantidad,color,numero,precio_venta FROM producto WHERE categoria_id='"+id_categoria+"' AND visible='"+1+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
     
    public void mostrar_zipper(){
        
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Color");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Numero");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[7];
        Statement st;
          try {
               String cat=String.valueOf(jComboBox1.getSelectedItem());
              int id_categoria=id_categoria(cat);
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_producto,categoria_id,cantidad,color,tamaño,numero,precio_venta FROM producto WHERE categoria_id='"+id_categoria+"' AND visible='"+1+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            datos[6]= rs.getString(7);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void mostrar_hilo(){
        
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Color");
        modelo.addColumn("Marca");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[6];
        Statement st;
          try {
              String cat=String.valueOf(jComboBox1.getSelectedItem());
              int id_categoria=id_categoria(cat);
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_producto,categoria_id,cantidad,color,marca,precio_venta FROM producto WHERE categoria_id='"+id_categoria+"' AND visible='"+1+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
     
    public void mostrar_plastico(){
        
        modelo.addColumn("ID");
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Medida");
        modelo.addColumn("Precio");
        
        tablaproducto.setModel(modelo);
        
        String[] datos = new String[6];
        Statement st;
          try {
              String cat=String.valueOf(jComboBox1.getSelectedItem());
              int id_categoria=id_categoria(cat);
              st=cn.createStatement();
              ResultSet rs=st.executeQuery("SELECT id_producto,categoria_id,tipo,cantidad,medida,precio_venta FROM producto WHERE categoria_id='"+id_categoria+"' AND visible='"+1+"'");
              
        while (rs.next()) {
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            datos[3]= rs.getString(4);
            datos[4]= rs.getString(5);
            datos[5]= rs.getString(6);
            modelo.addRow(datos);
        }
              
          } catch (SQLException ex) {
              Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JList ListadoTipos;
    private javax.swing.JPopupMenu PopMenu;
    private javax.swing.JLabel SelectProducto;
    private javax.swing.JSeparator SepDes;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTable TableVentas;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnDescuento;
    private javax.swing.JButton btnVender;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
    private javax.swing.JTable tablaproducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDireccionClient;
    private javax.swing.JTextField txtNitClient;
    private javax.swing.JTextField txtNombreClient;
    // End of variables declaration//GEN-END:variables
}
