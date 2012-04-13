/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartograph;


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author roberto
 */
public class Transporte {
    
    private int x, y;
    
    
    public void paint(Graphics g) {
        ImageIcon im=new ImageIcon(this.getClass().getResource("../images/camion.png"));
        ((Graphics2D)g).drawImage(im.getImage(), x-15, y-15,30,30, null);
    }
    
    public void move(Cruce c) {
        this.x = c.getX();
        this.y = c.getY();
    }
    
    public void drive(Mapa mapa) {
        for(final Cruce c : mapa.ruta.route) {
            mapa.transporte.move(c);    
            mapa.paint(mapa.getGraphics());
            mapa.transporte.paint(mapa.getGraphics());
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
