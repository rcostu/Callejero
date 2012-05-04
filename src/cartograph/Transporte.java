/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartograph;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 * @author roberto
 */
public class Transporte extends Observable {
    
    private Cruce location;
    private String image;
    
    public Transporte (String image, Cruce location) {
        this.image = image;
        this.location = location;
    }
    
    public void paint(Graphics g) {
        ImageIcon im=new ImageIcon(this.getClass().getResource(this.image));
        ((Graphics2D)g).drawImage(im.getImage(), this.location.getX()-15, this.location.getY()-15,30,30, null);
    }
    
    public void move(Cruce c) {
        this.location = c;
    }
    
    public void drive(Mapa mapa) {
        for(final Cruce c : mapa.ruta.route) {
            this.move(c);    
            mapa.paint(mapa.getGraphics());
            
            // Inform observes
            this.setChanged();
            this.paint(mapa.getGraphics());
            this.notifyObservers(this);
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public Cruce getLocation(){
        return this.location;
    }
    
    public boolean arrives (Spot s){
        return s.equals(this.location);
    }
}
