/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author roberto
 */
public class Camion {
    
    private int x, y;
    
    public Camion (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
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
            mapa.camion.move(c);    
            mapa.paint(mapa.getGraphics());
            mapa.camion.paint(mapa.getGraphics());
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
