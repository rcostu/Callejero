package cartograph;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hui
 */
public class Spot extends Observable implements Observer{

    private Cruce location;
    private int cantidad;
    private String image;
    
    public Spot(Cruce c, int cantidad, String image) {
        this.location = c;
        this.cantidad = cantidad;
        this.image = image;       
    }
    
    public void enableSpot() {
        this.setChanged();
        this.notifyObservers(this);
    }

    public void paint(Graphics g) {
        ImageIcon im = new ImageIcon(this.getClass().getResource(image));
        ((Graphics2D) g).drawImage(im.getImage(), this.location.getX() - 15, this.location.getY() - 15, 40, 40, null);
    }

    public Cruce getLocation() {
        return this.location;
    }
    
    @Override
    public void update(Observable o, Object o1) {
        
    }
    
}
