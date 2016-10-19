/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.aulas.votaqr.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author munif
 */
public class QRCodeService {

    private final int TAMANHO = 500;

    public BufferedImage gera(String msg) {
        BufferedImage image = new BufferedImage(TAMANHO, TAMANHO, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, TAMANHO, TAMANHO);
        graphics.setColor(Color.BLACK);
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(msg, BarcodeFormat.QR_CODE, TAMANHO, TAMANHO);
            for (int i = 0; i < TAMANHO; i++) {
                for (int j = 0; j < TAMANHO; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            return image;

        } catch (WriterException ex) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        graphics.drawString("Problemas ao gerar imagem", 0, TAMANHO/2);
        return image;
    }
    
    
    public static void main(String args[]){
        try {
            BufferedImage gera = new QRCodeService().gera("http://www.munif.com.br");
            ImageIO.write(gera, "PNG",new File("/Users/munif/qrcode.png"));
        } catch (IOException ex) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
