/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

import java.awt.Color;
import java.awt.Graphics;

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
    
    
    /**
     * 
     * @param g 
     */
    public void paint(Graphics g) {
        
        g.drawRect(x-3, y-3, 6, 6);
        g.fillRect(this.x-3, this.y-3, 6, 6);
        
    }
    
    public void move(Cruce c) {
        this.x = c.getX();
        this.y = c.getY();
    }
}
