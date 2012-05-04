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
public class Spot implements Observer {

    private Cruce location;
    private int cantidad;
    private String image;

    public Spot(Cruce c, int cantidad, String image) {
        this.location = c;
        this.cantidad = cantidad;
        this.image = image;
    }

    public void paint(Graphics g) {
        ImageIcon im = new ImageIcon(this.getClass().getResource(image));
        ((Graphics2D) g).drawImage(im.getImage(), this.location.getX() - 15, this.location.getY() - 15, 40, 40, null);
    }

    @Override
    public void update(Observable o, Object o1) {
        Transporte transporte  = (Transporte)o;
        if (transporte.arrives(this))
            JOptionPane.showMessageDialog(null, "Desea alojarse aqui?");
    }
    
    @Override
    public boolean equals (Object o){
        Cruce c = (Cruce)o;
        return c.getX() == this.location.getX() && c.getY() == this.location.getY();
    }
    
}
