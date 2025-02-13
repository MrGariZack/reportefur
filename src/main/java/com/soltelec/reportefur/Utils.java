package com.soltelec.reportefur;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Utils {
    public static String redondeoNorma(Float valor){
        DecimalFormat df = new DecimalFormat("#0"); // Formato de 2 decimales
        if (valor<10) df = new DecimalFormat("#0.00"); // Formato de 2 decimales
        if (valor<100) df = new DecimalFormat("#0.0"); // Formato de 2 decimales
        return df.format(valor);
    }


    public static BufferedImage convertirAImagen(byte[] imagenBytes) {
        if (imagenBytes == null || imagenBytes.length == 0) {
            return null;
        }
        try {
            return ImageIO.read(new ByteArrayInputStream(imagenBytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        
    
    }
}

}
