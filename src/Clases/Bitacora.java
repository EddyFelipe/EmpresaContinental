/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ismar
 */
public class Bitacora {

    private final String ruta = "bitacora.txt";
    private final String ruta2 = "contador.txt";

    public void crearArchivo() {

        File af = new File(ruta);
        if (af.isFile() && af.exists()) {
            System.out.println("EL ARCHIVO EXISTE");
        } else {
            try {
                FileWriter fw = new FileWriter(ruta, true);
                // BufferedWriter bw = new BufferedWriter(fw);
                //Escribimos en el fichero un String y un caracter 97 (a)
                // fw.write("\r\n" + "Esto es una prueba ");
                // fw.write("\r\n" + "dato2");
                // bw.newLine();
                //Cierro el stream
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Forms.Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void EscribirArchivo(String cadena) {
        try {
            FileWriter fw = new FileWriter(ruta, true);
            fw.write(cadena);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Forms.Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int numTransaccion() {
        int envio = 0;
        String linea = "";
        try {
            FileReader fr = new FileReader(ruta2);
            //Leemos el fichero y lo mostramos por pantalla
            int valor = fr.read();
            while (valor != -1) {
                linea = String.valueOf((char) valor);
                valor = fr.read();
            }
            //Cerramos el stream
            fr.close();
        } catch (IOException e) {
        }
        return Integer.parseInt(linea);
    }

    public String fecha() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.valueOf(dateFormat.format(date));
    }

    public String hora() {
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return String.valueOf(hourFormat.format(date));
    }
    public String User(){
        String usuario = System.getProperty("user.name");
        return usuario;
    }
     public void EscribirArchivoContador(String cadena) {
        try {
            FileWriter fw = new FileWriter(ruta2);
            fw.write(cadena);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Forms.Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
