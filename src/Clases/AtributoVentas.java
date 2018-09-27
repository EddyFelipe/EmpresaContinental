/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Felipe
 */
public class AtributoVentas {
    
     private String Producto,Descripcion;
    private int Cantidad,IdCategoria,idProducto,idInsercion;
    private double  Total;


    public AtributoVentas() {
    }
    
    public void SetProducto(String producto){ Producto = producto; }
    public String getProducto(){ return Producto; }
    
    public void SetDescripcion(String descripcion){ Descripcion = descripcion; }
    public String getDescripcion(){ return Descripcion; }
    
    public void SetCantidad(int cantidad){ Cantidad = cantidad; }
    public int getCantidad(){ return Cantidad; }
    
    public void SetTotal(double total){ Total = total; }
    public double getTotal(){return Total; }
    
    public void SetidCategoria(int id){ IdCategoria = id; }
    public int getidCategoria(){return IdCategoria; }
    
    public void SetidProducto(int id){ idProducto = id; }
    public int getidProducto(){ return idProducto; }
    
    public void SetIdInsercion(int id){ idInsercion = id; }
    public int getIdInsercion(){ return idInsercion; }
    
}
