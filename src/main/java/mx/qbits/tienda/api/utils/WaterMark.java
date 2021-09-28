/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.utils
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      WaterMark
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:36:42
 */
package mx.qbits.tienda.api.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>WaterMark class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class WaterMark {
    private Logger logger = LoggerFactory.getLogger(WaterMark.class);

    private static final String RUTA="/Users/garellano/Desktop/pics/";
    private static WaterMark instance =null;

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new WaterMark().addWatermarkOnImage();
    }
    private WaterMark() {
    }
    /**
     * <p>Getter for the field <code>instance</code>.</p>
     *
     * @return a {@link mx.qbits.tienda.api.utils.WaterMark} object.
     */
    public static WaterMark getInstance() {
        if(instance==null) {
            instance = new WaterMark();
        }
        return instance;
    }
    /**
     * <p>addWatermarkOnImage.</p>
     */
    public void addWatermarkOnImage() {
        addWatermarkOnImage(RUTA, "out_ok.jpg", "logo.png", "out_ok.jpg");
    }
    /**
     * <p>addWatermarkOnImage.</p>
     *
     * @param path a {@link java.lang.String} object.
     * @param origFileName a {@link java.lang.String} object.
     * @param watermarkImageFileName a {@link java.lang.String} object.
     * @param newFileName a {@link java.lang.String} object.
     */
    public void addWatermarkOnImage(String path, String origFileName, String watermarkImageFileName, String newFileName) {
        if(!path.endsWith("/")) path = path + File.separator;
        File origFile           = new File(path + origFileName);
        File watermarkImageFile = new File(path + watermarkImageFileName);
        File newFile            = new File(path + newFileName);

        if(!origFile.exists()) {
            System.out.println("No existe: "+origFile.getPath());
            return;
        }
        if(!watermarkImageFile.exists()) {
            System.out.println("No existe: "+watermarkImageFile.getPath());
            return;
        }
//        if(!newFile.exists()) {
//            System.out.println("No existe: "+newFile.getPath());
//            return;
//        }
        addWatermarkOnImage(origFile, watermarkImageFile, newFile);
    }
    /**
     * <p>addWatermarkOnImage.</p>
     *
     * @param originalFile a {@link java.io.File} object.
     * @param watermarkImageFile a {@link java.io.File} object.
     * @param newFile a {@link java.io.File} object.
     */
    public void addWatermarkOnImage(File originalFile, File watermarkImageFile, File newFile) {
        ImageIcon watermarkImage = new ImageIcon(watermarkImageFile.getPath());
        BufferedImage watermarkBufferedImage = makeTransparent(watermarkImage.getImage(), watermarkImage.getIconWidth());

        ImageIcon original = new ImageIcon(originalFile.getPath());

        // create BufferedImage object of same width and height as of original image
        BufferedImage originalBufferedImage = new BufferedImage(original.getIconWidth(), original.getIconHeight(), BufferedImage.TYPE_INT_RGB);

        // create graphics object and add original image to it
        Graphics graphics = originalBufferedImage.getGraphics();
        graphics.drawImage(original.getImage(), 0, 0, null);

        /** /
        // set font for the watermark text
        graphics.setFont(new Font("Arial", Font.BOLD, 30));
        // unicode characters for (c) is \u00a9
        String watermarkText = "\u00a9 tienda";
        // add the watermark text
        graphics.drawString(watermarkText, 0, original.getIconHeight() / 2);
        /**/

        int wOrig = originalBufferedImage.getWidth();
        int hOrig = originalBufferedImage.getHeight();

        int impresionesH = (hOrig<=wOrig)?4:3;
        int impresionesV = (hOrig<=wOrig)?3:4;

        int cuadrosH=2*impresionesH+1;
        int cuadrosV=2*impresionesV+1;

        int minWater = (cuadrosH>cuadrosV)?cuadrosV:cuadrosH;

        int wWater = watermarkBufferedImage.getWidth();
        int hWater = watermarkBufferedImage.getHeight();

        int factor = wOrig/minWater;

        for(int y=1; y<cuadrosV; y=y+2) {
            for(int x=1; x<cuadrosH; x=x+2) {
                graphics.drawImage(watermarkBufferedImage,
                    (wOrig/cuadrosH)*x,
                    (hOrig/cuadrosV)*y,
                    factor,
                    hWater*factor/wWater,
                    null);
            }
        }
        graphics.dispose();

        try {
            ImageIO.write(originalBufferedImage, "jpg", newFile);
        } catch (IOException e) {
            logger.error(e.toString());
        }
        System.out.println(newFile.getPath() + " created successfully!");
    }

    /**
     * <p>makeTransparent.</p>
     *
     * @param originalImage a {@link java.awt.Image} object.
     * @param ancho a int.
     * @return a {@link java.awt.image.BufferedImage} object.
     */
    public BufferedImage makeTransparent(Image originalImage, int ancho) {
        double h = originalImage.getHeight(null);
        double w = originalImage.getWidth(null);
        double radio = h / w;
        int largo = (int) (ancho * radio);
        BufferedImage resizedImage = new BufferedImage(ancho, largo, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
        g.drawImage(originalImage, 0, 0, ancho, largo, null);
        g.dispose();
        return resizedImage;
    }

}
