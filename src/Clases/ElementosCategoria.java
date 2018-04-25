package Clases;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class ElementosCategoria {
    
    private DefaultTableModel ListaProductos;
    private ArrayList<Integer> idProducto;
    public ElementosCategoria(){
        ListaProductos = new DefaultTableModel();
        idProducto = new ArrayList<>();
    }
    
    public void SetModelo(DefaultTableModel modelo){ ListaProductos = modelo; }
    public DefaultTableModel getModelo(){ return ListaProductos; }
    
    public void SetIdProducto(ArrayList<Integer> ids){ idProducto = ids; }
    public ArrayList getIdProducto(){ return idProducto; }
    
}
