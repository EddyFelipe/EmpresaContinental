package Clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class ElementosCategoria {
    
    //private ArrayList<AtributoVentas> ListaProductos;
    private DefaultTableModel ListaProductos;
    public ElementosCategoria(){
        ListaProductos = new DefaultTableModel();
    }
    
    public void SetModelo(DefaultTableModel modelo){ ListaProductos = modelo; }
    public DefaultTableModel getModelo(){ return ListaProductos; }
    
    
}
