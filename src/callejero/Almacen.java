package callejero;

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
public class Almacen {

    private int x;
    private int y;
    private int cantidad;

    public Almacen(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.cantidad = c;
    }

    public void paint(Graphics g) {
        ImageIcon im = new ImageIcon(this.getClass().getResource("../images/almacen.png"));
        ((Graphics2D) g).drawImage(im.getImage(), x - 15, y - 15, 40, 40, null);
    }
    
}
