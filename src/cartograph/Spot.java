package cartograph;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author hui
 */
public class Spot {

    private int x;
    private int y;
    private int cantidad;
    private String image;

    public Spot(int x, int y, int c, String image) {
        this.x = x;
        this.y = y;
        this.cantidad = c;
        this.image = image;
    }

    public void paint(Graphics g) {
        ImageIcon im = new ImageIcon(this.getClass().getResource(image));
        ((Graphics2D) g).drawImage(im.getImage(), x - 15, y - 15, 40, 40, null);
    }
    
}
