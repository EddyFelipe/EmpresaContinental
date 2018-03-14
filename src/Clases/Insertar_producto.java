/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author carlo
 */
public class Insertar_producto {

     String sql= "INSERT INTO productos () values()";
    
    public void Insertar_tela(String tipo, int cantidad,String color,double precio_venya){
        
        PreparedStatement insertar;
        
    }
    
    public void Insertar_etiqueta(String tamaño, int cantidad,String marca,double precio_venta){
        
        PreparedStatement insertar;
        
    }
    
    public void insertar_carrito(int cantidad,String tamaño,String color,int numero,double preci_venta){
        
    }
    
    public void insertar_metales(String tipo,int cantidad,int medida,double precio_venta){
        
    }
    
    public void insertar_correa(int cantidad,String color,int numero,double precio_venta){
        
    }
    
    public void insertar_zipper(int numero,int cantidad,String color,int tamaño,double precio_venta){
        
    }
    
    public void insertar_hilo(int cantidad,String marca,String color,double precio_venta){
        
    }
    
    public void insertar_plastico(String tipo,int cantidad,int medida,double precio_venta){
        
    }
}
