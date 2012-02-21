/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author roberto
 */
public class Cruce {

    private int x1;
    private int y1;
    private int width;
    private int height;
    
    private final ArrayList<Cruce> vecinos = new ArrayList<Cruce>();
    
    public void addVecino(Cruce cruce) {
        vecinos.add(cruce);
    }

    public Cruce (int x1, int y1, int width, int height){
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(this.x1, this.y1, this.width, this.height);
        g.fillRect(this.x1, this.y1, this.width, this.height);
    }
}
